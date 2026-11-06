package com.doctolib.apps.authentication.internal.devicekey;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyInfo;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.model.DeviceKey;
import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.interfaces.ECPublicKey;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeyKeystore {
    private final Lazy keyStore$delegate;
    private final PackageManager packageManager;

    public DeviceKeyKeystore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        this.packageManager = packageManager;
        this.keyStore$delegate = LazyKt.lazy(new Function0() { // from class: com.doctolib.apps.authentication.internal.devicekey.DeviceKeyKeystore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceKeyKeystore.keyStore_delegate$lambda$1();
            }
        });
    }

    private final KeyStore getKeyStore() {
        Object value = this.keyStore$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (KeyStore) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyStore keyStore_delegate$lambda$1() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    public final DeviceKey createKey(DeviceKeySlot slot, DeviceKeyUserAuthentication userAuthentication, DeviceKeyStorage storage) throws AuthError, KeyStoreException {
        Exception exc;
        DeviceKeyStorage deviceKeyStorage;
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        Intrinsics.checkNotNullParameter(storage, "storage");
        KeyPair keyPairGenerateWithCascade = generateWithCascade(DeviceKeyKeystoreKt.aliasFor(slot), userAuthentication);
        try {
            PrivateKey privateKey = keyPairGenerateWithCascade.getPrivate();
            Intrinsics.checkNotNullExpressionValue(privateKey, "getPrivate(...)");
            if (isHardwareBacked(privateKey)) {
                try {
                    deviceKeyStorage = DeviceKeyStorage.HARDWARE_BACKED_ONLY;
                } catch (Exception e) {
                    exc = e;
                    deleteKey(slot);
                    throw new AuthError(AppAuthErrorCode.RUNTIME_EXCEPTION, "Failed to read the device key security level", exc);
                }
            } else {
                deviceKeyStorage = DeviceKeyStorage.HARDWARE_BACKED_OR_SOFTWARE;
            }
            DeviceKeyStorage deviceKeyStorage2 = deviceKeyStorage;
            DeviceKeyStorage deviceKeyStorage3 = DeviceKeyStorage.HARDWARE_BACKED_ONLY;
            if (storage == deviceKeyStorage3 && deviceKeyStorage2 != deviceKeyStorage3) {
                deleteKey(slot);
                throw new AuthError(AppAuthErrorCode.DEVICE_KEY_POLICY_UNAVAILABLE, "The device produced a software-backed key and hardware backing was required", null, 4, null);
            }
            DeviceKeyCrypto deviceKeyCrypto = DeviceKeyCrypto.INSTANCE;
            PublicKey publicKey = keyPairGenerateWithCascade.getPublic();
            Intrinsics.checkNotNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
            DeviceKeyCrypto.PublicJwk publicJwk = deviceKeyCrypto.publicJwk((ECPublicKey) publicKey);
            return new DeviceKey(slot, publicJwk.getKid(), publicJwk.getJson(), null, userAuthentication, deviceKeyStorage2);
        } catch (Exception e2) {
            exc = e2;
        }
    }

    public final boolean containsKey(DeviceKeySlot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return getKeyStore().containsAlias(DeviceKeyKeystoreKt.aliasFor(slot));
    }

    public final void deleteKey(DeviceKeySlot slot) throws KeyStoreException {
        Intrinsics.checkNotNullParameter(slot, "slot");
        String strAliasFor = DeviceKeyKeystoreKt.aliasFor(slot);
        if (getKeyStore().containsAlias(strAliasFor)) {
            getKeyStore().deleteEntry(strAliasFor);
        }
    }

    public final Signature initSign(DeviceKeySlot slot) throws AuthError, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException, KeyStoreException {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Key key = getKeyStore().getKey(DeviceKeyKeystoreKt.aliasFor(slot), null);
        PrivateKey privateKey = key instanceof PrivateKey ? (PrivateKey) key : null;
        if (privateKey == null) {
            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_INVALIDATED, "The device key is no longer present in the keystore", null, 4, null);
        }
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        Intrinsics.checkNotNullExpressionValue(signature, "apply(...)");
        return signature;
    }

    private final KeyPair generateWithCascade(String str, DeviceKeyUserAuthentication deviceKeyUserAuthentication) throws AuthError {
        if (Build.VERSION.SDK_INT >= 28 && this.packageManager.hasSystemFeature("android.hardware.strongbox_keystore")) {
            try {
                try {
                    return generate(str, deviceKeyUserAuthentication, true);
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    Result.m5243constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Exception unused) {
                Result.Companion companion2 = Result.Companion;
                if (getKeyStore().containsAlias(str)) {
                    getKeyStore().deleteEntry(str);
                }
                Result.m5243constructorimpl(Unit.INSTANCE);
                return generate(str, deviceKeyUserAuthentication, false);
            }
        }
        try {
            return generate(str, deviceKeyUserAuthentication, false);
        } catch (InvalidAlgorithmParameterException e) {
            throw new AuthError(AppAuthErrorCode.DEVICE_KEY_POLICY_UNAVAILABLE, "The device cannot honour the requested user authentication level", e);
        } catch (Exception e2) {
            throw new AuthError(AppAuthErrorCode.RUNTIME_EXCEPTION, "Failed to generate the device key", e2);
        }
    }

    private final KeyPair generate(String str, DeviceKeyUserAuthentication deviceKeyUserAuthentication, boolean z) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        keyPairGenerator.initialize(DeviceKeyKeystoreKt.buildKeyGenSpec(str, deviceKeyUserAuthentication, z));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        Intrinsics.checkNotNullExpressionValue(keyPairGenerateKeyPair, "generateKeyPair(...)");
        return keyPairGenerateKeyPair;
    }

    private final boolean isHardwareBacked(PrivateKey privateKey) {
        KeyInfo keyInfo = (KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class);
        if (Build.VERSION.SDK_INT >= 31) {
            return keyInfo.getSecurityLevel() == 2 || keyInfo.getSecurityLevel() == 1 || keyInfo.getSecurityLevel() == -1;
        }
        return keyInfo.isInsideSecureHardware();
    }
}
