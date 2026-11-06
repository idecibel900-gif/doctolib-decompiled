package app.notifee.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationAlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        try {
            if (ContextHolder.getApplicationContext() == null) {
                ContextHolder.setApplicationContext(context.getApplicationContext());
            }
            NotifeeAlarmManager.displayScheduledNotification(intent.getExtras(), pendingResultGoAsync);
        } catch (Throwable th) {
            try {
                Logger.e("NotificationAlarmReceiver", "Failed to display scheduled notification", th);
            } finally {
                if (pendingResultGoAsync != null) {
                    pendingResultGoAsync.finish();
                }
            }
        }
    }
}
