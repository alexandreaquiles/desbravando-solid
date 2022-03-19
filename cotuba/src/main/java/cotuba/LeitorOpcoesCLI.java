package cotuba;

import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class LeitorOpcoesCLI {

  private Path diretorioDosMD;
  private String formato;
  private Path arquivoDeSaida;
  private boolean modoVerboso = false;

  public LeitorOpcoesCLI(String[] args) {

    try {

      var options = new Options();

      var opcaoDeDiretorioDosMD = new Option("d", "dir", true,
          "Diretório que contém os arquivos md. Default: diretório atual.");
      options.addOption(opcaoDeDiretorioDosMD);

      var opcaoDeFormatoDoEbook = new Option("f", "format", true,
          "Formato de saída do ebook. Pode ser: pdf ou epub. Default: pdf");
      options.addOption(opcaoDeFormatoDoEbook);

      var opcaoDeArquivoDeSaida = new Option("o", "output", true,
          "Arquivo de saída do ebook. Default: book.{formato}.");
      options.addOption(opcaoDeArquivoDeSaida);

      var opcaoModoVerboso = new Option("v", "verbose", false,
          "Habilita modo verboso.");
      options.addOption(opcaoModoVerboso);

      CommandLineParser cmdParser = new DefaultParser();
      var ajuda = new HelpFormatter();
      CommandLine cmd;

      try {
        cmd = cmdParser.parse(options, args);
      } catch (ParseException e) {
        ajuda.printHelp("cotuba", options);
        throw new IllegalArgumentException("Opção inválida", e);
      }

      String nomeDoDiretorioDosMD = cmd.getOptionValue("dir");

      if (nomeDoDiretorioDosMD != null) {
        diretorioDosMD = Paths.get(nomeDoDiretorioDosMD);
        if (!Files.isDirectory(diretorioDosMD)) {
          throw new IllegalArgumentException(nomeDoDiretorioDosMD + " não é um diretório.");
        }
      } else {
        Path diretorioAtual = Paths.get("");
        diretorioDosMD = diretorioAtual;
      }

      String nomeDoFormatoDoEbook = cmd.getOptionValue("format");

      if (nomeDoFormatoDoEbook != null) {
        formato = nomeDoFormatoDoEbook.toLowerCase();
      } else {
        formato = "pdf";
      }

      String nomeDoArquivoDeSaidaDoEbook = cmd.getOptionValue("output");
      if (nomeDoArquivoDeSaidaDoEbook != null) {
        arquivoDeSaida = Paths.get(nomeDoArquivoDeSaidaDoEbook);
      } else {
        arquivoDeSaida = Paths.get("book." + formato.toLowerCase());
      }
      if (Files.isDirectory(arquivoDeSaida)) {
        // deleta arquivos do diretório recursivamente
        Files.walk(arquivoDeSaida).sorted(Comparator.reverseOrder())
            .map(Path::toFile).forEach(File::delete);
      } else {
        Files.deleteIfExists(arquivoDeSaida);
      }

      modoVerboso = cmd.hasOption("verbose");

    } catch (IOException ex) {
      throw new IllegalArgumentException(ex);
    }
  }

  public Path getDiretorioDosMD() {
    return diretorioDosMD;
  }

  public String getFormato() {
    return formato;
  }

  public Path getArquivoDeSaida() {
    return arquivoDeSaida;
  }

  public boolean isModoVerboso() {
    return modoVerboso;
  }
}
