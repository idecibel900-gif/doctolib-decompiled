package com.swmansion.rnscreens;

import android.content.Context;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CustomAppBarLayout extends AppBarLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAppBarLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void applyToolbarLayoutCorrection$react_native_screens_release(int i) {
        applyFrameCorrectionByTopInset(i);
    }

    private final void applyFrameCorrectionByTopInset(int i) {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight() + i, 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom() + i);
    }
}
