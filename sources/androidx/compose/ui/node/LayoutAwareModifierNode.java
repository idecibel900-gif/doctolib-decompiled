package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    default void onPlaced(LayoutCoordinates layoutCoordinates) {
    }

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    default void mo195onRemeasuredozmzZPI(long j) {
    }
}
