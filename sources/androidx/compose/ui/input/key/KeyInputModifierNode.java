package androidx.compose.ui.input.key;

import androidx.compose.ui.node.DelegatableNode;

/* JADX INFO: loaded from: classes.dex */
public interface KeyInputModifierNode extends DelegatableNode {
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    boolean mo102onKeyEventZmokQxo(android.view.KeyEvent keyEvent);

    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    boolean mo104onPreKeyEventZmokQxo(android.view.KeyEvent keyEvent);
}
