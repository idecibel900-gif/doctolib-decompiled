package androidx.compose.foundation.text;

import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class EmptyMeasurePolicy implements MeasurePolicy {
    public static final EmptyMeasurePolicy INSTANCE = new EmptyMeasurePolicy();
    private static final Function1 placementBlock = new Function1() { // from class: androidx.compose.foundation.text.EmptyMeasurePolicy$placementBlock$1
        public final void invoke(Placeable.PlacementScope placementScope) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return Unit.INSTANCE;
        }
    };

    private EmptyMeasurePolicy() {
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo30measure3p2s80s(MeasureScope measureScope, List list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m2530getMaxWidthimpl(j), Constraints.m2529getMaxHeightimpl(j), null, placementBlock, 4, null);
    }
}
