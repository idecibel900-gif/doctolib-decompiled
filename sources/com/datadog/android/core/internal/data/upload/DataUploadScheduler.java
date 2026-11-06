package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.ContextProvider;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.Storage;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataUploadScheduler implements UploadScheduler {
    private final String featureName;
    private final InternalLogger internalLogger;
    private final DataUploadRunnable runnable;
    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    public DataUploadScheduler(String featureName, Storage storage, DataUploader dataUploader, ContextProvider contextProvider, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadSchedulerStrategy uploadSchedulerStrategy, int i, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadSchedulerStrategy, "uploadSchedulerStrategy");
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "scheduledThreadPoolExecutor");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.featureName = featureName;
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        this.internalLogger = internalLogger;
        this.runnable = new DataUploadRunnable(featureName, scheduledThreadPoolExecutor, storage, dataUploader, contextProvider, networkInfoProvider, systemInfoProvider, uploadSchedulerStrategy, i, internalLogger, null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, null);
    }

    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void startScheduling() {
        ConcurrencyExtKt.executeSafe(this.scheduledThreadPoolExecutor, this.featureName + ": data upload", this.internalLogger, this.runnable);
    }

    @Override // com.datadog.android.core.internal.data.upload.UploadScheduler
    public void stopScheduling() {
        this.scheduledThreadPoolExecutor.remove(this.runnable);
    }
}
