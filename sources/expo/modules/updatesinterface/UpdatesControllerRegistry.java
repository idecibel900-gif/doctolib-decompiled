package expo.modules.updatesinterface;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesControllerRegistry {
    public static final UpdatesControllerRegistry INSTANCE = new UpdatesControllerRegistry();
    private static WeakReference controller;

    private UpdatesControllerRegistry() {
    }

    public final WeakReference getController() {
        return controller;
    }

    public final void setController(WeakReference weakReference) {
        controller = weakReference;
    }
}
