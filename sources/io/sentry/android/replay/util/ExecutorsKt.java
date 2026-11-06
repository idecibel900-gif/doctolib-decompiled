package io.sentry.android.replay.util;

import io.sentry.ISentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExecutorsKt {
    public static final Future submitSafely(ISentryExecutorService iSentryExecutorService, final SentryOptions options, final String taskName, final Runnable task) {
        Intrinsics.checkNotNullParameter(iSentryExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            return iSentryExecutorService.submit(new Runnable() { // from class: io.sentry.android.replay.util.ExecutorsKt$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExecutorsKt.submitSafely$lambda$0(task, options, taskName);
                }
            });
        } catch (Throwable th) {
            options.getLogger().log(SentryLevel.ERROR, "Failed to submit task " + taskName + " to executor", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitSafely$lambda$0(Runnable runnable, SentryOptions sentryOptions, String str) {
        try {
            runnable.run();
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to execute task " + str, th);
        }
    }
}
