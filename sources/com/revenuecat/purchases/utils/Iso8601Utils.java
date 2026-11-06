package com.revenuecat.purchases.utils;

import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.common.Constants;
import j$.util.DesugarTimeZone;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public final class Iso8601Utils {
    private static final String GMT_ID = "GMT";
    private static final TimeZone TIMEZONE_Z = DesugarTimeZone.getTimeZone(GMT_ID);

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append(b.a);
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    public static Date parse(String str) {
        int i;
        int iPow;
        int i2;
        int i3;
        TimeZone timeZone;
        char cCharAt;
        try {
            int i4 = parseInt(str, 0, 4);
            int i5 = checkOffset(str, 4, '-') ? 5 : 4;
            int i6 = i5 + 2;
            int i7 = parseInt(str, i5, i6);
            if (checkOffset(str, i6, '-')) {
                i6 = i5 + 3;
            }
            int i8 = i6 + 2;
            int i9 = parseInt(str, i6, i8);
            boolean zCheckOffset = checkOffset(str, i8, 'T');
            if (!zCheckOffset && str.length() <= i8) {
                return new GregorianCalendar(i4, i7 - 1, i9).getTime();
            }
            if (zCheckOffset) {
                int i10 = i6 + 5;
                int i11 = parseInt(str, i6 + 3, i10);
                if (checkOffset(str, i10, ':')) {
                    i10 = i6 + 6;
                }
                int i12 = i10 + 2;
                i3 = parseInt(str, i10, i12);
                if (checkOffset(str, i12, ':')) {
                    i12 = i10 + 3;
                }
                if (str.length() <= i12 || (cCharAt = str.charAt(i12)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i = i11;
                    i8 = i12;
                    iPow = 0;
                    i2 = 0;
                } else {
                    int i13 = i12 + 2;
                    i2 = parseInt(str, i12, i13);
                    if (i2 > 59 && i2 < 63) {
                        i2 = 59;
                    }
                    if (checkOffset(str, i13, b.a)) {
                        int i14 = i12 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i12 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i12 + 6);
                        iPow = (int) (Math.pow(10.0d, 3 - (iMin - i14)) * ((double) parseInt(str, i14, iMin)));
                        i = i11;
                        i8 = iIndexOfNonDigit;
                    } else {
                        i = i11;
                        i8 = i13;
                        iPow = 0;
                    }
                }
            } else {
                i = 0;
                iPow = 0;
                i2 = 0;
                i3 = 0;
            }
            if (str.length() <= i8) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i8);
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    String str2 = GMT_ID + strSubstring;
                    TimeZone timeZone2 = DesugarTimeZone.getTimeZone(str2);
                    String id = timeZone2.getID();
                    if (!id.equals(str2) && !id.replace(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "").equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i9);
            gregorianCalendar.set(11, i);
            gregorianCalendar.set(12, i3);
            gregorianCalendar.set(13, i2);
            gregorianCalendar.set(14, iPow);
            return gregorianCalendar.getTime();
        } catch (IllegalArgumentException e) {
            e = e;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            throw new SerializationException("Not an RFC 3339 date: " + str, e);
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String string = Integer.toString(i);
        for (int length = i2 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
