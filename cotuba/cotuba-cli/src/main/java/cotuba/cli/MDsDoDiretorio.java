package cotuba.cli;

import cotuba.application.RepositorioDeMDs;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

class MDsDoDiretorio implements RepositorioDeMDs {

  private final Path diretorioDosMD;

  public MDsDoDiretorio(Path diretorioDosMD) {
    this.diretorioDosMD = diretorioDosMD;
  }

  @Override
  public List<String> obtemMDsDosCapitulos() {

    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.md");
    try (Stream<Path> arquivosMD = Files.list(diretorioDosMD)) {
      return arquivosMD
          .filter(matcher::matches)
          .sorted()
          .map(arquivoMD -> {
            try {
              return new String(Files.readAllBytes(arquivoMD));
            } catch (Exception ex) {
              throw new IllegalStateException("Erro ao ler arquivo " + arquivoMD, ex);
            }
          })
          .toList();
    } catch (IOException ex) {
      throw new IllegalStateException("Erro tentando encontrar arquivos .md em " + diretorioDosMD.toAbsolutePath(), ex);
    }

  }
}
