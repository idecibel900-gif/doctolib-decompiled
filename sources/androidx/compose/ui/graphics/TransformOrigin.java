package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TransformOrigin {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m1519boximpl(long j) {
        return new TransformOrigin(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1520constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1521equalsimpl(long j, Object obj) {
        return (obj instanceof TransformOrigin) && j == ((TransformOrigin) obj).m1527unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1522equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1525hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1526toStringimpl(long j) {
        return "TransformOrigin(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1521equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1525hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1526toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1527unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: getPivotFractionX-impl, reason: not valid java name */
    public static final float m1523getPivotFractionXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m1524getPivotFractionYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    private /* synthetic */ TransformOrigin(long j) {
        this.packedValue = j;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getCenter-SzJe1aQ, reason: not valid java name */
        public final long m1528getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }
    }
}
