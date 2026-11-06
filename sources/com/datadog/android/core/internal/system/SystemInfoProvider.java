package com.datadog.android.core.internal.system;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface SystemInfoProvider {
    SystemInfo getLatestSystemInfo();

    void register(Context context);

    void unregister(Context context);
}
