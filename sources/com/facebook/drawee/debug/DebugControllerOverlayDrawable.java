package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private int mLineIncrementPx;
    private int mLoopCount;
    private String mOriginText;
    private ScalingUtils$ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mWidthPx;
    private HashMap mAdditionalData = new HashMap();
    private int mTextGravity = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();
    private int mOriginColor = -1;
    private int mOverlayColor = 0;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mAdditionalData = new HashMap();
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1L;
        this.mOriginText = null;
        this.mOriginColor = -1;
        invalidateSelf();
    }

    public void setControllerId(String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.mWidthPx = i;
        this.mHeightPx = i2;
        invalidateSelf();
    }

    public void setImageSize(int i) {
        this.mImageSizeBytes = i;
    }

    public void addAdditionalData(String str, String str2) {
        this.mAdditionalData.put(str, str2);
    }

    public void setScaleType(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        this.mScaleType = scalingUtils$ScaleType;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        Paint paint = this.mPaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mPaint.setColor(this.mOverlayColor);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(style);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String str = this.mImageId;
        if (str != null) {
            addDebugText(canvas, "IDs", format("%s, %s", this.mControllerId, str));
        } else {
            addDebugText(canvas, "ID", this.mControllerId);
        }
        addDebugText(canvas, "D", format("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())));
        if (bounds.height() > 0) {
            addDebugText(canvas, "DAR", Float.valueOf(bounds.width() / bounds.height()));
        }
        addDebugText(canvas, "I", format("%dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx)), determineSizeHintColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        int i = this.mHeightPx;
        if (i > 0) {
            addDebugText(canvas, "IAR", Float.valueOf(this.mWidthPx / i));
        }
        addDebugText(canvas, "I", format("%d KiB", Integer.valueOf(this.mImageSizeBytes / IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET)));
        String str2 = this.mImageFormat;
        if (str2 != null) {
            addDebugText(canvas, "i format", str2);
        }
        int i2 = this.mFrameCount;
        if (i2 > 0) {
            addDebugText(canvas, "anim", format("f %d, l %d", Integer.valueOf(i2), Integer.valueOf(this.mLoopCount)));
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.mScaleType;
        if (scalingUtils$ScaleType != null) {
            addDebugText(canvas, "scale", scalingUtils$ScaleType);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0) {
            addDebugText(canvas, "t", format("%d ms", Long.valueOf(j)));
        }
        String str3 = this.mOriginText;
        if (str3 != null) {
            addDebugText(canvas, "origin", str3, this.mOriginColor);
        }
        for (Map.Entry entry : this.mAdditionalData.entrySet()) {
            addDebugText(canvas, (String) entry.getKey(), (String) entry.getValue());
        }
    }

    private void prepareDebugTextParameters(Rect rect, int i, int i2) {
        int i3;
        int iMin = Math.min(40, Math.max(10, Math.min(rect.width() / i2, rect.height() / i)));
        this.mPaint.setTextSize(iMin);
        int i4 = iMin + 8;
        this.mLineIncrementPx = i4;
        int i5 = this.mTextGravity;
        if (i5 == 80) {
            this.mLineIncrementPx = i4 * (-1);
        }
        this.mStartTextXPx = rect.left + 10;
        if (i5 == 80) {
            i3 = rect.bottom - 10;
        } else {
            i3 = rect.top + 20;
        }
        this.mStartTextYPx = i3;
    }

    private static String format(String str, Object... objArr) {
        return objArr == null ? str : String.format(Locale.US, str, objArr);
    }

    private void addDebugText(Canvas canvas, String str, Object obj) {
        addDebugText(canvas, str, String.valueOf(obj), -1);
    }

    private void addDebugText(Canvas canvas, String str, String str2) {
        addDebugText(canvas, str, str2, -1);
    }

    private void addDebugText(Canvas canvas, String str, String str2, int i) {
        String str3 = str + ": ";
        float fMeasureText = this.mPaint.measureText(str3);
        float fMeasureText2 = this.mPaint.measureText(str2);
        this.mPaint.setColor(1711276032);
        int i2 = this.mCurrentTextXPx;
        int i3 = this.mCurrentTextYPx;
        canvas.drawRect(i2 - 4, i3 + 8, i2 + fMeasureText + fMeasureText2 + 4.0f, i3 + this.mLineIncrementPx + 8, this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawText(str3, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(i);
        canvas.drawText(str2, this.mCurrentTextXPx + fMeasureText, this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    int determineSizeHintColor(int i, int i2, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        int i3;
        int i4;
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        if (iWidth > 0 && iHeight > 0 && i > 0 && i2 > 0) {
            if (scalingUtils$ScaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                rect.right = iWidth;
                rect.bottom = iHeight;
                this.mMatrix.reset();
                i3 = i;
                i4 = i2;
                scalingUtils$ScaleType.getTransform(this.mMatrix, this.mRect, i3, i4, 0.0f, 0.0f);
                RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i3;
                rectF.bottom = i4;
                this.mMatrix.mapRect(rectF);
                int iWidth2 = (int) this.mRectF.width();
                int iHeight2 = (int) this.mRectF.height();
                iWidth = Math.min(iWidth, iWidth2);
                iHeight = Math.min(iHeight, iHeight2);
            } else {
                i3 = i;
                i4 = i2;
            }
            float f = iWidth;
            float f2 = f * 0.1f;
            float f3 = f * 0.5f;
            float f4 = iHeight;
            float f5 = 0.1f * f4;
            float f6 = f4 * 0.5f;
            int iAbs = Math.abs(i3 - iWidth);
            int iAbs2 = Math.abs(i4 - iHeight);
            float f7 = iAbs;
            if (f7 < f2 && iAbs2 < f5) {
                return -16711936;
            }
            if (f7 < f3 && iAbs2 < f6) {
                return -256;
            }
        }
        return -65536;
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }
}
