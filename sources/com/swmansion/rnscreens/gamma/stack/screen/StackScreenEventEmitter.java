package com.swmansion.rnscreens.gamma.stack.screen;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenNativeDismissPreventedEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillDisappearEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StackScreenEventEmitter extends BaseEventEmitter implements ViewAppearanceEventEmitter {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreenEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillAppear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidAppear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillDisappear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidDisappear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenDidDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDismiss$react_native_screens_release(boolean z) {
        getReactEventDispatcher().dispatchEvent(new StackScreenDismissEvent(getSurfaceId(), getViewTag(), z));
    }

    public final void emitOnNativeDismissPrevented$react_native_screens_release() {
        getReactEventDispatcher().dispatchEvent(new StackScreenNativeDismissPreventedEvent(getSurfaceId(), getViewTag()));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
