package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
final class CircularFifoQueue extends AbstractCollection implements Queue, Serializable {
    private transient Object[] elements;
    private final int maxElements;
    private transient int start = 0;
    private transient int end = 0;
    private transient boolean full = false;

    CircularFifoQueue(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        Object[] objArr = new Object[i];
        this.elements = objArr;
        this.maxElements = objArr.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.end;
        int i2 = this.start;
        if (i < i2) {
            return (this.maxElements - i2) + i;
        }
        if (i != i2) {
            return i - i2;
        }
        if (this.full) {
            return this.maxElements;
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isAtFullCapacity() {
        return size() == this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (isAtFullCapacity()) {
            remove();
        }
        Object[] objArr = this.elements;
        int i = this.end;
        int i2 = i + 1;
        this.end = i2;
        objArr[i] = obj;
        if (i2 >= this.maxElements) {
            this.end = 0;
        }
        if (this.end == this.start) {
            this.full = true;
        }
        return true;
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return add(obj);
    }

    @Override // java.util.Queue
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.Queue
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[this.start];
    }

    @Override // java.util.Queue
    public Object remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Object[] objArr = this.elements;
        int i = this.start;
        Object obj = objArr[i];
        if (obj != null) {
            int i2 = i + 1;
            this.start = i2;
            objArr[i] = null;
            if (i2 >= this.maxElements) {
                this.start = 0;
            }
            this.full = false;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.maxElements) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.maxElements - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: io.sentry.CircularFifoQueue.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = CircularFifoQueue.this.start;
                this.isFirst = CircularFifoQueue.this.full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != CircularFifoQueue.this.end;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.isFirst = false;
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = CircularFifoQueue.this.increment(i);
                return CircularFifoQueue.this.elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i != -1) {
                    if (i == CircularFifoQueue.this.start) {
                        CircularFifoQueue.this.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int iIncrement = this.lastReturnedIndex + 1;
                    if (CircularFifoQueue.this.start >= this.lastReturnedIndex || iIncrement >= CircularFifoQueue.this.end) {
                        while (iIncrement != CircularFifoQueue.this.end) {
                            if (iIncrement >= CircularFifoQueue.this.maxElements) {
                                CircularFifoQueue.this.elements[iIncrement - 1] = CircularFifoQueue.this.elements[0];
                                iIncrement = 0;
                            } else {
                                CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(iIncrement)] = CircularFifoQueue.this.elements[iIncrement];
                                iIncrement = CircularFifoQueue.this.increment(iIncrement);
                            }
                        }
                    } else {
                        System.arraycopy(CircularFifoQueue.this.elements, iIncrement, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - iIncrement);
                    }
                    this.lastReturnedIndex = -1;
                    CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                    circularFifoQueue.end = circularFifoQueue.decrement(circularFifoQueue.end);
                    CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
                    CircularFifoQueue.this.full = false;
                    this.index = CircularFifoQueue.this.decrement(this.index);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
