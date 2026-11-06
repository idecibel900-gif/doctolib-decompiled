package com.datadog.android.api.storage;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpDataWriter implements DataWriter {
    @Override // com.datadog.android.api.storage.DataWriter
    public boolean write(EventBatchWriter writer, Object obj, EventType eventType) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return false;
    }
}
