package net.time4j.calendar;

import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ElementRule;

/* JADX INFO: loaded from: classes5.dex */
class WeekdayRule implements ElementRule {
    private final ChronoFunction calsysFunc;
    private final Weekmodel stdWeekmodel;

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtCeiling(CalendarDate calendarDate) {
        return null;
    }

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtFloor(CalendarDate calendarDate) {
        return null;
    }

    WeekdayRule(Weekmodel weekmodel, ChronoFunction chronoFunction) {
        this.stdWeekmodel = weekmodel;
        this.calsysFunc = chronoFunction;
    }

    @Override // net.time4j.engine.ElementRule
    public Weekday getValue(CalendarDate calendarDate) {
        return getWeekday(calendarDate.getDaysSinceEpochUTC());
    }

    @Override // net.time4j.engine.ElementRule
    public Weekday getMinimum(CalendarDate calendarDate) {
        CalendarSystem calendarSystem = (CalendarSystem) this.calsysFunc.apply(calendarDate);
        if ((calendarDate.getDaysSinceEpochUTC() + 1) - ((long) getValue(calendarDate).getValue(this.stdWeekmodel)) < calendarSystem.getMinimumSinceUTC()) {
            return getWeekday(calendarSystem.getMinimumSinceUTC());
        }
        return this.stdWeekmodel.getFirstDayOfWeek();
    }

    @Override // net.time4j.engine.ElementRule
    public Weekday getMaximum(CalendarDate calendarDate) {
        CalendarSystem calendarSystem = (CalendarSystem) this.calsysFunc.apply(calendarDate);
        if ((calendarDate.getDaysSinceEpochUTC() + 7) - ((long) getValue(calendarDate).getValue(this.stdWeekmodel)) > calendarSystem.getMaximumSinceUTC()) {
            return getWeekday(calendarSystem.getMaximumSinceUTC());
        }
        return this.stdWeekmodel.getFirstDayOfWeek().roll(6);
    }

    @Override // net.time4j.engine.ElementRule
    public boolean isValid(CalendarDate calendarDate, Weekday weekday) {
        if (weekday == null) {
            return false;
        }
        long daysSinceEpochUTC = (calendarDate.getDaysSinceEpochUTC() + ((long) weekday.getValue(this.stdWeekmodel))) - ((long) getValue(calendarDate).getValue(this.stdWeekmodel));
        CalendarSystem calendarSystem = (CalendarSystem) this.calsysFunc.apply(calendarDate);
        return daysSinceEpochUTC >= calendarSystem.getMinimumSinceUTC() && daysSinceEpochUTC <= calendarSystem.getMaximumSinceUTC();
    }

    @Override // net.time4j.engine.ElementRule
    public CalendarDate withValue(CalendarDate calendarDate, Weekday weekday, boolean z) {
        if (weekday == null) {
            throw new IllegalArgumentException("Missing weekday.");
        }
        int value = getValue(calendarDate).getValue(this.stdWeekmodel);
        long daysSinceEpochUTC = (calendarDate.getDaysSinceEpochUTC() + ((long) weekday.getValue(this.stdWeekmodel))) - ((long) value);
        CalendarSystem calendarSystem = (CalendarSystem) this.calsysFunc.apply(calendarDate);
        if (daysSinceEpochUTC >= calendarSystem.getMinimumSinceUTC() && daysSinceEpochUTC <= calendarSystem.getMaximumSinceUTC()) {
            return (CalendarDate) calendarSystem.transform(daysSinceEpochUTC);
        }
        throw new IllegalArgumentException("New day out of supported range.");
    }

    private static Weekday getWeekday(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }
}
