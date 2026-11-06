package com.swmansion.rnscreens;

/* JADX INFO: loaded from: classes4.dex */
public interface ScreenEventDispatcher {
    void dispatchLifecycleEventInChildContainers(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent);

    void updateLastEventDispatched(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent);
}
