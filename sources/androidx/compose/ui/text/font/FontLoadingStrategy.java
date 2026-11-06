package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontLoadingStrategy {
    public static final Companion Companion = new Companion(null);
    private static final int Blocking = m2273constructorimpl(0);
    private static final int OptionalLocal = m2273constructorimpl(1);
    private static final int Async = m2273constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2273constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2274equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2275hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2276toStringimpl(int i) {
        if (m2274equalsimpl0(i, Blocking)) {
            return "Blocking";
        }
        if (m2274equalsimpl0(i, OptionalLocal)) {
            return "Optional";
        }
        if (m2274equalsimpl0(i, Async)) {
            return "Async";
        }
        return "Invalid(value=" + i + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getBlocking-PKNRLFQ, reason: not valid java name */
        public final int m2278getBlockingPKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        /* JADX INFO: renamed from: getOptionalLocal-PKNRLFQ, reason: not valid java name */
        public final int m2279getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }

        /* JADX INFO: renamed from: getAsync-PKNRLFQ, reason: not valid java name */
        public final int m2277getAsyncPKNRLFQ() {
            return FontLoadingStrategy.Async;
        }
    }
}
