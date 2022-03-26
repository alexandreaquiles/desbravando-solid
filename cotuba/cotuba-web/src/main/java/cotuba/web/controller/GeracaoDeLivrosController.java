package cotuba.web.controller;

import cotuba.domain.FormatoEbook;
import cotuba.web.application.GeracaoDeLivros;
import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;
import cotuba.web.repository.RepositorioDeCapitulos;
import cotuba.web.repository.RepositorioDeLivros;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
public class GeracaoDeLivrosController {

  private final RepositorioDeLivros repositorioDeLivros;
  private final RepositorioDeCapitulos repositorioDeCapitulos;
  private final GeracaoDeLivros geracao;

  public GeracaoDeLivrosController(RepositorioDeLivros repositorioDeLivros,
                                   RepositorioDeCapitulos repositorioDeCapitulos,
                                   GeracaoDeLivros geracao) {
    this.repositorioDeLivros = repositorioDeLivros;
    this.repositorioDeCapitulos = repositorioDeCapitulos;
    this.geracao = geracao;
  }

  @GetMapping(value = "/livros/{id}/pdf", produces = "application/pdf")
  public byte[] geraPDF(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
    return ebookParaOFormato(FormatoEbook.PDF, response, id);
  }

  @GetMapping(value = "/livros/{id}/epub", produces = "application/epub+zip")
  public byte[] geraEPUB(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
    return ebookParaOFormato(FormatoEbook.EPUB, response, id);
  }

  private byte[] ebookParaOFormato(FormatoEbook formato, HttpServletResponse response, Long idLivro) throws IOException {
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=book." + formato.name().toLowerCase());

    Livro livro = repositorioDeLivros.findById(idLivro)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    List<Capitulo> capitulos = repositorioDeCapitulos.findAllByLivroOrderByOrdem(livro);
    Path ebook = geracao.geraLivro(capitulos, formato);

    return Files.readAllBytes(ebook);
  }

}