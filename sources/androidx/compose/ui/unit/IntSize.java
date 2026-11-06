package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class IntSize {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m2605constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntSize m2604boximpl(long j) {
        return new IntSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2605constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2606equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m2612unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2607equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final int m2608getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final int m2609getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2610hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2606equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2610hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2612unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2611toStringimpl(long j) {
        return m2609getWidthimpl(j) + " x " + m2608getHeightimpl(j);
    }

    public String toString() {
        return m2611toStringimpl(this.packedValue);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-YbymL2g, reason: not valid java name */
        public final long m2613getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }
}
