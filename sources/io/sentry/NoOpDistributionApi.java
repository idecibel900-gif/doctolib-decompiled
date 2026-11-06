package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpDistributionApi implements IDistributionApi {
    private static final NoOpDistributionApi instance = new NoOpDistributionApi();

    private NoOpDistributionApi() {
    }

    public static NoOpDistributionApi getInstance() {
        return instance;
    }
}
