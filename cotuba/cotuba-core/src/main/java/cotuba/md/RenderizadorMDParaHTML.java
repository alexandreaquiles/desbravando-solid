package cotuba.md;

import cotuba.application.RepositorioDeMDs;
import cotuba.domain.Capitulo;
import cotuba.domain.builder.CapituloBuilder;
import cotuba.plugin.AoRenderizarHTML;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.List;

public class RenderizadorMDParaHTML {

  public List<Capitulo> renderiza(RepositorioDeMDs repositorioDeMDs) {
    return repositorioDeMDs.obtemMDsDosCapitulos().stream()
        .map(conteudoMD -> {
          CapituloBuilder capituloBuilder = new CapituloBuilder();
          Node document = parseDoMD(conteudoMD, capituloBuilder);
          renderizaParaHTML(capituloBuilder, document);
          return capituloBuilder.constroi();
        }).toList();
  }

  private Node parseDoMD(String conteudoMD, CapituloBuilder capituloBuilder) {
    Parser parser = Parser.builder().build();
    Node document;
    try {
      document = parser.parse(conteudoMD);
      document.accept(new AbstractVisitor() {
        @Override
        public void visit(Heading heading) {
          if (heading.getLevel() == 1) {
            // capítulo
            String tituloDoCapitulo = ((Text) heading.getFirstChild()).getLiteral();
            capituloBuilder.comTitulo(tituloDoCapitulo);

          } else if (heading.getLevel() == 2) {
            // seção
          } else if (heading.getLevel() == 3) {
            // título
          }
        }

      });

      return document;

    } catch (Exception ex) {
      throw new IllegalStateException("Erro ao fazer parse de MD", ex);
    }
  }

  private void renderizaParaHTML(CapituloBuilder capituloBuilder, Node document) {

    try {
      HtmlRenderer renderer = HtmlRenderer.builder().build();
      String html = renderer.render(document);

      String htmlModificado = AoRenderizarHTML.renderizou(html);
      capituloBuilder.comConteudoHTML(htmlModificado);

    } catch (Exception ex) {
      throw new IllegalStateException("Erro ao renderizar MD para HTML", ex);
    }

  }

}
