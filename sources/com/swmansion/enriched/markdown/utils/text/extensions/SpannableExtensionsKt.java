package com.swmansion.enriched.markdown.utils.text.extensions;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SpannableExtensionsKt {
    public static final void replaceMathSpansWithPlaceholders(SpannableString spannableString, Context context) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final boolean isInlineImage(SpannableStringBuilder spannableStringBuilder) {
        char cLast;
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<this>");
        return (spannableStringBuilder.length() == 0 || (cLast = StringsKt.last(spannableStringBuilder)) == '\n' || cLast == 8203) ? false : true;
    }
}
