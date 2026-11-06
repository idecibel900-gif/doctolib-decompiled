package com.datadog.android.core.internal.net.info;

import android.content.Context;
import com.datadog.android.api.context.NetworkInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface NetworkInfoProvider {
    NetworkInfo getLatestNetworkInfo();

    void register(Context context);

    void unregister(Context context);
}
