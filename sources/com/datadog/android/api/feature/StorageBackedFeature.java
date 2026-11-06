package com.datadog.android.api.feature;

import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.FeatureStorageConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public interface StorageBackedFeature extends Feature {
    RequestFactory getRequestFactory();

    FeatureStorageConfiguration getStorageConfiguration();
}
