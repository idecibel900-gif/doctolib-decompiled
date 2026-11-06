package io.sentry.util;

import com.adjust.sdk.Constants;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StringUtils {
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    private static final Pattern PATTERN_WORD_SNAKE_CASE = Pattern.compile("[\\W_]+");

    public static String getOrEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String getStringAfterDot(String str) {
        int i;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf < 0 || str.length() <= (i = iLastIndexOf + 1)) ? str : str.substring(i);
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static String camelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] strArrSplit = PATTERN_WORD_SNAKE_CASE.split(str, -1);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append(capitalize(str2));
        }
        return sb.toString();
    }

    public static String removeSurrounding(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    public static String calculateStringHash(String str, ILogger iLogger) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str.getBytes(UTF_8))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e) {
                iLogger.log(SentryLevel.INFO, "SHA-1 isn't available to calculate the hash.", e);
            } catch (Throwable th) {
                iLogger.log(SentryLevel.INFO, "string: %s could not calculate its hash", th, str);
            }
        }
        return null;
    }

    public static String normalizeUUID(String str) {
        return str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
