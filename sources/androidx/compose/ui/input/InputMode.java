package androidx.compose.ui.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class InputMode {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Touch = m1682constructorimpl(1);
    private static final int Keyboard = m1682constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InputMode m1681boximpl(int i) {
        return new InputMode(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1682constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1683equalsimpl(int i, Object obj) {
        return (obj instanceof InputMode) && i == ((InputMode) obj).m1687unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1684equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1685hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m1683equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1685hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1687unboximpl() {
        return this.value;
    }

    private /* synthetic */ InputMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m1686toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1686toStringimpl(int i) {
        if (m1684equalsimpl0(i, Touch)) {
            return "Touch";
        }
        return m1684equalsimpl0(i, Keyboard) ? "Keyboard" : "Error";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getTouch-aOaMEAU, reason: not valid java name */
        public final int m1689getTouchaOaMEAU() {
            return InputMode.Touch;
        }

        /* JADX INFO: renamed from: getKeyboard-aOaMEAU, reason: not valid java name */
        public final int m1688getKeyboardaOaMEAU() {
            return InputMode.Keyboard;
        }
    }
}
