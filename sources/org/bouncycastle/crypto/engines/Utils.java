package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CryptoServicePurpose;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {
    static CryptoServicePurpose getPurpose(boolean z) {
        return z ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION;
    }
}
