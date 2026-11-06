package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.FilterHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class OutsetBoxShadowDrawable extends Drawable {
    private final float blurRadius;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private final float offsetX;
    private final float offsetY;
    private final int shadowColor;
    private final Paint shadowPaint;
    private final float spread;

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public OutsetBoxShadowDrawable(Context context, int i, float f, float f2, float f3, float f4, BorderRadiusStyle borderRadiusStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.shadowColor = i;
        this.offsetX = f;
        this.offsetY = f2;
        this.blurRadius = f3;
        this.spread = f4;
        this.borderRadius = borderRadiusStyle;
        Paint paint = new Paint();
        paint.setColor(i);
        float fSigmaToRadius$ReactAndroid_release = FilterHelper.INSTANCE.sigmaToRadius$ReactAndroid_release(f3 * 0.5f);
        if (fSigmaToRadius$ReactAndroid_release > 0.0f) {
            paint.setMaskFilter(new BlurMaskFilter(fSigmaToRadius$ReactAndroid_release, BlurMaskFilter.Blur.NORMAL));
        }
        this.shadowPaint = paint;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.shadowPaint.setAlpha(MathKt.roundToInt((i / 255.0f) * (Color.alpha(this.shadowColor) / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.shadowPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int alpha = this.shadowPaint.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ComputedBorderRadius computedBorderRadiusResolve;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        float fPxToDp = pixelUtil.pxToDp(getBounds().width());
        float fPxToDp2 = pixelUtil.pxToDp(getBounds().height());
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        ComputedBorderRadius computedBorderRadius = (borderRadiusStyle == null || (computedBorderRadiusResolve = borderRadiusStyle.resolve(getLayoutDirection(), this.context, fPxToDp, fPxToDp2)) == null) ? null : new ComputedBorderRadius(new CornerRadii(pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getHorizontal()), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopLeft().getVertical())), new CornerRadii(pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getHorizontal()), pixelUtil.dpToPx(computedBorderRadiusResolve.getTopRight().getVertical())), new CornerRadii(pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getHorizontal()), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomLeft().getVertical())), new CornerRadii(pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getHorizontal()), pixelUtil.dpToPx(computedBorderRadiusResolve.getBottomRight().getVertical())));
        float fDpToPx = pixelUtil.dpToPx(this.spread);
        RectF rectF = new RectF(getBounds());
        float f = -fDpToPx;
        rectF.inset(f, f);
        rectF.offset(pixelUtil.dpToPx(this.offsetX), pixelUtil.dpToPx(this.offsetY));
        int iSave = canvas.save();
        if (computedBorderRadius != null && computedBorderRadius.hasRoundedBorders()) {
            drawShadowRoundRect(canvas, rectF, fDpToPx, computedBorderRadius);
        } else {
            drawShadowRect(canvas, rectF);
        }
        canvas.restoreToCount(iSave);
    }

    private final void drawShadowRoundRect(Canvas canvas, RectF rectF, float f, ComputedBorderRadius computedBorderRadius) {
        RectF rectF2 = new RectF(getBounds());
        rectF2.inset(0.4f, 0.4f);
        Path path = new Path();
        float[] fArr = {computedBorderRadius.getTopLeft().getHorizontal(), computedBorderRadius.getTopLeft().getVertical(), computedBorderRadius.getTopRight().getHorizontal(), computedBorderRadius.getTopRight().getVertical(), computedBorderRadius.getBottomRight().getHorizontal(), computedBorderRadius.getBottomRight().getVertical(), computedBorderRadius.getBottomLeft().getHorizontal(), computedBorderRadius.getBottomLeft().getVertical()};
        Path.Direction direction = Path.Direction.CW;
        path.addRoundRect(rectF2, fArr, direction);
        canvas.clipOutPath(path);
        Path path2 = new Path();
        path2.addRoundRect(rectF, new float[]{BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getTopLeft().getHorizontal(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getTopLeft().getVertical(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getTopRight().getHorizontal(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getTopRight().getVertical(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getBottomRight().getHorizontal(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getBottomRight().getVertical(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getBottomLeft().getHorizontal(), f), BoxShadowBorderRadiusKt.adjustRadiusForSpread(computedBorderRadius.getBottomLeft().getVertical(), f)}, direction);
        canvas.drawPath(path2, this.shadowPaint);
    }

    private final void drawShadowRect(Canvas canvas, RectF rectF) {
        canvas.clipOutRect(getBounds());
        canvas.drawRect(rectF, this.shadowPaint);
    }
}
