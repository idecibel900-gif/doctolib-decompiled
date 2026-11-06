package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteStreams {
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i, i2 + i, bArr.length);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue queue, int i) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i) * 2));
        while (i < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i2 = 0;
            while (i2 < iMin2) {
                int i3 = inputStream.read(bArr, i2, iMin2 - i2);
                if (i3 == -1) {
                    return combineBuffers(queue, i);
                }
                i2 += i3;
                i += i3;
            }
            iMin = IntMath.saturatedMultiply(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] combineBuffers(Queue queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }
}
