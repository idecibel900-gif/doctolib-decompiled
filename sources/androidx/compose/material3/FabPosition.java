package androidx.compose.material3;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class FabPosition {
    public static final Companion Companion = new Companion(null);
    private static final int Start = m775constructorimpl(0);
    private static final int Center = m775constructorimpl(1);
    private static final int End = m775constructorimpl(2);
    private static final int EndOverlay = m775constructorimpl(3);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m775constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m776equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getStart-ERTFSPs, reason: not valid java name */
        public final int m779getStartERTFSPs() {
            return FabPosition.Start;
        }

        /* JADX INFO: renamed from: getEnd-ERTFSPs, reason: not valid java name */
        public final int m777getEndERTFSPs() {
            return FabPosition.End;
        }

        /* JADX INFO: renamed from: getEndOverlay-ERTFSPs, reason: not valid java name */
        public final int m778getEndOverlayERTFSPs() {
            return FabPosition.EndOverlay;
        }
    }
}
