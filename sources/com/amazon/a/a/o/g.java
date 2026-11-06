package com.amazon.a.a.o;

import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class g<T> implements Iterable<T> {
    private WeakHashMap<T, Object> a = new WeakHashMap<>();

    public void a(T t) {
        this.a.put(t, null);
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.a.keySet().iterator();
    }

    public void b(T t) {
        this.a.remove(t);
    }

    public int b() {
        return this.a.size();
    }

    public String toString() {
        return this.a.keySet().toString();
    }
}
