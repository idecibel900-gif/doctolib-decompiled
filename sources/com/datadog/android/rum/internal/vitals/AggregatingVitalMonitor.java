package com.datadog.android.rum.internal.vitals;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AggregatingVitalMonitor implements VitalMonitor {
    private double lastKnownSample = Double.NaN;
    private final Map listeners = new LinkedHashMap();

    @Override // com.datadog.android.rum.internal.vitals.VitalObserver
    public void onNewSample(double d) {
        this.lastKnownSample = d;
        notifyListeners(d);
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void register(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        double d = this.lastKnownSample;
        synchronized (this.listeners) {
            this.listeners.put(listener, VitalInfo.Companion.getEMPTY());
            Unit unit = Unit.INSTANCE;
        }
        if (Double.isNaN(d)) {
            return;
        }
        notifyListener(listener, d);
    }

    @Override // com.datadog.android.rum.internal.vitals.VitalMonitor
    public void unregister(VitalListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
        }
    }

    private final void notifyListeners(double d) {
        synchronized (this.listeners) {
            try {
                Iterator it = this.listeners.keySet().iterator();
                while (it.hasNext()) {
                    notifyListener((VitalListener) it.next(), d);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void notifyListener(VitalListener vitalListener, double d) {
        VitalInfo empty = (VitalInfo) this.listeners.get(vitalListener);
        if (empty == null) {
            empty = VitalInfo.Companion.getEMPTY();
        }
        int sampleCount = empty.getSampleCount() + 1;
        VitalInfo vitalInfo = new VitalInfo(sampleCount, Math.min(d, empty.getMinValue()), Math.max(d, empty.getMaxValue()), ((((double) empty.getSampleCount()) * empty.getMeanValue()) + d) / ((double) sampleCount));
        vitalListener.onVitalUpdate(vitalInfo);
        synchronized (this.listeners) {
            this.listeners.put(vitalListener, vitalInfo);
            Unit unit = Unit.INSTANCE;
        }
    }
}
