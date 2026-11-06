package androidx.compose.foundation.lazy.grid;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSlots {
    private final int[] positions;
    private final int[] sizes;

    public LazyGridSlots(int[] iArr, int[] iArr2) {
        this.sizes = iArr;
        this.positions = iArr2;
    }

    public final int[] getSizes() {
        return this.sizes;
    }

    public final int[] getPositions() {
        return this.positions;
    }
}
