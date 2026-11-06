package com.datadog.android.rum.internal.domain.accessibility;

import com.datadog.android.rum.internal.domain.InfoProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpAccessibilityReader implements InfoProvider {
    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public AccessibilityInfo getState() {
        return new AccessibilityInfo(null, null, null, null, null, null, null, 127, null);
    }
}
