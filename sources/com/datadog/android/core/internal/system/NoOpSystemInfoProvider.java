package com.datadog.android.core.internal.system;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpSystemInfoProvider implements SystemInfoProvider {
    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.core.internal.system.SystemInfoProvider
    public SystemInfo getLatestSystemInfo() {
        return new SystemInfo(false, 0, false, false, 15, null);
    }
}
