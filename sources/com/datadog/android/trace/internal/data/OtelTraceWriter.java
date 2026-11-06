package com.datadog.android.trace.internal.data;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.event.EventMapper;
import com.datadog.android.trace.internal.domain.event.ContextAwareMapper;
import com.datadog.android.trace.internal.storage.ContextAwareSerializer;
import com.datadog.trace.common.writer.Writer;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class OtelTraceWriter implements Writer {
    public static final Companion Companion = new Companion(null);
    private static final Set DROP_SAMPLING_PRIORITIES = SetsKt.setOf((Object[]) new Integer[]{0, -1});
    private final ContextAwareMapper ddSpanToSpanEventMapper;
    private final EventMapper eventMapper;
    private final InternalLogger internalLogger;
    private final FeatureSdkCore sdkCore;
    private final ContextAwareSerializer serializer;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public OtelTraceWriter(FeatureSdkCore sdkCore, ContextAwareMapper ddSpanToSpanEventMapper, EventMapper eventMapper, ContextAwareSerializer serializer, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(ddSpanToSpanEventMapper, "ddSpanToSpanEventMapper");
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.sdkCore = sdkCore;
        this.ddSpanToSpanEventMapper = ddSpanToSpanEventMapper;
        this.eventMapper = eventMapper;
        this.serializer = serializer;
        this.internalLogger = internalLogger;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
