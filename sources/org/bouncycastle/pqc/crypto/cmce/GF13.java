package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.math.raw.Interleave;

/* JADX INFO: loaded from: classes5.dex */
final class GF13 extends GF {
    GF13() {
    }

    private short gf_sq2(short s) {
        return gf_reduce(Interleave.expand16to32(gf_reduce(Interleave.expand16to32(s))));
    }

    private short gf_sq2mul(short s, short s2) {
        long j = s;
        long j2 = s2;
        long j3 = (j2 << 18) * (64 & j);
        long j4 = j ^ (j << 21);
        long j5 = ((j2 << 15) * (j4 & 8589934624L)) ^ (((((j3 ^ ((268435457 & j4) * j2)) ^ ((j2 << 3) * (536870914 & j4))) ^ ((j2 << 6) * (1073741828 & j4))) ^ ((j2 << 9) * (2147483656L & j4))) ^ ((j2 << 12) * (4294967312L & j4)));
        long j6 = 2305834213120671744L & j5;
        long j7 = j5 ^ ((j6 >>> 26) ^ (((j6 >>> 18) ^ (j6 >>> 20)) ^ (j6 >>> 24)));
        long j8 = 8796025913344L & j7;
        return gf_reduce(((int) (j7 ^ ((j8 >>> 26) ^ (((j8 >>> 18) ^ (j8 >>> 20)) ^ (j8 >>> 24))))) & 67108863);
    }

    private short gf_sqmul(short s, short s2) {
        long j = s;
        long j2 = s2;
        long j3 = (j2 << 6) * (64 & j);
        long j4 = j ^ (j << 7);
        long j5 = ((j2 << 5) * (j4 & 524320)) ^ (((((j3 ^ ((16385 & j4) * j2)) ^ ((j2 << 1) * (32770 & j4))) ^ ((j2 << 2) * (65540 & j4))) ^ ((j2 << 3) * (131080 & j4))) ^ ((j2 << 4) * (262160 & j4)));
        long j6 = 137371844608L & j5;
        return gf_reduce(((int) (j5 ^ ((j6 >>> 26) ^ (((j6 >>> 18) ^ (j6 >>> 20)) ^ (j6 >>> 24))))) & 67108863);
    }

    protected short gf_frac(short s, short s2) {
        short sGf_sqmul = gf_sqmul(s, s);
        short sGf_sq2mul = gf_sq2mul(sGf_sqmul, sGf_sqmul);
        return gf_sqmul(gf_sq2mul(gf_sq2(gf_sq2mul(gf_sq2(sGf_sq2mul), sGf_sq2mul)), sGf_sq2mul), s2);
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    protected short gf_inv(short s) {
        return gf_frac(s, (short) 1);
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    protected short gf_mul(short s, short s2) {
        int i = (s2 & 1) * s;
        for (int i2 = 1; i2 < 13; i2++) {
            i ^= ((1 << i2) & s2) * s;
        }
        return gf_reduce(i);
    }

    protected short gf_reduce(int i) {
        int i2 = i & 8191;
        int i3 = i >>> 13;
        int i4 = ((i3 << 4) ^ (i3 << 3)) ^ (i3 << 1);
        int i5 = i4 >>> 13;
        return (short) ((((i3 ^ i2) ^ i5) ^ (i4 & 8191)) ^ (((i5 << 4) ^ (i5 << 3)) ^ (i5 << 1)));
    }
}
