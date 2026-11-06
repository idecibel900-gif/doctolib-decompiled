package com.facebook.react.views.view;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.yoga.YogaMeasureMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MeasureUtil {
    public static final MeasureUtil INSTANCE = new MeasureUtil();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[YogaMeasureMode.values().length];
            try {
                iArr[YogaMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YogaMeasureMode.AT_MOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MeasureUtil() {
    }

    public static final int getMeasureSpec(float f, YogaMeasureMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return View.MeasureSpec.makeMeasureSpec((int) f, 1073741824);
        }
        if (i == 2) {
            return View.MeasureSpec.makeMeasureSpec((int) f, LinearLayoutManager.INVALID_OFFSET);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
