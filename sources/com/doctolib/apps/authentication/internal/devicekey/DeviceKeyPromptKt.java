package com.doctolib.apps.authentication.internal.devicekey;

import android.os.Build;
import androidx.biometric.BiometricPrompt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeviceKeyPromptKt {
    public static final BiometricPrompt.PromptInfo buildPromptInfo(String title, String subtitle, String description, String negativeButtonText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        BiometricPrompt.PromptInfo.Builder description2 = new BiometricPrompt.PromptInfo.Builder().setTitle(title).setSubtitle(subtitle).setDescription(description);
        if (Build.VERSION.SDK_INT >= 30) {
            description2.setAllowedAuthenticators(32783);
        } else {
            description2.setAllowedAuthenticators(15);
            description2.setNegativeButtonText(negativeButtonText);
        }
        BiometricPrompt.PromptInfo promptInfoBuild = description2.build();
        Intrinsics.checkNotNullExpressionValue(promptInfoBuild, "build(...)");
        return promptInfoBuild;
    }
}
