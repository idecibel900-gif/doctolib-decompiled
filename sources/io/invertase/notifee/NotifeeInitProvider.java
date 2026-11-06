package io.invertase.notifee;

import app.notifee.core.InitProvider;
import app.notifee.core.Notifee;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lio/invertase/notifee/NotifeeInitProvider;", "Lapp/notifee/core/InitProvider;", "<init>", "()V", "onCreate", "", "react-native-notify-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifeeInitProvider extends InitProvider {
    @Override // app.notifee.core.InitProvider, android.content.ContentProvider
    public boolean onCreate() {
        boolean zOnCreate = super.onCreate();
        Notifee.initialize(new NotifeeEventSubscriber());
        return zOnCreate;
    }
}
