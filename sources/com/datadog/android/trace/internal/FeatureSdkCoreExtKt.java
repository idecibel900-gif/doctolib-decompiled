package com.datadog.android.trace.internal;

import com.datadog.android.api.feature.FeatureSdkCore;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FeatureSdkCoreExtKt {
    public static final void addActiveTraceToContext(FeatureSdkCore featureSdkCore, final String traceId, final String spanId) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(spanId, "spanId");
        final String strResolveActiveTraceContextName = resolveActiveTraceContextName();
        featureSdkCore.updateFeatureContext("tracing", new Function1() { // from class: com.datadog.android.trace.internal.FeatureSdkCoreExtKt.addActiveTraceToContext.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.put(strResolveActiveTraceContextName, MapsKt.mapOf(TuplesKt.to("span_id", spanId), TuplesKt.to("trace_id", traceId)));
            }
        });
    }

    public static final void removeActiveTraceFromContext(FeatureSdkCore featureSdkCore) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        final String strResolveActiveTraceContextName = resolveActiveTraceContextName();
        featureSdkCore.updateFeatureContext("tracing", new Function1() { // from class: com.datadog.android.trace.internal.FeatureSdkCoreExtKt.removeActiveTraceFromContext.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.remove(strResolveActiveTraceContextName);
            }
        });
    }

    private static final String resolveActiveTraceContextName() {
        return "context@" + Thread.currentThread().getName();
    }
}
