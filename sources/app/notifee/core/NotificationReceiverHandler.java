package app.notifee.core;

import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.event.InitialNotificationEvent;
import app.notifee.core.event.MainComponentEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.model.NotificationModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NotificationReceiverHandler {
    static void handleNotification(Context context, Intent intent) {
        if (intent.hasExtra("notification")) {
            if (context != null && ContextHolder.getApplicationContext() == null) {
                ContextHolder.setApplicationContext(context.getApplicationContext());
            }
            handleNotificationIntent(context, intent);
        }
    }

    private static void handleNotificationIntent(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("notifee_event_type", 0);
        if (intExtra == 0) {
            return;
        }
        if (intExtra == 1) {
            handleNotificationPressIntent(context, intent);
        } else {
            if (intExtra != 2) {
                return;
            }
            handleNotificationActionIntent(context, intent);
        }
    }

    private static void handleNotificationActionIntent(Context context, Intent intent) {
        CharSequence charSequence;
        Bundle bundleExtra = intent.getBundleExtra("notification");
        Bundle bundleExtra2 = intent.getBundleExtra("pressAction");
        if (bundleExtra == null || bundleExtra2 == null) {
            return;
        }
        NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundleExtra);
        NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle = NotificationAndroidPressActionModel.fromBundle(bundleExtra2);
        Bundle bundle = new Bundle();
        bundle.putBundle("pressAction", notificationAndroidPressActionModelFromBundle.toBundle());
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("app.notifee.core.ReceiverService.REMOTE_INPUT_RECEIVER_KEY")) != null) {
            bundle.putString("input", charSequence.toString());
        }
        if (notificationModelFromBundle.getAndroid().getAutoCancel().booleanValue()) {
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra("notification_id", 0));
        }
        EventBus.postSticky(new InitialNotificationEvent(notificationModelFromBundle, bundle));
        EventBus.post(new NotificationEvent(2, notificationModelFromBundle, bundle));
    }

    private static void handleNotificationPressIntent(Context context, Intent intent) {
        NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle;
        String mainComponent;
        Bundle bundleExtra = intent.getBundleExtra("notification");
        if (bundleExtra == null) {
            return;
        }
        NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundleExtra);
        Bundle bundleExtra2 = intent.getBundleExtra("pressAction");
        Bundle bundle = new Bundle();
        if (bundleExtra2 != null) {
            notificationAndroidPressActionModelFromBundle = NotificationAndroidPressActionModel.fromBundle(bundleExtra2);
            bundle.putBundle("pressAction", notificationAndroidPressActionModelFromBundle.toBundle());
        } else {
            notificationAndroidPressActionModelFromBundle = null;
        }
        EventBus.post(new NotificationEvent(1, notificationModelFromBundle, bundle));
        EventBus.postSticky(new InitialNotificationEvent(notificationModelFromBundle, bundle));
        if (notificationAndroidPressActionModelFromBundle == null || (mainComponent = notificationAndroidPressActionModelFromBundle.getMainComponent()) == null) {
            return;
        }
        EventBus.postSticky(new MainComponentEvent(mainComponent));
    }
}
