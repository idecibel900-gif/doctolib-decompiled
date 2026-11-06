package androidx.compose.ui.text.intl;

import com.amazon.a.a.o.b.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleList implements Collection, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final LocaleList Empty = new LocaleList(CollectionsKt.emptyList());
    private final List localeList;
    private final int size;

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
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate predicate) {
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
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.toArray(this, objArr);
    }

    public LocaleList(List list) {
        this.localeList = list;
        this.size = list.size();
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Locale) {
            return contains((Locale) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocaleList getEmpty() {
            return LocaleList.Empty;
        }

        public final LocaleList getCurrent() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent();
        }
    }

    public final List getLocaleList() {
        return this.localeList;
    }

    public LocaleList(String str) {
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{f.a}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(listSplit$default.size());
        int size = listSplit$default.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(StringsKt.trim((String) listSplit$default.get(i)).toString());
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList2.add(new Locale((String) arrayList.get(i2)));
        }
        this(arrayList2);
    }

    public final Locale get(int i) {
        return (Locale) this.localeList.get(i);
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(Locale locale) {
        return this.localeList.contains(locale);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.localeList.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.localeList.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.localeList.iterator();
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocaleList) && Intrinsics.areEqual(this.localeList, ((LocaleList) obj).localeList);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.localeList.hashCode();
    }

    public String toString() {
        return "LocaleList(localeList=" + this.localeList + ')';
    }
}
