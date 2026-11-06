package org.brotli.dec;

/* JADX INFO: loaded from: classes5.dex */
abstract class Huffman {
    private static int getNextKey(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        while ((i & i3) != 0) {
            i3 >>= 1;
        }
        return (i & (i3 - 1)) + i3;
    }

    private static void replicateValue(int[] iArr, int i, int i2, int i3, int i4) {
        do {
            i3 -= i2;
            iArr[i + i3] = i4;
        } while (i3 > 0);
    }

    private static int nextTableBitSize(int[] iArr, int i, int i2) {
        int i3;
        int i4 = 1 << (i - i2);
        while (i < 15 && (i3 = i4 - iArr[i]) > 0) {
            i++;
            i4 = i3 << 1;
        }
        return i - i2;
    }

    static void buildHuffmanTable(int[] iArr, int i, int i2, int[] iArr2, int i3) {
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int nextKey = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr2[i4];
            iArr4[i5] = iArr4[i5] + 1;
        }
        iArr5[1] = 0;
        int i6 = 1;
        while (i6 < 15) {
            int i7 = i6 + 1;
            iArr5[i7] = iArr5[i6] + iArr4[i6];
            i6 = i7;
        }
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = iArr2[i8];
            if (i9 != 0) {
                int i10 = iArr5[i9];
                iArr5[i9] = i10 + 1;
                iArr3[i10] = i8;
            }
        }
        int i11 = 1 << i2;
        if (iArr5[15] == 1) {
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i + i12] = iArr3[0];
            }
            return;
        }
        int i13 = 2;
        int i14 = 2;
        int i15 = 0;
        int i16 = 1;
        while (i16 <= i2) {
            while (iArr4[i16] > 0) {
                replicateValue(iArr, i + nextKey, i14, i11, iArr3[i15] | (i16 << 16));
                nextKey = getNextKey(nextKey, i16);
                iArr4[i16] = iArr4[i16] - 1;
                i15++;
            }
            i16++;
            i14 <<= 1;
        }
        int i17 = i11 - 1;
        int i18 = i2 + 1;
        int i19 = -1;
        int i20 = i;
        while (i18 <= 15) {
            while (iArr4[i18] > 0) {
                int i21 = nextKey & i17;
                if (i21 != i19) {
                    i20 += i11;
                    int iNextTableBitSize = nextTableBitSize(iArr4, i18, i2);
                    iArr[i + i21] = ((iNextTableBitSize + i2) << 16) | ((i20 - i) - i21);
                    i11 = 1 << iNextTableBitSize;
                    i19 = i21;
                }
                replicateValue(iArr, (nextKey >> i2) + i20, i13, i11, ((i18 - i2) << 16) | iArr3[i15]);
                nextKey = getNextKey(nextKey, i18);
                iArr4[i18] = iArr4[i18] - 1;
                i15++;
            }
            i18++;
            i13 <<= 1;
        }
    }
}
