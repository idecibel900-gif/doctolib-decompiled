package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo54measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        float f = 0;
        if (Dp.m2550compareTo0680j_4(this.paddingValues.mo295calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m2551constructorimpl(f)) < 0 || Dp.m2550compareTo0680j_4(this.paddingValues.mo297calculateTopPaddingD9Ej5fM(), Dp.m2551constructorimpl(f)) < 0 || Dp.m2550compareTo0680j_4(this.paddingValues.mo296calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m2551constructorimpl(f)) < 0 || Dp.m2550compareTo0680j_4(this.paddingValues.mo294calculateBottomPaddingD9Ej5fM(), Dp.m2551constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative");
        }
        int iMo225roundToPx0680j_4 = measureScope.mo225roundToPx0680j_4(this.paddingValues.mo295calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo225roundToPx0680j_4(this.paddingValues.mo296calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int iMo225roundToPx0680j_5 = measureScope.mo225roundToPx0680j_4(this.paddingValues.mo297calculateTopPaddingD9Ej5fM()) + measureScope.mo225roundToPx0680j_4(this.paddingValues.mo294calculateBottomPaddingD9Ej5fM());
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.m2547offsetNN6EwU(j, -iMo225roundToPx0680j_4, -iMo225roundToPx0680j_5));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m2545constrainWidthK40F9xA(j, placeableMo1843measureBRTryo0.getWidth() + iMo225roundToPx0680j_4), ConstraintsKt.m2544constrainHeightK40F9xA(j, placeableMo1843measureBRTryo0.getHeight() + iMo225roundToPx0680j_5), null, new Function1() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, measureScope.mo225roundToPx0680j_4(this.getPaddingValues().mo295calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())), measureScope.mo225roundToPx0680j_4(this.getPaddingValues().mo297calculateTopPaddingD9Ej5fM()), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
