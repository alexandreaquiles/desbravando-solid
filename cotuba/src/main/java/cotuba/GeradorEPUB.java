package cotuba;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorEPUB {

  public void gera(Path diretorioDosMD, Path arquivoDeSaida) {

    var epub = new Book();

    // TODO: usar título do capítulo
    epub.addSection("Capítulo",
        new Resource(html.getBytes(), MediatypeService.XHTML)); // error: cannot find symbol

    var epubWriter = new EpubWriter();

    try {
      epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
    } catch (IOException ex) {
      throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
    }

  }

}