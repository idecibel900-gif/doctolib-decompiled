package com.datadog.android.core.internal;

import com.datadog.android.api.context.DatadogContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ContextProvider {
    DatadogContext getContext();

    Map getFeatureContext(String str);

    void setFeatureContext(String str, Map map);
}
