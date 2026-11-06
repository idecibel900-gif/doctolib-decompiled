package expo.modules.kotlin;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class FilteredIterator implements Iterator, KMappedMarker {
    private final Filter filter;
    private final Iterator iterator;
    private Object next;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public FilteredIterator(Iterator iterator, Filter filter) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.iterator = iterator;
        this.filter = filter;
        findNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.next;
        Intrinsics.checkNotNull(obj);
        findNext();
        return obj;
    }

    private final void findNext() {
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            this.next = next;
            if (this.filter.apply(next)) {
                return;
            }
        }
        this.next = null;
    }
}
