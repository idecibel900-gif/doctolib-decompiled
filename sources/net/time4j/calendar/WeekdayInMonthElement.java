package net.time4j.calendar;

import net.time4j.Weekday;
import net.time4j.base.MathUtils;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.IntElementRule;

/* JADX INFO: loaded from: classes5.dex */
final class WeekdayInMonthElement extends StdIntegerDateElement implements OrdinalWeekdayElement {
    private static final long serialVersionUID = 4275169663905222176L;
    private final transient ChronoElement domElement;
    private final transient ChronoElement dowElement;

    WeekdayInMonthElement(Class cls, ChronoElement chronoElement, ChronoElement chronoElement2) {
        super("WEEKDAY_IN_MONTH", cls, 1, ((Integer) chronoElement.getDefaultMaximum()).intValue() / 7, 'F', new WeekOperator(true), new WeekOperator(false));
        this.domElement = chronoElement;
        this.dowElement = chronoElement2;
    }

    public ChronoOperator setTo(int i, Weekday weekday) {
        return new SetOperator(this, i, weekday);
    }

    static ElementRule getRule(WeekdayInMonthElement weekdayInMonthElement) {
        return new Rule(weekdayInMonthElement);
    }

    private static class Rule implements IntElementRule {
        private final WeekdayInMonthElement wim;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return null;
        }

        Rule(WeekdayInMonthElement weekdayInMonthElement) {
            this.wim = weekdayInMonthElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(ChronoEntity chronoEntity) {
            return Integer.valueOf(getInt(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(ChronoEntity chronoEntity) {
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMax(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Integer num) {
            return num != null && isValid(chronoEntity, num.intValue());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
            if (num != null) {
                return withValue(chronoEntity, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing value.");
        }

        public boolean isValid(ChronoEntity chronoEntity, int i) {
            return i >= 1 && i <= getMax(chronoEntity);
        }

        @Override // net.time4j.engine.IntElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, int i, boolean z) {
            if (isValid(chronoEntity, i)) {
                return chronoEntity.with(this.wim.setTo(i, (Weekday) chronoEntity.get(this.wim.dowElement)));
            }
            throw new IllegalArgumentException("Invalid value: " + i);
        }

        @Override // net.time4j.engine.IntElementRule
        public int getInt(ChronoEntity chronoEntity) {
            return MathUtils.floorDivide(chronoEntity.getInt(this.wim.domElement) - 1, 7) + 1;
        }

        private int getMax(ChronoEntity chronoEntity) {
            int i = chronoEntity.getInt(this.wim.domElement);
            while (true) {
                int i2 = i + 7;
                if (i2 > ((Integer) chronoEntity.getMaximum(this.wim.domElement)).intValue()) {
                    return MathUtils.floorDivide(i - 1, 7) + 1;
                }
                i = i2;
            }
        }
    }

    private static class SetOperator implements ChronoOperator {
        private final Weekday dayOfWeek;
        private final long ordinal;
        private final WeekdayInMonthElement wim;

        SetOperator(WeekdayInMonthElement weekdayInMonthElement, int i, Weekday weekday) {
            if (weekday == null) {
                throw new NullPointerException("Missing value.");
            }
            this.wim = weekdayInMonthElement;
            this.ordinal = i;
            this.dayOfWeek = weekday;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // net.time4j.engine.ChronoOperator
        public ChronoEntity apply(ChronoEntity chronoEntity) {
            long jFloorDivide;
            Weekday weekday = (Weekday) chronoEntity.get(this.wim.dowElement);
            int i = chronoEntity.getInt(this.wim.domElement);
            if (this.ordinal == 2147483647L) {
                int iIntValue = ((Integer) chronoEntity.getMaximum(this.wim.domElement)).intValue() - i;
                int value = weekday.getValue() + (iIntValue % 7);
                if (value > 7) {
                    value -= 7;
                }
                int value2 = this.dayOfWeek.getValue() - value;
                jFloorDivide = iIntValue + value2;
                if (value2 > 0) {
                    jFloorDivide -= 7;
                }
            } else {
                int value3 = this.dayOfWeek.getValue() - weekday.getValue();
                jFloorDivide = ((this.ordinal - ((long) (MathUtils.floorDivide((i + value3) - 1, 7) + 1))) * 7) + ((long) value3);
            }
            return chronoEntity.with(EpochDays.UTC, ((CalendarDate) chronoEntity).getDaysSinceEpochUTC() + jFloorDivide);
        }
    }

    private static class WeekOperator implements ChronoOperator {
        private final boolean backwards;

        WeekOperator(boolean z) {
            this.backwards = z;
        }

        @Override // net.time4j.engine.ChronoOperator
        public ChronoEntity apply(ChronoEntity chronoEntity) {
            EpochDays epochDays = EpochDays.UTC;
            long jLongValue = ((Long) chronoEntity.get(epochDays)).longValue();
            return chronoEntity.with(epochDays, this.backwards ? jLongValue - 7 : jLongValue + 7);
        }
    }
}
