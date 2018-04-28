package br.com.caelum.casadocodigo.event;

import android.app.Notification;

import com.google.firebase.messaging.RemoteMessage;

import br.com.caelum.casadocodigo.modelo.Livros;

/**
 * Created by android7392 on 28/04/18.
 */
public class NotificationEvent {

    final RemoteMessage.Notification message;

    public RemoteMessage.Notification getMessage() {
        return message;
    }

    public NotificationEvent(RemoteMessage.Notification notification) {
        this.message = notification;
    }
}
