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
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class InsetBoxShadowDrawable extends Drawable {
    private final float blurRadius;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private final float offsetX;
    private final float offsetY;
    private final int shadowColor;
    private final Paint shadowPaint;
    private final float spread;

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public InsetBoxShadowDrawable(Context context, int i, float f, float f2, float f3, float f4, BorderInsets borderInsets, BorderRadiusStyle borderRadiusStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.shadowColor = i;
        this.offsetX = f;
        this.offsetY = f2;
        this.blurRadius = f3;
        this.spread = f4;
        this.borderInsets = borderInsets;
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
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        ComputedBorderRadius computedBorderRadiusComputeBorderRadii = computeBorderRadii();
        RectF rectFComputeBorderInsets = computeBorderInsets();
        RectF rectF = new RectF(getBounds().left + (rectFComputeBorderInsets != null ? rectFComputeBorderInsets.left : 0.0f), getBounds().top + (rectFComputeBorderInsets != null ? rectFComputeBorderInsets.top : 0.0f), getBounds().right - (rectFComputeBorderInsets != null ? rectFComputeBorderInsets.right : 0.0f), getBounds().bottom - (rectFComputeBorderInsets != null ? rectFComputeBorderInsets.bottom : 0.0f));
        float[] fArr = null;
        if (computedBorderRadiusComputeBorderRadii != null) {
            fArr = new float[]{innerRadius(computedBorderRadiusComputeBorderRadii.getTopLeft().getHorizontal(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.left) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getTopLeft().getVertical(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.top) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getTopRight().getHorizontal(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.right) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getTopRight().getVertical(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.top) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getBottomRight().getHorizontal(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.right) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getBottomRight().getVertical(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.bottom) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getBottomLeft().getHorizontal(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.left) : null), innerRadius(computedBorderRadiusComputeBorderRadii.getBottomLeft().getVertical(), rectFComputeBorderInsets != null ? Float.valueOf(rectFComputeBorderInsets.bottom) : null)};
        }
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        float fDpToPx = pixelUtil.dpToPx(this.offsetX);
        float fDpToPx2 = pixelUtil.dpToPx(this.offsetY);
        float fDpToPx3 = pixelUtil.dpToPx(this.spread);
        RectF rectF2 = new RectF(rectF);
        if (2 * fDpToPx3 > rectF.width()) {
            rectF2.setEmpty();
        } else {
            rectF2.inset(fDpToPx3, fDpToPx3);
        }
        rectF2.offset(fDpToPx, fDpToPx2);
        float fSigmaToRadius$ReactAndroid_release = FilterHelper.INSTANCE.sigmaToRadius$ReactAndroid_release(this.blurRadius);
        RectF rectF3 = new RectF(rectF2);
        rectF3.set(rectF);
        float f = -fSigmaToRadius$ReactAndroid_release;
        rectF3.inset(f, f);
        rectF3.union(new RectF(rectF2));
        int iSave = canvas.save();
        if (fArr != null) {
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.clipPath(path);
            ArrayList arrayList = new ArrayList(fArr.length);
            for (float f2 : fArr) {
                arrayList.add(Float.valueOf(BoxShadowBorderRadiusKt.adjustRadiusForSpread(f2, -fDpToPx3)));
            }
            canvas2 = canvas;
            canvas2.drawDoubleRoundRect(rectF3, InsetBoxShadowDrawableKt.ZERO_RADII, rectF2, CollectionsKt.toFloatArray(arrayList), this.shadowPaint);
        } else {
            canvas2 = canvas;
            canvas2.clipRect(rectF);
            canvas2.drawDoubleRoundRect(rectF3, InsetBoxShadowDrawableKt.ZERO_RADII, rectF2, InsetBoxShadowDrawableKt.ZERO_RADII, this.shadowPaint);
        }
        canvas2.restoreToCount(iSave);
    }

    private final ComputedBorderRadius computeBorderRadii() {
        ComputedBorderRadius computedBorderRadiusResolve;
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null) {
            int layoutDirection = getLayoutDirection();
            Context context = this.context;
            PixelUtil pixelUtil = PixelUtil.INSTANCE;
            computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, pixelUtil.pxToDp(getBounds().width()), pixelUtil.pxToDp(getBounds().height()));
        } else {
            computedBorderRadiusResolve = null;
        }
        if (computedBorderRadiusResolve == null || !computedBorderRadiusResolve.hasRoundedBorders()) {
            return null;
        }
        PixelUtil pixelUtil2 = PixelUtil.INSTANCE;
        return new ComputedBorderRadius(new CornerRadii(pixelUtil2.dpToPx(computedBorderRadiusResolve.getTopLeft().getHorizontal()), pixelUtil2.dpToPx(computedBorderRadiusResolve.getTopLeft().getVertical())), new CornerRadii(pixelUtil2.dpToPx(computedBorderRadiusResolve.getTopRight().getHorizontal()), pixelUtil2.dpToPx(computedBorderRadiusResolve.getTopRight().getVertical())), new CornerRadii(pixelUtil2.dpToPx(computedBorderRadiusResolve.getBottomLeft().getHorizontal()), pixelUtil2.dpToPx(computedBorderRadiusResolve.getBottomLeft().getVertical())), new CornerRadii(pixelUtil2.dpToPx(computedBorderRadiusResolve.getBottomRight().getHorizontal()), pixelUtil2.dpToPx(computedBorderRadiusResolve.getBottomRight().getVertical())));
    }

    private final RectF computeBorderInsets() {
        RectF rectFResolve;
        BorderInsets borderInsets = this.borderInsets;
        if (borderInsets == null || (rectFResolve = borderInsets.resolve(getLayoutDirection(), this.context)) == null) {
            return null;
        }
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        return new RectF(pixelUtil.dpToPx(rectFResolve.left), pixelUtil.dpToPx(rectFResolve.top), pixelUtil.dpToPx(rectFResolve.right), pixelUtil.dpToPx(rectFResolve.bottom));
    }

    private final float innerRadius(float f, Float f2) {
        return RangesKt.coerceAtLeast(f - (f2 != null ? f2.floatValue() : 0.0f), 0.0f);
    }
}
