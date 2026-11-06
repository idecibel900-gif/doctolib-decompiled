package com.datadog.android.core.internal.time;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpTimeProvider implements TimeProvider {
    @Override // com.datadog.android.core.internal.time.TimeProvider
    public long getDeviceTimestamp() {
        return System.currentTimeMillis();
    }

    @Override // com.datadog.android.core.internal.time.TimeProvider
    public long getServerTimestamp() {
        return System.currentTimeMillis();
    }
}
