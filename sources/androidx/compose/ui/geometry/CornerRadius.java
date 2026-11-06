package androidx.compose.ui.geometry;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class CornerRadius {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1207constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1208equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1211hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m1209getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m1210getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m1213getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1212toStringimpl(long j) {
        if (m1209getXimpl(j) == m1210getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m1209getXimpl(j), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m1209getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1210getYimpl(j), 1) + ')';
    }
}
