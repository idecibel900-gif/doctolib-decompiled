package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ImageBitmapConfig {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Argb8888 = m1421constructorimpl(0);
    private static final int Alpha8 = m1421constructorimpl(1);
    private static final int Rgb565 = m1421constructorimpl(2);
    private static final int F16 = m1421constructorimpl(3);
    private static final int Gpu = m1421constructorimpl(4);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m1420boximpl(int i) {
        return new ImageBitmapConfig(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1421constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1422equalsimpl(int i, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i == ((ImageBitmapConfig) obj).m1426unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1423equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1424hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m1422equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1424hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1426unboximpl() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getArgb8888-_sVssgQ, reason: not valid java name */
        public final int m1428getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* JADX INFO: renamed from: getAlpha8-_sVssgQ, reason: not valid java name */
        public final int m1427getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* JADX INFO: renamed from: getRgb565-_sVssgQ, reason: not valid java name */
        public final int m1431getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }

        /* JADX INFO: renamed from: getF16-_sVssgQ, reason: not valid java name */
        public final int m1429getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* JADX INFO: renamed from: getGpu-_sVssgQ, reason: not valid java name */
        public final int m1430getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i) {
        this.value = i;
    }

    public String toString() {
        return m1425toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1425toStringimpl(int i) {
        if (m1423equalsimpl0(i, Argb8888)) {
            return "Argb8888";
        }
        if (m1423equalsimpl0(i, Alpha8)) {
            return "Alpha8";
        }
        if (m1423equalsimpl0(i, Rgb565)) {
            return "Rgb565";
        }
        if (m1423equalsimpl0(i, F16)) {
            return "F16";
        }
        return m1423equalsimpl0(i, Gpu) ? "Gpu" : "Unknown";
    }
}
