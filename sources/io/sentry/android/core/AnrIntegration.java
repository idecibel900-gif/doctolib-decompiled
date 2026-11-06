package io.sentry.android.core;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.IScopes;
import io.sentry.ISentryLifecycleToken;
import io.sentry.Integration;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.AbnormalExit;
import io.sentry.hints.TransactionEnd;
import io.sentry.protocol.Mechanism;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public final class AnrIntegration implements Integration, Closeable {
    private static ANRWatchDog anrWatchDog;
    protected static final AutoClosableReentrantLock watchDogLock = new AutoClosableReentrantLock();
    private final Context context;
    private SentryOptions options;
    private boolean isClosed = false;
    private final AutoClosableReentrantLock startLock = new AutoClosableReentrantLock();

    public AnrIntegration(Context context) {
        this.context = ContextUtils.getApplicationContext(context);
    }

    @Override // io.sentry.Integration
    public final void register(IScopes iScopes, SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        register(iScopes, (SentryAndroidOptions) sentryOptions);
    }

    private void register(final IScopes iScopes, final SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            IntegrationUtils.addIntegrationToSdkVersion("Anr");
            try {
                sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.AnrIntegration$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnrIntegration.m5179$r8$lambda$_CZEDj0GSI5PrVh45OXTJKY2WM(this.f$0, iScopes, sentryAndroidOptions);
                    }
                });
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "Failed to start AnrIntegration on executor thread.", th);
            }
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$_CZEDj0GSI5PrVh45OX-TJKY2WM, reason: not valid java name */
    public static /* synthetic */ void m5179$r8$lambda$_CZEDj0GSI5PrVh45OXTJKY2WM(AnrIntegration anrIntegration, IScopes iScopes, SentryAndroidOptions sentryAndroidOptions) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = anrIntegration.startLock.acquire();
        try {
            if (!anrIntegration.isClosed) {
                anrIntegration.startAnrWatchdog(iScopes, sentryAndroidOptions);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void startAnrWatchdog(final IScopes iScopes, final SentryAndroidOptions sentryAndroidOptions) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = watchDogLock.acquire();
        try {
            if (anrWatchDog == null) {
                ILogger logger = sentryAndroidOptions.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                logger.log(sentryLevel, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                ANRWatchDog aNRWatchDog = new ANRWatchDog(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new ANRWatchDog.ANRListener() { // from class: io.sentry.android.core.AnrIntegration$$ExternalSyntheticLambda1
                    @Override // io.sentry.android.core.ANRWatchDog.ANRListener
                    public final void onAppNotResponding(ApplicationNotResponding applicationNotResponding) {
                        this.f$0.reportANR(iScopes, sentryAndroidOptions, applicationNotResponding);
                    }
                }, sentryAndroidOptions.getLogger(), this.context);
                anrWatchDog = aNRWatchDog;
                aNRWatchDog.start();
                sentryAndroidOptions.getLogger().log(sentryLevel, "AnrIntegration installed.", new Object[0]);
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire == null) {
                throw th;
            }
            try {
                iSentryLifecycleTokenAcquire.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportANR(IScopes iScopes, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        sentryAndroidOptions.getLogger().log(SentryLevel.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
        boolean zEquals = Boolean.TRUE.equals(AppState.getInstance().isInBackground());
        SentryEvent sentryEvent = new SentryEvent(buildAnrThrowable(zEquals, sentryAndroidOptions, applicationNotResponding));
        sentryEvent.setLevel(SentryLevel.ERROR);
        iScopes.captureEvent(sentryEvent, HintUtils.createWithTypeCheckHint(new AnrHint(zEquals)));
    }

    private Throwable buildAnrThrowable(boolean z, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        ApplicationNotResponding applicationNotResponding2;
        String str = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
        if (z) {
            str = "Background " + str;
        }
        Thread thread = applicationNotResponding.getThread();
        if (thread == null) {
            applicationNotResponding2 = new ApplicationNotResponding(str);
        } else {
            applicationNotResponding2 = new ApplicationNotResponding(str, thread);
        }
        Mechanism mechanism = new Mechanism();
        mechanism.setType("ANR");
        return new ExceptionMechanismException(mechanism, applicationNotResponding2, thread, true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.startLock.acquire();
        try {
            this.isClosed = true;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            iSentryLifecycleTokenAcquire = watchDogLock.acquire();
            try {
                ANRWatchDog aNRWatchDog = anrWatchDog;
                if (aNRWatchDog != null) {
                    aNRWatchDog.interrupt();
                    anrWatchDog = null;
                    SentryOptions sentryOptions = this.options;
                    if (sentryOptions != null) {
                        sentryOptions.getLogger().log(SentryLevel.DEBUG, "AnrIntegration removed.", new Object[0]);
                    }
                }
                if (iSentryLifecycleTokenAcquire != null) {
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } finally {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            }
        }
    }

    static final class AnrHint implements AbnormalExit, TransactionEnd {
        private final boolean isBackgroundAnr;

        @Override // io.sentry.hints.AbnormalExit
        public boolean ignoreCurrentThread() {
            return true;
        }

        @Override // io.sentry.hints.AbnormalExit
        public Long timestamp() {
            return null;
        }

        AnrHint(boolean z) {
            this.isBackgroundAnr = z;
        }

        @Override // io.sentry.hints.AbnormalExit
        public String mechanism() {
            return this.isBackgroundAnr ? "anr_background" : "anr_foreground";
        }
    }
}
