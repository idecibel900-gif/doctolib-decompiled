package io.sentry.cache.tape;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
final class EmptyObjectQueue extends ObjectQueue {
    @Override // io.sentry.cache.tape.ObjectQueue
    public void add(Object obj) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public void remove(int i) {
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public int size() {
        return 0;
    }

    EmptyObjectQueue() {
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new EmptyIterator();
    }

    private static final class EmptyIterator implements Iterator {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException("No elements in EmptyIterator!");
        }
    }
}
