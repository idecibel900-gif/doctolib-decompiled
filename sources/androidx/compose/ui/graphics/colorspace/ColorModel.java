package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ColorModel {
    private static final long Cmyk;
    public static final Companion Companion = new Companion(null);
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1530constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1531equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getComponentCount-impl, reason: not valid java name */
    public static final int m1532getComponentCountimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1533hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getRgb-xdoWZVw, reason: not valid java name */
        public final long m1536getRgbxdoWZVw() {
            return ColorModel.Rgb;
        }

        /* JADX INFO: renamed from: getXyz-xdoWZVw, reason: not valid java name */
        public final long m1537getXyzxdoWZVw() {
            return ColorModel.Xyz;
        }

        /* JADX INFO: renamed from: getLab-xdoWZVw, reason: not valid java name */
        public final long m1535getLabxdoWZVw() {
            return ColorModel.Lab;
        }
    }

    static {
        long j = 3;
        long j2 = j << 32;
        Rgb = m1530constructorimpl((((long) 0) & 4294967295L) | j2);
        Xyz = m1530constructorimpl((((long) 1) & 4294967295L) | j2);
        Lab = m1530constructorimpl(j2 | (((long) 2) & 4294967295L));
        Cmyk = m1530constructorimpl((j & 4294967295L) | (((long) 4) << 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1534toStringimpl(long j) {
        if (m1531equalsimpl0(j, Rgb)) {
            return "Rgb";
        }
        if (m1531equalsimpl0(j, Xyz)) {
            return "Xyz";
        }
        if (m1531equalsimpl0(j, Lab)) {
            return "Lab";
        }
        return m1531equalsimpl0(j, Cmyk) ? "Cmyk" : "Unknown";
    }
}
