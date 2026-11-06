package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArcMode {
    public static final Companion Companion = new Companion(null);
    private static final int ArcAbove = m68constructorimpl(5);
    private static final int ArcBelow = m68constructorimpl(4);
    private static final int ArcLinear = m68constructorimpl(0);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m68constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m69equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m70hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m71toStringimpl(int i) {
        return "ArcMode(value=" + i + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getArcLinear--9T-Mq4, reason: not valid java name */
        public final int m72getArcLinear9TMq4() {
            return ArcMode.ArcLinear;
        }
    }
}
