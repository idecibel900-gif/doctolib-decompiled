package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class RenderIntent {
    public static final Companion Companion = new Companion(null);
    private static final int Perceptual = m1547constructorimpl(0);
    private static final int Relative = m1547constructorimpl(1);
    private static final int Saturation = m1547constructorimpl(2);
    private static final int Absolute = m1547constructorimpl(3);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1547constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1548equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m1550getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* JADX INFO: renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m1551getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* JADX INFO: renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m1549getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }
    }
}
