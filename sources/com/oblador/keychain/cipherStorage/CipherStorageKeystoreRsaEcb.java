package com.oblador.keychain.cipherStorage;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.security.keystore.UserNotAuthenticatedException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import com.oblador.keychain.resultHandler.CryptoContext;
import com.oblador.keychain.resultHandler.CryptoOperation;
import com.oblador.keychain.resultHandler.ResultHandler;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.NoSuchPaddingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CipherStorageKeystoreRsaEcb extends CipherStorageBase {
    public static final Companion Companion = new Companion(null);

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public int getMinSupportedApiLevel() {
        return 23;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public boolean isAuthSupported() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherStorageKeystoreRsaEcb(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void encrypt(ResultHandler handler, String alias, String username, String password, SecurityLevel level) throws CryptoFailedException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(level, "level");
        throwIfInsufficientLevel(level);
        String defaultAliasIfEmpty = CipherStorageBase.Companion.getDefaultAliasIfEmpty(alias, getDefaultAliasServiceName());
        try {
            extractGeneratedKey(defaultAliasIfEmpty, level, new AtomicInteger(1));
            handler.onEncrypt(innerEncryptedCredentials(defaultAliasIfEmpty, password, username), null);
        } catch (Exception e) {
            if ((e instanceof NoSuchAlgorithmException) || (e instanceof InvalidKeySpecException) || (e instanceof NoSuchPaddingException) || (e instanceof InvalidKeyException)) {
                throw new CryptoFailedException("Could not encrypt data for service " + alias, e);
            }
            if ((e instanceof KeyStoreException) || (e instanceof KeyStoreAccessException)) {
                throw new CryptoFailedException("Could not access Keystore for service " + alias, e);
            }
            if (e instanceof IOException) {
                throw new CryptoFailedException("I/O error: " + e.getMessage(), e);
            }
            throw new CryptoFailedException("Unknown error: " + e.getMessage(), e);
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void decrypt(ResultHandler handler, String alias, byte[] username, byte[] password, SecurityLevel level) throws CryptoFailedException {
        UserNotAuthenticatedException userNotAuthenticatedException;
        Key key;
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(level, "level");
        throwIfInsufficientLevel(level);
        String defaultAliasIfEmpty = CipherStorageBase.Companion.getDefaultAliasIfEmpty(alias, getDefaultAliasServiceName());
        try {
            try {
                Key keyExtractGeneratedKey = extractGeneratedKey(defaultAliasIfEmpty, level, new AtomicInteger(1));
                try {
                    handler.onDecrypt(new CipherStorage.DecryptionResult(decryptBytes(keyExtractGeneratedKey, username), decryptBytes(keyExtractGeneratedKey, password), null, 4, null), null);
                } catch (UserNotAuthenticatedException e) {
                    userNotAuthenticatedException = e;
                    key = keyExtractGeneratedKey;
                    getLOG_TAG();
                    userNotAuthenticatedException.getMessage();
                    Intrinsics.checkNotNull(key);
                    handler.askAccessPermissions(new CryptoContext(defaultAliasIfEmpty, key, password, username, CryptoOperation.DECRYPT));
                }
            } catch (UserNotAuthenticatedException e2) {
                userNotAuthenticatedException = e2;
                key = null;
            }
        } catch (Throwable th) {
            handler.onDecrypt(null, th);
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public String getCipherStorageName() {
        return "KeystoreRSAECB";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionAlgorithm() {
        return "RSA";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionTransformation() {
        return "RSA/ECB/PKCS1Padding";
    }

    private final CipherStorage.EncryptionResult innerEncryptedCredentials(String str, String str2, String str3) throws GeneralSecurityException {
        Certificate certificate = getKeyStoreAndLoad().getCertificate(str);
        if (certificate == null) {
            throw new GeneralSecurityException("Certificate is null for alias " + str);
        }
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
        Intrinsics.checkNotNull(publicKeyGeneratePublic);
        return new CipherStorage.EncryptionResult(encryptString(publicKeyGeneratePublic, str3), encryptString(publicKeyGeneratePublic, str2), this);
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(alias, 3).setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setRandomizedEncryptionRequired(true).setUserAuthenticationRequired(true).setKeySize(2048);
        Intrinsics.checkNotNullExpressionValue(keySize, "setKeySize(...)");
        if (Build.VERSION.SDK_INT >= 30) {
            keySize.setUserAuthenticationParameters(5, 3);
            return keySize;
        }
        keySize.setUserAuthenticationValidityDurationSeconds(5);
        return keySize;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected KeyInfo getKeyInfo(Key key) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(key, "key");
        KeySpec keySpec = KeyFactory.getInstance(key.getAlgorithm(), "AndroidKeyStore").getKeySpec(key, KeyInfo.class);
        Intrinsics.checkNotNullExpressionValue(keySpec, "getKeySpec(...)");
        return (KeyInfo) keySpec;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected Key generateKey(KeyGenParameterSpec spec) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(spec, "spec");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(getEncryptionAlgorithm(), "AndroidKeyStore");
        keyPairGenerator.initialize(spec);
        PrivateKey privateKey = keyPairGenerator.generateKeyPair().getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "getPrivate(...)");
        return privateKey;
    }
}
