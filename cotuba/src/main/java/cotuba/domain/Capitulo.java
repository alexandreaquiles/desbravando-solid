package cotuba.domain;

public final class Capitulo {

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