package com.datadog.android.api.storage;

/* JADX INFO: loaded from: classes3.dex */
public interface EventBatchWriter {
    boolean write(RawBatchEvent rawBatchEvent, byte[] bArr, EventType eventType);
}
