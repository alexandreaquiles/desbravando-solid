package br.com.paradizo.tema;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collections;

public class FileUtils {

  public static String getResourceContents(String resource) {
    try {
      Path resourcePath = getResourceAsPath(resource);
      return getPathContents(resourcePath);
    } catch (URISyntaxException | IOException ex) {
      throw new IllegalStateException(ex);
    }
  }

  private static Path getResourceAsPath(String resource) throws URISyntaxException, IOException {
    URI uri = FileUtils.class.getResource(resource).toURI();

    if (isResourceInJar(uri)) {
      return getResourceFromJar(uri);
    } else {
      return Paths.get(uri);
    }
  }

  private static boolean isResourceInJar(URI uri) {
    return uri.getScheme().equals("jar");
  }

  private static Path getResourceFromJar(URI fullURI) throws IOException {
    // a resource from a JAR needs a FileSystem
    // see http://stackoverflow.com/a/22605905
    String[] uriParts = fullURI.toString().split("!");
    URI jarURI = URI.create(uriParts[0]);

    FileSystem fs;

    try {
      fs = FileSystems.newFileSystem(jarURI, Collections.<String, String>emptyMap());
    } catch (FileSystemAlreadyExistsException ex) {
      fs = FileSystems.getFileSystem(jarURI);
    }
    String resourceURI = uriParts[1];
    return fs.getPath(resourceURI);
  }

  private static String getPathContents(Path path) throws IOException {
    return new String(Files.readAllBytes(path));
  }

}