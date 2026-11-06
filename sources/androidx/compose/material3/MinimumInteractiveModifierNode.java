package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int width;
        int height;
        float f = 0;
        float fM2551constructorimpl = Dp.m2551constructorimpl(RangesKt.coerceAtLeast(((Dp) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).m2557unboximpl(), Dp.m2551constructorimpl(f)));
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(j);
        boolean z = isAttached() && !Float.isNaN(fM2551constructorimpl) && Dp.m2550compareTo0680j_4(fM2551constructorimpl, Dp.m2551constructorimpl(f)) > 0;
        int iMo225roundToPx0680j_4 = Float.isNaN(fM2551constructorimpl) ? 0 : measureScope.mo225roundToPx0680j_4(fM2551constructorimpl);
        if (z) {
            width = Math.max(placeableMo1843measureBRTryo0.getWidth(), iMo225roundToPx0680j_4);
        } else {
            width = placeableMo1843measureBRTryo0.getWidth();
        }
        final int i = width;
        if (z) {
            height = Math.max(placeableMo1843measureBRTryo0.getHeight(), iMo225roundToPx0680j_4);
        } else {
            height = placeableMo1843measureBRTryo0.getHeight();
        }
        final int i2 = height;
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1() { // from class: androidx.compose.material3.MinimumInteractiveModifierNode$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, MathKt.roundToInt((i - placeableMo1843measureBRTryo0.getWidth()) / 2.0f), MathKt.roundToInt((i2 - placeableMo1843measureBRTryo0.getHeight()) / 2.0f), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
