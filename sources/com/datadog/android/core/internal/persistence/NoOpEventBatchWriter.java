package com.datadog.android.core.internal.persistence;

import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpEventBatchWriter implements EventBatchWriter {
    @Override // com.datadog.android.api.storage.EventBatchWriter
    public boolean write(RawBatchEvent event, byte[] bArr, EventType eventType) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return true;
    }
}
