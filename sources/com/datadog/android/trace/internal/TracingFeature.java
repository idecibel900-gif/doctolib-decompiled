package com.datadog.android.trace.internal;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.trace.event.SpanEventMapper;
import com.datadog.android.trace.internal.data.NoOpCoreTracerWriter;
import com.datadog.android.trace.internal.data.NoOpWriter;
import com.datadog.android.trace.internal.data.OtelTraceWriter;
import com.datadog.android.trace.internal.data.TraceWriter;
import com.datadog.android.trace.internal.domain.event.CoreTracerSpanToSpanEventMapper;
import com.datadog.android.trace.internal.domain.event.DdSpanToSpanEventMapper;
import com.datadog.android.trace.internal.domain.event.SpanEventMapperWrapper;
import com.datadog.android.trace.internal.domain.event.SpanEventSerializer;
import com.datadog.android.trace.internal.net.TracesRequestFactory;
import com.datadog.trace.common.writer.Writer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TracingFeature implements StorageBackedFeature {
    public static final Companion Companion = new Companion(null);
    private Writer coreTracerDataWriter;
    private final AtomicBoolean initialized;
    private com.datadog.legacy.trace.common.writer.Writer legacyTracerWriter;
    private final String name;
    private final boolean networkInfoEnabled;
    private final Lazy requestFactory$delegate;
    private final FeatureSdkCore sdkCore;
    private final SpanEventMapper spanEventMapper;
    private final FeatureStorageConfiguration storageConfiguration;

    public TracingFeature(FeatureSdkCore sdkCore, final String str, SpanEventMapper spanEventMapper, boolean z) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(spanEventMapper, "spanEventMapper");
        this.sdkCore = sdkCore;
        this.spanEventMapper = spanEventMapper;
        this.networkInfoEnabled = z;
        this.legacyTracerWriter = new NoOpWriter();
        this.coreTracerDataWriter = new NoOpCoreTracerWriter();
        this.initialized = new AtomicBoolean(false);
        this.name = "tracing";
        this.requestFactory$delegate = LazyKt.lazy(new Function0() { // from class: com.datadog.android.trace.internal.TracingFeature$requestFactory$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TracesRequestFactory invoke() {
                return new TracesRequestFactory(str, this.sdkCore.getInternalLogger());
            }
        });
        this.storageConfiguration = FeatureStorageConfiguration.Companion.getDEFAULT();
    }

    public final com.datadog.legacy.trace.common.writer.Writer getLegacyTracerWriter$dd_sdk_android_trace_release() {
        return this.legacyTracerWriter;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.legacyTracerWriter = createDataWriter(this.sdkCore);
        this.coreTracerDataWriter = createOtelDataWriter(this.sdkCore);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return (RequestFactory) this.requestFactory$delegate.getValue();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.legacyTracerWriter = new NoOpWriter();
        this.initialized.set(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.datadog.legacy.trace.common.writer.Writer createDataWriter(FeatureSdkCore featureSdkCore) {
        InternalLogger internalLogger = featureSdkCore.getInternalLogger();
        int i = 2;
        return new TraceWriter(featureSdkCore, new DdSpanToSpanEventMapper(this.networkInfoEnabled, null, i, 0 == true ? 1 : 0), new SpanEventMapperWrapper(this.spanEventMapper, internalLogger), new SpanEventSerializer(internalLogger, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0), internalLogger);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Writer createOtelDataWriter(FeatureSdkCore featureSdkCore) {
        InternalLogger internalLogger = featureSdkCore.getInternalLogger();
        return new OtelTraceWriter(featureSdkCore, new CoreTracerSpanToSpanEventMapper(this.networkInfoEnabled), new SpanEventMapperWrapper(this.spanEventMapper, internalLogger), new SpanEventSerializer(internalLogger, null, 2, 0 == true ? 1 : 0), internalLogger);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
