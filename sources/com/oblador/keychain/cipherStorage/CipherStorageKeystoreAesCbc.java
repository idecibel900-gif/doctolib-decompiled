package com.oblador.keychain.cipherStorage;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.resultHandler.ResultHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
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
import javax.crypto.spec.IvParameterSpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CipherStorageKeystoreAesCbc extends CipherStorageBase {
    public static final Companion Companion = new Companion(null);

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public int getMinSupportedApiLevel() {
        return 23;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public boolean isAuthSupported() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherStorageKeystoreAesCbc(ReactApplicationContext reactContext) {
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
    public String getCipherStorageName() {
        return "KeystoreAESCBC";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase, com.oblador.keychain.cipherStorage.CipherStorage
    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionAlgorithm() {
        return "AES";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String getEncryptionTransformation() {
        return "AES/CBC/PKCS7Padding";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    public String getDefaultAliasServiceName() {
        return "RN_KEYCHAIN_DEFAULT_ALIAS";
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void encrypt(ResultHandler handler, String alias, String username, String password, SecurityLevel level) throws CryptoFailedException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(level, "level");
        throwIfInsufficientLevel(level);
        try {
            Key keyExtractGeneratedKey = extractGeneratedKey(CipherStorageBase.Companion.getDefaultAliasIfEmpty(alias, getDefaultAliasServiceName()), level, new AtomicInteger(1));
            handler.onEncrypt(new CipherStorage.EncryptionResult(encryptString(keyExtractGeneratedKey, username), encryptString(keyExtractGeneratedKey, password), this), null);
        } catch (GeneralSecurityException e) {
            throw new CryptoFailedException("Could not encrypt data with alias: " + alias, e);
        } catch (Throwable th) {
            throw new CryptoFailedException("Unknown error with alias: " + alias + ", error: " + th.getMessage(), th);
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void decrypt(ResultHandler handler, String alias, byte[] username, byte[] password, SecurityLevel level) throws CryptoFailedException {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(level, "level");
        throwIfInsufficientLevel(level);
        try {
            Key keyExtractGeneratedKey = extractGeneratedKey(CipherStorageBase.Companion.getDefaultAliasIfEmpty(alias, getDefaultAliasServiceName()), level, new AtomicInteger(1));
            handler.onDecrypt(new CipherStorage.DecryptionResult(decryptBytes(keyExtractGeneratedKey, username), decryptBytes(keyExtractGeneratedKey, password), getSecurityLevel(keyExtractGeneratedKey)), null);
        } catch (GeneralSecurityException e) {
            throw new CryptoFailedException("Could not decrypt data with alias: " + alias, e);
        } catch (Throwable th) {
            handler.onDecrypt(null, th);
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(alias, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setRandomizedEncryptionRequired(true).setKeySize(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        Intrinsics.checkNotNullExpressionValue(keySize, "setKeySize(...)");
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

    @Override // com.oblador.keychain.cipherStorage.CipherStorageBase
    protected String decryptBytes(Key key, byte[] bytes, CipherStorageBase.DecryptBytesHandler decryptBytesHandler) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Cipher cachedInstance = getCachedInstance();
        try {
            byte[] bArr = new byte[16];
            if (16 >= bytes.length) {
                throw new IOException("Insufficient length of input data for IV extracting.");
            }
            System.arraycopy(bytes, 0, bArr, 0, 16);
            cachedInstance.init(2, key, new IvParameterSpec(bArr));
            byte[] bArrDoFinal = cachedInstance.doFinal(bytes, 16, bytes.length - 16);
            Intrinsics.checkNotNull(bArrDoFinal);
            return new String(bArrDoFinal, CipherStorageBase.Companion.getUTF8());
        } catch (Throwable th) {
            getLOG_TAG();
            th.getMessage();
            throw th;
        }
    }

    public static final class IV {
        public static final IV INSTANCE = new IV();
        private static final CipherStorageBase.EncryptStringHandler encrypt = new CipherStorageBase.EncryptStringHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc$IV$$ExternalSyntheticLambda0
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.EncryptStringHandler
            public final void initialize(Cipher cipher, Key key, OutputStream outputStream) throws InvalidKeyException, IOException {
                CipherStorageKeystoreAesCbc.IV.encrypt$lambda$0(cipher, key, outputStream);
            }
        };
        private static final CipherStorageBase.DecryptBytesHandler decrypt = new CipherStorageBase.DecryptBytesHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc$IV$$ExternalSyntheticLambda1
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.DecryptBytesHandler
            public final void initialize(Cipher cipher, Key key, InputStream inputStream) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
                CipherStorageKeystoreAesCbc.IV.decrypt$lambda$1(cipher, key, inputStream);
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
            byte[] bArr = new byte[16];
            if (input.read(bArr, 0, 16) != 16) {
                throw new IOException("Input stream has insufficient data.");
            }
            cipher.init(2, key, new IvParameterSpec(bArr));
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
