package com.swmansion.enriched.markdown.utils.text.view;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TextSelectionColorsKt {
    public static final void applySelectionColors(TextView textView, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (num != null) {
            textView.setHighlightColor(num.intValue());
        }
        if (num2 != null) {
            applySelectionHandleTint(textView, num2.intValue());
        }
    }

    private static final void applySelectionHandleTint(TextView textView, int i) {
        Drawable drawableMutate;
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(TextSelectionColorsKt$applySelectionHandleTint$handles$1.INSTANCE, new Function2() { // from class: com.swmansion.enriched.markdown.utils.text.view.TextSelectionColorsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TextSelectionColorsKt.applySelectionHandleTint$lambda$2((TextView) obj, (Drawable) obj2);
            }
        }), TuplesKt.to(TextSelectionColorsKt$applySelectionHandleTint$handles$3.INSTANCE, new Function2() { // from class: com.swmansion.enriched.markdown.utils.text.view.TextSelectionColorsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TextSelectionColorsKt.applySelectionHandleTint$lambda$3((TextView) obj, (Drawable) obj2);
            }
        }), TuplesKt.to(TextSelectionColorsKt$applySelectionHandleTint$handles$5.INSTANCE, new Function2() { // from class: com.swmansion.enriched.markdown.utils.text.view.TextSelectionColorsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return TextSelectionColorsKt.applySelectionHandleTint$lambda$4((TextView) obj, (Drawable) obj2);
            }
        })})) {
            Function1 function1 = (Function1) pair.getFirst();
            Function2 function2 = (Function2) pair.getSecond();
            try {
                Drawable drawable = (Drawable) function1.invoke(textView);
                if (drawable != null && (drawableMutate = drawable.mutate()) != null) {
                    DrawableCompat.setTint(drawableMutate, i);
                    function2.invoke(textView, drawableMutate);
                }
            } catch (LinkageError e) {
                e.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applySelectionHandleTint$lambda$2(TextView tv, Drawable d) {
        Intrinsics.checkNotNullParameter(tv, "tv");
        Intrinsics.checkNotNullParameter(d, "d");
        tv.setTextSelectHandleLeft(d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applySelectionHandleTint$lambda$3(TextView tv, Drawable d) {
        Intrinsics.checkNotNullParameter(tv, "tv");
        Intrinsics.checkNotNullParameter(d, "d");
        tv.setTextSelectHandle(d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applySelectionHandleTint$lambda$4(TextView tv, Drawable d) {
        Intrinsics.checkNotNullParameter(tv, "tv");
        Intrinsics.checkNotNullParameter(d, "d");
        tv.setTextSelectHandleRight(d);
        return Unit.INSTANCE;
    }
}
