package br.com.caelum.casadocodigo.firebase;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by android7392 on 28/04/18.
 */

public class NotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        EventBus.getDefault().post(remoteMessage);
    }
}
