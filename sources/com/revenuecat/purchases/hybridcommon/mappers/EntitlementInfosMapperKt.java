package com.revenuecat.purchases.hybridcommon.mappers;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfos;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EntitlementInfosMapperKt {
    public static final Map<String, Object> map(EntitlementInfos entitlementInfos) {
        Intrinsics.checkNotNullParameter(entitlementInfos, "<this>");
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet = entitlementInfos.getAll().entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Pair pair2 = TuplesKt.to("all", linkedHashMap);
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet2 = entitlementInfos.getActive().entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet2, 10)), 16));
        Iterator<T> it2 = setEntrySet2.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Pair pair3 = TuplesKt.to(entry2.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry2.getValue()));
            linkedHashMap2.put(pair3.getFirst(), pair3.getSecond());
        }
        return MapsKt.mapOf(pair2, TuplesKt.to(AppStateModule.APP_STATE_ACTIVE, linkedHashMap2), TuplesKt.to("verification", entitlementInfos.getVerification().name()));
    }
}
