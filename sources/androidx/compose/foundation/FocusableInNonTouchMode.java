package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;

/* JADX INFO: loaded from: classes.dex */
public final class FocusableInNonTouchMode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode {
    private final boolean shouldAutoInvalidate;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    private final InputModeManager getInputModeManager() {
        return (InputModeManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalInputModeManager());
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(!InputMode.m1684equalsimpl0(getInputModeManager().mo1690getInputModeaOaMEAU(), InputMode.Companion.m1689getTouchaOaMEAU()));
    }
}
