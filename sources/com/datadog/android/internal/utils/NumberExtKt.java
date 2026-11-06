package com.datadog.android.internal.utils;

import java.math.BigInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NumberExtKt {
    public static final String toHexString(int i) {
        String string = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toHexString(long j) {
        String string = Long.toString(j, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final String toHexString(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        return toHexString(bigInteger.longValue());
    }
}
