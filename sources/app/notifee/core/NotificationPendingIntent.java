package app.notifee.core;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import app.notifee.core.event.MainComponentEvent;
import app.notifee.core.model.NotificationAndroidPressActionModel;
import app.notifee.core.utility.IntentUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NotificationPendingIntent {
    static PendingIntent createIntent(int i, Bundle bundle, int i2, String[] strArr, Bundle... bundleArr) {
        Intent[] intentArr;
        Context applicationContext = ContextHolder.getApplicationContext();
        Intent intentCreateLaunchActivityIntent = bundle != null ? createLaunchActivityIntent(applicationContext, i, NotificationAndroidPressActionModel.fromBundle(bundle)) : null;
        Intent intent = new Intent(applicationContext, (Class<?>) NotificationReceiverActivity.class);
        setIntentExtras(intentCreateLaunchActivityIntent, i2, i, strArr, bundleArr);
        setIntentExtras(intent, i2, i, strArr, bundleArr);
        int iHashCode = UUID.randomUUID().hashCode();
        if (intentCreateLaunchActivityIntent != null) {
            intent.setFlags(603979776);
            intentArr = new Intent[]{intentCreateLaunchActivityIntent, intent};
        } else {
            intent.setFlags(403177472);
            intentArr = new Intent[]{intent};
        }
        return PendingIntent.getActivities(applicationContext, iHashCode, intentArr, 167772160);
    }

    static void setIntentExtras(Intent intent, int i, int i2, String[] strArr, Bundle... bundleArr) {
        if (intent == null) {
            return;
        }
        intent.putExtra("notifee_event_type", i);
        intent.putExtra("notification_id", i2);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            if (i3 <= bundleArr.length - 1) {
                intent.putExtra(str, bundleArr[i3]);
            } else {
                intent.putExtra(str, (String) null);
            }
        }
    }

    static boolean shouldCreateLaunchActivityIntent(NotificationAndroidPressActionModel notificationAndroidPressActionModel) {
        if (notificationAndroidPressActionModel == null) {
            return false;
        }
        return (notificationAndroidPressActionModel.getLaunchActivity() == null && notificationAndroidPressActionModel.getMainComponent() == null) ? false : true;
    }

    static Intent createLaunchActivityIntent(Context context, int i, NotificationAndroidPressActionModel notificationAndroidPressActionModel) {
        if (!shouldCreateLaunchActivityIntent(notificationAndroidPressActionModel)) {
            return null;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            String launchActivity = notificationAndroidPressActionModel != null ? notificationAndroidPressActionModel.getLaunchActivity() : null;
            boolean z = false;
            Boolean boolValueOf = Boolean.valueOf(launchIntentForPackage == null);
            if (launchIntentForPackage != null) {
                if (!"default".equals(launchActivity) && !launchIntentForPackage.getComponent().getClassName().equals(launchActivity)) {
                    z = true;
                }
                boolValueOf = Boolean.valueOf(z);
            }
            if (launchActivity != null && boolValueOf.booleanValue()) {
                Intent intent = new Intent(context, (Class<?>) IntentUtils.getLaunchActivity(launchActivity));
                intent.setPackage(null);
                intent.setFlags(270532608);
                launchIntentForPackage = intent;
            }
            if (notificationAndroidPressActionModel.getLaunchActivityFlags() != -1) {
                launchIntentForPackage.setFlags(notificationAndroidPressActionModel.getLaunchActivityFlags());
            }
            if (notificationAndroidPressActionModel.getMainComponent() != null) {
                launchIntentForPackage.putExtra("mainComponent", notificationAndroidPressActionModel.getMainComponent());
                EventBus.postSticky(new MainComponentEvent(notificationAndroidPressActionModel.getMainComponent()));
            }
            return launchIntentForPackage;
        } catch (Exception e) {
            Logger.e("NotificationPendingIntent", "Failed to create LaunchActivityIntent for notification " + i, e);
            return null;
        }
    }
}
