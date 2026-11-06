package com.facebook.react.runtime;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactLifecycleStateManager {
    private LifecycleState state;
    private final ReactHostStateTracker stateTracker;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LifecycleState.values().length];
            try {
                iArr[LifecycleState.BEFORE_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LifecycleState.RESUMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LifecycleState.BEFORE_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ReactLifecycleStateManager(ReactHostStateTracker stateTracker) {
        Intrinsics.checkNotNullParameter(stateTracker, "stateTracker");
        this.stateTracker = stateTracker;
        this.state = LifecycleState.BEFORE_CREATE;
    }

    public final LifecycleState getLifecycleState() {
        return this.state;
    }

    public final void resumeReactContextIfHostResumed(ReactContext currentContext, Activity activity) {
        Intrinsics.checkNotNullParameter(currentContext, "currentContext");
        if (this.state == LifecycleState.RESUMED) {
            ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostResume()", null, 2, null);
            currentContext.onHostResume(activity);
        }
    }

    public final void moveToOnHostResume(ReactContext reactContext, Activity activity) {
        LifecycleState lifecycleState = this.state;
        LifecycleState lifecycleState2 = LifecycleState.RESUMED;
        if (lifecycleState == lifecycleState2) {
            return;
        }
        if (reactContext != null) {
            ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostResume()", null, 2, null);
            reactContext.onHostResume(activity);
        }
        this.state = lifecycleState2;
    }

    public final void moveToOnHostPause(ReactContext reactContext, Activity activity) {
        if (reactContext != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i == 1) {
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostResume()", null, 2, null);
                reactContext.onHostResume(activity);
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostPause()", null, 2, null);
                reactContext.onHostPause();
            } else if (i == 2) {
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostPause()", null, 2, null);
                reactContext.onHostPause();
            }
        }
        this.state = LifecycleState.BEFORE_RESUME;
    }

    public final void moveToOnHostDestroy(ReactContext reactContext) {
        if (reactContext != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i == 2) {
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostPause()", null, 2, null);
                reactContext.onHostPause();
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostDestroy()", null, 2, null);
                reactContext.onHostDestroy();
            } else if (i == 3) {
                ReactHostStateTracker.enterState$default(this.stateTracker, "ReactContext.onHostDestroy()", null, 2, null);
                reactContext.onHostDestroy();
            }
        }
        this.state = LifecycleState.BEFORE_CREATE;
    }
}
