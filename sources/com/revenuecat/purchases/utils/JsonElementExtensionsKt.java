package com.revenuecat.purchases.utils;

import java.util.ArrayList;
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
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006*\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"extractedContent", "", "Lkotlinx/serialization/json/JsonElement;", "getExtractedContent", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "asMap", "", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonElementExtensionsKt {
    public static final Map<String, Object> asMap(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private static final Object getExtractedContent(JsonElement jsonElement) {
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement);
            if (jsonPrimitive.isString()) {
                return jsonPrimitive.getContent();
            }
            Object booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
            return (booleanOrNull == null && (booleanOrNull = JsonElementKt.getIntOrNull(jsonPrimitive)) == null && (booleanOrNull = JsonElementKt.getLongOrNull(jsonPrimitive)) == null && (booleanOrNull = JsonElementKt.getFloatOrNull(jsonPrimitive)) == null && (booleanOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive)) == null) ? JsonElementKt.getContentOrNull(jsonPrimitive) : booleanOrNull;
        }
        if (jsonElement instanceof JsonArray) {
            JsonArray jsonArray = JsonElementKt.getJsonArray(jsonElement);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonArray, 10));
            Iterator<JsonElement> it = jsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(getExtractedContent(it.next()));
            }
            return arrayList;
        }
        if (!(jsonElement instanceof JsonObject)) {
            return null;
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = JsonElementKt.getJsonObject(jsonElement).entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Pair pair = TuplesKt.to(entry.getKey(), getExtractedContent((JsonElement) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
