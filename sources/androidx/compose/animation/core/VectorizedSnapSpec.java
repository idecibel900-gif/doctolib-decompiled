package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public final class VectorizedSnapSpec implements VectorizedDurationBasedAnimationSpec {
    private final int delayMillis;

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return 0;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return animationVector3;
    }

    public VectorizedSnapSpec(int i) {
        this.delayMillis = i;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return j < ((long) getDelayMillis()) * 1000000 ? animationVector : animationVector2;
    }
}
