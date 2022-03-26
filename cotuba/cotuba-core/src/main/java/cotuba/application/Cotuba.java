package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.domain.FormatoEbook;
import cotuba.md.RenderizadorMDParaHTML;
import cotuba.plugin.AoFinalizarGeracao;
import cotuba.plugin.GeradorEbook;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

  public void executa(ParametrosCotuba parametros) {

    FormatoEbook formato = parametros.getFormato();
    RepositorioDeMDs repositorioDeMDs = parametros.getRepositorioDeMDs();
    Path arquivoDeSaida = parametros.getArquivoDeSaida();

    RenderizadorMDParaHTML renderizador = new RenderizadorMDParaHTML();
    List<Capitulo> capitulos = renderizador.renderiza(repositorioDeMDs);

    Ebook ebook = new Ebook(formato, arquivoDeSaida, capitulos);

    GeradorEbook gerador = GeradorEbook.cria(formato);
    gerador.gera(ebook);

    AoFinalizarGeracao.gerou(ebook);

  }

}
