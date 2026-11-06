package com.revenuecat.purchases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001H\u0000\u001a\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"replaceJsonNullWithKotlinNull", "", "T", "toList", "Lorg/json/JSONArray;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JSONArrayExtensionsKt {
    public static final <T> List<T> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object list = jSONArray.get(i);
            if (list instanceof JSONObject) {
                list = JSONObjectExtensionsKt.toMap((JSONObject) list, true);
            } else if (list instanceof JSONArray) {
                list = toList((JSONArray) list);
            }
            arrayList.add(list);
        }
        return arrayList;
    }

    public static final <T> List<T> replaceJsonNullWithKotlinNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            if (t instanceof Map) {
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.Map<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull, T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull?>");
                t = (T) JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull((Map) t);
            } else if (t instanceof List) {
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.collections.List<T of com.revenuecat.purchases.utils.JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull?>");
                t = (T) replaceJsonNullWithKotlinNull((List) t);
            } else if (Intrinsics.areEqual(t, JSONObject.NULL)) {
                t = (T) null;
            }
            arrayList.add(t);
        }
        return arrayList;
    }
}
