package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier align(Modifier modifier, Alignment alignment) {
        return this.$$delegate_0.align(modifier, alignment);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m2524equalsimpl0(this.constraints, boxWithConstraintsScopeImpl.constraints);
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m2533hashCodeimpl(this.constraints);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier matchParentSize(Modifier modifier) {
        return this.$$delegate_0.matchParentSize(modifier);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m2535toStringimpl(this.constraints)) + ')';
    }

    private BoxWithConstraintsScopeImpl(Density density, long j) {
        this.density = density;
        this.constraints = j;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public long m292getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo291getMaxWidthD9Ej5fM() {
        return Constraints.m2526getHasBoundedWidthimpl(m292getConstraintsmsEJaDk()) ? this.density.mo228toDpu2uoSUM(Constraints.m2530getMaxWidthimpl(m292getConstraintsmsEJaDk())) : Dp.Companion.m2559getInfinityD9Ej5fM();
    }
}
