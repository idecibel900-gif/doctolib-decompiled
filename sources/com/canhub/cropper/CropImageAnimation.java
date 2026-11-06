package com.canhub.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CropImageAnimation extends Animation implements Animation.AnimationListener {
    private final CropOverlayView cropOverlayView;
    private final float[] endBoundPoints;
    private final RectF endCropWindowRect;
    private final float[] endImageMatrix;
    private final ImageView imageView;
    private final float[] startBoundPoints;
    private final RectF startCropWindowRect;
    private final float[] startImageMatrix;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public CropImageAnimation(ImageView imageView, CropOverlayView cropOverlayView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(cropOverlayView, "cropOverlayView");
        this.imageView = imageView;
        this.cropOverlayView = cropOverlayView;
        this.startBoundPoints = new float[8];
        this.endBoundPoints = new float[8];
        this.startCropWindowRect = new RectF();
        this.endCropWindowRect = new RectF();
        this.startImageMatrix = new float[9];
        this.endImageMatrix = new float[9];
        setDuration(300L);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public final void setStartState(float[] boundPoints, Matrix imageMatrix) {
        Intrinsics.checkNotNullParameter(boundPoints, "boundPoints");
        Intrinsics.checkNotNullParameter(imageMatrix, "imageMatrix");
        reset();
        System.arraycopy(boundPoints, 0, this.startBoundPoints, 0, 8);
        this.startCropWindowRect.set(this.cropOverlayView.getCropWindowRect());
        imageMatrix.getValues(this.startImageMatrix);
    }

    public final void setEndState(float[] boundPoints, Matrix imageMatrix) {
        Intrinsics.checkNotNullParameter(boundPoints, "boundPoints");
        Intrinsics.checkNotNullParameter(imageMatrix, "imageMatrix");
        System.arraycopy(boundPoints, 0, this.endBoundPoints, 0, 8);
        this.endCropWindowRect.set(this.cropOverlayView.getCropWindowRect());
        imageMatrix.getValues(this.endImageMatrix);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        RectF rectF = new RectF();
        RectF rectF2 = this.startCropWindowRect;
        float f2 = rectF2.left;
        RectF rectF3 = this.endCropWindowRect;
        rectF.left = f2 + ((rectF3.left - f2) * f);
        float f3 = rectF2.top;
        rectF.top = f3 + ((rectF3.top - f3) * f);
        float f4 = rectF2.right;
        rectF.right = f4 + ((rectF3.right - f4) * f);
        float f5 = rectF2.bottom;
        rectF.bottom = f5 + ((rectF3.bottom - f5) * f);
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            float f6 = this.startBoundPoints[i];
            fArr[i] = f6 + ((this.endBoundPoints[i] - f6) * f);
        }
        CropOverlayView cropOverlayView = this.cropOverlayView;
        cropOverlayView.setCropWindowRect(rectF);
        cropOverlayView.setBounds(fArr, this.imageView.getWidth(), this.imageView.getHeight());
        cropOverlayView.invalidate();
        float[] fArr2 = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            float f7 = this.startImageMatrix[i2];
            fArr2[i2] = f7 + ((this.endImageMatrix[i2] - f7) * f);
        }
        ImageView imageView = this.imageView;
        imageView.getImageMatrix().setValues(fArr2);
        imageView.invalidate();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.imageView.clearAnimation();
    }
}
