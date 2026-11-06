package kotlin.random;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RandomKt {
    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    public static final long nextLong(Random random, LongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (range.getLast() < Long.MAX_VALUE) {
                return random.nextLong(range.getFirst(), range.getLast() + 1);
            }
            return range.getFirst() > Long.MIN_VALUE ? random.nextLong(range.getFirst() - 1, range.getLast()) + 1 : random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }
}
