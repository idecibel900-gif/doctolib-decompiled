package androidx.compose.ui.input.pointer;

/* JADX INFO: loaded from: classes.dex */
public final class PointerKeyboardModifiers {
    private final int packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerKeyboardModifiers m1794boximpl(int i) {
        return new PointerKeyboardModifiers(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1795constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1796equalsimpl(int i, Object obj) {
        return (obj instanceof PointerKeyboardModifiers) && i == ((PointerKeyboardModifiers) obj).m1799unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1797hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1798toStringimpl(int i) {
        return "PointerKeyboardModifiers(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1796equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1797hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1798toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1799unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ PointerKeyboardModifiers(int i) {
        this.packedValue = i;
    }
}
