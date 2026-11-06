package net.time4j.calendar;

import java.util.Collections;
import java.util.Map;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;

/* JADX INFO: loaded from: classes5.dex */
final class RelatedGregorianYearRule implements ElementRule {
    private final ChronoElement dayOfYear;
    private final Map map;

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
        return null;
    }

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
        return null;
    }

    RelatedGregorianYearRule(CalendarSystem calendarSystem, ChronoElement chronoElement) {
        this.map = Collections.singletonMap("calendrical", calendarSystem);
        this.dayOfYear = chronoElement;
    }

    @Override // net.time4j.engine.ElementRule
    public Integer getValue(ChronoEntity chronoEntity) {
        return toGregorianYear(getCalendarSystem(chronoEntity).transform(chronoEntity.with(this.dayOfYear, 1)));
    }

    @Override // net.time4j.engine.ElementRule
    public Integer getMinimum(ChronoEntity chronoEntity) {
        CalendarSystem calendarSystem = getCalendarSystem(chronoEntity);
        return toGregorianYear(calendarSystem.transform(((ChronoEntity) calendarSystem.transform(calendarSystem.getMinimumSinceUTC())).with(this.dayOfYear, 1)));
    }

    @Override // net.time4j.engine.ElementRule
    public Integer getMaximum(ChronoEntity chronoEntity) {
        CalendarSystem calendarSystem = getCalendarSystem(chronoEntity);
        return toGregorianYear(calendarSystem.transform(((ChronoEntity) calendarSystem.transform(calendarSystem.getMaximumSinceUTC())).with(this.dayOfYear, 1)));
    }

    @Override // net.time4j.engine.ElementRule
    public boolean isValid(ChronoEntity chronoEntity, Integer num) {
        return getValue(chronoEntity).equals(num);
    }

    @Override // net.time4j.engine.ElementRule
    public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
        if (isValid(chronoEntity, num)) {
            return chronoEntity;
        }
        throw new IllegalArgumentException("The related gregorian year is read-only.");
    }

    private CalendarSystem getCalendarSystem(ChronoEntity chronoEntity) {
        return (CalendarSystem) this.map.get("calendrical");
    }

    private static Integer toGregorianYear(long j) {
        long j2;
        long jSafeAdd = MathUtils.safeAdd(EpochDays.MODIFIED_JULIAN_DATE.transform(j, EpochDays.UTC), 678881L);
        long jFloorDivide = MathUtils.floorDivide(jSafeAdd, 146097);
        int iFloorModulo = MathUtils.floorModulo(jSafeAdd, 146097);
        if (iFloorModulo == 146096) {
            j2 = (jFloorDivide + 1) * 400;
        } else {
            int i = iFloorModulo / 36524;
            int i2 = iFloorModulo % 36524;
            int i3 = i2 / 1461;
            int i4 = i2 % 1461;
            if (i4 == 1460) {
                j2 = (jFloorDivide * 400) + ((long) (i * 100)) + ((long) ((i3 + 1) * 4));
            } else {
                j2 = (jFloorDivide * 400) + ((long) (i * 100)) + ((long) (i3 * 4)) + ((long) (i4 / 365));
                if (((((i4 % 365) + 31) * 5) / 153) + 2 > 12) {
                    j2++;
                }
            }
        }
        return Integer.valueOf(MathUtils.safeCast(j2));
    }
}
