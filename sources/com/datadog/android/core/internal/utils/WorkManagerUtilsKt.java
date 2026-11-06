package com.datadog.android.core.internal.utils;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.UploadWorker;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WorkManagerUtilsKt {
    public static final void cancelUploadWorker(Context context, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            workManager.cancelAllWorkByTag("DatadogBackgroundUpload/" + instanceName);
        } catch (IllegalStateException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.cancelUploadWorker.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error cancelling the UploadWorker";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }

    public static final void triggerUploadWorker(Context context, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        try {
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            OneTimeWorkRequest.Builder builder = (OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(UploadWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.NOT_ROAMING).build())).addTag("DatadogBackgroundUpload/" + instanceName)).setInitialDelay(HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            Data dataBuild = new Data.Builder().putString("_dd.sdk.instanceName", instanceName).build();
            Intrinsics.checkNotNullExpressionValue(dataBuild, "Builder().putString(Uplo…ME, instanceName).build()");
            workManager.enqueueUniqueWork("DatadogUploadWorker", ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) builder.setInputData(dataBuild)).build());
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.triggerUploadWorker.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "UploadWorker was scheduled.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.utils.WorkManagerUtilsKt.triggerUploadWorker.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Error while trying to setup the UploadWorker";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
    }
}
