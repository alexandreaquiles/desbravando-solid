package cotuba.plugin;

import cotuba.domain.FormatoEbook;

import java.nio.file.Path;
import java.util.List;

public interface EbookSoParaLeitura {

  FormatoEbook getFormato();

  Path getArquivoDeSaida();

  List<? extends CapituloSoParaLeitura> getCapitulos();

}
