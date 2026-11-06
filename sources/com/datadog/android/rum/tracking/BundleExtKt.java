package com.datadog.android.rum.tracking;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BundleExtKt {
    public static final Map convertToRumViewAttributes(Bundle bundle) {
        if (bundle == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
        for (String str : setKeySet) {
            linkedHashMap.put("view.arguments." + str, bundle.get(str));
        }
        return linkedHashMap;
    }
}
