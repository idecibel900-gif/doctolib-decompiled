package com.datadog.android.rum.internal.domain.event;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceTiming {
    private final long connectDuration;
    private final long connectStart;
    private final long dnsDuration;
    private final long dnsStart;
    private final long downloadDuration;
    private final long downloadStart;
    private final long firstByteDuration;
    private final long firstByteStart;
    private final long sslDuration;
    private final long sslStart;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceTiming)) {
            return false;
        }
        ResourceTiming resourceTiming = (ResourceTiming) obj;
        return this.dnsStart == resourceTiming.dnsStart && this.dnsDuration == resourceTiming.dnsDuration && this.connectStart == resourceTiming.connectStart && this.connectDuration == resourceTiming.connectDuration && this.sslStart == resourceTiming.sslStart && this.sslDuration == resourceTiming.sslDuration && this.firstByteStart == resourceTiming.firstByteStart && this.firstByteDuration == resourceTiming.firstByteDuration && this.downloadStart == resourceTiming.downloadStart && this.downloadDuration == resourceTiming.downloadDuration;
    }

    public int hashCode() {
        return (((((((((((((((((Long.hashCode(this.dnsStart) * 31) + Long.hashCode(this.dnsDuration)) * 31) + Long.hashCode(this.connectStart)) * 31) + Long.hashCode(this.connectDuration)) * 31) + Long.hashCode(this.sslStart)) * 31) + Long.hashCode(this.sslDuration)) * 31) + Long.hashCode(this.firstByteStart)) * 31) + Long.hashCode(this.firstByteDuration)) * 31) + Long.hashCode(this.downloadStart)) * 31) + Long.hashCode(this.downloadDuration);
    }

    public String toString() {
        return "ResourceTiming(dnsStart=" + this.dnsStart + ", dnsDuration=" + this.dnsDuration + ", connectStart=" + this.connectStart + ", connectDuration=" + this.connectDuration + ", sslStart=" + this.sslStart + ", sslDuration=" + this.sslDuration + ", firstByteStart=" + this.firstByteStart + ", firstByteDuration=" + this.firstByteDuration + ", downloadStart=" + this.downloadStart + ", downloadDuration=" + this.downloadDuration + ")";
    }

    public ResourceTiming(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.dnsStart = j;
        this.dnsDuration = j2;
        this.connectStart = j3;
        this.connectDuration = j4;
        this.sslStart = j5;
        this.sslDuration = j6;
        this.firstByteStart = j7;
        this.firstByteDuration = j8;
        this.downloadStart = j9;
        this.downloadDuration = j10;
    }

    public final long getDnsStart() {
        return this.dnsStart;
    }

    public final long getDnsDuration() {
        return this.dnsDuration;
    }

    public final long getConnectStart() {
        return this.connectStart;
    }

    public final long getConnectDuration() {
        return this.connectDuration;
    }

    public final long getSslStart() {
        return this.sslStart;
    }

    public final long getSslDuration() {
        return this.sslDuration;
    }

    public final long getFirstByteStart() {
        return this.firstByteStart;
    }

    public final long getFirstByteDuration() {
        return this.firstByteDuration;
    }

    public final long getDownloadStart() {
        return this.downloadStart;
    }

    public final long getDownloadDuration() {
        return this.downloadDuration;
    }
}
