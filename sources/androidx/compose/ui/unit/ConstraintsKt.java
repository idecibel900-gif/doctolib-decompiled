package androidx.compose.ui.unit;

import kotlin.KotlinNothingValueException;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintsKt {
    private static final int bitsNeedForSizeUnchecked(int i) {
        if (i < 8191) {
            return 13;
        }
        if (i < 32767) {
            return 15;
        }
        if (i < 65535) {
            return 16;
        }
        return i < 262143 ? 18 : 255;
    }

    private static final void invalidConstraint(int i, int i2) {
        throw new IllegalArgumentException("Can't represent a width of " + i + " and height of " + i2 + " in Constraints");
    }

    private static final Void invalidSize(int i) {
        throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
    }

    public static final long createConstraints(int i, int i2, int i3, int i4) {
        int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
        int iBitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i5);
        int i6 = i2 == Integer.MAX_VALUE ? i : i2;
        int iBitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i6);
        if (iBitsNeedForSizeUnchecked + iBitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i6, i5);
        }
        int i7 = i2 + 1;
        int i8 = i7 & (~(i7 >> 31));
        int i9 = i4 + 1;
        int i10 = i9 & (~(i9 >> 31));
        int i11 = 0;
        if (iBitsNeedForSizeUnchecked2 != 13) {
            if (iBitsNeedForSizeUnchecked2 == 18) {
                i11 = 3;
            } else if (iBitsNeedForSizeUnchecked2 == 15) {
                i11 = 1;
            } else if (iBitsNeedForSizeUnchecked2 == 16) {
                i11 = 2;
            }
        }
        int i12 = ((i11 & 1) << 1) + (((i11 & 2) >> 1) * 3);
        return Constraints.m2520constructorimpl((((long) i8) << 33) | ((long) i11) | (((long) i) << 2) | (((long) i3) << (i12 + 15)) | (((long) i10) << (i12 + 46)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i) {
        if (i < 8191) {
            return 262142;
        }
        if (i < 32767) {
            return 65534;
        }
        if (i < 65535) {
            return 32766;
        }
        if (i < 262143) {
            return 8190;
        }
        invalidSize(i);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (!(i2 >= i)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')');
        }
        if (!(i4 >= i3)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')');
        }
        if (i >= 0 && i3 >= 0) {
            z = true;
        }
        if (!z) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0");
        }
        return createConstraints(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m2543constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m2532getMinWidthimpl(j2), Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2530getMaxWidthimpl(j2), Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m2531getMinHeightimpl(j2), Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m2529getMaxHeightimpl(j2), Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m2542constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m2609getWidthimpl(j2), Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m2608getHeightimpl(j2), Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j)));
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m2545constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m2544constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m2546isSatisfiedBy4WqzIAM(long j, long j2) {
        int iM2532getMinWidthimpl = Constraints.m2532getMinWidthimpl(j);
        int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
        int iM2609getWidthimpl = IntSize.m2609getWidthimpl(j2);
        if (iM2532getMinWidthimpl > iM2609getWidthimpl || iM2609getWidthimpl > iM2530getMaxWidthimpl) {
            return false;
        }
        int iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
        int iM2529getMaxHeightimpl = Constraints.m2529getMaxHeightimpl(j);
        int iM2608getHeightimpl = IntSize.m2608getHeightimpl(j2);
        return iM2531getMinHeightimpl <= iM2608getHeightimpl && iM2608getHeightimpl <= iM2529getMaxHeightimpl;
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m2548offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m2547offsetNN6EwU(j, i, i2);
    }

    /* JADX INFO: renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m2547offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m2532getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m2530getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m2531getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m2529getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }
}
