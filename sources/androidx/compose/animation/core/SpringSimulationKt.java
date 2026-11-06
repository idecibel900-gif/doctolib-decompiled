package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpringSimulationKt {
    private static final float UNSET = Float.MAX_VALUE;

    public static final long Motion(float f, float f2) {
        return Motion.m75constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final float getUNSET() {
        return UNSET;
    }
}
