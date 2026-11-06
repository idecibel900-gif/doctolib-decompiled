package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatFloatPair {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m21constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m20constructorimpl(float f, float f2) {
        return m21constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
