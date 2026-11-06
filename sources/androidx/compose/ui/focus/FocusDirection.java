package androidx.compose.ui.focus;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class FocusDirection {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Next = m1153constructorimpl(1);
    private static final int Previous = m1153constructorimpl(2);
    private static final int Left = m1153constructorimpl(3);
    private static final int Right = m1153constructorimpl(4);
    private static final int Up = m1153constructorimpl(5);
    private static final int Down = m1153constructorimpl(6);
    private static final int Enter = m1153constructorimpl(7);
    private static final int Exit = m1153constructorimpl(8);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m1152boximpl(int i) {
        return new FocusDirection(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1153constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1154equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m1158unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1155equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1156hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m1154equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1156hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1158unboximpl() {
        return this.value;
    }

    private /* synthetic */ FocusDirection(int i) {
        this.value = i;
    }

    public String toString() {
        return m1157toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1157toStringimpl(int i) {
        if (m1155equalsimpl0(i, Next)) {
            return "Next";
        }
        if (m1155equalsimpl0(i, Previous)) {
            return "Previous";
        }
        if (m1155equalsimpl0(i, Left)) {
            return "Left";
        }
        if (m1155equalsimpl0(i, Right)) {
            return "Right";
        }
        if (m1155equalsimpl0(i, Up)) {
            return "Up";
        }
        if (m1155equalsimpl0(i, Down)) {
            return "Down";
        }
        if (m1155equalsimpl0(i, Enter)) {
            return "Enter";
        }
        if (m1155equalsimpl0(i, Exit)) {
            return "Exit";
        }
        return "Invalid FocusDirection";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m1163getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* JADX INFO: renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m1164getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* JADX INFO: renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m1162getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* JADX INFO: renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m1165getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* JADX INFO: renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m1166getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        /* JADX INFO: renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m1159getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* JADX INFO: renamed from: getEnter-dhqQ-8s, reason: not valid java name */
        public final int m1160getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        /* JADX INFO: renamed from: getExit-dhqQ-8s, reason: not valid java name */
        public final int m1161getExitdhqQ8s() {
            return FocusDirection.Exit;
        }
    }
}
