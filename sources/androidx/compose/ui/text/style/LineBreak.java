package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class LineBreak {
    public static final Companion Companion = new Companion(null);
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineBreak m2428boximpl(int i) {
        return new LineBreak(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2429constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2430equalsimpl(int i, Object obj) {
        return (obj instanceof LineBreak) && i == ((LineBreak) obj).m2437unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2431equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2435hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2430equalsimpl(this.mask, obj);
    }

    public int hashCode() {
        return m2435hashCodeimpl(this.mask);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2437unboximpl() {
        return this.mask;
    }

    private /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: getStrategy-fcGXIks, reason: not valid java name */
    public static final int m2432getStrategyfcGXIks(int i) {
        return Strategy.m2440constructorimpl(LineBreak_androidKt.unpackByte1(i));
    }

    /* JADX INFO: renamed from: getStrictness-usljTpc, reason: not valid java name */
    public static final int m2433getStrictnessusljTpc(int i) {
        return Strictness.m2446constructorimpl(LineBreak_androidKt.unpackByte2(i));
    }

    /* JADX INFO: renamed from: getWordBreak-jp8hJ3c, reason: not valid java name */
    public static final int m2434getWordBreakjp8hJ3c(int i) {
        return WordBreak.m2453constructorimpl(LineBreak_androidKt.unpackByte3(i));
    }

    public String toString() {
        return m2436toStringimpl(this.mask);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2436toStringimpl(int i) {
        return "LineBreak(strategy=" + ((Object) Strategy.m2442toStringimpl(m2432getStrategyfcGXIks(i))) + ", strictness=" + ((Object) Strictness.m2448toStringimpl(m2433getStrictnessusljTpc(i))) + ", wordBreak=" + ((Object) WordBreak.m2455toStringimpl(m2434getWordBreakjp8hJ3c(i))) + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getSimple-rAG3T2k, reason: not valid java name */
        public final int m2438getSimplerAG3T2k() {
            return LineBreak.Simple;
        }

        /* JADX INFO: renamed from: getUnspecified-rAG3T2k, reason: not valid java name */
        public final int m2439getUnspecifiedrAG3T2k() {
            return LineBreak.Unspecified;
        }
    }

    static {
        Strategy.Companion companion = Strategy.Companion;
        int iM2445getSimplefcGXIks = companion.m2445getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int iM2451getNormalusljTpc = companion2.m2451getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = m2429constructorimpl(LineBreak_androidKt.packBytes(iM2445getSimplefcGXIks, iM2451getNormalusljTpc, companion3.m2456getDefaultjp8hJ3c()));
        Heading = m2429constructorimpl(LineBreak_androidKt.packBytes(companion.m2443getBalancedfcGXIks(), companion2.m2450getLooseusljTpc(), companion3.m2457getPhrasejp8hJ3c()));
        Paragraph = m2429constructorimpl(LineBreak_androidKt.packBytes(companion.m2444getHighQualityfcGXIks(), companion2.m2452getStrictusljTpc(), companion3.m2456getDefaultjp8hJ3c()));
        Unspecified = m2429constructorimpl(0);
    }

    public static final class Strategy {
        public static final Companion Companion = new Companion(null);
        private static final int Simple = m2440constructorimpl(1);
        private static final int HighQuality = m2440constructorimpl(2);
        private static final int Balanced = m2440constructorimpl(3);
        private static final int Unspecified = m2440constructorimpl(0);

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2440constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2441equalsimpl0(int i, int i2) {
            return i == i2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getSimple-fcGXIks, reason: not valid java name */
            public final int m2445getSimplefcGXIks() {
                return Strategy.Simple;
            }

            /* JADX INFO: renamed from: getHighQuality-fcGXIks, reason: not valid java name */
            public final int m2444getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* JADX INFO: renamed from: getBalanced-fcGXIks, reason: not valid java name */
            public final int m2443getBalancedfcGXIks() {
                return Strategy.Balanced;
            }
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2442toStringimpl(int i) {
            if (m2441equalsimpl0(i, Simple)) {
                return "Strategy.Simple";
            }
            if (m2441equalsimpl0(i, HighQuality)) {
                return "Strategy.HighQuality";
            }
            if (m2441equalsimpl0(i, Balanced)) {
                return "Strategy.Balanced";
            }
            return m2441equalsimpl0(i, Unspecified) ? "Strategy.Unspecified" : "Invalid";
        }
    }

    public static final class Strictness {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m2446constructorimpl(1);
        private static final int Loose = m2446constructorimpl(2);
        private static final int Normal = m2446constructorimpl(3);
        private static final int Strict = m2446constructorimpl(4);
        private static final int Unspecified = m2446constructorimpl(0);

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2446constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2447equalsimpl0(int i, int i2) {
            return i == i2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getDefault-usljTpc, reason: not valid java name */
            public final int m2449getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* JADX INFO: renamed from: getLoose-usljTpc, reason: not valid java name */
            public final int m2450getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* JADX INFO: renamed from: getNormal-usljTpc, reason: not valid java name */
            public final int m2451getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* JADX INFO: renamed from: getStrict-usljTpc, reason: not valid java name */
            public final int m2452getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2448toStringimpl(int i) {
            if (m2447equalsimpl0(i, Default)) {
                return "Strictness.None";
            }
            if (m2447equalsimpl0(i, Loose)) {
                return "Strictness.Loose";
            }
            if (m2447equalsimpl0(i, Normal)) {
                return "Strictness.Normal";
            }
            if (m2447equalsimpl0(i, Strict)) {
                return "Strictness.Strict";
            }
            return m2447equalsimpl0(i, Unspecified) ? "Strictness.Unspecified" : "Invalid";
        }
    }

    public static final class WordBreak {
        public static final Companion Companion = new Companion(null);
        private static final int Default = m2453constructorimpl(1);
        private static final int Phrase = m2453constructorimpl(2);
        private static final int Unspecified = m2453constructorimpl(0);

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m2453constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2454equalsimpl0(int i, int i2) {
            return i == i2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getDefault-jp8hJ3c, reason: not valid java name */
            public final int m2456getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* JADX INFO: renamed from: getPhrase-jp8hJ3c, reason: not valid java name */
            public final int m2457getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2455toStringimpl(int i) {
            if (m2454equalsimpl0(i, Default)) {
                return "WordBreak.None";
            }
            if (m2454equalsimpl0(i, Phrase)) {
                return "WordBreak.Phrase";
            }
            return m2454equalsimpl0(i, Unspecified) ? "WordBreak.Unspecified" : "Invalid";
        }
    }
}
