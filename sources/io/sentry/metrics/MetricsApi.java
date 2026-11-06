package io.sentry.metrics;

import io.sentry.Scopes;

/* JADX INFO: loaded from: classes5.dex */
public final class MetricsApi implements IMetricsApi {
    private final Scopes scopes;

    public MetricsApi(Scopes scopes) {
        this.scopes = scopes;
    }
}
