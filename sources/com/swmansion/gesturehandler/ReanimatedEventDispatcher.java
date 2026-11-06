package com.swmansion.gesturehandler;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ReanimatedEventDispatcher {
    private ReanimatedModule reanimatedModule;

    public final void sendEvent(Event event, ReactContext reactApplicationContext) {
        NodesManager nodesManager;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        if (this.reanimatedModule == null) {
            this.reanimatedModule = (ReanimatedModule) reactApplicationContext.getNativeModule(ReanimatedModule.class);
        }
        ReanimatedModule reanimatedModule = this.reanimatedModule;
        if (reanimatedModule == null || (nodesManager = reanimatedModule.getNodesManager()) == null) {
            return;
        }
        nodesManager.onEventDispatch(event);
    }
}
