package com.datadog.android.trace.internal.domain.event;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.trace.model.SpanEvent;
import com.datadog.trace.core.DDSpan;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CoreTracerSpanToSpanEventMapper extends BaseSpanEventMapper {
    public static final Companion Companion = new Companion(null);
    private final boolean networkInfoEnabled;

    @Override // com.datadog.android.trace.internal.domain.event.ContextAwareMapper
    public /* bridge */ /* synthetic */ Object map(DatadogContext datadogContext, Object obj) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        return map(datadogContext, (DDSpan) null);
    }

    public CoreTracerSpanToSpanEventMapper(boolean z) {
        this.networkInfoEnabled = z;
    }

    public SpanEvent map(DatadogContext datadogContext, DDSpan model) {
        Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
        Intrinsics.checkNotNullParameter(model, "model");
        datadogContext.getTime().getServerTimeOffsetNs();
        resolveMetrics(model);
        resolveMeta(datadogContext, model);
        throw null;
    }

    private final SpanEvent.Metrics resolveMetrics(DDSpan dDSpan) {
        resolveMetricsFromSpanContext(dDSpan);
        throw null;
    }

    private final SpanEvent.Meta resolveMeta(DatadogContext datadogContext, DDSpan dDSpan) {
        resolveDeviceInfo(datadogContext.getDeviceInfo());
        resolveOsInfo(datadogContext.getDeviceInfo());
        if (this.networkInfoEnabled) {
            resolveNetworkInfo(datadogContext.getNetworkInfo());
        }
        UserInfo userInfo = datadogContext.getUserInfo();
        datadogContext.getAccountInfo();
        new SpanEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), MapsKt.toMutableMap(userInfo.getAdditionalProperties()));
        datadogContext.getSource();
        throw null;
    }

    private final Map resolveMetricsFromSpanContext(DDSpan dDSpan) {
        throw null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
