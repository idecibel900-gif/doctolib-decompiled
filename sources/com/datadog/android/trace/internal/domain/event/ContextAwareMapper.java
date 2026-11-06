package com.datadog.android.trace.internal.domain.event;

import com.datadog.android.api.context.DatadogContext;

/* JADX INFO: loaded from: classes3.dex */
public interface ContextAwareMapper {
    Object map(DatadogContext datadogContext, Object obj);
}
