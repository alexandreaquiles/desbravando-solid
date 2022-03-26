package cotuba.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.*;

@RestController
public class GeracaoDeLivrosController {

  private static final String USER_HOME = System.getProperty("user.home");

  @GetMapping(value = "/livros/{id}/pdf", produces = "application/pdf")
  public byte[] geraPDF(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
    return ebookParaOFormato("pdf", response);
  }

  @GetMapping(value = "/livros/{id}/epub", produces = "application/epub+zip")
  public byte[] geraEPUB(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
    return ebookParaOFormato("epub", response);
  }

  private byte[] ebookParaOFormato(String formato, HttpServletResponse response) throws IOException {
    response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=book."+formato);
    Path ebook = Paths.get(USER_HOME, "Desktop/book."+formato);
    return Files.readAllBytes(ebook);
  }

}