package com.datadog.android.rum.internal.domain;

import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.persistence.Serializer;
import com.datadog.android.core.persistence.SerializerKt;
import com.datadog.android.rum.internal.domain.event.RumEventMeta;
import com.datadog.android.rum.model.ViewEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumDataWriter implements DataWriter {
    public static final Companion Companion = new Companion(null);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final Serializer eventMetaSerializer;
    private final Serializer eventSerializer;
    private final InternalSdkCore sdkCore;

    public RumDataWriter(Serializer eventSerializer, Serializer eventMetaSerializer, InternalSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(eventSerializer, "eventSerializer");
        Intrinsics.checkNotNullParameter(eventMetaSerializer, "eventMetaSerializer");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.eventSerializer = eventSerializer;
        this.eventMetaSerializer = eventMetaSerializer;
        this.sdkCore = sdkCore;
    }

    @Override // com.datadog.android.api.storage.DataWriter
    public boolean write(EventBatchWriter writer, Object element, EventType eventType) {
        RawBatchEvent rawBatchEvent;
        boolean zWrite;
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        byte[] bArrSerializeToByteArray = SerializerKt.serializeToByteArray(this.eventSerializer, element, this.sdkCore.getInternalLogger());
        if (bArrSerializeToByteArray == null) {
            return false;
        }
        if (element instanceof ViewEvent) {
            ViewEvent viewEvent = (ViewEvent) element;
            byte[] bArrSerializeToByteArray2 = SerializerKt.serializeToByteArray(this.eventMetaSerializer, new RumEventMeta.View(viewEvent.getView().getId(), viewEvent.getDd().getDocumentVersion(), Boolean.valueOf(viewEvent.getView().getAccessibility() != null)), this.sdkCore.getInternalLogger());
            if (bArrSerializeToByteArray2 == null) {
                bArrSerializeToByteArray2 = EMPTY_BYTE_ARRAY;
            }
            rawBatchEvent = new RawBatchEvent(bArrSerializeToByteArray, bArrSerializeToByteArray2);
        } else {
            rawBatchEvent = new RawBatchEvent(bArrSerializeToByteArray, null, 2, null);
        }
        synchronized (this) {
            zWrite = writer.write(rawBatchEvent, null, eventType);
            if (zWrite) {
                onDataWritten$dd_sdk_android_rum_release(element, bArrSerializeToByteArray);
            }
        }
        return zWrite;
    }

    public final void onDataWritten$dd_sdk_android_rum_release(Object data, byte[] rawData) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        if (data instanceof ViewEvent) {
            this.sdkCore.writeLastViewEvent(rawData);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
