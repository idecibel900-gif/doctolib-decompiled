package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo30measure3p2s80s(MeasureScope measureScope, List list, long j) {
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m2532getMinWidthimpl(j), Constraints.m2531getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        if (list.size() == 1) {
            final Placeable placeableMo1843measureBRTryo0 = ((Measurable) list.get(0)).mo1843measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, ConstraintsKt.m2545constrainWidthK40F9xA(j, placeableMo1843measureBRTryo0.getWidth()), ConstraintsKt.m2544constrainHeightK40F9xA(j, placeableMo1843measureBRTryo0.getHeight()), null, new Function1() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeableMo1843measureBRTryo0, 0, 0, 0.0f, null, 12, null);
                }
            }, 4, null);
        }
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Measurable) list.get(i)).mo1843measureBRTryo0(j));
        }
        int size2 = arrayList.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Placeable placeable = (Placeable) arrayList.get(i2);
            iMax = Math.max(placeable.getWidth(), iMax);
            iMax2 = Math.max(placeable.getHeight(), iMax2);
        }
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m2545constrainWidthK40F9xA(j, iMax), ConstraintsKt.m2544constrainHeightK40F9xA(j, iMax2), null, new Function1() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$4
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
                List list2 = arrayList;
                int size3 = list2.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, (Placeable) list2.get(i3), 0, 0, 0.0f, null, 12, null);
                }
            }
        }, 4, null);
    }
}
