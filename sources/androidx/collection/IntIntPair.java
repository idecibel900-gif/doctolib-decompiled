package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntIntPair {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m23constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: getFirst-impl, reason: not valid java name */
    public static final int m24getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: getSecond-impl, reason: not valid java name */
    public static final int m25getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m22constructorimpl(int i, int i2) {
        return m23constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }
}
