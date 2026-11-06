package io.didomi.ssl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003JN\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/s7;", "", "", "", "locales", "locale", "b", "", "a", "", "defaultCountries", "fallbackCodes", "Ljava/util/Locale;", "defaultLocale", "language", "locale1", "locale2", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class s7 {
    public static final s7 a = new s7();

    private s7() {
    }

    public final boolean a(Set<String> locales, String locale) {
        if (locales == null || locales.isEmpty() || locale == null || StringsKt.isBlank(locale)) {
            return false;
        }
        if ((locales instanceof Collection) && locales.isEmpty()) {
            return false;
        }
        Iterator<T> it = locales.iterator();
        while (it.hasNext()) {
            if (a.a((String) it.next(), locale)) {
                return true;
            }
        }
        return false;
    }

    public final String b(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return (String) StringsKt.split$default((CharSequence) locale, new String[]{"-"}, false, 0, 6, (Object) null).get(0);
    }

    private final String b(Set<String> locales, String locale) {
        Object next;
        Iterator<T> it = locales.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (StringsKt.equals((String) next, (String) za.a.c().split(locale, 0).get(0), true)) {
                return (String) next;
            }
        }
        next = null;
        return (String) next;
    }

    public final String a(Set<String> locales, Map<String, String> defaultCountries, Map<String, String> fallbackCodes, Locale defaultLocale) {
        Object obj = null;
        String language = defaultLocale != null ? defaultLocale.getLanguage() : null;
        String str = defaultCountries != null ? defaultCountries.get(language) : null;
        String str2 = fallbackCodes != null ? fallbackCodes.get(language) : null;
        if (locales == null || locales.isEmpty() || defaultLocale == null) {
            return null;
        }
        if (!(locales instanceof Collection) || !locales.isEmpty()) {
            Iterator<T> it = locales.iterator();
            while (it.hasNext()) {
                if (a.a((String) it.next(), t7.a(defaultLocale))) {
                    for (Object obj2 : locales) {
                        if (a.a((String) obj2, t7.a(defaultLocale))) {
                            obj = obj2;
                            break;
                        }
                    }
                    return (String) obj;
                }
            }
        }
        if (defaultCountries != null && !defaultCountries.isEmpty() && str != null && !StringsKt.isBlank(str)) {
            if (a(locales, language + '-' + str)) {
                return language + '-' + str;
            }
        }
        if (str2 != null && !StringsKt.isBlank(str2) && a(locales, str2)) {
            return str2;
        }
        String language2 = defaultLocale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language2, "defaultLocale.language");
        return b(locales, language2);
    }

    public final Locale a(String language) {
        if (!wg.a.b(language)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            return locale;
        }
        Intrinsics.checkNotNull(language, "null cannot be cast to non-null type kotlin.String");
        za zaVar = za.a;
        if (zaVar.c().containsMatchIn(language)) {
            List listSplit = zaVar.c().split(language, 0);
            String str = (String) listSplit.get(0);
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = str.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String str2 = (String) listSplit.get(1);
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String upperCase = str2.toUpperCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return new Locale(lowerCase, upperCase);
        }
        return new Locale(language);
    }

    public final boolean a(String locale1, String locale2) {
        if (locale1 == null || StringsKt.isBlank(locale1) || locale2 == null || StringsKt.isBlank(locale2)) {
            return false;
        }
        if (!StringsKt.equals(locale1, locale2, true)) {
            za zaVar = za.a;
            if (!StringsKt.equals(zaVar.c().replace(locale1, "-"), zaVar.c().replace(locale2, "-"), true)) {
                return false;
            }
        }
        return true;
    }
}
