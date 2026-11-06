package com.datadog.android.internal.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThrowableExtKt {
    public static final String loggableStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringWriter.toString()");
        return string;
    }
}
