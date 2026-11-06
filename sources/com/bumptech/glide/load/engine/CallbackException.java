package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes3.dex */
final class CallbackException extends RuntimeException {
    CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
