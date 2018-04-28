package br.com.caelum.casadocodigo.event;

import com.google.firebase.messaging.RemoteMessage;

import br.com.caelum.casadocodigo.modelo.Livros;

/**
 * Created by android7392 on 28/04/18.
 */
public class NotificationEvent {

    final RemoteMessage message;

    public RemoteMessage getMessage() {
        return message;
    }

    public NotificationEvent(RemoteMessage remoteMessage) {
        this.message = remoteMessage;
    }
}
