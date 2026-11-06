package org.bouncycastle.pqc.legacy.math.linearalgebra;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GoppaCode {
    public static GF2Matrix createCanonicalCheckMatrix(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int degree = gF2mField.getDegree();
        int i = 1;
        int i2 = 1 << degree;
        int degree2 = polynomialGF2mSmallM.getDegree();
        int i3 = 0;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, degree2, i2);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, degree2, i2);
        for (int i4 = 0; i4 < i2; i4++) {
            iArr2[0][i4] = gF2mField.inverse(polynomialGF2mSmallM.evaluateAt(i4));
        }
        for (int i5 = 1; i5 < degree2; i5++) {
            for (int i6 = 0; i6 < i2; i6++) {
                iArr2[i5][i6] = gF2mField.mult(iArr2[i5 - 1][i6], i6);
            }
        }
        for (int i7 = 0; i7 < degree2; i7++) {
            for (int i8 = i3; i8 < i2; i8++) {
                int i9 = i3;
                while (i9 <= i7) {
                    int[] iArr3 = iArr[i7];
                    iArr3[i8] = gF2mField.add(iArr3[i8], gF2mField.mult(iArr2[i9][i8], polynomialGF2mSmallM.getCoefficient((degree2 + i9) - i7)));
                    i9++;
                    i = i;
                    i3 = i3;
                }
            }
        }
        int i10 = i;
        int i11 = i3;
        int[] iArr4 = new int[2];
        iArr4[i10] = (i2 + 31) >>> 5;
        iArr4[i11] = degree2 * degree;
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) cls, iArr4);
        for (int i12 = i11; i12 < i2; i12++) {
            int i13 = i12 >>> 5;
            int i14 = i10 << (i12 & 31);
            for (int i15 = i11; i15 < degree2; i15++) {
                int i16 = iArr[i15][i12];
                for (int i17 = i11; i17 < degree; i17++) {
                    if (((i16 >>> i17) & 1) != 0) {
                        int[] iArr6 = iArr5[(((i15 + 1) * degree) - i17) - 1];
                        iArr6[i13] = iArr6[i13] ^ i14;
                    }
                }
            }
        }
        return new GF2Matrix(i2, iArr5);
    }
}
