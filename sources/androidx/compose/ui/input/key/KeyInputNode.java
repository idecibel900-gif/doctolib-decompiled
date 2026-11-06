package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {
    private Function1 onEvent;
    private Function1 onPreEvent;

    public final void setOnEvent(Function1 function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(Function1 function1) {
        this.onPreEvent = function1;
    }

    public KeyInputNode(Function1 function1, Function1 function2) {
        this.onEvent = function1;
        this.onPreEvent = function2;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo */
    public boolean mo102onKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m1711boximpl(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo104onPreKeyEventZmokQxo(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.m1711boximpl(keyEvent))).booleanValue();
        }
        return false;
    }
}
