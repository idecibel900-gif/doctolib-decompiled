package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.internal.utils.NumberExtKt;
import com.datadog.android.trace.model.SpanEvent;
import com.datadog.opentracing.DDSpan;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DdSpanToSpanEventMapper extends BaseSpanEventMapper {
    private final BigIntegerUtils bigIntegerUtils;
    private final boolean networkInfoEnabled;

    public /* synthetic */ DdSpanToSpanEventMapper(boolean z, BigIntegerUtils bigIntegerUtils, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? BigIntegerUtils.INSTANCE : bigIntegerUtils);
    }

    public DdSpanToSpanEventMapper(boolean z, BigIntegerUtils bigIntegerUtils) {
        Intrinsics.checkNotNullParameter(bigIntegerUtils, "bigIntegerUtils");
        this.networkInfoEnabled = z;
        this.bigIntegerUtils = bigIntegerUtils;
    }

    @Override // com.datadog.android.trace.internal.domain.event.ContextAwareMapper
    public SpanEvent map(DatadogContext datadogContext, DDSpan model) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(model, "model");
        long serverTimeOffsetNs = datadogContext.getTime().getServerTimeOffsetNs();
        SpanEvent.Metrics metricsResolveMetrics = resolveMetrics(model);
        SpanEvent.Meta metaResolveMeta = resolveMeta(datadogContext, model);
        BigIntegerUtils bigIntegerUtils = this.bigIntegerUtils;
        BigInteger traceId = model.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "model.traceId");
        String strLeastSignificant64BitsAsHex = bigIntegerUtils.leastSignificant64BitsAsHex(traceId);
        BigInteger spanId = model.getSpanId();
        Intrinsics.checkNotNullExpressionValue(spanId, "model.spanId");
        String hexString = NumberExtKt.toHexString(spanId);
        BigInteger parentId = model.getParentId();
        Intrinsics.checkNotNullExpressionValue(parentId, "model.parentId");
        String hexString2 = NumberExtKt.toHexString(parentId);
        String resourceName = model.getResourceName();
        String operationName = model.getOperationName();
        String serviceName = model.getServiceName();
        long durationNano = model.getDurationNano();
        long startTime = model.getStartTime() + serverTimeOffsetNs;
        Boolean boolIsError = model.isError();
        Intrinsics.checkNotNullExpressionValue(boolIsError, "model.isError");
        long j = boolIsError.booleanValue() ? 1L : 0L;
        Intrinsics.checkNotNullExpressionValue(resourceName, "resourceName");
        Intrinsics.checkNotNullExpressionValue(operationName, "operationName");
        Intrinsics.checkNotNullExpressionValue(serviceName, "serviceName");
        return new SpanEvent(strLeastSignificant64BitsAsHex, hexString, hexString2, resourceName, operationName, serviceName, durationNano, startTime, j, metricsResolveMetrics, metaResolveMeta);
    }

    private final SpanEvent.Metrics resolveMetrics(DDSpan dDSpan) {
        Long l = dDSpan.getParentId().longValue() == 0 ? 1L : null;
        Map metrics = dDSpan.getMetrics();
        Intrinsics.checkNotNullExpressionValue(metrics, "event.metrics");
        return new SpanEvent.Metrics(l, metrics);
    }

    private final SpanEvent.Meta resolveMeta(DatadogContext datadogContext, DDSpan dDSpan) {
        SpanEvent.Application application;
        SpanEvent.Session session;
        SpanEvent.View view = null;
        SpanEvent.Network networkResolveNetworkInfo = this.networkInfoEnabled ? resolveNetworkInfo(datadogContext.getNetworkInfo()) : null;
        SpanEvent.Device deviceResolveDeviceInfo = resolveDeviceInfo(datadogContext.getDeviceInfo());
        SpanEvent.Os osResolveOsInfo = resolveOsInfo(datadogContext.getDeviceInfo());
        UserInfo userInfo = datadogContext.getUserInfo();
        datadogContext.getAccountInfo();
        BigIntegerUtils bigIntegerUtils = this.bigIntegerUtils;
        BigInteger traceId = dDSpan.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "event.traceId");
        String strMostSignificant64BitsAsHex = bigIntegerUtils.mostSignificant64BitsAsHex(traceId);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("_dd.p.id", strMostSignificant64BitsAsHex);
        linkedHashMap.put("variant", datadogContext.getVariant());
        Map meta = dDSpan.getMeta();
        Intrinsics.checkNotNullExpressionValue(meta, "event.meta");
        linkedHashMap.putAll(meta);
        SpanEvent.Usr usrResolveUserInfo = resolveUserInfo(userInfo);
        String source = datadogContext.getSource();
        Object obj = dDSpan.getTags().get("application_id");
        if (obj != null) {
            application = new SpanEvent.Application(obj instanceof String ? (String) obj : null);
        } else {
            application = null;
        }
        Object obj2 = dDSpan.getTags().get("session_id");
        if (obj2 != null) {
            session = new SpanEvent.Session(obj2 instanceof String ? (String) obj2 : null);
        } else {
            session = null;
        }
        Object obj3 = dDSpan.getTags().get("view.id");
        if (obj3 != null) {
            view = new SpanEvent.View(obj3 instanceof String ? (String) obj3 : null);
        }
        return new SpanEvent.Meta(datadogContext.getVersion(), new SpanEvent.Dd(source, application, session, view), new SpanEvent.Span(), new SpanEvent.Tracer(datadogContext.getSdkVersion()), usrResolveUserInfo, null, networkResolveNetworkInfo, deviceResolveDeviceInfo, osResolveOsInfo, linkedHashMap);
    }
}
