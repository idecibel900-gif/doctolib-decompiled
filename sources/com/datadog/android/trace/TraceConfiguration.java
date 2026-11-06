package com.datadog.android.trace;

import com.datadog.android.trace.event.NoOpSpanEventMapper;
import com.datadog.android.trace.event.SpanEventMapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TraceConfiguration {
    private final String customEndpointUrl;
    private final SpanEventMapper eventMapper;
    private final boolean networkInfoEnabled;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TraceConfiguration)) {
            return false;
        }
        TraceConfiguration traceConfiguration = (TraceConfiguration) obj;
        return Intrinsics.areEqual(this.customEndpointUrl, traceConfiguration.customEndpointUrl) && Intrinsics.areEqual(this.eventMapper, traceConfiguration.eventMapper) && this.networkInfoEnabled == traceConfiguration.networkInfoEnabled;
    }

    public int hashCode() {
        String str = this.customEndpointUrl;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.eventMapper.hashCode()) * 31) + Boolean.hashCode(this.networkInfoEnabled);
    }

    public String toString() {
        return "TraceConfiguration(customEndpointUrl=" + this.customEndpointUrl + ", eventMapper=" + this.eventMapper + ", networkInfoEnabled=" + this.networkInfoEnabled + ")";
    }

    public TraceConfiguration(String str, SpanEventMapper eventMapper, boolean z) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.customEndpointUrl = str;
        this.eventMapper = eventMapper;
        this.networkInfoEnabled = z;
    }

    public final String getCustomEndpointUrl$dd_sdk_android_trace_release() {
        return this.customEndpointUrl;
    }

    public final SpanEventMapper getEventMapper$dd_sdk_android_trace_release() {
        return this.eventMapper;
    }

    public final boolean getNetworkInfoEnabled$dd_sdk_android_trace_release() {
        return this.networkInfoEnabled;
    }

    public static final class Builder {
        private String customEndpointUrl;
        private SpanEventMapper spanEventMapper = new NoOpSpanEventMapper();
        private boolean networkInfoEnabled = true;

        public final Builder useCustomEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customEndpointUrl = endpoint;
            return this;
        }

        public final TraceConfiguration build() {
            return new TraceConfiguration(this.customEndpointUrl, this.spanEventMapper, this.networkInfoEnabled);
        }
    }
}
