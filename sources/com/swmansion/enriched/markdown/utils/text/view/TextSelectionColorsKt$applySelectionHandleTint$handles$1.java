package com.swmansion.enriched.markdown.utils.text.view;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class TextSelectionColorsKt$applySelectionHandleTint$handles$1 extends FunctionReferenceImpl implements Function1 {
    public static final TextSelectionColorsKt$applySelectionHandleTint$handles$1 INSTANCE = new TextSelectionColorsKt$applySelectionHandleTint$handles$1();

    TextSelectionColorsKt$applySelectionHandleTint$handles$1() {
        super(1, TextView.class, "getTextSelectHandleLeft", "getTextSelectHandleLeft()Landroid/graphics/drawable/Drawable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Drawable invoke(TextView p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.getTextSelectHandleLeft();
    }
}
