package kotlin.text;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;

    static {
        int[] iArr = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = "0123456789abcdef".charAt(i2 & 15) | ("0123456789abcdef".charAt(i2 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = "0123456789ABCDEF".charAt(i3 & 15) | ("0123456789ABCDEF".charAt(i3 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i5)] = i6;
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i7)] = i8;
            i7++;
            i8++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i10)] = i11;
            i10++;
            i11++;
        }
        int i12 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    public static final String toHexString(byte[] bArr, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.Companion.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    public static final String toHexString(byte[] bArr, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (i == i2) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        if (bytes.getNoLineAndGroupSeparator$kotlin_stdlib()) {
            return toHexStringNoLineAndGroupSeparator(bArr, i, i2, bytes, iArr);
        }
        return toHexStringSlowPath(bArr, i, i2, bytes, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        if (bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i, i2, bytesHexFormat, iArr);
        }
        return toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i, i2, bytesHexFormat, iArr);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i3 = i2 - i;
        int byteAt = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(((long) i3) * 2)];
            while (i < i2) {
                byteAt = formatByteAt(bArr, i, iArr, cArr, byteAt);
                i++;
            }
            return StringsKt__StringsJVMKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((((long) i3) * 3) - 1)];
        char cCharAt = bytesHexFormat.getByteSeparator().charAt(0);
        int byteAt2 = formatByteAt(bArr, i, iArr, cArr2, 0);
        for (int i4 = i + 1; i4 < i2; i4++) {
            cArr2[byteAt2] = cCharAt;
            byteAt2 = formatByteAt(bArr, i4, iArr, cArr2, byteAt2 + 1);
        }
        return StringsKt__StringsJVMKt.concatToString(cArr2);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i2 - i, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int byteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, 0);
        for (int i3 = i + 1; i3 < i2; i3++) {
            byteAt = formatByteAt(bArr, i3, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, byteAt));
        }
        return StringsKt__StringsJVMKt.concatToString(cArr);
    }

    private static final String toHexStringSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i3;
        int i4;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int i5 = formattedStringLength(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        char[] cArr = new char[i5];
        int i6 = i;
        int charArrayIfNotEmpty = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i2) {
            if (i7 == bytesPerLine) {
                cArr[charArrayIfNotEmpty] = '\n';
                charArrayIfNotEmpty++;
                i3 = 0;
                i4 = 0;
            } else if (i8 == bytesPerGroup) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(groupSeparator, cArr, charArrayIfNotEmpty);
                i3 = i7;
                i4 = 0;
            } else {
                i3 = i7;
                i4 = i8;
            }
            if (i4 != 0) {
                charArrayIfNotEmpty = toCharArrayIfNotEmpty(byteSeparator, cArr, charArrayIfNotEmpty);
            }
            String str = bytePrefix;
            int byteAt = formatByteAt(bArr, i6, str, byteSuffix, iArr, cArr, charArrayIfNotEmpty);
            i6++;
            i8 = i4 + 1;
            charArrayIfNotEmpty = byteAt;
            bytePrefix = str;
            i7 = i3 + 1;
        }
        if (charArrayIfNotEmpty != i5) {
            throw new IllegalStateException("Check failed.");
        }
        return StringsKt__StringsJVMKt.concatToString(cArr);
    }

    private static final int formatByteAt(byte[] bArr, int i, String str, String str2, int[] iArr, char[] cArr, int i2) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i2)));
    }

    private static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i3 = iArr[bArr[i] & 255];
        cArr[i2] = (char) (i3 >> 8);
        cArr[i2 + 1] = (char) (i3 & 255);
        return i2 + 2;
    }

    private static final int formattedStringLength(int i, int i2, int i3, int i4) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j = i2;
        return checkFormatLength((((long) i) * (((((long) i3) + 2) + ((long) i4)) + j)) - j);
    }

    public static final int formattedStringLength(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i8 = i - 1;
        int i9 = i8 / i2;
        int i10 = (i2 - 1) / i3;
        int i11 = i % i2;
        if (i11 != 0) {
            i2 = i11;
        }
        int i12 = (i10 * i9) + ((i2 - 1) / i3);
        return checkFormatLength(((long) i9) + (((long) i12) * ((long) i4)) + (((long) ((i8 - i9) - i12)) * ((long) i5)) + (((long) i) * (((long) i6) + 2 + ((long) i7))));
    }

    private static final int checkFormatLength(long j) {
        if (0 <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m5301toStringimpl(ULong.m5297constructorimpl(j))));
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        int length = str.length();
        if (length != 0) {
            if (length == 1) {
                cArr[i] = str.charAt(0);
            } else {
                int length2 = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length2, cArr, i);
            }
        }
        return i + str.length();
    }
}
