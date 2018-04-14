package br.com.caelum.casadocodigo.API;

import java.util.List;

import br.com.caelum.casadocodigo.modelo.Livros;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by android7392 on 14/04/18.
 */

public interface LivrosService {
    @GET("listarLivros")
    Call<Livros> listaLivro(@Query("indicePrimeiroLivro") int primeiro, @Query("qtdLivros") int qtd);

}
