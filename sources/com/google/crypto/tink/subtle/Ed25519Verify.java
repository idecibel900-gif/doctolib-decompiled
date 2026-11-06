package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class Ed25519Verify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final Bytes publicKey;

    public Ed25519Verify(byte[] bArr) {
        if (!FIPS.isCompatible()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given public key's length is not %s.", 32));
        }
        this.publicKey = Bytes.copyFrom(bArr);
    }

    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            throw new GeneralSecurityException(String.format("The length of the signature is not %s.", 64));
        }
        if (!Ed25519.verify(bArr2, bArr, this.publicKey.toByteArray())) {
            throw new GeneralSecurityException("Signature check failed.");
        }
    }
}
