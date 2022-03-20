package cotuba.web.controller;

import cotuba.web.controller.form.CapituloForm;
import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;
import cotuba.web.repository.RepositorioDeCapitulos;
import cotuba.web.repository.RepositorioDeLivros;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class CapitulosController {

  private final RepositorioDeLivros repositorioDeLivros;
  private final RepositorioDeCapitulos repositorioDeCapitulos;

  public CapitulosController(RepositorioDeLivros repositorioDeLivros, RepositorioDeCapitulos repositorioDeCapitulos) {
    this.repositorioDeLivros = repositorioDeLivros;
    this.repositorioDeCapitulos = repositorioDeCapitulos;
  }

  @GetMapping("/livros/{livroId}/capitulos/{capituloId}")
  public String lista(@PathVariable("livroId") Long livroId, @PathVariable("capituloId") Long capituloId, Model model) {
    Livro livro = repositorioDeLivros.findById(livroId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    Capitulo capitulo = repositorioDeCapitulos.findById(capituloId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    model.addAttribute("livro", livro);
    model.addAttribute("capitulo", capitulo);

    return "capitulos/detalhe";
  }

  @PostMapping("/livros/{livroId}/capitulos/{capituloId}")
  public String lista(@PathVariable("livroId") Long livroId, @PathVariable("capituloId") Long capituloId, CapituloForm capituloForm) {
    Livro livro = repositorioDeLivros.findById(livroId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Capitulo capitulo = capituloForm.toEntity(capituloId, livro);
    repositorioDeCapitulos.save(capitulo);
    return "redirect:/livros/" + livroId;
  }

}
