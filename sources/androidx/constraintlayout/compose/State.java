package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.CorePixelDp;

/* JADX INFO: loaded from: classes.dex */
public final class State extends androidx.constraintlayout.core.state.State {
    private final Density density;
    private long rootIncomingConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;

    public State(Density density) {
        this.density = density;
        setDpToPixel(new CorePixelDp() { // from class: androidx.constraintlayout.compose.State$$ExternalSyntheticLambda0
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float toPixels(float f) {
                return State._init_$lambda$0(this.f$0, f);
            }
        });
    }

    /* JADX INFO: renamed from: getRootIncomingConstraints-msEJaDk, reason: not valid java name */
    public final long m2694getRootIncomingConstraintsmsEJaDk() {
        return this.rootIncomingConstraints;
    }

    /* JADX INFO: renamed from: setRootIncomingConstraints-BRTryo0, reason: not valid java name */
    public final void m2695setRootIncomingConstraintsBRTryo0(long j) {
        this.rootIncomingConstraints = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _init_$lambda$0(State state, float f) {
        return state.density.getDensity() * f;
    }

    @Override // androidx.constraintlayout.core.state.State
    public int convertDimension(Object obj) {
        if (obj instanceof Dp) {
            return this.density.mo225roundToPx0680j_4(((Dp) obj).m2557unboximpl());
        }
        return super.convertDimension(obj);
    }
}
