package com.datadog.android.trace.internal.domain.event;

import java.math.BigInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BigIntegerUtils {
    public static final BigIntegerUtils INSTANCE = new BigIntegerUtils();
    private static final BigInteger LONG_MASK = new BigInteger("ffffffffffffffff", 16);

    private BigIntegerUtils() {
    }

    public final String leastSignificant64BitsAsHex(BigInteger traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        try {
            String string = traceId.and(LONG_MASK).toString(16);
            Intrinsics.checkNotNullExpressionValue(string, "traceId.and(LONG_MASK).toString(HEX_RADIX)");
            return StringsKt.padStart(string, 16, '0');
        } catch (ArithmeticException | NumberFormatException | IllegalArgumentException unused) {
            return "";
        }
    }

    public final String mostSignificant64BitsAsHex(BigInteger traceId) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        try {
            String string = traceId.shiftRight(64).toString(16);
            Intrinsics.checkNotNullExpressionValue(string, "traceId.shiftRight(LONG_…SIZE).toString(HEX_RADIX)");
            return StringsKt.padStart(string, 16, '0');
        } catch (ArithmeticException | NumberFormatException | IllegalArgumentException unused) {
            return "";
        }
    }
}
