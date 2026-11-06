package androidx.compose.ui.text.style;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextAlign {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Left = m2475constructorimpl(1);
    private static final int Right = m2475constructorimpl(2);
    private static final int Center = m2475constructorimpl(3);
    private static final int Justify = m2475constructorimpl(4);
    private static final int Start = m2475constructorimpl(5);
    private static final int End = m2475constructorimpl(6);
    private static final int Unspecified = m2475constructorimpl(LinearLayoutManager.INVALID_OFFSET);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m2474boximpl(int i) {
        return new TextAlign(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2475constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2476equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m2480unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2477equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2478hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2476equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2478hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2480unboximpl() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m2479toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2479toStringimpl(int i) {
        if (m2477equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m2477equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m2477equalsimpl0(i, Center)) {
            return "Center";
        }
        if (m2477equalsimpl0(i, Justify)) {
            return "Justify";
        }
        if (m2477equalsimpl0(i, Start)) {
            return "Start";
        }
        if (m2477equalsimpl0(i, End)) {
            return "End";
        }
        return m2477equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m2484getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m2485getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m2481getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m2483getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m2486getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m2482getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* JADX INFO: renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m2487getUnspecifiede0LSkKk() {
            return TextAlign.Unspecified;
        }
    }
}
