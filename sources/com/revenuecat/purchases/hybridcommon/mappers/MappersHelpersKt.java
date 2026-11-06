package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.utils.Iso8601Utils;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\f\u0012\u0004\u0012\u00020\u000f\u0012\u0002\b\u00030\u0015\u001a\u000e\u0010\u0016\u001a\u00020\u0017*\u0006\u0012\u0002\b\u00030\u0018\u001a\u0018\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0015*\u00020\u0014\u001a\f\u0010\u001a\u001a\u00020\u000f*\u00020\u001bH\u0000\u001a\f\u0010\u001c\u001a\u00020\u0012*\u00020\u001bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "mapperDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getMapperDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "mapperDispatcher$delegate", "Lkotlin/Lazy;", "overrideMapperDispatcher", "getOverrideMapperDispatcher", "setOverrideMapperDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "formatUsingDeviceLocale", "", "priceCurrencyCode", "number", "", "convertToJson", "Lorg/json/JSONObject;", "", "convertToJsonArray", "Lorg/json/JSONArray;", "", "convertToMap", "toIso8601", "Ljava/util/Date;", "toMillis", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MappersHelpersKt {
    private static CoroutineDispatcher overrideMapperDispatcher;
    private static final Lazy mapperDispatcher$delegate = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.hybridcommon.mappers.MappersHelpersKt$mapperDispatcher$2
        @Override // kotlin.jvm.functions.Function0
        public final CoroutineDispatcher invoke() {
            CoroutineDispatcher overrideMapperDispatcher2 = MappersHelpersKt.getOverrideMapperDispatcher();
            return overrideMapperDispatcher2 == null ? Dispatchers.getDefault() : overrideMapperDispatcher2;
        }
    });
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    public static final JSONObject convertToJson(Map<String, ?> map) throws JSONException {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                jSONObject.put(key, JSONObject.NULL);
            } else if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONObject.put(key, convertToJson((Map) value));
            } else if (value instanceof List) {
                jSONObject.put(key, convertToJsonArray((List) value));
            } else if (value instanceof Object[]) {
                jSONObject.put(key, convertToJsonArray(ArraysKt.toList((Object[]) value)));
            } else {
                jSONObject.put(key, value);
            }
        }
        return jSONObject;
    }

    public static final JSONArray convertToJsonArray(List<?> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                jSONArray.put(JSONObject.NULL);
            } else if (obj instanceof Map) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
                jSONArray.put(convertToJson((Map) obj));
            } else if (obj instanceof Object[]) {
                jSONArray.put(convertToJsonArray(ArraysKt.asList((Object[]) obj)));
            } else if (obj instanceof List) {
                jSONArray.put(convertToJsonArray((List) obj));
            } else {
                jSONArray.put(obj);
            }
        }
        return jSONArray;
    }

    public static final Map<String, String> convertToMap(JSONObject jSONObject) {
        Pair pair;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "this.keys()");
        Sequence<String> sequenceAsSequence = SequencesKt.asSequence(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : sequenceAsSequence) {
            if (jSONObject.isNull(str)) {
                pair = TuplesKt.to(str, null);
            } else {
                pair = TuplesKt.to(str, jSONObject.getString(str));
            }
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final CoroutineDispatcher getOverrideMapperDispatcher() {
        return overrideMapperDispatcher;
    }

    public static final void setOverrideMapperDispatcher(CoroutineDispatcher coroutineDispatcher) {
        overrideMapperDispatcher = coroutineDispatcher;
    }

    public static final CoroutineDispatcher getMapperDispatcher() {
        return (CoroutineDispatcher) mapperDispatcher$delegate.getValue();
    }

    public static final CoroutineScope getMainScope() {
        return mainScope;
    }

    public static final long toMillis(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return date.getTime();
    }

    public static final String toIso8601(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String str = Iso8601Utils.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(this)");
        return str;
    }

    public static final String formatUsingDeviceLocale(String priceCurrencyCode, long j) {
        Intrinsics.checkNotNullParameter(priceCurrencyCode, "priceCurrencyCode");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(priceCurrencyCode));
        String str = currencyInstance.format(j);
        Intrinsics.checkNotNullExpressionValue(str, "getCurrencyInstance().ap…ode)\n    }.format(number)");
        return str;
    }
}
