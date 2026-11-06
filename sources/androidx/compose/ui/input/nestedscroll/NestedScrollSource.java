package androidx.compose.ui.input.nestedscroll;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class NestedScrollSource {
    public static final Companion Companion = new Companion(null);
    private static final int Drag;
    private static final int Fling;
    private static final int Relocate;
    private static final int SideEffect;
    private static final int UserInput;
    private static final int Wheel;

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1736constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1737equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUserInput-WNlRxjI, reason: not valid java name */
        public final int m1739getUserInputWNlRxjI() {
            return NestedScrollSource.UserInput;
        }

        /* JADX INFO: renamed from: getSideEffect-WNlRxjI, reason: not valid java name */
        public final int m1738getSideEffectWNlRxjI() {
            return NestedScrollSource.SideEffect;
        }
    }

    static {
        int iM1736constructorimpl = m1736constructorimpl(1);
        UserInput = iM1736constructorimpl;
        int iM1736constructorimpl2 = m1736constructorimpl(2);
        SideEffect = iM1736constructorimpl2;
        Drag = iM1736constructorimpl;
        Fling = iM1736constructorimpl2;
        Relocate = m1736constructorimpl(3);
        Wheel = iM1736constructorimpl;
    }
}
