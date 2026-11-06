package com.datadog.android.internal.attributes;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalAttributeKt {
    public static final Map enrichWithConstantAttribute(Map map, LocalAttribute$Constant attribute) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        return enrichWithLocalAttribute(map, attribute.getKey(), attribute);
    }

    public static final Map enrichWithNonNullAttribute(Map map, LocalAttribute$Key key, Object obj) {
        Map mapEnrichWithLocalAttribute;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return (obj == null || (mapEnrichWithLocalAttribute = enrichWithLocalAttribute(map, key, obj)) == null) ? map : mapEnrichWithLocalAttribute;
    }

    public static final Map enrichWithLocalAttribute(Map map, LocalAttribute$Key key, Object obj) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        map.put(key.toString(), obj);
        return map;
    }
}
