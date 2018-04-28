package br.com.caelum.casadocodigo.api;

import br.com.caelum.casadocodigo.modelo.Livros;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by android7392 on 28/04/18.
 */

public interface NotificationService {
    @POST("/device/register/{email}/{id}")
    Call<RequestBody> sendEmail(@Path("email") String email, @Path("id") String id);
}
