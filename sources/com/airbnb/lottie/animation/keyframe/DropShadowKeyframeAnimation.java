package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Matrix;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes3.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation color;
    private final FloatKeyframeAnimation direction;
    private final FloatKeyframeAnimation distance;
    private final BaseLayer layer;
    private Matrix layerInvMatrix;
    private final BaseKeyframeAnimation.AnimationListener listener;
    private final FloatKeyframeAnimation opacity;
    private final FloatKeyframeAnimation radius;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.listener = animationListener;
        this.layer = baseLayer;
        BaseKeyframeAnimation baseKeyframeAnimationCreateAnimation = dropShadowEffect.getColor().createAnimation();
        this.color = baseKeyframeAnimationCreateAnimation;
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = dropShadowEffect.getOpacity().createAnimation();
        this.opacity = floatKeyframeAnimationCreateAnimation;
        floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = dropShadowEffect.getDirection().createAnimation();
        this.direction = floatKeyframeAnimationCreateAnimation2;
        floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation2);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation3 = dropShadowEffect.getDistance().createAnimation();
        this.distance = floatKeyframeAnimationCreateAnimation3;
        floatKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation3);
        FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation4 = dropShadowEffect.getRadius().createAnimation();
        this.radius = floatKeyframeAnimationCreateAnimation4;
        floatKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(floatKeyframeAnimationCreateAnimation4);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.listener.onValueChanged();
    }

    public DropShadow evaluate(Matrix matrix, int i) {
        float floatValue = this.direction.getFloatValue() * 0.017453292f;
        float fFloatValue = ((Float) this.distance.getValue()).floatValue();
        double d = floatValue;
        float fSin = ((float) Math.sin(d)) * fFloatValue;
        float fCos = ((float) Math.cos(d + 3.141592653589793d)) * fFloatValue;
        float fFloatValue2 = ((Float) this.radius.getValue()).floatValue();
        int iIntValue = ((Integer) this.color.getValue()).intValue();
        DropShadow dropShadow = new DropShadow(fFloatValue2 * 0.33f, fSin, fCos, Color.argb(Math.round((((Float) this.opacity.getValue()).floatValue() * i) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        dropShadow.transformBy(matrix);
        if (this.layerInvMatrix == null) {
            this.layerInvMatrix = new Matrix();
        }
        this.layer.transform.getMatrix().invert(this.layerInvMatrix);
        dropShadow.transformBy(this.layerInvMatrix);
        return dropShadow;
    }

    public void setColorCallback(LottieValueCallback lottieValueCallback) {
        this.color.setValueCallback(lottieValueCallback);
    }

    public void setOpacityCallback(final LottieValueCallback lottieValueCallback) {
        if (lottieValueCallback == null) {
            this.opacity.setValueCallback(null);
        } else {
            this.opacity.setValueCallback(new LottieValueCallback() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
                @Override // com.airbnb.lottie.value.LottieValueCallback
                public Float getValue(LottieFrameInfo lottieFrameInfo) {
                    Float f = (Float) lottieValueCallback.getValue(lottieFrameInfo);
                    if (f == null) {
                        return null;
                    }
                    return Float.valueOf(f.floatValue() * 2.55f);
                }
            });
        }
    }

    public void setDirectionCallback(LottieValueCallback lottieValueCallback) {
        this.direction.setValueCallback(lottieValueCallback);
    }

    public void setDistanceCallback(LottieValueCallback lottieValueCallback) {
        this.distance.setValueCallback(lottieValueCallback);
    }

    public void setRadiusCallback(LottieValueCallback lottieValueCallback) {
        this.radius.setValueCallback(lottieValueCallback);
    }
}
