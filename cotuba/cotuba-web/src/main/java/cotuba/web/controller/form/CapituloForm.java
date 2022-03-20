package cotuba.web.controller.form;

import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CapituloForm {

  @Min(1)
  private Integer ordem;

  @Size(min = 1, max = 255)
  private String nome;

  @Size(min = 1)
  private String markdown;

  public Capitulo toEntity(Long capituloId, Livro livro) {
    return new Capitulo(capituloId, ordem, nome, markdown, livro);
  }

  public Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(Integer ordem) {
    this.ordem = ordem;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getMarkdown() {
    return markdown;
  }

  public void setMarkdown(String markdown) {
    this.markdown = markdown;
  }
}
