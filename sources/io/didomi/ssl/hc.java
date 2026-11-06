package io.didomi.ssl;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import com.amazon.device.iap.internal.c.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0000\u001a\u0014\u0010\u0001\u001a\u00020\u0002*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u0014\u0010\u0001\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"", "a", "Landroid/text/SpannableString;", "b", "", b.as, "android_release"}, k = 2, mv = {1, 8, 0})
public final class hc {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.trim(StringsKt.substringBeforeLast$default(str, "→", (String) null, 2, (Object) null)).toString();
    }

    public static final SpannableString b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String string = StringsKt.trim(str).toString();
        if (!StringsKt.endsWith$default(string, "→", false, 2, (Object) null)) {
            string = StringsKt.trim(string + " →").toString();
        }
        return new SpannableString(string);
    }

    public static final SpannableString a(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, "→", 0, false, 6, (Object) null) - 1;
        if (iIndexOf$default > 0) {
            spannableString.setSpan(new x(i), iIndexOf$default, spannableString.length(), 33);
        }
        return spannableString;
    }

    public static /* synthetic */ SpannableString a(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        return a(str, i);
    }

    public static /* synthetic */ SpannableString a(SpannableString spannableString, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 5;
        }
        return a(spannableString, i);
    }

    public static final SpannableString a(SpannableString spannableString, int i) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, "→", 0, false, 6, (Object) null) - 1;
        if (iIndexOf$default > 0) {
            spannableString.setSpan(new UnderlineSpan(), 0, iIndexOf$default, 33);
            spannableString.setSpan(new x(i), iIndexOf$default, spannableString.length(), 33);
            return spannableString;
        }
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
        return spannableString;
    }
}
