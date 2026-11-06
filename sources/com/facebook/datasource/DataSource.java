package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface DataSource {
    boolean close();

    Map getExtras();

    Throwable getFailureCause();

    float getProgress();

    Object getResult();

    boolean hasMultipleResults();

    boolean hasResult();

    boolean isFinished();

    void subscribe(DataSubscriber dataSubscriber, Executor executor);
}
