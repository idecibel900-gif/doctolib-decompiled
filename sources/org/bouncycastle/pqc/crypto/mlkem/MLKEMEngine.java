package org.bouncycastle.pqc.crypto.mlkem;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class MLKEMEngine {
    private final int CryptoBytes;
    private final int CryptoCipherTextBytes;
    private final int CryptoPublicKeyBytes;
    private final int CryptoSecretKeyBytes;
    private final int KyberCipherTextBytes;
    private final int KyberEta1;
    private final int KyberIndCpaBytes;
    private final int KyberIndCpaPublicKeyBytes;
    private final int KyberIndCpaSecretKeyBytes;
    private final int KyberK;
    private final int KyberPolyCompressedBytes;
    private final int KyberPolyVecBytes;
    private final int KyberPolyVecCompressedBytes;
    private final int KyberPublicKeyBytes;
    private final int KyberSecretKeyBytes;
    private MLKEMIndCpa indCpa;
    private final int sessionKeyLength;
    private final Symmetric symmetric;

    public MLKEMEngine(int i) {
        int i2;
        this.KyberK = i;
        if (i != 2) {
            if (i == 3) {
                this.KyberEta1 = 2;
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException("K: " + i + " is not supported for Crystals Kyber");
                }
                this.KyberEta1 = 2;
                this.KyberPolyCompressedBytes = 160;
                i2 = i * 352;
            }
            this.KyberPolyVecCompressedBytes = i2;
            this.sessionKeyLength = 32;
            int i3 = i * 384;
            this.KyberPolyVecBytes = i3;
            int i4 = i3 + 32;
            this.KyberIndCpaPublicKeyBytes = i4;
            this.KyberIndCpaSecretKeyBytes = i3;
            int i5 = this.KyberPolyVecCompressedBytes + this.KyberPolyCompressedBytes;
            this.KyberIndCpaBytes = i5;
            this.KyberPublicKeyBytes = i4;
            int i6 = i3 + i4 + 64;
            this.KyberSecretKeyBytes = i6;
            this.KyberCipherTextBytes = i5;
            this.CryptoBytes = 32;
            this.CryptoSecretKeyBytes = i6;
            this.CryptoPublicKeyBytes = i4;
            this.CryptoCipherTextBytes = i5;
            this.symmetric = new Symmetric.ShakeSymmetric();
            this.indCpa = new MLKEMIndCpa(this);
        }
        this.KyberEta1 = 3;
        this.KyberPolyCompressedBytes = 128;
        i2 = i * 320;
        this.KyberPolyVecCompressedBytes = i2;
        this.sessionKeyLength = 32;
        int i7 = i * 384;
        this.KyberPolyVecBytes = i7;
        int i8 = i7 + 32;
        this.KyberIndCpaPublicKeyBytes = i8;
        this.KyberIndCpaSecretKeyBytes = i7;
        int i9 = this.KyberPolyVecCompressedBytes + this.KyberPolyCompressedBytes;
        this.KyberIndCpaBytes = i9;
        this.KyberPublicKeyBytes = i8;
        int i10 = i7 + i8 + 64;
        this.KyberSecretKeyBytes = i10;
        this.KyberCipherTextBytes = i9;
        this.CryptoBytes = 32;
        this.CryptoSecretKeyBytes = i10;
        this.CryptoPublicKeyBytes = i8;
        this.CryptoCipherTextBytes = i9;
        this.symmetric = new Symmetric.ShakeSymmetric();
        this.indCpa = new MLKEMIndCpa(this);
    }

    public static int getKyberEta2() {
        return 2;
    }

    public byte[][] generateKemKeyPairInternal(byte[] bArr, byte[] bArr2) {
        byte[][] bArrGenerateKeyPair = this.indCpa.generateKeyPair(bArr);
        int i = this.KyberIndCpaSecretKeyBytes;
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArrGenerateKeyPair[1], 0, bArr3, 0, i);
        byte[] bArr4 = new byte[32];
        this.symmetric.hash_h(bArr4, bArrGenerateKeyPair[0], 0);
        int i2 = this.KyberIndCpaPublicKeyBytes;
        byte[] bArr5 = new byte[i2];
        System.arraycopy(bArrGenerateKeyPair[0], 0, bArr5, 0, i2);
        int i3 = i2 - 32;
        return new byte[][]{Arrays.copyOfRange(bArr5, 0, i3), Arrays.copyOfRange(bArr5, i3, i2), bArr3, bArr4, bArr2, Arrays.concatenate(bArr, bArr2)};
    }

    public int getKyberEta1() {
        return this.KyberEta1;
    }

    public int getKyberIndCpaBytes() {
        return this.KyberIndCpaBytes;
    }

    public int getKyberIndCpaPublicKeyBytes() {
        return this.KyberIndCpaPublicKeyBytes;
    }

    public int getKyberIndCpaSecretKeyBytes() {
        return this.KyberIndCpaSecretKeyBytes;
    }

    public int getKyberK() {
        return this.KyberK;
    }

    public int getKyberPolyCompressedBytes() {
        return this.KyberPolyCompressedBytes;
    }

    public int getKyberPolyVecBytes() {
        return this.KyberPolyVecBytes;
    }

    public int getKyberPolyVecCompressedBytes() {
        return this.KyberPolyVecCompressedBytes;
    }

    public int getKyberPublicKeyBytes() {
        return this.KyberPublicKeyBytes;
    }

    public Symmetric getSymmetric() {
        return this.symmetric;
    }
}
