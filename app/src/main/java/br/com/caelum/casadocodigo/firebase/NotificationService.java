package br.com.caelum.casadocodigo.firebase;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.greenrobot.eventbus.EventBus;

import br.com.caelum.casadocodigo.event.NotificationEvent;

/**
 * Created by android7392 on 28/04/18.
 */

public class NotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        EventBus.getDefault().post(new NotificationEvent(remoteMessage.getNotification()));
    }
}
