package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class RawConstraintSet implements ConstraintSet {
    private final CLObject clObject;
    private final ConstraintSetParser.LayoutVariables layoutVariables = new ConstraintSetParser.LayoutVariables();

    public RawConstraintSet(CLObject cLObject) {
        this.clObject = cLObject;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(State state, List list) {
        ConstraintSetParser.populateState(this.clObject, state, this.layoutVariables);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(RawConstraintSet.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.constraintlayout.compose.RawConstraintSet");
        return Intrinsics.areEqual(this.clObject, ((RawConstraintSet) obj).clObject);
    }

    public int hashCode() {
        return this.clObject.hashCode();
    }
}
