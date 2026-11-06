package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class RotaryInputNode extends Modifier.Node implements RotaryInputModifierNode {
    private Function1 onEvent;
    private Function1 onPreEvent;

    public final void setOnEvent(Function1 function1) {
        this.onEvent = function1;
    }

    public final void setOnPreEvent(Function1 function1) {
        this.onPreEvent = function1;
    }

    public RotaryInputNode(Function1 function1, Function1 function2) {
        this.onEvent = function1;
        this.onPreEvent = function2;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public boolean onRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
        Function1 function1 = this.onEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(rotaryScrollEvent)).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.rotary.RotaryInputModifierNode
    public boolean onPreRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent) {
        Function1 function1 = this.onPreEvent;
        if (function1 != null) {
            return ((Boolean) function1.invoke(rotaryScrollEvent)).booleanValue();
        }
        return false;
    }
}
