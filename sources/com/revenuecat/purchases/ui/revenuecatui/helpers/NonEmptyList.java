package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001eJ&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0002¢\u0006\u0004\b)\u0010\fJ\u000f\u0010*\u001a\u00020\u0011H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J-\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010/2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0004\b2\u00103J3\u00105\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010/2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000104¢\u0006\u0004\b5\u00106R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00107R\u0014\u00109\u001a\u00020\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010+R\u0011\u0010\u0006\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "A", "", "all", "<init>", "(Ljava/util/List;)V", "head", "tail", "(Ljava/lang/Object;Ljava/util/List;)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "index", b.au, "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "toList", "()Ljava/util/List;", "isEmpty", "()Z", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "B", "Lkotlin/Function1;", "transform", "map", "(Lkotlin/jvm/functions/Function1;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lkotlin/Function2;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Ljava/util/List;", "getSize", "size", "getHead", "()Ljava/lang/Object;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonEmptyList<A> implements List<A>, KMappedMarker {
    public static final int $stable = 8;
    private final List<A> all;

    @Override // java.util.List
    public void add(int i, A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return this.all.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.all.containsAll(elements);
    }

    @Override // java.util.List
    public A get(int index) {
        return this.all.get(index);
    }

    public int getSize() {
        return this.all.size();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return this.all.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<A> iterator() {
        return this.all.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return this.all.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<A> listIterator() {
        return this.all.listIterator();
    }

    @Override // java.util.List
    public ListIterator<A> listIterator(int index) {
        return this.all.listIterator(index);
    }

    @Override // java.util.List
    public A remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public A removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<A> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public A set(int i, A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super A> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<A> subList(int fromIndex, int toIndex) {
        return this.all.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptyList(List<? extends A> list) {
        this.all = list;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptyList(A a, List<? extends A> tail) {
        this(CollectionsKt.plus((Collection) CollectionsKt.listOf(a), (Iterable) tail));
        Intrinsics.checkNotNullParameter(tail, "tail");
    }

    /* JADX INFO: renamed from: toList, reason: from getter */
    public final /* synthetic */ List getAll() {
        return this.all;
    }

    public final /* synthetic */ Object getHead() {
        return CollectionsKt.first((List) this.all);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        return other instanceof NonEmptyList ? Intrinsics.areEqual(this.all, ((NonEmptyList) other).all) : Intrinsics.areEqual(this.all, other);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.all.hashCode();
    }

    public String toString() {
        return "NonEmptyList(" + CollectionsKt.joinToString$default(this.all, null, null, null, 0, null, null, 63, null) + ')';
    }

    public final /* synthetic */ NonEmptyList map(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return new NonEmptyList(arrayList);
    }

    public final /* synthetic */ NonEmptyList mapIndexed(Function2 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        List<A> list = this.all;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(transform.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return new NonEmptyList(arrayList);
    }
}
