package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

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

  public boolean isUltimoCapitulo(Capitulo capitulo) {
    return this.capitulos.get(this.capitulos.size() - 1).equals(capitulo);
  }

}
