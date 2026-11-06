package expo.modules.core.interfaces.services;

import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.LifecycleEventListener;

/* JADX INFO: loaded from: classes4.dex */
public interface UIManager {
    void registerActivityEventListener(ActivityEventListener activityEventListener);

    void registerLifecycleEventListener(LifecycleEventListener lifecycleEventListener);

    void unregisterActivityEventListener(ActivityEventListener activityEventListener);
}
