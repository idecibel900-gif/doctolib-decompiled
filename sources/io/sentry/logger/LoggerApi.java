package io.sentry.logger;

import io.sentry.Scopes;

/* JADX INFO: loaded from: classes5.dex */
public final class LoggerApi implements ILoggerApi {
    private final Scopes scopes;

    public LoggerApi(Scopes scopes) {
        this.scopes = scopes;
    }
}
