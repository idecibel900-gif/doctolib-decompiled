package com.abovevacant.epitaph.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class WireReader {
    private final byte[] buffer;
    private final int limit;
    private int position;

    public static int getFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getWireType(int i) {
        return i & 7;
    }

    public WireReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public WireReader(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    public static WireReader fromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return new WireReader(byteArrayOutputStream.toByteArray());
            }
        }
    }

    public boolean hasRemaining() {
        return this.position < this.limit;
    }

    public int remaining() {
        return this.limit - this.position;
    }

    public int readTag() {
        if (hasRemaining()) {
            return (int) readVarInt();
        }
        return 0;
    }

    public long readVarInt() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (!hasRemaining()) {
                throw new EOFException("Truncated varint");
            }
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new IOException("Malformed varint");
    }

    public int readVarInt32() {
        return (int) readVarInt();
    }

    public byte[] readBytes() throws IOException {
        int varInt32 = readVarInt32();
        if (varInt32 < 0) {
            throw new IOException("Negative length: " + varInt32);
        }
        if (remaining() < varInt32) {
            throw new EOFException("Not enough bytes for length-delimited field");
        }
        byte[] bArr = new byte[varInt32];
        System.arraycopy(this.buffer, this.position, bArr, 0, varInt32);
        this.position += varInt32;
        return bArr;
    }

    public String readString() {
        return new String(readBytes(), StandardCharsets.UTF_8);
    }

    public boolean readBool() {
        return readVarInt() != 0;
    }

    public WireReader readMessage() {
        return new WireReader(readBytes());
    }

    public static void expectWireType(int i, int i2, int i3) throws IOException {
        if (i2 == i3) {
            return;
        }
        throw new IOException("Field " + i + ": expected " + wireTypeName(i2) + " (wire type " + i2 + ") but got " + wireTypeName(i3) + " (wire type " + i3 + ")");
    }

    private static String wireTypeName(int i) {
        if (i == 0) {
            return "varint";
        }
        if (i == 1) {
            return "fixed64";
        }
        if (i == 2) {
            return "length-delimited";
        }
        if (i == 5) {
            return "fixed32";
        }
        return "unknown";
    }

    public void skipField(int i) throws IOException {
        if (i == 0) {
            readVarInt();
            return;
        }
        if (i == 1) {
            if (remaining() < 8) {
                throw new EOFException("Not enough bytes to skip fixed64");
            }
            this.position += 8;
        } else {
            if (i == 2) {
                int varInt32 = readVarInt32();
                if (remaining() < varInt32) {
                    throw new EOFException("Not enough bytes to skip length-delimited");
                }
                this.position += varInt32;
                return;
            }
            if (i == 5) {
                if (remaining() < 4) {
                    throw new EOFException("Not enough bytes to skip fixed32");
                }
                this.position += 4;
            } else {
                throw new IOException("Unknown wire type: " + i);
            }
        }
    }
}
