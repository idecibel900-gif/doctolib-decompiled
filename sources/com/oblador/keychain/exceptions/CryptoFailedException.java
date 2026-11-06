package com.oblador.keychain.exceptions;

import java.security.GeneralSecurityException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class CryptoFailedException extends GeneralSecurityException {
    public static final Companion Companion = new Companion(null);

    public CryptoFailedException(String str) {
        super(str);
    }

    public CryptoFailedException(String str, Throwable th) {
        super(str, th);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void reThrowOnError(Throwable th) throws CryptoFailedException {
            if (th == null) {
                return;
            }
            if (th instanceof CryptoFailedException) {
                throw ((CryptoFailedException) th);
            }
            throw new CryptoFailedException("Wrapped error: " + th.getMessage(), th);
        }
    }
}
