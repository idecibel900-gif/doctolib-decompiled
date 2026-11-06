package com.datadog.android.core.internal.lifecycle;

import android.content.Context;
import androidx.work.WorkManager;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.WorkManagerUtilsKt;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessLifecycleCallback implements ProcessLifecycleMonitor.Callback {
    private final Reference contextWeakRef;
    private final String instanceName;
    private final InternalLogger internalLogger;

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onPaused() {
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onResumed() {
    }

    public ProcessLifecycleCallback(Context appContext, String instanceName, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.instanceName = instanceName;
        this.internalLogger = internalLogger;
        this.contextWeakRef = new WeakReference(appContext);
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStarted() {
        Context context = (Context) this.contextWeakRef.get();
        if (context == null || !WorkManager.isInitialized()) {
            return;
        }
        WorkManagerUtilsKt.cancelUploadWorker(context, this.instanceName, this.internalLogger);
    }

    @Override // com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor.Callback
    public void onStopped() {
        Context context = (Context) this.contextWeakRef.get();
        if (context == null || !WorkManager.isInitialized()) {
            return;
        }
        WorkManagerUtilsKt.triggerUploadWorker(context, this.instanceName, this.internalLogger);
    }
}
