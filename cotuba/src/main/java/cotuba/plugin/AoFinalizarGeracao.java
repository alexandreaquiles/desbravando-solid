package cotuba.plugin;

import java.util.ServiceLoader;

public interface AoFinalizarGeracao {

  void aposGeracao(EbookSoParaLeitura ebook);

  static void gerou(EbookSoParaLeitura ebook) {
    ServiceLoader.load(AoFinalizarGeracao.class)
        .forEach(plugin -> plugin.aposGeracao(ebook));
  }

}