package io.sentry.featureflags;

import io.sentry.protocol.FeatureFlags;

/* JADX INFO: loaded from: classes5.dex */
public interface IFeatureFlagBuffer {
    void clear();

    IFeatureFlagBuffer clone();

    FeatureFlags getFeatureFlags();
}
