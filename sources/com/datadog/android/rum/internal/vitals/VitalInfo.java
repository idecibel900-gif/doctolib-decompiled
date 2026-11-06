package com.datadog.android.rum.internal.vitals;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class VitalInfo {
    public static final Companion Companion = new Companion(null);
    private static final VitalInfo EMPTY = new VitalInfo(0, Double.MAX_VALUE, -1.7976931348623157E308d, 0.0d);
    private final double maxValue;
    private final double meanValue;
    private final double minValue;
    private final int sampleCount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VitalInfo)) {
            return false;
        }
        VitalInfo vitalInfo = (VitalInfo) obj;
        return this.sampleCount == vitalInfo.sampleCount && Double.compare(this.minValue, vitalInfo.minValue) == 0 && Double.compare(this.maxValue, vitalInfo.maxValue) == 0 && Double.compare(this.meanValue, vitalInfo.meanValue) == 0;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.sampleCount) * 31) + Double.hashCode(this.minValue)) * 31) + Double.hashCode(this.maxValue)) * 31) + Double.hashCode(this.meanValue);
    }

    public String toString() {
        return "VitalInfo(sampleCount=" + this.sampleCount + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", meanValue=" + this.meanValue + ")";
    }

    public VitalInfo(int i, double d, double d2, double d3) {
        this.sampleCount = i;
        this.minValue = d;
        this.maxValue = d2;
        this.meanValue = d3;
    }

    public final int getSampleCount() {
        return this.sampleCount;
    }

    public final double getMinValue() {
        return this.minValue;
    }

    public final double getMaxValue() {
        return this.maxValue;
    }

    public final double getMeanValue() {
        return this.meanValue;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VitalInfo getEMPTY() {
            return VitalInfo.EMPTY;
        }
    }
}
