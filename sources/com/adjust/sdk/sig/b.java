package com.adjust.sdk.sig;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends a implements ListIterator {
    public final /* synthetic */ d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i) {
        super(dVar);
        this.c = dVar;
        int iA = dVar.a();
        if (i >= 0 && i <= iA) {
            this.a = i;
            return;
        }
        throw new IndexOutOfBoundsException("index: " + i + ", size: " + iA);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        d dVar = this.c;
        int i = this.a - 1;
        this.a = i;
        return dVar.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
