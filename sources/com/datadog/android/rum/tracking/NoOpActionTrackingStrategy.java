package com.datadog.android.rum.tracking;

import android.content.Context;
import android.view.View;
import com.datadog.android.api.SdkCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpActionTrackingStrategy implements ActionTrackingStrategy {
    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForScroll(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        return null;
    }

    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForTap(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        return null;
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
    }
}
