package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Pair implements Map.Entry, Comparable, Serializable {
    public abstract Object getLeft();

    public abstract Object getRight();

    public static Pair of(Object obj, Object obj2) {
        return new ImmutablePair(obj, obj2);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return getLeft();
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return getRight();
    }

    @Override // java.lang.Comparable
    public int compareTo(Pair pair) {
        return new CompareToBuilder().append(getLeft(), pair.getLeft()).append(getRight(), pair.getRight()).toComparison();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
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
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return "(" + getLeft() + ',' + getRight() + ')';
    }
}
