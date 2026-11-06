package org.bouncycastle.pqc.legacy.math.linearalgebra;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PolynomialRingGF2 {
    public static int degree(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static int gcd(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = remainder(i4, i);
        }
    }

    public static boolean isIrreducible(int i) {
        if (i == 0) {
            return false;
        }
        int iDegree = degree(i) >>> 1;
        int iModMultiply = 2;
        for (int i2 = 0; i2 < iDegree; i2++) {
            iModMultiply = modMultiply(iModMultiply, iModMultiply, i);
            if (gcd(iModMultiply ^ 2, i) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int modMultiply(int i, int i2, int i3) {
        int iRemainder = remainder(i, i3);
        int iRemainder2 = remainder(i2, i3);
        int i4 = 0;
        if (iRemainder2 != 0) {
            int iDegree = 1 << degree(i3);
            while (iRemainder != 0) {
                if (((byte) (iRemainder & 1)) == 1) {
                    i4 ^= iRemainder2;
                }
                iRemainder >>>= 1;
                iRemainder2 <<= 1;
                if (iRemainder2 >= iDegree) {
                    iRemainder2 ^= i3;
                }
            }
        }
        return i4;
    }

    public static int remainder(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (degree(i) >= degree(i2)) {
            i ^= i2 << (degree(i) - degree(i2));
        }
        return i;
    }
}
