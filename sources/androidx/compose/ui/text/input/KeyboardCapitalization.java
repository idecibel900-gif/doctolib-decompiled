package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardCapitalization {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Unspecified = m2346constructorimpl(-1);
    private static final int None = m2346constructorimpl(0);
    private static final int Characters = m2346constructorimpl(1);
    private static final int Words = m2346constructorimpl(2);
    private static final int Sentences = m2346constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyboardCapitalization m2345boximpl(int i) {
        return new KeyboardCapitalization(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2346constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2347equalsimpl(int i, Object obj) {
        return (obj instanceof KeyboardCapitalization) && i == ((KeyboardCapitalization) obj).m2351unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2348equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2349hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2347equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2349hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2351unboximpl() {
        return this.value;
    }

    private /* synthetic */ KeyboardCapitalization(int i) {
        this.value = i;
    }

    public String toString() {
        return m2350toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2350toStringimpl(int i) {
        if (m2348equalsimpl0(i, Unspecified)) {
            return "Unspecified";
        }
        if (m2348equalsimpl0(i, None)) {
            return "None";
        }
        if (m2348equalsimpl0(i, Characters)) {
            return "Characters";
        }
        if (m2348equalsimpl0(i, Words)) {
            return "Words";
        }
        return m2348equalsimpl0(i, Sentences) ? "Sentences" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-IUNYP9k, reason: not valid java name */
        public final int m2355getUnspecifiedIUNYP9k() {
            return KeyboardCapitalization.Unspecified;
        }

        /* JADX INFO: renamed from: getNone-IUNYP9k, reason: not valid java name */
        public final int m2353getNoneIUNYP9k() {
            return KeyboardCapitalization.None;
        }

        /* JADX INFO: renamed from: getCharacters-IUNYP9k, reason: not valid java name */
        public final int m2352getCharactersIUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        /* JADX INFO: renamed from: getWords-IUNYP9k, reason: not valid java name */
        public final int m2356getWordsIUNYP9k() {
            return KeyboardCapitalization.Words;
        }

        /* JADX INFO: renamed from: getSentences-IUNYP9k, reason: not valid java name */
        public final int m2354getSentencesIUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }
    }
}
