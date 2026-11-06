package io.sentry.util;

import io.sentry.ISentryLifecycleToken;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyEvaluator {
    private final Evaluator evaluator;
    private volatile Object value = null;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();

    public interface Evaluator {
        Object evaluate();
    }

    public LazyEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public Object getValue() {
        if (this.value == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
            try {
                if (this.value == null) {
                    this.value = this.evaluator.evaluate();
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
        return this.value;
    }

    public void setValue(Object obj) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.value = obj;
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

    public void resetValue() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.value = null;
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
}
