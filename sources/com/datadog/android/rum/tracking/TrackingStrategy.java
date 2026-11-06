package com.datadog.android.rum.tracking;

import android.content.Context;
import com.datadog.android.api.SdkCore;

/* JADX INFO: loaded from: classes3.dex */
public interface TrackingStrategy {
    void register(SdkCore sdkCore, Context context);

    void unregister(Context context);
}
