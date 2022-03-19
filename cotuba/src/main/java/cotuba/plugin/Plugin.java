package cotuba.plugin;

import cotuba.domain.Ebook;

public interface Plugin {

  String aposRenderizacao(String html);

  void aposGeracao(Ebook ebook);

}
