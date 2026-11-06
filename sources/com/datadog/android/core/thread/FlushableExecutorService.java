package com.datadog.android.core.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface FlushableExecutorService extends ExecutorService, AutoCloseable {

    public interface Factory {
        FlushableExecutorService create(InternalLogger internalLogger, String str, BackPressureStrategy backPressureStrategy);
    }
}
