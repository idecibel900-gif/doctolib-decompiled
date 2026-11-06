package com.lyft.kronos;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KronosTime {
    private final long posixTimeMs;
    private final Long timeSinceLastNtpSyncMs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KronosTime)) {
            return false;
        }
        KronosTime kronosTime = (KronosTime) obj;
        return this.posixTimeMs == kronosTime.posixTimeMs && Intrinsics.areEqual(this.timeSinceLastNtpSyncMs, kronosTime.timeSinceLastNtpSyncMs);
    }

    public int hashCode() {
        long j = this.posixTimeMs;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.timeSinceLastNtpSyncMs;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "KronosTime(posixTimeMs=" + this.posixTimeMs + ", timeSinceLastNtpSyncMs=" + this.timeSinceLastNtpSyncMs + ")";
    }

    public KronosTime(long j, Long l) {
        this.posixTimeMs = j;
        this.timeSinceLastNtpSyncMs = l;
    }

    public final long getPosixTimeMs() {
        return this.posixTimeMs;
    }
}
