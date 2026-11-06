package app.notifee.core;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import app.notifee.core.event.InitialNotificationEvent;
import app.notifee.core.event.MainComponentEvent;
import app.notifee.core.event.NotificationEvent;
import app.notifee.core.model.NotificationAndroidModel;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.model.NotificationModel;
import app.notifee.core.utility.IntentUtils;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiverService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static PendingIntent createIntent(String str, String[] strArr, Bundle... bundleArr) {
        Context applicationContext = ContextHolder.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) ReceiverService.class);
        intent.setAction(str);
        for (int i = 0; i < strArr.length; i++) {
            String str2 = strArr[i];
            if (i <= bundleArr.length - 1) {
                intent.putExtra(str2, bundleArr[i]);
            } else {
                intent.putExtra(str2, (String) null);
            }
        }
        intent.setData(createPendingIntentData(intent));
        return PendingIntent.getService(applicationContext, 0, intent, 167772160);
    }

    private static Uri createPendingIntentData(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("notification");
        Bundle bundle = bundleExtra == null ? null : bundleExtra.getBundle("android");
        Bundle bundleExtra2 = intent.getBundleExtra("pressAction");
        String string = bundleExtra == null ? null : bundleExtra.getString(DiagnosticsEntry.ID_KEY);
        String string2 = bundle == null ? null : bundle.getString("tag");
        String string3 = bundleExtra2 != null ? bundleExtra2.getString(DiagnosticsEntry.ID_KEY) : null;
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("notifee").authority("receiver-service").appendPath("pending-intent");
        appendNullableIdentityValue(builderAppendPath, "interactionType", intent.getAction());
        appendNullableIdentityValue(builderAppendPath, "notificationTag", string2);
        appendNullableIdentityValue(builderAppendPath, "notificationId", string);
        appendNullableIdentityValue(builderAppendPath, "pressActionId", string3);
        return builderAppendPath.build();
    }

    private static void appendNullableIdentityValue(Uri.Builder builder, String str, String str2) {
        builder.appendQueryParameter(str + "Present", str2 == null ? "0" : "1");
        if (str2 != null) {
            builder.appendQueryParameter(str, str2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String action = intent.getAction();
        if (action == null) {
            return 2;
        }
        switch (action) {
            case "app.notifee.core.ReceiverService.ACTION_PRESS_INTENT":
                onActionPressIntent(intent);
                return 2;
            case "app.notifee.core.ReceiverService.DELETE_INTENT":
                onDeleteIntent(intent);
                return 2;
            case "app.notifee.core.ReceiverService.PRESS_INTENT":
                onPressIntent(intent);
                return 2;
            default:
                return 2;
        }
    }

    private void onDeleteIntent(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("notification");
        if (bundleExtra == null) {
            return;
        }
        NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundleExtra);
        if (ForegroundService.repostIfActive(notificationModelFromBundle.getId())) {
            return;
        }
        EventBus.post(new NotificationEvent(0, notificationModelFromBundle));
    }

    private void onPressIntent(Intent intent) {
        NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle;
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
        InitialNotificationEvent initialNotificationEvent = new InitialNotificationEvent(notificationModelFromBundle, bundle);
        EventBus.postSticky(initialNotificationEvent);
        if (notificationAndroidPressActionModelFromBundle == null) {
            return;
        }
        String launchActivity = notificationAndroidPressActionModelFromBundle.getLaunchActivity();
        String mainComponent = notificationAndroidPressActionModelFromBundle.getMainComponent();
        if (launchActivity == null && mainComponent == null) {
            return;
        }
        launchPendingIntentActivity(initialNotificationEvent, launchActivity, mainComponent, notificationAndroidPressActionModelFromBundle.getLaunchActivityFlags());
    }

    private void onActionPressIntent(Intent intent) {
        CharSequence charSequence;
        Bundle bundleExtra = intent.getBundleExtra("notification");
        Bundle bundleExtra2 = intent.getBundleExtra("pressAction");
        if (bundleExtra == null || bundleExtra2 == null) {
            return;
        }
        NotificationModel notificationModelFromBundle = NotificationModel.fromBundle(bundleExtra);
        NotificationAndroidModel android2 = notificationModelFromBundle.getAndroid();
        NotificationAndroidPressActionModel notificationAndroidPressActionModelFromBundle = NotificationAndroidPressActionModel.fromBundle(bundleExtra2);
        Bundle bundle = new Bundle();
        bundle.putBundle("pressAction", notificationAndroidPressActionModelFromBundle.toBundle());
        Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
        if (resultsFromIntent != null && (charSequence = resultsFromIntent.getCharSequence("app.notifee.core.ReceiverService.REMOTE_INPUT_RECEIVER_KEY")) != null) {
            bundle.putString("input", charSequence.toString());
        }
        EventBus.post(new NotificationEvent(2, notificationModelFromBundle, bundle));
        if (notificationModelFromBundle.getAndroid().getAutoCancel().booleanValue()) {
            NotificationManagerCompat.from(getApplicationContext()).cancel(android2.getTag(), notificationModelFromBundle.getId().hashCode());
        }
        String launchActivity = notificationAndroidPressActionModelFromBundle.getLaunchActivity();
        String mainComponent = notificationAndroidPressActionModelFromBundle.getMainComponent();
        if (launchActivity == null && mainComponent == null) {
            return;
        }
        launchPendingIntentActivity(new InitialNotificationEvent(notificationModelFromBundle, bundle), launchActivity, mainComponent, notificationAndroidPressActionModelFromBundle.getLaunchActivityFlags());
        closeSystemDialogsBestEffort();
    }

    private void closeSystemDialogsBestEffort() {
        if (Build.VERSION.SDK_INT >= 31) {
            return;
        }
        try {
            ContextHolder.getApplicationContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (SecurityException e) {
            Logger.w("ReceiverService", "Unable to close system dialogs with legacy broadcast", e);
        }
    }

    private void launchPendingIntentActivity(InitialNotificationEvent initialNotificationEvent, String str, String str2, int i) {
        Class launchActivity = IntentUtils.getLaunchActivity(str);
        if (launchActivity == null) {
            Logger.e("ReceiverService", "Failed to get launch activity");
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) launchActivity);
        if (i != -1) {
            intent.addFlags(i);
        }
        if (str2 != null) {
            intent.putExtra("mainComponent", str2);
        }
        try {
            PendingIntent.getActivity(getApplicationContext(), initialNotificationEvent.getNotificationModel().getHashCode().intValue(), intent, 167772160).send();
            EventBus.postSticky(initialNotificationEvent);
            if (str2 != null) {
                EventBus.postSticky(new MainComponentEvent(str2));
            }
        } catch (Exception e) {
            Logger.e("ReceiverService", "Failed to send PendingIntent from launchPendingIntentActivity for notification " + initialNotificationEvent.getNotificationModel().getId(), e);
        }
    }
}
