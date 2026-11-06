package org.bouncycastle.pqc.crypto.frodo;

/* JADX INFO: loaded from: classes5.dex */
abstract class FrodoMatrixGenerator {
    int n;
    int q;

    static class Aes128MatrixGenerator extends FrodoMatrixGenerator {
        public Aes128MatrixGenerator(int i, int i2) {
            super(i, i2);
        }
    }

    static class Shake128MatrixGenerator extends FrodoMatrixGenerator {
        public Shake128MatrixGenerator(int i, int i2) {
            super(i, i2);
        }
    }

    public FrodoMatrixGenerator(int i, int i2) {
        this.n = i;
        this.q = i2;
    }
}
