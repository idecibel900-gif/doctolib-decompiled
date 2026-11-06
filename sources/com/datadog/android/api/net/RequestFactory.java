package com.datadog.android.api.net;

import com.datadog.android.api.context.DatadogContext;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface RequestFactory {
    Request create(DatadogContext datadogContext, RequestExecutionContext requestExecutionContext, List list, byte[] bArr);
}
