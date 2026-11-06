package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
final class SizeTransformImpl implements SizeTransform {
    private final boolean clip;
    private final Function2 sizeAnimationSpec;

    public SizeTransformImpl(boolean z, Function2 function2) {
        this.clip = z;
        this.sizeAnimationSpec = function2;
    }

    @Override // androidx.compose.animation.SizeTransform
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.animation.SizeTransform
    /* JADX INFO: renamed from: createAnimationSpec-TemP2vQ */
    public FiniteAnimationSpec mo63createAnimationSpecTemP2vQ(long j, long j2) {
        return (FiniteAnimationSpec) this.sizeAnimationSpec.invoke(IntSize.m2604boximpl(j), IntSize.m2604boximpl(j2));
    }
}
