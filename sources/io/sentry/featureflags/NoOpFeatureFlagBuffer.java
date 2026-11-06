package io.sentry.featureflags;

import io.sentry.protocol.FeatureFlags;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpFeatureFlagBuffer implements IFeatureFlagBuffer {
    private static final NoOpFeatureFlagBuffer instance = new NoOpFeatureFlagBuffer();

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    public void clear() {
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    public FeatureFlags getFeatureFlags() {
        return null;
    }

    public static NoOpFeatureFlagBuffer getInstance() {
        return instance;
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IFeatureFlagBuffer m5219clone() {
        return instance;
    }
}
