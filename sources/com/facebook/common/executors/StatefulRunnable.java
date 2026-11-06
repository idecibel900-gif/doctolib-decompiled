package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StatefulRunnable implements Runnable {
    protected final AtomicInteger mState = new AtomicInteger(0);

    protected abstract void disposeResult(Object obj);

    protected abstract Object getResult();

    protected abstract void onCancellation();

    protected abstract void onFailure(Exception exc);

    protected abstract void onSuccess(Object obj);

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mState.compareAndSet(0, 1)) {
            try {
                Object result = getResult();
                this.mState.set(3);
                try {
                    onSuccess(result);
                } finally {
                    disposeResult(result);
                }
            } catch (Exception e) {
                this.mState.set(4);
                onFailure(e);
            }
        }
    }

    public void cancel() {
        if (this.mState.compareAndSet(0, 2)) {
            onCancellation();
        }
    }
}
