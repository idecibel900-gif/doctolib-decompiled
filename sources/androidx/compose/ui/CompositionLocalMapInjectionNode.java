package androidx.compose.ui;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.node.DelegatableNodeKt;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalMapInjectionNode extends Modifier.Node {
    private CompositionLocalMap map;

    public CompositionLocalMapInjectionNode(CompositionLocalMap compositionLocalMap) {
        this.map = compositionLocalMap;
    }

    public final void setMap(CompositionLocalMap compositionLocalMap) {
        this.map = compositionLocalMap;
        DelegatableNodeKt.requireLayoutNode(this).setCompositionLocalMap(compositionLocalMap);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        DelegatableNodeKt.requireLayoutNode(this).setCompositionLocalMap(this.map);
    }
}
