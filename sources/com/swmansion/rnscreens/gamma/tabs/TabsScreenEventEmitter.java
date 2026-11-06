package com.swmansion.rnscreens.gamma.tabs;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.event.TabsScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabsScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabsScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.event.TabsScreenWillDisappearEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsScreenEventEmitter extends BaseEventEmitter {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsScreenEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnWillAppear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onWillAppear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidAppear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onDidAppear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnWillDisappear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onWillDisappear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidDisappear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onDidDisappear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenDidDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
