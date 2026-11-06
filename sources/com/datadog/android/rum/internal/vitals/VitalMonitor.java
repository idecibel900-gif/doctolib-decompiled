package com.datadog.android.rum.internal.vitals;

/* JADX INFO: loaded from: classes3.dex */
public interface VitalMonitor extends VitalObserver {
    void register(VitalListener vitalListener);

    void unregister(VitalListener vitalListener);
}
