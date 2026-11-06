package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureStrategy;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface ScheduledExecutorServiceFactory {
    ScheduledExecutorService create(InternalLogger internalLogger, String str, BackPressureStrategy backPressureStrategy);
}
