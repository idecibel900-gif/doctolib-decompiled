package com.datadog.trace.api.internal.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LongStringUtils {
    private static final byte[] HEX_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public static String toHexStringPadded(long j, int i) {
        byte[] bArrAllocatePaddedHexStringBytes = allocatePaddedHexStringBytes(i);
        fillStringBytesWithPaddedHexId(j, 0, bArrAllocatePaddedHexStringBytes.length, bArrAllocatePaddedHexStringBytes);
        return new String(bArrAllocatePaddedHexStringBytes, StandardCharsets.US_ASCII);
    }

    public static String toHexStringPadded(long j, long j2, int i) {
        if (i <= 16) {
            return toHexStringPadded(j2, i);
        }
        byte[] bArrAllocatePaddedHexStringBytes = allocatePaddedHexStringBytes(i);
        fillStringBytesWithPaddedHexId(j, 0, 16, bArrAllocatePaddedHexStringBytes);
        fillStringBytesWithPaddedHexId(j2, 16, 16, bArrAllocatePaddedHexStringBytes);
        return new String(bArrAllocatePaddedHexStringBytes, StandardCharsets.US_ASCII);
    }

    private static byte[] allocatePaddedHexStringBytes(int i) {
        if (i > 16) {
            i = 32;
        } else if (i < 16) {
            i = 16;
        }
        return new byte[i];
    }

    private static void fillStringBytesWithPaddedHexId(long j, int i, int i2, byte[] bArr) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) >>> 2;
        Arrays.fill(bArr, i, (i2 - 16) + i + iNumberOfLeadingZeros, (byte) 48);
        for (int i3 = 0; i3 < 16 - iNumberOfLeadingZeros; i3++) {
            bArr[((i + i2) - 1) - i3] = HEX_DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
    }
}
