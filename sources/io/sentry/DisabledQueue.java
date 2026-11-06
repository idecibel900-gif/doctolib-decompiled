package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
final class DisabledQueue extends AbstractCollection implements Queue, Serializable {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
    }

    @Override // java.util.Queue
    public Object element() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return false;
    }

    @Override // java.util.Queue
    public Object peek() {
        return null;
    }

    @Override // java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }

    @Override // java.util.Queue
    public Object remove() {
        throw new NoSuchElementException("queue is disabled");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: io.sentry.DisabledQueue.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new IllegalStateException();
            }
        };
    }
}
