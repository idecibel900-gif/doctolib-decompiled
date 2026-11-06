package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatablePathValue implements AnimatableValue {
    private final List keyframes;

    public AnimatablePathValue(List list) {
        this.keyframes = list;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.keyframes.size() == 1 && ((Keyframe) this.keyframes.get(0)).isStatic();
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation createAnimation() {
        if (((Keyframe) this.keyframes.get(0)).isStatic()) {
            return new PointKeyframeAnimation(this.keyframes);
        }
        return new PathKeyframeAnimation(this.keyframes);
    }
}
