package com.henninghall.date_picker;

import com.amazon.a.a.o.b.f;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LocaleUtils {
    public static String getDay(String str) {
        return getFormat(str, Formats.Format.MMMEd);
    }

    public static String getYear(String str) {
        return getFormat(str, Formats.Format.y);
    }

    public static String getDate(String str) {
        return getFormat(str, Formats.Format.d);
    }

    private static String getFormat(String str, Formats.Format format) {
        try {
            try {
                return Formats.get(str, format);
            } catch (Formats.FormatNotFoundException | IndexOutOfBoundsException unused) {
                return (String) Formats.defaultFormat.get(format);
            }
        } catch (Formats.FormatNotFoundException unused2) {
            return Formats.get(str.substring(0, str.indexOf("_")), format);
        }
    }

    public static String getDatePattern(Locale locale) {
        return ((SimpleDateFormat) DateFormat.getDateInstance(0, locale)).toLocalizedPattern().replaceAll(f.a, "").replaceAll("([a-zA-Z]+)", " $1").trim();
    }

    static String getDateTimePattern(Locale locale) {
        return ((SimpleDateFormat) DateFormat.getDateTimeInstance(0, 0, locale)).toLocalizedPattern().replace(f.a, "");
    }

    public static Locale getLocale(String str) {
        try {
            return org.apache.commons.lang3.LocaleUtils.toLocale(str);
        } catch (Exception unused) {
            return org.apache.commons.lang3.LocaleUtils.toLocale(str.substring(0, str.indexOf("_")));
        }
    }

    public static boolean localeUsesAmPm(Locale locale) {
        DateFormat timeInstance = DateFormat.getTimeInstance(0, locale);
        return (timeInstance instanceof SimpleDateFormat) && ((SimpleDateFormat) timeInstance).toPattern().contains("a");
    }
}
