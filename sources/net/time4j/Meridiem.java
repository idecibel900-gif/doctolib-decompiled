package net.time4j;

import java.util.Locale;
import net.time4j.base.WallTime;
import net.time4j.engine.ChronoCondition;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes5.dex */
public enum Meridiem implements ChronoCondition {
    AM,
    PM;

    public static Meridiem ofHour(int i) {
        if (i >= 0 && i <= 24) {
            return (i < 12 || i == 24) ? AM : PM;
        }
        throw new IllegalArgumentException("Hour of day out of range: " + i);
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getIsoInstance(locale).getMeridiems(textWidth, outputContext).print(this);
    }

    @Override // net.time4j.engine.ChronoCondition
    public boolean test(WallTime wallTime) {
        int hour = wallTime.getHour();
        if (this == AM) {
            return hour < 12 || hour == 24;
        }
        return hour >= 12 && hour < 24;
    }
}
