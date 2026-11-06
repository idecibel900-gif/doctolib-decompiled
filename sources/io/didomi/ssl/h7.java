package io.didomi.ssl;

import io.didomi.ssl.models.VendorNamespaces;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0003\u001a\f\u0010\u0002\u001a\u00020\u0006*\u00020\u0005H\u0002\u001a\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004*\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002\u001a\f\u0010\u0002\u001a\u00020\b*\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lio/didomi/sdk/g7;", "Lio/didomi/sdk/Vendor;", "a", "", "", "Lio/didomi/sdk/g7$a;", "Lio/didomi/sdk/Vendor$a;", "Lio/didomi/sdk/g7$b;", "Lio/didomi/sdk/Vendor$b;", "b", "android_release"}, k = 2, mv = {1, 8, 0})
public final class h7 {
    public static final Vendor a(InternalVendor internalVendor) {
        Intrinsics.checkNotNullParameter(internalVendor, "<this>");
        String id = internalVendor.getId();
        String str = id == null ? "" : id;
        String iabId = internalVendor.getIabId();
        String name = internalVendor.getName();
        if (name == null) {
            name = "";
        }
        String string = StringsKt.trim(name).toString();
        String privacyPolicyUrl = internalVendor.getPrivacyPolicyUrl();
        String namespace = internalVendor.getNamespace();
        String str2 = namespace == null ? "" : namespace;
        VendorNamespaces namespaces = internalVendor.getNamespaces();
        List<String> listO = internalVendor.o();
        if (listO == null) {
            listO = CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt.toMutableList((Collection) listO);
        List<String> listG = internalVendor.g();
        if (listG == null) {
            listG = CollectionsKt.emptyList();
        }
        List<String> list = listG;
        List<String> listQ = internalVendor.q();
        if (listQ == null) {
            listQ = CollectionsKt.emptyList();
        }
        List<String> list2 = listQ;
        List<String> listJ = internalVendor.j();
        if (listJ == null) {
            listJ = CollectionsKt.emptyList();
        }
        List mutableList2 = CollectionsKt.toMutableList((Collection) listJ);
        List<String> listF = internalVendor.f();
        if (listF == null) {
            listF = CollectionsKt.emptyList();
        }
        List<String> list3 = listF;
        List<String> listP = internalVendor.p();
        if (listP == null) {
            listP = CollectionsKt.emptyList();
        }
        List<String> list4 = listP;
        Long cookieMaxAgeSeconds = internalVendor.getCookieMaxAgeSeconds();
        boolean zAreEqual = Intrinsics.areEqual(internalVendor.getUsesNonCookieAccess(), Boolean.TRUE);
        String deviceStorageDisclosureUrl = internalVendor.getDeviceStorageDisclosureUrl();
        Set<String> setB = internalVendor.b();
        InternalVendor.DataRetention dataRetention = internalVendor.getDataRetention();
        Vendor.DataRetention dataRetentionA = dataRetention != null ? a(dataRetention) : null;
        List<InternalVendor.Url> listR = internalVendor.r();
        List<Vendor.Url> listB = listR != null ? b(listR) : null;
        List<String> listE = internalVendor.e();
        if (listE == null) {
            listE = CollectionsKt.emptyList();
        }
        return new Vendor(str, string, privacyPolicyUrl, str2, namespaces, mutableList, mutableList2, iabId, list, list2, list3, list4, cookieMaxAgeSeconds, zAreEqual, deviceStorageDisclosureUrl, setB, dataRetentionA, listB, CollectionsKt.toMutableList((Collection) listE), null, 524288, null);
    }

    private static final List<Vendor.Url> b(Collection<InternalVendor.Url> collection) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a((InternalVendor.Url) it.next()));
        }
        return arrayList;
    }

    private static final Vendor.DataRetention a(InternalVendor.DataRetention dataRetention) {
        return new Vendor.DataRetention(dataRetention.getStdRetention(), dataRetention.a(), dataRetention.b());
    }

    private static final Vendor.Url a(InternalVendor.Url url) {
        return new Vendor.Url(url.getLangId(), url.getPrivacy(), url.getLegIntClaim());
    }

    public static final List<Vendor> a(Collection<InternalVendor> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(a((InternalVendor) it.next()));
        }
        return arrayList;
    }
}
