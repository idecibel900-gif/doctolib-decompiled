package androidx.constraintlayout.compose;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutReference {
    private final Map helperParamsMap = new LinkedHashMap();
    private final Object id;

    public LayoutReference(Object obj) {
        this.id = obj;
    }

    public Object getId$constraintlayout_compose_release() {
        return this.id;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutReference) && Intrinsics.areEqual(getId$constraintlayout_compose_release(), ((LayoutReference) obj).getId$constraintlayout_compose_release());
    }

    public int hashCode() {
        return getId$constraintlayout_compose_release().hashCode();
    }
}
