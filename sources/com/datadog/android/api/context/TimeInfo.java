package com.datadog.android.api.context;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeInfo {
    private final long deviceTimeNs;
    private final long serverTimeNs;
    private final long serverTimeOffsetMs;
    private final long serverTimeOffsetNs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeInfo)) {
            return false;
        }
        TimeInfo timeInfo = (TimeInfo) obj;
        return this.deviceTimeNs == timeInfo.deviceTimeNs && this.serverTimeNs == timeInfo.serverTimeNs && this.serverTimeOffsetNs == timeInfo.serverTimeOffsetNs && this.serverTimeOffsetMs == timeInfo.serverTimeOffsetMs;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.deviceTimeNs) * 31) + Long.hashCode(this.serverTimeNs)) * 31) + Long.hashCode(this.serverTimeOffsetNs)) * 31) + Long.hashCode(this.serverTimeOffsetMs);
    }

    public String toString() {
        return "TimeInfo(deviceTimeNs=" + this.deviceTimeNs + ", serverTimeNs=" + this.serverTimeNs + ", serverTimeOffsetNs=" + this.serverTimeOffsetNs + ", serverTimeOffsetMs=" + this.serverTimeOffsetMs + ")";
    }

    public TimeInfo(long j, long j2, long j3, long j4) {
        this.deviceTimeNs = j;
        this.serverTimeNs = j2;
        this.serverTimeOffsetNs = j3;
        this.serverTimeOffsetMs = j4;
    }

    public final long getServerTimeOffsetNs() {
        return this.serverTimeOffsetNs;
    }

    public final long getServerTimeOffsetMs() {
        return this.serverTimeOffsetMs;
    }
}
