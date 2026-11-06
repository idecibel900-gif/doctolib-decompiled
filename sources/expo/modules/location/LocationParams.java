package expo.modules.location;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationParams {
    private final LocationAccuracy accuracy;
    private float distance;
    private long interval;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationParams)) {
            return false;
        }
        LocationParams locationParams = (LocationParams) obj;
        return this.accuracy == locationParams.accuracy && Float.compare(this.distance, locationParams.distance) == 0 && this.interval == locationParams.interval;
    }

    public int hashCode() {
        return (((this.accuracy.hashCode() * 31) + Float.hashCode(this.distance)) * 31) + Long.hashCode(this.interval);
    }

    public String toString() {
        return "LocationParams(accuracy=" + this.accuracy + ", distance=" + this.distance + ", interval=" + this.interval + ")";
    }

    public LocationParams(LocationAccuracy accuracy, float f, long j) {
        Intrinsics.checkNotNullParameter(accuracy, "accuracy");
        this.accuracy = accuracy;
        this.distance = f;
        this.interval = j;
    }

    public final float getDistance() {
        return this.distance;
    }

    public final void setDistance(float f) {
        this.distance = f;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final void setInterval(long j) {
        this.interval = j;
    }
}
