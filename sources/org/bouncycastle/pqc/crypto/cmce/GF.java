package org.bouncycastle.pqc.crypto.cmce;

/* JADX INFO: loaded from: classes5.dex */
abstract class GF {
    GF() {
    }

    protected abstract short gf_inv(short s);

    protected abstract short gf_mul(short s, short s2);
}
