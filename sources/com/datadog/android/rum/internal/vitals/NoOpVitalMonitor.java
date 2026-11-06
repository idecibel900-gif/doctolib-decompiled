package com.datadog.android.rum.internal.vitals;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpVitalMonitor implements VitalMonitor {
    @Override // com.datadog.android.rum.internal.vitals.VitalObserver
    public void onNewSample(double d) {
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void register(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void unregister(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
