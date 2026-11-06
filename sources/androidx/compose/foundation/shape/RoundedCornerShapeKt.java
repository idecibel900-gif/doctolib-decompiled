package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedCornerShapeKt {
    private static final RoundedCornerShape CircleShape = RoundedCornerShape(50);

    public static final RoundedCornerShape getCircleShape() {
        return CircleShape;
    }

    public static final RoundedCornerShape RoundedCornerShape(CornerSize cornerSize) {
        return new RoundedCornerShape(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    /* JADX INFO: renamed from: RoundedCornerShape-0680j_4, reason: not valid java name */
    public static final RoundedCornerShape m459RoundedCornerShape0680j_4(float f) {
        return RoundedCornerShape(CornerSizeKt.m458CornerSize0680j_4(f));
    }

    public static final RoundedCornerShape RoundedCornerShape(int i) {
        return RoundedCornerShape(CornerSizeKt.CornerSize(i));
    }

    /* JADX INFO: renamed from: RoundedCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ RoundedCornerShape m461RoundedCornerShapea9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m2551constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m2551constructorimpl(0);
        }
        return m460RoundedCornerShapea9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: RoundedCornerShape-a9UjIt4, reason: not valid java name */
    public static final RoundedCornerShape m460RoundedCornerShapea9UjIt4(float f, float f2, float f3, float f4) {
        return new RoundedCornerShape(CornerSizeKt.m458CornerSize0680j_4(f), CornerSizeKt.m458CornerSize0680j_4(f2), CornerSizeKt.m458CornerSize0680j_4(f3), CornerSizeKt.m458CornerSize0680j_4(f4));
    }

    public static final RoundedCornerShape RoundedCornerShape(int i, int i2, int i3, int i4) {
        return new RoundedCornerShape(CornerSizeKt.CornerSize(i), CornerSizeKt.CornerSize(i2), CornerSizeKt.CornerSize(i3), CornerSizeKt.CornerSize(i4));
    }
}
