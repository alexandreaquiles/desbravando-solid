package br.com.cognitio.estatisticas;

import java.util.Collection;
import java.util.TreeMap;

public class ContagemDePalavras extends TreeMap<String, Integer> {

  private static final long serialVersionUID = 1L;

  public void adicionaPalavra(String palavra) {

    Integer contagem = get(palavra);

    if (contagem != null) {
      contagem++;
    } else {
      contagem = 1;
    }

    put(palavra, contagem);

  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Collection<Integer> values() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Integer replace(String key, Integer value) {
    throw new UnsupportedOperationException();
  }

}
