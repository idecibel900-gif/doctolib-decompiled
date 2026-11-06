package io.sentry.util;

import io.sentry.ISentryLifecycleToken;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class AutoClosableReentrantLock extends ReentrantLock {
    public ISentryLifecycleToken acquire() {
        lock();
        return new AutoClosableReentrantLockLifecycleToken(this);
    }

    static final class AutoClosableReentrantLockLifecycleToken implements ISentryLifecycleToken {
        private final ReentrantLock lock;

        AutoClosableReentrantLockLifecycleToken(ReentrantLock reentrantLock) {
            this.lock = reentrantLock;
        }

        @Override // io.sentry.ISentryLifecycleToken, java.lang.AutoCloseable
        public void close() {
            this.lock.unlock();
        }
    }
}
