package com.datadog.android.trace.internal.utils;

import com.datadog.opentracing.DDSpanContext;
import io.opentracing.SpanContext;
import java.math.BigInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SpanContextExtKt {
    public static final String traceIdAsHexString(SpanContext spanContext) {
        BigInteger traceId;
        String string;
        String strPadStart;
        Intrinsics.checkNotNullParameter(spanContext, "<this>");
        DDSpanContext dDSpanContext = spanContext instanceof DDSpanContext ? (DDSpanContext) spanContext : null;
        return (dDSpanContext == null || (traceId = dDSpanContext.getTraceId()) == null || (string = traceId.toString(16)) == null || (strPadStart = StringsKt.padStart(string, 32, '0')) == null) ? "" : strPadStart;
    }
}
