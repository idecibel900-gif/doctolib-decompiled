package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.react.uimanager.style.BorderColors;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.ColorEdges;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class BorderDrawable extends Drawable {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BorderDrawable.class, "borderStyle", "getBorderStyle()Lcom/facebook/react/uimanager/style/BorderStyle;", 0))};
    private int borderAlpha;
    private Integer[] borderColors;
    private BorderInsets borderInsets;
    private final Paint borderPaint;
    private BorderRadiusStyle borderRadius;
    private final ReadWriteProperty borderStyle$delegate;
    private final Spacing borderWidth;
    private Path centerDrawPath;
    private ColorEdges computedBorderColors;
    private ComputedBorderRadius computedBorderRadius;
    private final Context context;
    private final float gapBetweenPaths;
    private PointF innerBottomLeftCorner;
    private PointF innerBottomRightCorner;
    private Path innerClipPathForBorderRadius;
    private RectF innerClipTempRectForBorderRadius;
    private PointF innerTopLeftCorner;
    private PointF innerTopRightCorner;
    private boolean needUpdatePath;
    private Path outerClipPathForBorderRadius;
    private RectF outerClipTempRectForBorderRadius;
    private Path pathForBorder;
    private Path pathForOutline;
    private Path pathForSingleBorder;
    private RectF tempRectForCenterDrawPath;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            try {
                iArr[BorderStyle.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BorderStyle.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BorderStyle.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int multiplyColorAlpha(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * ((i2 + (i2 >> 7)) >> 7)) >> 8) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BorderDrawable(Context context, Spacing spacing, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets, BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderWidth = spacing;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.borderStyle$delegate = invalidatingAndPathChange(borderStyle);
        this.computedBorderColors = new ColorEdges(0, 0, 0, 0, 15, null);
        this.borderAlpha = 255;
        this.gapBetweenPaths = 0.8f;
        this.borderPaint = new Paint(1);
        this.needUpdatePath = true;
    }

    private final ReadWriteProperty invalidatingAndPathChange(Object obj) {
        return new ObservableProperty(obj) { // from class: com.facebook.react.uimanager.drawable.BorderDrawable.invalidatingAndPathChange.1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                if (Intrinsics.areEqual(obj2, obj3)) {
                    return;
                }
                this.needUpdatePath = true;
                this.invalidateSelf();
            }
        };
    }

    public final BorderStyle getBorderStyle() {
        return (BorderStyle) this.borderStyle$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setBorderStyle(BorderStyle borderStyle) {
        this.borderStyle$delegate.setValue(this, $$delegatedProperties[0], borderStyle);
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
        this.borderAlpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (ComparisonsKt.maxOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 0) {
            return -2;
        }
        return ComparisonsKt.minOf(Color.alpha(multiplyColorAlpha(this.computedBorderColors.getLeft(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getTop(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getRight(), this.borderAlpha)), Color.alpha(multiplyColorAlpha(this.computedBorderColors.getBottom(), this.borderAlpha))) == 255 ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ColorEdges colorEdgesM3460resolveimpl;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        updatePathEffect();
        Integer[] numArr = this.borderColors;
        if (numArr == null || (colorEdgesM3460resolveimpl = BorderColors.m3460resolveimpl(numArr, getLayoutDirection(), this.context)) == null) {
            colorEdgesM3460resolveimpl = this.computedBorderColors;
        }
        this.computedBorderColors = colorEdgesM3460resolveimpl;
        BorderRadiusStyle borderRadiusStyle = this.borderRadius;
        if (borderRadiusStyle != null && borderRadiusStyle.hasRoundedBorders()) {
            drawRoundedBorders(canvas);
        } else {
            drawRectangularBorders(canvas);
        }
    }

    private final float getInnerBorderRadius(float f, float f2) {
        return RangesKt.coerceAtLeast(f - f2, 0.0f);
    }

    public final void setBorderWidth(int i, float f) {
        Spacing spacing = this.borderWidth;
        if (FloatUtil.floatsEqual(spacing != null ? Float.valueOf(spacing.getRaw(i)) : null, Float.valueOf(f))) {
            return;
        }
        Spacing spacing2 = this.borderWidth;
        if (spacing2 != null) {
            spacing2.set(i, f);
        }
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) {
            this.needUpdatePath = true;
        }
        invalidateSelf();
    }

    public final void setBorderColor(LogicalEdge position, Integer num) {
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArrM3459constructorimpl$default = this.borderColors;
        if (numArrM3459constructorimpl$default == null) {
            numArrM3459constructorimpl$default = BorderColors.m3459constructorimpl$default(null, 1, null);
        }
        this.borderColors = numArrM3459constructorimpl$default;
        if (numArrM3459constructorimpl$default != null) {
            numArrM3459constructorimpl$default[position.ordinal()] = num;
        }
        this.needUpdatePath = true;
        invalidateSelf();
    }

    public final int getBorderColor(LogicalEdge position) {
        Integer num;
        Intrinsics.checkNotNullParameter(position, "position");
        Integer[] numArr = this.borderColors;
        if (numArr == null || (num = numArr[position.ordinal()]) == null) {
            return -16777216;
        }
        return num.intValue();
    }

    private final void drawRectangularBorders(Canvas canvas) {
        RectF rectFComputeBorderInsets = computeBorderInsets();
        int iRoundToInt = MathKt.roundToInt(rectFComputeBorderInsets.left);
        int iRoundToInt2 = MathKt.roundToInt(rectFComputeBorderInsets.top);
        int iRoundToInt3 = MathKt.roundToInt(rectFComputeBorderInsets.right);
        int iRoundToInt4 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
        if (iRoundToInt > 0 || iRoundToInt3 > 0 || iRoundToInt2 > 0 || iRoundToInt4 > 0) {
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int i = bounds.left;
            int i2 = bounds.top;
            int iFastBorderCompatibleColorOrZero = fastBorderCompatibleColorOrZero(iRoundToInt, iRoundToInt2, iRoundToInt3, iRoundToInt4, this.computedBorderColors.getLeft(), this.computedBorderColors.getTop(), this.computedBorderColors.getRight(), this.computedBorderColors.getBottom());
            if (iFastBorderCompatibleColorOrZero != 0) {
                if (Color.alpha(iFastBorderCompatibleColorOrZero) != 0) {
                    int i3 = bounds.right;
                    int i4 = bounds.bottom;
                    this.borderPaint.setColor(multiplyColorAlpha(iFastBorderCompatibleColorOrZero, this.borderAlpha));
                    this.borderPaint.setStyle(Paint.Style.STROKE);
                    Path path = new Path();
                    this.pathForSingleBorder = path;
                    if (iRoundToInt > 0) {
                        path.reset();
                        int iRoundToInt5 = MathKt.roundToInt(rectFComputeBorderInsets.left);
                        updatePathEffect(iRoundToInt5);
                        this.borderPaint.setStrokeWidth(iRoundToInt5);
                        Path path2 = this.pathForSingleBorder;
                        if (path2 != null) {
                            path2.moveTo((iRoundToInt5 / 2) + i, i2);
                        }
                        Path path3 = this.pathForSingleBorder;
                        if (path3 != null) {
                            path3.lineTo((iRoundToInt5 / 2) + i, i4);
                        }
                        Path path4 = this.pathForSingleBorder;
                        if (path4 != null) {
                            canvas.drawPath(path4, this.borderPaint);
                        }
                    }
                    if (iRoundToInt2 > 0) {
                        Path path5 = this.pathForSingleBorder;
                        if (path5 != null) {
                            path5.reset();
                        }
                        int iRoundToInt6 = MathKt.roundToInt(rectFComputeBorderInsets.top);
                        updatePathEffect(iRoundToInt6);
                        this.borderPaint.setStrokeWidth(iRoundToInt6);
                        Path path6 = this.pathForSingleBorder;
                        if (path6 != null) {
                            path6.moveTo(i, (iRoundToInt6 / 2) + i2);
                        }
                        Path path7 = this.pathForSingleBorder;
                        if (path7 != null) {
                            path7.lineTo(i3, (iRoundToInt6 / 2) + i2);
                        }
                        Path path8 = this.pathForSingleBorder;
                        if (path8 != null) {
                            canvas.drawPath(path8, this.borderPaint);
                        }
                    }
                    if (iRoundToInt3 > 0) {
                        Path path9 = this.pathForSingleBorder;
                        if (path9 != null) {
                            path9.reset();
                        }
                        int iRoundToInt7 = MathKt.roundToInt(rectFComputeBorderInsets.right);
                        updatePathEffect(iRoundToInt7);
                        this.borderPaint.setStrokeWidth(iRoundToInt7);
                        Path path10 = this.pathForSingleBorder;
                        if (path10 != null) {
                            path10.moveTo(i3 - (iRoundToInt7 / 2), i2);
                        }
                        Path path11 = this.pathForSingleBorder;
                        if (path11 != null) {
                            path11.lineTo(i3 - (iRoundToInt7 / 2), i4);
                        }
                        Path path12 = this.pathForSingleBorder;
                        if (path12 != null) {
                            canvas.drawPath(path12, this.borderPaint);
                        }
                    }
                    if (iRoundToInt4 > 0) {
                        Path path13 = this.pathForSingleBorder;
                        if (path13 != null) {
                            path13.reset();
                        }
                        int iRoundToInt8 = MathKt.roundToInt(rectFComputeBorderInsets.bottom);
                        updatePathEffect(iRoundToInt8);
                        this.borderPaint.setStrokeWidth(iRoundToInt8);
                        Path path14 = this.pathForSingleBorder;
                        if (path14 != null) {
                            path14.moveTo(i, i4 - (iRoundToInt8 / 2));
                        }
                        Path path15 = this.pathForSingleBorder;
                        if (path15 != null) {
                            path15.lineTo(i3, i4 - (iRoundToInt8 / 2));
                        }
                        Path path16 = this.pathForSingleBorder;
                        if (path16 != null) {
                            canvas.drawPath(path16, this.borderPaint);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.borderPaint.setAntiAlias(false);
            int iWidth = bounds.width();
            int iHeight = bounds.height();
            if (iRoundToInt > 0) {
                float f = i;
                float f2 = i + iRoundToInt;
                int i5 = i2 + iHeight;
                drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, i2, f2, i2 + iRoundToInt2, f2, i5 - iRoundToInt4, f, i5);
            }
            if (iRoundToInt2 > 0) {
                float f3 = i2;
                float f4 = i + iRoundToInt;
                float f5 = i2 + iRoundToInt2;
                int i6 = i + iWidth;
                drawQuadrilateral(canvas, this.computedBorderColors.getTop(), i, f3, f4, f5, i6 - iRoundToInt3, f5, i6, f3);
            }
            if (iRoundToInt3 > 0) {
                int i7 = i + iWidth;
                float f6 = i7;
                int i8 = i2 + iHeight;
                float f7 = i7 - iRoundToInt3;
                drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f6, i2, f6, i8, f7, i8 - iRoundToInt4, f7, i2 + iRoundToInt2);
            }
            if (iRoundToInt4 > 0) {
                int i9 = i2 + iHeight;
                float f8 = i9;
                int i10 = i + iWidth;
                float f9 = i9 - iRoundToInt4;
                drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), i, f8, i10, f8, i10 - iRoundToInt3, f9, i + iRoundToInt, f9);
            }
            this.borderPaint.setAntiAlias(true);
        }
    }

    private final void drawRoundedBorders(Canvas canvas) {
        PointF pointF;
        PointF pointF2;
        CornerRadii topLeft;
        CornerRadii pixelFromDIP;
        CornerRadii topLeft2;
        CornerRadii pixelFromDIP2;
        updatePath();
        canvas.save();
        Path path = this.outerClipPathForBorderRadius;
        if (path == null) {
            throw new IllegalStateException("Required value was null.");
        }
        canvas.clipPath(path);
        RectF rectFComputeBorderInsets = computeBorderInsets();
        float vertical = 0.0f;
        if (rectFComputeBorderInsets.top > 0.0f || rectFComputeBorderInsets.bottom > 0.0f || rectFComputeBorderInsets.left > 0.0f || rectFComputeBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            int borderColor = getBorderColor(LogicalEdge.ALL);
            if (rectFComputeBorderInsets.top != fullBorderWidth || rectFComputeBorderInsets.bottom != fullBorderWidth || rectFComputeBorderInsets.left != fullBorderWidth || rectFComputeBorderInsets.right != fullBorderWidth || this.computedBorderColors.getLeft() != borderColor || this.computedBorderColors.getTop() != borderColor || this.computedBorderColors.getRight() != borderColor || this.computedBorderColors.getBottom() != borderColor) {
                this.borderPaint.setStyle(Paint.Style.FILL);
                if (Build.VERSION.SDK_INT >= 26) {
                    Path path2 = this.innerClipPathForBorderRadius;
                    if (path2 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.clipOutPath(path2);
                } else {
                    Path path3 = this.innerClipPathForBorderRadius;
                    if (path3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.clipPath(path3, Region.Op.DIFFERENCE);
                }
                RectF rectF = this.outerClipTempRectForBorderRadius;
                if (rectF == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                float f = rectF.left;
                float f2 = rectF.right;
                float f3 = rectF.top;
                float f4 = rectF.bottom;
                PointF pointF3 = this.innerTopLeftCorner;
                if (pointF3 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF4 = this.innerTopRightCorner;
                if (pointF4 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF5 = this.innerBottomLeftCorner;
                if (pointF5 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                PointF pointF6 = this.innerBottomRightCorner;
                if (pointF6 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                if (rectFComputeBorderInsets.left > 0.0f) {
                    float f5 = this.gapBetweenPaths;
                    float f6 = f5 + f4;
                    pointF2 = pointF6;
                    pointF = pointF4;
                    drawQuadrilateral(canvas, this.computedBorderColors.getLeft(), f, f3 - f5, pointF3.x, pointF3.y - f5, pointF5.x, pointF5.y + f5, f, f6);
                } else {
                    pointF = pointF4;
                    pointF2 = pointF6;
                }
                if (rectFComputeBorderInsets.top > vertical) {
                    float f7 = this.gapBetweenPaths;
                    drawQuadrilateral(canvas, this.computedBorderColors.getTop(), f - f7, f3, pointF3.x - f7, pointF3.y, pointF.x + f7, pointF.y, f2 + f7, f3);
                }
                if (rectFComputeBorderInsets.right > vertical) {
                    float f8 = this.gapBetweenPaths;
                    drawQuadrilateral(canvas, this.computedBorderColors.getRight(), f2, f3 - f8, pointF.x, pointF.y - f8, pointF2.x, pointF2.y + f8, f2, f4 + f8);
                }
                if (rectFComputeBorderInsets.bottom > 0) {
                    float f9 = this.gapBetweenPaths;
                    drawQuadrilateral(canvas, this.computedBorderColors.getBottom(), f - f9, f4, pointF5.x - f9, pointF5.y, pointF2.x + f9, pointF2.y, f2 + f9, f4);
                }
            } else if (fullBorderWidth > 0.0f) {
                this.borderPaint.setColor(multiplyColorAlpha(borderColor, this.borderAlpha));
                this.borderPaint.setStyle(Paint.Style.STROKE);
                this.borderPaint.setStrokeWidth(fullBorderWidth);
                ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
                if (computedBorderRadius != null && computedBorderRadius.isUniform()) {
                    RectF rectF2 = this.tempRectForCenterDrawPath;
                    if (rectF2 != null) {
                        ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
                        float horizontal = ((computedBorderRadius2 == null || (topLeft2 = computedBorderRadius2.getTopLeft()) == null || (pixelFromDIP2 = topLeft2.toPixelFromDIP()) == null) ? 0.0f : pixelFromDIP2.getHorizontal()) - (rectFComputeBorderInsets.left * 0.5f);
                        ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
                        if (computedBorderRadius3 != null && (topLeft = computedBorderRadius3.getTopLeft()) != null && (pixelFromDIP = topLeft.toPixelFromDIP()) != null) {
                            vertical = pixelFromDIP.getVertical();
                        }
                        canvas.drawRoundRect(rectF2, horizontal, vertical - (rectFComputeBorderInsets.top * 0.5f), this.borderPaint);
                    }
                } else {
                    Path path4 = this.centerDrawPath;
                    if (path4 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    canvas.drawPath(path4, this.borderPaint);
                }
            }
        }
        canvas.restore();
    }

    private final int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (Color.alpha(i5) >= 255 && Color.alpha(i6) >= 255 && Color.alpha(i7) >= 255 && Color.alpha(i8) >= 255) {
            int i9 = (i4 > 0 ? i8 : -1) & (i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1);
            if (i <= 0) {
                i5 = 0;
            }
            if (i2 <= 0) {
                i6 = 0;
            }
            int i10 = i5 | i6;
            if (i3 <= 0) {
                i7 = 0;
            }
            int i11 = i10 | i7;
            if (i4 <= 0) {
                i8 = 0;
            }
            if (i9 == (i11 | i8)) {
                return i9;
            }
        }
        return 0;
    }

    private final void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i == 0) {
            return;
        }
        if (this.pathForBorder == null) {
            this.pathForBorder = new Path();
        }
        this.borderPaint.setColor(multiplyColorAlpha(i, this.borderAlpha));
        Path path = this.pathForBorder;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.pathForBorder;
        if (path2 != null) {
            path2.moveTo(f, f2);
        }
        Path path3 = this.pathForBorder;
        if (path3 != null) {
            path3.lineTo(f3, f4);
        }
        Path path4 = this.pathForBorder;
        if (path4 != null) {
            path4.lineTo(f5, f6);
        }
        Path path5 = this.pathForBorder;
        if (path5 != null) {
            path5.lineTo(f7, f8);
        }
        Path path6 = this.pathForBorder;
        if (path6 != null) {
            path6.lineTo(f, f2);
        }
        Path path7 = this.pathForBorder;
        if (path7 != null) {
            canvas.drawPath(path7, this.borderPaint);
        }
    }

    private final RectF computeBorderInsets() {
        RectF rectFResolve;
        BorderInsets borderInsets = this.borderInsets;
        if (borderInsets != null && (rectFResolve = borderInsets.resolve(getLayoutDirection(), this.context)) != null) {
            return new RectF(Float.isNaN(rectFResolve.left) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.left), Float.isNaN(rectFResolve.top) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.top), Float.isNaN(rectFResolve.right) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.right), Float.isNaN(rectFResolve.bottom) ? 0.0f : PixelUtil.INSTANCE.dpToPx(rectFResolve.bottom));
        }
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private final float getFullBorderWidth() {
        Spacing spacing = this.borderWidth;
        float raw = spacing != null ? spacing.getRaw(8) : Float.NaN;
        if (Float.isNaN(raw)) {
            return 0.0f;
        }
        return raw;
    }

    private final void updatePathEffect() {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, getFullBorderWidth()) : null);
        }
    }

    private final void updatePathEffect(int i) {
        BorderStyle borderStyle = getBorderStyle();
        if (borderStyle != null) {
            this.borderPaint.setPathEffect(getBorderStyle() != null ? getPathEffect(borderStyle, i) : null);
        }
    }

    private final PathEffect getPathEffect(BorderStyle borderStyle, float f) {
        int i = WhenMappings.$EnumSwitchMapping$0[borderStyle.ordinal()];
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

    private final void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        double d9 = 2;
        double d10 = (d + d3) / d9;
        double d11 = (d2 + d4) / d9;
        double d12 = d5 - d10;
        double d13 = d6 - d11;
        double dAbs = Math.abs(d3 - d) / d9;
        double dAbs2 = Math.abs(d4 - d2) / d9;
        double d14 = ((d8 - d11) - d13) / ((d7 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = dAbs2 * dAbs2;
        double d17 = dAbs * dAbs;
        double d18 = d16 + (d17 * d14 * d14);
        double d19 = d9 * dAbs * dAbs * d15 * d14;
        double d20 = d9 * d18;
        double dSqrt = ((-d19) / d20) - Math.sqrt(((-(d17 * ((d15 * d15) - d16))) / d18) + Math.pow(d19 / d20, 2.0d));
        double d21 = (d14 * dSqrt) + d15;
        double d22 = dSqrt + d10;
        double d23 = d21 + d11;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x02f8  */
    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        char c;
        char c2;
        Path path;
        int i;
        Path path2;
        Path path3;
        CornerRadii bottomRight;
        CornerRadii bottomLeft;
        CornerRadii topRight;
        CornerRadii topLeft;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            Path path4 = this.innerClipPathForBorderRadius;
            if (path4 == null) {
                path4 = new Path();
            }
            this.innerClipPathForBorderRadius = path4;
            Path path5 = this.outerClipPathForBorderRadius;
            if (path5 == null) {
                path5 = new Path();
            }
            this.outerClipPathForBorderRadius = path5;
            this.pathForOutline = new Path();
            RectF rectF = this.innerClipTempRectForBorderRadius;
            if (rectF == null) {
                rectF = new RectF();
            }
            this.innerClipTempRectForBorderRadius = rectF;
            RectF rectF2 = this.outerClipTempRectForBorderRadius;
            if (rectF2 == null) {
                rectF2 = new RectF();
            }
            this.outerClipTempRectForBorderRadius = rectF2;
            RectF rectF3 = this.tempRectForCenterDrawPath;
            if (rectF3 == null) {
                rectF3 = new RectF();
            }
            this.tempRectForCenterDrawPath = rectF3;
            Path path6 = this.innerClipPathForBorderRadius;
            if (path6 != null) {
                path6.reset();
                Unit unit = Unit.INSTANCE;
            }
            Path path7 = this.outerClipPathForBorderRadius;
            if (path7 != null) {
                path7.reset();
                Unit unit2 = Unit.INSTANCE;
            }
            RectF rectF4 = this.innerClipTempRectForBorderRadius;
            if (rectF4 != null) {
                rectF4.set(getBounds());
                Unit unit3 = Unit.INSTANCE;
            }
            RectF rectF5 = this.outerClipTempRectForBorderRadius;
            if (rectF5 != null) {
                rectF5.set(getBounds());
                Unit unit4 = Unit.INSTANCE;
            }
            RectF rectF6 = this.tempRectForCenterDrawPath;
            if (rectF6 != null) {
                rectF6.set(getBounds());
                Unit unit5 = Unit.INSTANCE;
            }
            RectF rectFComputeBorderInsets = computeBorderInsets();
            if (Color.alpha(this.computedBorderColors.getLeft()) != 0 || Color.alpha(this.computedBorderColors.getTop()) != 0 || Color.alpha(this.computedBorderColors.getRight()) != 0 || Color.alpha(this.computedBorderColors.getBottom()) != 0) {
                RectF rectF7 = this.innerClipTempRectForBorderRadius;
                if (rectF7 != null) {
                    rectF7.top = rectF7 != null ? rectF7.top + rectFComputeBorderInsets.top : 0.0f;
                    Unit unit6 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.bottom = rectF7 != null ? rectF7.bottom - rectFComputeBorderInsets.bottom : 0.0f;
                    Unit unit7 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.left = rectF7 != null ? rectF7.left + rectFComputeBorderInsets.left : 0.0f;
                    Unit unit8 = Unit.INSTANCE;
                }
                if (rectF7 != null) {
                    rectF7.right = rectF7 != null ? rectF7.right - rectFComputeBorderInsets.right : 0.0f;
                    Unit unit9 = Unit.INSTANCE;
                }
            }
            RectF rectF8 = this.tempRectForCenterDrawPath;
            if (rectF8 != null) {
                rectF8.top = rectF8 != null ? rectF8.top + (rectFComputeBorderInsets.top * 0.5f) : 0.0f;
                Unit unit10 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.bottom = rectF8 != null ? rectF8.bottom - (rectFComputeBorderInsets.bottom * 0.5f) : 0.0f;
                Unit unit11 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.left = rectF8 != null ? rectF8.left + (rectFComputeBorderInsets.left * 0.5f) : 0.0f;
                Unit unit12 = Unit.INSTANCE;
            }
            if (rectF8 != null) {
                rectF8.right = rectF8 != null ? rectF8.right - (rectFComputeBorderInsets.right * 0.5f) : 0.0f;
                Unit unit13 = Unit.INSTANCE;
            }
            BorderRadiusStyle borderRadiusStyle = this.borderRadius;
            if (borderRadiusStyle != null) {
                int layoutDirection = getLayoutDirection();
                Context context = this.context;
                RectF rectF9 = this.outerClipTempRectForBorderRadius;
                float fPxToDp = rectF9 != null ? PixelUtil.INSTANCE.pxToDp(rectF9.width()) : 0.0f;
                RectF rectF10 = this.outerClipTempRectForBorderRadius;
                computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, fPxToDp, rectF10 != null ? PixelUtil.INSTANCE.pxToDp(rectF10.height()) : 0.0f);
            } else {
                computedBorderRadiusResolve = null;
            }
            this.computedBorderRadius = computedBorderRadiusResolve;
            if (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null || (cornerRadii = topLeft.toPixelFromDIP()) == null) {
                cornerRadii = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius = this.computedBorderRadius;
            if (computedBorderRadius == null || (topRight = computedBorderRadius.getTopRight()) == null || (cornerRadii2 = topRight.toPixelFromDIP()) == null) {
                cornerRadii2 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius2 = this.computedBorderRadius;
            if (computedBorderRadius2 == null || (bottomLeft = computedBorderRadius2.getBottomLeft()) == null || (cornerRadii3 = bottomLeft.toPixelFromDIP()) == null) {
                cornerRadii3 = new CornerRadii(0.0f, 0.0f);
            }
            ComputedBorderRadius computedBorderRadius3 = this.computedBorderRadius;
            if (computedBorderRadius3 == null || (bottomRight = computedBorderRadius3.getBottomRight()) == null || (cornerRadii4 = bottomRight.toPixelFromDIP()) == null) {
                cornerRadii4 = new CornerRadii(0.0f, 0.0f);
            }
            float innerBorderRadius = getInnerBorderRadius(cornerRadii.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius2 = getInnerBorderRadius(cornerRadii.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius3 = getInnerBorderRadius(cornerRadii2.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius4 = getInnerBorderRadius(cornerRadii2.getVertical(), rectFComputeBorderInsets.top);
            float innerBorderRadius5 = getInnerBorderRadius(cornerRadii4.getHorizontal(), rectFComputeBorderInsets.right);
            float innerBorderRadius6 = getInnerBorderRadius(cornerRadii4.getVertical(), rectFComputeBorderInsets.bottom);
            float innerBorderRadius7 = getInnerBorderRadius(cornerRadii3.getHorizontal(), rectFComputeBorderInsets.left);
            float innerBorderRadius8 = getInnerBorderRadius(cornerRadii3.getVertical(), rectFComputeBorderInsets.bottom);
            RectF rectF11 = this.innerClipTempRectForBorderRadius;
            if (rectF11 == null || (path3 = this.innerClipPathForBorderRadius) == null) {
                c = 7;
            } else {
                c = 7;
                path3.addRoundRect(rectF11, new float[]{innerBorderRadius, innerBorderRadius2, innerBorderRadius3, innerBorderRadius4, innerBorderRadius5, innerBorderRadius6, innerBorderRadius7, innerBorderRadius8}, Path.Direction.CW);
                Unit unit14 = Unit.INSTANCE;
            }
            RectF rectF12 = this.outerClipTempRectForBorderRadius;
            if (rectF12 == null || (path2 = this.outerClipPathForBorderRadius) == null) {
                c2 = 5;
            } else {
                float horizontal = cornerRadii.getHorizontal();
                float vertical = cornerRadii.getVertical();
                float horizontal2 = cornerRadii2.getHorizontal();
                float vertical2 = cornerRadii2.getVertical();
                float horizontal3 = cornerRadii4.getHorizontal();
                float vertical3 = cornerRadii4.getVertical();
                float horizontal4 = cornerRadii3.getHorizontal();
                float vertical4 = cornerRadii3.getVertical();
                c2 = 5;
                float[] fArr = new float[8];
                fArr[0] = horizontal;
                fArr[1] = vertical;
                fArr[2] = horizontal2;
                fArr[3] = vertical2;
                fArr[4] = horizontal3;
                fArr[5] = vertical3;
                fArr[6] = horizontal4;
                fArr[c] = vertical4;
                path2.addRoundRect(rectF12, fArr, Path.Direction.CW);
                Unit unit15 = Unit.INSTANCE;
            }
            Spacing spacing = this.borderWidth;
            float f = spacing != null ? spacing.get(8) / 2.0f : 0.0f;
            Path path8 = this.pathForOutline;
            if (path8 != null) {
                RectF rectF13 = new RectF(getBounds());
                float horizontal5 = cornerRadii.getHorizontal() + f;
                float vertical5 = cornerRadii.getVertical() + f;
                float horizontal6 = cornerRadii2.getHorizontal() + f;
                float vertical6 = cornerRadii2.getVertical() + f;
                float horizontal7 = cornerRadii4.getHorizontal() + f;
                float vertical7 = cornerRadii4.getVertical() + f;
                float horizontal8 = cornerRadii3.getHorizontal() + f;
                float vertical8 = cornerRadii3.getVertical() + f;
                float[] fArr2 = new float[8];
                fArr2[0] = horizontal5;
                fArr2[1] = vertical5;
                fArr2[2] = horizontal6;
                fArr2[3] = vertical6;
                fArr2[4] = horizontal7;
                fArr2[c2] = vertical7;
                fArr2[r13] = horizontal8;
                fArr2[c] = vertical8;
                path8.addRoundRect(rectF13, fArr2, Path.Direction.CW);
                Unit unit16 = Unit.INSTANCE;
            }
            ComputedBorderRadius computedBorderRadius4 = this.computedBorderRadius;
            if (computedBorderRadius4 == null || !computedBorderRadius4.isUniform()) {
                Path path9 = this.centerDrawPath;
                if (path9 == null) {
                    path9 = new Path();
                }
                this.centerDrawPath = path9;
                path9.reset();
                Unit unit17 = Unit.INSTANCE;
                RectF rectF14 = this.tempRectForCenterDrawPath;
                if (rectF14 == null || (path = this.centerDrawPath) == null) {
                    i = 2;
                } else {
                    float horizontal9 = cornerRadii.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f);
                    float vertical9 = cornerRadii.getVertical() - (rectFComputeBorderInsets.top * 0.5f);
                    float horizontal10 = cornerRadii2.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f);
                    float vertical10 = cornerRadii2.getVertical() - (rectFComputeBorderInsets.top * 0.5f);
                    float horizontal11 = cornerRadii4.getHorizontal() - (rectFComputeBorderInsets.right * 0.5f);
                    float vertical11 = cornerRadii4.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f);
                    i = 2;
                    float horizontal12 = cornerRadii3.getHorizontal() - (rectFComputeBorderInsets.left * 0.5f);
                    float vertical12 = cornerRadii3.getVertical() - (rectFComputeBorderInsets.bottom * 0.5f);
                    float[] fArr3 = new float[8];
                    fArr3[0] = horizontal9;
                    fArr3[1] = vertical9;
                    fArr3[2] = horizontal10;
                    fArr3[3] = vertical10;
                    fArr3[4] = horizontal11;
                    fArr3[c2] = vertical11;
                    fArr3[r13] = horizontal12;
                    fArr3[c] = vertical12;
                    path.addRoundRect(rectF14, fArr3, Path.Direction.CW);
                    Unit unit18 = Unit.INSTANCE;
                }
            } else {
                i = 2;
            }
            RectF rectF15 = this.innerClipTempRectForBorderRadius;
            RectF rectF16 = this.outerClipTempRectForBorderRadius;
            if (rectF15 == null || rectF16 == null) {
                return;
            }
            PointF pointF = this.innerTopLeftCorner;
            if (pointF == null) {
                pointF = new PointF();
            }
            this.innerTopLeftCorner = pointF;
            pointF.x = rectF15.left;
            Unit unit19 = Unit.INSTANCE;
            pointF.y = rectF15.top;
            Unit unit20 = Unit.INSTANCE;
            float f2 = rectF15.left;
            float f3 = rectF15.top;
            float f4 = i;
            getEllipseIntersectionWithLine(f2, f3, (innerBorderRadius * f4) + f2, (f4 * innerBorderRadius2) + f3, rectF16.left, rectF16.top, f2, f3, pointF);
            Unit unit21 = Unit.INSTANCE;
            PointF pointF2 = this.innerBottomLeftCorner;
            if (pointF2 == null) {
                pointF2 = new PointF();
            }
            this.innerBottomLeftCorner = pointF2;
            pointF2.x = rectF15.left;
            Unit unit22 = Unit.INSTANCE;
            pointF2.y = rectF15.bottom;
            Unit unit23 = Unit.INSTANCE;
            float f5 = rectF15.left;
            float f6 = rectF15.bottom;
            float f7 = 2;
            getEllipseIntersectionWithLine(f5, f6 - (innerBorderRadius8 * f7), (f7 * innerBorderRadius7) + f5, f6, rectF16.left, rectF16.bottom, f5, f6, pointF2);
            Unit unit24 = Unit.INSTANCE;
            PointF pointF3 = this.innerTopRightCorner;
            if (pointF3 == null) {
                pointF3 = new PointF();
            }
            this.innerTopRightCorner = pointF3;
            pointF3.x = rectF15.right;
            Unit unit25 = Unit.INSTANCE;
            pointF3.y = rectF15.top;
            Unit unit26 = Unit.INSTANCE;
            float f8 = rectF15.right;
            float f9 = 2;
            float f10 = rectF15.top;
            getEllipseIntersectionWithLine(f8 - (innerBorderRadius3 * f9), f10, f8, (f9 * innerBorderRadius4) + f10, rectF16.right, rectF16.top, f8, f10, pointF3);
            Unit unit27 = Unit.INSTANCE;
            PointF pointF4 = this.innerBottomRightCorner;
            if (pointF4 == null) {
                pointF4 = new PointF();
            }
            this.innerBottomRightCorner = pointF4;
            pointF4.x = rectF15.right;
            Unit unit28 = Unit.INSTANCE;
            pointF4.y = rectF15.bottom;
            Unit unit29 = Unit.INSTANCE;
            float f11 = rectF15.right;
            float f12 = 2;
            float f13 = rectF15.bottom;
            getEllipseIntersectionWithLine(f11 - (innerBorderRadius5 * f12), f13 - (f12 * innerBorderRadius6), f11, f13, rectF16.right, rectF16.bottom, f11, f13, pointF4);
            Unit unit30 = Unit.INSTANCE;
        }
    }
}
