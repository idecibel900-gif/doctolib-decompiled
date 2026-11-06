package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: loaded from: classes.dex */
final class TestTagNode extends Modifier.Node implements SemanticsModifierNode {
    private String tag;

    public TestTagNode(String str) {
        this.tag = str;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTestTag(semanticsPropertyReceiver, this.tag);
    }
}
