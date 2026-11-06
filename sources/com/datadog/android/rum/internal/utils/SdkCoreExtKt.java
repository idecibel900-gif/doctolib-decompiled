package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SdkCoreExtKt {
    public static /* synthetic */ WriteOperation newRumEventWriteOperation$default(FeatureSdkCore featureSdkCore, DataWriter dataWriter, EventType eventType, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            eventType = EventType.DEFAULT;
        }
        return newRumEventWriteOperation(featureSdkCore, dataWriter, eventType, function1);
    }

    public static final WriteOperation newRumEventWriteOperation(FeatureSdkCore featureSdkCore, DataWriter rumDataWriter, EventType eventType, Function1 eventSource) {
        Intrinsics.checkNotNullParameter(featureSdkCore, "<this>");
        Intrinsics.checkNotNullParameter(rumDataWriter, "rumDataWriter");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        return new WriteOperation(featureSdkCore, rumDataWriter, eventType, eventSource);
    }
}
