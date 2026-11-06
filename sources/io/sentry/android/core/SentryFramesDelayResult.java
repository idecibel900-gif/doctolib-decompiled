package io.sentry.android.core;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryFramesDelayResult {
    private final double delaySeconds;
    private final int framesContributingToDelayCount;

    public SentryFramesDelayResult(double d, int i) {
        this.delaySeconds = d;
        this.framesContributingToDelayCount = i;
    }

    public double getDelaySeconds() {
        return this.delaySeconds;
    }
}
