package com.henninghall.date_picker;

import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.henninghall.date_picker.models.WheelType;
import j$.util.DesugarTimeZone;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import net.time4j.PrettyTime;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Utils {
    public static boolean deviceUsesAmPm() {
        return !DateFormat.is24HourFormat(DatePickerPackage.context);
    }

    public static String printToday(Locale locale) {
        return PrettyTime.of(locale).printToday();
    }

    public static Calendar isoToCalendar(String str, TimeZone timeZone) {
        if (str == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(getIsoUTCFormat().parse(str));
            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToIso(Calendar calendar) {
        return getIsoUTCFormat().format(calendar.getTime());
    }

    public static boolean isToday(Calendar calendar) {
        return DateUtils.isToday(calendar.getTimeInMillis());
    }

    private static SimpleDateFormat getIsoUTCFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static WheelType patternCharToWheelType(char c) throws Exception {
        if (c != 'H') {
            if (c == 'M') {
                return WheelType.MONTH;
            }
            if (c == 'a') {
                return WheelType.AM_PM;
            }
            if (c == 'd') {
                return WheelType.DATE;
            }
            if (c != 'h') {
                if (c == 'm') {
                    return WheelType.MINUTE;
                }
                if (c == 'y') {
                    return WheelType.YEAR;
                }
                throw new Exception("Invalid pattern char: " + c);
            }
        }
        return WheelType.HOUR;
    }

    public static int getShortestScrollOption(int i, int i2, int i3, boolean z) {
        int i4;
        int i5 = i3 + 1;
        int i6 = i2 - i;
        int i7 = i6 > 0 ? i6 - i5 : i5 + i6;
        return (!z ? !((i4 = i + i6) <= i3 && i4 >= 0) : Math.abs(i6) >= Math.abs(i7)) ? i6 : i7;
    }

    public static int toDp(int i) {
        return (int) (i * DatePickerPackage.context.getResources().getDisplayMetrics().density);
    }

    public static String toPaddedMinutes(int i) {
        return new DecimalFormat("00").format(i);
    }
}
