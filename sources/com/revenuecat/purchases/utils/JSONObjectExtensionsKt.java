package com.revenuecat.purchases.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a4\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u0011\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013*\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u0011H\u0000\u001a(\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00150\u0011\"\u0004\b\u0000\u0010\u0015*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"copy", "Lorg/json/JSONObject;", "deep", "", "getDate", "Ljava/util/Date;", "jsonKey", "", "getNullableInt", "", "name", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "getNullableString", "optDate", "optNullableInt", "optNullableString", "replaceJsonNullWithKotlinNull", "", "K", "V", "toMap", "T", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JSONObjectExtensionsKt {
    public static final Date getDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        Date date = Iso8601Utils.parse(jSONObject.getString(jsonKey));
        Intrinsics.checkNotNullExpressionValue(date, "parse(getString(jsonKey))");
        return date;
    }

    public static final Date optDate(JSONObject jSONObject, String jsonKey) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jsonKey, "jsonKey");
        if (jSONObject.isNull(jsonKey)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getDate(jSONObject, jsonKey);
        }
        return null;
    }

    public static final String getNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (jSONObject.isNull(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject.getString(name);
        }
        return null;
    }

    public static final Integer getNullableInt(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (jSONObject.isNull(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return Integer.valueOf(jSONObject.getInt(name));
        }
        return null;
    }

    public static final String optNullableString(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableString(jSONObject, name);
        }
        return null;
    }

    public static final Integer optNullableInt(JSONObject jSONObject, String name) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!jSONObject.has(name)) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return getNullableInt(jSONObject, name);
        }
        return null;
    }

    public static /* synthetic */ Map toMap$default(JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toMap(jSONObject, z);
    }

    public static final <T> Map<String, T> toMap(final JSONObject jSONObject, final boolean z) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "this.keys()");
        return MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(itKeys), new Function1() { // from class: com.revenuecat.purchases.utils.JSONObjectExtensionsKt.toMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<String, T> invoke(String str) throws JSONException {
                if (z) {
                    Object list = jSONObject.get(str);
                    if (list instanceof JSONObject) {
                        list = JSONObjectExtensionsKt.toMap((JSONObject) list, true);
                    } else if (list instanceof JSONArray) {
                        list = JSONArrayExtensionsKt.toList((JSONArray) list);
                    }
                    return TuplesKt.to(str, list);
                }
                return TuplesKt.to(str, jSONObject.get(str));
            }
        }));
    }

    public static /* synthetic */ JSONObject copy$default(JSONObject jSONObject, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return copy(jSONObject, z);
    }

    public static final JSONObject copy(JSONObject jSONObject, boolean z) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return new JSONObject(toMap(jSONObject, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> replaceJsonNullWithKotlinNull(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<K of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull, V of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull?>");
                value = replaceJsonNullWithKotlinNull((Map) value);
            } else if (value instanceof List) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<V of com.revenuecat.purchases.utils.JSONObjectExtensionsKt.replaceJsonNullWithKotlinNull?>");
                value = JSONArrayExtensionsKt.replaceJsonNullWithKotlinNull((List) value);
            } else if (Intrinsics.areEqual(value, JSONObject.NULL)) {
                value = null;
            }
            linkedHashMap.put(key, value);
        }
        return linkedHashMap;
    }
}
