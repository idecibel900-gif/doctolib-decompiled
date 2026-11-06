package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class ULongArray implements Collection, KMappedMarker {
    private final long[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULongArray m5303boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m5305constructorimpl(long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5308equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).m5317unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5311hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5315toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
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
        return m5308equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m5311hashCodeimpl(this.storage);
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
        return m5315toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long[] m5317unboximpl() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m5316containsVKZWuLQ(((ULong) obj).m5302unboximpl());
        }
        return false;
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m5304constructorimpl(int i) {
        return m5305constructorimpl(new long[i]);
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public static final long m5309getsVKNKU(long[] jArr, int i) {
        return ULong.m5297constructorimpl(jArr[i]);
    }

    /* JADX INFO: renamed from: set-k8EXiF4, reason: not valid java name */
    public static final void m5314setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m5310getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m5310getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator m5313iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return m5313iteratorimpl(this.storage);
    }

    private static final class Iterator implements java.util.Iterator, KMappedMarker {
        private final long[] array;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return ULong.m5296boximpl(m5318nextsVKNKU());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-s-VKNKU, reason: not valid java name */
        public long m5318nextsVKNKU() {
            int i = this.index;
            long[] jArr = this.array;
            if (i >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return ULong.m5297constructorimpl(jArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m5316containsVKZWuLQ(long j) {
        return m5306containsVKZWuLQ(this.storage, j);
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public static boolean m5306containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt.contains(jArr, j);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m5307containsAllimpl(this.storage, elements);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m5307containsAllimpl(long[] jArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof ULong) || !ArraysKt.contains(jArr, ((ULong) obj).m5302unboximpl())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m5312isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m5312isEmptyimpl(this.storage);
    }
}
