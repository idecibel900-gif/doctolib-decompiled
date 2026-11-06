package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class Dp implements Comparable {
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m2551constructorimpl(0.0f);
    private static final float Infinity = m2551constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m2551constructorimpl(Float.NaN);
    private final float value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m2549boximpl(float f) {
        return new Dp(f);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m2551constructorimpl(float f) {
        return f;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2552equalsimpl(float f, Object obj) {
        return (obj instanceof Dp) && Float.compare(f, ((Dp) obj).m2557unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2553equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2554hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    public boolean equals(Object obj) {
        return m2552equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2554hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2557unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m2556compareTo0680j_4(((Dp) obj).m2557unboximpl());
    }

    private /* synthetic */ Dp(float f) {
        this.value = f;
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m2550compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m2556compareTo0680j_4(float f) {
        return m2550compareTo0680j_4(this.value, f);
    }

    public String toString() {
        return m2555toStringimpl(this.value);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m2558getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m2559getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m2560getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2555toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }
}
