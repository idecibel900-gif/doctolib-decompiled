package androidx.compose.foundation;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class OverscrollKt {
    public static final Modifier overscroll(Modifier modifier, OverscrollEffect overscrollEffect) {
        return modifier.then(overscrollEffect.getEffectModifier());
    }
}
