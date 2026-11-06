package com.datadog.android.api.storage.datastore;

import com.datadog.android.core.persistence.datastore.DataStoreContent;

/* JADX INFO: loaded from: classes3.dex */
public interface DataStoreReadCallback {
    void onFailure();

    void onSuccess(DataStoreContent dataStoreContent);
}
