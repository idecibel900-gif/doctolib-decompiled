package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.LayoutIdParentData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class ConstraintLayoutParentData implements LayoutIdParentData {
    private final Function1 constrain;
    private final Object layoutId;
    private final ConstrainedLayoutReference ref;

    public ConstraintLayoutParentData(ConstrainedLayoutReference constrainedLayoutReference, Function1 function1) {
        this.ref = constrainedLayoutReference;
        this.constrain = function1;
        this.layoutId = constrainedLayoutReference.getId$constraintlayout_compose_release();
    }

    public final ConstrainedLayoutReference getRef() {
        return this.ref;
    }

    public final Function1 getConstrain() {
        return this.constrain;
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    public Object getLayoutId() {
        return this.layoutId;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConstraintLayoutParentData)) {
            return false;
        }
        ConstraintLayoutParentData constraintLayoutParentData = (ConstraintLayoutParentData) obj;
        return Intrinsics.areEqual(this.ref.getId$constraintlayout_compose_release(), constraintLayoutParentData.ref.getId$constraintlayout_compose_release()) && this.constrain == constraintLayoutParentData.constrain;
    }

    public int hashCode() {
        return (this.ref.getId$constraintlayout_compose_release().hashCode() * 31) + this.constrain.hashCode();
    }
}
