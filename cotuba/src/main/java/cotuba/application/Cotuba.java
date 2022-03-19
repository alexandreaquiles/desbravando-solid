package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTML;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

  public void executa(ParametrosCotuba parametros) {

    String formato = parametros.getFormato();
    Path diretorioDosMD = parametros.getDiretorioDosMD();
    Path arquivoDeSaida = parametros.getArquivoDeSaida();

    RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
    List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

    Ebook ebook = new Ebook();
    ebook.setFormato(formato);
    ebook.setArquivoDeSaida(arquivoDeSaida);
    ebook.setCapitulos(capitulos);

    GeradorEbook gerador = GeradorEbook.cria(formato);
    gerador.gera(ebook);

  }

}
