package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Scale {
    private final FiniteAnimationSpec animationSpec;
    private final float scale;
    private final long transformOrigin;

    public /* synthetic */ Scale(float f, long j, FiniteAnimationSpec finiteAnimationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, j, finiteAnimationSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scale)) {
            return false;
        }
        Scale scale = (Scale) obj;
        return Float.compare(this.scale, scale.scale) == 0 && TransformOrigin.m1522equalsimpl0(this.transformOrigin, scale.transformOrigin) && Intrinsics.areEqual(this.animationSpec, scale.animationSpec);
    }

    public int hashCode() {
        return (((Float.hashCode(this.scale) * 31) + TransformOrigin.m1525hashCodeimpl(this.transformOrigin)) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Scale(scale=" + this.scale + ", transformOrigin=" + ((Object) TransformOrigin.m1526toStringimpl(this.transformOrigin)) + ", animationSpec=" + this.animationSpec + ')';
    }

    private Scale(float f, long j, FiniteAnimationSpec finiteAnimationSpec) {
        this.scale = f;
        this.transformOrigin = j;
        this.animationSpec = finiteAnimationSpec;
    }

    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    public final long m61getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }
}
