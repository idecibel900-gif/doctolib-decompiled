package com.facebook.react.views.scroll;

import com.facebook.common.logging.FLog;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class Interval {
    private final int end;
    private final String id;
    private final int start;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) obj;
        return this.start == interval.start && this.end == interval.end && Intrinsics.areEqual(this.id, interval.id);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "Interval(start=" + this.start + ", end=" + this.end + ", id=" + this.id + ")";
    }

    public Interval(int i, int i2, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.start = i;
        this.end = i2;
        this.id = id;
    }

    public final int getEnd() {
        return this.end;
    }

    public final String getId() {
        return this.id;
    }

    public final int getStart() {
        return this.start;
    }

    public final boolean intersects(Interval other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (VirtualViewContainerKt.getIS_DEBUG_BUILD() && ReactNativeFeatureFlags.enableVirtualViewDebugFeatures()) {
            FLog.d("VirtualViewContainerStateExperimental:Interval: intersect", this.id + ":(" + this.start + ", " + this.end + ") vs " + other.id + ":(" + other.start + ", " + other.end + ")");
        }
        return this.start < other.end && other.start < this.end;
    }
}
