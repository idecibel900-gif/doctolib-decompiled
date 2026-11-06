package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BackgroundPosition;
import com.facebook.react.uimanager.style.BackgroundRepeat;
import com.facebook.react.uimanager.style.BackgroundRepeatKeyword;
import com.facebook.react.uimanager.style.BackgroundSize;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundImageDrawable extends Drawable {
    private Path backgroundImageClipPath;
    private List backgroundImageLayers;
    private final Paint backgroundPaint;
    private RectF backgroundPaintingArea;
    private List backgroundPosition;
    private RectF backgroundPositioningArea;
    private List backgroundRepeat;
    private List backgroundSize;
    private BorderInsets borderInsets;
    private BorderRadiusStyle borderRadius;
    private final Context context;
    private boolean needUpdatePath;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void setBorderRadius(BorderRadiusStyle borderRadiusStyle) {
        this.borderRadius = borderRadiusStyle;
    }

    public final void setBorderInsets(BorderInsets borderInsets) {
        this.borderInsets = borderInsets;
    }

    public BackgroundImageDrawable(Context context, BorderRadiusStyle borderRadiusStyle, BorderInsets borderInsets) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderRadius = borderRadiusStyle;
        this.borderInsets = borderInsets;
        this.needUpdatePath = true;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.backgroundPaint = paint;
    }

    public final void setBackgroundImageLayers(List list) {
        if (Intrinsics.areEqual(this.backgroundImageLayers, list)) {
            return;
        }
        this.backgroundImageLayers = list;
        invalidateSelf();
    }

    public final void setBackgroundSize(List list) {
        if (Intrinsics.areEqual(this.backgroundSize, list)) {
            return;
        }
        this.backgroundSize = list;
        invalidateSelf();
    }

    public final void setBackgroundPosition(List list) {
        if (Intrinsics.areEqual(this.backgroundPosition, list)) {
            return;
        }
        this.backgroundPosition = list;
        invalidateSelf();
    }

    public final void setBackgroundRepeat(List list) {
        if (Intrinsics.areEqual(this.backgroundRepeat, list)) {
            return;
        }
        this.backgroundRepeat = list;
        invalidateSelf();
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
        this.backgroundPaint.setAlpha(i);
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

    /* JADX WARN: Code duplicated, block: B:69:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x019e  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:90:0x0225  */
    /* JADX WARN: Code duplicated, block: B:94:0x0235  */
    /* JADX WARN: Code duplicated, block: B:96:0x023a A[LOOP:2: B:95:0x0238->B:96:0x023a, LOOP_END] */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF;
        int size;
        int i;
        RectF rectF2;
        BackgroundRepeatKeyword x;
        float f;
        float f2;
        float f3;
        int i2;
        int i3;
        float f4;
        BackgroundRepeatKeyword y;
        float fRint;
        float f5;
        int i4;
        int i5;
        float f6;
        float f7;
        int i6;
        int i7;
        float f8;
        float fRint2;
        BackgroundImageDrawable backgroundImageDrawable = this;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        List list = backgroundImageDrawable.backgroundImageLayers;
        if (list != null) {
            int i8 = 1;
            if (list != null && list.isEmpty()) {
                return;
            }
            backgroundImageDrawable.updatePath();
            RectF rectF3 = backgroundImageDrawable.backgroundPaintingArea;
            if (rectF3 != null && (rectF = backgroundImageDrawable.backgroundPositioningArea) != null && !backgroundImageDrawable.hasInvalidDimensions(rectF, rectF3)) {
                canvas2.save();
                Path path = backgroundImageDrawable.backgroundImageClipPath;
                if (path != null) {
                    canvas2.clipPath(path);
                }
                List list2 = backgroundImageDrawable.backgroundImageLayers;
                if (list2 != null && (size = list2.size() - 1) >= 0) {
                    while (true) {
                        int i9 = size - 1;
                        BackgroundImageLayer backgroundImageLayer = (BackgroundImageLayer) list2.get(size);
                        List list3 = backgroundImageDrawable.backgroundSize;
                        BackgroundSize backgroundSize = list3 != null ? (BackgroundSize) CollectionsKt.getOrNull(list3, size % list3.size()) : null;
                        List list4 = backgroundImageDrawable.backgroundRepeat;
                        BackgroundRepeat backgroundRepeat = list4 != null ? (BackgroundRepeat) CollectionsKt.getOrNull(list4, size % list4.size()) : null;
                        List list5 = backgroundImageDrawable.backgroundPosition;
                        BackgroundPosition backgroundPosition = list5 != null ? (BackgroundPosition) CollectionsKt.getOrNull(list5, size % list5.size()) : null;
                        Pair pairCalculateBackgroundImageSize = backgroundImageDrawable.calculateBackgroundImageSize(rectF.width(), rectF.height(), rectF.width(), rectF.height(), backgroundSize, backgroundRepeat);
                        BackgroundRepeat backgroundRepeat2 = backgroundRepeat;
                        BackgroundImageDrawable backgroundImageDrawable2 = backgroundImageDrawable;
                        float fFloatValue = ((Number) pairCalculateBackgroundImageSize.getFirst()).floatValue();
                        float fFloatValue2 = ((Number) pairCalculateBackgroundImageSize.getSecond()).floatValue();
                        if (fFloatValue <= 0.0f || fFloatValue2 <= 0.0f) {
                            i = i8;
                            rectF2 = rectF3;
                            rectF = rectF;
                        } else {
                            backgroundImageDrawable2.backgroundPaint.setShader(backgroundImageLayer.getShader(fFloatValue, fFloatValue2));
                            Pair pairCalculateBackgroundPosition = backgroundImageDrawable2.calculateBackgroundPosition(fFloatValue, fFloatValue2, backgroundPosition);
                            float fFloatValue3 = ((Number) pairCalculateBackgroundPosition.getFirst()).floatValue();
                            float fFloatValue4 = ((Number) pairCalculateBackgroundPosition.getSecond()).floatValue();
                            if (backgroundRepeat2 == null || (x = backgroundRepeat2.getX()) == null) {
                                x = BackgroundRepeatKeyword.Repeat;
                            }
                            BackgroundRepeatKeyword backgroundRepeatKeyword = BackgroundRepeatKeyword.Space;
                            if (x == backgroundRepeatKeyword) {
                                float fWidth = rectF3.width() - (2 * fFloatValue);
                                i = i8;
                                RectF rectF4 = rectF3;
                                float fRint3 = (float) Math.rint(fFloatValue);
                                if (fRint3 <= 0.0f || (fWidth <= 0.0f && !FloatUtil.floatsEqual(fWidth, 0.0f))) {
                                    f2 = 0.0f;
                                    f = fFloatValue4;
                                    rectF2 = rectF4;
                                } else {
                                    f = fFloatValue4;
                                    int iFloor = (int) Math.floor(((float) Math.rint(fWidth)) / fRint3);
                                    int i10 = iFloor + 2;
                                    float f9 = (fWidth - (iFloor * fFloatValue)) / (iFloor + 1);
                                    rectF2 = rectF4;
                                    fFloatValue3 = rectF2.left;
                                    backgroundRepeat2 = backgroundRepeat2;
                                    f3 = 0.0f;
                                    rectF = rectF;
                                    f4 = f9;
                                    i3 = i10;
                                }
                                if (backgroundRepeat2 != null || (y = backgroundRepeat2.getY()) == null) {
                                    y = BackgroundRepeatKeyword.Repeat;
                                }
                                if (y == backgroundRepeatKeyword) {
                                    float fHeight = rectF2.height() - (2 * fFloatValue2);
                                    fRint2 = (float) Math.rint(fFloatValue2);
                                    if (fRint2 <= f3 && (fHeight > f3 || FloatUtil.floatsEqual(fHeight, f3))) {
                                        int iFloor2 = (int) Math.floor(((float) Math.rint(fHeight)) / fRint2);
                                        f = rectF2.top;
                                        f4 = f4;
                                        i5 = iFloor2 + 2;
                                        f6 = (fHeight - (iFloor2 * fFloatValue2)) / (iFloor2 + 1);
                                    }
                                    f7 = fFloatValue3;
                                    i6 = 0;
                                    while (i6 < i3) {
                                        i7 = 0;
                                        f8 = f;
                                        while (i7 < i5) {
                                            canvas2.save();
                                            canvas2.translate(f7, f8);
                                            canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                            canvas.restore();
                                            f8 += fFloatValue2 + f6;
                                            i7++;
                                            i3 = i3;
                                            i6 = i6;
                                            canvas2 = canvas;
                                        }
                                        f7 += fFloatValue + f4;
                                        i6++;
                                        i3 = i3;
                                        canvas2 = canvas;
                                    }
                                } else {
                                    if (y != BackgroundRepeatKeyword.Round || y == BackgroundRepeatKeyword.Repeat) {
                                        fRint = (float) Math.rint(fFloatValue2);
                                        if (fRint > 0.0f) {
                                            float f10 = f;
                                            int iCeil = (int) Math.ceil(((float) Math.rint(f10)) / fRint);
                                            int iCeil2 = ((int) Math.ceil(((float) Math.rint(rectF2.height() - f10)) / fRint)) + iCeil;
                                            f5 = f10 - (iCeil * fFloatValue2);
                                            i4 = iCeil2;
                                        } else {
                                            f5 = f;
                                            i4 = i;
                                        }
                                        f = f5;
                                        i5 = i4;
                                    }
                                    f6 = 0.0f;
                                    f7 = fFloatValue3;
                                    i6 = 0;
                                    while (i6 < i3) {
                                        i7 = 0;
                                        f8 = f;
                                        while (i7 < i5) {
                                            canvas2.save();
                                            canvas2.translate(f7, f8);
                                            canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                            canvas.restore();
                                            f8 += fFloatValue2 + f6;
                                            i7++;
                                            i3 = i3;
                                            i6 = i6;
                                            canvas2 = canvas;
                                        }
                                        f7 += fFloatValue + f4;
                                        i6++;
                                        i3 = i3;
                                        canvas2 = canvas;
                                    }
                                }
                                f4 = f4;
                                i5 = i;
                                f6 = 0.0f;
                                f7 = fFloatValue3;
                                i6 = 0;
                                while (i6 < i3) {
                                    i7 = 0;
                                    f8 = f;
                                    while (i7 < i5) {
                                        canvas2.save();
                                        canvas2.translate(f7, f8);
                                        canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                        canvas.restore();
                                        f8 += fFloatValue2 + f6;
                                        i7++;
                                        i3 = i3;
                                        i6 = i6;
                                        canvas2 = canvas;
                                    }
                                    f7 += fFloatValue + f4;
                                    i6++;
                                    i3 = i3;
                                    canvas2 = canvas;
                                }
                            } else {
                                f = fFloatValue4;
                                i = i8;
                                rectF2 = rectF3;
                                f2 = 0.0f;
                                if (x == BackgroundRepeatKeyword.Round || x == BackgroundRepeatKeyword.Repeat) {
                                    float fRint4 = (float) Math.rint(fFloatValue);
                                    if (fRint4 > 0.0f) {
                                        int iCeil3 = (int) Math.ceil(((float) Math.rint(fFloatValue3)) / fRint4);
                                        f3 = 0.0f;
                                        int iCeil4 = ((int) Math.ceil(((float) Math.rint(rectF2.width() - fFloatValue3)) / fRint4)) + iCeil3;
                                        fFloatValue3 -= iCeil3 * fFloatValue;
                                        i2 = iCeil4;
                                    } else {
                                        f3 = 0.0f;
                                        i2 = i;
                                    }
                                    i3 = i2;
                                }
                                f4 = f3;
                                if (backgroundRepeat2 != null) {
                                    y = BackgroundRepeatKeyword.Repeat;
                                } else {
                                    y = BackgroundRepeatKeyword.Repeat;
                                }
                                if (y == backgroundRepeatKeyword) {
                                    float fHeight2 = rectF2.height() - (2 * fFloatValue2);
                                    fRint2 = (float) Math.rint(fFloatValue2);
                                    if (fRint2 <= f3) {
                                    }
                                } else {
                                    if (y != BackgroundRepeatKeyword.Round) {
                                    }
                                    fRint = (float) Math.rint(fFloatValue2);
                                    if (fRint > 0.0f) {
                                        float f11 = f;
                                        int iCeil5 = (int) Math.ceil(((float) Math.rint(f11)) / fRint);
                                        int iCeil6 = ((int) Math.ceil(((float) Math.rint(rectF2.height() - f11)) / fRint)) + iCeil5;
                                        f5 = f11 - (iCeil5 * fFloatValue2);
                                        i4 = iCeil6;
                                    } else {
                                        f5 = f;
                                        i4 = i;
                                    }
                                    f = f5;
                                    i5 = i4;
                                    f6 = 0.0f;
                                    f7 = fFloatValue3;
                                    i6 = 0;
                                    while (i6 < i3) {
                                        i7 = 0;
                                        f8 = f;
                                        while (i7 < i5) {
                                            canvas2.save();
                                            canvas2.translate(f7, f8);
                                            canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                            canvas.restore();
                                            f8 += fFloatValue2 + f6;
                                            i7++;
                                            i3 = i3;
                                            i6 = i6;
                                            canvas2 = canvas;
                                        }
                                        f7 += fFloatValue + f4;
                                        i6++;
                                        i3 = i3;
                                        canvas2 = canvas;
                                    }
                                }
                                f4 = f4;
                                i5 = i;
                                f6 = 0.0f;
                                f7 = fFloatValue3;
                                i6 = 0;
                                while (i6 < i3) {
                                    i7 = 0;
                                    f8 = f;
                                    while (i7 < i5) {
                                        canvas2.save();
                                        canvas2.translate(f7, f8);
                                        canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                        canvas.restore();
                                        f8 += fFloatValue2 + f6;
                                        i7++;
                                        i3 = i3;
                                        i6 = i6;
                                        canvas2 = canvas;
                                    }
                                    f7 += fFloatValue + f4;
                                    i6++;
                                    i3 = i3;
                                    canvas2 = canvas;
                                }
                            }
                            backgroundRepeat2 = backgroundRepeat2;
                            f3 = f2;
                            rectF = rectF;
                            i3 = i;
                            f4 = f3;
                            if (backgroundRepeat2 != null) {
                                y = BackgroundRepeatKeyword.Repeat;
                            } else {
                                y = BackgroundRepeatKeyword.Repeat;
                            }
                            if (y == backgroundRepeatKeyword) {
                                float fHeight3 = rectF2.height() - (2 * fFloatValue2);
                                fRint2 = (float) Math.rint(fFloatValue2);
                                if (fRint2 <= f3) {
                                }
                            } else {
                                if (y != BackgroundRepeatKeyword.Round) {
                                }
                                fRint = (float) Math.rint(fFloatValue2);
                                if (fRint > 0.0f) {
                                    float f12 = f;
                                    int iCeil7 = (int) Math.ceil(((float) Math.rint(f12)) / fRint);
                                    int iCeil8 = ((int) Math.ceil(((float) Math.rint(rectF2.height() - f12)) / fRint)) + iCeil7;
                                    f5 = f12 - (iCeil7 * fFloatValue2);
                                    i4 = iCeil8;
                                } else {
                                    f5 = f;
                                    i4 = i;
                                }
                                f = f5;
                                i5 = i4;
                                f6 = 0.0f;
                                f7 = fFloatValue3;
                                i6 = 0;
                                while (i6 < i3) {
                                    i7 = 0;
                                    f8 = f;
                                    while (i7 < i5) {
                                        canvas2.save();
                                        canvas2.translate(f7, f8);
                                        canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                        canvas.restore();
                                        f8 += fFloatValue2 + f6;
                                        i7++;
                                        i3 = i3;
                                        i6 = i6;
                                        canvas2 = canvas;
                                    }
                                    f7 += fFloatValue + f4;
                                    i6++;
                                    i3 = i3;
                                    canvas2 = canvas;
                                }
                            }
                            f4 = f4;
                            i5 = i;
                            f6 = 0.0f;
                            f7 = fFloatValue3;
                            i6 = 0;
                            while (i6 < i3) {
                                i7 = 0;
                                f8 = f;
                                while (i7 < i5) {
                                    canvas2.save();
                                    canvas2.translate(f7, f8);
                                    canvas2.drawRect(0.0f, 0.0f, fFloatValue, fFloatValue2, backgroundImageDrawable2.backgroundPaint);
                                    canvas.restore();
                                    f8 += fFloatValue2 + f6;
                                    i7++;
                                    i3 = i3;
                                    i6 = i6;
                                    canvas2 = canvas;
                                }
                                f7 += fFloatValue + f4;
                                i6++;
                                i3 = i3;
                                canvas2 = canvas;
                            }
                        }
                        if (i9 < 0) {
                            break;
                        }
                        canvas2 = canvas;
                        backgroundImageDrawable = backgroundImageDrawable2;
                        rectF3 = rectF2;
                        size = i9;
                        rectF = rectF;
                        i8 = i;
                    }
                }
                canvas.restore();
            }
        }
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

    private final boolean hasInvalidDimensions(RectF rectF, RectF rectF2) {
        return FloatUtil.floatsEqual(rectF.width(), 0.0f) || rectF.width() < 0.0f || FloatUtil.floatsEqual(rectF.height(), 0.0f) || rectF.height() < 0.0f || FloatUtil.floatsEqual(rectF2.width(), 0.0f) || rectF2.width() < 0.0f || FloatUtil.floatsEqual(rectF2.height(), 0.0f) || rectF2.height() < 0.0f;
    }

    private final void updatePath() {
        ComputedBorderRadius computedBorderRadiusResolve;
        CornerRadii bottomLeft;
        CornerRadii bottomLeft2;
        CornerRadii bottomRight;
        CornerRadii bottomRight2;
        CornerRadii topRight;
        CornerRadii topRight2;
        CornerRadii topLeft;
        CornerRadii topLeft2;
        if (this.needUpdatePath) {
            this.needUpdatePath = false;
            RectF rectFComputeBorderInsets = computeBorderInsets();
            this.backgroundPositioningArea = new RectF(getBounds().left + rectFComputeBorderInsets.left, getBounds().top + rectFComputeBorderInsets.top, getBounds().right - rectFComputeBorderInsets.right, getBounds().bottom - rectFComputeBorderInsets.bottom);
            this.backgroundPaintingArea = new RectF(getBounds());
            BorderRadiusStyle borderRadiusStyle = this.borderRadius;
            if (borderRadiusStyle != null) {
                int layoutDirection = getLayoutDirection();
                Context context = this.context;
                PixelUtil pixelUtil = PixelUtil.INSTANCE;
                computedBorderRadiusResolve = borderRadiusStyle.resolve(layoutDirection, context, pixelUtil.pxToDp(getBounds().width()), pixelUtil.pxToDp(getBounds().height()));
            } else {
                computedBorderRadiusResolve = null;
            }
            BorderRadiusStyle borderRadiusStyle2 = this.borderRadius;
            if (borderRadiusStyle2 != null && borderRadiusStyle2.hasRoundedBorders()) {
                RectF rectF = this.backgroundPaintingArea;
                if (rectF == null) {
                    return;
                }
                Path path = new Path();
                this.backgroundImageClipPath = path;
                float fDpToPx = 0.0f;
                float fDpToPx2 = (computedBorderRadiusResolve == null || (topLeft2 = computedBorderRadiusResolve.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft2.getHorizontal());
                float fDpToPx3 = (computedBorderRadiusResolve == null || (topLeft = computedBorderRadiusResolve.getTopLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topLeft.getVertical());
                float fDpToPx4 = (computedBorderRadiusResolve == null || (topRight2 = computedBorderRadiusResolve.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight2.getHorizontal());
                float fDpToPx5 = (computedBorderRadiusResolve == null || (topRight = computedBorderRadiusResolve.getTopRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(topRight.getVertical());
                float fDpToPx6 = (computedBorderRadiusResolve == null || (bottomRight2 = computedBorderRadiusResolve.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight2.getHorizontal());
                float fDpToPx7 = (computedBorderRadiusResolve == null || (bottomRight = computedBorderRadiusResolve.getBottomRight()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomRight.getVertical());
                float fDpToPx8 = (computedBorderRadiusResolve == null || (bottomLeft2 = computedBorderRadiusResolve.getBottomLeft()) == null) ? 0.0f : PixelUtil.INSTANCE.dpToPx(bottomLeft2.getHorizontal());
                if (computedBorderRadiusResolve != null && (bottomLeft = computedBorderRadiusResolve.getBottomLeft()) != null) {
                    fDpToPx = PixelUtil.INSTANCE.dpToPx(bottomLeft.getVertical());
                }
                path.addRoundRect(rectF, new float[]{fDpToPx2, fDpToPx3, fDpToPx4, fDpToPx5, fDpToPx6, fDpToPx7, fDpToPx8, fDpToPx}, Path.Direction.CW);
                return;
            }
            RectF rectF2 = this.backgroundPaintingArea;
            if (rectF2 == null) {
                return;
            }
            Path path2 = new Path();
            this.backgroundImageClipPath = path2;
            path2.addRect(rectF2, Path.Direction.CW);
        }
    }

    private final float positionToPixels(LengthPercentage lengthPercentage, float f) {
        if (lengthPercentage.getType() == LengthPercentageType.PERCENT) {
            return lengthPercentage.resolve(f);
        }
        return PixelUtil.INSTANCE.dpToPx(lengthPercentage.resolve(f));
    }

    private final Pair calculateBackgroundImageSize(float f, float f2, float f3, float f4, BackgroundSize backgroundSize, BackgroundRepeat backgroundRepeat) {
        if (backgroundSize instanceof BackgroundSize.LengthPercentageAuto) {
            BackgroundSize.LengthPercentageAuto lengthPercentageAuto = (BackgroundSize.LengthPercentageAuto) backgroundSize;
            LengthPercentage x = lengthPercentageAuto.getLengthPercentage().getX();
            LengthPercentage y = lengthPercentageAuto.getLengthPercentage().getY();
            if (x != null && y != null) {
                f3 = positionToPixels(x, f);
                f4 = positionToPixels(y, f2);
            }
        }
        BackgroundRepeatKeyword x2 = backgroundRepeat != null ? backgroundRepeat.getX() : null;
        BackgroundRepeatKeyword backgroundRepeatKeyword = BackgroundRepeatKeyword.Round;
        if (x2 == backgroundRepeatKeyword && f3 > 0.0f && !FloatUtil.floatsEqual(f % f3, 0.0f)) {
            float fRint = (float) Math.rint(f / f3);
            if (fRint > 0.0f) {
                f3 = f / fRint;
            }
        }
        if ((backgroundRepeat != null ? backgroundRepeat.getY() : null) == backgroundRepeatKeyword && f4 > 0.0f && !FloatUtil.floatsEqual(f2 % f4, 0.0f)) {
            float fRint2 = (float) Math.rint(f2 / f4);
            if (fRint2 > 0.0f) {
                f4 = f2 / fRint2;
            }
        }
        return TuplesKt.to(Float.valueOf(f3), Float.valueOf(f4));
    }

    private final Pair calculateBackgroundPosition(float f, float f2, BackgroundPosition backgroundPosition) {
        float fPositionToPixels;
        float fPositionToPixels2 = 0.0f;
        Float fValueOf = Float.valueOf(0.0f);
        RectF rectF = this.backgroundPositioningArea;
        if (rectF == null) {
            return TuplesKt.to(fValueOf, fValueOf);
        }
        float fWidth = rectF.width() - f;
        float fHeight = rectF.height() - f2;
        if ((backgroundPosition != null ? backgroundPosition.getLeft() : null) != null) {
            fPositionToPixels = positionToPixels(backgroundPosition.getLeft(), fWidth);
        } else {
            fPositionToPixels = (backgroundPosition != null ? backgroundPosition.getRight() : null) != null ? fWidth - positionToPixels(backgroundPosition.getRight(), fWidth) : 0.0f;
        }
        float f3 = fPositionToPixels + rectF.left;
        if ((backgroundPosition != null ? backgroundPosition.getTop() : null) != null) {
            fPositionToPixels2 = positionToPixels(backgroundPosition.getTop(), fHeight);
        } else {
            if ((backgroundPosition != null ? backgroundPosition.getBottom() : null) != null) {
                fPositionToPixels2 = fHeight - positionToPixels(backgroundPosition.getBottom(), fHeight);
            }
        }
        return TuplesKt.to(Float.valueOf(f3), Float.valueOf(fPositionToPixels2 + rectF.top));
    }
}
