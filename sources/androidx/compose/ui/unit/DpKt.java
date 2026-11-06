package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class DpKt {
    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m2561DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m2565constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m2562DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m2573constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m2563lerpMdfbLM(float f, float f2, float f3) {
        return Dp.m2551constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }
}
