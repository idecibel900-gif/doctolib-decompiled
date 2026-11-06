package com.swmansion.enriched.markdown.utils.common;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReadableMapExtensionsKt {
    public static final boolean getBooleanOrDefault(ReadableMap readableMap, String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (readableMap == null || !readableMap.hasKey(key)) ? z : readableMap.getBoolean(key);
    }

    public static final String getStringOrDefault(ReadableMap readableMap, String key, String str) {
        String string;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        return (readableMap == null || !readableMap.hasKey(key) || (string = readableMap.getString(key)) == null) ? str : string;
    }

    public static final ReadableMap getMapOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap == null || !readableMap.hasKey(key)) {
            return null;
        }
        return readableMap.getMap(key);
    }

    public static final ReadableArray getArrayOrNull(ReadableMap readableMap, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (readableMap == null || !readableMap.hasKey(key)) {
            return null;
        }
        return readableMap.getArray(key);
    }
}
