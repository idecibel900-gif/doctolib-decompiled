package com.oblador.keychain.resultHandler;

import android.os.Looper;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ResultHandlerInteractiveBiometricManualRetry extends ResultHandlerInteractiveBiometric implements ResultHandler {
    private CipherStorage.DecryptionResult decryptionResult;
    private boolean didFailBiometric;
    private CipherStorage.EncryptionResult encryptionResult;
    private Throwable error;
    private BiometricPrompt presentedPrompt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultHandlerInteractiveBiometricManualRetry(ReactApplicationContext reactContext, CipherStorage storage, BiometricPrompt.PromptInfo promptInfo) {
        super(reactContext, storage, promptInfo);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(promptInfo, "promptInfo");
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric, com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.DecryptionResult getDecryptionResult() {
        return this.decryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric
    public void setDecryptionResult(CipherStorage.DecryptionResult decryptionResult) {
        this.decryptionResult = decryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric, com.oblador.keychain.resultHandler.ResultHandler
    public CipherStorage.EncryptionResult getEncryptionResult() {
        return this.encryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric
    public void setEncryptionResult(CipherStorage.EncryptionResult encryptionResult) {
        this.encryptionResult = encryptionResult;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric, com.oblador.keychain.resultHandler.ResultHandler
    public Throwable getError() {
        return this.error;
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric
    public void setError(Throwable th) {
        this.error = th;
    }

    private final void cancelPresentedAuthentication() {
        getLOG_TAG();
        BiometricPrompt biometricPrompt = this.presentedPrompt;
        if (biometricPrompt == null) {
            return;
        }
        if (biometricPrompt != null) {
            try {
                biometricPrompt.cancelAuthentication();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.presentedPrompt = null;
            }
        }
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric, androidx.biometric.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence errString) {
        Intrinsics.checkNotNullParameter(errString, "errString");
        if (this.didFailBiometric) {
            this.presentedPrompt = null;
            this.didFailBiometric = false;
            retryAuthentication();
            return;
        }
        super.onAuthenticationError(i, errString);
    }

    @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationFailed() {
        getLOG_TAG();
        if (this.presentedPrompt != null) {
            this.didFailBiometric = true;
            cancelPresentedAuthentication();
        }
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric, androidx.biometric.BiometricPrompt.AuthenticationCallback
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.presentedPrompt = null;
        this.didFailBiometric = false;
        super.onAuthenticationSucceeded(result);
    }

    @Override // com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometric
    public void startAuthentication() {
        FragmentActivity currentActivity = getCurrentActivity();
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            currentActivity.runOnUiThread(new Runnable() { // from class: com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometricManualRetry$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.startAuthentication();
                }
            });
            waitResult();
        } else {
            this.presentedPrompt = authenticateWithPrompt(currentActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void retryAuthentication() {
        getLOG_TAG();
        FragmentActivity currentActivity = getCurrentActivity();
        if (!Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            currentActivity.runOnUiThread(new Runnable() { // from class: com.oblador.keychain.resultHandler.ResultHandlerInteractiveBiometricManualRetry$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.retryAuthentication();
                }
            });
        } else {
            this.presentedPrompt = authenticateWithPrompt(currentActivity);
        }
    }
}
