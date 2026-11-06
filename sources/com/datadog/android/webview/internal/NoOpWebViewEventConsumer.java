package com.datadog.android.webview.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpWebViewEventConsumer implements WebViewEventConsumer {
    @Override // com.datadog.android.webview.internal.WebViewEventConsumer
    public void consume(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
