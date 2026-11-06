package com.datadog.android.rum.internal.metric.networksettled;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalResourceContext {
    private final long eventCreatedAtNanos;
    private final String resourceId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalResourceContext)) {
            return false;
        }
        InternalResourceContext internalResourceContext = (InternalResourceContext) obj;
        return Intrinsics.areEqual(this.resourceId, internalResourceContext.resourceId) && this.eventCreatedAtNanos == internalResourceContext.eventCreatedAtNanos;
    }

    public int hashCode() {
        return (this.resourceId.hashCode() * 31) + Long.hashCode(this.eventCreatedAtNanos);
    }

    public String toString() {
        return "InternalResourceContext(resourceId=" + this.resourceId + ", eventCreatedAtNanos=" + this.eventCreatedAtNanos + ")";
    }

    public InternalResourceContext(String resourceId, long j) {
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.resourceId = resourceId;
        this.eventCreatedAtNanos = j;
    }

    public final String getResourceId$dd_sdk_android_rum_release() {
        return this.resourceId;
    }

    public final long getEventCreatedAtNanos$dd_sdk_android_rum_release() {
        return this.eventCreatedAtNanos;
    }
}
