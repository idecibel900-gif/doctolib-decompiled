package coil.decode;

import coil.size.Scale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DecodeUtils {
    public static final DecodeUtils INSTANCE = new DecodeUtils();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DecodeUtils() {
    }

    public static final int calculateInSampleSize(int i, int i2, int i3, int i4, Scale scale) {
        int iMin;
        int iHighestOneBit = Integer.highestOneBit(i / i3);
        int iHighestOneBit2 = Integer.highestOneBit(i2 / i4);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
        }
        return RangesKt.coerceAtLeast(iMin, 1);
    }

    public static final double computeSizeMultiplier(int i, int i2, int i3, int i4, Scale scale) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int i5 = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final double computeSizeMultiplier(double d, double d2, double d3, double d4, Scale scale) {
        double d5 = d3 / d;
        double d6 = d4 / d2;
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Math.max(d5, d6);
        }
        if (i == 2) {
            return Math.min(d5, d6);
        }
        throw new NoWhenBranchMatchedException();
    }
}
