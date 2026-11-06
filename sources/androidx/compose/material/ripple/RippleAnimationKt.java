package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public abstract class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m2551constructorimpl(10);

    /* JADX INFO: renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m674getRippleStartRadiusuvyYCjk(long j) {
        return Math.max(Size.m1261getWidthimpl(j), Size.m1259getHeightimpl(j)) * 0.3f;
    }

    /* JADX INFO: renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m673getRippleEndRadiuscSwnlzA(Density density, boolean z, long j) {
        float fM1221getDistanceimpl = Offset.m1221getDistanceimpl(OffsetKt.Offset(Size.m1261getWidthimpl(j), Size.m1259getHeightimpl(j))) / 2.0f;
        return z ? fM1221getDistanceimpl + density.mo231toPx0680j_4(BoundedRippleExtraRadius) : fM1221getDistanceimpl;
    }
}
