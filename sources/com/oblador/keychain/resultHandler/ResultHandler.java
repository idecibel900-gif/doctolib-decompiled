package com.oblador.keychain.resultHandler;

import com.oblador.keychain.cipherStorage.CipherStorage;

/* JADX INFO: loaded from: classes4.dex */
public interface ResultHandler {
    void askAccessPermissions(CryptoContext cryptoContext);

    CipherStorage.DecryptionResult getDecryptionResult();

    CipherStorage.EncryptionResult getEncryptionResult();

    Throwable getError();

    void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th);

    void onEncrypt(CipherStorage.EncryptionResult encryptionResult, Throwable th);
}
