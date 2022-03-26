package cotuba.application;

import cotuba.domain.FormatoEbook;

import java.nio.file.Path;

public interface ParametrosCotuba {

  RepositorioDeMDs getRepositorioDeMDs();

  FormatoEbook getFormato();

  Path getArquivoDeSaida();

}
