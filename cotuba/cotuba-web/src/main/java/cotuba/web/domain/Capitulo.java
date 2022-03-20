package cotuba.web.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "capitulos")
public class Capitulo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Min(1)
  private Integer ordem;

  @Size(min = 1, max = 255)
  private String nome;

  @Size(min = 1)
  @Lob
  private String markdown;

  @ManyToOne(optional = false)
  private Livro livro;

  @Deprecated
  protected Capitulo() {
  }

  public Capitulo(Integer ordem, String nome, String markdown, Livro livro) {
    this.ordem = ordem;
    this.nome = nome;
    this.markdown = markdown;
    this.livro = livro;
  }

  public Capitulo(Long id, Integer ordem, String nome, String markdown, Livro livro) {
    this(ordem, nome, markdown, livro);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public Integer getOrdem() {
    return ordem;
  }

  public String getNome() {
    return nome;
  }

  public String getMarkdown() {
    return markdown;
  }

  public Livro getLivro() {
    return livro;
  }

  @Override
  public String toString() {
    return "Capitulo{" +
        "id=" + id +
        ", ordem=" + ordem +
        ", nome='" + nome + '\'' +
        ", markdown='" + markdown + '\'' +
        ", livro=" + livro +
        '}';
  }
}
