package com.datadog.android.core.internal.persistence.datastore;

import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.persistence.Serializer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpDataStoreHandler implements DataStoreHandler {
    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void clearAllData() {
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void removeValue(String key, DataStoreWriteCallback dataStoreWriteCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void setValue(String key, Object data, int i, DataStoreWriteCallback dataStoreWriteCallback, Serializer serializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void value(String key, Integer num, DataStoreReadCallback callback, Deserializer deserializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
    }
}
