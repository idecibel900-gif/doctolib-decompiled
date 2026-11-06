package app.notifee.core.event;

import android.os.Bundle;
import app.notifee.core.model.NotificationModel;

/* JADX INFO: loaded from: classes3.dex */
public class InitialNotificationEvent {
    private Bundle extras;
    private NotificationModel notificationModel;

    public InitialNotificationEvent(NotificationModel notificationModel, Bundle bundle) {
        this.notificationModel = notificationModel;
        this.extras = bundle;
    }

    public NotificationModel getNotificationModel() {
        return this.notificationModel;
    }

    public Bundle getExtras() {
        return this.extras;
    }
}
