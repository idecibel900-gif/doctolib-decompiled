package com.datadog.android.core.persistence;

import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface PersistenceStrategy {

    public static final class Batch {
    }

    public interface Factory {
    }

    void dropAll();

    Batch lockAndReadNext();

    void migrateData(PersistenceStrategy persistenceStrategy);

    void unlockAndDelete(String str);

    void unlockAndKeep(String str);

    boolean write(RawBatchEvent rawBatchEvent, byte[] bArr, EventType eventType);
}
