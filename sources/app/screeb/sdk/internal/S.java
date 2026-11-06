package app.screeb.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class S {
    public static void a(int[] rects, Bitmap bitmap, double d, int i, int i2) {
        Intrinsics.checkNotNullParameter(rects, "rects");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (rects.length == 0) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        for (int i3 = 0; i3 < rects.length; i3 += 4) {
            int iCoerceIn = RangesKt.coerceIn(((int) Math.floor(((double) rects[i3]) * d)) - i, 0, bitmap.getWidth());
            int iCoerceIn2 = RangesKt.coerceIn(((int) Math.floor(((double) rects[i3 + 1]) * d)) - i2, 0, bitmap.getHeight());
            int iCoerceIn3 = RangesKt.coerceIn(((int) Math.ceil(((double) rects[i3 + 2]) * d)) - i, 0, bitmap.getWidth());
            int iCoerceIn4 = RangesKt.coerceIn(((int) Math.ceil(((double) rects[i3 + 3]) * d)) - i2, 0, bitmap.getHeight());
            if (iCoerceIn3 > iCoerceIn && iCoerceIn4 > iCoerceIn2) {
                canvas.drawRect(iCoerceIn, iCoerceIn2, iCoerceIn3, iCoerceIn4, T.e);
            }
        }
    }
}
