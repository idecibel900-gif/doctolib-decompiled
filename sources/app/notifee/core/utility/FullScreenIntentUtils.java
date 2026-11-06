package app.notifee.core.utility;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.ContextHolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FullScreenIntentUtils {
    public static boolean canUseFullScreenIntent() {
        return canUseFullScreenIntent(ContextHolder.getApplicationContext());
    }

    static boolean canUseFullScreenIntent(Context context) {
        if (context == null) {
            return true;
        }
        return NotificationManagerCompat.from(context).canUseFullScreenIntent();
    }
}
