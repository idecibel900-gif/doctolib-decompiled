package com.doctolib.apps.authentication.internal.devicekey;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import java.security.spec.ECGenParameterSpec;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeviceKeyKeystoreKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceKeySlot.values().length];
            try {
                iArr[DeviceKeySlot.DEVICE_BOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String aliasFor(DeviceKeySlot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        if (WhenMappings.$EnumSwitchMapping$0[slot.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return "doctolib_apps_auth_device_bound";
    }

    public static final KeyGenParameterSpec buildKeyGenSpec(String alias, DeviceKeyUserAuthentication userAuthentication, boolean z) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        KeyGenParameterSpec.Builder digests = new KeyGenParameterSpec.Builder(alias, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256");
        if (userAuthentication == DeviceKeyUserAuthentication.USER_PRESENCE) {
            digests.setUserAuthenticationRequired(true);
            if (Build.VERSION.SDK_INT >= 30) {
                digests.setUserAuthenticationParameters(0, 3);
            } else {
                digests.setUserAuthenticationValidityDurationSeconds(-1);
            }
            digests.setInvalidatedByBiometricEnrollment(false);
        }
        if (z && Build.VERSION.SDK_INT >= 28) {
            digests.setIsStrongBoxBacked(true);
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = digests.build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        return keyGenParameterSpecBuild;
    }
}
