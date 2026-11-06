package com.swmansion.rnscreens.gamma.common.event;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEventEmitter {
    public static final Companion Companion = new Companion(null);
    private final ReactContext reactContext;
    private final EventDispatcher reactEventDispatcher;
    private final int viewTag;

    public BaseEventEmitter(ReactContext reactContext, int i) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.viewTag = i;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, i);
        if (eventDispatcherForReactTag != null) {
            this.reactEventDispatcher = eventDispatcherForReactTag;
            return;
        }
        throw new IllegalStateException(("[RNScreens] Nullish event dispatcher for view with tag: " + i).toString());
    }

    public final int getViewTag() {
        return this.viewTag;
    }

    protected final EventDispatcher getReactEventDispatcher() {
        return this.reactEventDispatcher;
    }

    protected final int getSurfaceId() {
        return UIManagerHelper.getSurfaceId(this.reactContext);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
