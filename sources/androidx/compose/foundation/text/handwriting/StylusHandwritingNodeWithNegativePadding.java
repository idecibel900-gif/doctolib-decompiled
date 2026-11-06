package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class StylusHandwritingNodeWithNegativePadding extends StylusHandwritingNode implements LayoutModifierNode {
    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public boolean sharePointerInputWithSiblings() {
        return true;
    }

    public StylusHandwritingNodeWithNegativePadding(Function0 function0) {
        super(function0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final int iMo225roundToPx0680j_4 = measureScope.mo225roundToPx0680j_4(StylusHandwritingKt.getHandwritingBoundsVerticalOffset());
        final int iMo225roundToPx0680j_5 = measureScope.mo225roundToPx0680j_4(StylusHandwritingKt.getHandwritingBoundsHorizontalOffset());
        int i = iMo225roundToPx0680j_5 * 2;
        int i2 = iMo225roundToPx0680j_4 * 2;
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.m2547offsetNN6EwU(j, i, i2));
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth() - i, placeableMo1843measureBRTryo0.getHeight() - i2, null, new Function1() { // from class: androidx.compose.foundation.text.handwriting.StylusHandwritingNodeWithNegativePadding$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, -iMo225roundToPx0680j_5, -iMo225roundToPx0680j_4, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
