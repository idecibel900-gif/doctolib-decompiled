package com.bumptech.glide.load.resource.bitmap;

import com.adjust.sdk.Constants;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import com.facebook.imageutils.JfifUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = "Exif\u0000\u0000".getBytes(Charset.forName(Constants.ENCODING));
    static final byte[] JPEG_MPF_SEGMENT_PREAMBLE_BYTES = "MPF".getBytes(Charset.forName(Constants.ENCODING));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean handles(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, ArrayPool arrayPool) {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(InputStream inputStream, ArrayPool arrayPool) {
        return hasJpegMpf(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return hasJpegMpf(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    private boolean hasJpegMpf(Reader reader, ArrayPool arrayPool) {
        if (getType(reader) != ImageHeaderParser.ImageType.JPEG) {
            return false;
        }
        int iMoveToApp2SegmentAndGetLength = moveToApp2SegmentAndGetLength(reader);
        while (iMoveToApp2SegmentAndGetLength > 0) {
            byte[] bArr = (byte[]) arrayPool.get(iMoveToApp2SegmentAndGetLength, byte[].class);
            try {
                if (hasJpegMpfPreamble(reader, bArr, iMoveToApp2SegmentAndGetLength)) {
                    return true;
                }
                arrayPool.put(bArr);
                iMoveToApp2SegmentAndGetLength = moveToApp2SegmentAndGetLength(reader);
            } finally {
                arrayPool.put(bArr);
            }
        }
        return false;
    }

    private ImageHeaderParser.ImageType getType(Reader reader) {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt9 = (uInt8 << 8) | reader.getUInt8();
            if (uInt9 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt9 != 1380533830) {
                return sniffAvif(reader, uInt9);
            }
            reader.skip(4L);
            if (((reader.getUInt16() << 16) | reader.getUInt16()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt17 = (reader.getUInt16() << 16) | reader.getUInt16();
            if ((uInt17 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = uInt17 & 255;
            if (i != 88) {
                if (i == 76) {
                    reader.skip(4L);
                    return (reader.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            short uInt10 = reader.getUInt8();
            if ((uInt10 & 2) != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if ((uInt10 & 16) != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private ImageHeaderParser.ImageType sniffAvif(Reader reader, int i) {
        if (((reader.getUInt16() << 16) | reader.getUInt16()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int uInt16 = (reader.getUInt16() << 16) | reader.getUInt16();
        if (uInt16 == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i2 = 0;
        boolean z = uInt16 == 1635150182;
        reader.skip(4L);
        int i3 = i - 16;
        if (i3 % 4 == 0) {
            while (i2 < 5 && i3 > 0) {
                int uInt17 = (reader.getUInt16() << 16) | reader.getUInt16();
                if (uInt17 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (uInt17 == 1635150182) {
                    z = true;
                }
                i2++;
                i3 -= 4;
            }
        }
        return z ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) {
        int iMoveToExifSegmentAndGetLength;
        try {
            if (!handles(reader.getUInt16()) || (iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader)) == -1) {
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.get(iMoveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(reader, bArr, iMoveToExifSegmentAndGetLength);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i) {
        if (reader.read(bArr, i) == i && hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new RandomAccessReader(bArr, i));
        }
        return -1;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        return hasMatchingBytes(bArr, i, JPEG_EXIF_SEGMENT_PREAMBLE_BYTES);
    }

    private boolean hasMatchingBytes(byte[] bArr, int i, byte[] bArr2) {
        boolean z = (bArr == null || bArr2 == null || i <= bArr2.length) ? false : true;
        if (z) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength(Reader reader) {
        return moveToSegmentAndGetLength(reader, JfifUtil.MARKER_APP1);
    }

    private boolean hasJpegMpfPreamble(Reader reader, byte[] bArr, int i) {
        if (reader.read(bArr, i) != i) {
            return false;
        }
        return hasMatchingBytes(bArr, i, JPEG_MPF_SEGMENT_PREAMBLE_BYTES);
    }

    private int moveToApp2SegmentAndGetLength(Reader reader) {
        return moveToSegmentAndGetLength(reader, 226);
    }

    private int moveToSegmentAndGetLength(Reader reader, int i) {
        short uInt8;
        while (reader.getUInt8() == 255 && (uInt8 = reader.getUInt8()) != 218 && uInt8 != 217) {
            int uInt16 = reader.getUInt16() - 2;
            if (uInt8 == i) {
                return uInt16;
            }
            long j = uInt16;
            if (reader.skip(j) != j) {
                return -1;
            }
        }
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16;
        int int32;
        int i;
        int i2;
        short int17 = randomAccessReader.getInt16(6);
        if (int17 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (int17 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int33 = randomAccessReader.getInt32(10) + 6;
        short int18 = randomAccessReader.getInt16(int33);
        for (int i3 = 0; i3 < int18; i3++) {
            int iCalcTagOffset = calcTagOffset(int33, i3);
            if (randomAccessReader.getInt16(iCalcTagOffset) == 274 && (int16 = randomAccessReader.getInt16(iCalcTagOffset + 2)) >= 1 && int16 <= 12 && (int32 = randomAccessReader.getInt32(iCalcTagOffset + 4)) >= 0 && (i = int32 + BYTES_PER_FORMAT[int16]) <= 4 && (i2 = iCalcTagOffset + 8) >= 0 && i2 <= randomAccessReader.length() && i >= 0 && i + i2 <= randomAccessReader.length()) {
                return randomAccessReader.getInt16(i2);
            }
        }
        return -1;
    }

    private static final class RandomAccessReader {
        private final ByteBuffer data;

        RandomAccessReader(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }

        int length() {
            return this.data.remaining();
        }

        int getInt32(int i) {
            if (isAvailable(i, 4)) {
                return this.data.getInt(i);
            }
            return -1;
        }

        short getInt16(int i) {
            if (isAvailable(i, 2)) {
                return this.data.getShort(i);
            }
            return (short) -1;
        }

        private boolean isAvailable(int i, int i2) {
            return this.data.remaining() - i >= i2;
        }
    }

    private interface Reader {
        int getUInt16();

        short getUInt8();

        int read(byte[] bArr, int i);

        long skip(long j);

        public static final class EndOfFileException extends IOException {
            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }
    }

    private static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() < 1) {
                throw new Reader.EndOfFileException();
            }
            return (short) (this.byteBuffer.get() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            int iMin = Math.min(i, this.byteBuffer.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int iMin = (int) Math.min(this.byteBuffer.remaining(), j);
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    private static final class StreamReader implements Reader {
        private final InputStream is;

        StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int i = this.is.read();
            if (i != -1) {
                return (short) i;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws Reader.EndOfFileException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.is.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.is.skip(j2);
                if (jSkip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }
    }
}
