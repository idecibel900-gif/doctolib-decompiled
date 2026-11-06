package com.datadog.android.core.internal.metrics;

/* JADX INFO: loaded from: classes3.dex */
public final class BatchClosedMetadata {
    private final long eventsCount;
    private final boolean forcedNew;
    private final long lastTimeWasUsedInMs;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatchClosedMetadata)) {
            return false;
        }
        BatchClosedMetadata batchClosedMetadata = (BatchClosedMetadata) obj;
        return this.lastTimeWasUsedInMs == batchClosedMetadata.lastTimeWasUsedInMs && this.forcedNew == batchClosedMetadata.forcedNew && this.eventsCount == batchClosedMetadata.eventsCount;
    }

    public int hashCode() {
        return (((Long.hashCode(this.lastTimeWasUsedInMs) * 31) + Boolean.hashCode(this.forcedNew)) * 31) + Long.hashCode(this.eventsCount);
    }

    public String toString() {
        return "BatchClosedMetadata(lastTimeWasUsedInMs=" + this.lastTimeWasUsedInMs + ", forcedNew=" + this.forcedNew + ", eventsCount=" + this.eventsCount + ")";
    }

    public BatchClosedMetadata(long j, boolean z, long j2) {
        this.lastTimeWasUsedInMs = j;
        this.forcedNew = z;
        this.eventsCount = j2;
    }

    public final long getLastTimeWasUsedInMs$dd_sdk_android_core_release() {
        return this.lastTimeWasUsedInMs;
    }

    public final boolean getForcedNew$dd_sdk_android_core_release() {
        return this.forcedNew;
    }

    public final long getEventsCount$dd_sdk_android_core_release() {
        return this.eventsCount;
    }
}
