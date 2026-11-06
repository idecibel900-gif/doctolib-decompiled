package com.datadog.android.log;

import com.datadog.android.event.EventMapper;
import com.datadog.android.event.NoOpEventMapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogsConfiguration {
    private final String customEndpointUrl;
    private final EventMapper eventMapper;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogsConfiguration)) {
            return false;
        }
        LogsConfiguration logsConfiguration = (LogsConfiguration) obj;
        return Intrinsics.areEqual(this.customEndpointUrl, logsConfiguration.customEndpointUrl) && Intrinsics.areEqual(this.eventMapper, logsConfiguration.eventMapper);
    }

    public int hashCode() {
        String str = this.customEndpointUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.eventMapper.hashCode();
    }

    public String toString() {
        return "LogsConfiguration(customEndpointUrl=" + this.customEndpointUrl + ", eventMapper=" + this.eventMapper + ")";
    }

    public LogsConfiguration(String str, EventMapper eventMapper) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        this.customEndpointUrl = str;
        this.eventMapper = eventMapper;
    }

    public final String getCustomEndpointUrl$dd_sdk_android_logs_release() {
        return this.customEndpointUrl;
    }

    public final EventMapper getEventMapper$dd_sdk_android_logs_release() {
        return this.eventMapper;
    }

    public static final class Builder {
        private String customEndpointUrl;
        private EventMapper logsEventMapper = new NoOpEventMapper();

        public final Builder useCustomEndpoint(String endpoint) {
            Intrinsics.checkNotNullParameter(endpoint, "endpoint");
            this.customEndpointUrl = endpoint;
            return this;
        }

        public final LogsConfiguration build() {
            return new LogsConfiguration(this.customEndpointUrl, this.logsEventMapper);
        }
    }
}
