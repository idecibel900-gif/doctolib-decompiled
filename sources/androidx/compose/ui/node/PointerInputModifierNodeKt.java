package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: loaded from: classes.dex */
public abstract class PointerInputModifierNodeKt {
    public static final LayoutCoordinates getLayoutCoordinates(PointerInputModifierNode pointerInputModifierNode) {
        return DelegatableNodeKt.m1891requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m1990constructorimpl(16));
    }
}
