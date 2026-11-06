package com.datadog.android.rum.internal.vitals;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumViewType;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class VitalReaderRunnable implements Runnable {
    private final ScheduledExecutorService executor;
    private final VitalObserver observer;
    private final long periodMs;
    private final VitalReader reader;
    private final FeatureSdkCore sdkCore;

    public VitalReaderRunnable(FeatureSdkCore sdkCore, VitalReader reader, VitalObserver observer, ScheduledExecutorService executor, long j) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.sdkCore = sdkCore;
        this.reader = reader;
        this.observer = observer;
        this.executor = executor;
        this.periodMs = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        Double vitalData;
        if (RumContext.Companion.fromFeatureContext(this.sdkCore.getFeatureContext("rum")).getViewType() == RumViewType.FOREGROUND && (vitalData = this.reader.readVitalData()) != null) {
            this.observer.onNewSample(vitalData.doubleValue());
        }
        ConcurrencyExtKt.scheduleSafe(this.executor, "Vitals monitoring", this.periodMs, TimeUnit.MILLISECONDS, this.sdkCore.getInternalLogger(), this);
    }
}
