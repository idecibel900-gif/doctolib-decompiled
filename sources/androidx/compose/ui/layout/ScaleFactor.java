package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ScaleFactor {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1877constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m1878getScaleXimpl(long j) {
        if (!(j != Unspecified)) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m1879getScaleYimpl(long j) {
        if (!(j != Unspecified)) {
            InlineClassHelperKt.throwIllegalStateException("ScaleFactor is unspecified");
        }
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
