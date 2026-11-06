package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MiscUtilsKt {
    public static final boolean retryWithDelay(int i, long j, InternalLogger internalLogger, Function0 block) {
        InternalLogger internalLogger2 = internalLogger;
        Intrinsics.checkNotNullParameter(internalLogger2, "internalLogger");
        Intrinsics.checkNotNullParameter(block, "block");
        long jNanoTime = System.nanoTime() - j;
        int i2 = 1;
        boolean zBooleanValue = false;
        while (i2 <= i && !zBooleanValue) {
            if (System.nanoTime() - jNanoTime >= j) {
                try {
                    zBooleanValue = ((Boolean) block.invoke()).booleanValue();
                } catch (Exception e) {
                    InternalLogger.DefaultImpls.log$default(internalLogger2, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.MiscUtilsKt.retryWithDelay.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Internal I/O operation failed";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                    zBooleanValue = false;
                }
                jNanoTime = System.nanoTime();
                i2++;
            }
            internalLogger2 = internalLogger;
        }
        return zBooleanValue;
    }

    public static final JsonElement toJsonArray(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        JsonArray jsonArray = new JsonArray();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            jsonArray.add(JsonSerializer.INSTANCE.toJsonElement(it.next()));
        }
        return jsonArray;
    }

    public static final JsonElement toJsonObject(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry entry : map.entrySet()) {
            jsonObject.add(String.valueOf(entry.getKey()), JsonSerializer.INSTANCE.toJsonElement(entry.getValue()));
        }
        return jsonObject;
    }

    public static final JsonElement toJsonObject(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        JsonObject jsonObject = new JsonObject();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jsonObject.add(next, JsonSerializer.INSTANCE.toJsonElement(jSONObject.get(next)));
        }
        return jsonObject;
    }

    public static final JsonElement toJsonArray(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        JsonArray jsonArray = new JsonArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            jsonArray.add(JsonSerializer.INSTANCE.toJsonElement(jSONArray.get(i)));
        }
        return jsonArray;
    }
}
