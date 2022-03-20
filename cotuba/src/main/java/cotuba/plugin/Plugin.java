package cotuba.plugin;

import cotuba.domain.Ebook;

import java.util.ServiceLoader;

public interface Plugin {

  void aposGeracao(Ebook ebook);

  static void gerou(Ebook ebook) {
    ServiceLoader.load(Plugin.class)
        .forEach(plugin -> plugin.aposGeracao(ebook));
  }

}
