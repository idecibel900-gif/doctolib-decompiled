package com.datadog.android.internal.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StringBuilderExtKt {
    public static final StringBuilder appendIfNotEmpty(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (sb.length() > 0) {
            sb.append(c);
        }
        return sb;
    }
}
