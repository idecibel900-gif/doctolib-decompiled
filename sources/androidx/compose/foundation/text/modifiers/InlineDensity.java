package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class InlineDensity {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m598constructorimpl(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static long m599constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m601equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getDensity-impl, reason: not valid java name */
    public static final float m602getDensityimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getFontScale-impl, reason: not valid java name */
    public static final float m603getFontScaleimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m600constructorimpl(Density density) {
        return m598constructorimpl(density.getDensity(), density.getFontScale());
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m604toStringimpl(long j) {
        return "InlineDensity(density=" + m602getDensityimpl(j) + ", fontScale=" + m603getFontScaleimpl(j) + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-L26CHvs, reason: not valid java name */
        public final long m605getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m598constructorimpl(float f, float f2) {
        return m599constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }
}
