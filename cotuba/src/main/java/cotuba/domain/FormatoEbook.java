package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.pdf.GeradorPDF;

public enum FormatoEbook {

  PDF(new GeradorPDF()),
  EPUB(new GeradorEPUB());

  private GeradorEbook gerador;

  FormatoEbook(GeradorEbook gerador) {
    this.gerador = gerador;
  }

  public GeradorEbook getGerador() {
    return gerador;
  }

}