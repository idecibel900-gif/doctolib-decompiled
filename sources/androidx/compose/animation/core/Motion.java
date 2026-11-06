package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public abstract class Motion {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m75constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m76getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getVelocity-impl, reason: not valid java name */
    public static final float m77getVelocityimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }
}
