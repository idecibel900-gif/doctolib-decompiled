package com.google.crypto.tink.subtle;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes3.dex */
public interface EngineWrapper {
    Object getInstance(String str, Provider provider);

    public static class TCipher implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Cipher getInstance(String str, Provider provider) {
            if (provider == null) {
                return Cipher.getInstance(str);
            }
            return Cipher.getInstance(str, provider);
        }
    }

    public static class TMac implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Mac getInstance(String str, Provider provider) {
            if (provider == null) {
                return Mac.getInstance(str);
            }
            return Mac.getInstance(str, provider);
        }
    }

    public static class TKeyPairGenerator implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyPairGenerator getInstance(String str, Provider provider) {
            if (provider == null) {
                return KeyPairGenerator.getInstance(str);
            }
            return KeyPairGenerator.getInstance(str, provider);
        }
    }

    public static class TMessageDigest implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public MessageDigest getInstance(String str, Provider provider) {
            if (provider == null) {
                return MessageDigest.getInstance(str);
            }
            return MessageDigest.getInstance(str, provider);
        }
    }

    public static class TSignature implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public Signature getInstance(String str, Provider provider) {
            if (provider == null) {
                return Signature.getInstance(str);
            }
            return Signature.getInstance(str, provider);
        }
    }

    public static class TKeyFactory implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyFactory getInstance(String str, Provider provider) {
            if (provider == null) {
                return KeyFactory.getInstance(str);
            }
            return KeyFactory.getInstance(str, provider);
        }
    }

    public static class TKeyAgreement implements EngineWrapper {
        @Override // com.google.crypto.tink.subtle.EngineWrapper
        public KeyAgreement getInstance(String str, Provider provider) {
            if (provider == null) {
                return KeyAgreement.getInstance(str);
            }
            return KeyAgreement.getInstance(str, provider);
        }
    }
}
