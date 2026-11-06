package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
final class MutableSetWrapper extends SetWrapper implements Set, KMutableSet {
    private final MutableScatterSet parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSetWrapper(MutableScatterSet parent) {
        super(parent);
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.parent = parent;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.parent.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.parent.addAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.parent.clear();
    }

    /* JADX INFO: renamed from: androidx.collection.MutableSetWrapper$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        private int current = -1;
        private final Iterator iterator;

        AnonymousClass1() {
            this.iterator = SequencesKt.iterator(new MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper.this, this, null));
        }

        public final void setCurrent(int i) {
            this.current = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current != -1) {
                MutableSetWrapper.this.parent.removeElementAt(this.current);
                this.current = -1;
            }
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.parent.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.parent.retainAll(elements);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.parent.removeAll(elements);
    }
}
