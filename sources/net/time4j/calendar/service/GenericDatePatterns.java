package net.time4j.calendar.service;

import java.util.Locale;
import net.time4j.engine.DisplayStyle;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.i18n.PropertyBundle;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GenericDatePatterns {
    public static String get(String str, DisplayStyle displayStyle, Locale locale) {
        DisplayMode displayModeOfStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
        if (str.equals("iso8601")) {
            return CalendarText.patternForDate(displayModeOfStyle, locale);
        }
        String str2 = "F(" + Character.toLowerCase(displayModeOfStyle.name().charAt(0)) + ')';
        PropertyBundle bundle = GenericTextProviderSPI.getBundle(str, locale);
        if (!bundle.containsKey(str2)) {
            bundle = GenericTextProviderSPI.getBundle("generic", locale);
        }
        return bundle.getString(str2);
    }
}
