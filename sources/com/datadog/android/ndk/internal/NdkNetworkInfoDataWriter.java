package com.datadog.android.ndk.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.net.info.NetworkInfoSerializer;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.FileWriter;
import com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileMigrator;
import com.datadog.android.core.internal.persistence.file.advanced.ConsentAwareFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.single.SingleFileOrchestrator;
import com.datadog.android.core.internal.persistence.file.single.SingleItemDataWriter;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import java.io.File;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NdkNetworkInfoDataWriter extends SingleItemDataWriter {
    /* JADX WARN: Illegal instructions before constructor call */
    public NdkNetworkInfoDataWriter(File storageDir, ConsentProvider consentProvider, ExecutorService executorService, FileWriter fileWriter, FileMover fileMover, InternalLogger internalLogger, FilePersistenceConfig filePersistenceConfig) {
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(fileWriter, "fileWriter");
        Intrinsics.checkNotNullParameter(fileMover, "fileMover");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        DatadogNdkCrashHandler.Companion companion = DatadogNdkCrashHandler.Companion;
        super(new ConsentAwareFileOrchestrator(consentProvider, new SingleFileOrchestrator(companion.getPendingNetworkInfoFile$dd_sdk_android_core_release(storageDir), internalLogger), new SingleFileOrchestrator(companion.getGrantedNetworkInfoFile$dd_sdk_android_core_release(storageDir), internalLogger), new ConsentAwareFileMigrator(fileMover, internalLogger), executorService, internalLogger), new NetworkInfoSerializer(), fileWriter, internalLogger, filePersistenceConfig);
    }
}
