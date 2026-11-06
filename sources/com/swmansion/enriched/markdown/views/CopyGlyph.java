package com.swmansion.enriched.markdown.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CopyGlyph {
    private final Paint clearPaint;
    private final Path back = new Path();
    private final Path front = new Path();
    private final Path backFold = new Path();
    private final Path frontFold = new Path();

    public CopyGlyph() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.clearPaint = paint;
    }

    public final void draw(Canvas canvas, float f, Paint stroke) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        float f2 = f / 24.0f;
        float f3 = f2 * 4.0f;
        float f4 = f2 * 2.0f;
        float f5 = 1 * f2;
        float f6 = 20 * f2;
        buildPage(this.back, 9 * f2, f5, f6, 17 * f2, f3, f4);
        float f7 = 7 * f2;
        float f8 = 14 * f2;
        buildPage(this.front, 3 * f2, f7, f8, 23 * f2, f3, f4);
        buildFold(this.backFold, f6, f5, f3);
        buildFold(this.frontFold, f8, f7, f3);
        this.clearPaint.setStrokeWidth(stroke.getStrokeWidth() * 3.0f);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, f, f, null);
        canvas.drawPath(this.back, stroke);
        canvas.drawPath(this.backFold, stroke);
        canvas.drawPath(this.front, this.clearPaint);
        canvas.drawPath(this.front, stroke);
        canvas.drawPath(this.frontFold, stroke);
        canvas.restoreToCount(iSaveLayer);
    }

    private final void buildPage(Path path, float f, float f2, float f3, float f4, float f5, float f6) {
        path.rewind();
        path.moveTo(f, f2 + f6);
        float f7 = f + f6;
        path.quadTo(f, f2, f7, f2);
        path.lineTo(f3 - f5, f2);
        path.lineTo(f3, f2 + f5);
        float f8 = f4 - f6;
        path.lineTo(f3, f8);
        path.quadTo(f3, f4, f3 - f6, f4);
        path.lineTo(f7, f4);
        path.quadTo(f, f4, f, f8);
        path.close();
    }

    private final void buildFold(Path path, float f, float f2, float f3) {
        path.rewind();
        float f4 = f - f3;
        path.moveTo(f4, f2);
        float f5 = f2 + f3;
        path.lineTo(f4, f5);
        path.lineTo(f, f5);
    }
}
