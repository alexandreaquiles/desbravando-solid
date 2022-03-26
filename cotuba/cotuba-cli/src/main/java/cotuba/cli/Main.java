package cotuba.cli;

import cotuba.application.Cotuba;
import cotuba.domain.builder.CapituloBuilder;
import cotuba.md.RenderizadorMDParaHTML;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    CapituloBuilder builder = new CapituloBuilder(); // opa!
    System.out.println(builder);

    RenderizadorMDParaHTML md = new RenderizadorMDParaHTML();  // eita!
    System.out.println(md);

    Path arquivoDeSaida;
    boolean modoVerboso = false;

    try {

      LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

      arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
      modoVerboso = opcoesCLI.isModoVerboso();

      Cotuba cotuba = new Cotuba();
      cotuba.executa(opcoesCLI);

      System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
      if (modoVerboso) {
        ex.printStackTrace();
      }
      System.exit(1);
    }
  }

}
