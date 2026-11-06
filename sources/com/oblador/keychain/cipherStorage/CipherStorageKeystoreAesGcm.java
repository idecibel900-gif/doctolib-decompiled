package com.oblador.keychain.cipherStorage;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.security.keystore.UserNotAuthenticatedException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.resultHandler.CryptoContext;
import com.oblador.keychain.resultHandler.CryptoOperation;
import com.oblador.keychain.resultHandler.ResultHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public final class CipherStorageKeystoreAesGcm extends CipherStorageBase {
    public static final Companion Companion = new Companion(null);
    private final boolean requiresAuth;

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public int getMinSupportedApiLevel() {
        return 23;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherStorageKeystoreAesGcm(ReactApplicationContext reactContext, boolean z) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.requiresAuth = z;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public String getCipherStorageName() {
        boolean z = this.requiresAuth;
        if (z) {
            return "KeystoreAESGCM";
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return "KeystoreAESGCM_NoAuth";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase, com.oblador.keychain.cipherStorage.CipherStorage
    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public boolean isAuthSupported() {
        return this.requiresAuth;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionAlgorithm() {
        return "AES";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionTransformation() {
        return "AES/GCM/NoPadding";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void encrypt(ResultHandler handler, String alias, String username, String password, SecurityLevel level) throws CryptoFailedException {
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
                    handler.onEncrypt(new CipherStorage.EncryptionResult(encryptString(keyExtractGeneratedKey, username), encryptString(keyExtractGeneratedKey, password), this), null);
                } catch (UserNotAuthenticatedException e) {
                    userNotAuthenticatedException = e;
                    key = keyExtractGeneratedKey;
                    getLOG_TAG();
                    userNotAuthenticatedException.getMessage();
                    Intrinsics.checkNotNull(key);
                    Charset charset = Charsets.UTF_8;
                    byte[] bytes = password.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    byte[] bytes2 = username.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                    handler.askAccessPermissions(new CryptoContext(defaultAliasIfEmpty, key, bytes, bytes2, CryptoOperation.ENCRYPT));
                }
            } catch (UserNotAuthenticatedException e2) {
                userNotAuthenticatedException = e2;
                key = null;
            }
        } catch (Throwable th) {
            handler.onEncrypt(null, th);
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

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(alias, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setRandomizedEncryptionRequired(true).setKeySize(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        Intrinsics.checkNotNullExpressionValue(keySize, "setKeySize(...)");
        if (this.requiresAuth) {
            keySize.setUserAuthenticationRequired(true);
            if (Build.VERSION.SDK_INT >= 30) {
                keySize.setUserAuthenticationParameters(5, 3);
                return keySize;
            }
            keySize.setUserAuthenticationValidityDurationSeconds(5);
        }
        return keySize;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected KeyInfo getKeyInfo(Key key) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(key, "key");
        KeySpec keySpec = SecretKeyFactory.getInstance(key.getAlgorithm(), "AndroidKeyStore").getKeySpec((SecretKey) key, KeyInfo.class);
        Intrinsics.checkNotNullExpressionValue(keySpec, "getKeySpec(...)");
        return (KeyInfo) keySpec;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected Key generateKey(KeyGenParameterSpec spec) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(spec, "spec");
        KeyGenerator keyGenerator = KeyGenerator.getInstance(getEncryptionAlgorithm(), "AndroidKeyStore");
        keyGenerator.init(spec);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    public static final class IV {
        public static final IV INSTANCE = new IV();
        private static final CipherStorageBase.EncryptStringHandler encrypt = new CipherStorageBase.EncryptStringHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesGcm$IV$$ExternalSyntheticLambda0
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.EncryptStringHandler
            public final void initialize(Cipher cipher, Key key, OutputStream outputStream) throws InvalidKeyException, IOException {
                CipherStorageKeystoreAesGcm.IV.encrypt$lambda$0(cipher, key, outputStream);
            }
        };
        private static final CipherStorageBase.DecryptBytesHandler decrypt = new CipherStorageBase.DecryptBytesHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesGcm$IV$$ExternalSyntheticLambda1
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.DecryptBytesHandler
            public final void initialize(Cipher cipher, Key key, InputStream inputStream) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
                CipherStorageKeystoreAesGcm.IV.decrypt$lambda$1(cipher, key, inputStream);
            }
        };

        private IV() {
        }

        public final CipherStorageBase.EncryptStringHandler getEncrypt() {
            return encrypt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void encrypt$lambda$0(Cipher cipher, Key key, OutputStream output) throws InvalidKeyException, IOException {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(output, "output");
            cipher.init(1, key);
            byte[] iv = cipher.getIV();
            output.write(iv, 0, iv.length);
        }

        public final CipherStorageBase.DecryptBytesHandler getDecrypt() {
            return decrypt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void decrypt$lambda$1(Cipher cipher, Key key, InputStream input) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(input, "input");
            byte[] bArr = new byte[12];
            if (input.read(bArr, 0, 12) != 12) {
                throw new IOException("Input stream has insufficient data.");
            }
            cipher.init(2, key, new GCMParameterSpec(128, bArr));
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    public byte[] encryptString(Key key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return encryptString(key, value, IV.INSTANCE.getEncrypt());
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    public String decryptBytes(Key key, byte[] bytes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decryptBytes(key, bytes, IV.INSTANCE.getDecrypt());
    }
}
