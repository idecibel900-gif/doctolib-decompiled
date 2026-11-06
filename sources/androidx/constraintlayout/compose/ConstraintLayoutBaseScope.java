package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintLayoutBaseScope {
    private final int HelpersStartId;
    private final CLObject containerObject;
    private int helperId;
    private int helpersHashCode;
    private final List tasks = new ArrayList();

    public ConstraintLayoutBaseScope(CLObject cLObject) {
        CLObject cLObjectMo2697clone;
        this.containerObject = (cLObject == null || (cLObjectMo2697clone = cLObject.mo2697clone()) == null) ? new CLObject(new char[0]) : cLObjectMo2697clone;
        this.HelpersStartId = 1000;
        this.helperId = 1000;
    }

    public final CLObject getContainerObject() {
        return this.containerObject;
    }

    public final void applyTo(State state) {
        ConstraintSetParser.populateState(this.containerObject, state, new ConstraintSetParser.LayoutVariables());
    }

    public void reset() {
        this.containerObject.clear();
        this.helperId = this.HelpersStartId;
        this.helpersHashCode = 0;
    }

    public final int getHelpersHashCode() {
        return this.helpersHashCode;
    }

    private final void updateHelpersHashCode(int i) {
        this.helpersHashCode = ((this.helpersHashCode * 1009) + i) % 1000000007;
    }

    private final int createHelperId() {
        int i = this.helperId;
        this.helperId = i + 1;
        return i;
    }

    public static final class VerticalAnchor {
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerticalAnchor)) {
                return false;
            }
            VerticalAnchor verticalAnchor = (VerticalAnchor) obj;
            return Intrinsics.areEqual(this.id, verticalAnchor.id) && this.index == verticalAnchor.index && Intrinsics.areEqual(this.reference, verticalAnchor.reference);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "VerticalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public VerticalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }
    }

    public static final class HorizontalAnchor {
        private final Object id;
        private final int index;
        private final LayoutReference reference;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HorizontalAnchor)) {
                return false;
            }
            HorizontalAnchor horizontalAnchor = (HorizontalAnchor) obj;
            return Intrinsics.areEqual(this.id, horizontalAnchor.id) && this.index == horizontalAnchor.index && Intrinsics.areEqual(this.reference, horizontalAnchor.reference);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "HorizontalAnchor(id=" + this.id + ", index=" + this.index + ", reference=" + this.reference + ')';
        }

        public HorizontalAnchor(Object obj, int i, LayoutReference layoutReference) {
            this.id = obj;
            this.index = i;
            this.reference = layoutReference;
        }

        public final Object getId$constraintlayout_compose_release() {
            return this.id;
        }

        public final int getIndex$constraintlayout_compose_release() {
            return this.index;
        }
    }

    public static final class BaselineAnchor {
        private final Object id;
        private final LayoutReference reference;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BaselineAnchor)) {
                return false;
            }
            BaselineAnchor baselineAnchor = (BaselineAnchor) obj;
            return Intrinsics.areEqual(this.id, baselineAnchor.id) && Intrinsics.areEqual(this.reference, baselineAnchor.reference);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.reference.hashCode();
        }

        public String toString() {
            return "BaselineAnchor(id=" + this.id + ", reference=" + this.reference + ')';
        }

        public BaselineAnchor(Object obj, LayoutReference layoutReference) {
            this.id = obj;
            this.reference = layoutReference;
        }
    }

    /* JADX INFO: renamed from: createBottomBarrier-3ABfNKs$default, reason: not valid java name */
    public static /* synthetic */ HorizontalAnchor m2683createBottomBarrier3ABfNKs$default(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
        }
        if ((i & 2) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        return constraintLayoutBaseScope.m2684createBottomBarrier3ABfNKs(layoutReferenceArr, f);
    }

    /* JADX INFO: renamed from: createEndBarrier-3ABfNKs, reason: not valid java name */
    public final VerticalAnchor m2685createEndBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "end");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(13);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m2554hashCodeimpl(f));
        return new VerticalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl);
    }

    /* JADX INFO: renamed from: createBottomBarrier-3ABfNKs, reason: not valid java name */
    public final HorizontalAnchor m2684createBottomBarrier3ABfNKs(LayoutReference[] layoutReferenceArr, float f) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(createHelperId()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.add(CLString.from(layoutReference.getId$constraintlayout_compose_release().toString()));
        }
        CLObject cLObjectAsCLContainer$constraintlayout_compose_release = asCLContainer$constraintlayout_compose_release(layoutReferenceImpl);
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("type", "barrier");
        cLObjectAsCLContainer$constraintlayout_compose_release.putString("direction", "bottom");
        cLObjectAsCLContainer$constraintlayout_compose_release.putNumber("margin", f);
        cLObjectAsCLContainer$constraintlayout_compose_release.put("contains", cLArray);
        updateHelpersHashCode(15);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            updateHelpersHashCode(layoutReference2.hashCode());
        }
        updateHelpersHashCode(Dp.m2554hashCodeimpl(f));
        return new HorizontalAnchor(layoutReferenceImpl.getId$constraintlayout_compose_release(), 0, layoutReferenceImpl);
    }

    public final CLObject asCLContainer$constraintlayout_compose_release(LayoutReference layoutReference) {
        String string = layoutReference.getId$constraintlayout_compose_release().toString();
        if (this.containerObject.getObjectOrNull(string) == null) {
            this.containerObject.put(string, new CLObject(new char[0]));
        }
        return this.containerObject.getObject(string);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstraintLayoutBaseScope) {
            return Intrinsics.areEqual(this.containerObject, ((ConstraintLayoutBaseScope) obj).containerObject);
        }
        return false;
    }

    public int hashCode() {
        return this.containerObject.hashCode();
    }
}
