package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocaleMatcher {

    public static class LocaleMatchResult {
        public HashMap extensions = new HashMap();
        public ILocaleObject matchedLocale;
    }

    public static String BestAvailableLocale(String[] strArr, String str) {
        while (Arrays.asList(strArr).indexOf(str) <= -1) {
            int iLastIndexOf = str.lastIndexOf("-");
            if (iLastIndexOf < 0) {
                return "";
            }
            if (iLastIndexOf >= 2 && str.charAt(iLastIndexOf - 2) == '-') {
                iLastIndexOf -= 2;
            }
            str = str.substring(0, iLastIndexOf);
        }
        return str;
    }

    public static LocaleMatchResult lookupMatch(String[] strArr, String[] strArr2) {
        LocaleMatchResult localeMatchResult = new LocaleMatchResult();
        for (String str : strArr) {
            ILocaleObject iLocaleObjectCreateFromLocaleId = LocaleObject.createFromLocaleId(str);
            String strBestAvailableLocale = BestAvailableLocale(strArr2, iLocaleObjectCreateFromLocaleId.toCanonicalTagWithoutExtensions());
            if (!strBestAvailableLocale.isEmpty()) {
                localeMatchResult.matchedLocale = LocaleObject.createFromLocaleId(strBestAvailableLocale);
                localeMatchResult.extensions = iLocaleObjectCreateFromLocaleId.getUnicodeExtensions();
                return localeMatchResult;
            }
        }
        localeMatchResult.matchedLocale = LocaleObject.createDefault();
        return localeMatchResult;
    }

    public static String[] getAvailableLocales() {
        ArrayList arrayList = new ArrayList();
        for (Locale locale : Locale.getAvailableLocales()) {
            arrayList.add(locale.toLanguageTag());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static LocaleMatchResult lookupMatch(String[] strArr) {
        return lookupMatch(strArr, getAvailableLocales());
    }

    public static String[] lookupSupportedLocales(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        String[] availableLocales = getAvailableLocales();
        for (String str : strArr) {
            String strBestAvailableLocale = BestAvailableLocale(availableLocales, LocaleObject.createFromLocaleId(str).toCanonicalTagWithoutExtensions());
            if (strBestAvailableLocale != null && !strBestAvailableLocale.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static ULocale bestFitBestAvailableLocale(ILocaleObject iLocaleObject) {
        boolean[] zArr = new boolean[1];
        ULocale uLocaleAcceptLanguage = ULocale.acceptLanguage(new ULocale[]{(ULocale) iLocaleObject.getLocaleWithoutExtensions()}, ULocale.getAvailableLocales(), zArr);
        if (zArr[0] || uLocaleAcceptLanguage == null) {
            return null;
        }
        return uLocaleAcceptLanguage;
    }

    public static LocaleMatchResult bestFitMatch(String[] strArr) {
        LocaleMatchResult localeMatchResult = new LocaleMatchResult();
        for (String str : strArr) {
            ILocaleObject iLocaleObjectCreateFromLocaleId = LocaleObject.createFromLocaleId(str);
            ULocale uLocaleBestFitBestAvailableLocale = bestFitBestAvailableLocale(iLocaleObjectCreateFromLocaleId);
            if (uLocaleBestFitBestAvailableLocale != null) {
                localeMatchResult.matchedLocale = LocaleObjectICU.createFromULocale(uLocaleBestFitBestAvailableLocale);
                localeMatchResult.extensions = iLocaleObjectCreateFromLocaleId.getUnicodeExtensions();
                return localeMatchResult;
            }
        }
        localeMatchResult.matchedLocale = LocaleObjectICU.createDefault();
        return localeMatchResult;
    }

    public static String[] bestFitSupportedLocales(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (bestFitBestAvailableLocale(LocaleObject.createFromLocaleId(str)) != null) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
