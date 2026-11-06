package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class StrokeCap {
    public static final Companion Companion = new Companion(null);
    private static final int Butt = m1496constructorimpl(0);
    private static final int Round = m1496constructorimpl(1);
    private static final int Square = m1496constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1496constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1497equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1498hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getButt-KaPHkGw, reason: not valid java name */
        public final int m1500getButtKaPHkGw() {
            return StrokeCap.Butt;
        }

        /* JADX INFO: renamed from: getRound-KaPHkGw, reason: not valid java name */
        public final int m1501getRoundKaPHkGw() {
            return StrokeCap.Round;
        }

        /* JADX INFO: renamed from: getSquare-KaPHkGw, reason: not valid java name */
        public final int m1502getSquareKaPHkGw() {
            return StrokeCap.Square;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1499toStringimpl(int i) {
        if (m1497equalsimpl0(i, Butt)) {
            return "Butt";
        }
        if (m1497equalsimpl0(i, Round)) {
            return "Round";
        }
        return m1497equalsimpl0(i, Square) ? "Square" : "Unknown";
    }
}
