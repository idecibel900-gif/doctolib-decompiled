package io.didomi.ssl;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0003"}, d2 = {"Ljava/util/Locale;", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class t7 {
    public static final String a(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String language = locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "language");
        if (StringsKt.isBlank(language)) {
            return "";
        }
        String country = locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "country");
        if (StringsKt.isBlank(country)) {
            String language2 = locale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language2, "language");
            return language2;
        }
        return locale.getLanguage() + '-' + locale.getCountry();
    }
}
