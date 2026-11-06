package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.OutlineStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class OutlineDrawable extends Drawable {
    private BorderRadiusStyle borderRadius;
    private ComputedBorderRadius computedBorderRadius;
    private final Context context;
    private final float gapBetweenPaths;
    private int outlineColor;
    private float outlineOffset;
    private final Paint outlinePaint;
    private OutlineStyle outlineStyle;
    private float outlineWidth;
    private final Path pathForOutline;
    private RectF tempRectForOutline;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutlineStyle.values().length];
            try {
                iArr[OutlineStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutlineStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OutlineStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final float calculateRadius(float f, float f2, float f3) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return f + (f2 * 0.5f) + f3;
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public OutlineDrawable(Context context, BorderRadiusStyle borderRadiusStyle, int i, float f, OutlineStyle outlineStyle, float f2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outlineStyle, "outlineStyle");
        this.context = context;
        this.borderRadius = borderRadiusStyle;
        this.gapBetweenPaths = 0.8f;
        this.outlineOffset = f;
        this.outlineStyle = outlineStyle;
        this.outlineColor = i;
        this.outlineWidth = f2;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f2);
        paint.setPathEffect(getPathEffect(outlineStyle, f2));
        this.outlinePaint = paint;
        this.tempRectForOutline = new RectF();
        this.pathForOutline = new Path();
    }

    public final void setOutlineOffset(float f) {
        if (f == this.outlineOffset) {
            return;
        }
        this.outlineOffset = f;
        invalidateSelf();
    }

    public final void setOutlineStyle(OutlineStyle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.outlineStyle) {
            this.outlineStyle = value;
            this.outlinePaint.setPathEffect(getPathEffect(value, this.outlineWidth));
            invalidateSelf();
        }
    }

    public final void setOutlineColor(int i) {
        if (i != this.outlineColor) {
            this.outlineColor = i;
            this.outlinePaint.setColor(i);
            invalidateSelf();
        }
    }

    public final void setOutlineWidth(float f) {
        if (f == this.outlineWidth) {
            return;
        }
        this.outlineWidth = f;
        this.outlinePaint.setStrokeWidth(f);
        this.outlinePaint.setPathEffect(getPathEffect(this.outlineStyle, f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.outlinePaint.setAlpha(MathKt.roundToInt((i / 255.0f) * (Color.alpha(this.outlineColor) / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.outlinePaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int alpha = this.outlinePaint.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ComputedBorderRadius computedBorderRadiusResolve;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.outlineWidth == 0.0f) {
            return;
        }
        this.pathForOutline.reset();
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null) {
            int layoutDirection = getLayoutDirection();
            Context context = this.context;
            PixelUtil pixelUtil = PixelUtil.INSTANCE;
            computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, pixelUtil.pxToDp(getBounds().width()), pixelUtil.pxToDp(getBounds().height()));
        } else {
            computedBorderRadiusResolve = null;
        }
        this.computedBorderRadius = computedBorderRadiusResolve;
        updateOutlineRect();
        ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
        if (computedBorderRadius != null && computedBorderRadius != null && computedBorderRadius.hasRoundedBorders()) {
            drawRoundedOutline(canvas);
        } else {
            drawRectangularOutline(canvas);
        }
    }

    private final void updateOutlineRect() {
        this.tempRectForOutline.set(getBounds());
        RectF rectF = this.tempRectForOutline;
        float f = rectF.top;
        float f2 = this.outlineWidth;
        float f3 = this.outlineOffset;
        float f4 = this.gapBetweenPaths;
        rectF.top = f - (((f2 * 0.5f) + f3) - f4);
        rectF.bottom += ((f2 * 0.5f) + f3) - f4;
        rectF.left -= ((f2 * 0.5f) + f3) - f4;
        rectF.right += ((f2 * 0.5f) + f3) - f4;
    }

    private final PathEffect getPathEffect(OutlineStyle outlineStyle, float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[outlineStyle.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            float f2 = f * 3;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
    }

    private final void drawRectangularOutline(Canvas canvas) {
        this.pathForOutline.addRect(this.tempRectForOutline, Path.Direction.CW);
        canvas.drawPath(this.pathForOutline, this.outlinePaint);
    }

    private final void drawRoundedOutline(Canvas canvas) {
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        CornerRadii bottomRight;
        CornerRadii bottomLeft;
        CornerRadii topRight;
        CornerRadii topLeft;
        ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
        if (computedBorderRadius == null || (topLeft = computedBorderRadius.getTopLeft()) == null || (cornerRadii = topLeft.toPixelFromDIP()) == null) {
            cornerRadii = new CornerRadii(0.0f, 0.0f);
        }
        ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
        if (computedBorderRadius2 == null || (topRight = computedBorderRadius2.getTopRight()) == null || (cornerRadii2 = topRight.toPixelFromDIP()) == null) {
            cornerRadii2 = new CornerRadii(0.0f, 0.0f);
        }
        ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
        if (computedBorderRadius3 == null || (bottomLeft = computedBorderRadius3.getBottomLeft()) == null || (cornerRadii3 = bottomLeft.toPixelFromDIP()) == null) {
            cornerRadii3 = new CornerRadii(0.0f, 0.0f);
        }
        ComputedBorderRadius computedBorderRadius4 = this.computedBorderRadius;
        if (computedBorderRadius4 == null || (bottomRight = computedBorderRadius4.getBottomRight()) == null || (cornerRadii4 = bottomRight.toPixelFromDIP()) == null) {
            cornerRadii4 = new CornerRadii(0.0f, 0.0f);
        }
        this.pathForOutline.addRoundRect(this.tempRectForOutline, new float[]{calculateRadius(cornerRadii.getHorizontal(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii.getVertical(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii2.getHorizontal(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii2.getVertical(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii4.getHorizontal(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii4.getVertical(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii3.getHorizontal(), this.outlineWidth, this.outlineOffset), calculateRadius(cornerRadii3.getVertical(), this.outlineWidth, this.outlineOffset)}, Path.Direction.CW);
        canvas.drawPath(this.pathForOutline, this.outlinePaint);
    }
}
