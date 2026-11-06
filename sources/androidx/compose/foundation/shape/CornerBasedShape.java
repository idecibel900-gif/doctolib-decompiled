package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: loaded from: classes.dex */
public abstract class CornerBasedShape implements Shape {
    private final CornerSize bottomEnd;
    private final CornerSize bottomStart;
    private final CornerSize topEnd;
    private final CornerSize topStart;

    public abstract CornerBasedShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    /* JADX INFO: renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public abstract Outline mo456createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection);

    public CornerBasedShape(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public final CornerSize getTopStart() {
        return this.topStart;
    }

    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final Outline mo145createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        float fMo457toPxTmRCtEA = this.topStart.mo457toPxTmRCtEA(j, density);
        float fMo457toPxTmRCtEA2 = this.topEnd.mo457toPxTmRCtEA(j, density);
        float fMo457toPxTmRCtEA3 = this.bottomEnd.mo457toPxTmRCtEA(j, density);
        float fMo457toPxTmRCtEA4 = this.bottomStart.mo457toPxTmRCtEA(j, density);
        float fM1260getMinDimensionimpl = Size.m1260getMinDimensionimpl(j);
        float f = fMo457toPxTmRCtEA + fMo457toPxTmRCtEA4;
        if (f > fM1260getMinDimensionimpl) {
            float f2 = fM1260getMinDimensionimpl / f;
            fMo457toPxTmRCtEA *= f2;
            fMo457toPxTmRCtEA4 *= f2;
        }
        float f3 = fMo457toPxTmRCtEA2 + fMo457toPxTmRCtEA3;
        if (f3 > fM1260getMinDimensionimpl) {
            float f4 = fM1260getMinDimensionimpl / f3;
            fMo457toPxTmRCtEA2 *= f4;
            fMo457toPxTmRCtEA3 *= f4;
        }
        if (fMo457toPxTmRCtEA < 0.0f || fMo457toPxTmRCtEA2 < 0.0f || fMo457toPxTmRCtEA3 < 0.0f || fMo457toPxTmRCtEA4 < 0.0f) {
            throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fMo457toPxTmRCtEA + ", topEnd = " + fMo457toPxTmRCtEA2 + ", bottomEnd = " + fMo457toPxTmRCtEA3 + ", bottomStart = " + fMo457toPxTmRCtEA4 + ")!").toString());
        }
        return mo456createOutlineLjSzlW0(j, fMo457toPxTmRCtEA, fMo457toPxTmRCtEA2, fMo457toPxTmRCtEA3, fMo457toPxTmRCtEA4, layoutDirection);
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
