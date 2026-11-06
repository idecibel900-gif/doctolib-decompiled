package androidx.compose.ui.geometry;

/* JADX INFO: loaded from: classes.dex */
public abstract class SizeKt {
    public static final long Size(float f, float f2) {
        return Size.m1256constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m1269toRectuvyYCjk(long j) {
        return RectKt.m1247Recttz77jQw(Offset.Companion.m1235getZeroF1C5BW0(), j);
    }

    /* JADX INFO: renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m1268getCenteruvyYCjk(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return OffsetKt.Offset(Float.intBitsToFloat((int) (j >> 32)) / 2.0f, Float.intBitsToFloat((int) (j & 4294967295L)) / 2.0f);
    }
}
