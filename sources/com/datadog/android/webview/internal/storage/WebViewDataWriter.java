package com.datadog.android.webview.internal.storage;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewDataWriter implements DataWriter {
    private final InternalLogger internalLogger;
    private final Serializer serializer;

    public WebViewDataWriter(Serializer serializer, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.serializer = serializer;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.api.storage.DataWriter
    public boolean write(EventBatchWriter writer, JsonObject element, EventType eventType) {
        boolean zWrite;
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.serializer, element, this.internalLogger);
        if (bArrSerializeToByteArray == null) {
            return false;
        }
        synchronized (this) {
            zWrite = writer.write(new RawBatchEvent(bArrSerializeToByteArray, null, 2, null), null, eventType);
        }
        return zWrite;
    }
}
