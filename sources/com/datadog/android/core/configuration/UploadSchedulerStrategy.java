package com.datadog.android.core.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface UploadSchedulerStrategy {
    long getMsDelayUntilNextUpload(String str, int i, Integer num, Throwable th);
}
