package com.adjust.sdk.sig;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Iterator, q1 {
    public int a;
    public final /* synthetic */ d b;

    public a(d dVar) {
        this.b = dVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.a();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        d dVar = this.b;
        int i = this.a;
        this.a = i + 1;
        return dVar.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
