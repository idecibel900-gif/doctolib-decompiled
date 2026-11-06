package io.invertase.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.HeadlessJsTaskService;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.SharedUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class ReactNativeFirebaseMessagingReceiver extends BroadcastReceiver {
    private static final String TAG = "RNFirebaseMsgReceiver";
    static HashMap<String, RemoteMessage> notifications = new HashMap<>();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (ReactNativeFirebaseApp.getApplicationContext() == null) {
            ReactNativeFirebaseApp.setApplicationContext(context.getApplicationContext());
        }
        if (intent.getExtras() == null) {
            return;
        }
        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        if (remoteMessage.getNotification() != null) {
            notifications.put(remoteMessage.getMessageId(), remoteMessage);
            ReactNativeFirebaseMessagingStoreHelper.getInstance().getMessagingStore().storeFirebaseMessage(remoteMessage);
        }
        if (SharedUtils.isAppInForeground(context)) {
            sharedInstance.sendEvent(ReactNativeFirebaseMessagingSerializer.remoteMessageToEvent(remoteMessage, Boolean.FALSE));
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) ReactNativeFirebaseMessagingHeadlessService.class);
            intent2.putExtra("message", remoteMessage);
            if (context.startService(intent2) != null) {
                HeadlessJsTaskService.acquireWakeLockNow(context);
            }
        } catch (IllegalStateException unused) {
        }
    }
}
