package io.sentry;

import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public final class ShutdownHookIntegration implements Integration, Closeable {
    private final Runtime runtime;
    private Thread thread;

    public ShutdownHookIntegration(Runtime runtime) {
        this.runtime = (Runtime) Objects.requireNonNull(runtime, "Runtime is required");
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }

    @Override // io.sentry.Integration
    public void register(final IScopes iScopes, final SentryOptions sentryOptions) {
        Objects.requireNonNull(iScopes, "Scopes are required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (sentryOptions.isEnableShutdownHook()) {
            this.thread = new Thread(new Runnable() { // from class: io.sentry.ShutdownHookIntegration$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    iScopes.flush(sentryOptions.getFlushTimeoutMillis());
                }
            }, "sentry-shutdownhook");
            handleShutdownInProgress(new Runnable() { // from class: io.sentry.ShutdownHookIntegration$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ShutdownHookIntegration.m5167$r8$lambda$FKX5vC2E3WmjmJjtqJsnNqsII(this.f$0, sentryOptions);
                }
            });
        } else {
            sentryOptions.getLogger().log(SentryLevel.INFO, "enableShutdownHook is disabled.", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-FKX5vC2E3W-mjmJjtqJsnNqsII, reason: not valid java name */
    public static /* synthetic */ void m5167$r8$lambda$FKX5vC2E3WmjmJjtqJsnNqsII(ShutdownHookIntegration shutdownHookIntegration, SentryOptions sentryOptions) {
        shutdownHookIntegration.runtime.addShutdownHook(shutdownHookIntegration.thread);
        sentryOptions.getLogger().log(SentryLevel.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
        IntegrationUtils.addIntegrationToSdkVersion("ShutdownHook");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.thread != null) {
            handleShutdownInProgress(new Runnable() { // from class: io.sentry.ShutdownHookIntegration$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ShutdownHookIntegration shutdownHookIntegration = this.f$0;
                    shutdownHookIntegration.runtime.removeShutdownHook(shutdownHookIntegration.thread);
                }
            });
        }
    }

    private void handleShutdownInProgress(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                throw e;
            }
        }
    }
}
