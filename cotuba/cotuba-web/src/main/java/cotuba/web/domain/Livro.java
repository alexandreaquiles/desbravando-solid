package cotuba.web.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "livros")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 1, max = 255)
  private String titulo;

  @Deprecated
  protected Livro() {
  }

  public Livro(String titulo) {
    this.titulo = titulo;
  }

  public Livro(Long id, String titulo) {
    this(titulo);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  @Override
  public String toString() {
    return "Livro{" +
        "id=" + id +
        ", titulo='" + titulo + '\'' +
        '}';
  }
}
