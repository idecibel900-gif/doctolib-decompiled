package com.datadog.android.rum.metric.networksettled;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpInitialResourceIdentifier implements InitialResourceIdentifier {
    @Override // com.datadog.android.rum.metric.networksettled.InitialResourceIdentifier
    public boolean validate(NetworkSettledResourceContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }
}
