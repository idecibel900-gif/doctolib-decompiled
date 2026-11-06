package org.apache.commons.lang3;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LocaleUtils {
    private static final ConcurrentMap cLanguagesByCountry = new ConcurrentHashMap();
    private static final ConcurrentMap cCountriesByLanguage = new ConcurrentHashMap();

    public static Locale toLocale(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new Locale("", "");
        }
        if (str.contains("#")) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        int length = str.length();
        if (length < 2) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (str.charAt(0) != '_') {
            return parseLocale(str);
        }
        if (length < 3) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        char cCharAt = str.charAt(1);
        char cCharAt2 = str.charAt(2);
        if (!Character.isUpperCase(cCharAt) || !Character.isUpperCase(cCharAt2)) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (length == 3) {
            return new Locale("", str.substring(1, 3));
        }
        if (length < 5) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (str.charAt(3) != '_') {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        return new Locale("", str.substring(1, 3), str.substring(4));
    }

    private static Locale parseLocale(String str) {
        if (isISO639LanguageCode(str)) {
            return new Locale(str);
        }
        String[] strArrSplit = str.split("_", -1);
        String str2 = strArrSplit[0];
        if (strArrSplit.length == 2) {
            String str3 = strArrSplit[1];
            if ((isISO639LanguageCode(str2) && isISO3166CountryCode(str3)) || isNumericAreaCode(str3)) {
                return new Locale(str2, str3);
            }
        } else if (strArrSplit.length == 3) {
            String str4 = strArrSplit[1];
            String str5 = strArrSplit[2];
            if (isISO639LanguageCode(str2) && ((str4.isEmpty() || isISO3166CountryCode(str4) || isNumericAreaCode(str4)) && !str5.isEmpty())) {
                return new Locale(str2, str4, str5);
            }
        }
        throw new IllegalArgumentException("Invalid locale format: " + str);
    }

    private static boolean isISO639LanguageCode(String str) {
        if (StringUtils.isAllLowerCase(str)) {
            return str.length() == 2 || str.length() == 3;
        }
        return false;
    }

    private static boolean isISO3166CountryCode(String str) {
        return StringUtils.isAllUpperCase(str) && str.length() == 2;
    }

    private static boolean isNumericAreaCode(String str) {
        return StringUtils.isNumeric(str) && str.length() == 3;
    }
}
