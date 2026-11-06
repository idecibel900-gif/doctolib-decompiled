package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ImeAction {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unspecified = m2326constructorimpl(-1);
    private static final int Default = m2326constructorimpl(1);
    private static final int None = m2326constructorimpl(0);
    private static final int Go = m2326constructorimpl(2);
    private static final int Search = m2326constructorimpl(3);
    private static final int Send = m2326constructorimpl(4);
    private static final int Previous = m2326constructorimpl(5);
    private static final int Next = m2326constructorimpl(6);
    private static final int Done = m2326constructorimpl(7);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m2325boximpl(int i) {
        return new ImeAction(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2326constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2327equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).m2331unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2328equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2329hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2327equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2329hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2331unboximpl() {
        return this.value;
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    public String toString() {
        return m2330toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2330toStringimpl(int i) {
        if (m2328equalsimpl0(i, Unspecified)) {
            return "Unspecified";
        }
        if (m2328equalsimpl0(i, None)) {
            return "None";
        }
        if (m2328equalsimpl0(i, Default)) {
            return "Default";
        }
        if (m2328equalsimpl0(i, Go)) {
            return "Go";
        }
        if (m2328equalsimpl0(i, Search)) {
            return "Search";
        }
        if (m2328equalsimpl0(i, Send)) {
            return "Send";
        }
        if (m2328equalsimpl0(i, Previous)) {
            return "Previous";
        }
        if (m2328equalsimpl0(i, Next)) {
            return "Next";
        }
        return m2328equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-eUduSuo, reason: not valid java name */
        public final int m2340getUnspecifiedeUduSuo() {
            return ImeAction.Unspecified;
        }

        /* JADX INFO: renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m2332getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* JADX INFO: renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m2336getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* JADX INFO: renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m2334getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* JADX INFO: renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m2338getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* JADX INFO: renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m2339getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* JADX INFO: renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m2337getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* JADX INFO: renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m2335getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* JADX INFO: renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m2333getDoneeUduSuo() {
            return ImeAction.Done;
        }
    }
}
