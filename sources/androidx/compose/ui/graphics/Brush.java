package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class Brush {
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo1347applyToPq9zytI(long j, Paint paint, float f);

    private Brush() {
        this.intrinsicSize = Size.Companion.m1266getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo1348getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m1350linearGradientmHitzGk(List list, long j, long j2, int i) {
            return new LinearGradient(list, null, j, j2, i, null);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m1349verticalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m1514getClamp3opZhB0();
            }
            return companion.m1351verticalGradient8A3gB4(list, f, f2, i);
        }

        /* JADX INFO: renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m1351verticalGradient8A3gB4(List list, float f, float f2, int i) {
            return m1350linearGradientmHitzGk(list, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }
    }
}
