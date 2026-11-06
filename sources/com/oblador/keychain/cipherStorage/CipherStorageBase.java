package com.oblador.keychain.cipherStorage;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.security.keystore.UserNotAuthenticatedException;
import com.adjust.sdk.Constants;
import com.oblador.keychain.DeviceAvailability;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.UnrecoverableKeyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CipherStorageBase implements CipherStorage {
    public static final Companion Companion = new Companion(null);
    private static final Charset UTF8;
    private final String LOG_TAG;
    private final Context applicationContext;
    private transient KeyStore cachedKeyStore;

    public interface DecryptBytesHandler {
        void initialize(Cipher cipher, Key key, InputStream inputStream);
    }

    public interface EncryptStringHandler {
        void initialize(Cipher cipher, Key key, OutputStream outputStream);
    }

    protected abstract Key generateKey(KeyGenParameterSpec keyGenParameterSpec);

    protected abstract String getEncryptionAlgorithm();

    protected abstract String getEncryptionTransformation();

    protected abstract KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str);

    protected abstract KeyInfo getKeyInfo(Key key);

    public CipherStorageBase(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.LOG_TAG = CipherStorageBase.class.getSimpleName();
    }

    protected final String getLOG_TAG() {
        return this.LOG_TAG;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Charset getUTF8() {
            return CipherStorageBase.UTF8;
        }

        public final String getDefaultAliasIfEmpty(String str, String fallback) {
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            return (str == null || str.length() == 0) ? fallback : str;
        }
    }

    static {
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        UTF8 = charsetForName;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public int getCapabilityLevel() {
        return ((isAuthSupported() ? 1 : 0) * 1000) + getMinSupportedApiLevel();
    }

    public String getDefaultAliasServiceName() {
        return getCipherStorageName();
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public void removeKey(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        String defaultAliasIfEmpty = Companion.getDefaultAliasIfEmpty(alias, getDefaultAliasServiceName());
        KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
        try {
            if (keyStoreAndLoad.containsAlias(defaultAliasIfEmpty)) {
                keyStoreAndLoad.deleteEntry(defaultAliasIfEmpty);
            }
        } catch (GeneralSecurityException unused) {
        }
    }

    @Override // com.oblador.keychain.cipherStorage.CipherStorage
    public Set getAllKeys() throws KeyStoreAccessException {
        KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
        try {
            return new HashSet(Collections.list(keyStoreAndLoad.aliases()));
        } catch (KeyStoreException e) {
            throw new KeyStoreAccessException("Error accessing aliases in keystore " + keyStoreAndLoad, e);
        }
    }

    public final Cipher getCachedInstance() {
        return CipherCache.INSTANCE.getCipher(getEncryptionTransformation());
    }

    protected final void throwIfInsufficientLevel(SecurityLevel level) throws CryptoFailedException {
        Intrinsics.checkNotNullParameter(level, "level");
        if (securityLevel().satisfiesSafetyThreshold(level)) {
            return;
        }
        throw new CryptoFailedException("Insufficient security level (wants " + level + "; got " + securityLevel() + ")");
    }

    protected final Key extractGeneratedKey(String safeAlias, SecurityLevel level, AtomicInteger retries) throws CryptoFailedException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyStoreAccessException {
        Key keyExtractKey;
        Intrinsics.checkNotNullParameter(safeAlias, "safeAlias");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(retries, "retries");
        do {
            KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
            if (!keyStoreAndLoad.containsAlias(safeAlias)) {
                generateKeyAndStoreUnderAlias(safeAlias, level);
            } else {
                keyExtractKey = null;
                Key key = keyStoreAndLoad.getKey(safeAlias, null);
                if (key != null && !isKeyAlgorithmSupported(key, getEncryptionAlgorithm())) {
                    getEncryptionTransformation();
                    keyStoreAndLoad.deleteEntry(safeAlias);
                    generateKeyAndStoreUnderAlias(safeAlias, level);
                }
            }
            keyExtractKey = extractKey(keyStoreAndLoad, safeAlias, retries);
        } while (keyExtractKey == null);
        return keyExtractKey;
    }

    protected final Key extractKey(KeyStore keyStore, String safeAlias, AtomicInteger retry) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyStoreAccessException {
        Intrinsics.checkNotNullParameter(keyStore, "keyStore");
        Intrinsics.checkNotNullParameter(safeAlias, "safeAlias");
        Intrinsics.checkNotNullParameter(retry, "retry");
        try {
            Key key = keyStore.getKey(safeAlias, null);
            if (key != null) {
                return key;
            }
            throw new KeyStoreAccessException("Empty key extracted!");
        } catch (UnrecoverableKeyException e) {
            if (retry.getAndDecrement() > 0) {
                keyStore.deleteEntry(safeAlias);
                return null;
            }
            throw e;
        }
    }

    protected final boolean validateKeySecurityLevel(SecurityLevel level, Key key) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(key, "key");
        return getSecurityLevel(key).satisfiesSafetyThreshold(level);
    }

    protected final SecurityLevel getSecurityLevel(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (getKeyInfo(key).isInsideSecureHardware()) {
            return SecurityLevel.SECURE_HARDWARE;
        }
        return SecurityLevel.SECURE_SOFTWARE;
    }

    public final KeyStore getKeyStoreAndLoad() {
        if (this.cachedKeyStore == null) {
            synchronized (this) {
                try {
                    if (this.cachedKeyStore == null) {
                        try {
                            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                            keyStore.load(null);
                            this.cachedKeyStore = keyStore;
                        } catch (Throwable th) {
                            throw new KeyStoreAccessException("Could not access Keystore", th);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        KeyStore keyStore2 = this.cachedKeyStore;
        Intrinsics.checkNotNull(keyStore2);
        return keyStore2;
    }

    public byte[] encryptString(Key key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return encryptString(key, value, Defaults.INSTANCE.getEncrypt());
    }

    public String decryptBytes(Key key, byte[] bytes) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decryptBytes(key, bytes, Defaults.INSTANCE.getDecrypt());
    }

    protected final byte[] encryptString(Key key, String value, EncryptStringHandler encryptStringHandler) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Cipher cachedInstance = getCachedInstance();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (encryptStringHandler != null) {
                try {
                    encryptStringHandler.initialize(cachedInstance, key, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th);
                        throw th2;
                    }
                }
            }
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cachedInstance);
            try {
                byte[] bytes = value.getBytes(UTF8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                cipherOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cipherOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return byteArray;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(cipherOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th5.getMessage();
            throw th5;
        }
    }

    protected String decryptBytes(Key key, byte[] bytes, DecryptBytesHandler decryptBytesHandler) {
        Throwable cause;
        String message;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Cipher cachedInstance = getCachedInstance();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decryptBytesHandler != null) {
                    try {
                        decryptBytesHandler.initialize(cachedInstance, key, byteArrayInputStream);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                }
                try {
                    byteArrayOutputStream.write(cachedInstance.doFinal(ByteStreamsKt.readBytes(byteArrayInputStream)));
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    String str = new String(byteArray, UTF8);
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    return str;
                } catch (Exception e) {
                    if (e instanceof UserNotAuthenticatedException) {
                        throw e;
                    }
                    if (CipherStorageBase$$ExternalSyntheticApiModelOutline0.m(e.getCause()) && (cause = e.getCause()) != null && (message = cause.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "Key user not authenticated", false, 2, (Object) null)) {
                        throw new UserNotAuthenticatedException();
                    }
                    if (e instanceof AEADBadTagException) {
                        throw new CryptoFailedException("Decryption failed: Authentication tag verification failed. This usually indicates that the encrypted data was modified, corrupted, or is being decrypted with the wrong key.", e);
                    }
                    throw e;
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayInputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th5.getMessage();
            throw th5;
        }
    }

    public final void generateKeyAndStoreUnderAlias(String alias, SecurityLevel requiredLevel) throws CryptoFailedException {
        Key keyTryGenerateStrongBoxSecurityKey;
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(requiredLevel, "requiredLevel");
        boolean zIsStrongboxAvailable = DeviceAvailability.INSTANCE.isStrongboxAvailable(this.applicationContext);
        if (zIsStrongboxAvailable) {
            try {
                keyTryGenerateStrongBoxSecurityKey = tryGenerateStrongBoxSecurityKey(alias);
            } catch (GeneralSecurityException | ProviderException unused) {
                keyTryGenerateStrongBoxSecurityKey = null;
            }
        } else {
            keyTryGenerateStrongBoxSecurityKey = null;
        }
        if (keyTryGenerateStrongBoxSecurityKey == null || !zIsStrongboxAvailable) {
            keyTryGenerateStrongBoxSecurityKey = tryGenerateRegularSecurityKey(alias);
        }
        Intrinsics.checkNotNull(keyTryGenerateStrongBoxSecurityKey);
        if (!validateKeySecurityLevel(requiredLevel, keyTryGenerateStrongBoxSecurityKey)) {
            throw new CryptoFailedException("Cannot generate keys with required security guarantees");
        }
    }

    protected final boolean isKeyAlgorithmSupported(Key key, String expectedAlgorithm) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(expectedAlgorithm, "expectedAlgorithm");
        if (!StringsKt.equals(key.getAlgorithm(), expectedAlgorithm, true)) {
            return false;
        }
        try {
            KeyInfo keyInfo = getKeyInfo(key);
            String[] blockModes = keyInfo.getBlockModes();
            Intrinsics.checkNotNullExpressionValue(blockModes, "getBlockModes(...)");
            if (keyInfo.isUserAuthenticationRequired() != isAuthSupported()) {
                return false;
            }
            String str = (String) StringsKt.split$default((CharSequence) getEncryptionTransformation(), new String[]{"/"}, false, 0, 6, (Object) null).get(1);
            for (String str2 : blockModes) {
                if (StringsKt.equals(str2, str, true)) {
                    return true;
                }
            }
            return false;
        } catch (GeneralSecurityException e) {
            e.getMessage();
            return false;
        }
    }

    protected final Key tryGenerateRegularSecurityKey(String alias) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        KeyGenParameterSpec keyGenParameterSpecBuild = getKeyGenSpecBuilder(alias).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        return generateKey(keyGenParameterSpecBuild);
    }

    protected final Key tryGenerateStrongBoxSecurityKey(String alias) throws KeyStoreAccessException {
        Intrinsics.checkNotNullParameter(alias, "alias");
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            throw new KeyStoreAccessException("Strong box security keystore is not supported for old API" + i + ".");
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = getKeyGenSpecBuilder(alias).setIsStrongBoxBacked(true).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "build(...)");
        return generateKey(keyGenParameterSpecBuild);
    }

    public static final class Defaults {
        public static final Defaults INSTANCE = new Defaults();
        private static final EncryptStringHandler encrypt = new EncryptStringHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageBase$Defaults$$ExternalSyntheticLambda0
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.EncryptStringHandler
            public final void initialize(Cipher cipher, Key key, OutputStream outputStream) throws InvalidKeyException {
                CipherStorageBase.Defaults.encrypt$lambda$0(cipher, key, outputStream);
            }
        };
        private static final DecryptBytesHandler decrypt = new DecryptBytesHandler() { // from class: com.oblador.keychain.cipherStorage.CipherStorageBase$Defaults$$ExternalSyntheticLambda1
            @Override // com.oblador.keychain.cipherStorage.CipherStorageBase.DecryptBytesHandler
            public final void initialize(Cipher cipher, Key key, InputStream inputStream) throws InvalidKeyException {
                CipherStorageBase.Defaults.decrypt$lambda$1(cipher, key, inputStream);
            }
        };

        private Defaults() {
        }

        public final EncryptStringHandler getEncrypt() {
            return encrypt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void encrypt$lambda$0(Cipher cipher, Key key, OutputStream outputStream) throws InvalidKeyException {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(outputStream, "<unused var>");
            cipher.init(1, key);
        }

        public final DecryptBytesHandler getDecrypt() {
            return decrypt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void decrypt$lambda$1(Cipher cipher, Key key, InputStream inputStream) throws InvalidKeyException {
            Intrinsics.checkNotNullParameter(cipher, "cipher");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(inputStream, "<unused var>");
            cipher.init(2, key);
        }
    }
}
