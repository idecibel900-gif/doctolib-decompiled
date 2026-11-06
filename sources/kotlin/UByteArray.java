package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class UByteArray implements Collection, KMappedMarker {
    private final byte[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByteArray m5258boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m5260constructorimpl(byte[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5263equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).m5272unboximpl());
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5266hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5270toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
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
        return m5263equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m5266hashCodeimpl(this.storage);
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
        return m5270toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte[] m5272unboximpl() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m5271contains7apg3OU(((UByte) obj).m5257unboximpl());
        }
        return false;
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.storage = bArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m5259constructorimpl(int i) {
        return m5260constructorimpl(new byte[i]);
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m5264getw2LRezQ(byte[] bArr, int i) {
        return UByte.m5253constructorimpl(bArr[i]);
    }

    /* JADX INFO: renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m5269setVurrAj0(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m5265getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m5265getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator m5268iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator iterator() {
        return m5268iteratorimpl(this.storage);
    }

    private static final class Iterator implements java.util.Iterator, KMappedMarker {
        private final byte[] array;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return UByte.m5252boximpl(m5273nextw2LRezQ());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-w2LRezQ, reason: not valid java name */
        public byte m5273nextw2LRezQ() {
            int i = this.index;
            byte[] bArr = this.array;
            if (i >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return UByte.m5253constructorimpl(bArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m5271contains7apg3OU(byte b) {
        return m5261contains7apg3OU(this.storage, b);
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m5261contains7apg3OU(byte[] bArr, byte b) {
        return ArraysKt.contains(bArr, b);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m5262containsAllimpl(this.storage, elements);
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m5262containsAllimpl(byte[] bArr, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UByte) || !ArraysKt.contains(bArr, ((UByte) obj).m5257unboximpl())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m5267isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m5267isEmptyimpl(this.storage);
    }
}
