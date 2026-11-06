package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public interface VerticalAnchorable {
    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    void mo2679linkToVpY3zN4(ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, float f, float f2);

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m2696linkToVpY3zN4$default(VerticalAnchorable verticalAnchorable, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        verticalAnchorable.mo2679linkToVpY3zN4(verticalAnchor, f, f2);
    }
}
