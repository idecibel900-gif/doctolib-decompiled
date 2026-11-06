package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestDelegate extends DefaultLifecycleObserver {
    default void assertActive() {
    }

    void complete();

    void start();
}
