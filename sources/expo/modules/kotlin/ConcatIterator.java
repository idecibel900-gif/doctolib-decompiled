package expo.modules.kotlin;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ConcatIterator implements Iterator, KMappedMarker {
    private final Iterator first;
    private final Iterator second;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ConcatIterator(Iterator first, Iterator second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        this.first = first;
        this.second = second;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.first.hasNext() || this.second.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.first.hasNext()) {
            return this.first.next();
        }
        return this.second.next();
    }
}
