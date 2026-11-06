package net.time4j.format;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface WeekdataProvider {
    int getEndOfWeekend(Locale locale);

    int getFirstDayOfWeek(Locale locale);

    int getMinimalDaysInFirstWeek(Locale locale);

    int getStartOfWeekend(Locale locale);
}
