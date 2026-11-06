package androidx.compose.ui.node;

/* JADX INFO: loaded from: classes.dex */
public abstract class DrawModifierNodeKt {
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m1891requireCoordinator64DMado(drawModifierNode, NodeKind.m1990constructorimpl(1)).invalidateLayer();
        }
    }
}
