package cotuba.web.application;

import cotuba.application.ParametrosCotuba;
import cotuba.application.RepositorioDeMDs;
import cotuba.domain.FormatoEbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ParametrosCotubaWeb implements ParametrosCotuba {

  private final FormatoEbook formato;
  private final Path arquivoDeSaida;
  private final MDsDoBancoDeDados mDsDoBancoDeDados;

  public ParametrosCotubaWeb(FormatoEbook formato, MDsDoBancoDeDados mDsDoBancoDeDados) {
    this.formato = formato;
    this.arquivoDeSaida = criaArquivoTemporario();
    this.mDsDoBancoDeDados = mDsDoBancoDeDados;
  }

  @Override
  public RepositorioDeMDs getRepositorioDeMDs() {
    return mDsDoBancoDeDados;
  }

  @Override
  public FormatoEbook getFormato() {
    return formato;
  }

  @Override
  public Path getArquivoDeSaida() {
    return arquivoDeSaida;
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
