package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {

    private static class DefaultProperties implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;
        private final CryptoServicePurpose purpose;

        public DefaultProperties(int i, String str, CryptoServicePurpose cryptoServicePurpose) {
            this.bitsOfSecurity = i;
            this.algorithmName = str;
            this.purpose = cryptoServicePurpose;
        }

        @Override // org.bouncycastle.crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    private static class DefaultPropertiesWithPRF implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;
        private final int prfBitsOfSecurity;
        private final CryptoServicePurpose purpose;

        public DefaultPropertiesWithPRF(int i, int i2, String str, CryptoServicePurpose cryptoServicePurpose) {
            this.bitsOfSecurity = i;
            this.prfBitsOfSecurity = i2;
            this.algorithmName = str;
            this.purpose = cryptoServicePurpose;
        }

        @Override // org.bouncycastle.crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    static CryptoServiceProperties getDefaultProperties(Digest digest, int i, CryptoServicePurpose cryptoServicePurpose) {
        return new DefaultPropertiesWithPRF(digest.getDigestSize() * 4, i, digest.getAlgorithmName(), cryptoServicePurpose);
    }

    static CryptoServiceProperties getDefaultProperties(Digest digest, CryptoServicePurpose cryptoServicePurpose) {
        return new DefaultProperties(digest.getDigestSize() * 4, digest.getAlgorithmName(), cryptoServicePurpose);
    }
}
