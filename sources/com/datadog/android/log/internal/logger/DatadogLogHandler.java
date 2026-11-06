package com.datadog.android.log.internal.logger;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.EventBatchWriter;
import com.datadog.android.api.storage.EventType;
import com.datadog.android.core.sampling.Sampler;
import com.datadog.android.log.internal.LogsFeature;
import com.datadog.android.log.internal.domain.LogGenerator;
import com.datadog.android.log.model.LogEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogLogHandler implements LogHandler {
    private static final Companion Companion = new Companion(null);
    private final boolean attachNetworkInfo;
    private final boolean bundleWithRum;
    private final boolean bundleWithTraces;
    private final LogGenerator logGenerator;
    private final String loggerName;
    private final int minLogPriority;
    private final Sampler sampler;
    private final FeatureSdkCore sdkCore;
    private final DataWriter writer;

    public DatadogLogHandler(String loggerName, LogGenerator logGenerator, FeatureSdkCore sdkCore, DataWriter writer, boolean z, boolean z2, boolean z3, Sampler sampler, int i) {
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(logGenerator, "logGenerator");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(sampler, "sampler");
        this.loggerName = loggerName;
        this.logGenerator = logGenerator;
        this.sdkCore = sdkCore;
        this.writer = writer;
        this.attachNetworkInfo = z;
        this.bundleWithTraces = z2;
        this.bundleWithRum = z3;
        this.sampler = sampler;
        this.minLogPriority = i;
    }

    public final DataWriter getWriter$dd_sdk_android_logs_release() {
        return this.writer;
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(final int i, final String message, final Throwable th, Map attributes, final Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (i < this.minLogPriority) {
            return;
        }
        final long jLongValue = l != null ? l.longValue() : System.currentTimeMillis();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature != null) {
            linkedHashMap.putAll(MapsKt.toMutableMap(((LogsFeature) feature.unwrap()).getAttributes$dd_sdk_android_logs_release()));
        }
        linkedHashMap.putAll(attributes);
        if (this.sampler.sample(Unit.INSTANCE)) {
            if (feature != null) {
                final String name = Thread.currentThread().getName();
                FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.1
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
                        DatadogLogHandler datadogLogHandler = DatadogLogHandler.this;
                        int i2 = i;
                        String str = message;
                        Throwable th2 = th;
                        Map map = linkedHashMap;
                        Set set = tags;
                        String threadName = name;
                        Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
                        LogEvent logEventCreateLog = datadogLogHandler.createLog(i2, datadogContext, str, th2, map, set, threadName, jLongValue);
                        if (logEventCreateLog != null) {
                            DatadogLogHandler.this.getWriter$dd_sdk_android_logs_release().write(eventBatchWriter, logEventCreateLog, EventType.DEFAULT);
                        }
                    }
                }, 1, null);
            } else {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Requested to write log, but Logs feature is not registered.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        if (i >= 6) {
            FeatureScope feature2 = this.sdkCore.getFeature("rum");
            if (feature2 != null) {
                feature2.sendEvent(MapsKt.mapOf(TuplesKt.to("type", "logger_error"), TuplesKt.to("message", message), TuplesKt.to("throwable", th), TuplesKt.to("attributes", linkedHashMap)));
            } else {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Requested to forward error log to RUM, but RUM feature is not registered.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(final int i, final String message, final String str, final String str2, final String str3, Map attributes, final Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (i < this.minLogPriority) {
            return;
        }
        final long jLongValue = l != null ? l.longValue() : System.currentTimeMillis();
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        FeatureScope feature = this.sdkCore.getFeature("logs");
        if (feature != null) {
            linkedHashMap.putAll(MapsKt.toMutableMap(((LogsFeature) feature.unwrap()).getAttributes$dd_sdk_android_logs_release()));
        }
        linkedHashMap.putAll(attributes);
        if (this.sampler.sample(Unit.INSTANCE)) {
            if (feature != null) {
                final String name = Thread.currentThread().getName();
                FeatureScope.DefaultImpls.withWriteContext$default(feature, false, new Function2() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.4
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
                        DatadogLogHandler datadogLogHandler = DatadogLogHandler.this;
                        int i2 = i;
                        String str4 = message;
                        String str5 = str;
                        String str6 = str2;
                        String str7 = str3;
                        Map map = linkedHashMap;
                        Set set = tags;
                        String threadName = name;
                        Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
                        LogEvent logEventCreateLog = datadogLogHandler.createLog(i2, datadogContext, str4, str5, str6, str7, map, set, threadName, jLongValue);
                        if (logEventCreateLog != null) {
                            DatadogLogHandler.this.getWriter$dd_sdk_android_logs_release().write(eventBatchWriter, logEventCreateLog, EventType.DEFAULT);
                        }
                    }
                }, 1, null);
            } else {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.5
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Requested to write log, but Logs feature is not registered.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
        if (i >= 6) {
            FeatureScope feature2 = this.sdkCore.getFeature("rum");
            if (feature2 != null) {
                feature2.sendEvent(MapsKt.mapOf(TuplesKt.to("type", "logger_error_with_stacktrace"), TuplesKt.to("message", message), TuplesKt.to("stacktrace", str3), TuplesKt.to("attributes", linkedHashMap)));
            } else {
                InternalLogger.DefaultImpls.log$default(this.sdkCore.getInternalLogger(), InternalLogger.Level.INFO, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.log.internal.logger.DatadogLogHandler.handleLog.6
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Requested to forward error log to RUM, but RUM feature is not registered.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEvent createLog(int i, DatadogContext datadogContext, String str, Throwable th, Map map, Set set, String str2, long j) {
        return LogGenerator.DefaultImpls.generateLog$default(this.logGenerator, i, str, th, map, set, j, str2, datadogContext, this.attachNetworkInfo, this.loggerName, this.bundleWithTraces, this.bundleWithRum, null, null, null, null, 61440, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LogEvent createLog(int i, DatadogContext datadogContext, String str, String str2, String str3, String str4, Map map, Set set, String str5, long j) {
        return LogGenerator.DefaultImpls.generateLog$default(this.logGenerator, i, str, str2, str3, str4, map, set, j, str5, datadogContext, this.attachNetworkInfo, this.loggerName, this.bundleWithTraces, this.bundleWithRum, null, null, null, 114688, null);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
