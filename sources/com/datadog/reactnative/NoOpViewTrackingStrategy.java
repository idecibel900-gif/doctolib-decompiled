package com.datadog.reactnative;

import android.content.Context;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpViewTrackingStrategy implements ViewTrackingStrategy {
    public static final NoOpViewTrackingStrategy INSTANCE = new NoOpViewTrackingStrategy();

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
    }

    private NoOpViewTrackingStrategy() {
    }
}
