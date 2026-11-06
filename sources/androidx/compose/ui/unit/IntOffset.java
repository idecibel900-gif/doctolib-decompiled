package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class IntOffset {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m2586constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m2583boximpl(long j) {
        return new IntOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2586constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2589equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m2597unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2590equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m2591getXimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m2592getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2593hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2589equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2593hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2597unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m2584component1impl(long j) {
        return m2591getXimpl(j);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m2585component2impl(long j) {
        return m2592getYimpl(j);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m2588copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return m2587copyiSbpLlY(j, i, i2);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m2587copyiSbpLlY(long j, int i, int i2) {
        return m2586constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m2594minusqkQi6aY(long j, long j2) {
        return m2586constructorimpl((((long) (((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m2595plusqkQi6aY(long j, long j2) {
        return m2586constructorimpl((((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2596toStringimpl(long j) {
        return '(' + m2591getXimpl(j) + ", " + m2592getYimpl(j) + ')';
    }

    public String toString() {
        return m2596toStringimpl(this.packedValue);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m2598getZeronOccac() {
            return IntOffset.Zero;
        }
    }
}
