package app.notifee.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class NotificationReceiverActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotificationReceiverHandler.handleNotification(this, getIntent());
        finish();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        NotificationReceiverHandler.handleNotification(this, intent);
        finish();
    }
}
