package app.notifee.core;

import android.content.Context;
import android.os.Trace;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public final class WarmupHelper {
    private static final String TAG = "WarmupHelper";
    static final String[] WARMUP_CLASSES = {"app.notifee.core.ForegroundService", "app.notifee.core.NotificationManager", "app.notifee.core.model.NotificationModel", "app.notifee.core.model.NotificationAndroidModel", "app.notifee.core.model.ChannelModel", "androidx.core.app.NotificationCompat$Builder", "androidx.core.app.NotificationManagerCompat"};

    private WarmupHelper() {
    }

    @KeepForSdk
    public static void runWarmup(Context context) {
        Trace.beginSection("notifee:warmup");
        try {
            ClassLoader classLoader = context.getClassLoader();
            for (String str : WARMUP_CLASSES) {
                try {
                    Class.forName(str, true, classLoader);
                } catch (ClassNotFoundException unused) {
                    Logger.d(TAG, "Warmup class not found: " + str);
                }
            }
            try {
                NotificationManagerCompat.from(context).getNotificationChannels();
            } catch (Exception e) {
                Logger.d(TAG, "Warmup Binder pre-warm failed: " + e.getMessage());
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}
