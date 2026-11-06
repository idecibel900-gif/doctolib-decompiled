package org.bouncycastle.pqc.legacy.math.linearalgebra;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class Permutation {
    private int[] perm;

    public Permutation(byte[] bArr) {
        if (bArr.length <= 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        int iOS2IP = LittleEndianConversions.OS2IP(bArr, 0);
        int iCeilLog256 = IntegerFunctions.ceilLog256(iOS2IP - 1);
        if (bArr.length != (iOS2IP * iCeilLog256) + 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        this.perm = new int[iOS2IP];
        for (int i = 0; i < iOS2IP; i++) {
            this.perm[i] = LittleEndianConversions.OS2IP(bArr, (i * iCeilLog256) + 4, iCeilLog256);
        }
        if (!isPermutation(this.perm)) {
            throw new IllegalArgumentException("invalid encoding");
        }
    }

    private boolean isPermutation(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i : iArr) {
            if (i < 0 || i >= length || zArr[i]) {
                return false;
            }
            zArr[i] = true;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Permutation) {
            return IntUtils.equals(this.perm, ((Permutation) obj).perm);
        }
        return false;
    }

    public byte[] getEncoded() {
        int length = this.perm.length;
        int iCeilLog256 = IntegerFunctions.ceilLog256(length - 1);
        byte[] bArr = new byte[(length * iCeilLog256) + 4];
        LittleEndianConversions.I2OSP(length, bArr, 0);
        for (int i = 0; i < length; i++) {
            LittleEndianConversions.I2OSP(this.perm[i], bArr, (i * iCeilLog256) + 4, iCeilLog256);
        }
        return bArr;
    }

    public int hashCode() {
        return Arrays.hashCode(this.perm);
    }

    public String toString() {
        String str = "[" + this.perm[0];
        for (int i = 1; i < this.perm.length; i++) {
            str = str + ", " + this.perm[i];
        }
        return str + "]";
    }
}
