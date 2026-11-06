package com.oblador.keychain.resultHandler;

import android.os.Build;
import androidx.biometric.BiometricPrompt;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ResultHandlerProvider {
    public static final ResultHandlerProvider INSTANCE = new ResultHandlerProvider();
    private static final String[] ONE_PLUS_MODELS_WITHOUT_BIOMETRIC_BUG = {"A0001", "ONE A2001", "ONE A2003", "ONE A2005", "ONE E1001", "ONE E1003", "ONE E1005", "ONEPLUS A3000", "ONEPLUS SM-A3000", "ONEPLUS A3003", "ONEPLUS A3010", "ONEPLUS A5000", "ONEPLUS A5010", "ONEPLUS A6000", "ONEPLUS A6003"};

    private ResultHandlerProvider() {
    }

    private final boolean hasOnePlusBiometricBug() {
        return StringsKt.equals(Build.BRAND, "oneplus", true) && !ArraysKt.contains(ONE_PLUS_MODELS_WITHOUT_BIOMETRIC_BUG, Build.MODEL);
    }

    public final ResultHandler getHandler(ReactApplicationContext reactContext, CipherStorage storage, BiometricPrompt.PromptInfo promptInfo) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(promptInfo, "promptInfo");
        if (storage.isAuthSupported()) {
            if (hasOnePlusBiometricBug()) {
                return new ResultHandlerInteractiveBiometricManualRetry(reactContext, storage, promptInfo);
            }
            return new ResultHandlerInteractiveBiometric(reactContext, storage, promptInfo);
        }
        return new ResultHandlerNonInteractive();
    }
}
