package com.datadog.android.trace.internal.storage;

import com.datadog.android.api.context.DatadogContext;

/* JADX INFO: loaded from: classes3.dex */
public interface ContextAwareSerializer {
    String serialize(DatadogContext datadogContext, Object obj);
}
