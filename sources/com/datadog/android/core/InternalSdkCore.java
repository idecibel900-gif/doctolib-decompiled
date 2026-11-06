package com.datadog.android.core;

import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface InternalSdkCore extends FeatureSdkCore {
    List getAllFeatures();

    long getAppStartTimeNs();

    DatadogContext getDatadogContext();

    FirstPartyHostHeaderTypeResolver getFirstPartyHostResolver();

    Long getLastFatalAnrSent();

    JsonObject getLastViewEvent();

    NetworkInfo getNetworkInfo();

    ExecutorService getPersistenceExecutorService();

    boolean isDeveloperModeEnabled();

    void writeLastFatalAnrSent(long j);

    void writeLastViewEvent(byte[] bArr);
}
