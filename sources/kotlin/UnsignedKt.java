package kotlin;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UnsignedKt {
    public static final double uintToDouble(int i) {
        return ((double) (Integer.MAX_VALUE & i)) + (((double) ((i >>> 31) << 30)) * ((double) 2));
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * ((double) 2048)) + (j & 2047);
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ LinearLayoutManager.INVALID_OFFSET, i2 ^ LinearLayoutManager.INVALID_OFFSET);
    }

    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return UInt.m5275constructorimpl((int) d);
        }
        return UInt.m5275constructorimpl(UInt.m5275constructorimpl((int) (d - ((double) Integer.MAX_VALUE))) + UInt.m5275constructorimpl(Integer.MAX_VALUE));
    }

    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
