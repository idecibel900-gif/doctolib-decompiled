package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class LineHeightStyle {
    public static final Companion Companion;
    private static final LineHeightStyle Default;
    private final float alignment;
    private final int trim;

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    private LineHeightStyle(float f, int i) {
        this.alignment = f;
        this.trim = i;
    }

    /* JADX INFO: renamed from: getAlignment-PIaL0Z0, reason: not valid java name */
    public final float m2458getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getTrim-EVpEnUU, reason: not valid java name */
    public final int m2459getTrimEVpEnUU() {
        return this.trim;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        Default = new LineHeightStyle(Alignment.Companion.m2465getProportionalPIaL0Z0(), Trim.Companion.m2472getBothEVpEnUU(), defaultConstructorMarker);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.m2461equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m2467equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    public int hashCode() {
        return (Alignment.m2462hashCodeimpl(this.alignment) * 31) + Trim.m2468hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m2463toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m2471toStringimpl(this.trim)) + ')';
    }

    public static final class Trim {
        public static final Companion Companion = new Companion(null);
        private static final int FirstLineTop = m2466constructorimpl(1);
        private static final int LastLineBottom = m2466constructorimpl(16);
        private static final int Both = m2466constructorimpl(17);
        private static final int None = m2466constructorimpl(0);

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m2466constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2467equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2468hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        /* JADX INFO: renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2469isTrimFirstLineTopimpl$ui_text_release(int i) {
            return (i & 1) > 0;
        }

        /* JADX INFO: renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
        public static final boolean m2470isTrimLastLineBottomimpl$ui_text_release(int i) {
            return (i & 16) > 0;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2471toStringimpl(int i) {
            if (i == FirstLineTop) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (i == LastLineBottom) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (i == Both) {
                return "LineHeightStyle.Trim.Both";
            }
            return i == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m2472getBothEVpEnUU() {
                return Trim.Both;
            }

            /* JADX INFO: renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m2473getNoneEVpEnUU() {
                return Trim.None;
            }
        }
    }

    public static final class Alignment {
        public static final Companion Companion = new Companion(null);
        private static final float Top = m2460constructorimpl(0.0f);
        private static final float Center = m2460constructorimpl(0.5f);
        private static final float Proportional = m2460constructorimpl(-1.0f);
        private static final float Bottom = m2460constructorimpl(1.0f);

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m2461equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m2462hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static float m2460constructorimpl(float f) {
            if ((0.0f > f || f > 1.0f) && f != -1.0f) {
                throw new IllegalStateException("topRatio should be in [0..1] range or -1");
            }
            return f;
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m2463toStringimpl(float f) {
            if (f == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (f == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (f == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (f == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final float m2464getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* JADX INFO: renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final float m2465getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }
        }
    }
}
