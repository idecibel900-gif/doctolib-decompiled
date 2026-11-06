package org.brotli.dec;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: loaded from: classes5.dex */
abstract class Utils {
    private static final byte[] BYTE_ZEROES = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];
    private static final int[] INT_ZEROES = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];

    static void fillWithZeroes(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iMin = Math.min(i3 + IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, i2) - i3;
            System.arraycopy(BYTE_ZEROES, 0, bArr, i + i3, iMin);
            i3 += iMin;
        }
    }

    static void fillWithZeroes(int[] iArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iMin = Math.min(i3 + IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, i2) - i3;
            System.arraycopy(INT_ZEROES, 0, iArr, i + i3, iMin);
            i3 += iMin;
        }
    }
}
