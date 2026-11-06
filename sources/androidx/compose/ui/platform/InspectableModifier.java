package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final class InspectableModifier extends InspectorValueInfo implements Modifier.Element {
    private final End end;

    public final class End implements Modifier.Element {
        public End() {
        }
    }

    public InspectableModifier(Function1 function1) {
        super(function1);
        this.end = new End();
    }
}
