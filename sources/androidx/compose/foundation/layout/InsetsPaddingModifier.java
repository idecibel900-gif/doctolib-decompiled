package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InsetsPaddingModifier implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider {
    private final MutableState consumedInsets$delegate;
    private final WindowInsets insets;
    private final MutableState unconsumedInsets$delegate;

    public InsetsPaddingModifier(WindowInsets windowInsets) {
        this.insets = windowInsets;
        this.unconsumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, null, 2, null);
        this.consumedInsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(windowInsets, null, 2, null);
    }

    private final WindowInsets getUnconsumedInsets() {
        return (WindowInsets) this.unconsumedInsets$delegate.getValue();
    }

    private final void setUnconsumedInsets(WindowInsets windowInsets) {
        this.unconsumedInsets$delegate.setValue(windowInsets);
    }

    private final WindowInsets getConsumedInsets() {
        return (WindowInsets) this.consumedInsets$delegate.getValue();
    }

    private final void setConsumedInsets(WindowInsets windowInsets) {
        this.consumedInsets$delegate.setValue(windowInsets);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo32measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final int left = getUnconsumedInsets().getLeft(measureScope, measureScope.getLayoutDirection());
        final int top = getUnconsumedInsets().getTop(measureScope);
        int right = getUnconsumedInsets().getRight(measureScope, measureScope.getLayoutDirection()) + left;
        int bottom = getUnconsumedInsets().getBottom(measureScope) + top;
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(ConstraintsKt.m2547offsetNN6EwU(j, -right, -bottom));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m2545constrainWidthK40F9xA(j, placeableMo1843measureBRTryo0.getWidth() + right), ConstraintsKt.m2544constrainHeightK40F9xA(j, placeableMo1843measureBRTryo0.getHeight() + bottom), null, new Function1() { // from class: androidx.compose.foundation.layout.InsetsPaddingModifier$measure$1
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
                Placeable.PlacementScope.place$default(placementScope, placeableMo1843measureBRTryo0, left, top, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        WindowInsets windowInsets = (WindowInsets) modifierLocalReadScope.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, windowInsets));
        setConsumedInsets(WindowInsetsKt.union(windowInsets, this.insets));
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public WindowInsets getValue() {
        return getConsumedInsets();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InsetsPaddingModifier) {
            return Intrinsics.areEqual(((InsetsPaddingModifier) obj).insets, this.insets);
        }
        return false;
    }

    public int hashCode() {
        return this.insets.hashCode();
    }
}
