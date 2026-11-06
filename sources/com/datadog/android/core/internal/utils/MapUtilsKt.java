package com.datadog.android.core.internal.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MapUtilsKt {
    public static final Map toMutableMap(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return MapsKt.toMap(iterable, new LinkedHashMap());
    }
}
