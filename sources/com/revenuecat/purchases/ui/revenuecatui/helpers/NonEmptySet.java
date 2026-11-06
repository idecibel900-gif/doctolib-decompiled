package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.opentok.android.PublisherKit;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0096\u0003J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0012\u0010\f\u001a\u00020\rX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "A", "", "head", "rest", "", "(Ljava/lang/Object;Ljava/lang/Iterable;)V", "all", "(Ljava/lang/Object;Ljava/util/Set;)V", "getHead", "()Ljava/lang/Object;", "Ljava/lang/Object;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "isEmpty", "iterator", "", "toSet", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonEmptySet<A> implements Set<A>, KMappedMarker {
    public static final int $stable = 8;
    private final Set<A> all;
    private final A head;

    @Override // java.util.Set, java.util.Collection
    public boolean add(A a) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends A> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return this.all.contains(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.all.containsAll(elements);
    }

    public int getSize() {
        return this.all.size();
    }

    @Override // java.util.Set, java.util.Collection
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<A> iterator() {
        return this.all.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptySet(A a, Set<? extends A> set) {
        this.head = a;
        this.all = set;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* synthetic */ Object getHead() {
        return this.head;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptySet(A a, Iterable<? extends A> rest) {
        this((Object) a, SetsKt.plus(CollectionsKt.toSet(rest), a));
        Intrinsics.checkNotNullParameter(rest, "rest");
    }

    /* JADX INFO: renamed from: toSet, reason: from getter */
    public final /* synthetic */ Set getAll() {
        return this.all;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object other) {
        return other instanceof NonEmptySet ? Intrinsics.areEqual(this.all, ((NonEmptySet) other).all) : Intrinsics.areEqual(this.all, other);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.all.hashCode();
    }

    public String toString() {
        return "NonEmptySet(" + CollectionsKt.joinToString$default(this.all, null, null, null, 0, null, null, 63, null) + ')';
    }
}
