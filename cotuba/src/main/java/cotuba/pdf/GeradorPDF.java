package cotuba.pdf;

import cotuba.domain.Ebook;

public interface GeradorPDF {

  void gera(Ebook ebook);

  static GeradorPDF cria() {
    return new GeradorPDFComIText();
  }

}
