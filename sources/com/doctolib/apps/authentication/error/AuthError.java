package com.doctolib.apps.authentication.error;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthError extends Exception {
    private final AppAuthErrorCode code;
    private final Throwable underlyingAuthError;

    public /* synthetic */ AuthError(AppAuthErrorCode appAuthErrorCode, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appAuthErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    public final AppAuthErrorCode getCode() {
        return this.code;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthError(AppAuthErrorCode code, String str, Throwable th) {
        super(str, th);
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.underlyingAuthError = th;
    }

    public final String getStringValue() {
        return this.code.getValue();
    }

    public final String getErrorMessage() {
        String message = getMessage();
        return message == null ? this.code.getDefaultMessage() : message;
    }

    @Override // java.lang.Throwable
    public String toString() {
        String str = "AuthError(" + getStringValue() + "): " + getErrorMessage();
        Throwable th = this.underlyingAuthError;
        if (th == null) {
            return str;
        }
        return ((Object) str) + " [underlying: " + th + "]";
    }
}
