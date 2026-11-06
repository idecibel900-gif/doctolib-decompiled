package com.swmansion.gesturehandler;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReactContextExtensionsKt {
    public static final void dispatchEvent(ReactContext reactContext, Event event) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, 2);
        Intrinsics.checkNotNull(uIManager, "null cannot be cast to non-null type com.facebook.react.fabric.FabricUIManager");
        ((FabricUIManager) uIManager).getEventDispatcher().dispatchEvent(event);
    }
}
