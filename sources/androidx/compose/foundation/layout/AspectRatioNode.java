package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM281findSizeToXhtMw = m281findSizeToXhtMw(j);
        if (!IntSize.m2607equalsimpl0(jM281findSizeToXhtMw, IntSize.Companion.m2613getZeroYbymL2g())) {
            j = Constraints.Companion.m2539fixedJhjzzOo(IntSize.m2609getWidthimpl(jM281findSizeToXhtMw), IntSize.m2608getHeightimpl(jM281findSizeToXhtMw));
        }
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(i * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(i * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(i / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return Math.round(i / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m281findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM285tryMaxWidthJN0ABg$default = m285tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m2607equalsimpl0(jM285tryMaxWidthJN0ABg$default, companion.m2613getZeroYbymL2g())) {
                return jM285tryMaxWidthJN0ABg$default;
            }
            long jM283tryMaxHeightJN0ABg$default = m283tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM283tryMaxHeightJN0ABg$default, companion.m2613getZeroYbymL2g())) {
                return jM283tryMaxHeightJN0ABg$default;
            }
            long jM289tryMinWidthJN0ABg$default = m289tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM289tryMinWidthJN0ABg$default, companion.m2613getZeroYbymL2g())) {
                return jM289tryMinWidthJN0ABg$default;
            }
            long jM287tryMinHeightJN0ABg$default = m287tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM287tryMinHeightJN0ABg$default, companion.m2613getZeroYbymL2g())) {
                return jM287tryMinHeightJN0ABg$default;
            }
            long jM284tryMaxWidthJN0ABg = m284tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM284tryMaxWidthJN0ABg, companion.m2613getZeroYbymL2g())) {
                return jM284tryMaxWidthJN0ABg;
            }
            long jM282tryMaxHeightJN0ABg = m282tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM282tryMaxHeightJN0ABg, companion.m2613getZeroYbymL2g())) {
                return jM282tryMaxHeightJN0ABg;
            }
            long jM288tryMinWidthJN0ABg = m288tryMinWidthJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM288tryMinWidthJN0ABg, companion.m2613getZeroYbymL2g())) {
                return jM288tryMinWidthJN0ABg;
            }
            long jM286tryMinHeightJN0ABg = m286tryMinHeightJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM286tryMinHeightJN0ABg, companion.m2613getZeroYbymL2g())) {
                return jM286tryMinHeightJN0ABg;
            }
        } else {
            long jM283tryMaxHeightJN0ABg$default2 = m283tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m2607equalsimpl0(jM283tryMaxHeightJN0ABg$default2, companion2.m2613getZeroYbymL2g())) {
                return jM283tryMaxHeightJN0ABg$default2;
            }
            long jM285tryMaxWidthJN0ABg$default2 = m285tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM285tryMaxWidthJN0ABg$default2, companion2.m2613getZeroYbymL2g())) {
                return jM285tryMaxWidthJN0ABg$default2;
            }
            long jM287tryMinHeightJN0ABg$default2 = m287tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM287tryMinHeightJN0ABg$default2, companion2.m2613getZeroYbymL2g())) {
                return jM287tryMinHeightJN0ABg$default2;
            }
            long jM289tryMinWidthJN0ABg$default2 = m289tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2607equalsimpl0(jM289tryMinWidthJN0ABg$default2, companion2.m2613getZeroYbymL2g())) {
                return jM289tryMinWidthJN0ABg$default2;
            }
            long jM282tryMaxHeightJN0ABg2 = m282tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM282tryMaxHeightJN0ABg2, companion2.m2613getZeroYbymL2g())) {
                return jM282tryMaxHeightJN0ABg2;
            }
            long jM284tryMaxWidthJN0ABg2 = m284tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM284tryMaxWidthJN0ABg2, companion2.m2613getZeroYbymL2g())) {
                return jM284tryMaxWidthJN0ABg2;
            }
            long jM286tryMinHeightJN0ABg2 = m286tryMinHeightJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM286tryMinHeightJN0ABg2, companion2.m2613getZeroYbymL2g())) {
                return jM286tryMinHeightJN0ABg2;
            }
            long jM288tryMinWidthJN0ABg2 = m288tryMinWidthJN0ABg(j, false);
            if (!IntSize.m2607equalsimpl0(jM288tryMinWidthJN0ABg2, companion2.m2613getZeroYbymL2g())) {
                return jM288tryMinWidthJN0ABg2;
            }
        }
        return IntSize.Companion.m2613getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m285tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m284tryMaxWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m284tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
        if (iM2530getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM2530getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM2530getMaxWidthimpl, iRound);
            if (!z || ConstraintsKt.m2546isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m2613getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m283tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m282tryMaxHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m282tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM2529getMaxHeightimpl = Constraints.m2529getMaxHeightimpl(j);
        if (iM2529getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM2529getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM2529getMaxHeightimpl);
            if (!z || ConstraintsKt.m2546isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m2613getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m289tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m288tryMinWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m288tryMinWidthJN0ABg(long j, boolean z) {
        int iM2532getMinWidthimpl = Constraints.m2532getMinWidthimpl(j);
        int iRound = Math.round(iM2532getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM2532getMinWidthimpl, iRound);
            if (!z || ConstraintsKt.m2546isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m2613getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m287tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m286tryMinHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m286tryMinHeightJN0ABg(long j, boolean z) {
        int iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
        int iRound = Math.round(iM2531getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM2531getMinHeightimpl);
            if (!z || ConstraintsKt.m2546isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.Companion.m2613getZeroYbymL2g();
    }
}
