package app.notifee.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class RebootBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            Logger.w("RebootReceiver", "Ignoring reboot event with null intent");
            return;
        }
        String action = intent.getAction();
        if (!"android.intent.action.BOOT_COMPLETED".equals(action) && !"android.intent.action.QUICKBOOT_POWERON".equals(action) && !"com.htc.intent.action.QUICKBOOT_POWERON".equals(action)) {
            Logger.w("RebootReceiver", "Ignoring unsupported reboot event action: " + action);
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        try {
            Logger.i("RebootReceiver", "Received reboot event");
            if (ContextHolder.getApplicationContext() == null) {
                ContextHolder.setApplicationContext(context.getApplicationContext());
            }
            new NotifeeAlarmManager().rescheduleNotifications(pendingResultGoAsync);
        } catch (Throwable th) {
            try {
                Logger.e("RebootReceiver", "Failed to reschedule notifications after reboot", th);
            } finally {
                if (pendingResultGoAsync != null) {
                    pendingResultGoAsync.finish();
                }
            }
        }
    }
}
