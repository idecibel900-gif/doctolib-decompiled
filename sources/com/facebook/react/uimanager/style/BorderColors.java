package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BorderColors {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Integer[] m3458constructorimpl(Integer[] edgeColors) {
        Intrinsics.checkNotNullParameter(edgeColors, "edgeColors");
        return edgeColors;
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Integer[] m3459constructorimpl$default(Integer[] numArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            numArr = new Integer[LogicalEdge.values().length];
        }
        return m3458constructorimpl(numArr);
    }

    /* JADX INFO: renamed from: resolve-impl, reason: not valid java name */
    public static final ColorEdges m3460resolveimpl(Integer[] numArr, int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int iIntValue = -16777216;
        if (i == 0) {
            Integer num = numArr[LogicalEdge.START.ordinal()];
            int iIntValue2 = (num == null && (num = numArr[LogicalEdge.LEFT.ordinal()]) == null && (num = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num.intValue();
            Integer num2 = numArr[LogicalEdge.BLOCK_START.ordinal()];
            int iIntValue3 = (num2 == null && (num2 = numArr[LogicalEdge.TOP.ordinal()]) == null && (num2 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num2 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null && (num2 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num2.intValue();
            Integer num3 = numArr[LogicalEdge.END.ordinal()];
            int iIntValue4 = (num3 == null && (num3 = numArr[LogicalEdge.RIGHT.ordinal()]) == null && (num3 = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num3 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num3.intValue();
            Integer num4 = numArr[LogicalEdge.BLOCK_END.ordinal()];
            if (num4 == null && (num4 = numArr[LogicalEdge.BOTTOM.ordinal()]) == null && (num4 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num4 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null) {
                Integer num5 = numArr[LogicalEdge.ALL.ordinal()];
                if (num5 != null) {
                    iIntValue = num5.intValue();
                }
            } else {
                iIntValue = num4.intValue();
            }
            return new ColorEdges(iIntValue2, iIntValue3, iIntValue4, iIntValue);
        }
        if (i == 1) {
            if (I18nUtil.Companion.getInstance().doLeftAndRightSwapInRTL(context)) {
                Integer num6 = numArr[LogicalEdge.END.ordinal()];
                int iIntValue5 = (num6 == null && (num6 = numArr[LogicalEdge.RIGHT.ordinal()]) == null && (num6 = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num6 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num6.intValue();
                Integer num7 = numArr[LogicalEdge.BLOCK_START.ordinal()];
                int iIntValue6 = (num7 == null && (num7 = numArr[LogicalEdge.TOP.ordinal()]) == null && (num7 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num7 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null && (num7 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num7.intValue();
                Integer num8 = numArr[LogicalEdge.START.ordinal()];
                int iIntValue7 = (num8 == null && (num8 = numArr[LogicalEdge.LEFT.ordinal()]) == null && (num8 = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num8 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num8.intValue();
                Integer num9 = numArr[LogicalEdge.BLOCK_END.ordinal()];
                if (num9 == null && (num9 = numArr[LogicalEdge.BOTTOM.ordinal()]) == null && (num9 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num9 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null) {
                    Integer num10 = numArr[LogicalEdge.ALL.ordinal()];
                    if (num10 != null) {
                        iIntValue = num10.intValue();
                    }
                } else {
                    iIntValue = num9.intValue();
                }
                return new ColorEdges(iIntValue5, iIntValue6, iIntValue7, iIntValue);
            }
            Integer num11 = numArr[LogicalEdge.END.ordinal()];
            int iIntValue8 = (num11 == null && (num11 = numArr[LogicalEdge.LEFT.ordinal()]) == null && (num11 = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num11 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num11.intValue();
            Integer num12 = numArr[LogicalEdge.BLOCK_START.ordinal()];
            int iIntValue9 = (num12 == null && (num12 = numArr[LogicalEdge.TOP.ordinal()]) == null && (num12 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num12 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null && (num12 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num12.intValue();
            Integer num13 = numArr[LogicalEdge.START.ordinal()];
            int iIntValue10 = (num13 == null && (num13 = numArr[LogicalEdge.RIGHT.ordinal()]) == null && (num13 = numArr[LogicalEdge.HORIZONTAL.ordinal()]) == null && (num13 = numArr[LogicalEdge.ALL.ordinal()]) == null) ? -16777216 : num13.intValue();
            Integer num14 = numArr[LogicalEdge.BLOCK_END.ordinal()];
            if (num14 == null && (num14 = numArr[LogicalEdge.BOTTOM.ordinal()]) == null && (num14 = numArr[LogicalEdge.BLOCK.ordinal()]) == null && (num14 = numArr[LogicalEdge.VERTICAL.ordinal()]) == null) {
                Integer num15 = numArr[LogicalEdge.ALL.ordinal()];
                if (num15 != null) {
                    iIntValue = num15.intValue();
                }
            } else {
                iIntValue = num14.intValue();
            }
            return new ColorEdges(iIntValue8, iIntValue9, iIntValue10, iIntValue);
        }
        throw new IllegalArgumentException("Expected resolved layout direction");
    }
}
