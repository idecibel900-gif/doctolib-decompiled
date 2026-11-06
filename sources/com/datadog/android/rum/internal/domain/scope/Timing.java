package com.datadog.android.rum.internal.domain.scope;

/* JADX INFO: loaded from: classes3.dex */
final class Timing {
    private final long duration;
    private final long startTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timing)) {
            return false;
        }
        Timing timing = (Timing) obj;
        return this.startTime == timing.startTime && this.duration == timing.duration;
    }

    public int hashCode() {
        return (Long.hashCode(this.startTime) * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "Timing(startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }

    public Timing(long j, long j2) {
        this.startTime = j;
        this.duration = j2;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getStartTime() {
        return this.startTime;
    }
}
