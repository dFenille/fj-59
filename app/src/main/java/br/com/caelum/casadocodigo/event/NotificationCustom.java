package br.com.caelum.casadocodigo.event;

import okhttp3.RequestBody;

/**
 * Created by android7392 on 28/04/18.
 */

public class NotificationCustom {
    RequestBody requestBody;
    public NotificationCustom(RequestBody requestBody){
        this.requestBody = requestBody;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }
}
