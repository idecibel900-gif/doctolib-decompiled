package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Transform3D;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public class TransformKeyframeAnimation {
    private BaseKeyframeAnimation anchorPoint;
    private final boolean autoOrient;
    private BaseKeyframeAnimation endOpacity;
    private BaseKeyframeAnimation opacity;
    private BaseKeyframeAnimation position;
    private BaseKeyframeAnimation rotation;
    private FloatKeyframeAnimation rotationX;
    private FloatKeyframeAnimation rotationY;
    private FloatKeyframeAnimation rotationZ;
    private BaseKeyframeAnimation scale;
    private FloatKeyframeAnimation skew;
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    private BaseKeyframeAnimation startOpacity;
    private final Matrix matrix = new Matrix();
    private float cachedRotationX = Float.NaN;
    private float cachedRotationY = Float.NaN;
    private float cachedRotationZ = Float.NaN;
    private float cachedCosX = 1.0f;
    private float cachedCosY = 1.0f;
    private boolean rotation3DCacheDirty = true;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.anchorPoint = animatableTransform.getAnchorPoint() == null ? null : animatableTransform.getAnchorPoint().createAnimation();
        this.position = animatableTransform.getPosition() == null ? null : animatableTransform.getPosition().createAnimation();
        this.scale = animatableTransform.getScale() == null ? null : animatableTransform.getScale().createAnimation();
        this.rotation = animatableTransform.getRotation() == null ? null : animatableTransform.getRotation().createAnimation();
        this.skew = animatableTransform.getSkew() == null ? null : animatableTransform.getSkew().createAnimation();
        this.autoOrient = animatableTransform.isAutoOrient();
        this.rotationX = animatableTransform.getRotationX() == null ? null : animatableTransform.getRotationX().createAnimation();
        this.rotationY = animatableTransform.getRotationY() == null ? null : animatableTransform.getRotationY().createAnimation();
        this.rotationZ = animatableTransform.getRotationZ() == null ? null : animatableTransform.getRotationZ().createAnimation();
        if (this.skew != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        this.skewAngle = animatableTransform.getSkewAngle() == null ? null : animatableTransform.getSkewAngle().createAnimation();
        if (animatableTransform.getOpacity() != null) {
            this.opacity = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.startOpacity = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.skew);
        baseLayer.addAnimation(this.skewAngle);
        baseLayer.addAnimation(this.rotationX);
        baseLayer.addAnimation(this.rotationY);
        baseLayer.addAnimation(this.rotationZ);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.rotationX;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.addUpdateListener(animationListener);
            this.rotationX.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation$$ExternalSyntheticLambda0
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public final void onValueChanged() {
                    this.f$0.rotation3DCacheDirty = true;
                }
            });
        }
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.rotationY;
        if (floatKeyframeAnimation4 != null) {
            floatKeyframeAnimation4.addUpdateListener(animationListener);
            this.rotationY.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation$$ExternalSyntheticLambda1
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public final void onValueChanged() {
                    this.f$0.rotation3DCacheDirty = true;
                }
            });
        }
        FloatKeyframeAnimation floatKeyframeAnimation5 = this.rotationZ;
        if (floatKeyframeAnimation5 != null) {
            floatKeyframeAnimation5.addUpdateListener(animationListener);
            this.rotationZ.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() { // from class: com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation$$ExternalSyntheticLambda2
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public final void onValueChanged() {
                    this.f$0.rotation3DCacheDirty = true;
                }
            });
        }
    }

    public void setProgress(float f) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.rotationX;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.rotationY;
        if (floatKeyframeAnimation4 != null) {
            floatKeyframeAnimation4.setProgress(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation5 = this.rotationZ;
        if (floatKeyframeAnimation5 != null) {
            floatKeyframeAnimation5.setProgress(f);
        }
    }

    public BaseKeyframeAnimation getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation getStartOpacity() {
        return this.startOpacity;
    }

    public BaseKeyframeAnimation getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        float floatValue;
        PointF pointF;
        ScaleXY scaleXY;
        PointF pointF2;
        this.matrix.reset();
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.rotationX;
        if ((floatKeyframeAnimation3 != null && floatKeyframeAnimation3.getFloatValue() != 0.0f) || (((floatKeyframeAnimation = this.rotationY) != null && floatKeyframeAnimation.getFloatValue() != 0.0f) || ((floatKeyframeAnimation2 = this.rotationZ) != null && floatKeyframeAnimation2.getFloatValue() != 0.0f))) {
            FloatKeyframeAnimation floatKeyframeAnimation4 = this.rotationX;
            float floatValue2 = floatKeyframeAnimation4 != null ? floatKeyframeAnimation4.getFloatValue() : 0.0f;
            FloatKeyframeAnimation floatKeyframeAnimation5 = this.rotationY;
            float floatValue3 = floatKeyframeAnimation5 != null ? floatKeyframeAnimation5.getFloatValue() : 0.0f;
            FloatKeyframeAnimation floatKeyframeAnimation6 = this.rotationZ;
            float floatValue4 = floatKeyframeAnimation6 != null ? floatKeyframeAnimation6.getFloatValue() : 0.0f;
            if (this.rotation3DCacheDirty || floatValue2 != this.cachedRotationX || floatValue3 != this.cachedRotationY || floatValue4 != this.cachedRotationZ) {
                this.cachedRotationX = floatValue2;
                this.cachedRotationY = floatValue3;
                this.cachedRotationZ = floatValue4;
                if (floatValue2 != 0.0f) {
                    this.cachedCosX = (float) Math.cos(Math.toRadians(floatValue2));
                } else {
                    this.cachedCosX = 1.0f;
                }
                if (floatValue3 != 0.0f) {
                    this.cachedCosY = (float) Math.cos(Math.toRadians(floatValue3));
                } else {
                    this.cachedCosY = 1.0f;
                }
                this.rotation3DCacheDirty = false;
            }
            BaseKeyframeAnimation baseKeyframeAnimation = this.anchorPoint;
            PointF pointF3 = baseKeyframeAnimation == null ? null : (PointF) baseKeyframeAnimation.getValue();
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.position;
            PointF pointF4 = baseKeyframeAnimation2 == null ? null : (PointF) baseKeyframeAnimation2.getValue();
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.scale;
            ScaleXY scaleXY2 = baseKeyframeAnimation3 != null ? (ScaleXY) baseKeyframeAnimation3.getValue() : null;
            Transform3D.applyTransform(this.matrix, pointF3, pointF4, scaleXY2 != null ? scaleXY2.getScaleX() : 1.0f, scaleXY2 != null ? scaleXY2.getScaleY() : 1.0f, floatValue2, floatValue3, floatValue4, this.cachedCosX, this.cachedCosY);
            return this.matrix;
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.position;
        if (baseKeyframeAnimation4 != null && (pointF2 = (PointF) baseKeyframeAnimation4.getValue()) != null) {
            float f = pointF2.x;
            if (f != 0.0f || pointF2.y != 0.0f) {
                this.matrix.preTranslate(f, pointF2.y);
            }
        }
        if (!this.autoOrient) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.rotation;
            if (baseKeyframeAnimation5 != null) {
                if (baseKeyframeAnimation5 instanceof ValueCallbackKeyframeAnimation) {
                    floatValue = ((Float) baseKeyframeAnimation5.getValue()).floatValue();
                } else {
                    floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation5).getFloatValue();
                }
                if (floatValue != 0.0f) {
                    this.matrix.preRotate(floatValue);
                }
            }
        } else if (baseKeyframeAnimation4 != null) {
            float progress = baseKeyframeAnimation4.getProgress();
            PointF pointF5 = (PointF) baseKeyframeAnimation4.getValue();
            float f2 = pointF5.x;
            float f3 = pointF5.y;
            baseKeyframeAnimation4.setProgress(1.0E-4f + progress);
            PointF pointF6 = (PointF) baseKeyframeAnimation4.getValue();
            baseKeyframeAnimation4.setProgress(progress);
            this.matrix.preRotate((float) Math.toDegrees(Math.atan2(pointF6.y - f3, pointF6.x - f2)));
        }
        FloatKeyframeAnimation floatKeyframeAnimation7 = this.skew;
        if (floatKeyframeAnimation7 != null) {
            FloatKeyframeAnimation floatKeyframeAnimation8 = this.skewAngle;
            float fCos = floatKeyframeAnimation8 == null ? 0.0f : (float) Math.cos(Math.toRadians((-floatKeyframeAnimation8.getFloatValue()) + 90.0f));
            FloatKeyframeAnimation floatKeyframeAnimation9 = this.skewAngle;
            float fSin = floatKeyframeAnimation9 == null ? 1.0f : (float) Math.sin(Math.toRadians((-floatKeyframeAnimation9.getFloatValue()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(floatKeyframeAnimation7.getFloatValue()));
            clearSkewValues();
            float[] fArr = this.skewValues;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f4 = -fSin;
            fArr[3] = f4;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.skewMatrix1.setValues(fArr);
            clearSkewValues();
            float[] fArr2 = this.skewValues;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.skewMatrix2.setValues(fArr2);
            clearSkewValues();
            float[] fArr3 = this.skewValues;
            fArr3[0] = fCos;
            fArr3[1] = f4;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.skewMatrix3.setValues(fArr3);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null && (scaleXY = (ScaleXY) baseKeyframeAnimation6.getValue()) != null && (scaleXY.getScaleX() != 1.0f || scaleXY.getScaleY() != 1.0f)) {
            this.matrix.preScale(scaleXY.getScaleX(), scaleXY.getScaleY());
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.anchorPoint;
        if (baseKeyframeAnimation7 != null && (pointF = (PointF) baseKeyframeAnimation7.getValue()) != null) {
            float f5 = pointF.x;
            if (f5 != 0.0f || pointF.y != 0.0f) {
                this.matrix.preTranslate(-f5, -pointF.y);
            }
        }
        return this.matrix;
    }

    private void clearSkewValues() {
        for (int i = 0; i < 9; i++) {
            this.skewValues[i] = 0.0f;
        }
    }

    public Matrix getMatrixForRepeater(float f) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.position;
        PointF pointF = baseKeyframeAnimation == null ? null : (PointF) baseKeyframeAnimation.getValue();
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.scale;
        ScaleXY scaleXY = baseKeyframeAnimation2 == null ? null : (ScaleXY) baseKeyframeAnimation2.getValue();
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.anchorPoint;
        PointF pointF2 = baseKeyframeAnimation3 != null ? (PointF) baseKeyframeAnimation3.getValue() : null;
        this.matrix.reset();
        if (pointF != null) {
            this.matrix.preTranslate(pointF.x * f, pointF.y * f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.rotationX;
        float floatValue = floatKeyframeAnimation != null ? floatKeyframeAnimation.getFloatValue() * f : 0.0f;
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.rotationY;
        float floatValue2 = floatKeyframeAnimation2 != null ? floatKeyframeAnimation2.getFloatValue() * f : 0.0f;
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.rotationZ;
        float floatValue3 = floatKeyframeAnimation3 != null ? floatKeyframeAnimation3.getFloatValue() * f : 0.0f;
        if (floatValue != 0.0f || floatValue2 != 0.0f || floatValue3 != 0.0f) {
            float fCos = floatValue != 0.0f ? (float) Math.cos(Math.toRadians(floatValue)) : 1.0f;
            float fCos2 = floatValue2 != 0.0f ? (float) Math.cos(Math.toRadians(floatValue2)) : 1.0f;
            if (floatValue3 != 0.0f) {
                this.matrix.preRotate(floatValue3, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
            Transform3D.apply3DRotations(this.matrix, floatValue, floatValue2, 0.0f, fCos, fCos2);
        } else {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.rotation;
            if (baseKeyframeAnimation4 != null) {
                this.matrix.preRotate(((Float) baseKeyframeAnimation4.getValue()).floatValue() * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
            }
        }
        if (scaleXY != null) {
            double d = f;
            this.matrix.preScale((float) Math.pow(scaleXY.getScaleX(), d), (float) Math.pow(scaleXY.getScaleY(), d));
        }
        return this.matrix;
    }

    public boolean applyValueCallback(Object obj, LottieValueCallback lottieValueCallback) {
        Float fValueOf = Float.valueOf(100.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (obj == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.anchorPoint;
            if (baseKeyframeAnimation == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.position;
            if (baseKeyframeAnimation2 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_POSITION_X) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.position;
            if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3).setXValueCallback(lottieValueCallback);
                return true;
            }
        }
        if (obj == LottieProperty.TRANSFORM_POSITION_Y) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.position;
            if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4).setYValueCallback(lottieValueCallback);
                return true;
            }
        }
        if (obj == LottieProperty.TRANSFORM_SCALE) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.scale;
            if (baseKeyframeAnimation5 == null) {
                this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_ROTATION) {
            BaseKeyframeAnimation baseKeyframeAnimation6 = this.rotation;
            if (baseKeyframeAnimation6 == null) {
                this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf2);
                return true;
            }
            baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation7 = this.opacity;
            if (baseKeyframeAnimation7 == null) {
                this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_START_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation8 = this.startOpacity;
            if (baseKeyframeAnimation8 == null) {
                this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf);
                return true;
            }
            baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_END_OPACITY) {
            BaseKeyframeAnimation baseKeyframeAnimation9 = this.endOpacity;
            if (baseKeyframeAnimation9 == null) {
                this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf);
                return true;
            }
            baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_SKEW) {
            if (this.skew == null) {
                this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
            }
            this.skew.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_SKEW_ANGLE) {
            if (this.skewAngle == null) {
                this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
            }
            this.skewAngle.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_ROTATION_X) {
            if (this.rotationX == null) {
                this.rotationX = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
            }
            this.rotationX.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_ROTATION_Y) {
            if (this.rotationY == null) {
                this.rotationY = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
            }
            this.rotationY.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj != LottieProperty.TRANSFORM_ROTATION_Z) {
            return false;
        }
        if (this.rotationZ == null) {
            this.rotationZ = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
        }
        this.rotationZ.setValueCallback(lottieValueCallback);
        return true;
    }
}
