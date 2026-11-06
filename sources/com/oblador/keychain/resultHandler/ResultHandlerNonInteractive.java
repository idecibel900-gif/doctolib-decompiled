package com.oblador.keychain.resultHandler;

import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.exceptions.CryptoFailedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ResultHandlerNonInteractive implements ResultHandler {
    private CipherStorage.DecryptionResult decryptionResult;
    private CipherStorage.EncryptionResult encryptionResult;
    private Throwable error;

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.DecryptionResult getDecryptionResult() {
        return this.decryptionResult;
    }

    public void setDecryptionResult(CipherStorage.DecryptionResult decryptionResult) {
        this.decryptionResult = decryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.EncryptionResult getEncryptionResult() {
        return this.encryptionResult;
    }

    public void setEncryptionResult(CipherStorage.EncryptionResult encryptionResult) {
        this.encryptionResult = encryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public Throwable getError() {
        return this.error;
    }

    public void setError(Throwable th) {
        this.error = th;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void askAccessPermissions(CryptoContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        onDecrypt(null, new CryptoFailedException("Non-interactive decryption mode."));
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th) {
        setDecryptionResult(decryptionResult);
        setError(th);
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandler
    public void onEncrypt(CipherStorage.EncryptionResult encryptionResult, Throwable th) {
        setEncryptionResult(encryptionResult);
        setError(th);
    }
}
