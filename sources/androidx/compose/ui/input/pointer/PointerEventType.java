package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class PointerEventType {
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m1755constructorimpl(0);
    private static final int Press = m1755constructorimpl(1);
    private static final int Release = m1755constructorimpl(2);
    private static final int Move = m1755constructorimpl(3);
    private static final int Enter = m1755constructorimpl(4);
    private static final int Exit = m1755constructorimpl(5);
    private static final int Scroll = m1755constructorimpl(6);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m1755constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1756equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m1763getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }

        /* JADX INFO: renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m1760getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* JADX INFO: renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m1761getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* JADX INFO: renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m1759getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* JADX INFO: renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m1757getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* JADX INFO: renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m1758getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* JADX INFO: renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m1762getScroll7fucELk() {
            return PointerEventType.Scroll;
        }
    }
}
