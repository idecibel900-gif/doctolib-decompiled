package com.oblador.keychain;

import com.oblador.keychain.cipherStorage.CipherStorage;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public interface PrefsStorageBase {
    public static final Companion Companion = Companion.$$INSTANCE;

    ResultSet getEncryptedEntry(String str);

    Set getUsedCipherNames();

    void removeEntry(String str);

    void storeEncryptedEntry(String str, CipherStorage.EncryptionResult encryptionResult);

    public static final class ResultSet extends CipherStorage.CipherResult {
        public final String cipherStorageName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResultSet(String cipherStorageName, byte[] bArr, byte[] bArr2) {
            super(bArr, bArr2);
            Intrinsics.checkNotNullParameter(cipherStorageName, "cipherStorageName");
            this.cipherStorageName = cipherStorageName;
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final String getKeyForUsername(String service) {
            Intrinsics.checkNotNullParameter(service, "service");
            return service + ":u";
        }

        public final String getKeyForPassword(String service) {
            Intrinsics.checkNotNullParameter(service, "service");
            return service + ":p";
        }

        public final String getKeyForCipherStorage(String service) {
            Intrinsics.checkNotNullParameter(service, "service");
            return service + ":c";
        }

        public final boolean isKeyForCipherStorage(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return StringsKt.endsWith$default(key, ":c", false, 2, (Object) null);
        }
    }
}
