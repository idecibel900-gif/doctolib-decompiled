package app.notifee.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmPermissionBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.app.action.SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED".equals(intent.getAction())) {
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            try {
                Logger.i("AlarmPermissionReceiver", "Received alarm permission state changed event");
                if (ContextHolder.getApplicationContext() == null) {
                    ContextHolder.setApplicationContext(context.getApplicationContext());
                }
                new NotifeeAlarmManager().rescheduleNotifications(pendingResultGoAsync);
            } catch (Throwable th) {
                try {
                    Logger.e("AlarmPermissionReceiver", "Failed to reschedule notifications after permission change", th);
                } finally {
                    if (pendingResultGoAsync != null) {
                        pendingResultGoAsync.finish();
                    }
                }
            }
        }
    }
}
