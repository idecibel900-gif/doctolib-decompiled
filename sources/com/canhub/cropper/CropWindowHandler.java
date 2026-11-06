package com.canhub.cropper;

import android.graphics.RectF;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CropWindowHandler {
    private float mMaxCropResultHeight;
    private float mMaxCropResultWidth;
    private float mMaxCropWindowHeight;
    private float mMaxCropWindowWidth;
    private float mMinCropResultHeight;
    private float mMinCropResultWidth;
    private float mMinCropWindowHeight;
    private float mMinCropWindowWidth;
    private final RectF mEdges = new RectF();
    private final RectF mGetEdges = new RectF();
    private float mScaleFactorWidth = 1.0f;
    private float mScaleFactorHeight = 1.0f;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CropImageView.CropShape.values().length];
            try {
                iArr[CropImageView.CropShape.RECTANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CropImageView.CropShape.OVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CropImageView.CropShape.RECTANGLE_VERTICAL_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CropImageView.CropShape.RECTANGLE_HORIZONTAL_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean isInCenterTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    public final RectF getRect() {
        this.mGetEdges.set(this.mEdges);
        return this.mGetEdges;
    }

    public final float getMinCropWidth() {
        return RangesKt.coerceAtLeast(this.mMinCropWindowWidth, this.mMinCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMinCropHeight() {
        return RangesKt.coerceAtLeast(this.mMinCropWindowHeight, this.mMinCropResultHeight / this.mScaleFactorHeight);
    }

    public final float getMaxCropWidth() {
        return RangesKt.coerceAtMost(this.mMaxCropWindowWidth, this.mMaxCropResultWidth / this.mScaleFactorWidth);
    }

    public final float getMaxCropHeight() {
        return RangesKt.coerceAtMost(this.mMaxCropWindowHeight, this.mMaxCropResultHeight / this.mScaleFactorHeight);
    }

    public final float getScaleFactorWidth() {
        return this.mScaleFactorWidth;
    }

    public final float getScaleFactorHeight() {
        return this.mScaleFactorHeight;
    }

    public final void setMinCropResultSize(int i, int i2) {
        this.mMinCropResultWidth = i;
        this.mMinCropResultHeight = i2;
    }

    public final void setMaxCropResultSize(int i, int i2) {
        this.mMaxCropResultWidth = i;
        this.mMaxCropResultHeight = i2;
    }

    public final void setCropWindowLimits(float f, float f2, float f3, float f4) {
        this.mMaxCropWindowWidth = f;
        this.mMaxCropWindowHeight = f2;
        this.mScaleFactorWidth = f3;
        this.mScaleFactorHeight = f4;
    }

    public final void setInitialAttributeValues(CropImageOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.mMinCropWindowWidth = options.minCropWindowWidth;
        this.mMinCropWindowHeight = options.minCropWindowHeight;
        this.mMinCropResultWidth = options.minCropResultWidth;
        this.mMinCropResultHeight = options.minCropResultHeight;
        this.mMaxCropResultWidth = options.maxCropResultWidth;
        this.mMaxCropResultHeight = options.maxCropResultHeight;
    }

    public final void setRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.mEdges.set(rect);
    }

    public final boolean showGuidelines() {
        return this.mEdges.width() >= 100.0f && this.mEdges.height() >= 100.0f;
    }

    public final CropWindowMoveHandler getMoveHandler(float f, float f2, float f3, CropImageView.CropShape cropShape, boolean z) {
        CropWindowMoveHandler.Type rectanglePressedMoveType;
        Intrinsics.checkNotNullParameter(cropShape, "cropShape");
        int i = WhenMappings.$EnumSwitchMapping$0[cropShape.ordinal()];
        if (i == 1) {
            rectanglePressedMoveType = getRectanglePressedMoveType(f, f2, f3, z);
        } else if (i == 2) {
            rectanglePressedMoveType = getOvalPressedMoveType(f, f2, z);
        } else if (i == 3) {
            rectanglePressedMoveType = getRectangleVerticalOnlyPressedMoveType(f, f2, f3, z);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            rectanglePressedMoveType = getRectangleHorizontalOnlyPressedMoveType(f, f2, f3, z);
        }
        if (rectanglePressedMoveType != null) {
            return new CropWindowMoveHandler(rectanglePressedMoveType, this, f, f2);
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getRectanglePressedMoveType(float f, float f2, float f3, boolean z) {
        RectF rectF = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF.left, rectF.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        RectF rectF2 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF2.right, rectF2.top, f3)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        RectF rectF3 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF3.left, rectF3.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        RectF rectF4 = this.mEdges;
        if (isInCornerTargetZone(f, f2, rectF4.right, rectF4.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (z) {
            RectF rectF5 = this.mEdges;
            if (isInCenterTargetZone(f, f2, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && focusCenter()) {
                return CropWindowMoveHandler.Type.CENTER;
            }
        }
        RectF rectF6 = this.mEdges;
        if (isInHorizontalTargetZone(f, f2, rectF6.left, rectF6.right, rectF6.top, f3)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        RectF rectF7 = this.mEdges;
        if (isInHorizontalTargetZone(f, f2, rectF7.left, rectF7.right, rectF7.bottom, f3)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        RectF rectF8 = this.mEdges;
        if (isInVerticalTargetZone(f, f2, rectF8.left, rectF8.top, rectF8.bottom, f3)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        RectF rectF9 = this.mEdges;
        if (isInVerticalTargetZone(f, f2, rectF9.right, rectF9.top, rectF9.bottom, f3)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (z) {
            RectF rectF10 = this.mEdges;
            if (isInCenterTargetZone(f, f2, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) && !focusCenter()) {
                return CropWindowMoveHandler.Type.CENTER;
            }
        }
        return getOvalPressedMoveType(f, f2, z);
    }

    private final CropWindowMoveHandler.Type getOvalPressedMoveType(float f, float f2, boolean z) {
        float f3 = 6;
        float fWidth = this.mEdges.width() / f3;
        RectF rectF = this.mEdges;
        float f4 = rectF.left;
        float f5 = f4 + fWidth;
        float f6 = 5;
        float f7 = f4 + (fWidth * f6);
        float fHeight = rectF.height() / f3;
        float f8 = this.mEdges.top;
        float f9 = f8 + fHeight;
        float f10 = f8 + (f6 * fHeight);
        if (f < f5) {
            if (f2 < f9) {
                return CropWindowMoveHandler.Type.TOP_LEFT;
            }
            if (f2 < f10) {
                return CropWindowMoveHandler.Type.LEFT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        if (f >= f7) {
            if (f2 < f9) {
                return CropWindowMoveHandler.Type.TOP_RIGHT;
            }
            if (f2 < f10) {
                return CropWindowMoveHandler.Type.RIGHT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        if (f2 < f9) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (f2 >= f10) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (z) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        return null;
    }

    private final CropWindowMoveHandler.Type getRectangleVerticalOnlyPressedMoveType(float f, float f2, float f3, boolean z) {
        float f4;
        float f5;
        if (distance(f, f2, this.mEdges.centerX(), this.mEdges.top) <= f3) {
            return CropWindowMoveHandler.Type.TOP;
        }
        if (distance(f, f2, this.mEdges.centerX(), this.mEdges.bottom) <= f3) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        if (z) {
            RectF rectF = this.mEdges;
            f4 = f;
            f5 = f2;
            if (isInCenterTargetZone(f4, f5, rectF.left, rectF.top, rectF.right, rectF.bottom)) {
                return CropWindowMoveHandler.Type.CENTER;
            }
        } else {
            f4 = f;
            f5 = f2;
        }
        return getOvalPressedMoveType(f4, f5, z);
    }

    private final CropWindowMoveHandler.Type getRectangleHorizontalOnlyPressedMoveType(float f, float f2, float f3, boolean z) {
        float f4;
        float f5;
        RectF rectF = this.mEdges;
        if (distance(f, f2, rectF.left, rectF.centerY()) <= f3) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        RectF rectF2 = this.mEdges;
        if (distance(f, f2, rectF2.right, rectF2.centerY()) <= f3) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        if (z) {
            RectF rectF3 = this.mEdges;
            f4 = f;
            f5 = f2;
            if (isInCenterTargetZone(f4, f5, rectF3.left, rectF3.top, rectF3.right, rectF3.bottom)) {
                return CropWindowMoveHandler.Type.CENTER;
            }
        } else {
            f4 = f;
            f5 = f2;
        }
        return getOvalPressedMoveType(f4, f5, z);
    }

    private final boolean isInCornerTargetZone(float f, float f2, float f3, float f4, float f5) {
        return distance(f, f2, f3, f4) <= f5;
    }

    private final float distance(float f, float f2, float f3, float f4) {
        return Math.max(Math.abs(f - f3), Math.abs(f2 - f4));
    }

    private final boolean isInHorizontalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    private final boolean isInVerticalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    private final boolean focusCenter() {
        return !showGuidelines();
    }
}
