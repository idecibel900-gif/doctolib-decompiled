package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetContainer extends ConstraintWidget {
    public ArrayList mChildren;

    public abstract void layout();

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int i, int i2) {
        super(i, i2);
        this.mChildren = new ArrayList();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.reset();
    }

    public ArrayList getChildren() {
        return this.mChildren;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetSolverVariables(cache);
        }
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }
}
