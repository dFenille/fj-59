package br.com.caelum.casadocodigo.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.ui.CarrinhoActivity;

/**
 * Created by android7392 on 28/04/18.
 */

public class MeuListener extends FirebaseMessagingService {
    private static int NOTIFY_TAG = 123;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String,String> data = remoteMessage.getData();
        String message = data.get("message");
        PendingIntent pendingIntent = PendingIntent.
                                        getActivity(getBaseContext(),NOTIFY_TAG,
                                                    new Intent(getApplicationContext(), CarrinhoActivity.class),
                                                    PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notification = new NotificationCompat.Builder(getBaseContext())
                .setSmallIcon(R.drawable.casadocodigo)
                                        .setContentTitle(message)
                                        .setColor(Color.WHITE)
                                        .setAutoCancel(true)
                                        .setContentIntent(pendingIntent)
                                        .build();

        Context context = getBaseContext();
        NotificationManager manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFY_TAG,notification);
    }


}
