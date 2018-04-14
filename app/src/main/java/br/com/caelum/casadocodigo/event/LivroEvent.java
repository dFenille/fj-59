package br.com.caelum.casadocodigo.event;

import br.com.caelum.casadocodigo.modelo.Livros;

/**
 * Created by android7392 on 14/04/18.
 */

public class LivroEvent {
    final Livros livros;

    public Livros getLivros() {
        return livros;
    }

    public LivroEvent(Livros livros) {
        this.livros = livros;
    }
}
