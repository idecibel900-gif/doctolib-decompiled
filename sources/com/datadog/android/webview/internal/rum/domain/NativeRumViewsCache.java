package com.datadog.android.webview.internal.rum.domain;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface NativeRumViewsCache {
    void addToCache(Map map);

    String resolveLastParentIdForBrowserEvent(long j);
}
