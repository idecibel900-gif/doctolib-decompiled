package androidx.compose.ui.text.style;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextDirection {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Ltr = m2489constructorimpl(1);
    private static final int Rtl = m2489constructorimpl(2);
    private static final int Content = m2489constructorimpl(3);
    private static final int ContentOrLtr = m2489constructorimpl(4);
    private static final int ContentOrRtl = m2489constructorimpl(5);
    private static final int Unspecified = m2489constructorimpl(LinearLayoutManager.INVALID_OFFSET);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextDirection m2488boximpl(int i) {
        return new TextDirection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2489constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2490equalsimpl(int i, Object obj) {
        return (obj instanceof TextDirection) && i == ((TextDirection) obj).m2494unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2491equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2492hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2490equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2492hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2494unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m2493toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2493toStringimpl(int i) {
        if (m2491equalsimpl0(i, Ltr)) {
            return "Ltr";
        }
        if (m2491equalsimpl0(i, Rtl)) {
            return "Rtl";
        }
        if (m2491equalsimpl0(i, Content)) {
            return "Content";
        }
        if (m2491equalsimpl0(i, ContentOrLtr)) {
            return "ContentOrLtr";
        }
        if (m2491equalsimpl0(i, ContentOrRtl)) {
            return "ContentOrRtl";
        }
        return m2491equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLtr-s_7X-co, reason: not valid java name */
        public final int m2498getLtrs_7Xco() {
            return TextDirection.Ltr;
        }

        /* JADX INFO: renamed from: getRtl-s_7X-co, reason: not valid java name */
        public final int m2499getRtls_7Xco() {
            return TextDirection.Rtl;
        }

        /* JADX INFO: renamed from: getContent-s_7X-co, reason: not valid java name */
        public final int m2495getContents_7Xco() {
            return TextDirection.Content;
        }

        /* JADX INFO: renamed from: getContentOrLtr-s_7X-co, reason: not valid java name */
        public final int m2496getContentOrLtrs_7Xco() {
            return TextDirection.ContentOrLtr;
        }

        /* JADX INFO: renamed from: getContentOrRtl-s_7X-co, reason: not valid java name */
        public final int m2497getContentOrRtls_7Xco() {
            return TextDirection.ContentOrRtl;
        }

        /* JADX INFO: renamed from: getUnspecified-s_7X-co, reason: not valid java name */
        public final int m2500getUnspecifieds_7Xco() {
            return TextDirection.Unspecified;
        }
    }
}
