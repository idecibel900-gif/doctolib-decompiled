package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimationStateKt {
    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j, long j2, boolean z, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i & 2) != 0) {
            animationVector = AnimationVectorsKt.copy(animationState.getVelocityVector());
        }
        if ((i & 4) != 0) {
            j = animationState.getLastFrameTimeNanos();
        }
        if ((i & 8) != 0) {
            j2 = animationState.getFinishedTimeNanos();
        }
        if ((i & 16) != 0) {
            z = animationState.isRunning();
        }
        boolean z2 = z;
        long j3 = j2;
        return copy(animationState, obj, animationVector, j, j3, z2);
    }

    public static final AnimationState copy(AnimationState animationState, Object obj, AnimationVector animationVector, long j, long j2, boolean z) {
        return new AnimationState(animationState.getTypeConverter(), obj, animationVector, j, j2, z);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ((Number) animationState.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f2 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        }
        if ((i & 4) != 0) {
            j = animationState.getLastFrameTimeNanos();
        }
        if ((i & 8) != 0) {
            j2 = animationState.getFinishedTimeNanos();
        }
        if ((i & 16) != 0) {
            z = animationState.isRunning();
        }
        boolean z2 = z;
        long j3 = j2;
        return copy(animationState, f, f2, j, j3, z2);
    }

    public static final AnimationState copy(AnimationState animationState, float f, float f2, long j, long j2, boolean z) {
        return new AnimationState(animationState.getTypeConverter(), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f2), j, j2, z);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            j = Long.MIN_VALUE;
        }
        if ((i & 8) != 0) {
            j2 = Long.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return AnimationState(f, f2, j, j2, z);
    }

    public static final AnimationState AnimationState(float f, float f2, long j, long j2, boolean z) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f2), j, j2, z);
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j, long j2, boolean z, int i, Object obj3) {
        if ((i & 8) != 0) {
            j = Long.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            j2 = Long.MIN_VALUE;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        return AnimationState(twoWayConverter, obj, obj2, j, j2, z);
    }

    public static final AnimationState AnimationState(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j, long j2, boolean z) {
        return new AnimationState(twoWayConverter, obj, (AnimationVector) twoWayConverter.getConvertToVector().invoke(obj2), j, j2, z);
    }

    public static final AnimationVector createZeroVectorFrom(TwoWayConverter twoWayConverter, Object obj) {
        AnimationVector animationVector = (AnimationVector) twoWayConverter.getConvertToVector().invoke(obj);
        animationVector.reset$animation_core_release();
        return animationVector;
    }
}
