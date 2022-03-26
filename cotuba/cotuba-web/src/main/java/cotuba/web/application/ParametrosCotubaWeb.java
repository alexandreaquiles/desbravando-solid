package cotuba.web.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import cotuba.domain.FormatoEbook;
import cotuba.application.ParametrosCotuba;

public class ParametrosCotubaWeb implements ParametrosCotuba {

  private final FormatoEbook formato;
  private final Path arquivoDeSaida;

  public ParametrosCotubaWeb(FormatoEbook formato) {
    this.formato = formato;
    this.arquivoDeSaida = criaArquivoTemporario();
  }

  @Override
  public FormatoEbook getFormato() {
    return formato;
  }

  @Override
  public Path getArquivoDeSaida() {
    return arquivoDeSaida;
  }

  @Override
  public Path getDiretorioDosMD() {
  }

  private Path criaArquivoTemporario() {
    try {
      Path diretorioTemporario = Files.createTempDirectory("ebooks");
      String nomeDoArquivoDeSaida = "book." + formato.name().toLowerCase();
      return diretorioTemporario.resolve(nomeDoArquivoDeSaida);
    } catch (IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

}
