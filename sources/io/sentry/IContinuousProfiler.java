package io.sentry;

import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public interface IContinuousProfiler {
    void close(boolean z);

    SentryId getChunkId();

    SentryId getProfilerId();

    boolean isRunning();

    void reevaluateSampling();

    void startProfiler(ProfileLifecycle profileLifecycle, TracesSampler tracesSampler);

    void stopProfiler(ProfileLifecycle profileLifecycle);
}
