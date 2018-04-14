package br.com.caelum.casadocodigo.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by android7392 on 14/04/18.
 */

public class Livros implements Serializable {

    private List<Livro> livros;

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
