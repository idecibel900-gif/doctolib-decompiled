package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public interface GridCells {
    List calculateCrossAxisCellSizes(Density density, int i, int i2);

    public static final class Adaptive implements GridCells {
        private final float minSize;

        public /* synthetic */ Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        private Adaptive(float f) {
            this.minSize = f;
            if (Dp.m2550compareTo0680j_4(f, Dp.m2551constructorimpl(0)) > 0) {
                return;
            }
            throw new IllegalArgumentException(("Provided min size " + ((Object) Dp.m2555toStringimpl(f)) + " should be larger than zero.").toString());
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List calculateCrossAxisCellSizes(Density density, int i, int i2) {
            return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i, Math.max((i + i2) / (density.mo225roundToPx0680j_4(this.minSize) + i2), 1), i2);
        }

        public int hashCode() {
            return Dp.m2554hashCodeimpl(this.minSize);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Adaptive) && Dp.m2553equalsimpl0(this.minSize, ((Adaptive) obj).minSize);
        }
    }
}
