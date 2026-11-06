package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DeviceStorageDisclosures;
import io.didomi.ssl.models.VendorNamespaces;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u0004\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000\u001a\u001e\u0010\u0004\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0004\u001a\u00020\n*\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\f\u001a\u0012\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\f\u001a'\u0010\u0004\u001a\u0004\u0018\u00010\u0017*\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0015\"\u00020\f¢\u0006\u0004\b\u0004\u0010\u0018\u001a\u0018\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00000\u00192\u0006\u0010\u001a\u001a\u00020\f\u001a\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00000\u00192\u0006\u0010\u001a\u001a\u00020\f\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u001b*\b\u0012\u0004\u0012\u00020\u00000\u0019\u001a \u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u001a\"\u0010\u0002\u001a\u0004\u0018\u00010\u0000*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u001aD\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u0019\u001a\"\u0010\u0004\u001a\u0004\u0018\u00010\u0000*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00000\u000b2\u0006\u0010\t\u001a\u00020\u0000H\u0002¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/Vendor;", "", "b", "c", "a", "g", "e", "f", "d", "didomiVendor", "", "", "", "Lio/didomi/sdk/Purpose;", "availablePurposes", "h", "i", "Lio/didomi/sdk/models/DeviceStorageDisclosures;", "disclosures", "purposeId", "purposeIabId", "", "languages", "Lio/didomi/sdk/Vendor$b;", "(Lio/didomi/sdk/Vendor;[Ljava/lang/String;)Lio/didomi/sdk/Vendor$b;", "", DiagnosticsEntry.ID_KEY, "", "didomiVendors", "android_release"}, k = 2, mv = {1, 8, 0})
public final class yh {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "language", "Lio/didomi/sdk/Vendor$b;", "a", "(Ljava/lang/String;)Lio/didomi/sdk/Vendor$b;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function1 {
        final /* synthetic */ Vendor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Vendor vendor) {
            super(1);
            this.a = vendor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Vendor.Url invoke(String language) {
            Intrinsics.checkNotNullParameter(language, "language");
            List<Vendor.Url> urls = this.a.getUrls();
            Object obj = null;
            if (urls == null) {
                return null;
            }
            for (Object obj2 : urls) {
                if (Intrinsics.areEqual(((Vendor.Url) obj2).getLangId(), language)) {
                    obj = obj2;
                    break;
                }
            }
            return (Vendor.Url) obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/didomi/sdk/Vendor;", "firstVendor", "secondVendor", "", "a", "(Lio/didomi/sdk/Vendor;Lio/didomi/sdk/Vendor;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function2 {
        public static final b a = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(Vendor firstVendor, Vendor secondVendor) {
            Intrinsics.checkNotNullParameter(firstVendor, "firstVendor");
            Intrinsics.checkNotNullParameter(secondVendor, "secondVendor");
            return Integer.valueOf(StringsKt.compareTo(firstVendor.getName(), secondVendor.getName(), true));
        }
    }

    public static final boolean a(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return (vendor.getPurposeIds().isEmpty() && vendor.getLegIntPurposeIds().isEmpty() && vendor.getSpecialPurposeIds().isEmpty() && vendor.getEssentialPurposeIds().isEmpty() && vendor.getFeatureIds().isEmpty() && vendor.getSpecialFeatureIds().isEmpty()) ? false : true;
    }

    public static final boolean b(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return vendor.getPurposeIds().isEmpty() && vendor.getLegIntPurposeIds().isEmpty() && !vendor.getEssentialPurposeIds().isEmpty();
    }

    public static final boolean c(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return vendor.getPurposeIds().isEmpty() && vendor.getLegIntPurposeIds().isEmpty() && vendor.getEssentialPurposeIds().isEmpty();
    }

    private static final boolean d(Vendor vendor) {
        return !vendor.getPurposeIds().isEmpty();
    }

    public static final boolean e(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return Intrinsics.areEqual(vendor.getNamespace(), "didomi");
    }

    private static final boolean f(Vendor vendor) {
        return !vendor.getLegIntPurposeIds().isEmpty();
    }

    public static final boolean g(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return f(vendor) && !d(vendor);
    }

    public static final boolean h(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return vendor.getCookieMaxAgeSeconds() != null || vendor.getUsesNonCookieAccess();
    }

    public static final boolean i(Vendor vendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        return h(vendor) || vendor.getDeviceStorageDisclosureUrl() != null;
    }

    public static final boolean b(Vendor vendor, String purposeIabId) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        Intrinsics.checkNotNullParameter(purposeIabId, "purposeIabId");
        return vendor.getSpecialFeatureIds().contains(purposeIabId);
    }

    public static final Vendor b(Collection<Vendor> collection, String id) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            next = it.next();
            Vendor vendor = (Vendor) next;
            if (Intrinsics.areEqual(vendor.getId(), id) || (vendor.isIabVendor() && Intrinsics.areEqual(vendor.getIabId(), id))) {
                return (Vendor) next;
            }
        }
        next = null;
        return (Vendor) next;
    }

    public static final Vendor b(Map<String, Vendor> map, String str) {
        Object next;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Vendor vendor = map.get(str);
        if (vendor != null) {
            return vendor;
        }
        Iterator<T> it = map.values().iterator();
        while (it.hasNext()) {
            next = it.next();
            Vendor vendor2 = (Vendor) next;
            if (vendor2.isIabVendor() && Intrinsics.areEqual(vendor2.getIabId(), str)) {
                return (Vendor) next;
            }
        }
        next = null;
        return (Vendor) next;
    }

    public static final void a(Vendor vendor, Vendor didomiVendor) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        Intrinsics.checkNotNullParameter(didomiVendor, "didomiVendor");
        vendor.setIabId(vendor.getId());
        vendor.setId(didomiVendor.getId());
        vendor.setNamespace(didomiVendor.getNamespace());
        vendor.setNamespaces(didomiVendor.getNamespaces());
    }

    public static final void a(Vendor vendor, Map<String, Purpose> availablePurposes) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        Intrinsics.checkNotNullParameter(availablePurposes, "availablePurposes");
        List<String> purposeIds = vendor.getPurposeIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : purposeIds) {
            if (availablePurposes.containsKey((String) obj)) {
                arrayList.add(obj);
            }
        }
        vendor.setPurposeIds(CollectionsKt.toMutableList((Collection) arrayList));
        List<String> legIntPurposeIds = vendor.getLegIntPurposeIds();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : legIntPurposeIds) {
            if (availablePurposes.containsKey((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        vendor.setLegIntPurposeIds(CollectionsKt.toMutableList((Collection) arrayList2));
    }

    public static final void a(Vendor vendor, DeviceStorageDisclosures deviceStorageDisclosures) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        vendor.setDeviceStorageDisclosureComplete(true);
        vendor.setDeviceStorageDisclosures(deviceStorageDisclosures);
    }

    public static final boolean a(Vendor vendor, String purposeId) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        return vendor.getPurposeIds().contains(purposeId) || vendor.getLegIntPurposeIds().contains(purposeId) || vendor.getEssentialPurposeIds().contains(purposeId);
    }

    public static final Vendor.Url a(Vendor vendor, String... languages) {
        Intrinsics.checkNotNullParameter(vendor, "<this>");
        Intrinsics.checkNotNullParameter(languages, "languages");
        return (Vendor.Url) SequencesKt.firstOrNull(SequencesKt.mapNotNull(ArraysKt.asSequence(languages), new a(vendor)));
    }

    public static final boolean a(Collection<Vendor> collection, String id) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        return b(collection, id) != null;
    }

    public static final List<Vendor> a(Collection<Vendor> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        final b bVar = b.a;
        return CollectionsKt.sortedWith(collection, new Comparator() { // from class: io.didomi.sdk.yh$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return yh.a(bVar, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public static final boolean a(Map<String, Vendor> map, String str) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return b(map, str) != null;
    }

    public static final Map<String, Vendor> a(Map<String, Vendor> map, Map<String, Purpose> availablePurposes, Collection<Vendor> didomiVendors) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(availablePurposes, "availablePurposes");
        Intrinsics.checkNotNullParameter(didomiVendors, "didomiVendors");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Vendor vendor : didomiVendors) {
            Vendor vendorA = a(map, vendor);
            if (vendorA != null) {
                if (Intrinsics.areEqual(vendorA.getId(), vendor.getId()) && vendorA.getIabId() != null) {
                    String iabId = vendorA.getIabId();
                    Intrinsics.checkNotNull(iabId, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add(iabId);
                } else {
                    arrayList.add(vendorA.getId());
                    a(vendorA, vendor);
                }
                linkedHashMap.put(vendor.getId(), vendorA);
            } else {
                a(vendor, availablePurposes);
                linkedHashMap.put(vendor.getId(), vendor);
            }
        }
        for (Map.Entry<String, Vendor> entry : map.entrySet()) {
            String key = entry.getKey();
            Vendor value = entry.getValue();
            if (!arrayList.contains(key)) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    private static final Vendor a(Map<String, Vendor> map, Vendor vendor) {
        String iab2;
        VendorNamespaces namespaces = vendor.getNamespaces();
        if (namespaces == null || (iab2 = namespaces.getIab2()) == null) {
            return null;
        }
        Vendor vendorB = b(map, iab2);
        if (vendorB != null && vendorB.isIabVendor()) {
            return vendorB;
        }
        namespaces.setIab2(null);
        return null;
    }
}
