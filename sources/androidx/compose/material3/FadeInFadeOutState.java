package androidx.compose.material3;

import androidx.compose.runtime.RecomposeScope;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class FadeInFadeOutState {
    private Object current = new Object();
    private List items = new ArrayList();
    private RecomposeScope scope;

    public final Object getCurrent() {
        return this.current;
    }

    public final void setCurrent(Object obj) {
        this.current = obj;
    }

    public final List getItems() {
        return this.items;
    }

    public final RecomposeScope getScope() {
        return this.scope;
    }

    public final void setScope(RecomposeScope recomposeScope) {
        this.scope = recomposeScope;
    }
}
