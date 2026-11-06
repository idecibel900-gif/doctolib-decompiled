package androidx.compose.ui.hapticfeedback;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class HapticFeedbackType {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1675constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1676equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m1677getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1679getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m1678getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1680getTextHandleMove5zf0vsI();
        }
    }
}
