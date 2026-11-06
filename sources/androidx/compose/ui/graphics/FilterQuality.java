package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class FilterQuality {
    public static final Companion Companion = new Companion(null);
    private static final int None = m1405constructorimpl(0);
    private static final int Low = m1405constructorimpl(1);
    private static final int Medium = m1405constructorimpl(2);
    private static final int High = m1405constructorimpl(3);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1405constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1406equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1407hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-f-v9h1I, reason: not valid java name */
        public final int m1410getNonefv9h1I() {
            return FilterQuality.None;
        }

        /* JADX INFO: renamed from: getLow-f-v9h1I, reason: not valid java name */
        public final int m1409getLowfv9h1I() {
            return FilterQuality.Low;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1408toStringimpl(int i) {
        if (m1406equalsimpl0(i, None)) {
            return "None";
        }
        if (m1406equalsimpl0(i, Low)) {
            return "Low";
        }
        if (m1406equalsimpl0(i, Medium)) {
            return "Medium";
        }
        return m1406equalsimpl0(i, High) ? "High" : "Unknown";
    }
}
