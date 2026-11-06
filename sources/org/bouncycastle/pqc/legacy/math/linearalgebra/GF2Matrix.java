package org.bouncycastle.pqc.legacy.math.linearalgebra;

import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class GF2Matrix extends Matrix {
    private int length;
    private int[][] matrix;

    public GF2Matrix(int i, int[][] iArr) {
        int[] iArr2 = iArr[0];
        if (iArr2.length != ((i + 31) >> 5)) {
            throw new ArithmeticException("Int array does not match given number of columns.");
        }
        this.numColumns = i;
        this.numRows = iArr.length;
        this.length = iArr2.length;
        int i2 = i & 31;
        int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
        for (int i4 = 0; i4 < this.numRows; i4++) {
            int[] iArr3 = iArr[i4];
            int i5 = this.length - 1;
            iArr3[i5] = iArr3[i5] & i3;
        }
        this.matrix = iArr;
    }

    public GF2Matrix(GF2Matrix gF2Matrix) {
        this.numColumns = gF2Matrix.getNumColumns();
        this.numRows = gF2Matrix.getNumRows();
        this.length = gF2Matrix.length;
        this.matrix = new int[gF2Matrix.matrix.length][];
        int i = 0;
        while (true) {
            int[][] iArr = this.matrix;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = IntUtils.clone(gF2Matrix.matrix[i]);
            i++;
        }
    }

    public GF2Matrix(byte[] bArr) {
        if (bArr.length < 9) {
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        this.numRows = LittleEndianConversions.OS2IP(bArr, 0);
        int iOS2IP = LittleEndianConversions.OS2IP(bArr, 4);
        this.numColumns = iOS2IP;
        int i = this.numRows;
        int i2 = ((iOS2IP + 7) >>> 3) * i;
        if (i > 0) {
            int i3 = 8;
            if (i2 == bArr.length - 8) {
                int i4 = (iOS2IP + 31) >>> 5;
                this.length = i4;
                this.matrix = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, i4);
                int i5 = this.numColumns;
                int i6 = i5 >> 5;
                int i7 = i5 & 31;
                for (int i8 = 0; i8 < this.numRows; i8++) {
                    int i9 = 0;
                    while (i9 < i6) {
                        this.matrix[i8][i9] = LittleEndianConversions.OS2IP(bArr, i3);
                        i9++;
                        i3 += 4;
                    }
                    int i10 = 0;
                    while (i10 < i7) {
                        int[] iArr = this.matrix[i8];
                        iArr[i6] = ((bArr[i3] & 255) << i10) ^ iArr[i6];
                        i10 += 8;
                        i3++;
                    }
                }
                return;
            }
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2Matrix)) {
            return false;
        }
        GF2Matrix gF2Matrix = (GF2Matrix) obj;
        if (this.numRows != gF2Matrix.numRows || this.numColumns != gF2Matrix.numColumns || this.length != gF2Matrix.length) {
            return false;
        }
        for (int i = 0; i < this.numRows; i++) {
            if (!IntUtils.equals(this.matrix[i], gF2Matrix.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public byte[] getEncoded() {
        int i = (this.numColumns + 7) >>> 3;
        int i2 = this.numRows;
        int i3 = 8;
        byte[] bArr = new byte[(i * i2) + 8];
        LittleEndianConversions.I2OSP(i2, bArr, 0);
        LittleEndianConversions.I2OSP(this.numColumns, bArr, 4);
        int i4 = this.numColumns;
        int i5 = i4 >>> 5;
        int i6 = i4 & 31;
        for (int i7 = 0; i7 < this.numRows; i7++) {
            int i8 = 0;
            while (i8 < i5) {
                LittleEndianConversions.I2OSP(this.matrix[i7][i8], bArr, i3);
                i8++;
                i3 += 4;
            }
            int i9 = 0;
            while (i9 < i6) {
                bArr[i3] = (byte) ((this.matrix[i7][i5] >>> i9) & 255);
                i9 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public int hashCode() {
        int iHashCode = (((this.numRows * 31) + this.numColumns) * 31) + this.length;
        for (int i = 0; i < this.numRows; i++) {
            iHashCode = (iHashCode * 31) + Arrays.hashCode(this.matrix[i]);
        }
        return iHashCode;
    }

    public String toString() {
        int i = this.numColumns & 31;
        int i2 = this.length;
        if (i != 0) {
            i2--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.numRows; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.matrix[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.matrix[i3][this.length - 1];
            for (int i8 = 0; i8 < i; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
