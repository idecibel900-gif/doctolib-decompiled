package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class DecayAnimationSpecKt {
    public static final float calculateTargetValue(DecayAnimationSpec decayAnimationSpec, float f, float f2) {
        return ((AnimationVector1D) decayAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue(AnimationVectorsKt.AnimationVector(f), AnimationVectorsKt.AnimationVector(f2))).getValue();
    }

    public static final DecayAnimationSpec generateDecayAnimationSpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }
}
