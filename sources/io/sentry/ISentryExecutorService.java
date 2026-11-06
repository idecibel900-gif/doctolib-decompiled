package io.sentry;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public interface ISentryExecutorService {
    void close(long j);

    boolean isClosed();

    void prewarm();

    Future schedule(Runnable runnable, long j);

    Future submit(Runnable runnable);
}
