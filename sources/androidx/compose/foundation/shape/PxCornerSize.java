package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
final class PxCornerSize implements CornerSize {
    private final float size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PxCornerSize) && Float.compare(this.size, ((PxCornerSize) obj).size) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.size);
    }

    public PxCornerSize(float f) {
        this.size = f;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo457toPxTmRCtEA(long j, Density density) {
        return this.size;
    }

    public String toString() {
        return "CornerSize(size = " + this.size + ".px)";
    }
}
