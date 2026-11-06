package androidx.constraintlayout.compose;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintLayoutScope extends ConstraintLayoutBaseScope {
    private final int ChildrenStartIndex;
    private int childId;
    private final ArrayList childrenRefs;
    private boolean isAnimateChanges;
    private ConstrainedLayoutReferences referencesObject;

    private static final class ConstrainAsModifier extends InspectorValueInfo implements ParentDataModifier {
        private final Function1 constrainBlock;
        private final ConstrainedLayoutReference ref;

        public ConstrainAsModifier(final ConstrainedLayoutReference constrainedLayoutReference, final Function1 function1) {
            super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.constraintlayout.compose.ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("constrainAs");
                    inspectorInfo.getProperties().set("ref", constrainedLayoutReference);
                    inspectorInfo.getProperties().set("constrainBlock", function1);
                }
            } : InspectableValueKt.getNoInspectorInfo());
            this.ref = constrainedLayoutReference;
            this.constrainBlock = function1;
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public ConstraintLayoutParentData modifyParentData(Density density, Object obj) {
            return new ConstraintLayoutParentData(this.ref, this.constrainBlock);
        }

        public int hashCode() {
            return this.constrainBlock.hashCode();
        }

        public boolean equals(Object obj) {
            Function1 function1 = this.constrainBlock;
            ConstrainAsModifier constrainAsModifier = obj instanceof ConstrainAsModifier ? (ConstrainAsModifier) obj : null;
            return function1 == (constrainAsModifier != null ? constrainAsModifier.constrainBlock : null);
        }
    }

    public ConstraintLayoutScope() {
        super(null);
        this.childId = this.ChildrenStartIndex;
        this.childrenRefs = new ArrayList();
    }

    public final ConstrainedLayoutReference createRef() {
        ArrayList arrayList = this.childrenRefs;
        int i = this.childId;
        this.childId = i + 1;
        ConstrainedLayoutReference constrainedLayoutReference = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList, i);
        if (constrainedLayoutReference != null) {
            return constrainedLayoutReference;
        }
        ConstrainedLayoutReference constrainedLayoutReference2 = new ConstrainedLayoutReference(Integer.valueOf(this.childId));
        this.childrenRefs.add(constrainedLayoutReference2);
        return constrainedLayoutReference2;
    }

    public final ConstrainedLayoutReferences createRefs() {
        ConstrainedLayoutReferences constrainedLayoutReferences = this.referencesObject;
        if (constrainedLayoutReferences != null) {
            return constrainedLayoutReferences;
        }
        ConstrainedLayoutReferences constrainedLayoutReferences2 = new ConstrainedLayoutReferences();
        this.referencesObject = constrainedLayoutReferences2;
        return constrainedLayoutReferences2;
    }

    @Override // androidx.constraintlayout.compose.ConstraintLayoutBaseScope
    public void reset() {
        super.reset();
        this.childId = this.ChildrenStartIndex;
    }

    public final class ConstrainedLayoutReferences {
        public ConstrainedLayoutReferences() {
        }

        public final ConstrainedLayoutReference component1() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component2() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component3() {
            return ConstraintLayoutScope.this.createRef();
        }

        public final ConstrainedLayoutReference component4() {
            return ConstraintLayoutScope.this.createRef();
        }
    }

    public final Modifier constrainAs(Modifier modifier, ConstrainedLayoutReference constrainedLayoutReference, Function1 function1) {
        if (this.isAnimateChanges) {
            function1.invoke(new ConstrainScope(constrainedLayoutReference.getId$constraintlayout_compose_release(), asCLContainer$constraintlayout_compose_release(constrainedLayoutReference)));
        }
        return modifier.then(new ConstrainAsModifier(constrainedLayoutReference, function1));
    }
}
