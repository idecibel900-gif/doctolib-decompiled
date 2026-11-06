package com.facebook.imageformat;

import com.facebook.common.webp.WebpSupportStatus;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    private static final byte[] AVIF_HEADER_PREFIX;
    private static final byte[] AVIF_HEADER_SUFFIX;
    private static final byte[] BINARY_XML_HEADER;
    private static final byte[] BMP_HEADER;
    private static final int BMP_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_II;
    private static final int DNG_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_MM;
    private static final byte[] HEIF_HEADER_PREFIX;
    private static final byte[][] HEIF_HEADER_SUFFIXES;
    private static final byte[] ICO_HEADER;
    private static final int ICO_HEADER_LENGTH;
    private static final byte[] JPEG_HEADER;
    private static final int JPEG_HEADER_LENGTH;
    private static final byte[] PNG_HEADER;
    private static final int PNG_HEADER_LENGTH;
    private final int headerSize;
    public static final Companion Companion = new Companion(null);
    private static final byte[] GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
    private static final byte[] GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");

    public DefaultImageFormatChecker() {
        Object objMaxOrNull = ArraysKt.maxOrNull(new Integer[]{21, 20, Integer.valueOf(JPEG_HEADER_LENGTH), Integer.valueOf(PNG_HEADER_LENGTH), 6, Integer.valueOf(BMP_HEADER_LENGTH), Integer.valueOf(ICO_HEADER_LENGTH), 12, 4, 12});
        if (objMaxOrNull == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.headerSize = ((Number) objMaxOrNull).intValue();
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.headerSize;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public ImageFormat determineFormat(byte[] headerBytes, int i) {
        Intrinsics.checkNotNullParameter(headerBytes, "headerBytes");
        if (!WebpSupportStatus.isWebpHeader(headerBytes, 0, i)) {
            Companion companion = Companion;
            if (companion.isJpegHeader(headerBytes, i)) {
                return DefaultImageFormats.JPEG;
            }
            if (companion.isPngHeader(headerBytes, i)) {
                return DefaultImageFormats.PNG;
            }
            if (companion.isGifHeader(headerBytes, i)) {
                return DefaultImageFormats.GIF;
            }
            if (companion.isBmpHeader(headerBytes, i)) {
                return DefaultImageFormats.BMP;
            }
            if (companion.isIcoHeader(headerBytes, i)) {
                return DefaultImageFormats.ICO;
            }
            if (companion.isAvifHeader(headerBytes, i)) {
                return DefaultImageFormats.AVIF;
            }
            if (companion.isHeifHeader(headerBytes, i)) {
                return DefaultImageFormats.HEIF;
            }
            if (companion.isBinaryXmlHeader(headerBytes, i)) {
                return DefaultImageFormats.BINARY_XML;
            }
            if (companion.isDngHeader(headerBytes, i)) {
                return DefaultImageFormats.DNG;
            }
            return ImageFormat.UNKNOWN;
        }
        return Companion.getWebpFormat(headerBytes, i);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ImageFormat getWebpFormat(byte[] bArr, int i) {
            if (!WebpSupportStatus.isWebpHeader(bArr, 0, i)) {
                throw new IllegalStateException("Check failed.");
            }
            if (WebpSupportStatus.isSimpleWebpHeader(bArr, 0)) {
                return DefaultImageFormats.WEBP_SIMPLE;
            }
            if (WebpSupportStatus.isLosslessWebpHeader(bArr, 0)) {
                return DefaultImageFormats.WEBP_LOSSLESS;
            }
            if (WebpSupportStatus.isExtendedWebpHeader(bArr, 0, i)) {
                if (WebpSupportStatus.isAnimatedWebpHeader(bArr, 0)) {
                    return DefaultImageFormats.WEBP_ANIMATED;
                }
                if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(bArr, 0)) {
                    return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
                }
                return DefaultImageFormats.WEBP_EXTENDED;
            }
            return ImageFormat.UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isJpegHeader(byte[] bArr, int i) {
            return i >= DefaultImageFormatChecker.JPEG_HEADER.length && ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.JPEG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isPngHeader(byte[] bArr, int i) {
            return i >= DefaultImageFormatChecker.PNG_HEADER.length && ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.PNG_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isGifHeader(byte[] bArr, int i) {
            if (i < 6) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.GIF_HEADER_87A) || ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.GIF_HEADER_89A);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBmpHeader(byte[] bArr, int i) {
            if (i < DefaultImageFormatChecker.BMP_HEADER.length) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.BMP_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isIcoHeader(byte[] bArr, int i) {
            if (i < DefaultImageFormatChecker.ICO_HEADER.length) {
                return false;
            }
            return ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.ICO_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isHeifHeader(byte[] bArr, int i) {
            if (i < 12 || bArr[3] < 8 || !ImageFormatCheckerUtils.hasPatternAt(bArr, DefaultImageFormatChecker.HEIF_HEADER_PREFIX, 4)) {
                return false;
            }
            for (byte[] bArr2 : DefaultImageFormatChecker.HEIF_HEADER_SUFFIXES) {
                if (ImageFormatCheckerUtils.hasPatternAt(bArr, bArr2, 8)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isDngHeader(byte[] bArr, int i) {
            if (i >= DefaultImageFormatChecker.DNG_HEADER_LENGTH) {
                return ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.DNG_HEADER_II) || ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.DNG_HEADER_MM);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBinaryXmlHeader(byte[] bArr, int i) {
            return i >= 4 && ImageFormatCheckerUtils.startsWithPattern(bArr, DefaultImageFormatChecker.BINARY_XML_HEADER);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAvifHeader(byte[] bArr, int i) {
            if (i >= 12 && getBoxLength(bArr) >= 8 && ImageFormatCheckerUtils.hasPatternAt(bArr, DefaultImageFormatChecker.AVIF_HEADER_PREFIX, 4)) {
                return ImageFormatCheckerUtils.hasPatternAt(bArr, DefaultImageFormatChecker.AVIF_HEADER_SUFFIX, 8);
            }
            return false;
        }

        private final int getBoxLength(byte[] bArr) {
            if (bArr.length < 4) {
                return -1;
            }
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
    }

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        byte[] bArrAsciiBytes = ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = bArrAsciiBytes;
        BMP_HEADER_LENGTH = bArrAsciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        HEIF_HEADER_PREFIX = ImageFormatCheckerUtils.asciiBytes("ftyp");
        HEIF_HEADER_SUFFIXES = new byte[][]{ImageFormatCheckerUtils.asciiBytes("heic"), ImageFormatCheckerUtils.asciiBytes("heix"), ImageFormatCheckerUtils.asciiBytes("hevc"), ImageFormatCheckerUtils.asciiBytes("hevx"), ImageFormatCheckerUtils.asciiBytes("mif1"), ImageFormatCheckerUtils.asciiBytes("msf1")};
        byte[] bArr4 = {73, 73, 42, 0};
        DNG_HEADER_II = bArr4;
        DNG_HEADER_MM = new byte[]{77, 77, 0, 42};
        DNG_HEADER_LENGTH = bArr4.length;
        BINARY_XML_HEADER = new byte[]{3, 0, 8, 0};
        AVIF_HEADER_PREFIX = ImageFormatCheckerUtils.asciiBytes("ftyp");
        AVIF_HEADER_SUFFIX = ImageFormatCheckerUtils.asciiBytes("avif");
    }
}
