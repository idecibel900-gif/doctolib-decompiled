package kotlin.text;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.trace.api.DD128bTraceId$$ExternalSyntheticBackport2;
import kotlin.KotlinNothingValueException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UStringsKt {
    public static final byte toUByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UByte uByteOrNull = toUByteOrNull(str);
        if (uByteOrNull != null) {
            return uByteOrNull.m5257unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UShort uShortOrNull = toUShortOrNull(str);
        if (uShortOrNull != null) {
            return uShortOrNull.m5324unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str);
        if (uIntOrNull != null) {
            return uIntOrNull.m5279unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ULong uLongOrNull = toULongOrNull(str);
        if (uLongOrNull != null) {
            return uLongOrNull.m5302unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUByteOrNull(str, 10);
    }

    public static final UByte toUByteOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int iM5279unboximpl = uIntOrNull.m5279unboximpl();
        if (Integer.compare(iM5279unboximpl ^ LinearLayoutManager.INVALID_OFFSET, UInt.m5275constructorimpl(255) ^ LinearLayoutManager.INVALID_OFFSET) > 0) {
            return null;
        }
        return UByte.m5252boximpl(UByte.m5253constructorimpl((byte) iM5279unboximpl));
    }

    public static final UShort toUShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUShortOrNull(str, 10);
    }

    public static final UShort toUShortOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        UInt uIntOrNull = toUIntOrNull(str, i);
        if (uIntOrNull == null) {
            return null;
        }
        int iM5279unboximpl = uIntOrNull.m5279unboximpl();
        if (Integer.compare(iM5279unboximpl ^ LinearLayoutManager.INVALID_OFFSET, UInt.m5275constructorimpl(Settings.DEFAULT_INITIAL_WINDOW_SIZE) ^ LinearLayoutManager.INVALID_OFFSET) > 0) {
            return null;
        }
        return UShort.m5319boximpl(UShort.m5320constructorimpl((short) iM5279unboximpl));
    }

    public static final UInt toUIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toUIntOrNull(str, 10);
    }

    public static final UInt toUIntOrNull(String str, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iM5275constructorimpl = UInt.m5275constructorimpl(i);
        int iM = 119304647;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (Integer.compare(i3 ^ LinearLayoutManager.INVALID_OFFSET, iM ^ LinearLayoutManager.INVALID_OFFSET) > 0) {
                if (iM == 119304647) {
                    iM = UStringsKt$$ExternalSyntheticBackport1.m(-1, iM5275constructorimpl);
                    if (Integer.compare(i3 ^ LinearLayoutManager.INVALID_OFFSET, iM ^ LinearLayoutManager.INVALID_OFFSET) > 0) {
                    }
                }
                return null;
            }
            int iM5275constructorimpl2 = UInt.m5275constructorimpl(i3 * iM5275constructorimpl);
            int iM5275constructorimpl3 = UInt.m5275constructorimpl(UInt.m5275constructorimpl(iDigitOf) + iM5275constructorimpl2);
            if (Integer.compare(iM5275constructorimpl3 ^ LinearLayoutManager.INVALID_OFFSET, iM5275constructorimpl2 ^ LinearLayoutManager.INVALID_OFFSET) < 0) {
                return null;
            }
            i2++;
            i3 = iM5275constructorimpl3;
        }
        return UInt.m5274boximpl(i3);
    }

    public static final ULong toULongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toULongOrNull(str, 10);
    }

    public static final ULong toULongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (Intrinsics.compare((int) cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jM5297constructorimpl = ULong.m5297constructorimpl(i);
        long j = 0;
        long jM = 512409557603043100L;
        while (i2 < length) {
            int iDigitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (iDigitOf < 0) {
                return null;
            }
            if (Long.compare(j ^ Long.MIN_VALUE, jM ^ Long.MIN_VALUE) > 0) {
                if (jM == 512409557603043100L) {
                    jM = DD128bTraceId$$ExternalSyntheticBackport2.m(-1L, jM5297constructorimpl);
                    if (Long.compare(j ^ Long.MIN_VALUE, jM ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jM5297constructorimpl2 = ULong.m5297constructorimpl(j * jM5297constructorimpl);
            long jM5297constructorimpl3 = ULong.m5297constructorimpl(ULong.m5297constructorimpl(((long) UInt.m5275constructorimpl(iDigitOf)) & 4294967295L) + jM5297constructorimpl2);
            if (Long.compare(jM5297constructorimpl3 ^ Long.MIN_VALUE, jM5297constructorimpl2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            j = jM5297constructorimpl3;
        }
        return ULong.m5296boximpl(j);
    }
}
