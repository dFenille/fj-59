package br.com.caelum.casadocodigo.api;

import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.event.NotificationCustom;
import br.com.caelum.casadocodigo.event.NotificationEvent;
import br.com.caelum.casadocodigo.modelo.Livros;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
    public Retrofit client;
    public WebClient(){
       client = new Retrofit.Builder().
                baseUrl(SERVER_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void getLivros(int indicePrimeiro, int qtd) {


        LivrosService service = this.client.create(LivrosService.class);
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

    public void sendEmail(String email,String token){
        NotificationService notificationService = this.client.create(NotificationService.class);
        Call<RequestBody> call = notificationService.sendEmail(email,token);
        call.enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                EventBus.getDefault().post(new NotificationCustom(response.body()));
            }

            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                EventBus.getDefault().post(new Throwable(t));
            }
        });
    }
}
