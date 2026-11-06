package org.bouncycastle.crypto.constraints;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultServiceProperties implements CryptoServiceProperties {
    private final String algorithm;
    private final int bitsOfSecurity;
    private final Object params;
    private final CryptoServicePurpose purpose;

    public DefaultServiceProperties(String str, int i) {
        this(str, i, null, CryptoServicePurpose.ANY);
    }

    public DefaultServiceProperties(String str, int i, Object obj, CryptoServicePurpose cryptoServicePurpose) {
        this.algorithm = str;
        this.bitsOfSecurity = i;
        this.params = obj;
        if (obj instanceof CryptoServicePurpose) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.purpose = cryptoServicePurpose;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        return this.algorithm;
    }
}
