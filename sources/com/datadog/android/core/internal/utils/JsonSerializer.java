package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JsonSerializer {
    public static final JsonSerializer INSTANCE = new JsonSerializer();

    private JsonSerializer() {
    }

    public final JsonElement toJsonElement(Object obj) {
        if (Intrinsics.areEqual(obj, com.datadog.android.internal.utils.MapUtilsKt.getNULL_MAP_VALUE())) {
            JsonNull INSTANCE2 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
            return INSTANCE2;
        }
        if (obj == null) {
            JsonNull INSTANCE3 = JsonNull.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(INSTANCE3, "INSTANCE");
            return INSTANCE3;
        }
        JsonNull INSTANCE4 = JsonNull.INSTANCE;
        if (Intrinsics.areEqual(obj, INSTANCE4)) {
            Intrinsics.checkNotNullExpressionValue(INSTANCE4, "INSTANCE");
            return INSTANCE4;
        }
        if (obj instanceof Boolean) {
            return new JsonPrimitive((Boolean) obj);
        }
        if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double)) {
            if (obj instanceof String) {
                return new JsonPrimitive((String) obj);
            }
            if (obj instanceof Date) {
                return new JsonPrimitive(Long.valueOf(((Date) obj).getTime()));
            }
            if (obj instanceof JsonArray) {
                return (JsonElement) obj;
            }
            if (obj instanceof Iterable) {
                return MiscUtilsKt.toJsonArray((Iterable) obj);
            }
            if (obj instanceof Map) {
                return MiscUtilsKt.toJsonObject((Map) obj);
            }
            if (!(obj instanceof JsonObject) && !(obj instanceof JsonPrimitive)) {
                if (obj instanceof JSONObject) {
                    return MiscUtilsKt.toJsonObject((JSONObject) obj);
                }
                return obj instanceof JSONArray ? MiscUtilsKt.toJsonArray((JSONArray) obj) : new JsonPrimitive(obj.toString());
            }
            return (JsonElement) obj;
        }
        return new JsonPrimitive((Number) obj);
    }

    public final Map safeMapValuesToJson(Map map, InternalLogger internalLogger) {
        InternalLogger internalLogger2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (final Map.Entry entry : map.entrySet()) {
            try {
                Pair pair = TuplesKt.to(entry.getKey(), INSTANCE.toJsonElement(entry.getValue()));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
                internalLogger2 = internalLogger;
            } catch (Exception e) {
                internalLogger2 = internalLogger;
                InternalLogger.DefaultImpls.log$default(internalLogger2, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.utils.JsonSerializer$safeMapValuesToJson$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String str = String.format(Locale.US, "Error serializing value for key %s, value was dropped.", Arrays.copyOf(new Object[]{entry.getKey()}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        return str;
                    }
                }, (Throwable) e, false, (Map) null, 48, (Object) null);
            }
            internalLogger = internalLogger2;
        }
        return linkedHashMap;
    }
}
