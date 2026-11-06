package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundDrawable extends Drawable {
    private int backgroundColor;
    private final Paint backgroundPaint;
    private RectF backgroundRect;
    private Path backgroundRenderPath;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private RectF computedBorderInsets;
    private ComputedBorderRadius computedBorderRadius;
    private final Context context;
    private boolean needUpdatePath;
    private final float pathAdjustment;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BackgroundDrawable(Context context, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.pathAdjustment = 0.8f;
        this.needUpdatePath = true;
        this.backgroundRect = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.backgroundColor);
        this.backgroundPaint = paint;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        if (this.backgroundColor != i) {
            this.backgroundColor = i;
            this.backgroundPaint.setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.needUpdatePath = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.needUpdatePath = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.backgroundPaint.setAlpha(MathKt.roundToInt((i / 255.0f) * (Color.alpha(this.backgroundColor) / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int alpha = this.backgroundPaint.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BorderRadiusStyle borderRadiusStyle;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        updatePath();
        canvas.save();
        if (this.backgroundPaint.getAlpha() != 0) {
            ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
            if (computedBorderRadius != null && computedBorderRadius.isUniform() && (borderRadiusStyle = this.borderRadius) != null && borderRadiusStyle.hasRoundedBorders()) {
                RectF rectF = this.backgroundRect;
                ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
                float fDpToPx = 0.0f;
                float fDpToPx2 = (computedBorderRadius2 == null || (topLeft2 = computedBorderRadius2.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal());
                ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
                if (computedBorderRadius3 != null && (topLeft = computedBorderRadius3.getTopLeft()) != null) {
                    fDpToPx = PixelUtil.INSTANCE.dpToPx(topLeft.getVertical());
                }
                canvas.drawRoundRect(rectF, fDpToPx2, fDpToPx, this.backgroundPaint);
            } else {
                BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
                if (borderRadiusStyle2 == null || !borderRadiusStyle2.hasRoundedBorders()) {
                    canvas.drawRect(this.backgroundRect, this.backgroundPaint);
                } else {
                    Path path = this.backgroundRenderPath;
                    if (path == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.drawPath(path, this.backgroundPaint);
                }
            }
        }
        canvas.restore();
    }

    private final RectF computeBorderInsets() {
        float fDpToPx;
        float fDpToPx2;
        float fDpToPx3;
        BorderInsets borderInsets = this.borderInsets;
        RectF rectFResolve = borderInsets != null ? borderInsets.resolve(getLayoutDirection(), this.context) : null;
        float fDpToPx4 = 0.0f;
        if (rectFResolve != null) {
            fDpToPx = PixelUtil.INSTANCE.dpToPx(rectFResolve.left);
        } else {
            fDpToPx = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx2 = PixelUtil.INSTANCE.dpToPx(rectFResolve.top);
        } else {
            fDpToPx2 = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx3 = PixelUtil.INSTANCE.dpToPx(rectFResolve.right);
        } else {
            fDpToPx3 = 0.0f;
        }
        if (rectFResolve != null) {
            fDpToPx4 = PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom);
        }
        return new RectF(fDpToPx, fDpToPx2, fDpToPx3, fDpToPx4);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        boolean z;
        Path path;
        CornerRadii bottomLeft;
        CornerRadii bottomLeft2;
        CornerRadii bottomRight;
        CornerRadii bottomRight2;
        CornerRadii topRight;
        CornerRadii topRight2;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        BorderRadiusStyle borderRadiusStyle;
        ComputedBorderRadius computedBorderRadius;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            this.backgroundRect.set(getBounds());
            this.computedBorderInsets = computeBorderInsets();
            BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
            if (borderRadiusStyle2 != null) {
                int layoutDirection = getLayoutDirection();
                Context context = this.context;
                PixelUtil pixelUtil = PixelUtil.INSTANCE;
                computedBorderRadiusResolve = borderRadiusStyle2.resolve(layoutDirection, context, pixelUtil.pxToDp(getBounds().width()), pixelUtil.pxToDp(getBounds().height()));
            } else {
                computedBorderRadiusResolve = null;
            }
            this.computedBorderRadius = computedBorderRadiusResolve;
            RectF rectF = this.computedBorderInsets;
            float fDpToPx = 0.0f;
            if (Intrinsics.areEqual(rectF != null ? Float.valueOf(rectF.left) : null, 0.0f)) {
                RectF rectF2 = this.computedBorderInsets;
                if (Intrinsics.areEqual(rectF2 != null ? Float.valueOf(rectF2.top) : null, 0.0f)) {
                    RectF rectF3 = this.computedBorderInsets;
                    if (Intrinsics.areEqual(rectF3 != null ? Float.valueOf(rectF3.right) : null, 0.0f)) {
                        RectF rectF4 = this.computedBorderInsets;
                        if (Intrinsics.areEqual(rectF4 != null ? Float.valueOf(rectF4.bottom) : null, 0.0f)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = true;
                    }
                } else {
                    z = true;
                }
            } else {
                z = true;
            }
            ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
            if (computedBorderRadius2 != null && computedBorderRadius2.hasRoundedBorders() && (computedBorderRadius = this.computedBorderRadius) != null && !computedBorderRadius.isUniform()) {
                Path path2 = this.backgroundRenderPath;
                if (path2 == null) {
                    path2 = new Path();
                }
                this.backgroundRenderPath = path2;
                path2.reset();
            }
            if (z && (borderRadiusStyle = this.borderRadius) != null && borderRadiusStyle.hasRoundedBorders()) {
                RectF rectF5 = this.backgroundRect;
                float f = rectF5.left;
                float f2 = this.pathAdjustment;
                rectF5.left = f + f2;
                rectF5.top += f2;
                rectF5.right -= f2;
                rectF5.bottom -= f2;
            }
            BorderRadiusStyle borderRadiusStyle3 = this.borderRadius;
            if (borderRadiusStyle3 == null || !borderRadiusStyle3.hasRoundedBorders()) {
                return;
            }
            ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
            if ((computedBorderRadius3 == null || !computedBorderRadius3.isUniform()) && (path = this.backgroundRenderPath) != null) {
                RectF rectF6 = this.backgroundRect;
                ComputedBorderRadius computedBorderRadius4 = this.computedBorderRadius;
                float fDpToPx2 = (computedBorderRadius4 == null || (topLeft2 = computedBorderRadius4.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal());
                ComputedBorderRadius computedBorderRadius5 = this.computedBorderRadius;
                float fDpToPx3 = (computedBorderRadius5 == null || (topLeft = computedBorderRadius5.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft.getVertical());
                ComputedBorderRadius computedBorderRadius6 = this.computedBorderRadius;
                float fDpToPx4 = (computedBorderRadius6 == null || (topRight2 = computedBorderRadius6.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight2.getHorizontal());
                ComputedBorderRadius computedBorderRadius7 = this.computedBorderRadius;
                float fDpToPx5 = (computedBorderRadius7 == null || (topRight = computedBorderRadius7.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight.getVertical());
                ComputedBorderRadius computedBorderRadius8 = this.computedBorderRadius;
                float fDpToPx6 = (computedBorderRadius8 == null || (bottomRight2 = computedBorderRadius8.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight2.getHorizontal());
                ComputedBorderRadius computedBorderRadius9 = this.computedBorderRadius;
                float fDpToPx7 = (computedBorderRadius9 == null || (bottomRight = computedBorderRadius9.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight.getVertical());
                ComputedBorderRadius computedBorderRadius10 = this.computedBorderRadius;
                float fDpToPx8 = (computedBorderRadius10 == null || (bottomLeft2 = computedBorderRadius10.getBottomLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomLeft2.getHorizontal());
                ComputedBorderRadius computedBorderRadius11 = this.computedBorderRadius;
                if (computedBorderRadius11 != null && (bottomLeft = computedBorderRadius11.getBottomLeft()) != null) {
                    fDpToPx = PixelUtil.INSTANCE.dpToPx(bottomLeft.getVertical());
                }
                path.addRoundRect(rectF6, new float[]{fDpToPx2, fDpToPx3, fDpToPx4, fDpToPx5, fDpToPx6, fDpToPx7, fDpToPx8, fDpToPx}, Path.Direction.CW);
            }
        }
    }
}
