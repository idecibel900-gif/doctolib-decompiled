package net.time4j;

import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
public enum Weekday implements ChronoCondition, ChronoOperator {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private static final Weekday[] ENUMS = values();

    public int getValue() {
        return ordinal() + 1;
    }

    public int getValue(Weekmodel weekmodel) {
        return (((ordinal() + 7) - weekmodel.getFirstDayOfWeek().ordinal()) % 7) + 1;
    }

    public static Weekday valueOf(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return ENUMS[i - 1];
    }

    public Weekday roll(int i) {
        return valueOf(((ordinal() + ((i % 7) + 7)) % 7) + 1);
    }

    @Override // net.time4j.engine.ChronoCondition
    public boolean test(GregorianDate gregorianDate) {
        return GregorianMath.getDayOfWeek(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth()) == getValue();
    }

    @Override // net.time4j.engine.ChronoOperator
    public PlainDate apply(PlainDate plainDate) {
        return (PlainDate) plainDate.with(PlainDate.DAY_OF_WEEK, this);
    }
}
