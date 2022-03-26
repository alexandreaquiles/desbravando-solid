import cotuba.epub.GeradorEPUB;

module cotuba.epub {
  exports cotuba.epub;
  requires cotuba.core;

  requires epublib.core;

  provides cotuba.plugin.GeradorEbook with GeradorEPUB;
}