package net.time4j.tz.model;

import java.io.Serializable;
import net.time4j.CalendarUnit;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GregorianTimezoneRule extends DaylightSavingRule implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient byte month;

    protected abstract PlainDate getDate0(int i);

    protected GregorianTimezoneRule(Month month, int i, OffsetIndicator offsetIndicator, int i2) {
        super(i, offsetIndicator, i2);
        this.month = (byte) month.getValue();
    }

    @Override // net.time4j.tz.model.DaylightSavingRule
    public final PlainDate getDate(int i) {
        return (PlainDate) getDate0(i).plus(getDayOverflow(), CalendarUnit.DAYS);
    }

    @Override // net.time4j.tz.model.DaylightSavingRule
    protected int toCalendarYear(long j) {
        return GregorianMath.readYear(GregorianMath.toPackedDate(j));
    }

    @Override // net.time4j.tz.model.DaylightSavingRule
    protected int toCalendarYear(GregorianDate gregorianDate) {
        return gregorianDate.getYear();
    }

    @Override // net.time4j.tz.model.DaylightSavingRule
    protected String getCalendarType() {
        return "iso8601";
    }

    protected boolean isEqual(GregorianTimezoneRule gregorianTimezoneRule) {
        return getTimeOfDay().equals(gregorianTimezoneRule.getTimeOfDay()) && getDayOverflow() == gregorianTimezoneRule.getDayOverflow() && getIndicator() == gregorianTimezoneRule.getIndicator() && getSavings() == gregorianTimezoneRule.getSavings() && this.month == gregorianTimezoneRule.month;
    }

    byte getMonthValue() {
        return this.month;
    }
}
