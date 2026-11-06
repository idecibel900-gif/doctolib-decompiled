package androidx.compose.ui.node;

/* JADX INFO: loaded from: classes.dex */
abstract class DistanceAndInLayer {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1893constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m1895isInLayerimpl(long j) {
        return ((int) (j & 4294967295L)) != 0;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m1894getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: compareTo-S_HNhKs, reason: not valid java name */
    public static final int m1892compareToS_HNhKs(long j, long j2) {
        boolean zM1895isInLayerimpl = m1895isInLayerimpl(j);
        if (zM1895isInLayerimpl != m1895isInLayerimpl(j2)) {
            return zM1895isInLayerimpl ? -1 : 1;
        }
        return (int) Math.signum(m1894getDistanceimpl(j) - m1894getDistanceimpl(j2));
    }
}
