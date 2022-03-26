package cotuba.web.application;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;
import cotuba.web.domain.Capitulo;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class GeracaoDeLivros {

  public Path geraLivro(List<Capitulo> capitulos, FormatoEbook formato) {
    Cotuba cotuba = new Cotuba();
    ParametrosCotuba parametros = // o que colocar aqui???
    cotuba.executa(parametros);
  }

}
