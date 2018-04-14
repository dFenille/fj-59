package br.com.caelum.casadocodigo.API;

import org.greenrobot.eventbus.EventBus;

import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.modelo.Livros;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android7392 on 14/04/18.
 */

public class WebClient {
    private static final String SERVER_URL = "http://cdcmob.herokuapp.com";
    public LivrosDelegate delegate;

    public WebClient(){
    }

    public void getLivros(int indicePrimeiro, int qtd) {
        Retrofit client = new Retrofit.Builder().
                baseUrl(SERVER_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        LivrosService service = client.create(LivrosService.class);
        Call<Livros> call = service.listaLivro(indicePrimeiro,qtd);
        call.enqueue(new Callback<Livros>(){

            @Override
            public void onResponse(Call<Livros> call, Response<Livros> response) {
                EventBus.getDefault().post(new LivroEvent(response.body()));
            }

            @Override
            public void onFailure(Call<Livros> call, Throwable t) {
                EventBus.getDefault().post(new Throwable(t));
            }


        });
    }
}
