package com.amazon.a.a.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Serializable, Iterable<a> {
    private static final long a = 1;
    private final List<a> b = new ArrayList();

    public boolean a() {
        return this.b.isEmpty();
    }

    public Collection<a> b() {
        return this.b;
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return this.b.iterator();
    }

    public void a(a aVar) {
        this.b.add(aVar);
    }

    public int c() {
        return this.b.size();
    }

    public String toString() {
        return "MetricBatch: [" + this.b + "]";
    }
}
