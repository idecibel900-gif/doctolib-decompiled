package com.revenuecat.purchases.ui.revenuecatui.helpers;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B/\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\u0007B/\b\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0002\u0010\nJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00028\u0001H\u0096\u0001¢\u0006\u0002\u0010 J\u0013\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0018\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J>\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010+2\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u0002H+0-H\u0086\bø\u0001\u0000J>\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H+0\u0000\"\u0004\b\u0002\u0010+2\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u0002H+0-H\u0086\bø\u0001\u0000J\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J\b\u00100\u001a\u000201H\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "K", "V", "", "entry", "Lkotlin/Pair;", "tail", "(Lkotlin/Pair;Ljava/util/Map;)V", "", "all", "(Ljava/util/Map$Entry;Ljava/util/Map;)V", "entries", "", "getEntries", "()Ljava/util/Set;", "getEntry", "()Ljava/util/Map$Entry;", "keys", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "getKeys", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", b.au, "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "isEmpty", "mapKeys", "R", "transform", "Lkotlin/Function1;", "mapValues", "toMap", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonEmptyMap<K, V> implements Map<K, V>, KMappedMarker {
    public static final int $stable = 8;
    private final Map<K, V> all;
    private final Map.Entry<K, V> entry;
    private final NonEmptySet<K> keys;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.all.containsKey(key);
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.all.containsValue(value);
    }

    @Override // java.util.Map
    public V get(Object key) {
        return this.all.get(key);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.all.entrySet();
    }

    public int getSize() {
        return this.all.size();
    }

    public Collection<V> getValues() {
        return this.all.values();
    }

    @Override // java.util.Map
    public /* synthetic */ boolean isEmpty() {
        return false;
    }

    @Override // java.util.Map
    public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V putIfAbsent(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V replace(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(K k, V v, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NonEmptyMap(Map.Entry<? extends K, ? extends V> entry, Map<K, ? extends V> map) {
        this.entry = entry;
        this.all = map;
        this.keys = new NonEmptySet<>(entry.getKey(), (Iterable<? extends Object>) map.keySet());
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ NonEmptySet<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final /* synthetic */ Map.Entry getEntry() {
        return this.entry;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NonEmptyMap(Pair<? extends K, ? extends V> entry, Map<K, ? extends V> tail) {
        this((Map.Entry) CollectionsKt.first(MapsKt.mapOf(entry).entrySet()), MapsKt.plus(tail, entry));
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(tail, "tail");
    }

    public NonEmptySet<K> getKeys() {
        return this.keys;
    }

    /* JADX INFO: renamed from: toMap, reason: from getter */
    public final /* synthetic */ Map getAll() {
        return this.all;
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (!(other instanceof NonEmptyMap)) {
            return Intrinsics.areEqual(this.all, other);
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) other;
        return Intrinsics.areEqual(this.entry, nonEmptyMap.entry) && Intrinsics.areEqual(this.all, nonEmptyMap.all);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.all.hashCode();
    }

    public String toString() {
        return "NonEmptyMap(" + CollectionsKt.joinToString$default(this.all.entrySet(), null, null, null, 0, null, null, 63, null) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> NonEmptyMap<K, R> mapValues(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Map map = this.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), transform.invoke(obj));
        }
        return NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(getEntry().getKey(), MapsKt.getValue(linkedHashMap, getEntry().getKey())), linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> NonEmptyMap<R, V> mapKeys(Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Object objInvoke = transform.invoke(getEntry());
        Map map = this.all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Intrinsics.areEqual(entry.getKey(), getEntry().getKey()) ? objInvoke : transform.invoke(entry), entry.getValue());
        }
        return NonEmptyMapKt.nonEmptyMapOf(TuplesKt.to(objInvoke, MapsKt.getValue(linkedHashMap, objInvoke)), linkedHashMap);
    }
}
