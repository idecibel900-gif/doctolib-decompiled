package com.swmansion.rnscreens.bottomsheet;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BottomSheetBehaviorExtKt {
    public static /* synthetic */ BottomSheetBehavior updateMetrics$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return updateMetrics(bottomSheetBehavior, num, num2);
    }

    public static final BottomSheetBehavior updateMetrics(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        if (num != null) {
            bottomSheetBehavior.setMaxHeight(num.intValue());
        }
        if (num2 != null) {
            bottomSheetBehavior.setExpandedOffset(num2.intValue());
        }
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useSingleDetent$default(BottomSheetBehavior bottomSheetBehavior, Integer num, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return useSingleDetent(bottomSheetBehavior, num, z, bool);
    }

    public static final BottomSheetBehavior useSingleDetent(BottomSheetBehavior bottomSheetBehavior, Integer num, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.setFitToContents(true);
        if (z) {
            bottomSheetBehavior.setState(3);
        }
        if (num != null) {
            bottomSheetBehavior.setMaxHeight(num.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useTwoDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        return useTwoDetents(bottomSheetBehavior, num, num2, num3, bool);
    }

    public static final BottomSheetBehavior useTwoDetents(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(true);
        if (num != null) {
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (num3 != null) {
            bottomSheetBehavior.setMaxHeight(num3.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useThreeDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Float f, Integer num4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            f = null;
        }
        if ((i & 16) != 0) {
            num4 = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        return useThreeDetents(bottomSheetBehavior, num, num2, num3, f, num4, bool);
    }

    public static final BottomSheetBehavior useThreeDetents(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Float f, Integer num4, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(false);
        if (num != null) {
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (f != null) {
            bottomSheetBehavior.setHalfExpandedRatio(f.floatValue());
        }
        if (num4 != null) {
            bottomSheetBehavior.setExpandedOffset(num4.intValue());
        }
        if (num3 != null) {
            bottomSheetBehavior.setMaxHeight(num3.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    private static final void maybeApplyManualInsetsAdjustmentWorkaround(BottomSheetBehavior bottomSheetBehavior, Boolean bool) {
        if (bool != null) {
            bottomSheetBehavior.setGestureInsetBottomIgnored(bool.booleanValue());
        }
    }

    public static final int fitToContentsSheetHeight(BottomSheetBehavior bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        return bottomSheetBehavior.getMaxHeight();
    }
}
