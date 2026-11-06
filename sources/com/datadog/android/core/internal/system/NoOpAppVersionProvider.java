package com.datadog.android.core.internal.system;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpAppVersionProvider implements AppVersionProvider {
    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public void setVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public String getVersion() {
        return "";
    }
}
