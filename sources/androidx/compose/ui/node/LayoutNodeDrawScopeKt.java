package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutNodeDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node nextDrawNode(DelegatableNode delegatableNode) {
        int iM1990constructorimpl = NodeKind.m1990constructorimpl(4);
        int iM1990constructorimpl2 = NodeKind.m1990constructorimpl(2);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null || (child$ui_release.getAggregateChildKindSet$ui_release() & iM1990constructorimpl) == 0) {
            return null;
        }
        while (child$ui_release != null && (child$ui_release.getKindSet$ui_release() & iM1990constructorimpl2) == 0) {
            if ((child$ui_release.getKindSet$ui_release() & iM1990constructorimpl) != 0) {
                return child$ui_release;
            }
            child$ui_release = child$ui_release.getChild$ui_release();
        }
        return null;
    }
}
