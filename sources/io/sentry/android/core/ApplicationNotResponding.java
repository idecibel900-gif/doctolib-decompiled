package io.sentry.android.core;

import io.sentry.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class ApplicationNotResponding extends RuntimeException {
    private final Thread thread;

    ApplicationNotResponding(String str) {
        super(str);
        this.thread = null;
    }

    ApplicationNotResponding(String str, Thread thread) {
        super(str);
        Thread thread2 = (Thread) Objects.requireNonNull(thread, "Thread must be provided.");
        this.thread = thread2;
        setStackTrace(thread2.getStackTrace());
    }

    public Thread getThread() {
        return this.thread;
    }
}
