package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class BlendMode {
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m1312constructorimpl(0);
    private static final int Src = m1312constructorimpl(1);
    private static final int Dst = m1312constructorimpl(2);
    private static final int SrcOver = m1312constructorimpl(3);
    private static final int DstOver = m1312constructorimpl(4);
    private static final int SrcIn = m1312constructorimpl(5);
    private static final int DstIn = m1312constructorimpl(6);
    private static final int SrcOut = m1312constructorimpl(7);
    private static final int DstOut = m1312constructorimpl(8);
    private static final int SrcAtop = m1312constructorimpl(9);
    private static final int DstAtop = m1312constructorimpl(10);
    private static final int Xor = m1312constructorimpl(11);
    private static final int Plus = m1312constructorimpl(12);
    private static final int Modulate = m1312constructorimpl(13);
    private static final int Screen = m1312constructorimpl(14);
    private static final int Overlay = m1312constructorimpl(15);
    private static final int Darken = m1312constructorimpl(16);
    private static final int Lighten = m1312constructorimpl(17);
    private static final int ColorDodge = m1312constructorimpl(18);
    private static final int ColorBurn = m1312constructorimpl(19);
    private static final int Hardlight = m1312constructorimpl(20);
    private static final int Softlight = m1312constructorimpl(21);
    private static final int Difference = m1312constructorimpl(22);
    private static final int Exclusion = m1312constructorimpl(23);
    private static final int Multiply = m1312constructorimpl(24);
    private static final int Hue = m1312constructorimpl(25);
    private static final int Saturation = m1312constructorimpl(26);
    private static final int Color = m1312constructorimpl(27);
    private static final int Luminosity = m1312constructorimpl(28);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1312constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1313equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1314hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m1316getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* JADX INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m1339getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* JADX INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m1322getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* JADX INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m1343getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* JADX INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m1326getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* JADX INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m1341getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* JADX INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m1324getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* JADX INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m1342getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* JADX INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m1325getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* JADX INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m1340getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* JADX INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m1323getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* JADX INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m1344getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* JADX INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m1335getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* JADX INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m1332getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* JADX INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m1337getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* JADX INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m1334getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* JADX INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m1320getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* JADX INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m1330getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* JADX INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m1319getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* JADX INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m1318getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* JADX INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m1328getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* JADX INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m1338getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* JADX INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m1321getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* JADX INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m1327getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* JADX INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m1333getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* JADX INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m1329getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* JADX INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m1336getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* JADX INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m1317getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* JADX INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m1331getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1315toStringimpl(int i) {
        if (m1313equalsimpl0(i, Clear)) {
            return "Clear";
        }
        if (m1313equalsimpl0(i, Src)) {
            return "Src";
        }
        if (m1313equalsimpl0(i, Dst)) {
            return "Dst";
        }
        if (m1313equalsimpl0(i, SrcOver)) {
            return "SrcOver";
        }
        if (m1313equalsimpl0(i, DstOver)) {
            return "DstOver";
        }
        if (m1313equalsimpl0(i, SrcIn)) {
            return "SrcIn";
        }
        if (m1313equalsimpl0(i, DstIn)) {
            return "DstIn";
        }
        if (m1313equalsimpl0(i, SrcOut)) {
            return "SrcOut";
        }
        if (m1313equalsimpl0(i, DstOut)) {
            return "DstOut";
        }
        if (m1313equalsimpl0(i, SrcAtop)) {
            return "SrcAtop";
        }
        if (m1313equalsimpl0(i, DstAtop)) {
            return "DstAtop";
        }
        if (m1313equalsimpl0(i, Xor)) {
            return "Xor";
        }
        if (m1313equalsimpl0(i, Plus)) {
            return "Plus";
        }
        if (m1313equalsimpl0(i, Modulate)) {
            return "Modulate";
        }
        if (m1313equalsimpl0(i, Screen)) {
            return "Screen";
        }
        if (m1313equalsimpl0(i, Overlay)) {
            return "Overlay";
        }
        if (m1313equalsimpl0(i, Darken)) {
            return "Darken";
        }
        if (m1313equalsimpl0(i, Lighten)) {
            return "Lighten";
        }
        if (m1313equalsimpl0(i, ColorDodge)) {
            return "ColorDodge";
        }
        if (m1313equalsimpl0(i, ColorBurn)) {
            return "ColorBurn";
        }
        if (m1313equalsimpl0(i, Hardlight)) {
            return "HardLight";
        }
        if (m1313equalsimpl0(i, Softlight)) {
            return "Softlight";
        }
        if (m1313equalsimpl0(i, Difference)) {
            return "Difference";
        }
        if (m1313equalsimpl0(i, Exclusion)) {
            return "Exclusion";
        }
        if (m1313equalsimpl0(i, Multiply)) {
            return "Multiply";
        }
        if (m1313equalsimpl0(i, Hue)) {
            return "Hue";
        }
        if (m1313equalsimpl0(i, Saturation)) {
            return "Saturation";
        }
        if (m1313equalsimpl0(i, Color)) {
            return "Color";
        }
        return m1313equalsimpl0(i, Luminosity) ? "Luminosity" : "Unknown";
    }
}
