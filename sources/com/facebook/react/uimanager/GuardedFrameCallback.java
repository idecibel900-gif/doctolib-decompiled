package com.facebook.react.uimanager;

import android.view.Choreographer;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GuardedFrameCallback implements Choreographer.FrameCallback {
    private final JSExceptionHandler exceptionHandler;

    protected abstract void doFrameGuarded(long j);

    protected GuardedFrameCallback(JSExceptionHandler exceptionHandler) {
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        this.exceptionHandler = exceptionHandler;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected GuardedFrameCallback(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        JSExceptionHandler exceptionHandler = reactContext.getExceptionHandler();
        Intrinsics.checkNotNullExpressionValue(exceptionHandler, "getExceptionHandler(...)");
        this(exceptionHandler);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.exceptionHandler.handleException(e);
        }
    }
}
