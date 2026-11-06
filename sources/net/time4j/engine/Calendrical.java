package net.time4j.engine;

import net.time4j.base.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Calendrical extends TimePoint implements CalendarDate {
    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public Calendrical transform(Class cls) {
        String name = cls.getName();
        Chronology chronologyLookup = Chronology.lookup(cls);
        if (chronologyLookup == null) {
            throw new IllegalArgumentException("Cannot find any chronology for given target type: " + name);
        }
        return (Calendrical) transform(chronologyLookup.getCalendarSystem(), name);
    }

    public boolean isBefore(CalendarDate calendarDate) {
        return compareByTime(calendarDate) < 0;
    }

    public boolean isAfter(CalendarDate calendarDate) {
        return compareByTime(calendarDate) > 0;
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(Calendrical calendrical) {
        if (getChronology().getChronoType() != calendrical.getChronology().getChronoType()) {
            throw new ClassCastException("Cannot compare different types of dates, use instance of EpochDays as comparator instead.");
        }
        return compareByTime(calendrical);
    }

    public Calendrical plus(CalendarDays calendarDays) {
        long jSafeAdd = MathUtils.safeAdd(getDaysSinceEpochUTC(), calendarDays.getAmount());
        try {
            return (Calendrical) getCalendarSystem().transform(jSafeAdd);
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Out of range: " + jSafeAdd);
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public long getDaysSinceEpochUTC() {
        return getCalendarSystem().transform(getContext());
    }

    protected int compareByTime(CalendarDate calendarDate) {
        long daysSinceEpochUTC = getDaysSinceEpochUTC();
        long daysSinceEpochUTC2 = calendarDate.getDaysSinceEpochUTC();
        if (daysSinceEpochUTC < daysSinceEpochUTC2) {
            return -1;
        }
        return daysSinceEpochUTC == daysSinceEpochUTC2 ? 0 : 1;
    }

    private CalendarSystem getCalendarSystem() {
        return getChronology().getCalendarSystem();
    }

    private Object transform(CalendarSystem calendarSystem, String str) {
        long daysSinceEpochUTC = getDaysSinceEpochUTC();
        if (calendarSystem.getMinimumSinceUTC() > daysSinceEpochUTC || calendarSystem.getMaximumSinceUTC() < daysSinceEpochUTC) {
            throw new ArithmeticException("Cannot transform <" + daysSinceEpochUTC + "> to: " + str);
        }
        return calendarSystem.transform(daysSinceEpochUTC);
    }
}
