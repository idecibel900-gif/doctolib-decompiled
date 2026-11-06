package com.datadog.android.webview.internal.rum.domain;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpNativeRumViewsCache implements NativeRumViewsCache {
    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public void addToCache(Map event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache
    public String resolveLastParentIdForBrowserEvent(long j) {
        return null;
    }
}
