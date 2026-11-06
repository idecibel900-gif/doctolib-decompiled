package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class StrokeJoin {
    public static final Companion Companion = new Companion(null);
    private static final int Miter = m1503constructorimpl(0);
    private static final int Round = m1503constructorimpl(1);
    private static final int Bevel = m1503constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1503constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1504equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1505hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getMiter-LxFBmk8, reason: not valid java name */
        public final int m1508getMiterLxFBmk8() {
            return StrokeJoin.Miter;
        }

        /* JADX INFO: renamed from: getRound-LxFBmk8, reason: not valid java name */
        public final int m1509getRoundLxFBmk8() {
            return StrokeJoin.Round;
        }

        /* JADX INFO: renamed from: getBevel-LxFBmk8, reason: not valid java name */
        public final int m1507getBevelLxFBmk8() {
            return StrokeJoin.Bevel;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1506toStringimpl(int i) {
        if (m1504equalsimpl0(i, Miter)) {
            return "Miter";
        }
        if (m1504equalsimpl0(i, Round)) {
            return "Round";
        }
        return m1504equalsimpl0(i, Bevel) ? "Bevel" : "Unknown";
    }
}
