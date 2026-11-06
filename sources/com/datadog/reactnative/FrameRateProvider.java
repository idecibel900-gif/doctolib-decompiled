package com.datadog.reactnative;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameRateProvider {
    private final FpsFrameCallback frameCallback;

    public FrameRateProvider(Function1 reactFrameRateCallback, JsThreadExecutor jsThreadExecutor) {
        Intrinsics.checkNotNullParameter(reactFrameRateCallback, "reactFrameRateCallback");
        Intrinsics.checkNotNullParameter(jsThreadExecutor, "jsThreadExecutor");
        this.frameCallback = new FpsFrameCallback(reactFrameRateCallback, jsThreadExecutor);
    }

    public final void start() {
        this.frameCallback.reset();
        this.frameCallback.start();
    }

    public final void stop() {
        this.frameCallback.stop();
    }
}
