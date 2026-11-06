package com.datadog.android.rum.internal.domain.display;

import com.datadog.android.rum.internal.domain.InfoProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpDisplayInfoProvider implements InfoProvider {
    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public DisplayInfo getState() {
        return new DisplayInfo(null, 1, null);
    }
}
