package io.didomi.ssl;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\t"}, d2 = {"Landroid/text/Spanned;", "", "textSize", "Landroid/text/Spannable;", "a", "", "", "start", "index", "android_release"}, k = 2, mv = {1, 8, 0})
public final class dc {
    public static final int a(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int iIndexOf$default = StringsKt.indexOf$default(charSequence, "\n", i, false, 4, (Object) null);
        return iIndexOf$default > 0 ? iIndexOf$default : charSequence.length();
    }

    public static final int a(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.indexOf$default(charSequence, i + ". ", i2, false, 4, (Object) null);
    }

    public static /* synthetic */ int a(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(charSequence, i, i2);
    }

    public static final Spannable a(Spanned spanned, float f) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(spanned);
        Intrinsics.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        int iA = a(spannableStringValueOf, 1, 0, 2, null);
        if (iA >= 0) {
            spannableStringValueOf.setSpan(new LeadingMarginSpan.Standard(0, (int) (2 * f)), iA, a((CharSequence) spannableStringValueOf, iA), 18);
            int iA2 = a(spannableStringValueOf, 2, 0, 2, null);
            if (iA2 >= 0) {
                int i = 2;
                while (a(spannableStringValueOf, i, 0, 2, null) > 0) {
                    i++;
                }
                int iA3 = a(spannableStringValueOf, i - 1, 0, 2, null);
                int iA4 = a(spannableStringValueOf, 10, iA2);
                if (iA4 < 0) {
                    spannableStringValueOf.setSpan(new LeadingMarginSpan.Standard(0, (int) (((double) f) * 2.6d)), iA2, a((CharSequence) spannableStringValueOf, iA3), 18);
                } else {
                    double d = f;
                    spannableStringValueOf.setSpan(new LeadingMarginSpan.Standard(0, (int) (2.6d * d)), iA2, iA4, 18);
                    spannableStringValueOf.setSpan(new LeadingMarginSpan.Standard(0, (int) (d * 3.3d)), a(spannableStringValueOf, 10, iA2), a((CharSequence) spannableStringValueOf, iA3), 18);
                }
            }
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableStringValueOf, "• ", 0, false, 6, (Object) null);
        if (iIndexOf$default >= 0) {
            spannableStringValueOf.setSpan(new LeadingMarginSpan.Standard(0, (int) (((double) f) * 1.6d)), iIndexOf$default, a((CharSequence) spannableStringValueOf, StringsKt.lastIndexOf$default((CharSequence) spannableStringValueOf, "• ", 0, false, 6, (Object) null)), 18);
        }
        return spannableStringValueOf;
    }
}
