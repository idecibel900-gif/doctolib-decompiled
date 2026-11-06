package com.datadog.android.core.internal.metrics;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.configuration.DataUploadConfiguration;
import com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.advanced.FeatureFileOrchestrator;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.privacy.TrackingConsent;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class BatchMetricsDispatcher implements MetricsDispatcher, ProcessLifecycleMonitor.Callback {
    public static final Companion Companion = new Companion(null);
    private final TimeProvider dateTimeProvider;
    private final FilePersistenceConfig filePersistenceConfig;
    private final InternalLogger internalLogger;
    private final AtomicBoolean isInBackground;
    private final String trackName;
    private final DataUploadConfiguration uploadConfiguration;

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStarted() {
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStopped() {
    }

    public BatchMetricsDispatcher(String featureName, DataUploadConfiguration dataUploadConfiguration, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, TimeProvider dateTimeProvider) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dateTimeProvider, "dateTimeProvider");
        this.uploadConfiguration = dataUploadConfiguration;
        this.filePersistenceConfig = filePersistenceConfig;
        this.internalLogger = internalLogger;
        this.dateTimeProvider = dateTimeProvider;
        this.trackName = resolveTrackName(featureName);
        this.isInBackground = new AtomicBoolean(true);
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchDeletedMetric(File batchFile, RemovalReason removalReason, int i) {
        Map mapResolveBatchDeletedMetricAttributes;
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(removalReason, "removalReason");
        if (!removalReason.includeInMetrics$dd_sdk_android_core_release() || this.trackName == null || (mapResolveBatchDeletedMetricAttributes = resolveBatchDeletedMetricAttributes(batchFile, removalReason, i)) == null) {
            return;
        }
        InternalLogger.DefaultImpls.logMetric$default(this.internalLogger, new Function0() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher$sendBatchDeletedMetric$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "[Mobile Metric] Batch Deleted";
            }
        }, mapResolveBatchDeletedMetricAttributes, 1.5f, null, 8, null);
    }

    @Override // com.datadog.android.core.internal.metrics.MetricsDispatcher
    public void sendBatchClosedMetric(File batchFile, BatchClosedMetadata batchMetadata) {
        Map mapResolveBatchClosedMetricAttributes;
        Intrinsics.checkNotNullParameter(batchFile, "batchFile");
        Intrinsics.checkNotNullParameter(batchMetadata, "batchMetadata");
        if (this.trackName == null || !FileExtKt.existsSafe(batchFile, this.internalLogger) || (mapResolveBatchClosedMetricAttributes = resolveBatchClosedMetricAttributes(batchFile, batchMetadata)) == null) {
            return;
        }
        InternalLogger.DefaultImpls.logMetric$default(this.internalLogger, new Function0() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher$sendBatchClosedMetric$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "[Mobile Metric] Batch Closed";
            }
        }, mapResolveBatchClosedMetricAttributes, 1.5f, null, 8, null);
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onResumed() {
        this.isInBackground.set(false);
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onPaused() {
        this.isInBackground.set(true);
    }

    private final Map resolveBatchDeletedMetricAttributes(File file, RemovalReason removalReason, int i) {
        Long lNameAsTimestampSafe = nameAsTimestampSafe(file, this.internalLogger);
        if (lNameAsTimestampSafe == null) {
            return null;
        }
        long deviceTimestamp = this.dateTimeProvider.getDeviceTimestamp() - lNameAsTimestampSafe.longValue();
        if (deviceTimestamp < 0) {
            return null;
        }
        Pair pair = TuplesKt.to("track", this.trackName);
        Pair pair2 = TuplesKt.to("metric_type", "batch deleted");
        Pair pair3 = TuplesKt.to("batch_age", Long.valueOf(deviceTimestamp));
        DataUploadConfiguration dataUploadConfiguration = this.uploadConfiguration;
        Pair pair4 = TuplesKt.to("min", dataUploadConfiguration != null ? Long.valueOf(dataUploadConfiguration.getMinDelayMs$dd_sdk_android_core_release()) : null);
        DataUploadConfiguration dataUploadConfiguration2 = this.uploadConfiguration;
        return MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("uploader_delay", MapsKt.mapOf(pair4, TuplesKt.to("max", dataUploadConfiguration2 != null ? Long.valueOf(dataUploadConfiguration2.getMaxDelayMs$dd_sdk_android_core_release()) : null))), TuplesKt.to("uploader_window", Long.valueOf(this.filePersistenceConfig.getRecentDelayMs())), TuplesKt.to("batch_removal_reason", removalReason.toString()), TuplesKt.to("in_background", Boolean.valueOf(this.isInBackground.get())), TuplesKt.to(AuthorizationRequest.Prompt.CONSENT, resolveFileOriginAsConsent(file)), TuplesKt.to("filename", file.getName()), TuplesKt.to("pending_batches", Integer.valueOf(i)), TuplesKt.to("thread", Thread.currentThread().getName()));
    }

    private final Map resolveBatchClosedMetricAttributes(File file, BatchClosedMetadata batchClosedMetadata) {
        Long lNameAsTimestampSafe = nameAsTimestampSafe(file, this.internalLogger);
        if (lNameAsTimestampSafe == null) {
            return null;
        }
        long lastTimeWasUsedInMs$dd_sdk_android_core_release = batchClosedMetadata.getLastTimeWasUsedInMs$dd_sdk_android_core_release() - lNameAsTimestampSafe.longValue();
        if (lastTimeWasUsedInMs$dd_sdk_android_core_release < 0) {
            return null;
        }
        return MapsKt.mapOf(TuplesKt.to("track", this.trackName), TuplesKt.to("metric_type", "batch closed"), TuplesKt.to("batch_duration", Long.valueOf(lastTimeWasUsedInMs$dd_sdk_android_core_release)), TuplesKt.to("uploader_window", Long.valueOf(this.filePersistenceConfig.getRecentDelayMs())), TuplesKt.to("batch_size", Long.valueOf(FileExtKt.lengthSafe(file, this.internalLogger))), TuplesKt.to("batch_events_count", Long.valueOf(batchClosedMetadata.getEventsCount$dd_sdk_android_core_release())), TuplesKt.to("forced_new", Boolean.valueOf(batchClosedMetadata.getForcedNew$dd_sdk_android_core_release())), TuplesKt.to(AuthorizationRequest.Prompt.CONSENT, resolveFileOriginAsConsent(file)), TuplesKt.to("filename", file.getName()), TuplesKt.to("thread", Thread.currentThread().getName()));
    }

    private final Long nameAsTimestampSafe(final File file, InternalLogger internalLogger) {
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.name");
        Long longOrNull = StringsKt.toLongOrNull(name);
        if (longOrNull == null) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.metrics.BatchMetricsDispatcher.nameAsTimestampSafe.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String str = String.format(Locale.ENGLISH, "Unable to parse the file name as a timestamp: %s", Arrays.copyOf(new Object[]{file.getName()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return longOrNull;
    }

    private final String resolveTrackName(String str) {
        switch (str) {
            case "tracing":
                return "trace";
            case "rum":
                return "rum";
            case "logs":
                return "logs";
            case "session-replay":
                return "sr";
            case "session-replay-resources":
                return "sr-resources";
            default:
                return null;
        }
    }

    private final String resolveFileOriginAsConsent(File file) {
        File parentFile = file.getParentFile();
        String name = parentFile != null ? parentFile.getName() : null;
        if (name == null) {
            return null;
        }
        FeatureFileOrchestrator.Companion companion = FeatureFileOrchestrator.Companion;
        if (companion.getIS_PENDING_DIR_REG_EX$dd_sdk_android_core_release().matches(name)) {
            String string = TrackingConsent.PENDING.toString();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = string.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (!companion.getIS_GRANTED_DIR_REG_EX$dd_sdk_android_core_release().matches(name)) {
            return null;
        }
        String string2 = TrackingConsent.GRANTED.toString();
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String lowerCase2 = string2.toLowerCase(US2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return lowerCase2;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
