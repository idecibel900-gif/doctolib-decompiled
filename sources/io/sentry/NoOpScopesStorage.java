package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpScopesStorage implements IScopesStorage {
    private static final NoOpScopesStorage instance = new NoOpScopesStorage();

    @Override // io.sentry.IScopesStorage
    public void close() {
    }

    @Override // io.sentry.IScopesStorage
    public void init() {
    }

    private NoOpScopesStorage() {
    }

    public static NoOpScopesStorage getInstance() {
        return instance;
    }

    @Override // io.sentry.IScopesStorage
    public ISentryLifecycleToken set(IScopes iScopes) {
        return NoOpScopesLifecycleToken.getInstance();
    }

    @Override // io.sentry.IScopesStorage
    public IScopes get() {
        return NoOpScopes.getInstance();
    }
}
