package br.com.caelum.casadocodigo.delegate;

import java.util.List;

import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.modelo.Livros;

/**
 * Created by android7392 on 14/04/18.
 */
public interface LivrosDelegate {

    public void lidaComLivroSelecionado(Livro livro);
    public void lidaComSucesso(LivroEvent livros);
    public void lidaComErro(Throwable t);

}
