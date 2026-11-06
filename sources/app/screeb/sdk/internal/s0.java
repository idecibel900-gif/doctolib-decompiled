package app.screeb.sdk.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 {
    public static r0 a(q0 boundsInWindow, int i, int i2, double d) {
        Intrinsics.checkNotNullParameter(boundsInWindow, "boundsInWindow");
        int iCoerceAtLeast = RangesKt.coerceAtLeast(boundsInWindow.a, 0);
        int iCoerceAtLeast2 = RangesKt.coerceAtLeast(boundsInWindow.b, 0);
        int iCoerceAtMost = RangesKt.coerceAtMost(boundsInWindow.c, i);
        int iCoerceAtMost2 = RangesKt.coerceAtMost(boundsInWindow.d, i2);
        if (iCoerceAtMost <= iCoerceAtLeast || iCoerceAtMost2 <= iCoerceAtLeast2) {
            return null;
        }
        int i3 = boundsInWindow.a;
        int i4 = iCoerceAtLeast - i3;
        int i5 = boundsInWindow.b;
        int i6 = iCoerceAtLeast2 - i5;
        int i7 = iCoerceAtMost - i3;
        int i8 = iCoerceAtMost2 - i5;
        return new r0(new q0(i4, i6, i7, i8), (int) (((double) iCoerceAtLeast) * d), (int) (((double) iCoerceAtLeast2) * d), RangesKt.coerceAtLeast((int) (((double) (i7 - i4)) * d), 1), RangesKt.coerceAtLeast((int) (((double) (i8 - i6)) * d), 1));
    }
}
