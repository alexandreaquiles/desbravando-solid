module cotuba.core {
  exports cotuba.application;
  exports cotuba.domain;
  exports cotuba.plugin;

  requires org.commonmark;

  uses cotuba.plugin.AoRenderizarHTML;
  uses cotuba.plugin.AoFinalizarGeracao;
  uses cotuba.plugin.GeradorEbook;
}