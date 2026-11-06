package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public final class AnimationResult {
    private final AnimationEndReason endReason;
    private final AnimationState endState;

    public AnimationResult(AnimationState animationState, AnimationEndReason animationEndReason) {
        this.endState = animationState;
        this.endReason = animationEndReason;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.endReason + ", endState=" + this.endState + ')';
    }
}
