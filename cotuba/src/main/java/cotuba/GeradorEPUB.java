package cotuba;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

public class GeradorEPUB {

  public void gera(Path diretorioDosMD, Path arquivoDeSaida) {

    var epub = new Book();

    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
    try (Stream<Path> arquivosMD = Files.list(diretorioDosMD)) {
      arquivosMD
          .filter(matcher::matches)
          .sorted()
          .forEach(arquivoMD -> {
            Parser parser = Parser.builder().build();
            Node document = null;
            try {
              document = parser.parseReader(Files.newBufferedReader(arquivoMD));
              document.accept(new AbstractVisitor() {
                @Override
                public void visit(Heading heading) {
                  if (heading.getLevel() == 1) {
                    // capítulo
                    String tituloDoCapitulo = ((Text) heading.getFirstChild()).getLiteral();
                    // TODO: usar título do capítulo
                  } else if (heading.getLevel() == 2) {
                    // seção
                  } else if (heading.getLevel() == 3) {
                    // título
                  }
                }

              });
            } catch (Exception ex) {
              throw new IllegalStateException("Erro ao fazer parse do arquivo " + arquivoMD, ex);
            }

            try {
              HtmlRenderer renderer = HtmlRenderer.builder().build();
              String html = renderer.render(document);

              // TODO: usar título do capítulo
              epub.addSection("Capítulo", new Resource(html.getBytes(), MediatypeService.XHTML));

            } catch (Exception ex) {
              throw new IllegalStateException("Erro ao renderizar para HTML o arquivo " + arquivoMD, ex);
            }
          });

    } catch (IOException ex) {
      throw new IllegalStateException("Erro tentando encontrar arquivos .md em " + diretorioDosMD.toAbsolutePath(), ex);
    }

    var epubWriter = new EpubWriter();

    try {
      epubWriter.write(epub, Files.newOutputStream(arquivoDeSaida));
    } catch (IOException ex) {
      throw new IllegalStateException("Erro ao criar arquivo EPUB: " + arquivoDeSaida.toAbsolutePath(), ex);
    }

  }

}
