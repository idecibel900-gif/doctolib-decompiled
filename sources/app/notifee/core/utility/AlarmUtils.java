package app.notifee.core.utility;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import app.notifee.core.ContextHolder;
import app.notifee.core.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AlarmUtils {
    public static AlarmManager getAlarmManager() {
        return (AlarmManager) ContextHolder.getApplicationContext().getSystemService("alarm");
    }

    public static void openAlarmPermissionSettings(Activity activity) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
            intent.setData(Uri.parse("package:" + ContextHolder.getApplicationContext().getPackageName()));
            IntentUtils.startActivityOnUiThread(activity, intent);
        } catch (Exception e) {
            Logger.e("AlarmUtils", "An error occurred whilst trying to open alarm permission settings", e);
        }
    }

    public static boolean canScheduleExactAlarms() {
        if (Build.VERSION.SDK_INT >= 31) {
            return getAlarmManager().canScheduleExactAlarms();
        }
        return true;
    }
}
