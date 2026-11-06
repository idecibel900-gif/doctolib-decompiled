package io.sentry.util.thread;

/* JADX INFO: loaded from: classes5.dex */
public interface IThreadChecker {
    long currentThreadSystemId();

    String getCurrentThreadName();

    boolean isMainThread();
}
