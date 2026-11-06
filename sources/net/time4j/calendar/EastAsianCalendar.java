package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ElementRule;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.UnitRule;
import net.time4j.format.CalendarType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EastAsianCalendar extends Calendrical {
    private final transient int cycle;
    private final transient int dayOfMonth;
    private final transient int leapMonth;
    private final transient EastAsianMonth month;
    private final transient long utcDays;
    private final transient int yearOfCycle;

    abstract EastAsianCS getCalendarSystem();

    EastAsianCalendar(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
        this.cycle = i;
        this.yearOfCycle = i2;
        this.month = eastAsianMonth;
        this.dayOfMonth = i3;
        this.utcDays = j;
        this.leapMonth = getCalendarSystem().getLeapMonth(i, i2);
    }

    public CyclicYear getYear() {
        return CyclicYear.of(this.yearOfCycle);
    }

    public EastAsianMonth getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public int getDayOfYear() {
        return (int) ((this.utcDays - getCalendarSystem().newYear(this.cycle, this.yearOfCycle)) + 1);
    }

    public boolean isLeapYear() {
        return this.leapMonth > 0;
    }

    public int lengthOfMonth() {
        return (int) (((((long) this.dayOfMonth) + getCalendarSystem().newMoonOnOrAfter(this.utcDays + 1)) - this.utcDays) - 1);
    }

    public int lengthOfYear() {
        int i = this.cycle;
        int i2 = 1;
        int i3 = this.yearOfCycle + 1;
        if (i3 > 60) {
            i++;
        } else {
            i2 = i3;
        }
        return (int) (getCalendarSystem().newYear(i, i2) - getCalendarSystem().newYear(this.cycle, this.yearOfCycle));
    }

    @Override // net.time4j.engine.Calendrical, net.time4j.engine.CalendarDate
    public long getDaysSinceEpochUTC() {
        return this.utcDays;
    }

    @Override // net.time4j.engine.Calendrical
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EastAsianCalendar eastAsianCalendar = (EastAsianCalendar) obj;
            if (this.cycle == eastAsianCalendar.cycle && this.yearOfCycle == eastAsianCalendar.yearOfCycle && this.dayOfMonth == eastAsianCalendar.dayOfMonth && this.month.equals(eastAsianCalendar.month) && this.utcDays == eastAsianCalendar.utcDays) {
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.engine.Calendrical
    public int hashCode() {
        long j = this.utcDays;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strValue = ((CalendarType) getClass().getAnnotation(CalendarType.class)).value();
        if (strValue.equals("dangi")) {
            strValue = "korean";
        }
        sb.append(strValue);
        sb.append('[');
        sb.append(getYear().getDisplayName(Locale.ROOT));
        sb.append('(');
        sb.append(getInt(CommonElements.RELATED_GREGORIAN_YEAR));
        sb.append(")-");
        sb.append(this.month.toString());
        sb.append('-');
        if (this.dayOfMonth < 10) {
            sb.append('0');
        }
        sb.append(this.dayOfMonth);
        sb.append(']');
        return sb.toString();
    }

    static ElementRule getCycleRule(ChronoElement chronoElement) {
        return new IntegerElementRule(3, chronoElement);
    }

    static ElementRule getYearOfCycleRule(ChronoElement chronoElement) {
        return new CyclicYearRule(chronoElement, false);
    }

    static ElementRule getMonthOfYearRule(ChronoElement chronoElement) {
        return new MonthRule(chronoElement);
    }

    static ElementRule getMonthAsOrdinalRule(ChronoElement chronoElement) {
        return new IntegerElementRule(2, chronoElement);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static ElementRule getDayOfMonthRule() {
        return new IntegerElementRule(0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static ElementRule getDayOfYearRule() {
        return new IntegerElementRule(1, null);
    }

    static UnitRule getUnitRule(int i) {
        return new EastAsianUnitRule(i);
    }

    int getCycle() {
        return this.cycle;
    }

    int getLeapMonth() {
        return this.leapMonth;
    }

    private static class IntegerElementRule implements IntElementRule {
        private final ChronoElement child;
        private final int index;

        private IntegerElementRule(int i, ChronoElement chronoElement) {
            this.index = i;
            this.child = chronoElement;
        }

        @Override // net.time4j.engine.IntElementRule
        public int getInt(EastAsianCalendar eastAsianCalendar) {
            int i = this.index;
            if (i == 0) {
                return eastAsianCalendar.getDayOfMonth();
            }
            if (i == 1) {
                return eastAsianCalendar.getDayOfYear();
            }
            if (i == 2) {
                int number = eastAsianCalendar.getMonth().getNumber();
                int leapMonth = eastAsianCalendar.getLeapMonth();
                return ((leapMonth <= 0 || leapMonth >= number) && !eastAsianCalendar.getMonth().isLeap()) ? number : number + 1;
            }
            if (i == 3) {
                return eastAsianCalendar.getCycle();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(EastAsianCalendar eastAsianCalendar, int i) {
            if (i < 1) {
                return false;
            }
            int i2 = this.index;
            if (i2 == 0) {
                if (i > 30) {
                    return false;
                }
                return i != 30 || eastAsianCalendar.lengthOfMonth() == 30;
            }
            if (i2 == 1) {
                return i <= eastAsianCalendar.lengthOfYear();
            }
            if (i2 == 2) {
                return i <= 12 || (i == 13 && eastAsianCalendar.getLeapMonth() > 0);
            }
            if (i2 == 3) {
                EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
                return i >= ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMinimumSinceUTC())).getCycle() && i <= ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMaximumSinceUTC())).getCycle();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        @Override // net.time4j.engine.IntElementRule
        public EastAsianCalendar withValue(EastAsianCalendar eastAsianCalendar, int i, boolean z) {
            int i2 = this.index;
            if (i2 == 0) {
                if (z) {
                    return eastAsianCalendar.getCalendarSystem().transform((eastAsianCalendar.getDaysSinceEpochUTC() + ((long) i)) - ((long) eastAsianCalendar.getDayOfMonth()));
                }
                if (i < 1 || i > 30 || (i == 30 && eastAsianCalendar.lengthOfMonth() < 30)) {
                    throw new IllegalArgumentException("Day of month out of range: " + i);
                }
                return eastAsianCalendar.getCalendarSystem().create(eastAsianCalendar.getCycle(), eastAsianCalendar.getYear().getNumber(), eastAsianCalendar.getMonth(), i, (eastAsianCalendar.getDaysSinceEpochUTC() + ((long) i)) - ((long) eastAsianCalendar.getDayOfMonth()));
            }
            if (i2 == 1) {
                if (!z && (i < 1 || i > eastAsianCalendar.lengthOfYear())) {
                    throw new IllegalArgumentException("Day of year out of range: " + i);
                }
                return eastAsianCalendar.getCalendarSystem().transform((eastAsianCalendar.getDaysSinceEpochUTC() + ((long) i)) - ((long) eastAsianCalendar.getDayOfYear()));
            }
            boolean z2 = false;
            if (i2 != 2) {
                if (i2 == 3) {
                    if (isValid(eastAsianCalendar, i)) {
                        return (EastAsianCalendar) EastAsianCalendar.getUnitRule(0).addTo(eastAsianCalendar, i - eastAsianCalendar.getCycle());
                    }
                    throw new IllegalArgumentException("Sexagesimal cycle out of range: " + i);
                }
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            if (isValid(eastAsianCalendar, i)) {
                int leapMonth = eastAsianCalendar.getLeapMonth();
                if (leapMonth > 0 && leapMonth < i) {
                    boolean z3 = i == leapMonth + 1;
                    i--;
                    z2 = z3;
                }
                EastAsianMonth eastAsianMonthValueOf = EastAsianMonth.valueOf(i);
                if (z2) {
                    eastAsianMonthValueOf = eastAsianMonthValueOf.withLeap();
                }
                return MonthRule.withMonth(eastAsianCalendar, eastAsianMonthValueOf);
            }
            throw new IllegalArgumentException("Ordinal month out of range: " + i);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(EastAsianCalendar eastAsianCalendar) {
            return Integer.valueOf(getInt(eastAsianCalendar));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(EastAsianCalendar eastAsianCalendar) {
            if (this.index == 3) {
                EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
                return Integer.valueOf(((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMinimumSinceUTC())).getCycle());
            }
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(EastAsianCalendar eastAsianCalendar) {
            int iLengthOfMonth;
            int i = this.index;
            if (i == 0) {
                iLengthOfMonth = eastAsianCalendar.lengthOfMonth();
            } else if (i == 1) {
                iLengthOfMonth = eastAsianCalendar.lengthOfYear();
            } else if (i == 2) {
                iLengthOfMonth = eastAsianCalendar.isLeapYear() ? 13 : 12;
            } else if (i == 3) {
                EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
                iLengthOfMonth = ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMaximumSinceUTC())).getCycle();
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            return Integer.valueOf(iLengthOfMonth);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(EastAsianCalendar eastAsianCalendar, Integer num) {
            return num != null && isValid(eastAsianCalendar, num.intValue());
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianCalendar withValue(EastAsianCalendar eastAsianCalendar, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            return withValue(eastAsianCalendar, num.intValue(), z);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }
    }

    private static class CyclicYearRule implements ElementRule {
        private final ChronoElement child;
        private final boolean vietnam;

        private CyclicYearRule(ChronoElement chronoElement, boolean z) {
            this.child = chronoElement;
            this.vietnam = z;
        }

        @Override // net.time4j.engine.ElementRule
        public CyclicYear getValue(EastAsianCalendar eastAsianCalendar) {
            return eastAsianCalendar.getYear();
        }

        @Override // net.time4j.engine.ElementRule
        public CyclicYear getMinimum(EastAsianCalendar eastAsianCalendar) {
            if (this.vietnam) {
                return eastAsianCalendar.getCycle() == 75 ? CyclicYear.of(10) : CyclicYear.of(1);
            }
            return eastAsianCalendar.getCycle() == 72 ? CyclicYear.of(22) : CyclicYear.of(1);
        }

        @Override // net.time4j.engine.ElementRule
        public CyclicYear getMaximum(EastAsianCalendar eastAsianCalendar) {
            return CyclicYear.of(eastAsianCalendar.getCycle() == 94 ? 56 : 60);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(EastAsianCalendar eastAsianCalendar, CyclicYear cyclicYear) {
            return cyclicYear != null && getMinimum(eastAsianCalendar).compareTo((SexagesimalName) cyclicYear) <= 0 && getMaximum(eastAsianCalendar).compareTo((SexagesimalName) cyclicYear) >= 0;
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianCalendar withValue(EastAsianCalendar eastAsianCalendar, CyclicYear cyclicYear, boolean z) {
            if (isValid(eastAsianCalendar, cyclicYear)) {
                EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
                int dayOfMonth = eastAsianCalendar.getDayOfMonth();
                EastAsianMonth month = eastAsianCalendar.getMonth();
                int number = cyclicYear.getNumber();
                int cycle = eastAsianCalendar.getCycle();
                if (month.isLeap() && month.getNumber() != calendarSystem.getLeapMonth(cycle, number)) {
                    month = EastAsianMonth.valueOf(month.getNumber());
                }
                EastAsianMonth eastAsianMonth = month;
                if (dayOfMonth <= 29) {
                    return calendarSystem.create(cycle, number, eastAsianMonth, dayOfMonth, calendarSystem.transform(cycle, number, eastAsianMonth, dayOfMonth));
                }
                long jTransform = calendarSystem.transform(cycle, number, eastAsianMonth, 1);
                int iMin = Math.min(dayOfMonth, calendarSystem.transform(jTransform).lengthOfMonth());
                return calendarSystem.create(cycle, number, eastAsianMonth, iMin, (jTransform + ((long) iMin)) - 1);
            }
            throw new IllegalArgumentException("Invalid cyclic year: " + cyclicYear);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }
    }

    private static class MonthRule implements ElementRule {
        private final ChronoElement child;

        private MonthRule(ChronoElement chronoElement) {
            this.child = chronoElement;
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianMonth getValue(EastAsianCalendar eastAsianCalendar) {
            return eastAsianCalendar.getMonth();
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianMonth getMinimum(EastAsianCalendar eastAsianCalendar) {
            return EastAsianMonth.valueOf(1);
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianMonth getMaximum(EastAsianCalendar eastAsianCalendar) {
            return EastAsianMonth.valueOf(12);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(EastAsianCalendar eastAsianCalendar, EastAsianMonth eastAsianMonth) {
            if (eastAsianMonth != null) {
                return !eastAsianMonth.isLeap() || eastAsianMonth.getNumber() == eastAsianCalendar.getLeapMonth();
            }
            return false;
        }

        @Override // net.time4j.engine.ElementRule
        public EastAsianCalendar withValue(EastAsianCalendar eastAsianCalendar, EastAsianMonth eastAsianMonth, boolean z) {
            if (isValid(eastAsianCalendar, eastAsianMonth)) {
                return withMonth(eastAsianCalendar, eastAsianMonth);
            }
            throw new IllegalArgumentException("Invalid month: " + eastAsianMonth);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(EastAsianCalendar eastAsianCalendar) {
            return this.child;
        }

        static EastAsianCalendar withMonth(EastAsianCalendar eastAsianCalendar, EastAsianMonth eastAsianMonth) {
            EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
            int dayOfMonth = eastAsianCalendar.getDayOfMonth();
            int number = eastAsianCalendar.getYear().getNumber();
            if (dayOfMonth <= 29) {
                return calendarSystem.create(eastAsianCalendar.getCycle(), number, eastAsianMonth, dayOfMonth, calendarSystem.transform(eastAsianCalendar.getCycle(), number, eastAsianMonth, dayOfMonth));
            }
            long jTransform = calendarSystem.transform(eastAsianCalendar.getCycle(), number, eastAsianMonth, 1);
            int iMin = Math.min(dayOfMonth, calendarSystem.transform(jTransform).lengthOfMonth());
            return calendarSystem.create(eastAsianCalendar.getCycle(), number, eastAsianMonth, iMin, (jTransform + ((long) iMin)) - 1);
        }
    }

    private static class EastAsianUnitRule implements UnitRule {
        private final int index;

        EastAsianUnitRule(int i) {
            this.index = i;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 2601. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        @Override // net.time4j.engine.UnitRule
        public net.time4j.calendar.EastAsianCalendar addTo(net.time4j.calendar.EastAsianCalendar r18, long r19) {
            /*
                Method dump skipped, instruction units count: 260
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.EastAsianCalendar.EastAsianUnitRule.addTo(net.time4j.calendar.EastAsianCalendar, long):net.time4j.calendar.EastAsianCalendar");
        }

        @Override // net.time4j.engine.UnitRule
        public long between(EastAsianCalendar eastAsianCalendar, EastAsianCalendar eastAsianCalendar2) {
            return between(eastAsianCalendar, eastAsianCalendar2, this.index);
        }

        private static long between(EastAsianCalendar eastAsianCalendar, EastAsianCalendar eastAsianCalendar2, int i) {
            int iCompareTo;
            EastAsianCalendar eastAsianCalendar3;
            EastAsianCalendar eastAsianCalendar4;
            int leapMonth;
            EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
            if (i == 0) {
                return between(eastAsianCalendar, eastAsianCalendar2, 1) / 60;
            }
            if (i == 1) {
                int cycle = (((eastAsianCalendar2.getCycle() * 60) + eastAsianCalendar2.getYear().getNumber()) - (eastAsianCalendar.getCycle() * 60)) - eastAsianCalendar.getYear().getNumber();
                if (cycle > 0) {
                    int iCompareTo2 = eastAsianCalendar.getMonth().compareTo(eastAsianCalendar2.getMonth());
                    if (iCompareTo2 > 0 || (iCompareTo2 == 0 && eastAsianCalendar.getDayOfMonth() > eastAsianCalendar2.getDayOfMonth())) {
                        cycle--;
                    }
                } else if (cycle < 0 && ((iCompareTo = eastAsianCalendar.getMonth().compareTo(eastAsianCalendar2.getMonth())) < 0 || (iCompareTo == 0 && eastAsianCalendar.getDayOfMonth() < eastAsianCalendar2.getDayOfMonth()))) {
                    cycle++;
                }
                return cycle;
            }
            if (i != 2) {
                if (i == 3) {
                    return (eastAsianCalendar2.getDaysSinceEpochUTC() - eastAsianCalendar.getDaysSinceEpochUTC()) / 7;
                }
                if (i == 4) {
                    return eastAsianCalendar2.getDaysSinceEpochUTC() - eastAsianCalendar.getDaysSinceEpochUTC();
                }
                throw new UnsupportedOperationException();
            }
            boolean zIsAfter = eastAsianCalendar.isAfter(eastAsianCalendar2);
            if (zIsAfter) {
                eastAsianCalendar4 = eastAsianCalendar;
                eastAsianCalendar3 = eastAsianCalendar2;
            } else {
                eastAsianCalendar3 = eastAsianCalendar;
                eastAsianCalendar4 = eastAsianCalendar2;
            }
            int cycle2 = eastAsianCalendar3.getCycle();
            int number = eastAsianCalendar3.getYear().getNumber();
            EastAsianMonth month = eastAsianCalendar3.getMonth();
            int number2 = month.getNumber();
            boolean zIsLeap = month.isLeap();
            int leapMonth2 = calendarSystem.getLeapMonth(cycle2, number);
            int i2 = 0;
            while (true) {
                if (cycle2 == eastAsianCalendar4.getCycle() && number == eastAsianCalendar4.getYear().getNumber() && month.equals(eastAsianCalendar4.getMonth())) {
                    break;
                }
                if (zIsLeap) {
                    number2++;
                    zIsLeap = false;
                } else if (leapMonth2 == number2) {
                    zIsLeap = true;
                } else {
                    number2++;
                }
                if (!zIsLeap) {
                    if (number2 == 13) {
                        number++;
                        if (number == 61) {
                            cycle2++;
                            number = 1;
                        }
                        leapMonth = calendarSystem.getLeapMonth(cycle2, number);
                        number2 = 1;
                    } else if (number2 == 0) {
                        number--;
                        if (number == 0) {
                            cycle2--;
                            number = 60;
                        }
                        leapMonth = calendarSystem.getLeapMonth(cycle2, number);
                        number2 = 12;
                    }
                    leapMonth2 = leapMonth;
                }
                month = EastAsianMonth.valueOf(number2);
                if (zIsLeap) {
                    month = month.withLeap();
                }
                i2++;
            }
            if (i2 > 0 && eastAsianCalendar3.getDayOfMonth() > eastAsianCalendar4.getDayOfMonth()) {
                i2--;
            }
            if (zIsAfter) {
                i2 = -i2;
            }
            return i2;
        }

        private static EastAsianCalendar create(int i, int i2, EastAsianMonth eastAsianMonth, int i3, EastAsianCS eastAsianCS) {
            if (i3 <= 29) {
                return eastAsianCS.create(i, i2, eastAsianMonth, i3, eastAsianCS.transform(i, i2, eastAsianMonth, i3));
            }
            long jTransform = eastAsianCS.transform(i, i2, eastAsianMonth, 1);
            int iMin = Math.min(i3, eastAsianCS.transform(jTransform).lengthOfMonth());
            return eastAsianCS.create(i, i2, eastAsianMonth, iMin, (jTransform + ((long) iMin)) - 1);
        }

        private static void checkAmountOfMonths(long j) {
            if (j > 1200 || j < -1200) {
                throw new ArithmeticException("Month arithmetic limited to delta not greater than 1200.");
            }
        }
    }
}
