package org.bouncycastle.pqc.legacy.crypto.qtesla;

/* JADX INFO: loaded from: classes5.dex */
public abstract class QTESLASecurityCategory {
    static int getPrivateSize(int i) {
        if (i == 5) {
            return 5224;
        }
        if (i == 6) {
            return 12392;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    static int getPublicSize(int i) {
        if (i == 5) {
            return 14880;
        }
        if (i == 6) {
            return 38432;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }
}
