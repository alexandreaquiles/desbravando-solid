package cotuba.web.repository;

import cotuba.web.domain.Capitulo;
import cotuba.web.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDeCapitulos extends JpaRepository<Capitulo, Long> {

  List<Capitulo> findAllByLivroOrderByOrdem(Livro livro);

}
