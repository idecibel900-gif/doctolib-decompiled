package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class InitializedLazyImpl implements Lazy, Serializable {
    private final Object value;

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return true;
    }

    public InitializedLazyImpl(Object obj) {
        this.value = obj;
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
