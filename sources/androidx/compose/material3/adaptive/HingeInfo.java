package androidx.compose.material3.adaptive;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class HingeInfo {
    private final Rect bounds;
    private final boolean isFlat;
    private final boolean isOccluding;
    private final boolean isSeparating;
    private final boolean isVertical;

    public HingeInfo(Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        this.bounds = rect;
        this.isFlat = z;
        this.isVertical = z2;
        this.isSeparating = z3;
        this.isOccluding = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HingeInfo)) {
            return false;
        }
        HingeInfo hingeInfo = (HingeInfo) obj;
        return Intrinsics.areEqual(this.bounds, hingeInfo.bounds) && this.isFlat == hingeInfo.isFlat && this.isVertical == hingeInfo.isVertical && this.isSeparating == hingeInfo.isSeparating && this.isOccluding == hingeInfo.isOccluding;
    }

    public int hashCode() {
        return (((((((this.bounds.hashCode() * 31) + Boolean.hashCode(this.isFlat)) * 31) + Boolean.hashCode(this.isVertical)) * 31) + Boolean.hashCode(this.isSeparating)) * 31) + Boolean.hashCode(this.isOccluding);
    }

    public String toString() {
        return "HingeInfo(bounds=" + this.bounds + ", isFlat=" + this.isFlat + ", isVertical=" + this.isVertical + ", isSeparating=" + this.isSeparating + ", isOccluding=" + this.isOccluding + ')';
    }
}
