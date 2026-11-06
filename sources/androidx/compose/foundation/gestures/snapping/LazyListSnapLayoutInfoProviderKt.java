package androidx.compose.foundation.gestures.snapping;

import androidx.compose.ui.unit.Density;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListSnapLayoutInfoProviderKt {
    public static final int calculateFinalSnappingItem(Density density, float f) {
        if (Math.abs(f) < density.mo231toPx0680j_4(SnapFlingBehaviorKt.getMinFlingVelocityDp())) {
            return FinalSnappingItem.Companion.m265getClosestItembbeMdSM();
        }
        return f > 0.0f ? FinalSnappingItem.Companion.m266getNextItembbeMdSM() : FinalSnappingItem.Companion.m267getPreviousItembbeMdSM();
    }
}
