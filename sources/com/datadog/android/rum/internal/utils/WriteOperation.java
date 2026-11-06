package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WriteOperation {
    public static final Companion Companion = new Companion(null);
    private static final Function1 NO_OP_EVENT_OUTCOME_ACTION = new Function1() { // from class: com.datadog.android.rum.internal.utils.WriteOperation$Companion$NO_OP_EVENT_OUTCOME_ACTION$1
        public final void invoke(AdvancedRumMonitor it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AdvancedRumMonitor) obj);
            return Unit.INSTANCE;
        }
    };
    private final AdvancedRumMonitor advancedRumMonitor;
    private final Function1 eventSource;
    private final EventType eventType;
    private Function1 onError;
    private Function1 onSuccess;
    private final DataWriter rumDataWriter;
    private final FeatureSdkCore sdkCore;

    public WriteOperation(FeatureSdkCore sdkCore, DataWriter rumDataWriter, EventType eventType, Function1 eventSource) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(rumDataWriter, "rumDataWriter");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        this.sdkCore = sdkCore;
        this.rumDataWriter = rumDataWriter;
        this.eventType = eventType;
        this.eventSource = eventSource;
        RumMonitor rumMonitor = GlobalRumMonitor.get(sdkCore);
        this.advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        Function1 function1 = NO_OP_EVENT_OUTCOME_ACTION;
        this.onError = function1;
        this.onSuccess = function1;
    }

    public final WriteOperation onError(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.onError = action;
        return this;
    }

    public final WriteOperation onSuccess(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.onSuccess = action;
        return this;
    }

    public final void submit() {
        FeatureScope feature = this.sdkCore.getFeature("rum");
        if (feature != null) {
            FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.submit.1
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
                    if (!(WriteOperation.this.rumDataWriter instanceof NoOpDataWriter)) {
                        try {
                            if (WriteOperation.this.rumDataWriter.write(eventBatchWriter, WriteOperation.this.eventSource.invoke(datadogContext), WriteOperation.this.eventType)) {
                                AdvancedRumMonitor advancedRumMonitor = WriteOperation.this.advancedRumMonitor;
                                if (advancedRumMonitor != null) {
                                    WriteOperation.this.onSuccess.invoke(advancedRumMonitor);
                                    return;
                                }
                                return;
                            }
                            WriteOperation.notifyEventWriteFailure$default(WriteOperation.this, null, 1, null);
                            return;
                        } catch (Exception e) {
                            WriteOperation.this.notifyEventWriteFailure(e);
                            return;
                        }
                    }
                    InternalLogger.DefaultImpls.log$default(WriteOperation.this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.submit.1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Write operation ignored, session is expired or RUM feature is disabled.";
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    AdvancedRumMonitor advancedRumMonitor2 = WriteOperation.this.advancedRumMonitor;
                    if (advancedRumMonitor2 != null) {
                        WriteOperation.this.onError.invoke(advancedRumMonitor2);
                    }
                }
            }, 1, null);
        }
    }

    static /* synthetic */ void notifyEventWriteFailure$default(WriteOperation writeOperation, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = null;
        }
        writeOperation.notifyEventWriteFailure(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyEventWriteFailure(Exception exc) {
        List listMutableListOf = CollectionsKt.mutableListOf(InternalLogger.Target.USER);
        if (exc != null) {
            listMutableListOf.add(InternalLogger.Target.TELEMETRY);
        }
        InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.ERROR, listMutableListOf, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.utils.WriteOperation.notifyEventWriteFailure.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Write operation failed.";
            }
        }, (Throwable) exc, false, (Map) null, 48, (Object) null);
        AdvancedRumMonitor advancedRumMonitor = this.advancedRumMonitor;
        if (advancedRumMonitor != null) {
            if (Intrinsics.areEqual(this.onError, NO_OP_EVENT_OUTCOME_ACTION)) {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.utils.WriteOperation$notifyEventWriteFailure$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Write operation failed, but no onError callback was provided.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            this.onError.invoke(advancedRumMonitor);
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
