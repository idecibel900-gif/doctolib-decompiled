package com.canhub.cropper;

import android.graphics.PointF;
import android.graphics.RectF;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CropWindowMoveHandler {
    public static final Companion Companion = new Companion(null);
    private final float mMaxCropHeight;
    private final float mMaxCropWidth;
    private final float mMinCropHeight;
    private final float mMinCropWidth;
    private final PointF mTouchOffset;
    private final Type type;

    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Type.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Type.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Type.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Type.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Type.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CropWindowMoveHandler(Type type, CropWindowHandler cropWindowHandler, float f, float f2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(cropWindowHandler, "cropWindowHandler");
        this.type = type;
        this.mMinCropWidth = cropWindowHandler.getMinCropWidth();
        this.mMinCropHeight = cropWindowHandler.getMinCropHeight();
        this.mMaxCropWidth = cropWindowHandler.getMaxCropWidth();
        this.mMaxCropHeight = cropWindowHandler.getMaxCropHeight();
        this.mTouchOffset = new PointF(0.0f, 0.0f);
        calculateTouchOffset(cropWindowHandler.getRect(), f, f2);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float calculateAspectRatio$cropper_release(float f, float f2, float f3, float f4) {
            return (f3 - f) / (f4 - f2);
        }

        private Companion() {
        }
    }

    public final void move(RectF rect, float f, float f2, RectF bounds, int i, int i2, float f3, boolean z, float f4) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        PointF pointF = this.mTouchOffset;
        float f5 = pointF.x + f;
        float f6 = pointF.y + f2;
        if (this.type == Type.CENTER) {
            moveCenter(rect, f5, f6, bounds, i, i2, f3);
        } else if (z) {
            moveSizeWithFixedAspectRatio(rect, f5, f6, bounds, i, i2, f3, f4);
        } else {
            moveSizeWithFreeAspectRatio(rect, f5, f6, bounds, i, i2, f3);
        }
    }

    private final void calculateTouchOffset(RectF rectF, float f, float f2) {
        float fCenterY;
        float f3;
        float f4;
        float fCenterX = 0.0f;
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                fCenterX = rectF.left - f;
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                PointF pointF = this.mTouchOffset;
                pointF.x = fCenterX;
                pointF.y = f4;
                return;
            case 2:
                fCenterX = rectF.right - f;
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                PointF pointF2 = this.mTouchOffset;
                pointF2.x = fCenterX;
                pointF2.y = f4;
                return;
            case 3:
                fCenterX = rectF.left - f;
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                PointF pointF3 = this.mTouchOffset;
                pointF3.x = fCenterX;
                pointF3.y = f4;
                return;
            case 4:
                fCenterX = rectF.right - f;
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                PointF pointF4 = this.mTouchOffset;
                pointF4.x = fCenterX;
                pointF4.y = f4;
                return;
            case 5:
                f3 = rectF.left;
                fCenterX = f3 - f;
                f4 = 0.0f;
                PointF pointF5 = this.mTouchOffset;
                pointF5.x = fCenterX;
                pointF5.y = f4;
                return;
            case 6:
                fCenterY = rectF.top;
                f4 = fCenterY - f2;
                PointF pointF6 = this.mTouchOffset;
                pointF6.x = fCenterX;
                pointF6.y = f4;
                return;
            case 7:
                f3 = rectF.right;
                fCenterX = f3 - f;
                f4 = 0.0f;
                PointF pointF7 = this.mTouchOffset;
                pointF7.x = fCenterX;
                pointF7.y = f4;
                return;
            case 8:
                fCenterY = rectF.bottom;
                f4 = fCenterY - f2;
                PointF pointF8 = this.mTouchOffset;
                pointF8.x = fCenterX;
                pointF8.y = f4;
                return;
            case 9:
                fCenterX = rectF.centerX() - f;
                fCenterY = rectF.centerY();
                f4 = fCenterY - f2;
                PointF pointF9 = this.mTouchOffset;
                pointF9.x = fCenterX;
                pointF9.y = f4;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    private final void moveCenter(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float fCenterX = f - rectF.centerX();
        float fCenterY = f2 - rectF.centerY();
        float f4 = rectF.left;
        if (f4 + fCenterX >= 0.0f) {
            float f5 = rectF.right;
            if (f5 + fCenterX > i || f4 + fCenterX < rectF2.left || f5 + fCenterX > rectF2.right) {
                fCenterX /= 1.05f;
                this.mTouchOffset.x -= fCenterX / 2;
            }
        } else {
            fCenterX /= 1.05f;
            this.mTouchOffset.x -= fCenterX / 2;
        }
        float f6 = rectF.top;
        if (f6 + fCenterY >= 0.0f) {
            float f7 = rectF.bottom;
            if (f7 + fCenterY > i2 || f6 + fCenterY < rectF2.top || f7 + fCenterY > rectF2.bottom) {
                fCenterY /= 1.05f;
                this.mTouchOffset.y -= fCenterY / 2;
            }
        } else {
            fCenterY /= 1.05f;
            this.mTouchOffset.y -= fCenterY / 2;
        }
        rectF.offset(fCenterX, fCenterY);
        snapEdgesToBounds(rectF, rectF2, f3);
    }

    private final void moveSizeWithFreeAspectRatio(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 2:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 3:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 4:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 5:
                adjustLeft(rectF, f, rectF2, f3, 0.0f, false, false);
                return;
            case 6:
                adjustTop(rectF, f2, rectF2, f3, 0.0f, false, false);
                return;
            case 7:
                adjustRight(rectF, f, rectF2, i, f3, 0.0f, false, false);
                return;
            case 8:
                adjustBottom(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                return;
            case 9:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void moveSizeWithFixedAspectRatio(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()]) {
            case 1:
                if (Companion.calculateAspectRatio$cropper_release(f, f2, rectF.right, rectF.bottom) < f4) {
                    adjustTop(rectF, f2, rectF2, f3, f4, true, false);
                    adjustLeftByAspectRatio(rectF, f4);
                    return;
                } else {
                    adjustLeft(rectF, f, rectF2, f3, f4, true, false);
                    adjustTopByAspectRatio(rectF, f4);
                    return;
                }
            case 2:
                if (Companion.calculateAspectRatio$cropper_release(rectF.left, f2, f, rectF.bottom) < f4) {
                    adjustTop(rectF, f2, rectF2, f3, f4, false, true);
                    adjustRightByAspectRatio(rectF, f4);
                    return;
                } else {
                    adjustRight(rectF, f, rectF2, i, f3, f4, true, false);
                    adjustTopByAspectRatio(rectF, f4);
                    return;
                }
            case 3:
                if (Companion.calculateAspectRatio$cropper_release(f, rectF.top, rectF.right, f2) < f4) {
                    adjustBottom(rectF, f2, rectF2, i2, f3, f4, true, false);
                    adjustLeftByAspectRatio(rectF, f4);
                    return;
                } else {
                    adjustLeft(rectF, f, rectF2, f3, f4, false, true);
                    adjustBottomByAspectRatio(rectF, f4);
                    return;
                }
            case 4:
                if (Companion.calculateAspectRatio$cropper_release(rectF.left, rectF.top, f, f2) < f4) {
                    adjustBottom(rectF, f2, rectF2, i2, f3, f4, false, true);
                    adjustRightByAspectRatio(rectF, f4);
                    return;
                } else {
                    adjustRight(rectF, f, rectF2, i, f3, f4, false, true);
                    adjustBottomByAspectRatio(rectF, f4);
                    return;
                }
            case 5:
                adjustLeft(rectF, f, rectF2, f3, f4, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF2, f4);
                return;
            case 6:
                adjustTop(rectF, f2, rectF2, f3, f4, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF2, f4);
                return;
            case 7:
                adjustRight(rectF, f, rectF2, i, f3, f4, true, true);
                adjustTopBottomByAspectRatio(rectF, rectF2, f4);
                return;
            case 8:
                adjustBottom(rectF, f2, rectF2, i2, f3, f4, true, true);
                adjustLeftRightByAspectRatio(rectF, rectF2, f4);
                return;
            case 9:
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void snapEdgesToBounds(RectF rectF, RectF rectF2, float f) {
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 < f3 + f) {
            rectF.offset(f3 - f2, 0.0f);
        }
        float f4 = rectF.top;
        float f5 = rectF2.top;
        if (f4 < f5 + f) {
            rectF.offset(0.0f, f5 - f4);
        }
        float f6 = rectF.right;
        float f7 = rectF2.right;
        if (f6 > f7 - f) {
            rectF.offset(f7 - f6, 0.0f);
        }
        float f8 = rectF.bottom;
        float f9 = rectF2.bottom;
        if (f8 > f9 - f) {
            rectF.offset(0.0f, f9 - f8);
        }
    }

    private final void adjustLeft(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.mTouchOffset.x -= f / 1.1f;
        }
        float f4 = rectF2.left;
        if (f < f4) {
            this.mTouchOffset.x -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.right;
        float f6 = f5 - f;
        float f7 = this.mMinCropWidth;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.mMaxCropWidth;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) / f3;
            float f11 = this.mMinCropHeight;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 * f3));
                f10 = (rectF.right - f) / f3;
            }
            float f12 = this.mMaxCropHeight;
            if (f10 > f12) {
                f = Math.max(rectF2.left, rectF.right - (f12 * f3));
                f10 = (rectF.right - f) / f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z) {
                    float f13 = rectF.bottom;
                    float f14 = f13 - f10;
                    float f15 = rectF2.top;
                    if (f14 < f15) {
                        f = Math.max(rectF2.left, rectF.right - ((f13 - f15) * f3));
                        f10 = (rectF.right - f) / f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.top;
                    float f17 = f10 + f16;
                    float f18 = rectF2.bottom;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.left, rectF.right - ((f18 - f16) * f3)));
                    }
                }
            }
        }
        rectF.left = f;
    }

    private final void adjustRight(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.mTouchOffset.x -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.right;
        if (f > f5) {
            this.mTouchOffset.x -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.left;
        float f7 = f - f6;
        float f8 = this.mMinCropWidth;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.mMaxCropWidth;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) / f3;
            float f12 = this.mMinCropHeight;
            if (f11 < f12) {
                f = Math.min(f5, f6 + (f12 * f3));
                f11 = (f - rectF.left) / f3;
            }
            float f13 = this.mMaxCropHeight;
            if (f11 > f13) {
                f = Math.min(rectF2.right, rectF.left + (f13 * f3));
                f11 = (f - rectF.left) / f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            } else {
                if (z) {
                    float f14 = rectF.bottom;
                    float f15 = f14 - f11;
                    float f16 = rectF2.top;
                    if (f15 < f16) {
                        f = Math.min(rectF2.right, rectF.left + ((f14 - f16) * f3));
                        f11 = (f - rectF.left) / f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.top;
                    float f18 = f11 + f17;
                    float f19 = rectF2.bottom;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.right, rectF.left + ((f19 - f17) * f3)));
                    }
                }
            }
        }
        rectF.right = f;
    }

    private final void adjustTop(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.mTouchOffset.y -= f / 1.1f;
        }
        float f4 = rectF2.top;
        if (f < f4) {
            this.mTouchOffset.y -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.bottom;
        float f6 = f5 - f;
        float f7 = this.mMinCropHeight;
        if (f6 < f7) {
            f = f5 - f7;
        }
        float f8 = f5 - f;
        float f9 = this.mMaxCropHeight;
        if (f8 > f9) {
            f = f5 - f9;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f10 = (f5 - f) * f3;
            float f11 = this.mMinCropWidth;
            if (f10 < f11) {
                f = Math.max(f4, f5 - (f11 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            float f12 = this.mMaxCropWidth;
            if (f10 > f12) {
                f = Math.max(rectF2.top, rectF.bottom - (f12 / f3));
                f10 = (rectF.bottom - f) * f3;
            }
            if (z && z2) {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z) {
                    float f13 = rectF.right;
                    float f14 = f13 - f10;
                    float f15 = rectF2.left;
                    if (f14 < f15) {
                        f = Math.max(rectF2.top, rectF.bottom - ((f13 - f15) / f3));
                        f10 = (rectF.bottom - f) * f3;
                    }
                }
                if (z2) {
                    float f16 = rectF.left;
                    float f17 = f10 + f16;
                    float f18 = rectF2.right;
                    if (f17 > f18) {
                        f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((f18 - f16) / f3)));
                    }
                }
            }
        }
        rectF.top = f;
    }

    private final void adjustBottom(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.mTouchOffset.y -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.bottom;
        if (f > f5) {
            this.mTouchOffset.y -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.top;
        float f7 = f - f6;
        float f8 = this.mMinCropHeight;
        if (f7 < f8) {
            f = f6 + f8;
        }
        float f9 = f - f6;
        float f10 = this.mMaxCropHeight;
        if (f9 > f10) {
            f = f6 + f10;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f11 = (f - f6) * f3;
            float f12 = this.mMinCropWidth;
            if (f11 < f12) {
                f = Math.min(f5, f6 + (f12 / f3));
                f11 = (f - rectF.top) * f3;
            }
            float f13 = this.mMaxCropWidth;
            if (f11 > f13) {
                f = Math.min(rectF2.bottom, rectF.top + (f13 / f3));
                f11 = (f - rectF.top) * f3;
            }
            if (z && z2) {
                f = Math.min(f, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            } else {
                if (z) {
                    float f14 = rectF.right;
                    float f15 = f14 - f11;
                    float f16 = rectF2.left;
                    if (f15 < f16) {
                        f = Math.min(rectF2.bottom, rectF.top + ((f14 - f16) / f3));
                        f11 = (f - rectF.top) * f3;
                    }
                }
                if (z2) {
                    float f17 = rectF.left;
                    float f18 = f11 + f17;
                    float f19 = rectF2.right;
                    if (f18 > f19) {
                        f = Math.min(f, Math.min(rectF2.bottom, rectF.top + ((f19 - f17) / f3)));
                    }
                }
            }
        }
        rectF.bottom = f;
    }

    private final void adjustLeftByAspectRatio(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    private final void adjustTopByAspectRatio(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    private final void adjustRightByAspectRatio(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    private final void adjustBottomByAspectRatio(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    private final void adjustLeftRightByAspectRatio(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2, 0.0f);
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 < f3) {
            rectF.offset(f3 - f2, 0.0f);
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 > f5) {
            rectF.offset(f5 - f4, 0.0f);
        }
    }

    private final void adjustTopBottomByAspectRatio(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2);
        float f2 = rectF.top;
        float f3 = rectF2.top;
        if (f2 < f3) {
            rectF.offset(0.0f, f3 - f2);
        }
        float f4 = rectF.bottom;
        float f5 = rectF2.bottom;
        if (f4 > f5) {
            rectF.offset(0.0f, f5 - f4);
        }
    }
}
