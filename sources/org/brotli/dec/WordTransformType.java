package org.brotli.dec;

/* JADX INFO: loaded from: classes5.dex */
abstract class WordTransformType {
    static int getOmitFirst(int i) {
        if (i >= 12) {
            return i - 11;
        }
        return 0;
    }

    static int getOmitLast(int i) {
        if (i <= 9) {
            return i;
        }
        return 0;
    }
}
