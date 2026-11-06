package net.time4j;

import net.time4j.base.GregorianDate;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
public enum Quarter implements ChronoCondition, ChronoOperator {
    Q1,
    Q2,
    Q3,
    Q4;

    private static final Quarter[] ENUMS = values();

    public static Quarter valueOf(int i) {
        if (i < 1 || i > 4) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return ENUMS[i - 1];
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // net.time4j.engine.ChronoCondition
    public boolean test(GregorianDate gregorianDate) {
        return getValue() == ((gregorianDate.getMonth() - 1) / 3) + 1;
    }

    @Override // net.time4j.engine.ChronoOperator
    public PlainDate apply(PlainDate plainDate) {
        return (PlainDate) plainDate.with(PlainDate.QUARTER_OF_YEAR, this);
    }
}
