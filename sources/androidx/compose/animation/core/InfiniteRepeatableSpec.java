package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InfiniteRepeatableSpec implements AnimationSpec {
    public static final int $stable = 8;
    private final DurationBasedAnimationSpec animation;
    private final long initialStartOffset;
    private final RepeatMode repeatMode;

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, repeatMode, j);
    }

    private InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        this.animation = durationBasedAnimationSpec;
        this.repeatMode = repeatMode;
        this.initialStartOffset = j;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedAnimationSpec vectorize(TwoWayConverter twoWayConverter) {
        return new VectorizedInfiniteRepeatableSpec(this.animation.vectorize(twoWayConverter), this.repeatMode, this.initialStartOffset, null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
            if (Intrinsics.areEqual(infiniteRepeatableSpec.animation, this.animation) && infiniteRepeatableSpec.repeatMode == this.repeatMode && StartOffset.m82equalsimpl0(infiniteRepeatableSpec.initialStartOffset, this.initialStartOffset)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.animation.hashCode() * 31) + this.repeatMode.hashCode()) * 31) + StartOffset.m83hashCodeimpl(this.initialStartOffset);
    }
}
