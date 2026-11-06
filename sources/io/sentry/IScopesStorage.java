package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public interface IScopesStorage {
    void close();

    IScopes get();

    void init();

    ISentryLifecycleToken set(IScopes iScopes);
}
