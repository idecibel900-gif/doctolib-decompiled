package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"createLocaleFromString", "Ljava/util/Locale;", "localeString", "", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocaleHelpersKt {
    public static final Locale createLocaleFromString(String localeString) {
        List listSplit$default;
        Intrinsics.checkNotNullParameter(localeString, "localeString");
        if (StringsKt.contains$default((CharSequence) localeString, '-', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) localeString, '_', false, 2, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) localeString, '-', false, 2, (Object) null)) {
                listSplit$default = StringsKt.split$default((CharSequence) localeString, new char[]{'-'}, false, 2, 2, (Object) null);
            } else {
                listSplit$default = StringsKt.split$default((CharSequence) localeString, new char[]{'_'}, false, 2, 2, (Object) null);
            }
            if (listSplit$default.size() >= 2) {
                return new Locale((String) listSplit$default.get(0), (String) listSplit$default.get(1));
            }
            return new Locale((String) listSplit$default.get(0));
        }
        return new Locale(localeString);
    }
}
