package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ScaleTypeStartInside extends ScalingUtils$AbstractScaleType {
    public static final Companion Companion = new Companion(null);
    private static final ScalingUtils$ScaleType INSTANCE = new ScaleTypeStartInside();

    @Override // com.facebook.drawee.drawable.ScalingUtils$AbstractScaleType
    public void getTransformImpl(Matrix outTransform, Rect parentRect, int i, int i2, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(outTransform, "outTransform");
        Intrinsics.checkNotNullParameter(parentRect, "parentRect");
        float fCoerceAtMost = RangesKt.coerceAtMost(Math.min(f3, f4), 1.0f);
        float f5 = parentRect.left;
        float f6 = parentRect.top;
        outTransform.setScale(fCoerceAtMost, fCoerceAtMost);
        outTransform.postTranslate(Math.round(f5), Math.round(f6));
    }

    public String toString() {
        return "start_inside";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScalingUtils$ScaleType getINSTANCE() {
            return ScaleTypeStartInside.INSTANCE;
        }
    }
}
