package expo.modules.video.utils;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes5.dex */
public final class WeakMutableSet implements Set, KMutableSet {
    private final HashSet delegate = new HashSet();
    private final ReferenceQueue referenceQueue = new ReferenceQueue();

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.delegate.contains(new WeakElement(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        removeGarbageCollectedEntries();
        return this.delegate.add(new WeakElement(obj, this.referenceQueue));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove = this.delegate.remove(new WeakElement(obj));
        removeGarbageCollectedEntries();
        return zRemove;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (add(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        removeGarbageCollectedEntries();
        Iterator it = this.delegate.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return new AnonymousClass1(it);
    }

    /* JADX INFO: renamed from: expo.modules.video.utils.WeakMutableSet$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator, KMappedMarker {
        final /* synthetic */ Iterator $i;

        AnonymousClass1(Iterator it) {
            this.$i = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.$i.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            T t = ((WeakElement) this.$i.next()).get();
            if (t != 0) {
                return t;
            }
            throw new NoSuchElementException("The next element was garbage collected.");
        }

        @Override // java.util.Iterator
        public void remove() {
            this.$i.remove();
        }
    }

    private final void removeGarbageCollectedEntries() {
        while (true) {
            Reference referencePoll = this.referenceQueue.poll();
            WeakElement weakElement = referencePoll instanceof WeakElement ? (WeakElement) referencePoll : null;
            if (weakElement == null) {
                return;
            } else {
                TypeIntrinsics.asMutableCollection(this.delegate).remove(weakElement);
            }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList();
        for (Object obj : this) {
            if (!elements.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return removeAll(CollectionsKt.toSet(arrayList));
    }
}
