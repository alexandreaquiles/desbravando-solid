package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

  public void executa(ParametrosCotuba parametros) {

    String formato = parametros.getFormato();
    Path diretorioDosMD = parametros.getDiretorioDosMD();
    Path arquivoDeSaida = parametros.getArquivoDeSaida();

    RenderizadorMDParaHTML renderizador = RenderizadorMDParaHTML.cria();
    List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

    Ebook ebook = new Ebook();
    ebook.setFormato(formato);
    ebook.setArquivoDeSaida(arquivoDeSaida);
    ebook.setCapitulos(capitulos);

    GeradorEbook gerador;

    if ("pdf".equals(formato)) {

      gerador = new GeradorPDF();

    } else if ("epub".equals(formato)) {

      gerador = new GeradorEPUB();

    } else {

      throw new IllegalArgumentException("Formato do ebook inválido: " + formato);

    }

    gerador.gera(ebook);

  }

}
