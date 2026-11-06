package androidx.compose.ui.geometry;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class Size {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m1256constructorimpl(0);
    private static final long Unspecified = m1256constructorimpl(9205357640488583168L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m1255boximpl(long j) {
        return new Size(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1256constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1257equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).m1265unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1258equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1262hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m1257equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1262hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1265unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ Size(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: getWidth-impl, reason: not valid java name */
    public static final float m1261getWidthimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getHeight-impl, reason: not valid java name */
    public static final float m1259getHeightimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m1267getZeroNHjbRc() {
            return Size.Zero;
        }

        /* JADX INFO: renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m1266getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m1263isEmptyimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        long j2 = j & (~((((-9223372034707292160L) & j) >>> 31) * ((long) (-1))));
        return ((j2 & 4294967295L) & (j2 >>> 32)) == 0;
    }

    /* JADX INFO: renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m1260getMinDimensionimpl(long j) {
        if (j == 9205357640488583168L) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        return Math.min(Float.intBitsToFloat((int) ((j >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j & 2147483647L)));
    }

    public String toString() {
        return m1264toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1264toStringimpl(long j) {
        if (j != 9205357640488583168L) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m1261getWidthimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1259getHeightimpl(j), 1) + ')';
        }
        return "Size.Unspecified";
    }
}
