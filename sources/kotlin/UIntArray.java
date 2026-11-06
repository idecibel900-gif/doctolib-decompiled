package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class UIntArray implements Collection, KMappedMarker {
    private final int[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m5280boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m5282constructorimpl(int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5285equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m5294unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5288hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5292toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m5285equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m5288hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return m5292toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m5294unboximpl() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m5293containsWZ4Q5Ns(((UInt) obj).m5279unboximpl());
        }
        return false;
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m5281constructorimpl(int i) {
        return m5282constructorimpl(new int[i]);
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m5286getpVg5ArA(int[] iArr, int i) {
        return UInt.m5275constructorimpl(iArr[i]);
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m5291setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m5287getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m5287getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator m5290iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return m5290iteratorimpl(this.storage);
    }

    private static final class Iterator implements java.util.Iterator, KMappedMarker {
        private final int[] array;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return UInt.m5274boximpl(m5295nextpVg5ArA());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
        public int m5295nextpVg5ArA() {
            int i = this.index;
            int[] iArr = this.array;
            if (i >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return UInt.m5275constructorimpl(iArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m5293containsWZ4Q5Ns(int i) {
        return m5283containsWZ4Q5Ns(this.storage, i);
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m5283containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt.contains(iArr, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m5284containsAllimpl(this.storage, elements);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m5284containsAllimpl(int[] iArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UInt) || !ArraysKt.contains(iArr, ((UInt) obj).m5279unboximpl())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m5289isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m5289isEmptyimpl(this.storage);
    }
}
