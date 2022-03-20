package cotuba.domain;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class Ebook {

  private final FormatoEbook formato;

  private final Path arquivoDeSaida;

  private final List<Capitulo> capitulos;

  public Ebook(FormatoEbook formato, Path arquivoDeSaida, List<Capitulo> capitulos) {
    this.formato = formato;
    this.arquivoDeSaida = arquivoDeSaida;
    this.capitulos = Collections.unmodifiableList(capitulos);
  }

  public FormatoEbook getFormato() {
    return formato;
  }

  public Path getArquivoDeSaida() {
    return arquivoDeSaida;
  }

  public List<Capitulo> getCapitulos() {
    return capitulos;
  }

  public boolean isUltimoCapitulo(Capitulo capitulo) {
    return this.capitulos.get(this.capitulos.size() - 1).equals(capitulo);
  }

}
