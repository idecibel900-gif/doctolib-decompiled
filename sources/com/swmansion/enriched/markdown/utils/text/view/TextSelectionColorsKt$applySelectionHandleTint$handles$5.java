package com.swmansion.enriched.markdown.utils.text.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class TextSelectionColorsKt$applySelectionHandleTint$handles$5 extends FunctionReferenceImpl implements Function1 {
    public static final TextSelectionColorsKt$applySelectionHandleTint$handles$5 INSTANCE = new TextSelectionColorsKt$applySelectionHandleTint$handles$5();

    TextSelectionColorsKt$applySelectionHandleTint$handles$5() {
        super(1, TextView.class, "getTextSelectHandleRight", "getTextSelectHandleRight()Landroid/graphics/drawable/Drawable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Drawable invoke(TextView p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.getTextSelectHandleRight();
    }
}
