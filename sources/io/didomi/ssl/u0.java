package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.consent.model.ConsentStatus;
import io.didomi.ssl.consent.model.ConsentToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\b*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u001a\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e\u001a\u0014\u0010\u0004\u001a\u00020\b*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u001a\u0014\u0010\u0006\u001a\u00020\b*\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\n\u0010\u0011\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u0015\u001a\u00020\u0010*\u00020\u0000\u001a\u008a\u0001\u0010\t\u001a\u00020\u0010*\u00020\u00002\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0001\u001a\n\u0010\t\u001a\u00020\u0000*\u00020\u0000¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/consent/model/ConsentToken;", "", "", "h", "d", "f", "b", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/consent/model/ConsentStatus;", "a", "i", "e", "g", "c", "Lio/didomi/sdk/Vendor;", "vendor", "", "l", "j", "m", "n", "k", "Lio/didomi/sdk/Purpose;", "enabledPurposes", "disabledPurposes", "enabledLegitimatePurposes", "disabledLegitimatePurposes", "enabledVendors", "disabledVendors", "enabledLegIntVendors", "disabledLegIntVendors", "android_release"}, k = 2, mv = {1, 8, 0})
public final class u0 {
    public static final ConsentStatus a(ConsentToken consentToken, String str) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (consentToken.getEnabledLegitimatePurposes().containsKey(str)) {
            return ConsentStatus.ENABLE;
        }
        return consentToken.getDisabledLegitimatePurposes().containsKey(str) ? ConsentStatus.DISABLE : ConsentStatus.UNKNOWN;
    }

    public static final Set<String> b(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getDisabledLegitimatePurposes().keySet());
    }

    public static final Set<String> c(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getDisabledLegitimateVendors().keySet());
    }

    public static final Set<String> d(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getDisabledPurposes().keySet());
    }

    public static final Set<String> e(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getDisabledVendors().keySet());
    }

    public static final Set<String> f(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getEnabledLegitimatePurposes().keySet());
    }

    public static final Set<String> g(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getEnabledLegitimateVendors().keySet());
    }

    public static final Set<String> h(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getEnabledPurposes().keySet());
    }

    public static final Set<String> i(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return CollectionsKt.toSet(consentToken.getEnabledVendors().keySet());
    }

    public static final boolean j(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (k(consentToken)) {
            return (consentToken.getDisabledPurposes().isEmpty() && consentToken.getDisabledLegitimatePurposes().isEmpty() && consentToken.getDisabledVendors().isEmpty() && consentToken.getDisabledLegitimateVendors().isEmpty()) ? false : true;
        }
        return false;
    }

    public static final boolean k(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return (consentToken.getDisabledPurposes().isEmpty() && consentToken.getEnabledPurposes().isEmpty() && consentToken.getDisabledVendors().isEmpty() && consentToken.getEnabledVendors().isEmpty() && consentToken.getDisabledLegitimatePurposes().isEmpty() && consentToken.getEnabledLegitimatePurposes().isEmpty() && consentToken.getDisabledLegitimateVendors().isEmpty() && consentToken.getEnabledLegitimateVendors().isEmpty()) ? false : true;
    }

    public static final boolean l(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return !(consentToken.getDisabledPurposes().isEmpty() && consentToken.getDisabledVendors().isEmpty()) && consentToken.getEnabledPurposes().isEmpty() && consentToken.getEnabledVendors().isEmpty();
    }

    public static final boolean m(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return consentToken.getEnabledLegitimatePurposes().isEmpty() && consentToken.getDisabledLegitimatePurposes().isEmpty();
    }

    public static final boolean n(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        Collection<Purpose> collectionValues = consentToken.getEnabledPurposes().values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (ca.a((Purpose) it.next())) {
                    return false;
                }
            }
        }
        Collection<Purpose> collectionValues2 = consentToken.getDisabledPurposes().values();
        if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
            return true;
        }
        Iterator<T> it2 = collectionValues2.iterator();
        while (it2.hasNext()) {
            if (ca.a((Purpose) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static final ConsentStatus b(ConsentToken consentToken, String str) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (consentToken.getEnabledPurposes().containsKey(str)) {
            return ConsentStatus.ENABLE;
        }
        return consentToken.getDisabledPurposes().containsKey(str) ? ConsentStatus.DISABLE : ConsentStatus.UNKNOWN;
    }

    public static final ConsentStatus c(ConsentToken consentToken, String str) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (yh.a(consentToken.getEnabledVendors(), str)) {
            return ConsentStatus.ENABLE;
        }
        return yh.a(consentToken.getDisabledVendors(), str) ? ConsentStatus.DISABLE : ConsentStatus.UNKNOWN;
    }

    public static final ConsentStatus d(ConsentToken consentToken, String str) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (yh.a(consentToken.getEnabledLegitimateVendors(), str)) {
            return ConsentStatus.ENABLE;
        }
        return yh.a(consentToken.getDisabledLegitimateVendors(), str) ? ConsentStatus.DISABLE : ConsentStatus.UNKNOWN;
    }

    public static final ConsentStatus a(ConsentToken consentToken, Vendor vendor) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return c(consentToken, vendor.getId());
    }

    public static final boolean a(ConsentToken consentToken, Set<Purpose> set, Set<Purpose> set2, Set<Purpose> set3, Set<Purpose> set4, Set<Vendor> set5, Set<Vendor> set6, Set<Vendor> set7, Set<Vendor> set8) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        if (Intrinsics.areEqual(new HashSet(consentToken.getEnabledPurposes().values()), set) && Intrinsics.areEqual(new HashSet(consentToken.getDisabledPurposes().values()), set2) && Intrinsics.areEqual(new HashSet(consentToken.getEnabledLegitimatePurposes().values()), set3) && Intrinsics.areEqual(new HashSet(consentToken.getDisabledLegitimatePurposes().values()), set4) && Intrinsics.areEqual(new HashSet(consentToken.getEnabledVendors().values()), set5) && Intrinsics.areEqual(new HashSet(consentToken.getDisabledVendors().values()), set6) && Intrinsics.areEqual(new HashSet(consentToken.getEnabledLegitimateVendors().values()), set7) && Intrinsics.areEqual(new HashSet(consentToken.getDisabledLegitimateVendors().values()), set8)) {
            return false;
        }
        Map<String, Purpose> enabledPurposes = consentToken.getEnabledPurposes();
        enabledPurposes.clear();
        if (set != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            for (Purpose purpose : set) {
                arrayList.add(TuplesKt.to(purpose.getId(), purpose));
            }
            MapsKt.putAll(enabledPurposes, arrayList);
        }
        Map<String, Purpose> disabledPurposes = consentToken.getDisabledPurposes();
        disabledPurposes.clear();
        if (set2 != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
            for (Purpose purpose2 : set2) {
                arrayList2.add(TuplesKt.to(purpose2.getId(), purpose2));
            }
            MapsKt.putAll(disabledPurposes, arrayList2);
        }
        Map<String, Purpose> enabledLegitimatePurposes = consentToken.getEnabledLegitimatePurposes();
        enabledLegitimatePurposes.clear();
        if (set3 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set3, 10));
            for (Purpose purpose3 : set3) {
                arrayList3.add(TuplesKt.to(purpose3.getId(), purpose3));
            }
            MapsKt.putAll(enabledLegitimatePurposes, arrayList3);
        }
        Map<String, Purpose> disabledLegitimatePurposes = consentToken.getDisabledLegitimatePurposes();
        disabledLegitimatePurposes.clear();
        if (set4 != null) {
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set4, 10));
            for (Purpose purpose4 : set4) {
                arrayList4.add(TuplesKt.to(purpose4.getId(), purpose4));
            }
            MapsKt.putAll(disabledLegitimatePurposes, arrayList4);
        }
        Map<String, Vendor> enabledVendors = consentToken.getEnabledVendors();
        enabledVendors.clear();
        if (set5 != null) {
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set5, 10));
            for (Vendor vendor : set5) {
                arrayList5.add(TuplesKt.to(vendor.getId(), vendor));
            }
            MapsKt.putAll(enabledVendors, arrayList5);
        }
        Map<String, Vendor> disabledVendors = consentToken.getDisabledVendors();
        disabledVendors.clear();
        if (set6 != null) {
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set6, 10));
            for (Vendor vendor2 : set6) {
                arrayList6.add(TuplesKt.to(vendor2.getId(), vendor2));
            }
            MapsKt.putAll(disabledVendors, arrayList6);
        }
        Map<String, Vendor> enabledLegitimateVendors = consentToken.getEnabledLegitimateVendors();
        enabledLegitimateVendors.clear();
        if (set7 != null) {
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set7, 10));
            for (Vendor vendor3 : set7) {
                arrayList7.add(TuplesKt.to(vendor3.getId(), vendor3));
            }
            MapsKt.putAll(enabledLegitimateVendors, arrayList7);
        }
        Map<String, Vendor> disabledLegitimateVendors = consentToken.getDisabledLegitimateVendors();
        disabledLegitimateVendors.clear();
        if (set8 == null) {
            return true;
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set8, 10));
        for (Vendor vendor4 : set8) {
            arrayList8.add(TuplesKt.to(vendor4.getId(), vendor4));
        }
        MapsKt.putAll(disabledLegitimateVendors, arrayList8);
        return true;
    }

    public static final ConsentStatus b(ConsentToken consentToken, Vendor vendor) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return d(consentToken, vendor != null ? vendor.getId() : null);
    }

    public static final ConsentToken a(ConsentToken consentToken) {
        Intrinsics.checkNotNullParameter(consentToken, "<this>");
        return ConsentToken.copy$default(consentToken, null, null, null, null, MapsKt.toMutableMap(consentToken.getEnabledPurposes()), MapsKt.toMutableMap(consentToken.getDisabledPurposes()), MapsKt.toMutableMap(consentToken.getEnabledLegitimatePurposes()), MapsKt.toMutableMap(consentToken.getDisabledLegitimatePurposes()), MapsKt.toMutableMap(consentToken.getEnabledVendors()), MapsKt.toMutableMap(consentToken.getDisabledVendors()), MapsKt.toMutableMap(consentToken.getEnabledLegitimateVendors()), MapsKt.toMutableMap(consentToken.getDisabledLegitimateVendors()), 0, 4111, null);
    }
}
