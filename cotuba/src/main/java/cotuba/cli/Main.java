package cotuba.cli;

import cotuba.CotubaConfig;
import cotuba.application.Cotuba;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Path;

public class Main {

  public static void main(String[] args) {

    Path arquivoDeSaida;
    boolean modoVerboso = false;

    try {

      LeitorOpcoesCLI opcoesCLI = new LeitorOpcoesCLI(args);

      arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
      modoVerboso = opcoesCLI.isModoVerboso();

      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CotubaConfig.class);
      Cotuba cotuba = applicationContext.getBean(Cotuba.class);

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
