package kotlinx.serialization.json;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.opentok.android.PublisherKit;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001!B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0096\u0003J\u0017\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0011\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0006H\u0096\u0003J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0096\u0001J\t\u0010\u0016\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0096\u0003J\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001H\u0096\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0096\u0001J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0096\u0001J\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0096\u0001J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", b.au, "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonArray extends JsonElement implements List<JsonElement>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List content;

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends JsonElement> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.content.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.content.containsAll(elements);
    }

    @Override // java.util.List
    public JsonElement get(int index) {
        return (JsonElement) this.content.get(index);
    }

    public int getSize() {
        return this.content.size();
    }

    public int indexOf(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.content.indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.content.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.content.iterator();
    }

    public int lastIndexOf(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.content.lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<JsonElement> listIterator() {
        return this.content.listIterator();
    }

    @Override // java.util.List
    public ListIterator<JsonElement> listIterator(int index) {
        return this.content.listIterator(index);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ JsonElement remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<JsonElement> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ JsonElement set(int i, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super JsonElement> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<JsonElement> subList(int fromIndex, int toIndex) {
        return this.content.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return JsonArraySerializer.INSTANCE;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof JsonElement) {
            return contains((JsonElement) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof JsonElement) {
            return indexOf((JsonElement) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof JsonElement) {
            return lastIndexOf((JsonElement) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonArray(List content) {
        super(null);
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        return Intrinsics.areEqual(this.content, other);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.content, f.a, "[", "]", 0, null, null, 56, null);
    }
}
