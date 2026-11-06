package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.Window;
import com.datadog.android.api.SdkCore;

/* JADX INFO: loaded from: classes3.dex */
public interface GesturesTracker {
    void startTracking(Window window, Context context, SdkCore sdkCore);

    void stopTracking(Window window, Context context);
}
