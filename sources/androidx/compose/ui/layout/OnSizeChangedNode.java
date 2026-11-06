package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class OnSizeChangedNode extends Modifier.Node implements LayoutAwareModifierNode {
    private Function1 onSizeChanged;
    private final boolean shouldAutoInvalidate = true;
    private long previousSize = IntSizeKt.IntSize(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);

    public OnSizeChangedNode(Function1 function1) {
        this.onSizeChanged = function1;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final void update(Function1 function1) {
        this.onSizeChanged = function1;
        this.previousSize = IntSizeKt.IntSize(LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo195onRemeasuredozmzZPI(long j) {
        if (IntSize.m2607equalsimpl0(this.previousSize, j)) {
            return;
        }
        this.onSizeChanged.invoke(IntSize.m2604boximpl(j));
        this.previousSize = j;
    }
}
