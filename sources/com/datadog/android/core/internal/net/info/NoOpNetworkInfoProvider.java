package com.datadog.android.core.internal.net.info;

import android.content.Context;
import com.datadog.android.api.context.NetworkInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpNetworkInfoProvider implements NetworkInfoProvider {
    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public NetworkInfo getLatestNetworkInfo() {
        return new NetworkInfo(null, null, null, null, null, null, null, 127, null);
    }
}
