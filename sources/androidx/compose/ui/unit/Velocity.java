package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class Velocity {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m2643constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m2642boximpl(long j) {
        return new Velocity(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2643constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2646equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m2655unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2647equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2650hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2646equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2650hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2655unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m2645copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m2644copyOhffZ5M(j, f, f2);
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m2648getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m2649getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m2651minusAH228Gc(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m2643constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m2652plusAH228Gc(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m2643constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-adjELrA, reason: not valid java name */
    public static final long m2653timesadjELrA(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return m2643constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m2644copyOhffZ5M(long j, float f, float f2) {
        return m2643constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m2656getZero9UxMQ8M() {
            return Velocity.Zero;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2654toStringimpl(long j) {
        return '(' + m2648getXimpl(j) + ", " + m2649getYimpl(j) + ") px/sec";
    }

    public String toString() {
        return m2654toStringimpl(this.packedValue);
    }
}
