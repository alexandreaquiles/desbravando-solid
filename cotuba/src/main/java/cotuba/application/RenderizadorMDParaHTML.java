package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.md.RenderizadorMDParaHTMLComCommonMark;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorMDParaHTML {

  List<Capitulo> renderiza(Path diretorioDosMD);

}
