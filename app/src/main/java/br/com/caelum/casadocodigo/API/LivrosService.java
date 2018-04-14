package br.com.caelum.casadocodigo.API;

import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livros;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android7392 on 14/04/18.
 */

public interface LivrosService {
    @GET("listarLivros?indicePrimeiroLivro=0&qtdLivros=20")
    Call<Livros> listaLivro();

}
