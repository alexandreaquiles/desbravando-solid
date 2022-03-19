package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.epub.GeradorEPUB;
import cotuba.html.GeradorHTML;
import cotuba.pdf.GeradorPDF;

public enum FormatoEbook {

  PDF(new GeradorPDF()),
  EPUB(new GeradorEPUB()),
  HTML(new GeradorHTML());

  private GeradorEbook gerador;

  FormatoEbook(GeradorEbook gerador) {
    this.gerador = gerador;
  }

  public GeradorEbook getGerador() {
    return gerador;
  }

}