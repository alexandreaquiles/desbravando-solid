package cotuba.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.property.AreaBreakType;
import cotuba.domain.FormatoEbook;
import cotuba.plugin.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GeradorPDF implements GeradorEbook {

  @Override
  public FormatoEbook formato() {
    return FormatoEbook.PDF;
  }

  @Override
  public void gera(Ebook ebook) {

    try {

      // puxa!
      Class mainClass = Class.forName("cotuba.cli.Main");
      Object main = mainClass.getDeclaredConstructor().newInstance();
      System.out.println(main);

      // caramba!
      Class optionsClass = Class.forName("org.apache.commons.cli.Options");
      Object options = optionsClass.getDeclaredConstructor().newInstance();
      System.out.println(options);

    } catch (ClassNotFoundException | InstantiationException|
        IllegalAccessException | NoSuchMethodException |
        InvocationTargetException ex) {
      throw new IllegalStateException(ex);
    }

    Path arquivoDeSaida = ebook.arquivoDeSaida();

    try (var writer = new PdfWriter(Files.newOutputStream(arquivoDeSaida));
         var pdf = new PdfDocument(writer);
         var pdfDocument = new Document(pdf)) {

      for (Capitulo capitulo : ebook.capitulos()) {

        String html = capitulo.conteudoHTML();

        List<IElement> convertToElements =
            HtmlConverter.convertToElements(html);
        for (IElement element : convertToElements) {
          pdfDocument.add((IBlockElement) element);
        }

        if (!ebook.ultimoCapitulo(capitulo)) {
          pdfDocument.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        }

      }

    } catch (Exception ex) {
      throw new IllegalStateException("Erro ao criar arquivo PDF: " + arquivoDeSaida.toAbsolutePath(), ex);
    }

  }

}
