package com.datadog.android.api.storage.datastore;

import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.persistence.Serializer;

/* JADX INFO: loaded from: classes3.dex */
public interface DataStoreHandler {
    void clearAllData();

    void removeValue(String str, DataStoreWriteCallback dataStoreWriteCallback);

    void setValue(String str, Object obj, int i, DataStoreWriteCallback dataStoreWriteCallback, Serializer serializer);

    void value(String str, Integer num, DataStoreReadCallback dataStoreReadCallback, Deserializer deserializer);

    public static final class DefaultImpls {
        public static /* synthetic */ void removeValue$default(DataStoreHandler dataStoreHandler, String str, DataStoreWriteCallback dataStoreWriteCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeValue");
            }
            if ((i & 2) != 0) {
                dataStoreWriteCallback = null;
            }
            dataStoreHandler.removeValue(str, dataStoreWriteCallback);
        }
    }
}
