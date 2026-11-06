package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM2532getMinWidthimpl;
        int iM2530getMaxWidthimpl;
        int iM2529getMaxHeightimpl;
        int iCoerceIn;
        if (Constraints.m2526getHasBoundedWidthimpl(j) && this.direction != Direction.Vertical) {
            iM2532getMinWidthimpl = RangesKt.coerceIn(Math.round(Constraints.m2530getMaxWidthimpl(j) * this.fraction), Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j));
            iM2530getMaxWidthimpl = iM2532getMinWidthimpl;
        } else {
            iM2532getMinWidthimpl = Constraints.m2532getMinWidthimpl(j);
            iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
        }
        if (Constraints.m2525getHasBoundedHeightimpl(j) && this.direction != Direction.Horizontal) {
            iCoerceIn = RangesKt.coerceIn(Math.round(Constraints.m2529getMaxHeightimpl(j) * this.fraction), Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j));
            iM2529getMaxHeightimpl = iCoerceIn;
        } else {
            int iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
            iM2529getMaxHeightimpl = Constraints.m2529getMaxHeightimpl(j);
            iCoerceIn = iM2531getMinHeightimpl;
        }
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.Constraints(iM2532getMinWidthimpl, iM2530getMaxWidthimpl, iCoerceIn, iM2529getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), placeableMo1843measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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
}
