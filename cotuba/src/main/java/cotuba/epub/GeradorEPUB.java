package cotuba.epub;

import cotuba.domain.Ebook;

public interface GeradorEPUB {

  void gera(Ebook ebook);

  static GeradorEPUB cria() {
    return new GeradorEPUBImpl();
  }

}
