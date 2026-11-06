package com.datadog.android.rum.internal.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class Time {
    private final long nanoTime;
    private final long timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Time)) {
            return false;
        }
        Time time = (Time) obj;
        return this.timestamp == time.timestamp && this.nanoTime == time.nanoTime;
    }

    public int hashCode() {
        return (Long.hashCode(this.timestamp) * 31) + Long.hashCode(this.nanoTime);
    }

    public String toString() {
        return "Time(timestamp=" + this.timestamp + ", nanoTime=" + this.nanoTime + ")";
    }

    public Time(long j, long j2) {
        this.timestamp = j;
        this.nanoTime = j2;
    }

    public /* synthetic */ Time(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? System.currentTimeMillis() : j, (i & 2) != 0 ? System.nanoTime() : j2);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getNanoTime() {
        return this.nanoTime;
    }
}
