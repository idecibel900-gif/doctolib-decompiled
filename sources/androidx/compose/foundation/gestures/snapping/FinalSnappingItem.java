package androidx.compose.foundation.gestures.snapping;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class FinalSnappingItem {
    public static final Companion Companion = new Companion(null);
    private static final int ClosestItem = m263constructorimpl(0);
    private static final int NextItem = m263constructorimpl(1);
    private static final int PreviousItem = m263constructorimpl(2);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m263constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m264equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getClosestItem-bbeMdSM, reason: not valid java name */
        public final int m265getClosestItembbeMdSM() {
            return FinalSnappingItem.ClosestItem;
        }

        /* JADX INFO: renamed from: getNextItem-bbeMdSM, reason: not valid java name */
        public final int m266getNextItembbeMdSM() {
            return FinalSnappingItem.NextItem;
        }

        /* JADX INFO: renamed from: getPreviousItem-bbeMdSM, reason: not valid java name */
        public final int m267getPreviousItembbeMdSM() {
            return FinalSnappingItem.PreviousItem;
        }
    }
}
