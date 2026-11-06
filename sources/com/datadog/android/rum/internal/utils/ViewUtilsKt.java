package com.datadog.android.rum.internal.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewUtilsKt {
    public static final String resolveViewUrl(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        if (obj instanceof String) {
            return (String) obj;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName == null) {
            canonicalName = obj.getClass().getSimpleName();
        }
        Intrinsics.checkNotNullExpressionValue(canonicalName, "javaClass.canonicalName ?: javaClass.simpleName");
        return canonicalName;
    }
}
