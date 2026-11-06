package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class PaintingStyle {
    public static final Companion Companion = new Companion(null);
    private static final int Fill = m1459constructorimpl(0);
    private static final int Stroke = m1459constructorimpl(1);

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1459constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1460equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getFill-TiuSbCo, reason: not valid java name */
        public final int m1461getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* JADX INFO: renamed from: getStroke-TiuSbCo, reason: not valid java name */
        public final int m1462getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }
}
