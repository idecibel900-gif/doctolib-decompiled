package com.oblador.keychain;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import androidx.biometric.BiometricManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DeviceAvailability {
    public static final DeviceAvailability INSTANCE = new DeviceAvailability();

    private DeviceAvailability() {
    }

    public final boolean isStrongboxAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 28) {
            return context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore");
        }
        return false;
    }

    public final boolean isStrongBiometricAuthAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiometricManager.from(context).canAuthenticate(15) == 0;
    }

    public final boolean isDevicePasscodeAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 30 && BiometricManager.from(context).canAuthenticate(32768) == 0;
    }

    public final boolean isFingerprintAuthAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
    }

    public final boolean isFaceAuthAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.biometrics.face");
    }

    public final boolean isIrisAuthAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.biometrics.iris");
    }

    public static final boolean isPermissionsGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (!((KeyguardManager) systemService).isKeyguardSecure()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return context.checkSelfPermission("android.permission.USE_BIOMETRIC") == 0;
        }
        return context.checkSelfPermission("android.permission.USE_FINGERPRINT") == 0;
    }
}
