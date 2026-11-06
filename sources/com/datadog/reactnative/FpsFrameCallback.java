package com.datadog.reactnative;

import android.view.Choreographer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FpsFrameCallback implements Choreographer.FrameCallback {
    private Choreographer choreographer;
    private final JsThreadExecutor jsThreadExecutor;
    private long lastFrameTime;
    private final Function1 reactFrameRateCallback;

    public FpsFrameCallback(Function1 reactFrameRateCallback, JsThreadExecutor jsThreadExecutor) {
        Intrinsics.checkNotNullParameter(reactFrameRateCallback, "reactFrameRateCallback");
        Intrinsics.checkNotNullParameter(jsThreadExecutor, "jsThreadExecutor");
        this.reactFrameRateCallback = reactFrameRateCallback;
        this.jsThreadExecutor = jsThreadExecutor;
        this.lastFrameTime = -1L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.lastFrameTime;
        if (j2 != -1) {
            this.reactFrameRateCallback.invoke(Double.valueOf(j - j2));
        }
        this.lastFrameTime = j;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public final void start() {
        this.jsThreadExecutor.runOnJsThread(new Runnable() { // from class: com.datadog.reactnative.FpsFrameCallback$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FpsFrameCallback.start$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0(FpsFrameCallback fpsFrameCallback) {
        try {
            Choreographer choreographer = Choreographer.getInstance();
            choreographer.removeFrameCallback(fpsFrameCallback);
            fpsFrameCallback.choreographer = choreographer;
            choreographer.postFrameCallback(fpsFrameCallback);
        } catch (IllegalStateException unused) {
        }
    }

    public final void stop() {
        this.jsThreadExecutor.runOnJsThread(new Runnable() { // from class: com.datadog.reactnative.FpsFrameCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FpsFrameCallback.stop$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$1(FpsFrameCallback fpsFrameCallback) {
        Choreographer choreographer = fpsFrameCallback.choreographer;
        if (choreographer != null) {
            choreographer.removeFrameCallback(fpsFrameCallback);
        }
    }

    public final void reset() {
        this.lastFrameTime = -1L;
    }
}
