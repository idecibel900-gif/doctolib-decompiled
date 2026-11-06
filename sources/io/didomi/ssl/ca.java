package io.didomi.ssl;

import io.didomi.ssl.models.SpecialFeature;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0003\u001a\u001a\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00000\u00072\u0006\u0010\u0006\u001a\u00020\u0000\u001a\u0010\u0010\u0002\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00000\t\u001a2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f*\b\u0012\u0004\u0012\u00020\u00000\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u000b2\u0006\u0010\u000e\u001a\u00020\r\u001a0\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u000b*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/Purpose;", "", "a", "", "", "", "purpose", "", "b", "", "", "", "availablePurposes", "Lio/didomi/sdk/Vendor;", "vendor", "", "Lio/didomi/sdk/models/SpecialFeature;", "specialFeatures", "android_release"}, k = 2, mv = {1, 8, 0})
public final class ca {

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            String name = ((Purpose) t).getName();
            Normalizer.Form form = Normalizer.Form.NFD;
            return ComparisonsKt.compareValues(Normalizer.normalize(name, form), Normalizer.normalize(((Purpose) t2).getName(), form));
        }
    }

    public static final boolean a(Purpose purpose) {
        Intrinsics.checkNotNullParameter(purpose, "<this>");
        return Intrinsics.areEqual(purpose.getType$android_release(), Purpose.personalDataType);
    }

    public static final boolean b(Collection<Purpose> collection, Purpose purpose) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Iterator<T> it = collection.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Purpose) next).getId(), purpose.getId()));
        Purpose purpose2 = (Purpose) next;
        if (purpose2 != null) {
            return collection.remove(purpose2);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x002c A[RETURN] */
    public static final boolean a(Collection<Purpose> collection, Purpose purpose) {
        Object obj;
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        do {
            obj = null;
            if (it.hasNext()) {
                next = it.next();
            }
            if (obj != null) {
                return true;
            }
            return false;
        } while (!Intrinsics.areEqual(((Purpose) next).getId(), purpose != null ? purpose.getId() : null));
        obj = next;
        if (obj != null) {
            return true;
        }
        return false;
    }

    public static final Set<Purpose> a(Collection<Purpose> collection, Map<String, Purpose> availablePurposes, Vendor vendor) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(availablePurposes, "availablePurposes");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Set<Purpose> mutableSet = CollectionsKt.toMutableSet(collection);
        for (String str : vendor.getSpecialFeatureIds()) {
            for (Purpose purpose : availablePurposes.values()) {
                if (Intrinsics.areEqual(purpose.getIabId(), str)) {
                    purpose.setConsent(true);
                    mutableSet.add(purpose);
                }
            }
        }
        return mutableSet;
    }

    public static final Set<String> a(Collection<Purpose> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((Purpose) it.next()).getId());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public static final void a(List<Purpose> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new a());
        }
    }

    public static final Map<String, Purpose> a(Map<String, Purpose> map, Collection<SpecialFeature> specialFeatures) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(specialFeatures, "specialFeatures");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(specialFeatures, 10)), 16));
        for (SpecialFeature specialFeature : specialFeatures) {
            Pair pair = TuplesKt.to(specialFeature.getId(), ec.a(specialFeature));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return MapsKt.plus(map, linkedHashMap);
    }
}
