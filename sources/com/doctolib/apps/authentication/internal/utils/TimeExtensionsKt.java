package com.doctolib.apps.authentication.internal.utils;

import j$.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TimeExtensionsKt {
    public static final String toIsoUtcString(long j) {
        String string = Instant.ofEpochMilli(j).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
