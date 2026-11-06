package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class OffsetKt {
    /* JADX INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m1236isFinitek4lQ0M(long j) {
        long j2 = (j & 9187343241974906880L) ^ 9187343241974906880L;
        return (((~j2) & (j2 - 4294967297L)) & (-9223372034707292160L)) == 0;
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1237isSpecifiedk4lQ0M(long j) {
        return (j & 9223372034707292159L) != 9205357640488583168L;
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1238isUnspecifiedk4lQ0M(long j) {
        return (j & 9223372034707292159L) == 9205357640488583168L;
    }

    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m1239lerpWko1d7g(long j, long j2, float f) {
        float fLerp = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 >> 32)), f);
        float fLerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 & 4294967295L)), f);
        return Offset.m1215constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L));
    }

    public static final long Offset(float f, float f2) {
        return Offset.m1215constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
