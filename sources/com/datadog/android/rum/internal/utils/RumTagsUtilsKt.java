package com.datadog.android.rum.internal.utils;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.context.DatadogContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RumTagsUtilsKt {
    public static final String buildDDTagsString(DatadogContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder();
        sb.append("service:" + context.getService());
        sb.append(f.a);
        sb.append("version:" + context.getVersion());
        sb.append(f.a);
        sb.append("sdk_version:" + context.getSdkVersion());
        sb.append(f.a);
        sb.append("env:" + context.getEnv());
        if (context.getVariant().length() > 0) {
            sb.append(f.a);
            sb.append("variant:" + context.getVariant());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
