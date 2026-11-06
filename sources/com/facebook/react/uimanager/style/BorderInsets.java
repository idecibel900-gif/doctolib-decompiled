package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.RectF;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BorderInsets {
    private final Float[] edgeInsets = new Float[LogicalEdge.values().length];

    public final void setBorderWidth(LogicalEdge edge, Float f) {
        Intrinsics.checkNotNullParameter(edge, "edge");
        this.edgeInsets[edge.ordinal()] = f;
    }

    public final RectF resolve(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == 0) {
            Float f = this.edgeInsets[LogicalEdge.START.ordinal()];
            float fFloatValue = (f == null && (f = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f.floatValue();
            Float f2 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
            float fFloatValue2 = (f2 == null && (f2 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f2 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f2.floatValue();
            Float f3 = this.edgeInsets[LogicalEdge.END.ordinal()];
            float fFloatValue3 = (f3 == null && (f3 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f3 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f3 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f3.floatValue();
            Float f4 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
            return new RectF(fFloatValue, fFloatValue2, fFloatValue3, (f4 == null && (f4 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f4 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f4 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f4 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f4.floatValue());
        }
        if (i == 1) {
            if (I18nUtil.Companion.getInstance().doLeftAndRightSwapInRTL(context)) {
                Float f5 = this.edgeInsets[LogicalEdge.END.ordinal()];
                float fFloatValue4 = (f5 == null && (f5 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f5 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f5 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f5.floatValue();
                Float f6 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
                float fFloatValue5 = (f6 == null && (f6 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f6 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f6 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f6 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f6.floatValue();
                Float f7 = this.edgeInsets[LogicalEdge.START.ordinal()];
                float fFloatValue6 = (f7 == null && (f7 = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f7 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f7 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f7.floatValue();
                Float f8 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
                return new RectF(fFloatValue4, fFloatValue5, fFloatValue6, (f8 == null && (f8 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f8 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f8 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f8 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f8.floatValue());
            }
            Float f9 = this.edgeInsets[LogicalEdge.END.ordinal()];
            float fFloatValue7 = (f9 == null && (f9 = this.edgeInsets[LogicalEdge.LEFT.ordinal()]) == null && (f9 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f9 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f9.floatValue();
            Float f10 = this.edgeInsets[LogicalEdge.BLOCK_START.ordinal()];
            float fFloatValue8 = (f10 == null && (f10 = this.edgeInsets[LogicalEdge.TOP.ordinal()]) == null && (f10 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f10 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f10 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f10.floatValue();
            Float f11 = this.edgeInsets[LogicalEdge.START.ordinal()];
            float fFloatValue9 = (f11 == null && (f11 = this.edgeInsets[LogicalEdge.RIGHT.ordinal()]) == null && (f11 = this.edgeInsets[LogicalEdge.HORIZONTAL.ordinal()]) == null && (f11 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f11.floatValue();
            Float f12 = this.edgeInsets[LogicalEdge.BLOCK_END.ordinal()];
            return new RectF(fFloatValue7, fFloatValue8, fFloatValue9, (f12 == null && (f12 = this.edgeInsets[LogicalEdge.BOTTOM.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.BLOCK.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.VERTICAL.ordinal()]) == null && (f12 = this.edgeInsets[LogicalEdge.ALL.ordinal()]) == null) ? 0.0f : f12.floatValue());
        }
        throw new IllegalArgumentException("Expected resolved layout direction");
    }
}
