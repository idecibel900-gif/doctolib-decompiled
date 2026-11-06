package com.datadog.android.core.internal;

import com.datadog.android.DatadogSite;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.DeviceInfo;
import com.datadog.android.api.context.DeviceType;
import com.datadog.android.api.context.LocaleInfo;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.ProcessInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.privacy.TrackingConsent;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpContextProvider implements ContextProvider {
    @Override // com.datadog.android.core.internal.ContextProvider
    public void setFeatureContext(String feature, Map context) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.ContextProvider
    public DatadogContext getContext() {
        return new DatadogContext(DatadogSite.US1, "", "", "", "", "", "", "", new TimeInfo(0L, 0L, 0L, 0L), new ProcessInfo(true), new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null), new DeviceInfo("", "", "", DeviceType.OTHER, "", "", "", "", "", null, new LocaleInfo(CollectionsKt.emptyList(), "", "")), new UserInfo(null, null, null, null, MapsKt.emptyMap()), null, TrackingConsent.NOT_GRANTED, null, MapsKt.emptyMap());
    }

    @Override // com.datadog.android.core.internal.ContextProvider
    public Map getFeatureContext(String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return MapsKt.emptyMap();
    }
}
