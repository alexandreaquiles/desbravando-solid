package cotuba.application;

import java.nio.file.Path;
import java.util.List;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEPUB;
import cotuba.md.RenderizadorMDParaHTML;
import cotuba.pdf.GeradorPDF;

/**
 * Esta classe é um caso de uso. A sua função é orquestar a execução das demais
 * classes Modelo, para que a saída esperada seja atingida através dos dados
 * recebidos.
 * 
 * Dentro da arquitetura MVC, ela se encaixaria dentro de M (Model), visto que
 * não apresenta componentes de UI e não realiza quaisquer interações com o V
 * (View).
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com)
 *
 */
public class Cotuba {

	public void executa(Path diretorioDosMD, String formato, Path arquivoDeSaida) {
		var renderizador = new RenderizadorMDParaHTML();
		List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

		Ebook ebook = new Ebook();
		ebook.setFormato(formato);
		ebook.setArquivoDeSaida(arquivoDeSaida);
		ebook.setCapitulos(capitulos);

		if ("pdf".equals(formato)) {
			var geradorPDF = new GeradorPDF();
			geradorPDF.gera(ebook);

		} else if ("epub".equals(formato)) {
			var geradorEPUB = new GeradorEPUB();
			geradorEPUB.gera(ebook);

		} else {
			throw new IllegalArgumentException("Formato do ebook inválido: " + formato);
		}
	}

}
