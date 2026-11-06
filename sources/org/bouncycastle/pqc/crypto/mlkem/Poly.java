package org.bouncycastle.pqc.crypto.mlkem;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes5.dex */
class Poly {
    private MLKEMEngine engine;
    private int eta1;
    private int polyCompressedBytes;
    private Symmetric symmetric;
    private short[] coeffs = new short[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    private int eta2 = MLKEMEngine.getKyberEta2();

    public Poly(MLKEMEngine mLKEMEngine) {
        this.engine = mLKEMEngine;
        this.polyCompressedBytes = mLKEMEngine.getKyberPolyCompressedBytes();
        this.eta1 = mLKEMEngine.getKyberEta1();
        this.symmetric = mLKEMEngine.getSymmetric();
    }

    public static void baseMultMontgomery(Poly poly, Poly poly2, Poly poly3) {
        for (int i = 0; i < 64; i++) {
            int i2 = i * 4;
            short coeffIndex = poly2.getCoeffIndex(i2);
            int i3 = i2 + 1;
            short coeffIndex2 = poly2.getCoeffIndex(i3);
            short coeffIndex3 = poly3.getCoeffIndex(i2);
            short coeffIndex4 = poly3.getCoeffIndex(i3);
            short[] sArr = Ntt.nttZetas;
            int i4 = i + 64;
            Ntt.baseMult(poly, i2, coeffIndex, coeffIndex2, coeffIndex3, coeffIndex4, sArr[i4]);
            int i5 = i2 + 2;
            int i6 = i2 + 3;
            Ntt.baseMult(poly, i5, poly2.getCoeffIndex(i5), poly2.getCoeffIndex(i6), poly3.getCoeffIndex(i5), poly3.getCoeffIndex(i6), (short) (sArr[i4] * (-1)));
        }
    }

    public void addCoeffs(Poly poly) {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, (short) (getCoeffIndex(i) + poly.getCoeffIndex(i)));
        }
    }

    public void conditionalSubQ() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, Reduce.conditionalSubQ(getCoeffIndex(i)));
        }
    }

    public void convertToMont() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, Reduce.montgomeryReduce(getCoeffIndex(i) * 1353));
        }
    }

    public short getCoeffIndex(int i) {
        return this.coeffs[i];
    }

    public short[] getCoeffs() {
        return this.coeffs;
    }

    public void getEta1Noise(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[(this.eta1 * IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) / 4];
        this.symmetric.prf(bArr2, bArr, b);
        CBD.mlkemCBD(this, bArr2, this.eta1);
    }

    public void polyNtt() {
        setCoeffs(Ntt.ntt(getCoeffs()));
        reduce();
    }

    public void reduce() {
        for (int i = 0; i < 256; i++) {
            setCoeffIndex(i, Reduce.barretReduce(getCoeffIndex(i)));
        }
    }

    public void setCoeffIndex(int i, short s) {
        this.coeffs[i] = s;
    }

    public void setCoeffs(short[] sArr) {
        this.coeffs = sArr;
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[384];
        conditionalSubQ();
        for (int i = 0; i < 128; i++) {
            int i2 = i * 2;
            short coeffIndex = getCoeffIndex(i2);
            short coeffIndex2 = getCoeffIndex(i2 + 1);
            int i3 = i * 3;
            bArr[i3] = (byte) coeffIndex;
            bArr[i3 + 1] = (byte) ((coeffIndex >> 8) | (coeffIndex2 << 4));
            bArr[i3 + 2] = (byte) (coeffIndex2 >> 4);
        }
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        int i = 0;
        while (true) {
            short[] sArr = this.coeffs;
            if (i >= sArr.length) {
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
            stringBuffer.append((int) sArr[i]);
            if (i != this.coeffs.length - 1) {
                stringBuffer.append(", ");
            }
            i++;
        }
    }
}
