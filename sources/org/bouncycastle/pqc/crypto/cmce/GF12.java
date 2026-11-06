package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.math.raw.Interleave;

/* JADX INFO: loaded from: classes5.dex */
final class GF12 extends GF {
    GF12() {
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    protected short gf_inv(short s) {
        short sGf_mul = gf_mul(gf_sq(s), s);
        short sGf_mul2 = gf_mul(gf_sq(gf_sq(sGf_mul)), sGf_mul);
        return gf_sq(gf_mul(gf_sq(gf_mul(gf_sq(gf_sq(gf_mul(gf_sq(gf_sq(gf_sq(gf_sq(sGf_mul2)))), sGf_mul2))), sGf_mul)), s));
    }

    @Override // org.bouncycastle.pqc.crypto.cmce.GF
    protected short gf_mul(short s, short s2) {
        int i = (s2 & 1) * s;
        for (int i2 = 1; i2 < 12; i2++) {
            i ^= ((1 << i2) & s2) * s;
        }
        return gf_reduce(i);
    }

    protected short gf_reduce(int i) {
        return (short) ((i >>> 21) ^ ((((i & 4095) ^ (i >>> 12)) ^ ((2093056 & i) >>> 9)) ^ ((14680064 & i) >>> 18)));
    }

    protected short gf_sq(short s) {
        return gf_reduce(Interleave.expand16to32(s));
    }
}
