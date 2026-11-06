package com.oblador.keychain.cipherStorage;

import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.resultHandler.ResultHandler;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface CipherStorage {
    void decrypt(ResultHandler resultHandler, String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel);

    void encrypt(ResultHandler resultHandler, String str, String str2, String str3, SecurityLevel securityLevel);

    Set getAllKeys();

    int getCapabilityLevel();

    String getCipherStorageName();

    int getMinSupportedApiLevel();

    boolean isAuthSupported();

    void removeKey(String str);

    SecurityLevel securityLevel();

    public static abstract class CipherResult {
        private final Object password;
        private final Object username;

        public CipherResult(Object obj, Object obj2) {
            this.username = obj;
            this.password = obj2;
        }

        public final Object getPassword() {
            return this.password;
        }

        public final Object getUsername() {
            return this.username;
        }
    }

    public static final class EncryptionResult extends CipherResult {
        private final String cipherName;

        public final String getCipherName() {
            return this.cipherName;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EncryptionResult(byte[] username, byte[] password, String cipherName) {
            super(username, password);
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(cipherName, "cipherName");
            this.cipherName = cipherName;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EncryptionResult(byte[] username, byte[] password, CipherStorage cipherStorage) {
            this(username, password, cipherStorage.getCipherStorageName());
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(cipherStorage, "cipherStorage");
        }
    }

    public static final class DecryptionResult extends CipherResult {
        private final SecurityLevel securityLevel;

        public /* synthetic */ DecryptionResult(String str, String str2, SecurityLevel securityLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? SecurityLevel.ANY : securityLevel);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecryptionResult(String username, String password, SecurityLevel securityLevel) {
            super(username, password);
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(securityLevel, "securityLevel");
            this.securityLevel = securityLevel;
        }

        public final SecurityLevel getSecurityLevel() {
            return this.securityLevel;
        }
    }
}
