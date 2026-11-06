package com.datadog.android.rum.internal.domain.battery;

import com.datadog.android.rum.internal.domain.InfoProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpBatteryInfoProvider implements InfoProvider {
    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public void cleanup() {
    }

    @Override // com.datadog.android.rum.internal.domain.InfoProvider
    public BatteryInfo getState() {
        return new BatteryInfo(null, null, 3, null);
    }
}
