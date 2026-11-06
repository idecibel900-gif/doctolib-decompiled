package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalLifecycle extends Lifecycle {
    public static final GlobalLifecycle INSTANCE = new GlobalLifecycle();
    private static final GlobalLifecycle$owner$1 owner = new LifecycleOwner() { // from class: coil.request.GlobalLifecycle$owner$1
        @Override // androidx.lifecycle.LifecycleOwner
        public GlobalLifecycle getLifecycle() {
            return GlobalLifecycle.INSTANCE;
        }
    };

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver) {
    }

    private GlobalLifecycle() {
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.RESUMED;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        if (!(lifecycleObserver instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((lifecycleObserver + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) lifecycleObserver;
        GlobalLifecycle$owner$1 globalLifecycle$owner$1 = owner;
        defaultLifecycleObserver.onCreate(globalLifecycle$owner$1);
        defaultLifecycleObserver.onStart(globalLifecycle$owner$1);
        defaultLifecycleObserver.onResume(globalLifecycle$owner$1);
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
