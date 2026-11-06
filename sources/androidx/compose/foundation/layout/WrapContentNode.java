package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2 alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }

    public final Function2 getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final void setAlignmentCallback(Function2 function2) {
        this.alignmentCallback = function2;
    }

    public WrapContentNode(Direction direction, boolean z, Function2 function2) {
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = function2;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int iM2532getMinWidthimpl = direction != direction2 ? 0 : Constraints.m2532getMinWidthimpl(j);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.Constraints(iM2532getMinWidthimpl, (this.direction == direction2 || !this.unbounded) ? Constraints.m2530getMaxWidthimpl(j) : Integer.MAX_VALUE, direction3 == direction4 ? Constraints.m2531getMinHeightimpl(j) : 0, (this.direction == direction4 || !this.unbounded) ? Constraints.m2529getMaxHeightimpl(j) : Integer.MAX_VALUE));
        final int iCoerceIn = RangesKt.coerceIn(placeableMo1843measureBRTryo0.getWidth(), Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j));
        final int iCoerceIn2 = RangesKt.coerceIn(placeableMo1843measureBRTryo0.getHeight(), Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j));
        return MeasureScope.layout$default(measureScope, iCoerceIn, iCoerceIn2, null, new Function1() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m1865place70tqf50$default(placementScope, placeableMo1843measureBRTryo0, ((IntOffset) this.this$0.getAlignmentCallback().invoke(IntSize.m2604boximpl(IntSizeKt.IntSize(iCoerceIn - placeableMo1843measureBRTryo0.getWidth(), iCoerceIn2 - placeableMo1843measureBRTryo0.getHeight())), measureScope.getLayoutDirection())).m2597unboximpl(), 0.0f, 2, null);
            }
        }, 4, null);
    }
}
