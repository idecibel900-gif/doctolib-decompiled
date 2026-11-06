package com.datadog.android.core.internal.system;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAppVersionProvider implements AppVersionProvider {
    private final AtomicReference value;

    public DefaultAppVersionProvider(String initialVersion) {
        Intrinsics.checkNotNullParameter(initialVersion, "initialVersion");
        this.value = new AtomicReference(initialVersion);
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public String getVersion() {
        Object obj = this.value.get();
        Intrinsics.checkNotNullExpressionValue(obj, "value.get()");
        return (String) obj;
    }

    @Override // com.datadog.android.core.internal.system.AppVersionProvider
    public void setVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value.set(value);
    }
}
