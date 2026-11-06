package org.bouncycastle.pqc.legacy.math.linearalgebra;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IntegerFunctions {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private static final int[] SMALL_PRIMES = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
    private static SecureRandom sr = null;
    private static final int[] jacobiTable = {0, 1, 0, -1, 0, -1, 0, 1};

    public static int ceilLog256(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 8;
        }
        return i2;
    }
}
