package cotuba.domain;

import cotuba.plugin.CapituloSoParaLeitura;

public final class Capitulo implements CapituloSoParaLeitura {

  private final String titulo;

  private final String conteudoHTML;

  public Capitulo(String titulo, String conteudoHTML) {
    this.titulo = titulo;
    this.conteudoHTML = conteudoHTML;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getConteudoHTML() {
    return conteudoHTML;
  }

}