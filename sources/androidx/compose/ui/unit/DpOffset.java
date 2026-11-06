package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class DpOffset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m2565constructorimpl(0);
    private static final long Unspecified = m2565constructorimpl(9205357640488583168L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m2564boximpl(long j) {
        return new DpOffset(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2565constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2566equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m2571unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2569hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2566equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2569hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2571unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m2567getXD9Ej5fM(long j) {
        return Dp.m2551constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m2568getYD9Ej5fM(long j) {
        return Dp.m2551constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m2570toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2570toStringimpl(long j) {
        if (j != 9205357640488583168L) {
            return '(' + ((Object) Dp.m2555toStringimpl(m2567getXD9Ej5fM(j))) + ", " + ((Object) Dp.m2555toStringimpl(m2568getYD9Ej5fM(j))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
