package com.datadog.android.core.persistence;

import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpPersistenceStrategy implements PersistenceStrategy {
    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void dropAll() {
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public PersistenceStrategy.Batch lockAndReadNext() {
        return null;
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void migrateData(PersistenceStrategy targetStrategy) {
        Intrinsics.checkNotNullParameter(targetStrategy, "targetStrategy");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void unlockAndDelete(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public void unlockAndKeep(String batchId) {
        Intrinsics.checkNotNullParameter(batchId, "batchId");
    }

    @Override // com.datadog.android.core.persistence.PersistenceStrategy
    public boolean write(RawBatchEvent event, byte[] bArr, EventType eventType) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return false;
    }
}
