package com.iabtcf.utils;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class Base64 {

    private static class DecInputStream extends InputStream {
        private final int[] base64;
        private final InputStream is;
        private final boolean isMIME;
        private int bits = 0;
        private int nextin = 18;
        private int nextout = -8;
        private boolean eof = false;
        private boolean closed = false;
        private byte[] sbBuf = new byte[1];

        DecInputStream(InputStream inputStream, int[] iArr, boolean z) {
            this.is = inputStream;
            this.base64 = iArr;
            this.isMIME = z;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            return this.is.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.is.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.sbBuf, 0, 1) == -1) {
                return -1;
            }
            return this.sbBuf[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            if (this.eof && this.nextout < 0) {
                return -1;
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (this.nextout >= 0) {
                int i4 = i;
                while (i2 != 0) {
                    i3 = i4 + 1;
                    int i5 = this.bits;
                    int i6 = this.nextout;
                    bArr[i4] = (byte) (i5 >> i6);
                    i2--;
                    int i7 = i6 - 8;
                    this.nextout = i7;
                    if (i7 < 0) {
                        this.bits = 0;
                    } else {
                        i4 = i3;
                    }
                }
                return i4 - i;
            }
            i3 = i;
            while (i2 > 0) {
                int i8 = this.is.read();
                if (i8 == -1) {
                    this.eof = true;
                    int i9 = this.nextin;
                    if (i9 != 18) {
                        if (i9 == 12) {
                            throw new IOException("Base64 stream has one un-decoded dangling byte.");
                        }
                        int i10 = i3 + 1;
                        int i11 = this.bits;
                        bArr[i3] = (byte) (i11 >> 16);
                        int i12 = i2 - 1;
                        if (i9 != 0) {
                            i3 = i10;
                        } else if (i12 == 0) {
                            this.bits = i11 >> 8;
                            this.nextout = 0;
                            i3 = i10;
                        } else {
                            i3 += 2;
                            bArr[i10] = (byte) (i11 >> 8);
                        }
                    }
                    if (i3 == i) {
                        return -1;
                    }
                    return i3 - i;
                }
                if (i8 == 61) {
                    int i13 = this.nextin;
                    if (i13 != 18 && i13 != 12 && (i13 != 6 || this.is.read() == 61)) {
                        int i14 = i3 + 1;
                        int i15 = this.bits;
                        bArr[i3] = (byte) (i15 >> 16);
                        int i16 = i2 - 1;
                        if (this.nextin != 0) {
                            i3 = i14;
                        } else if (i16 == 0) {
                            this.bits = i15 >> 8;
                            this.nextout = 0;
                            i3 = i14;
                        } else {
                            i3 += 2;
                            bArr[i14] = (byte) (i15 >> 8);
                        }
                        this.eof = true;
                        break;
                    }
                    throw new IOException("Illegal base64 ending sequence:" + this.nextin);
                }
                int i17 = this.base64[i8];
                if (i17 != -1) {
                    int i18 = this.bits;
                    int i19 = this.nextin;
                    this.bits = (i17 << i19) | i18;
                    if (i19 == 0) {
                        this.nextin = 18;
                        this.nextout = 16;
                        while (true) {
                            int i20 = this.nextout;
                            if (i20 < 0) {
                                this.bits = 0;
                                break;
                            }
                            int i21 = i3 + 1;
                            bArr[i3] = (byte) (this.bits >> i20);
                            i2--;
                            int i22 = i20 - 8;
                            this.nextout = i22;
                            if (i2 == 0 && i22 >= 0) {
                                return i21 - i;
                            }
                            i3 = i21;
                        }
                    } else {
                        this.nextin = i19 - 6;
                    }
                } else if (!this.isMIME) {
                    throw new IOException("Illegal base64 character " + Integer.toString(i17, 16));
                }
            }
            return i3 - i;
        }
    }

    private static class EncOutputStream extends FilterOutputStream {
        private int b0;
        private int b1;
        private int b2;
        private final char[] base64;
        private boolean closed;
        private final boolean doPadding;
        private int leftover;
        private final int linemax;
        private int linepos;
        private final byte[] newline;

        EncOutputStream(OutputStream outputStream, char[] cArr, byte[] bArr, int i, boolean z) {
            super(outputStream);
            this.leftover = 0;
            this.closed = false;
            this.linepos = 0;
            this.base64 = cArr;
            this.newline = bArr;
            this.linemax = i;
            this.doPadding = z;
        }

        private void checkNewline() throws IOException {
            if (this.linepos == this.linemax) {
                ((FilterOutputStream) this).out.write(this.newline);
                this.linepos = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            int i = this.leftover;
            if (i == 1) {
                checkNewline();
                ((FilterOutputStream) this).out.write(this.base64[this.b0 >> 2]);
                ((FilterOutputStream) this).out.write(this.base64[(this.b0 << 4) & 63]);
                if (this.doPadding) {
                    ((FilterOutputStream) this).out.write(61);
                    ((FilterOutputStream) this).out.write(61);
                }
            } else if (i == 2) {
                checkNewline();
                ((FilterOutputStream) this).out.write(this.base64[this.b0 >> 2]);
                ((FilterOutputStream) this).out.write(this.base64[((this.b0 << 4) & 63) | (this.b1 >> 4)]);
                ((FilterOutputStream) this).out.write(this.base64[(this.b1 << 2) & 63]);
                if (this.doPadding) {
                    ((FilterOutputStream) this).out.write(61);
                }
            }
            this.leftover = 0;
            ((FilterOutputStream) this).out.close();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)}, 0, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (!this.closed) {
                if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                if (i2 == 0) {
                    return;
                }
                int i3 = this.leftover;
                if (i3 != 0) {
                    if (i3 == 1) {
                        int i4 = i + 1;
                        this.b1 = bArr[i] & 255;
                        i2--;
                        if (i2 == 0) {
                            this.leftover = i3 + 1;
                            return;
                        }
                        i = i4;
                    }
                    this.b2 = bArr[i] & 255;
                    i2--;
                    checkNewline();
                    ((FilterOutputStream) this).out.write(this.base64[this.b0 >> 2]);
                    ((FilterOutputStream) this).out.write(this.base64[((this.b0 << 4) & 63) | (this.b1 >> 4)]);
                    ((FilterOutputStream) this).out.write(this.base64[((this.b1 << 2) & 63) | (this.b2 >> 6)]);
                    ((FilterOutputStream) this).out.write(this.base64[this.b2 & 63]);
                    this.linepos += 4;
                    i++;
                }
                int i5 = i2 / 3;
                this.leftover = i2 - (i5 * 3);
                while (true) {
                    int i6 = i5 - 1;
                    if (i5 <= 0) {
                        break;
                    }
                    checkNewline();
                    int i7 = i + 2;
                    int i8 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                    i += 3;
                    int i9 = i8 | (bArr[i7] & 255);
                    ((FilterOutputStream) this).out.write(this.base64[(i9 >>> 18) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[(i9 >>> 12) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[(i9 >>> 6) & 63]);
                    ((FilterOutputStream) this).out.write(this.base64[i9 & 63]);
                    this.linepos += 4;
                    i5 = i6;
                }
                int i10 = this.leftover;
                if (i10 == 1) {
                    this.b0 = bArr[i] & 255;
                    return;
                } else {
                    if (i10 == 2) {
                        this.b0 = bArr[i] & 255;
                        this.b1 = bArr[i + 1] & 255;
                        return;
                    }
                    return;
                }
            }
            throw new IOException("Stream is closed");
        }
    }

    public static class Encoder {
        private static final byte[] CRLF;
        private static final int MIMELINEMAX = 76;
        static final Encoder RFC2045;
        private final boolean doPadding;
        private final boolean isURL;
        private final int linemax;
        private final byte[] newline;
        private static final char[] TO_BASE_64 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] TO_BASE_64_URL = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        static final Encoder RFC4648 = new Encoder(false, null, -1, true);
        static final Encoder RFC4648_URLSAFE = new Encoder(true, null, -1, true);

        static {
            byte[] bArr = {13, 10};
            CRLF = bArr;
            RFC2045 = new Encoder(false, bArr, MIMELINEMAX, true);
        }

        private int encode0(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            char[] cArr = this.isURL ? TO_BASE_64_URL : TO_BASE_64;
            int i4 = ((i2 - i) / 3) * 3;
            int i5 = i + i4;
            int i6 = this.linemax;
            if (i6 > 0 && i4 > (i3 = (i6 / 4) * 3)) {
                i4 = i3;
            }
            int i7 = i;
            int i8 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + i4, i5);
                int i9 = i7;
                int i10 = i8;
                while (i9 < iMin) {
                    int i11 = i9 + 2;
                    int i12 = ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9] & 255) << 16);
                    i9 += 3;
                    int i13 = i12 | (bArr[i11] & 255);
                    bArr2[i10] = (byte) cArr[(i13 >>> 18) & 63];
                    bArr2[i10 + 1] = (byte) cArr[(i13 >>> 12) & 63];
                    int i14 = i10 + 3;
                    bArr2[i10 + 2] = (byte) cArr[(i13 >>> 6) & 63];
                    i10 += 4;
                    bArr2[i14] = (byte) cArr[i13 & 63];
                }
                int i15 = ((iMin - i7) / 3) * 4;
                i8 += i15;
                if (i15 == this.linemax && iMin < i2) {
                    byte[] bArr3 = this.newline;
                    int length = bArr3.length;
                    int i16 = 0;
                    while (i16 < length) {
                        bArr2[i8] = bArr3[i16];
                        i16++;
                        i8++;
                    }
                }
                i7 = iMin;
            }
            if (i7 >= i2) {
                return i8;
            }
            int i17 = i7 + 1;
            int i18 = bArr[i7] & 255;
            int i19 = i8 + 1;
            bArr2[i8] = (byte) cArr[i18 >> 2];
            if (i17 == i2) {
                int i20 = i8 + 2;
                bArr2[i19] = (byte) cArr[(i18 << 4) & 63];
                if (!this.doPadding) {
                    return i20;
                }
                int i21 = i8 + 3;
                bArr2[i20] = 61;
                int i22 = i8 + 4;
                bArr2[i21] = 61;
                return i22;
            }
            int i23 = bArr[i17] & 255;
            bArr2[i19] = (byte) cArr[((i18 << 4) & 63) | (i23 >> 4)];
            int i24 = i8 + 3;
            bArr2[i8 + 2] = (byte) cArr[(i23 << 2) & 63];
            if (!this.doPadding) {
                return i24;
            }
            int i25 = i8 + 4;
            bArr2[i24] = 61;
            return i25;
        }

        private final int outLength(int i) {
            int i2;
            if (this.doPadding) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.linemax;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.newline.length) : i2;
        }

        public byte[] encode(byte[] bArr) {
            int iOutLength = outLength(bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iEncode0 = encode0(bArr, 0, bArr.length, bArr2);
            return iEncode0 != iOutLength ? Arrays.copyOf(bArr2, iEncode0) : bArr2;
        }

        public String encodeToString(byte[] bArr) {
            byte[] bArrEncode = encode(bArr);
            return new String(bArrEncode, 0, 0, bArrEncode.length);
        }

        public Encoder withoutPadding() {
            return !this.doPadding ? this : new Encoder(this.isURL, this.newline, this.linemax, false);
        }

        public OutputStream wrap(OutputStream outputStream) {
            Objects.requireNonNull(outputStream);
            return new EncOutputStream(outputStream, this.isURL ? TO_BASE_64_URL : TO_BASE_64, this.newline, this.linemax, this.doPadding);
        }

        private Encoder(boolean z, byte[] bArr, int i, boolean z2) {
            this.isURL = z;
            this.newline = bArr;
            this.linemax = i;
            this.doPadding = z2;
        }

        public int encode(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= outLength(bArr.length)) {
                return encode0(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
        }

        public ByteBuffer encode(ByteBuffer byteBuffer) {
            int iEncode0;
            int iOutLength = outLength(byteBuffer.remaining());
            byte[] bArrCopyOf = new byte[iOutLength];
            if (byteBuffer.hasArray()) {
                iEncode0 = encode0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), bArrCopyOf);
                byteBuffer.position(byteBuffer.limit());
            } else {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                iEncode0 = encode0(bArr, 0, iRemaining, bArrCopyOf);
            }
            if (iEncode0 != iOutLength) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, iEncode0);
            }
            return ByteBuffer.wrap(bArrCopyOf);
        }
    }

    private Base64() {
    }

    public static Decoder getDecoder() {
        return Decoder.RFC4648;
    }

    public static Encoder getEncoder() {
        return Encoder.RFC4648;
    }

    public static Decoder getMimeDecoder() {
        return Decoder.RFC2045;
    }

    public static Encoder getMimeEncoder() {
        return Encoder.RFC2045;
    }

    public static Decoder getUrlDecoder() {
        return Decoder.RFC4648_URLSAFE;
    }

    public static Encoder getUrlEncoder() {
        return Encoder.RFC4648_URLSAFE;
    }

    public static Encoder getMimeEncoder(int i, byte[] bArr) {
        Objects.requireNonNull(bArr);
        int[] iArr = Decoder.FROM_BASE_64;
        for (byte b : bArr) {
            if (iArr[b & 255] != -1) {
                throw new IllegalArgumentException("Illegal base64 line separator character 0x" + Integer.toString(b, 16));
            }
        }
        if (i <= 0) {
            return Encoder.RFC4648;
        }
        return new Encoder(false, bArr, (i >> 2) << 2, true);
    }

    public static class Decoder {
        private static final int[] FROM_BASE_64;
        private static final int[] FROM_BASE_64_URL;
        static final Decoder RFC2045;
        static final Decoder RFC4648;
        static final Decoder RFC4648_URLSAFE;
        private final boolean isMIME;
        private final boolean isURL;

        static {
            int[] iArr = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
            FROM_BASE_64 = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < Encoder.TO_BASE_64.length; i++) {
                FROM_BASE_64[Encoder.TO_BASE_64[i]] = i;
            }
            FROM_BASE_64[61] = -2;
            int[] iArr2 = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
            FROM_BASE_64_URL = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < Encoder.TO_BASE_64_URL.length; i2++) {
                FROM_BASE_64_URL[Encoder.TO_BASE_64_URL[i2]] = i2;
            }
            FROM_BASE_64_URL[61] = -2;
            RFC4648 = new Decoder(false, false);
            RFC4648_URLSAFE = new Decoder(true, false);
            RFC2045 = new Decoder(false, true);
        }

        private Decoder(boolean z, boolean z2) {
            this.isURL = z;
            this.isMIME = z2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        
            if (r4 != 18) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int decode0(byte[] r12, int r13, int r14, byte[] r15) {
            /*
                Method dump skipped, instruction units count: 203
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iabtcf.utils.Base64.Decoder.decode0(byte[], int, int, byte[]):int");
        }

        private int outLength(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.isURL ? FROM_BASE_64_URL : FROM_BASE_64;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.isMIME && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.isMIME) {
                int i6 = 0;
                while (i < i2) {
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        public byte[] decode(byte[] bArr) {
            int iOutLength = outLength(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iOutLength];
            int iDecode0 = decode0(bArr, 0, bArr.length, bArr2);
            return iDecode0 != iOutLength ? Arrays.copyOf(bArr2, iDecode0) : bArr2;
        }

        public InputStream wrap(InputStream inputStream) {
            Objects.requireNonNull(inputStream);
            return new DecInputStream(inputStream, this.isURL ? FROM_BASE_64_URL : FROM_BASE_64, this.isMIME);
        }

        public byte[] decode(String str) {
            return decode(str.getBytes(Charset.forName("ISO-8859-1")));
        }

        public int decode(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= outLength(bArr, 0, bArr.length)) {
                return decode0(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
        }

        public ByteBuffer decode(ByteBuffer byteBuffer) {
            int iRemaining;
            byte[] bArrArray;
            int iArrayOffset;
            int iPosition = byteBuffer.position();
            try {
                if (byteBuffer.hasArray()) {
                    bArrArray = byteBuffer.array();
                    iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    iRemaining = byteBuffer.arrayOffset() + byteBuffer.limit();
                    byteBuffer.position(byteBuffer.limit());
                } else {
                    iRemaining = byteBuffer.remaining();
                    bArrArray = new byte[iRemaining];
                    byteBuffer.get(bArrArray);
                    iArrayOffset = 0;
                }
                byte[] bArr = new byte[outLength(bArrArray, iArrayOffset, iRemaining)];
                return ByteBuffer.wrap(bArr, 0, decode0(bArrArray, iArrayOffset, iRemaining, bArr));
            } catch (IllegalArgumentException e) {
                byteBuffer.position(iPosition);
                throw e;
            }
        }
    }
}
