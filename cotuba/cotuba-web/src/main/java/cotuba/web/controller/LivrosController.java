package cotuba.web.controller;

import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;
import cotuba.web.repository.RepositorioDeCapitulos;
import cotuba.web.repository.RepositorioDeLivros;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class LivrosController {

  private final RepositorioDeLivros repositorioDeLivros;
  private final RepositorioDeCapitulos repositorioDeCapitulos;


  public LivrosController(RepositorioDeLivros repositorioDeLivros, RepositorioDeCapitulos repositorioDeCapitulos) {
    this.repositorioDeLivros = repositorioDeLivros;
    this.repositorioDeCapitulos = repositorioDeCapitulos;
  }

  @GetMapping("/")
  public String lista(Model model) {
    model.addAttribute("livros", repositorioDeLivros.findAll());
    return "livros/index";
  }

  @GetMapping("/livros/{id}")
  public String lista(@PathVariable("id") Long id, Model model) {
    Livro livro = repositorioDeLivros.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    List<Capitulo> capitulos = repositorioDeCapitulos.findAllByLivroOrderByOrdem(livro);
    model.addAttribute("livro", livro);
    model.addAttribute("capitulos", capitulos);
    return "livros/detalhe";
  }

}
