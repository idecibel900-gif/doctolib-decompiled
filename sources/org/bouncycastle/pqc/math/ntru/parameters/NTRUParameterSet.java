package org.bouncycastle.pqc.math.ntru.parameters;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NTRUParameterSet {
    private final int logQ;
    private final int n;
    private final int prfKeyBytes;
    private final int seedBytes;
    private final int sharedKeyBytes;

    public NTRUParameterSet(int i, int i2, int i3, int i4, int i5) {
        this.n = i;
        this.logQ = i2;
        this.seedBytes = i3;
        this.prfKeyBytes = i4;
        this.sharedKeyBytes = i5;
    }
}
