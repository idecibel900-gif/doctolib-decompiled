package androidx.compose.ui.graphics;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransformOriginKt {
    public static final long TransformOrigin(float f, float f2) {
        return TransformOrigin.m1520constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
