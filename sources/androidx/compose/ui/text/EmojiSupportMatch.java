package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class EmojiSupportMatch {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Default = m2138constructorimpl(0);
    private static final int None = m2138constructorimpl(1);
    private static final int All = m2138constructorimpl(2);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ EmojiSupportMatch m2137boximpl(int i) {
        return new EmojiSupportMatch(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2138constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2139equalsimpl(int i, Object obj) {
        return (obj instanceof EmojiSupportMatch) && i == ((EmojiSupportMatch) obj).m2143unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2140equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2141hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2139equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2141hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2143unboximpl() {
        return this.value;
    }

    private /* synthetic */ EmojiSupportMatch(int i) {
        this.value = i;
    }

    public String toString() {
        return m2142toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2142toStringimpl(int i) {
        if (i == Default) {
            return "EmojiSupportMatch.Default";
        }
        if (i == None) {
            return "EmojiSupportMatch.None";
        }
        if (i == All) {
            return "EmojiSupportMatch.All";
        }
        return "Invalid(value=" + i + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDefault-_3YsG6Y, reason: not valid java name */
        public final int m2145getDefault_3YsG6Y() {
            return EmojiSupportMatch.Default;
        }

        /* JADX INFO: renamed from: getNone-_3YsG6Y, reason: not valid java name */
        public final int m2146getNone_3YsG6Y() {
            return EmojiSupportMatch.None;
        }

        /* JADX INFO: renamed from: getAll-_3YsG6Y, reason: not valid java name */
        public final int m2144getAll_3YsG6Y() {
            return EmojiSupportMatch.All;
        }
    }
}
