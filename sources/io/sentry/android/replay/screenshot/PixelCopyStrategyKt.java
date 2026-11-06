package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PixelCopyStrategyKt {
    public static final void compositeSurfaceViewInto(Canvas destCanvas, Paint destPaint, Rect tmpSrc, RectF tmpDst, Bitmap sourceBitmap, int i, int i2, int i3, int i4, float f, float f2) {
        Intrinsics.checkNotNullParameter(destCanvas, "destCanvas");
        Intrinsics.checkNotNullParameter(destPaint, "destPaint");
        Intrinsics.checkNotNullParameter(tmpSrc, "tmpSrc");
        Intrinsics.checkNotNullParameter(tmpDst, "tmpDst");
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        float f3 = (i - i3) * f;
        float f4 = (i2 - i4) * f2;
        tmpSrc.set(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight());
        tmpDst.set(f3, f4, (sourceBitmap.getWidth() * f) + f3, (sourceBitmap.getHeight() * f2) + f4);
        destCanvas.drawBitmap(sourceBitmap, tmpSrc, tmpDst, destPaint);
    }
}
