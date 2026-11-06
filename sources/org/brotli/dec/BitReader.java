package org.brotli.dec;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
final class BitReader {
    long accumulator;
    int bitOffset;
    private boolean endOfStreamReached;
    private InputStream input;
    private int intOffset;
    private final byte[] byteBuffer = new byte[4160];
    private final int[] intBuffer = new int[1040];
    private final IntReader intReader = new IntReader();
    private int tailBytes = 0;

    BitReader() {
    }

    static void readMoreInput(BitReader bitReader) {
        int i = bitReader.intOffset;
        if (i <= 1015) {
            return;
        }
        if (bitReader.endOfStreamReached) {
            if (intAvailable(bitReader) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i3 = 4096 - i2;
        byte[] bArr = bitReader.byteBuffer;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        bitReader.intOffset = 0;
        while (i3 < 4096) {
            try {
                int i4 = bitReader.input.read(bitReader.byteBuffer, i3, 4096 - i3);
                if (i4 <= 0) {
                    bitReader.endOfStreamReached = true;
                    bitReader.tailBytes = i3;
                    i3 += 3;
                    break;
                }
                i3 += i4;
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        IntReader.convert(bitReader.intReader, i3 >> 2);
    }

    static void checkHealth(BitReader bitReader, boolean z) {
        if (bitReader.endOfStreamReached) {
            int i = ((bitReader.intOffset << 2) + ((bitReader.bitOffset + 7) >> 3)) - 8;
            int i2 = bitReader.tailBytes;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    static void fillBitWindow(BitReader bitReader) {
        int i = bitReader.bitOffset;
        if (i >= 32) {
            int[] iArr = bitReader.intBuffer;
            int i2 = bitReader.intOffset;
            bitReader.intOffset = i2 + 1;
            bitReader.accumulator = (((long) iArr[i2]) << 32) | (bitReader.accumulator >>> 32);
            bitReader.bitOffset = i - 32;
        }
    }

    static int readBits(BitReader bitReader, int i) {
        fillBitWindow(bitReader);
        long j = bitReader.accumulator;
        int i2 = bitReader.bitOffset;
        int i3 = ((int) (j >>> i2)) & ((1 << i) - 1);
        bitReader.bitOffset = i2 + i;
        return i3;
    }

    static void init(BitReader bitReader, InputStream inputStream) {
        if (bitReader.input != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        IntReader.init(bitReader.intReader, bitReader.byteBuffer, bitReader.intBuffer);
        bitReader.input = inputStream;
        bitReader.accumulator = 0L;
        bitReader.bitOffset = 64;
        bitReader.intOffset = IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
        bitReader.endOfStreamReached = false;
        prepare(bitReader);
    }

    private static void prepare(BitReader bitReader) {
        readMoreInput(bitReader);
        checkHealth(bitReader, false);
        fillBitWindow(bitReader);
        fillBitWindow(bitReader);
    }

    static void reload(BitReader bitReader) {
        if (bitReader.bitOffset == 64) {
            prepare(bitReader);
        }
    }

    static void close(BitReader bitReader) throws IOException {
        InputStream inputStream = bitReader.input;
        bitReader.input = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    static void jumpToByteBoundary(BitReader bitReader) {
        int i = (64 - bitReader.bitOffset) & 7;
        if (i != 0 && readBits(bitReader, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    static int intAvailable(BitReader bitReader) {
        return (bitReader.endOfStreamReached ? (bitReader.tailBytes + 3) >> 2 : IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) - bitReader.intOffset;
    }

    static void copyBytes(BitReader bitReader, byte[] bArr, int i, int i2) {
        if ((bitReader.bitOffset & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i3 = bitReader.bitOffset;
            if (i3 == 64 || i2 == 0) {
                break;
            }
            bArr[i] = (byte) (bitReader.accumulator >>> i3);
            bitReader.bitOffset = i3 + 8;
            i2--;
            i++;
        }
        if (i2 == 0) {
            return;
        }
        int iMin = Math.min(intAvailable(bitReader), i2 >> 2);
        if (iMin > 0) {
            int i4 = iMin << 2;
            System.arraycopy(bitReader.byteBuffer, bitReader.intOffset << 2, bArr, i, i4);
            i += i4;
            i2 -= i4;
            bitReader.intOffset += iMin;
        }
        if (i2 == 0) {
            return;
        }
        if (intAvailable(bitReader) <= 0) {
            while (i2 > 0) {
                try {
                    int i5 = bitReader.input.read(bArr, i, i2);
                    if (i5 == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i += i5;
                    i2 -= i5;
                } catch (IOException e) {
                    throw new BrotliRuntimeException("Failed to read input", e);
                }
            }
            return;
        }
        fillBitWindow(bitReader);
        while (i2 != 0) {
            long j = bitReader.accumulator;
            int i6 = bitReader.bitOffset;
            bArr[i] = (byte) (j >>> i6);
            bitReader.bitOffset = i6 + 8;
            i2--;
            i++;
        }
        checkHealth(bitReader, false);
    }
}
