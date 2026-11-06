package com.revenuecat.purchases.utils.serializers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\u0018\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004*\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"toAny", "", "Lkotlinx/serialization/json/JsonElement;", "toAnyMap", "", "", "Lkotlinx/serialization/json/JsonObject;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JsonObjectToMapSerializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> toAnyMap(JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonObject.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object any = toAny((JsonElement) entry.getValue());
            Pair pair = any == null ? null : TuplesKt.to(str, any);
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object toAny(JsonElement jsonElement) {
        if (jsonElement instanceof JsonNull) {
            return null;
        }
        if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
            if (jsonPrimitive.isString()) {
                return jsonPrimitive.getContent();
            }
            if (JsonElementKt.getBooleanOrNull(jsonPrimitive) != null) {
                Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
                Intrinsics.checkNotNull(booleanOrNull);
                return booleanOrNull;
            }
            if (JsonElementKt.getIntOrNull(jsonPrimitive) != null) {
                Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
                Intrinsics.checkNotNull(intOrNull);
                return intOrNull;
            }
            if (JsonElementKt.getLongOrNull(jsonPrimitive) != null) {
                Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
                Intrinsics.checkNotNull(longOrNull);
                return longOrNull;
            }
            if (JsonElementKt.getDoubleOrNull(jsonPrimitive) == null) {
                return jsonPrimitive.getContent();
            }
            Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
            Intrinsics.checkNotNull(doubleOrNull);
            return doubleOrNull;
        }
        if (jsonElement instanceof JsonObject) {
            return toAnyMap((JsonObject) jsonElement);
        }
        if (jsonElement instanceof JsonArray) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Iterable) jsonElement).iterator();
            while (it.hasNext()) {
                Object any = toAny((JsonElement) it.next());
                if (any != null) {
                    arrayList.add(any);
                }
            }
            return arrayList;
        }
        throw new NoWhenBranchMatchedException();
    }
}
