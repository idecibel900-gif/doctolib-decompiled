package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class LiveRegionMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Polite = m2087constructorimpl(0);
    private static final int Assertive = m2087constructorimpl(1);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m2086boximpl(int i) {
        return new LiveRegionMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2087constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2088equalsimpl(int i, Object obj) {
        return (obj instanceof LiveRegionMode) && i == ((LiveRegionMode) obj).m2092unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2089equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2090hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2088equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2090hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2092unboximpl() {
        return this.value;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getPolite-0phEisY, reason: not valid java name */
        public final int m2094getPolite0phEisY() {
            return LiveRegionMode.Polite;
        }

        /* JADX INFO: renamed from: getAssertive-0phEisY, reason: not valid java name */
        public final int m2093getAssertive0phEisY() {
            return LiveRegionMode.Assertive;
        }
    }

    private /* synthetic */ LiveRegionMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m2091toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2091toStringimpl(int i) {
        if (m2089equalsimpl0(i, Polite)) {
            return "Polite";
        }
        return m2089equalsimpl0(i, Assertive) ? "Assertive" : "Unknown";
    }
}
