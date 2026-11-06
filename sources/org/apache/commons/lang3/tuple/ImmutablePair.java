package org.apache.commons.lang3.tuple;

/* JADX INFO: loaded from: classes5.dex */
public final class ImmutablePair extends Pair {
    private static final ImmutablePair NULL = of((Object) null, (Object) null);
    public final Object left;
    public final Object right;

    public static ImmutablePair of(Object obj, Object obj2) {
        return new ImmutablePair(obj, obj2);
    }

    public ImmutablePair(Object obj, Object obj2) {
        this.left = obj;
        this.right = obj2;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public Object getLeft() {
        return this.left;
    }

    @Override // org.apache.commons.lang3.tuple.Pair
    public Object getRight() {
        return this.right;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
