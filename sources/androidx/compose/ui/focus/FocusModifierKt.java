package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class FocusModifierKt {
    public static final Modifier focusTarget(Modifier modifier) {
        return modifier.then(FocusTargetNode.FocusTargetElement.INSTANCE);
    }
}
