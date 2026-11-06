package com.google.common.collect;

import com.amazon.a.a.o.b.f;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractMapEntry implements Map.Entry {
    @Override // java.util.Map.Entry
    public abstract Object getKey();

    @Override // java.util.Map.Entry
    public abstract Object getValue();

    AbstractMapEntry() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        return getKey() + f.b + getValue();
    }
}
