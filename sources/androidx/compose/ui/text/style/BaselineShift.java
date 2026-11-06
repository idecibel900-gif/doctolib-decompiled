package androidx.compose.ui.text.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class BaselineShift {
    private final float multiplier;
    public static final Companion Companion = new Companion(null);
    private static final float Superscript = m2409constructorimpl(0.5f);
    private static final float Subscript = m2409constructorimpl(-0.5f);
    private static final float None = m2409constructorimpl(0.0f);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m2408boximpl(float f) {
        return new BaselineShift(f);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m2409constructorimpl(float f) {
        return f;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2410equalsimpl(float f, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f, ((BaselineShift) obj).m2414unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2411equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2412hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2413toStringimpl(float f) {
        return "BaselineShift(multiplier=" + f + ')';
    }

    public boolean equals(Object obj) {
        return m2410equalsimpl(this.multiplier, obj);
    }

    public int hashCode() {
        return m2412hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m2413toStringimpl(this.multiplier);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2414unboximpl() {
        return this.multiplier;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getNone-y9eOQZs, reason: not valid java name */
        public final float m2415getNoney9eOQZs() {
            return BaselineShift.None;
        }
    }

    private /* synthetic */ BaselineShift(float f) {
        this.multiplier = f;
    }
}
