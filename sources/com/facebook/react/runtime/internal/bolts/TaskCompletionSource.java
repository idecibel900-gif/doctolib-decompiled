package com.facebook.react.runtime.internal.bolts;

/* JADX INFO: loaded from: classes3.dex */
public final class TaskCompletionSource {
    private final Task task = new Task();

    public final Task getTask() {
        return this.task;
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled$ReactAndroid_release();
    }

    public final boolean trySetResult(Object obj) {
        return this.task.trySetResult$ReactAndroid_release(obj);
    }

    public final boolean trySetError(Exception exc) {
        return this.task.trySetError$ReactAndroid_release(exc);
    }

    public final void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void setResult(Object obj) {
        if (!trySetResult(obj)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final void setError(Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
