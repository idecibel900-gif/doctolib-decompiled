package com.datadog.reactnative;

import com.facebook.react.bridge.UiThreadUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactUiThreadExecutor implements UiThreadExecutor {
    @Override // com.datadog.reactnative.UiThreadExecutor
    public void runOnUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        UiThreadUtil.runOnUiThread(runnable);
    }
}
