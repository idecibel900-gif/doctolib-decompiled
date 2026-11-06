package androidx.compose.ui.input.key;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class KeyEventType {
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m1717constructorimpl(0);
    private static final int KeyUp = m1717constructorimpl(1);
    private static final int KeyDown = m1717constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1717constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1718equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnknown-CS__XNY, reason: not valid java name */
        public final int m1721getUnknownCS__XNY() {
            return KeyEventType.Unknown;
        }

        /* JADX INFO: renamed from: getKeyUp-CS__XNY, reason: not valid java name */
        public final int m1720getKeyUpCS__XNY() {
            return KeyEventType.KeyUp;
        }

        /* JADX INFO: renamed from: getKeyDown-CS__XNY, reason: not valid java name */
        public final int m1719getKeyDownCS__XNY() {
            return KeyEventType.KeyDown;
        }
    }
}
