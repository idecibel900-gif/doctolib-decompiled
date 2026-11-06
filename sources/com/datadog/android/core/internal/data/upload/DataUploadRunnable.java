package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.ContextProvider;
import com.datadog.android.core.internal.metrics.BenchmarkUploads;
import com.datadog.android.core.internal.metrics.RemovalReason;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.BatchData;
import com.datadog.android.core.internal.persistence.BatchId;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.system.SystemInfo;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataUploadRunnable implements Runnable {
    public static final Companion Companion = new Companion(null);
    private final BenchmarkUploads benchmarkUploads;
    private final ContextProvider contextProvider;
    private final DataUploader dataUploader;
    private final String featureName;
    private final InternalLogger internalLogger;
    private final int maxBatchesPerJob;
    private final NetworkInfoProvider networkInfoProvider;
    private final Storage storage;
    private final SystemInfoProvider systemInfoProvider;
    private final ScheduledThreadPoolExecutor threadPoolExecutor;
    private final UploadSchedulerStrategy uploadSchedulerStrategy;

    public DataUploadRunnable(String featureName, ScheduledThreadPoolExecutor threadPoolExecutor, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, InternalLogger internalLogger, BenchmarkUploads benchmarkUploads) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "threadPoolExecutor");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadSchedulerStrategy, "uploadSchedulerStrategy");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(benchmarkUploads, "benchmarkUploads");
        this.featureName = featureName;
        this.threadPoolExecutor = threadPoolExecutor;
        this.storage = storage;
        this.dataUploader = dataUploader;
        this.contextProvider = contextProvider;
        this.networkInfoProvider = networkInfoProvider;
        this.systemInfoProvider = systemInfoProvider;
        this.uploadSchedulerStrategy = uploadSchedulerStrategy;
        this.maxBatchesPerJob = i;
        this.internalLogger = internalLogger;
        this.benchmarkUploads = benchmarkUploads;
    }

    public /* synthetic */ DataUploadRunnable(String str, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, InternalLogger internalLogger, BenchmarkUploads benchmarkUploads, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, scheduledThreadPoolExecutor, storage, dataUploader, contextProvider, networkInfoProvider, systemInfoProvider, uploadSchedulerStrategy, i, internalLogger, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? new BenchmarkUploads(null, 1, null) : benchmarkUploads);
    }

    @Override // java.lang.Runnable
    public void run() {
        UploadStatus uploadStatusHandleNextBatch;
        int i = 0;
        if (isNetworkAvailable() && isSystemReady()) {
            DatadogContext context = this.contextProvider.getContext();
            int i2 = this.maxBatchesPerJob;
            do {
                this.benchmarkUploads.incrementBenchmarkUploadsCount$dd_sdk_android_core_release(this.featureName);
                i2--;
                uploadStatusHandleNextBatch = handleNextBatch(context);
                if (uploadStatusHandleNextBatch != null) {
                    i++;
                }
                if (i2 <= 0) {
                    break;
                }
            } while (uploadStatusHandleNextBatch instanceof UploadStatus.Success);
        } else {
            uploadStatusHandleNextBatch = null;
        }
        scheduleNextUpload(this.uploadSchedulerStrategy.getMsDelayUntilNextUpload(this.featureName, i, uploadStatusHandleNextBatch != null ? Integer.valueOf(uploadStatusHandleNextBatch.getCode()) : null, uploadStatusHandleNextBatch != null ? uploadStatusHandleNextBatch.getThrowable() : null));
    }

    private final UploadStatus handleNextBatch(DatadogContext datadogContext) {
        BatchData nextBatch = this.storage.readNextBatch();
        if (nextBatch != null) {
            return consumeBatch(datadogContext, nextBatch.getId(), nextBatch.getData(), nextBatch.getMetadata());
        }
        return null;
    }

    private final boolean isNetworkAvailable() {
        return this.networkInfoProvider.getLatestNetworkInfo().getConnectivity() != NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED;
    }

    private final boolean isSystemReady() {
        SystemInfo latestSystemInfo = this.systemInfoProvider.getLatestSystemInfo();
        return (latestSystemInfo.getBatteryFullOrCharging() || latestSystemInfo.getOnExternalPowerSource() || latestSystemInfo.getBatteryLevel() > 10) && !latestSystemInfo.getPowerSaveMode();
    }

    private final void scheduleNextUpload(long j) {
        this.threadPoolExecutor.remove(this);
        ConcurrencyExtKt.scheduleSafe(this.threadPoolExecutor, this.featureName + ": data upload", j, TimeUnit.MILLISECONDS, this.internalLogger, this);
    }

    private final UploadStatus consumeBatch(DatadogContext datadogContext, BatchId batchId, List list, byte[] bArr) {
        RemovalReason intakeCode;
        UploadStatus uploadStatusUpload = this.dataUploader.upload(datadogContext, list, bArr, batchId);
        if (uploadStatusUpload instanceof UploadStatus.Success) {
            Iterator it = list.iterator();
            int length = 0;
            while (it.hasNext()) {
                length += ((RawBatchEvent) it.next()).getData().length;
            }
            this.benchmarkUploads.sendBenchmarkBytesUploaded$dd_sdk_android_core_release(this.featureName, length);
        }
        if (uploadStatusUpload instanceof UploadStatus.RequestCreationError) {
            intakeCode = RemovalReason.Invalid.INSTANCE;
        } else {
            intakeCode = new RemovalReason.IntakeCode(uploadStatusUpload.getCode());
        }
        this.storage.confirmBatchRead(batchId, intakeCode, !uploadStatusUpload.getShouldRetry());
        return uploadStatusUpload;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
