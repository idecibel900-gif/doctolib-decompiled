package io.sentry;

import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public interface ReplayController {
    void captureReplay(Boolean bool);

    ReplayBreadcrumbConverter getBreadcrumbConverter();

    SentryId getReplayId();

    boolean isDebugMaskingOverlayEnabled();

    void pause();

    void resume();

    void setBreadcrumbConverter(ReplayBreadcrumbConverter replayBreadcrumbConverter);

    void start();

    void stop();
}
