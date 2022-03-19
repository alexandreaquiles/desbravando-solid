package cotuba.plugin;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.util.ServiceLoader;

public interface Plugin {

  String aposRenderizacao(String html);

  void aposGeracao(Ebook ebook);

  static void renderizou(Capitulo capitulo) {
    ServiceLoader.load(Plugin.class)
        .forEach(plugin -> {
          String html = capitulo.getConteudoHTML();
          String htmlModificado = plugin.aposRenderizacao(html);
          capitulo.setConteudoHTML(htmlModificado);
        });
  }

  static void gerou(Ebook ebook) {
    ServiceLoader.load(Plugin.class)
        .forEach(plugin -> plugin.aposGeracao(ebook));
  }

}
