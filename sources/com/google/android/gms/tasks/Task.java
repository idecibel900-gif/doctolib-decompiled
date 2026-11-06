package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Task<TResult> {
    public abstract Task addOnFailureListener(OnFailureListener onFailureListener);

    public abstract Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener);

    public abstract Task addOnSuccessListener(OnSuccessListener onSuccessListener);

    public abstract Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener);

    public abstract Exception getException();

    public abstract Object getResult();

    public abstract Object getResult(Class cls);

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public Task onSuccessTask(SuccessContinuation successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public Task continueWith(Executor executor, Continuation continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public Task continueWithTask(Executor executor, Continuation continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    public Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }
}
