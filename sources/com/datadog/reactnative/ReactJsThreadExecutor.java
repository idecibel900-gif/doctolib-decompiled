package com.datadog.reactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactJsThreadExecutor implements JsThreadExecutor {
    private final ReactApplicationContext reactContext;

    public ReactJsThreadExecutor(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.datadog.reactnative.JsThreadExecutor
    public void runOnJsThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.reactContext.runOnJSQueueThread(runnable);
    }
}
