package com.oblador.keychain.exceptions;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyStoreAccessException extends GeneralSecurityException {
    public KeyStoreAccessException(String str) {
        super(str);
    }

    public KeyStoreAccessException(String str, Throwable th) {
        super(str, th);
    }
}
