package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardType {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unspecified = m2358constructorimpl(0);
    private static final int Text = m2358constructorimpl(1);
    private static final int Ascii = m2358constructorimpl(2);
    private static final int Number = m2358constructorimpl(3);
    private static final int Phone = m2358constructorimpl(4);
    private static final int Uri = m2358constructorimpl(5);
    private static final int Email = m2358constructorimpl(6);
    private static final int Password = m2358constructorimpl(7);
    private static final int NumberPassword = m2358constructorimpl(8);
    private static final int Decimal = m2358constructorimpl(9);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardType m2357boximpl(int i) {
        return new KeyboardType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2358constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2359equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardType) && i == ((KeyboardType) obj).m2363unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2360equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2361hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2359equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2361hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2363unboximpl() {
        return this.value;
    }

    private /* synthetic */ KeyboardType(int i) {
        this.value = i;
    }

    public String toString() {
        return m2362toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2362toStringimpl(int i) {
        if (m2360equalsimpl0(i, Unspecified)) {
            return "Unspecified";
        }
        if (m2360equalsimpl0(i, Text)) {
            return "Text";
        }
        if (m2360equalsimpl0(i, Ascii)) {
            return "Ascii";
        }
        if (m2360equalsimpl0(i, Number)) {
            return "Number";
        }
        if (m2360equalsimpl0(i, Phone)) {
            return "Phone";
        }
        if (m2360equalsimpl0(i, Uri)) {
            return "Uri";
        }
        if (m2360equalsimpl0(i, Email)) {
            return "Email";
        }
        if (m2360equalsimpl0(i, Password)) {
            return "Password";
        }
        if (m2360equalsimpl0(i, NumberPassword)) {
            return "NumberPassword";
        }
        return m2360equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-PjHm6EE, reason: not valid java name */
        public final int m2372getUnspecifiedPjHm6EE() {
            return KeyboardType.Unspecified;
        }

        /* JADX INFO: renamed from: getText-PjHm6EE, reason: not valid java name */
        public final int m2371getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* JADX INFO: renamed from: getAscii-PjHm6EE, reason: not valid java name */
        public final int m2364getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* JADX INFO: renamed from: getNumber-PjHm6EE, reason: not valid java name */
        public final int m2367getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* JADX INFO: renamed from: getPhone-PjHm6EE, reason: not valid java name */
        public final int m2370getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* JADX INFO: renamed from: getUri-PjHm6EE, reason: not valid java name */
        public final int m2373getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        /* JADX INFO: renamed from: getEmail-PjHm6EE, reason: not valid java name */
        public final int m2366getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* JADX INFO: renamed from: getPassword-PjHm6EE, reason: not valid java name */
        public final int m2369getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* JADX INFO: renamed from: getNumberPassword-PjHm6EE, reason: not valid java name */
        public final int m2368getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* JADX INFO: renamed from: getDecimal-PjHm6EE, reason: not valid java name */
        public final int m2365getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }
    }
}
