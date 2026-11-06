package com.datadog.android.core.internal.persistence.file.advanced;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.metrics.MetricsDispatcher;
import com.datadog.android.core.internal.persistence.file.FileMover;
import com.datadog.android.core.internal.persistence.file.FileOrchestrator;
import com.datadog.android.core.internal.persistence.file.FilePersistenceConfig;
import com.datadog.android.core.internal.persistence.file.batch.BatchFileOrchestrator;
import com.datadog.android.core.internal.privacy.ConsentProvider;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class FeatureFileOrchestrator extends ConsentAwareFileOrchestrator {
    public static final Companion Companion = new Companion(null);
    private static final Regex IS_GRANTED_DIR_REG_EX = new Regex("([a-z]+-)+v[0-9]+");
    private static final Regex IS_PENDING_DIR_REG_EX = new Regex("([a-z]+-)+pending-v[0-9]+");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureFileOrchestrator(ConsentProvider consentProvider, FileOrchestrator pendingOrchestrator, FileOrchestrator grantedOrchestrator, DataMigrator dataMigrator, ExecutorService executorService, InternalLogger internalLogger) {
        super(consentProvider, pendingOrchestrator, grantedOrchestrator, dataMigrator, executorService, internalLogger);
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(pendingOrchestrator, "pendingOrchestrator");
        Intrinsics.checkNotNullParameter(grantedOrchestrator, "grantedOrchestrator");
        Intrinsics.checkNotNullParameter(dataMigrator, "dataMigrator");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
    }

    public FeatureFileOrchestrator(ConsentProvider consentProvider, File storageDir, String featureName, ExecutorService executorService, FilePersistenceConfig filePersistenceConfig, InternalLogger internalLogger, MetricsDispatcher metricsDispatcher) {
        Intrinsics.checkNotNullParameter(consentProvider, "consentProvider");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(filePersistenceConfig, "filePersistenceConfig");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(metricsDispatcher, "metricsDispatcher");
        Locale locale = Locale.US;
        String str = String.format(locale, "%s-pending-v2", Arrays.copyOf(new Object[]{featureName}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        BatchFileOrchestrator batchFileOrchestrator = new BatchFileOrchestrator(new File(storageDir, str), filePersistenceConfig, internalLogger, metricsDispatcher, null, 16, null);
        String str2 = String.format(locale, "%s-v2", Arrays.copyOf(new Object[]{featureName}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        this(consentProvider, batchFileOrchestrator, new BatchFileOrchestrator(new File(storageDir, str2), filePersistenceConfig, internalLogger, metricsDispatcher, null, 16, null), new ConsentAwareFileMigrator(new FileMover(internalLogger), internalLogger), executorService, internalLogger);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getIS_GRANTED_DIR_REG_EX$dd_sdk_android_core_release() {
            return FeatureFileOrchestrator.IS_GRANTED_DIR_REG_EX;
        }

        public final Regex getIS_PENDING_DIR_REG_EX$dd_sdk_android_core_release() {
            return FeatureFileOrchestrator.IS_PENDING_DIR_REG_EX;
        }
    }
}
