package com.datadog.android.rum.tracking;

import android.content.Context;
import com.datadog.android.api.SdkCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpTrackingStrategy implements TrackingStrategy {
    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
    }
}
