package androidx.compose.ui.graphics.layer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class CompositingStrategy {
    public static final Companion Companion = new Companion(null);
    private static final int Auto = m1606constructorimpl(0);
    private static final int Offscreen = m1606constructorimpl(1);
    private static final int ModulateAlpha = m1606constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1606constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1607equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getAuto-ke2Ky5w, reason: not valid java name */
        public final int m1608getAutoke2Ky5w() {
            return CompositingStrategy.Auto;
        }

        /* JADX INFO: renamed from: getOffscreen-ke2Ky5w, reason: not valid java name */
        public final int m1610getOffscreenke2Ky5w() {
            return CompositingStrategy.Offscreen;
        }

        /* JADX INFO: renamed from: getModulateAlpha-ke2Ky5w, reason: not valid java name */
        public final int m1609getModulateAlphake2Ky5w() {
            return CompositingStrategy.ModulateAlpha;
        }
    }
}
