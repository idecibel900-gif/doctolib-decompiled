package io.sentry.android.replay.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayRunnable implements Runnable {
    private final /* synthetic */ Runnable $$delegate_0;
    private final String taskName;

    @Override // java.lang.Runnable
    public void run() {
        this.$$delegate_0.run();
    }

    public ReplayRunnable(String taskName, Runnable delegate) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.taskName = taskName;
        this.$$delegate_0 = delegate;
    }

    public final String getTaskName() {
        return this.taskName;
    }
}
