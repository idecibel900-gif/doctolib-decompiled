package androidx.constraintlayout.compose;

/* JADX INFO: loaded from: classes.dex */
public final class ConstrainedLayoutReference extends LayoutReference {
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteLeft;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteRight;
    private final ConstraintLayoutBaseScope.BaselineAnchor baseline;
    private final ConstraintLayoutBaseScope.HorizontalAnchor bottom;
    private final ConstraintLayoutBaseScope.VerticalAnchor end;
    private final Object id;
    private final ConstraintLayoutBaseScope.VerticalAnchor start;
    private final ConstraintLayoutBaseScope.HorizontalAnchor top;

    public ConstrainedLayoutReference(Object obj) {
        super(obj);
        this.id = obj;
        this.start = new ConstraintLayoutBaseScope.VerticalAnchor(getId$constraintlayout_compose_release(), -2, this);
        this.absoluteLeft = new ConstraintLayoutBaseScope.VerticalAnchor(getId$constraintlayout_compose_release(), 0, this);
        this.top = new ConstraintLayoutBaseScope.HorizontalAnchor(getId$constraintlayout_compose_release(), 0, this);
        this.end = new ConstraintLayoutBaseScope.VerticalAnchor(getId$constraintlayout_compose_release(), -1, this);
        this.absoluteRight = new ConstraintLayoutBaseScope.VerticalAnchor(getId$constraintlayout_compose_release(), 1, this);
        this.bottom = new ConstraintLayoutBaseScope.HorizontalAnchor(getId$constraintlayout_compose_release(), 1, this);
        this.baseline = new ConstraintLayoutBaseScope.BaselineAnchor(getId$constraintlayout_compose_release(), this);
    }

    @Override // androidx.constraintlayout.compose.LayoutReference
    public Object getId$constraintlayout_compose_release() {
        return this.id;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getStart() {
        return this.start;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getTop() {
        return this.top;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getEnd() {
        return this.end;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getBottom() {
        return this.bottom;
    }
}
