package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class ClipOp {
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m1357constructorimpl(0);
    private static final int Intersect = m1357constructorimpl(1);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1357constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1358equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getDifference-rtfAjoo, reason: not valid java name */
        public final int m1359getDifferencertfAjoo() {
            return ClipOp.Difference;
        }

        /* JADX INFO: renamed from: getIntersect-rtfAjoo, reason: not valid java name */
        public final int m1360getIntersectrtfAjoo() {
            return ClipOp.Intersect;
        }
    }
}
