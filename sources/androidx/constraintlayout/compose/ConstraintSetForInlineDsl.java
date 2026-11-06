package androidx.constraintlayout.compose;

import android.os.Handler;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintSetForInlineDsl implements ConstraintSet, RememberObserver {
    private Handler handler;
    private final ConstraintLayoutScope scope;
    private final SnapshotStateObserver observer = new SnapshotStateObserver(new ConstraintSetForInlineDsl$observer$1(this));
    private boolean knownDirty = true;
    private final Function1 onCommitAffectingConstrainLambdas = new Function1() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$onCommitAffectingConstrainLambdas$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Unit) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Unit unit) {
            this.this$0.setKnownDirty(true);
        }
    };
    private final List previousDatas = new ArrayList();

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    public ConstraintSetForInlineDsl(ConstraintLayoutScope constraintLayoutScope) {
        this.scope = constraintLayoutScope;
    }

    public final ConstraintLayoutScope getScope() {
        return this.scope;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(final State state, final List list) {
        this.previousDatas.clear();
        this.observer.observeReads(Unit.INSTANCE, this.onCommitAffectingConstrainLambdas, new Function0() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl.applyTo.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2688invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2688invoke() {
                List list2 = list;
                ConstraintSetForInlineDsl constraintSetForInlineDsl = this;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    Object parentData = ((Measurable) list2.get(i)).getParentData();
                    ConstraintLayoutParentData constraintLayoutParentData = parentData instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) parentData : null;
                    if (constraintLayoutParentData != null) {
                        ConstrainedLayoutReference ref = constraintLayoutParentData.getRef();
                        constraintLayoutParentData.getConstrain().invoke(new ConstrainScope(ref.getId$constraintlayout_compose_release(), constraintSetForInlineDsl.getScope().asCLContainer$constraintlayout_compose_release(ref)));
                    }
                    constraintSetForInlineDsl.previousDatas.add(constraintLayoutParentData);
                }
                this.getScope().applyTo(state);
            }
        });
        this.knownDirty = false;
    }

    public final void setKnownDirty(boolean z) {
        this.knownDirty = z;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean isDirty(List list) {
        if (this.knownDirty || list.size() != this.previousDatas.size()) {
            return true;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object parentData = ((Measurable) list.get(i)).getParentData();
            if (!Intrinsics.areEqual(parentData instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) parentData : null, this.previousDatas.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.observer.start();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.observer.stop();
        this.observer.clear();
    }
}
