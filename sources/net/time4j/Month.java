package net.time4j;

import net.time4j.base.GregorianDate;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
public enum Month implements ChronoCondition, ChronoOperator {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    private static final Month[] ENUMS = values();

    public static Month valueOf(int i) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return ENUMS[i - 1];
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // net.time4j.engine.ChronoCondition
    public boolean test(GregorianDate gregorianDate) {
        return gregorianDate.getMonth() == getValue();
    }

    @Override // net.time4j.engine.ChronoOperator
    public PlainDate apply(PlainDate plainDate) {
        return (PlainDate) plainDate.with(PlainDate.MONTH_OF_YEAR, this);
    }
}
