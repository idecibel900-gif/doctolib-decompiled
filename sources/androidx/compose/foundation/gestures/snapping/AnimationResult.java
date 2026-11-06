package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationState;

/* JADX INFO: loaded from: classes.dex */
final class AnimationResult {
    private final AnimationState currentAnimationState;
    private final Object remainingOffset;

    public AnimationResult(Object obj, AnimationState animationState) {
        this.remainingOffset = obj;
        this.currentAnimationState = animationState;
    }

    public final AnimationState getCurrentAnimationState() {
        return this.currentAnimationState;
    }

    public final Object component1() {
        return this.remainingOffset;
    }

    public final AnimationState component2() {
        return this.currentAnimationState;
    }
}
