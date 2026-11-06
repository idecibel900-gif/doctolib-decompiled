package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;

/* JADX INFO: loaded from: classes.dex */
final class FocusTargetPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode {
    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(getNode().isAttached() && FocusGroupNode_androidKt.getView(this).hasFocusable());
    }
}
