package org.bouncycastle.pqc.legacy.math.linearalgebra;

/* JADX INFO: loaded from: classes5.dex */
public class PolynomialGF2mSmallM {
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i) {
        this.field = gF2mField;
        this.degree = i;
        int[] iArr = new int[i + 1];
        this.coefficients = iArr;
        iArr[i] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.field = gF2mField;
        int i = 8;
        int i2 = 1;
        while (gF2mField.getDegree() > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 != 0) {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
        this.coefficients = new int[bArr.length / i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.coefficients;
            if (i3 >= iArr.length) {
                if (iArr.length != 1 && iArr[iArr.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
                computeDegree();
                return;
            }
            int i5 = 0;
            while (i5 < i) {
                int[] iArr2 = this.coefficients;
                iArr2[i3] = ((bArr[i4] & 255) << i5) ^ iArr2[i3];
                i5 += 8;
                i4++;
            }
            if (!this.field.isElementOfThisField(this.coefficients[i3])) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            i3++;
        }
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.field = gF2mField;
        this.coefficients = normalForm(iArr);
        computeDegree();
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = polynomialGF2mSmallM.field;
        this.degree = polynomialGF2mSmallM.degree;
        this.coefficients = IntUtils.clone(polynomialGF2mSmallM.coefficients);
    }

    private int[] add(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.field.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    private static int computeDegree(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    private void computeDegree() {
        int length = this.coefficients.length;
        do {
            this.degree = length - 1;
            length = this.degree;
            if (length < 0) {
                return;
            }
        } while (this.coefficients[length] == 0);
    }

    private static int headCoefficient(int[] iArr) {
        int iComputeDegree = computeDegree(iArr);
        if (iComputeDegree == -1) {
            return 0;
        }
        return iArr[iComputeDegree];
    }

    private static boolean isEqual(int[] iArr, int[] iArr2) {
        int iComputeDegree = computeDegree(iArr);
        if (iComputeDegree != computeDegree(iArr2)) {
            return false;
        }
        for (int i = 0; i <= iComputeDegree; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] mod(int[] iArr, int[] iArr2) {
        int iComputeDegree = computeDegree(iArr2);
        if (iComputeDegree == -1) {
            throw new ArithmeticException("Division by zero");
        }
        int length = iArr.length;
        int[] iArrAdd = new int[length];
        int iInverse = this.field.inverse(headCoefficient(iArr2));
        System.arraycopy(iArr, 0, iArrAdd, 0, length);
        while (iComputeDegree <= computeDegree(iArrAdd)) {
            iArrAdd = add(multWithElement(multWithMonomial(iArr2, computeDegree(iArrAdd) - iComputeDegree), this.field.mult(headCoefficient(iArrAdd), iInverse)), iArrAdd);
        }
        return iArrAdd;
    }

    private int[] multWithElement(int[] iArr, int i) {
        int iComputeDegree = computeDegree(iArr);
        if (iComputeDegree == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[iComputeDegree + 1];
        while (iComputeDegree >= 0) {
            iArr2[iComputeDegree] = this.field.mult(iArr[iComputeDegree], i);
            iComputeDegree--;
        }
        return iArr2;
    }

    private static int[] multWithMonomial(int[] iArr, int i) {
        int iComputeDegree = computeDegree(iArr);
        if (iComputeDegree == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[iComputeDegree + i + 1];
        System.arraycopy(iArr, 0, iArr2, i, iComputeDegree + 1);
        return iArr2;
    }

    private static int[] normalForm(int[] iArr) {
        int iComputeDegree = computeDegree(iArr);
        if (iComputeDegree == -1) {
            return new int[1];
        }
        int i = iComputeDegree + 1;
        if (iArr.length == i) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    public void addToThis(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.coefficients = add(this.coefficients, polynomialGF2mSmallM.coefficients);
        computeDegree();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PolynomialGF2mSmallM)) {
            PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
            if (this.field.equals(polynomialGF2mSmallM.field) && this.degree == polynomialGF2mSmallM.degree && isEqual(this.coefficients, polynomialGF2mSmallM.coefficients)) {
                return true;
            }
        }
        return false;
    }

    public int evaluateAt(int i) {
        int[] iArr = this.coefficients;
        int i2 = this.degree;
        int iMult = iArr[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            iMult = this.field.mult(iMult, i) ^ this.coefficients[i3];
        }
        return iMult;
    }

    public int getCoefficient(int i) {
        if (i < 0 || i > this.degree) {
            return 0;
        }
        return this.coefficients[i];
    }

    public int getDegree() {
        int[] iArr = this.coefficients;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i = 8;
        int i2 = 1;
        while (this.field.getDegree() > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[this.coefficients.length * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < this.coefficients.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.coefficients[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public int hashCode() {
        int iHashCode = this.field.hashCode();
        int i = 0;
        while (true) {
            int[] iArr = this.coefficients;
            if (i >= iArr.length) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 31) + iArr[i];
            i++;
        }
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, mod(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public void multThisWithElement(int i) {
        if (!this.field.isElementOfThisField(i)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        this.coefficients = multWithElement(this.coefficients, i);
        computeDegree();
    }

    public PolynomialGF2mSmallM multWithElement(int i) {
        if (!this.field.isElementOfThisField(i)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        return new PolynomialGF2mSmallM(this.field, multWithElement(this.coefficients, i));
    }

    public String toString() {
        String str = " Polynomial over " + this.field.toString() + ": \n";
        for (int i = 0; i < this.coefficients.length; i++) {
            str = str + this.field.elementToStr(this.coefficients[i]) + "Y^" + i + "+";
        }
        return str + ";";
    }
}
