package com.datadog.android.api.feature;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface Feature {
    String getName();

    void onInitialize(Context context);

    void onStop();
}
