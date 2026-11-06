package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public interface BeyondBoundsLayout {

    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    /* JADX INFO: renamed from: layout-o7g1Pn8 */
    Object mo405layouto7g1Pn8(int i, Function1 function1);

    public static final class LayoutDirection {
        public static final Companion Companion = new Companion(null);
        private static final int Before = m1825constructorimpl(1);
        private static final int After = m1825constructorimpl(2);
        private static final int Left = m1825constructorimpl(3);
        private static final int Right = m1825constructorimpl(4);
        private static final int Above = m1825constructorimpl(5);
        private static final int Below = m1825constructorimpl(6);

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static int m1825constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1826equalsimpl0(int i, int i2) {
            return i == i2;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getBefore-hoxUOeE, reason: not valid java name */
            public final int m1829getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* JADX INFO: renamed from: getAfter-hoxUOeE, reason: not valid java name */
            public final int m1828getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* JADX INFO: renamed from: getLeft-hoxUOeE, reason: not valid java name */
            public final int m1831getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* JADX INFO: renamed from: getRight-hoxUOeE, reason: not valid java name */
            public final int m1832getRighthoxUOeE() {
                return LayoutDirection.Right;
            }

            /* JADX INFO: renamed from: getAbove-hoxUOeE, reason: not valid java name */
            public final int m1827getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* JADX INFO: renamed from: getBelow-hoxUOeE, reason: not valid java name */
            public final int m1830getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }
        }
    }
}
