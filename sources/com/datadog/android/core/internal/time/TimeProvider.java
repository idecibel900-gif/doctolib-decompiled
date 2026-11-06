package com.datadog.android.core.internal.time;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeProvider {
    long getDeviceTimestamp();

    long getServerTimestamp();
}
