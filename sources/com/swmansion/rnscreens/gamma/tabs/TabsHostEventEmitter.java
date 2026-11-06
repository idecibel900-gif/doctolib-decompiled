package com.swmansion.rnscreens.gamma.tabs;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.event.TabsHostNativeFocusChangeEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsHostEventEmitter extends BaseEventEmitter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnNativeFocusChange(String tabKey, int i, boolean z) {
        Intrinsics.checkNotNullParameter(tabKey, "tabKey");
        getReactEventDispatcher().dispatchEvent(new TabsHostNativeFocusChangeEvent(getSurfaceId(), getViewTag(), tabKey, i, z));
    }
}
