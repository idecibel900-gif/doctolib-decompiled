package com.datadog.android.rum.metric.networksettled;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkSettledResourceContext {
    private final long eventCreatedAtNanos;
    private final String resourceId;
    private final Long viewCreatedTimestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkSettledResourceContext)) {
            return false;
        }
        NetworkSettledResourceContext networkSettledResourceContext = (NetworkSettledResourceContext) obj;
        return Intrinsics.areEqual(this.resourceId, networkSettledResourceContext.resourceId) && this.eventCreatedAtNanos == networkSettledResourceContext.eventCreatedAtNanos && Intrinsics.areEqual(this.viewCreatedTimestamp, networkSettledResourceContext.viewCreatedTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((this.resourceId.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos)) * 31;
        Long l = this.viewCreatedTimestamp;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "NetworkSettledResourceContext(resourceId=" + this.resourceId + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ", viewCreatedTimestamp=" + this.viewCreatedTimestamp + ")";
    }

    public NetworkSettledResourceContext(String resourceId, long j, Long l) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.eventCreatedAtNanos = j;
        this.viewCreatedTimestamp = l;
    }

    public final long getEventCreatedAtNanos() {
        return this.eventCreatedAtNanos;
    }

    public final Long getViewCreatedTimestamp() {
        return this.viewCreatedTimestamp;
    }
}
