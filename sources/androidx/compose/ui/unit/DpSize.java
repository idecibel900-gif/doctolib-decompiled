package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class DpSize {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m2573constructorimpl(0);
    private static final long Unspecified = m2573constructorimpl(9205357640488583168L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m2572boximpl(long j) {
        return new DpSize(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2573constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2574equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m2580unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2575equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2578hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2574equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2578hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2580unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m2576getHeightD9Ej5fM(long j) {
        return Dp.m2551constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m2577getWidthD9Ej5fM(long j) {
        return Dp.m2551constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m2579toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2579toStringimpl(long j) {
        if (j != 9205357640488583168L) {
            return ((Object) Dp.m2555toStringimpl(m2577getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m2555toStringimpl(m2576getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m2582getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m2581getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }
}
