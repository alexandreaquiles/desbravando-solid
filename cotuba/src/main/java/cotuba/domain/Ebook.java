package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

/**
 * Esta classe representa o Domain Model da aplicação.
 * 
 * @author MarcosGOFavaretto (marcosfavaretto.dev@gmail.com).
 *
 */
public class Ebook {

	private String formato;
	private Path arquivoDeSaida;
	private List<Capitulo> capitulos;

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Path getArquivoDeSaida() {
		return arquivoDeSaida;
	}

	public void setArquivoDeSaida(Path arquivoDeSaida) {
		this.arquivoDeSaida = arquivoDeSaida;
	}

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}

	/*
	 * TODO: Cumprir o desafio passado pelo autor.
	 * 
	 * "Talvez seja uma maneira ingênua de manipular os parâmetros. Poderíamos usar
	 * uma programação mais defensiva, evitando exceções indesejadas. Fica como
	 * exercício!" - Alexandre Aquiles, página 55.
	 */
	public boolean isUltimoCapitulo(Capitulo capitulo) {
		return this.capitulos.get(this.capitulos.size() - 1).equals(capitulo);
	}
}
