package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public final class SettableFuture extends AbstractFuture.TrustedFuture {
    public static SettableFuture create() {
        return new SettableFuture();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(Object obj) {
        return super.set(obj);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    private SettableFuture() {
    }
}
