package com.datadog.android.rum.internal.metric;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewInitializationMetricsState {
    private final ViewInitializationMetricsConfig config;
    private final Long initializationTime;
    private final NoValueReason noValueReason;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInitializationMetricsState)) {
            return false;
        }
        ViewInitializationMetricsState viewInitializationMetricsState = (ViewInitializationMetricsState) obj;
        return Intrinsics.areEqual(this.initializationTime, viewInitializationMetricsState.initializationTime) && this.config == viewInitializationMetricsState.config && Intrinsics.areEqual(this.noValueReason, viewInitializationMetricsState.noValueReason);
    }

    public int hashCode() {
        Long l = this.initializationTime;
        int iHashCode = (((l == null ? 0 : l.hashCode()) * 31) + this.config.hashCode()) * 31;
        NoValueReason noValueReason = this.noValueReason;
        return iHashCode + (noValueReason != null ? noValueReason.hashCode() : 0);
    }

    public String toString() {
        return "ViewInitializationMetricsState(initializationTime=" + this.initializationTime + ", config=" + this.config + ", noValueReason=" + this.noValueReason + ")";
    }

    public ViewInitializationMetricsState(Long l, ViewInitializationMetricsConfig config, NoValueReason noValueReason) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.initializationTime = l;
        this.config = config;
        this.noValueReason = noValueReason;
    }

    public final Long getInitializationTime() {
        return this.initializationTime;
    }

    public final ViewInitializationMetricsConfig getConfig() {
        return this.config;
    }

    public final NoValueReason getNoValueReason() {
        return this.noValueReason;
    }
}
