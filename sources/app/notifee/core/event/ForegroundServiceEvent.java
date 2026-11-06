package app.notifee.core.event;

import app.notifee.core.KeepForSdk;
import app.notifee.core.interfaces.MethodCallResult;
import app.notifee.core.model.NotificationModel;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class ForegroundServiceEvent {
    private boolean completed = false;
    private final NotificationModel notification;
    private MethodCallResult<Void> result;

    public ForegroundServiceEvent(NotificationModel notificationModel, MethodCallResult<Void> methodCallResult) {
        this.notification = notificationModel;
        this.result = methodCallResult;
    }

    @KeepForSdk
    public NotificationModel getNotification() {
        return this.notification;
    }

    @KeepForSdk
    public void setCompletionResult() {
        if (this.completed) {
            return;
        }
        this.completed = true;
        this.result.onComplete(null, null);
    }
}
