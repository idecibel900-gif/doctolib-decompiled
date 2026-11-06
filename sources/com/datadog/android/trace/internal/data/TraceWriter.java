package com.datadog.android.trace.internal.data;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.event.EventMapper;
import com.datadog.android.trace.internal.domain.event.ContextAwareMapper;
import com.datadog.android.trace.internal.storage.ContextAwareSerializer;
import com.datadog.android.trace.model.SpanEvent;
import com.datadog.legacy.trace.common.writer.Writer;
import com.datadog.opentracing.DDSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class TraceWriter implements Writer {
    public static final Companion Companion = new Companion(null);
    private static final Set DROP_SAMPLING_PRIORITIES = SetsKt.setOf((Object[]) new Integer[]{0, -1});
    private static final Set KEEP_AND_UNSET_SAMPLING_PRIORITIES;
    private static final Set KEEP_SAMPLING_PRIORITIES;
    private final ContextAwareMapper ddSpanToSpanEventMapper;
    private final EventMapper eventMapper;
    private final InternalLogger internalLogger;
    private final FeatureSdkCore sdkCore;
    private final ContextAwareSerializer serializer;

    @Override // com.datadog.legacy.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void incrementTraceCount() {
    }

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void start() {
    }

    public TraceWriter(FeatureSdkCore sdkCore, ContextAwareMapper ddSpanToSpanEventMapper, EventMapper eventMapper, ContextAwareSerializer serializer, InternalLogger internalLogger) {
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

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void write(final List list) {
        FeatureScope feature;
        if (list == null || (feature = this.sdkCore.getFeature("tracing")) == null) {
            return;
        }
        FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.trace.internal.data.TraceWriter.write.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((DatadogContext) obj, (EventBatchWriter) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(DatadogContext datadogContext, EventBatchWriter eventBatchWriter) {
                Intrinsics.checkNotNullParameter(datadogContext, "datadogContext");
                Intrinsics.checkNotNullParameter(eventBatchWriter, "eventBatchWriter");
                List list2 = list;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list2) {
                    DDSpan dDSpan = (DDSpan) obj;
                    if (dDSpan.getSamplingPriority() == null || !TraceWriter.Companion.getDROP_SAMPLING_PRIORITIES$dd_sdk_android_trace_release().contains(dDSpan.getSamplingPriority())) {
                        arrayList.add(obj);
                    }
                }
                TraceWriter traceWriter = this;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    traceWriter.writeSpan(datadogContext, eventBatchWriter, (DDSpan) it.next());
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeSpan(DatadogContext datadogContext, EventBatchWriter eventBatchWriter, DDSpan dDSpan) {
        final SpanEvent spanEvent = (SpanEvent) this.eventMapper.map((SpanEvent) this.ddSpanToSpanEventMapper.map(datadogContext, dDSpan));
        if (spanEvent == null) {
            return;
        }
        try {
            String strSerialize = this.serializer.serialize(datadogContext, spanEvent);
            if (strSerialize != null) {
                byte[] bytes = strSerialize.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                if (bytes != null) {
                    synchronized (this) {
                        eventBatchWriter.write(new RawBatchEvent(bytes, null, 2, null), null, EventType.DEFAULT);
                    }
                }
            }
        } catch (Throwable th) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.trace.internal.data.TraceWriter.writeSpan.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.US, "Error serializing %s model", Arrays.copyOf(new Object[]{spanEvent.getClass().getSimpleName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, th, false, (Map) null, 48, (Object) null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set getDROP_SAMPLING_PRIORITIES$dd_sdk_android_trace_release() {
            return TraceWriter.DROP_SAMPLING_PRIORITIES;
        }
    }

    static {
        Set of = SetsKt.setOf((Object[]) new Integer[]{1, 2});
        KEEP_SAMPLING_PRIORITIES = of;
        KEEP_AND_UNSET_SAMPLING_PRIORITIES = SetsKt.plus(of, Integer.valueOf(LinearLayoutManager.INVALID_OFFSET));
    }
}
