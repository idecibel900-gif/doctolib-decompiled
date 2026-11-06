package com.datadog.reactnative;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalState {
    public static final GlobalState INSTANCE = new GlobalState();
    private static final Map globalAttributes = new ConcurrentHashMap();

    private GlobalState() {
    }

    public final Map getGlobalAttributes$datadog_mobile_react_native_release() {
        return globalAttributes;
    }

    public static final void addAttribute(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj == null) {
            globalAttributes.remove(key);
        } else {
            globalAttributes.put(key, obj);
        }
    }
}
