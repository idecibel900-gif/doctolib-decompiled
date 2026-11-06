package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int None = m2291constructorimpl(0);
    private static final int All = m2291constructorimpl(1);
    private static final int Weight = m2291constructorimpl(2);
    private static final int Style = m2291constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m2290boximpl(int i) {
        return new FontSynthesis(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2291constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2292equalsimpl(int i, Object obj) {
        return (obj instanceof FontSynthesis) && i == ((FontSynthesis) obj).m2298unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2293equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2294hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2292equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2294hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2298unboximpl() {
        return this.value;
    }

    private /* synthetic */ FontSynthesis(int i) {
        this.value = i;
    }

    public String toString() {
        return m2297toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2297toStringimpl(int i) {
        if (m2293equalsimpl0(i, None)) {
            return "None";
        }
        if (m2293equalsimpl0(i, All)) {
            return "All";
        }
        if (m2293equalsimpl0(i, Weight)) {
            return "Weight";
        }
        return m2293equalsimpl0(i, Style) ? "Style" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m2300getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* JADX INFO: renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m2299getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* JADX INFO: renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m2302getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }

        /* JADX INFO: renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m2301getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }
    }

    /* JADX INFO: renamed from: isWeightOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2296isWeightOnimpl$ui_text_release(int i) {
        return m2293equalsimpl0(i, All) || m2293equalsimpl0(i, Weight);
    }

    /* JADX INFO: renamed from: isStyleOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m2295isStyleOnimpl$ui_text_release(int i) {
        return m2293equalsimpl0(i, All) || m2293equalsimpl0(i, Style);
    }
}
