package cotuba.epub;

import cotuba.domain.FormatoEbook;
import cotuba.plugin.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorEPUB implements GeradorEbook {

  @Override
  public FormatoEbook formato() {
    return FormatoEbook.EPUB;
  }

  @Override
  public void gera(Ebook ebook) {

    Path arquivoDeSaida = ebook.arquivoDeSaida();

    var epub = new Book();

    for (Capitulo capitulo : ebook.capitulos()) {

      String html = capitulo.conteudoHTML();

      epub.addSection(capitulo.titulo(),
          new Resource(html.getBytes(), MediatypeService.XHTML));

    }

    var epubWriter = new EpubWriter();

    try {
      epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
    } catch (IOException ex) {
      throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
    }

  }

}