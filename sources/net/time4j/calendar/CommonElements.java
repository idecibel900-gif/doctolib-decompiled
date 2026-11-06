package net.time4j.calendar;

import java.io.ObjectStreamException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CommonElements {
    public static final ChronoElement RELATED_GREGORIAN_YEAR = RelatedGregorianYearElement.SINGLETON;

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMax(ChronoElement chronoElement, ChronoEntity chronoEntity) {
        return ((Integer) Integer.class.cast(chronoEntity.getMaximum(chronoElement))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Weekday getDayOfWeek(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }

    static class Weekengine implements ChronoExtension {
        private final Class chronoType;
        private final ChronoElement dayOfMonthElement;
        private final ChronoElement dayOfYearElement;
        private final Weekmodel defaultWeekmodel;

        @Override // net.time4j.engine.ChronoExtension
        public boolean canResolve(ChronoElement chronoElement) {
            return false;
        }

        @Override // net.time4j.engine.ChronoExtension
        public ChronoEntity resolve(ChronoEntity chronoEntity, Locale locale, AttributeQuery attributeQuery) {
            return chronoEntity;
        }

        Weekengine(Class cls, ChronoElement chronoElement, ChronoElement chronoElement2, Weekmodel weekmodel) {
            this.chronoType = cls;
            this.dayOfMonthElement = chronoElement;
            this.dayOfYearElement = chronoElement2;
            this.defaultWeekmodel = weekmodel;
        }

        @Override // net.time4j.engine.ChronoExtension
        public boolean accept(Class cls) {
            return this.chronoType.equals(cls);
        }

        @Override // net.time4j.engine.ChronoExtension
        public Set getElements(Locale locale, AttributeQuery attributeQuery) {
            Weekmodel weekmodelOf = locale.getCountry().isEmpty() ? this.defaultWeekmodel : Weekmodel.of(locale);
            HashSet hashSet = new HashSet();
            hashSet.add(DayOfWeekElement.of(this.chronoType, weekmodelOf));
            hashSet.add(CalendarWeekElement.of("WEEK_OF_MONTH", this.chronoType, 1, 5, 'W', weekmodelOf, this.dayOfMonthElement, false));
            hashSet.add(CalendarWeekElement.of("WEEK_OF_YEAR", this.chronoType, 1, 52, 'w', weekmodelOf, this.dayOfYearElement, false));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_MONTH", this.chronoType, 1, 5, (char) 0, weekmodelOf, this.dayOfMonthElement, true));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_YEAR", this.chronoType, 1, 52, (char) 0, weekmodelOf, this.dayOfYearElement, true));
            return Collections.unmodifiableSet(hashSet);
        }
    }

    private static class CalendarWeekElement extends StdIntegerDateElement {
        private static final long serialVersionUID = -7471192143785466686L;
        private final boolean bounded;
        private final ChronoElement dayElement;
        private final Weekmodel model;

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return true;
        }

        @Override // net.time4j.calendar.service.StdDateElement
        protected Object readResolve() throws ObjectStreamException {
            return this;
        }

        CalendarWeekElement(String str, Class cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement chronoElement, boolean z) {
            super(str, cls, i, i2, c);
            if (weekmodel == null) {
                throw new NullPointerException("Missing week model.");
            }
            this.model = weekmodel;
            this.dayElement = chronoElement;
            this.bounded = z;
        }

        static CalendarWeekElement of(String str, Class cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement chronoElement, boolean z) {
            return new CalendarWeekElement(str, cls, i, i2, c, weekmodel, chronoElement, z);
        }

        @Override // net.time4j.calendar.service.StdDateElement, net.time4j.engine.BasicElement
        protected boolean doEquals(BasicElement basicElement) {
            if (super.doEquals(basicElement)) {
                CalendarWeekElement calendarWeekElement = (CalendarWeekElement) CalendarWeekElement.class.cast(basicElement);
                if (this.model.equals(calendarWeekElement.model) && this.bounded == calendarWeekElement.bounded) {
                    return true;
                }
            }
            return false;
        }

        @Override // net.time4j.engine.BasicElement
        protected ElementRule derive(Chronology chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return this.bounded ? new BWRule(this) : new CWRule(this);
            }
            return null;
        }
    }

    private static class CWRule implements ElementRule {
        private final CalendarWeekElement owner;

        private CWRule(CalendarWeekElement calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(ChronoEntity chronoEntity) {
            return Integer.valueOf(getCalendarWeek(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(ChronoEntity chronoEntity) {
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMaxCalendarWeek(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= 1 && iIntValue <= getMaxCalendarWeek(chronoEntity);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
            int iIntValue = num.intValue();
            if (!z && !isValid(chronoEntity, num)) {
                throw new IllegalArgumentException("Invalid value: " + iIntValue + " (context=" + chronoEntity + ")");
            }
            return setCalendarWeek(chronoEntity, iIntValue);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return getChild(chronoEntity.getClass());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return getChild(chronoEntity.getClass());
        }

        private ChronoElement getChild(Object obj) {
            return new DayOfWeekElement((Class) obj, this.owner.model);
        }

        private int getMaxCalendarWeek(ChronoEntity chronoEntity) {
            int i = chronoEntity.getInt(this.owner.dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(chronoEntity, 0);
            if (firstCalendarWeekAsDay <= i) {
                int firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(chronoEntity, 1) + getLengthOfYM(chronoEntity, 0);
                if (firstCalendarWeekAsDay2 <= i) {
                    try {
                        int firstCalendarWeekAsDay3 = getFirstCalendarWeekAsDay(chronoEntity, 1);
                        EpochDays epochDays = EpochDays.UTC;
                        firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(chronoEntity.with(epochDays, ((Long) chronoEntity.get(epochDays)).longValue() + 7), 1) + getLengthOfYM(chronoEntity, 1);
                        firstCalendarWeekAsDay = firstCalendarWeekAsDay3;
                    } catch (RuntimeException unused) {
                        firstCalendarWeekAsDay2 += 7;
                    }
                }
                return (firstCalendarWeekAsDay2 - firstCalendarWeekAsDay) / 7;
            }
            return ((firstCalendarWeekAsDay + getLengthOfYM(chronoEntity, -1)) - getFirstCalendarWeekAsDay(chronoEntity, -1)) / 7;
        }

        private int getFirstCalendarWeekAsDay(ChronoEntity chronoEntity, int i) {
            Weekday weekdayStart = getWeekdayStart(chronoEntity, i);
            Weekmodel weekmodel = this.owner.model;
            int value = weekdayStart.getValue(weekmodel);
            return value <= 8 - weekmodel.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
        }

        private Weekday getWeekdayStart(ChronoEntity chronoEntity, int i) {
            int i2 = chronoEntity.getInt(this.owner.dayElement);
            if (i == -1) {
                EpochDays epochDays = EpochDays.UTC;
                long jLongValue = ((Long) chronoEntity.get(epochDays)).longValue() - ((long) i2);
                return CommonElements.getDayOfWeek((jLongValue - ((long) chronoEntity.with(epochDays, jLongValue).getInt(this.owner.dayElement))) + 1);
            }
            if (i == 0) {
                return CommonElements.getDayOfWeek((((Long) chronoEntity.get(EpochDays.UTC)).longValue() - ((long) i2)) + 1);
            }
            if (i == 1) {
                return CommonElements.getDayOfWeek(((((Long) chronoEntity.get(EpochDays.UTC)).longValue() + ((long) CommonElements.getMax(this.owner.dayElement, chronoEntity))) + 1) - ((long) i2));
            }
            throw new AssertionError("Unexpected: " + i);
        }

        private int getLengthOfYM(ChronoEntity chronoEntity, int i) {
            int i2 = chronoEntity.getInt(this.owner.dayElement);
            if (i == -1) {
                ChronoElement chronoElement = this.owner.dayElement;
                EpochDays epochDays = EpochDays.UTC;
                return CommonElements.getMax(chronoElement, chronoEntity.with(epochDays, ((Long) chronoEntity.get(epochDays)).longValue() - ((long) i2)));
            }
            if (i == 0) {
                return CommonElements.getMax(this.owner.dayElement, chronoEntity);
            }
            if (i == 1) {
                int max = CommonElements.getMax(this.owner.dayElement, chronoEntity);
                ChronoElement chronoElement2 = this.owner.dayElement;
                EpochDays epochDays2 = EpochDays.UTC;
                return CommonElements.getMax(chronoElement2, chronoEntity.with(epochDays2, ((((Long) chronoEntity.get(epochDays2)).longValue() + ((long) max)) + 1) - ((long) i2)));
            }
            throw new AssertionError("Unexpected: " + i);
        }

        private int getCalendarWeek(ChronoEntity chronoEntity) {
            int lengthOfYM;
            int i = chronoEntity.getInt(this.owner.dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(chronoEntity, 0);
            if (firstCalendarWeekAsDay <= i) {
                if (getFirstCalendarWeekAsDay(chronoEntity, 1) + getLengthOfYM(chronoEntity, 0) <= i) {
                    return 1;
                }
                lengthOfYM = (i - firstCalendarWeekAsDay) / 7;
            } else {
                lengthOfYM = ((i + getLengthOfYM(chronoEntity, -1)) - getFirstCalendarWeekAsDay(chronoEntity, -1)) / 7;
            }
            return lengthOfYM + 1;
        }

        private ChronoEntity setCalendarWeek(ChronoEntity chronoEntity, int i) {
            int calendarWeek = getCalendarWeek(chronoEntity);
            if (i == calendarWeek) {
                return chronoEntity;
            }
            EpochDays epochDays = EpochDays.UTC;
            return chronoEntity.with(epochDays, ((Long) chronoEntity.get(epochDays)).longValue() + ((long) ((i - calendarWeek) * 7)));
        }
    }

    private static class BWRule implements ElementRule {
        private final CalendarWeekElement owner;

        private BWRule(CalendarWeekElement calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(ChronoEntity chronoEntity) {
            return Integer.valueOf(getWeek(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMinWeek(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMaxWeek(chronoEntity));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return getChild(chronoEntity, false);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return getChild(chronoEntity, true);
        }

        private ChronoElement getChild(ChronoEntity chronoEntity, boolean z) {
            DayOfWeekElement dayOfWeekElementOf = DayOfWeekElement.of(chronoEntity.getClass(), this.owner.model);
            int week = getWeek(chronoEntity);
            EpochDays epochDays = EpochDays.UTC;
            long jLongValue = ((Long) chronoEntity.get(epochDays)).longValue();
            int i = chronoEntity.getInt(this.owner.dayElement);
            if (z) {
                if (((Integer) chronoEntity.getMaximum(this.owner.dayElement)).intValue() < ((long) i) + (((Long) chronoEntity.with(dayOfWeekElementOf, chronoEntity.getMaximum(dayOfWeekElementOf)).get(epochDays)).longValue() - jLongValue)) {
                    return this.owner.dayElement;
                }
            } else if (week <= 1) {
                if (((Integer) chronoEntity.getMinimum(this.owner.dayElement)).intValue() > ((long) i) - (jLongValue - ((Long) chronoEntity.with(dayOfWeekElementOf, chronoEntity.getMinimum(dayOfWeekElementOf)).get(epochDays)).longValue())) {
                    return this.owner.dayElement;
                }
            }
            return dayOfWeekElementOf;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= getMinWeek(chronoEntity) && iIntValue <= getMaxWeek(chronoEntity);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
            if (num == null || (!z && !isValid(chronoEntity, num))) {
                throw new IllegalArgumentException("Invalid value: " + num + " (context=" + chronoEntity + ")");
            }
            return setWeek(chronoEntity, num.intValue());
        }

        private int getWeek(ChronoEntity chronoEntity) {
            return getWeek(chronoEntity, 0);
        }

        private int getMinWeek(ChronoEntity chronoEntity) {
            return getWeek(chronoEntity, -1);
        }

        private int getMaxWeek(ChronoEntity chronoEntity) {
            return getWeek(chronoEntity, 1);
        }

        private int getWeek(ChronoEntity chronoEntity, int i) {
            int iIntValue = chronoEntity.getInt(this.owner.dayElement);
            int value = CommonElements.getDayOfWeek((((Long) chronoEntity.get(EpochDays.UTC)).longValue() - ((long) iIntValue)) + 1).getValue(this.owner.model);
            int i2 = value <= 8 - this.owner.model.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
            if (i == -1) {
                iIntValue = 1;
            } else if (i != 0) {
                if (i == 1) {
                    iIntValue = ((Integer) chronoEntity.getMaximum(this.owner.dayElement)).intValue();
                } else {
                    throw new AssertionError("Unexpected: " + i);
                }
            }
            return MathUtils.floorDivide(iIntValue - i2, 7) + 1;
        }

        private ChronoEntity setWeek(ChronoEntity chronoEntity, int i) {
            int week = getWeek(chronoEntity);
            if (i == week) {
                return chronoEntity;
            }
            int i2 = (i - week) * 7;
            EpochDays epochDays = EpochDays.UTC;
            return chronoEntity.with(epochDays, ((Long) chronoEntity.get(epochDays)).longValue() + ((long) i2));
        }
    }

    private static class DayOfWeekElement extends StdEnumDateElement {
        private static final long serialVersionUID = 5613494586572932860L;
        private final Weekmodel model;

        @Override // net.time4j.calendar.service.StdEnumDateElement
        protected boolean isWeekdayElement() {
            return true;
        }

        @Override // net.time4j.calendar.service.StdDateElement
        protected Object readResolve() throws ObjectStreamException {
            return this;
        }

        DayOfWeekElement(Class cls, Weekmodel weekmodel) {
            super("LOCAL_DAY_OF_WEEK", cls, Weekday.class, 'e');
            this.model = weekmodel;
        }

        static DayOfWeekElement of(Class cls, Weekmodel weekmodel) {
            return new DayOfWeekElement(cls, weekmodel);
        }

        @Override // net.time4j.calendar.service.StdEnumDateElement
        public int numerical(Weekday weekday) {
            return weekday.getValue(this.model);
        }

        @Override // net.time4j.engine.ChronoElement
        public Weekday getDefaultMinimum() {
            return this.model.getFirstDayOfWeek();
        }

        @Override // net.time4j.engine.ChronoElement
        public Weekday getDefaultMaximum() {
            return this.model.getFirstDayOfWeek().roll(6);
        }

        @Override // net.time4j.engine.BasicElement, java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            int value = ((Weekday) chronoDisplay.get(this)).getValue(this.model);
            int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(this.model);
            if (value < value2) {
                return -1;
            }
            return value == value2 ? 0 : 1;
        }

        @Override // net.time4j.calendar.service.StdDateElement, net.time4j.engine.BasicElement
        protected boolean doEquals(BasicElement basicElement) {
            if (!super.doEquals(basicElement)) {
                return false;
            }
            return this.model.equals(((DayOfWeekElement) DayOfWeekElement.class.cast(basicElement)).model);
        }

        @Override // net.time4j.engine.BasicElement
        protected ElementRule derive(Chronology chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return new DRule(this);
            }
            return null;
        }
    }

    private static class DRule implements ElementRule {
        private final DayOfWeekElement element;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return null;
        }

        private DRule(DayOfWeekElement dayOfWeekElement) {
            this.element = dayOfWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getValue(ChronoEntity chronoEntity) {
            return CommonElements.getDayOfWeek(((Long) chronoEntity.get(EpochDays.UTC)).longValue());
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMinimum(ChronoEntity chronoEntity) {
            long minimumSinceUTC = Chronology.lookup(chronoEntity.getClass()).getCalendarSystem().getMinimumSinceUTC();
            long jLongValue = ((Long) chronoEntity.get(EpochDays.UTC)).longValue();
            if ((jLongValue + 1) - ((long) CommonElements.getDayOfWeek(jLongValue).getValue(this.element.model)) < minimumSinceUTC) {
                return CommonElements.getDayOfWeek(minimumSinceUTC);
            }
            return this.element.getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMaximum(ChronoEntity chronoEntity) {
            long maximumSinceUTC = Chronology.lookup(chronoEntity.getClass()).getCalendarSystem().getMaximumSinceUTC();
            long jLongValue = ((Long) chronoEntity.get(EpochDays.UTC)).longValue();
            if ((jLongValue + 7) - ((long) CommonElements.getDayOfWeek(jLongValue).getValue(this.element.model)) > maximumSinceUTC) {
                return CommonElements.getDayOfWeek(maximumSinceUTC);
            }
            return this.element.getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            try {
                withValue(chronoEntity, weekday, false);
                return true;
            } catch (ArithmeticException | IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Weekday weekday, boolean z) {
            EpochDays epochDays = EpochDays.UTC;
            long jLongValue = ((Long) chronoEntity.get(epochDays)).longValue();
            Weekday dayOfWeek = CommonElements.getDayOfWeek(jLongValue);
            if (weekday == dayOfWeek) {
                return chronoEntity;
            }
            return chronoEntity.with(epochDays, (jLongValue + ((long) weekday.getValue(this.element.model))) - ((long) dayOfWeek.getValue(this.element.model)));
        }
    }
}
