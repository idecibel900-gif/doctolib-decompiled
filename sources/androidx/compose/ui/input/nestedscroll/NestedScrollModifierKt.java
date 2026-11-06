package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class NestedScrollModifierKt {
    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }

    public static final Modifier nestedScroll(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        return modifier.then(new NestedScrollElement(nestedScrollConnection, nestedScrollDispatcher));
    }
}
