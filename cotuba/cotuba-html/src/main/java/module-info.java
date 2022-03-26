import cotuba.html.GeradorHTML;

module cotuba.html {
  exports cotuba.html;
  requires cotuba.core;

  provides cotuba.plugin.GeradorEbook with GeradorHTML;
}