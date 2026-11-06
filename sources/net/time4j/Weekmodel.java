package net.time4j;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.NumericalElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.WeekdataProvider;

/* JADX INFO: loaded from: classes5.dex */
public final class Weekmodel implements Serializable {
    private static final Map CACHE = new ConcurrentHashMap();
    public static final Weekmodel ISO = new Weekmodel(Weekday.MONDAY, 4, Weekday.SATURDAY, Weekday.SUNDAY);
    private static final WeekdataProvider LOCALIZED_WEEKDATA;
    private static final long serialVersionUID = 7794495882610436763L;
    private final transient AdjustableElement boundWomElement;
    private final transient AdjustableElement boundWoyElement;
    private final transient NavigableElement dayOfWeekElement;
    private final transient Set elements;
    private final transient Weekday endOfWeekend;
    private final transient Weekday firstDayOfWeek;
    private final transient int minimalDaysInFirstWeek;
    private final transient Weekday startOfWeekend;
    private final transient ChronoCondition weekendCondition;
    private final transient AdjustableElement womElement;
    private final transient AdjustableElement woyElement;

    static {
        Iterator it = ResourceLoader.getInstance().services(WeekdataProvider.class).iterator();
        LOCALIZED_WEEKDATA = it.hasNext() ? (WeekdataProvider) it.next() : null;
    }

    private Weekmodel(Weekday weekday, int i, final Weekday weekday2, final Weekday weekday3) {
        if (weekday == null) {
            throw new NullPointerException("Missing first day of week.");
        }
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal days in first week out of range: " + i);
        }
        if (weekday2 == null) {
            throw new NullPointerException("Missing start of weekend.");
        }
        if (weekday3 == null) {
            throw new NullPointerException("Missing end of weekend.");
        }
        this.firstDayOfWeek = weekday;
        this.minimalDaysInFirstWeek = i;
        this.startOfWeekend = weekday2;
        this.endOfWeekend = weekday3;
        CalendarWeekElement calendarWeekElement = new CalendarWeekElement("WEEK_OF_YEAR", 0);
        this.woyElement = calendarWeekElement;
        CalendarWeekElement calendarWeekElement2 = new CalendarWeekElement("WEEK_OF_MONTH", 1);
        this.womElement = calendarWeekElement2;
        CalendarWeekElement calendarWeekElement3 = new CalendarWeekElement("BOUNDED_WEEK_OF_YEAR", 2);
        this.boundWoyElement = calendarWeekElement3;
        CalendarWeekElement calendarWeekElement4 = new CalendarWeekElement("BOUNDED_WEEK_OF_MONTH", 3);
        this.boundWomElement = calendarWeekElement4;
        DayOfWeekElement dayOfWeekElement = new DayOfWeekElement();
        this.dayOfWeekElement = dayOfWeekElement;
        this.weekendCondition = new ChronoCondition() { // from class: net.time4j.Weekmodel.1
            @Override // net.time4j.engine.ChronoCondition
            public boolean test(GregorianDate gregorianDate) {
                Weekday weekdayValueOf = Weekday.valueOf(GregorianMath.getDayOfWeek(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth()));
                return weekdayValueOf == weekday2 || weekdayValueOf == weekday3;
            }
        };
        HashSet hashSet = new HashSet();
        hashSet.add(calendarWeekElement);
        hashSet.add(calendarWeekElement2);
        hashSet.add(dayOfWeekElement);
        hashSet.add(calendarWeekElement3);
        hashSet.add(calendarWeekElement4);
        this.elements = Collections.unmodifiableSet(hashSet);
    }

    public static Weekmodel of(Weekday weekday, int i) {
        return of(weekday, i, Weekday.SATURDAY, Weekday.SUNDAY);
    }

    public static Weekmodel of(Weekday weekday, int i, Weekday weekday2, Weekday weekday3) {
        if (weekday == Weekday.MONDAY && i == 4 && weekday2 == Weekday.SATURDAY && weekday3 == Weekday.SUNDAY) {
            return ISO;
        }
        return new Weekmodel(weekday, i, weekday2, weekday3);
    }

    public static Weekmodel of(Locale locale) {
        if (locale.getCountry().isEmpty()) {
            return ISO;
        }
        Map map = CACHE;
        Weekmodel weekmodel = (Weekmodel) map.get(locale);
        if (weekmodel != null) {
            return weekmodel;
        }
        WeekdataProvider weekdataProvider = LOCALIZED_WEEKDATA;
        if (weekdataProvider == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(locale);
            int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
            return of(Weekday.valueOf(firstDayOfWeek == 1 ? 7 : firstDayOfWeek - 1), gregorianCalendar.getMinimalDaysInFirstWeek());
        }
        Weekmodel weekmodel2 = new Weekmodel(Weekday.valueOf(weekdataProvider.getFirstDayOfWeek(locale)), weekdataProvider.getMinimalDaysInFirstWeek(locale), Weekday.valueOf(weekdataProvider.getStartOfWeekend(locale)), Weekday.valueOf(weekdataProvider.getEndOfWeekend(locale)));
        if (map.size() > 150) {
            map.clear();
        }
        map.put(locale, weekmodel2);
        return weekmodel2;
    }

    public Weekday getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public Weekday getStartOfWeekend() {
        return this.startOfWeekend;
    }

    public Weekday getEndOfWeekend() {
        return this.endOfWeekend;
    }

    public AdjustableElement weekOfYear() {
        return this.woyElement;
    }

    public AdjustableElement weekOfMonth() {
        return this.womElement;
    }

    public NavigableElement localDayOfWeek() {
        return this.dayOfWeekElement;
    }

    public AdjustableElement boundedWeekOfYear() {
        return this.boundWoyElement;
    }

    public AdjustableElement boundedWeekOfMonth() {
        return this.boundWomElement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Weekmodel) {
            Weekmodel weekmodel = (Weekmodel) obj;
            if (this.firstDayOfWeek == weekmodel.firstDayOfWeek && this.minimalDaysInFirstWeek == weekmodel.minimalDaysInFirstWeek && this.startOfWeekend == weekmodel.startOfWeekend && this.endOfWeekend == weekmodel.endOfWeekend) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.name().hashCode() * 17) + (this.minimalDaysInFirstWeek * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(Weekmodel.class.getName());
        sb.append("[firstDayOfWeek=");
        sb.append(this.firstDayOfWeek);
        sb.append(",minimalDaysInFirstWeek=");
        sb.append(this.minimalDaysInFirstWeek);
        sb.append(",startOfWeekend=");
        sb.append(this.startOfWeekend);
        sb.append(",endOfWeekend=");
        sb.append(this.endOfWeekend);
        sb.append(']');
        return sb.toString();
    }

    Set getElements() {
        return this.elements;
    }

    static Weekday getDayOfWeek(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }

    private Object writeReplace() {
        return new SPX(this, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private class DayOfWeekElement extends AbstractDateElement implements NavigableElement, NumericalElement, TextElement {
        private static final long serialVersionUID = 1945670789283677398L;

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public char getSymbol() {
            return 'e';
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        DayOfWeekElement() {
            super("LOCAL_DAY_OF_WEEK");
        }

        @Override // net.time4j.engine.ChronoElement
        public Class getType() {
            return Weekday.class;
        }

        public int numerical(Weekday weekday) {
            return weekday.getValue(Weekmodel.this);
        }

        @Override // net.time4j.format.NumericalElement
        public int printToInt(Weekday weekday, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
            return numerical(weekday);
        }

        @Override // net.time4j.format.NumericalElement
        public boolean parseFromInt(ChronoEntity chronoEntity, int i) {
            for (Weekday weekday : Weekday.values()) {
                if (weekday.getValue(Weekmodel.this) == i) {
                    chronoEntity.with(this, weekday);
                    return true;
                }
            }
            return false;
        }

        @Override // net.time4j.engine.BasicElement, java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            int value = ((Weekday) chronoDisplay.get(this)).getValue(Weekmodel.this);
            int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(Weekmodel.this);
            if (value < value2) {
                return -1;
            }
            return value == value2 ? 0 : 1;
        }

        @Override // net.time4j.engine.ChronoElement
        public Weekday getDefaultMinimum() {
            return Weekmodel.this.getFirstDayOfWeek();
        }

        @Override // net.time4j.engine.ChronoElement
        public Weekday getDefaultMaximum() {
            return Weekmodel.this.getFirstDayOfWeek().roll(6);
        }

        @Override // net.time4j.format.TextElement
        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(accessor(attributeQuery, (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print((Enum) chronoDisplay.get(this)));
        }

        @Override // net.time4j.format.TextElement
        public Weekday parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int index = parsePosition.getIndex();
            AttributeKey attributeKey = Attributes.OUTPUT_CONTEXT;
            OutputContext outputContext = OutputContext.FORMAT;
            OutputContext outputContext2 = (OutputContext) attributeQuery.get(attributeKey, outputContext);
            Weekday weekday = (Weekday) accessor(attributeQuery, outputContext2).parse(charSequence, parsePosition, getType(), attributeQuery);
            if (weekday != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                return weekday;
            }
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            if (outputContext2 == outputContext) {
                outputContext = OutputContext.STANDALONE;
            }
            return (Weekday) accessor(attributeQuery, outputContext).parse(charSequence, parsePosition, getType(), attributeQuery);
        }

        @Override // net.time4j.engine.BasicElement
        protected boolean doEquals(BasicElement basicElement) {
            return getModel().equals(((DayOfWeekElement) basicElement).getModel());
        }

        @Override // net.time4j.engine.BasicElement
        protected ElementRule derive(Chronology chronology) {
            if (chronology.isRegistered(PlainDate.CALENDAR_DATE)) {
                return new DRule(this);
            }
            return null;
        }

        @Override // net.time4j.engine.BasicElement
        protected ChronoElement getParent() {
            return PlainDate.DAY_OF_WEEK;
        }

        private TextAccessor accessor(AttributeQuery attributeQuery, OutputContext outputContext) {
            return CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getWeekdays((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), outputContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Weekmodel getModel() {
            return Weekmodel.this;
        }

        private Object readResolve() throws ObjectStreamException {
            return Weekmodel.this.localDayOfWeek();
        }
    }

    private static class DRule implements ElementRule {
        final DayOfWeekElement element;

        private DRule(DayOfWeekElement dayOfWeekElement) {
            this.element = dayOfWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getValue(ChronoEntity chronoEntity) {
            return ((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)).getDayOfWeek();
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMinimum(ChronoEntity chronoEntity) {
            PlainDate plainDate = (PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE);
            if ((plainDate.getDaysSinceEpochUTC() + 1) - ((long) plainDate.getDayOfWeek().getValue(this.element.getModel())) < PlainDate.axis().getCalendarSystem().getMinimumSinceUTC()) {
                return Weekday.MONDAY;
            }
            return this.element.getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public Weekday getMaximum(ChronoEntity chronoEntity) {
            PlainDate plainDate = (PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE);
            if ((plainDate.getDaysSinceEpochUTC() + 7) - ((long) plainDate.getDayOfWeek().getValue(this.element.getModel())) > PlainDate.axis().getCalendarSystem().getMaximumSinceUTC()) {
                return Weekday.FRIDAY;
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
            } catch (RuntimeException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Weekday weekday, boolean z) {
            if (weekday == null) {
                throw new IllegalArgumentException("Missing weekday.");
            }
            ChronoElement chronoElement = PlainDate.CALENDAR_DATE;
            PlainDate plainDate = (PlainDate) chronoEntity.get(chronoElement);
            long daysSinceUTC = plainDate.getDaysSinceUTC();
            Weekday dayOfWeek = Weekmodel.getDayOfWeek(daysSinceUTC);
            if (weekday == dayOfWeek) {
                return chronoEntity;
            }
            return chronoEntity.with(chronoElement, plainDate.withDaysSinceUTC((daysSinceUTC + ((long) weekday.getValue(this.element.getModel()))) - ((long) dayOfWeek.getValue(this.element.getModel()))));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return getChild(chronoEntity);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return getChild(chronoEntity);
        }

        private ChronoElement getChild(ChronoEntity chronoEntity) {
            ChronoElement chronoElement = PlainTime.WALL_TIME;
            if (chronoEntity.contains(chronoElement)) {
                return chronoElement;
            }
            return null;
        }
    }

    private class CalendarWeekElement extends AbstractDateElement {
        private static final long serialVersionUID = -5936254509996557266L;
        private final int category;

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        CalendarWeekElement(String str, int i) {
            super(str);
            this.category = i;
        }

        @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
        public char getSymbol() {
            int i = this.category;
            if (i == 0) {
                return 'w';
            }
            if (i != 1) {
                return super.getSymbol();
            }
            return 'W';
        }

        @Override // net.time4j.engine.ChronoElement
        public Class getType() {
            return Integer.class;
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMinimum() {
            return 1;
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMaximum() {
            return Integer.valueOf(isYearRelated() ? 52 : 5);
        }

        @Override // net.time4j.engine.BasicElement
        protected boolean doEquals(BasicElement basicElement) {
            return getModel().equals(((CalendarWeekElement) basicElement).getModel());
        }

        @Override // net.time4j.engine.BasicElement
        protected ChronoElement getParent() {
            return PlainDate.WEEKDAY_IN_MONTH;
        }

        @Override // net.time4j.engine.BasicElement
        protected ElementRule derive(Chronology chronology) {
            if (!chronology.isRegistered(PlainDate.CALENDAR_DATE)) {
                return null;
            }
            if (isBounded()) {
                return new BWRule(this);
            }
            return new CWRule(this);
        }

        private Object readResolve() throws ObjectStreamException {
            Weekmodel model = getModel();
            int i = this.category;
            if (i == 0) {
                return model.weekOfYear();
            }
            if (i == 1) {
                return model.weekOfMonth();
            }
            if (i == 2) {
                return model.boundedWeekOfYear();
            }
            if (i == 3) {
                return model.boundedWeekOfMonth();
            }
            throw new InvalidObjectException("Unknown category: " + this.category);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Weekmodel getModel() {
            return Weekmodel.this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isYearRelated() {
            return this.category % 2 == 0;
        }

        private boolean isBounded() {
            return this.category >= 2;
        }
    }

    private static class CWRule implements ElementRule {
        private final CalendarWeekElement owner;

        private CWRule(CalendarWeekElement calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(ChronoEntity chronoEntity) {
            return 1;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMaxCalendarWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)));
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            return getChild();
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            return getChild();
        }

        private ChronoElement getChild() {
            return this.owner.getModel().localDayOfWeek();
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(ChronoEntity chronoEntity) {
            return Integer.valueOf(getCalendarWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)));
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Integer num) {
            if (num == null) {
                return false;
            }
            int iIntValue = num.intValue();
            if (this.owner.isYearRelated() && iIntValue >= 1 && iIntValue <= 52) {
                return true;
            }
            if (!this.owner.isYearRelated() || iIntValue == 53) {
                return iIntValue >= 1 && iIntValue <= getMaxCalendarWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE));
            }
            return false;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
            ChronoElement chronoElement = PlainDate.CALENDAR_DATE;
            PlainDate plainDate = (PlainDate) chronoEntity.get(chronoElement);
            if (num == null || (!z && !isValid(chronoEntity, num))) {
                throw new IllegalArgumentException("Invalid value: " + num + " (context=" + chronoEntity + ")");
            }
            return chronoEntity.with(chronoElement, setCalendarWeek(plainDate, num.intValue()));
        }

        private int getMaxCalendarWeek(PlainDate plainDate) {
            int dayOfMonth;
            if (this.owner.isYearRelated()) {
                dayOfMonth = plainDate.getDayOfYear();
            } else {
                dayOfMonth = plainDate.getDayOfMonth();
            }
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(plainDate, 0);
            if (firstCalendarWeekAsDay <= dayOfMonth) {
                int firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(plainDate, 1) + getLengthOfYM(plainDate, 0);
                if (firstCalendarWeekAsDay2 <= dayOfMonth) {
                    try {
                        int firstCalendarWeekAsDay3 = getFirstCalendarWeekAsDay(plainDate, 1);
                        firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(plainDate, 2) + getLengthOfYM(plainDate, 1);
                        firstCalendarWeekAsDay = firstCalendarWeekAsDay3;
                    } catch (RuntimeException unused) {
                        firstCalendarWeekAsDay2 += 7;
                    }
                }
                return (firstCalendarWeekAsDay2 - firstCalendarWeekAsDay) / 7;
            }
            return ((firstCalendarWeekAsDay + getLengthOfYM(plainDate, -1)) - getFirstCalendarWeekAsDay(plainDate, -1)) / 7;
        }

        private int getFirstCalendarWeekAsDay(PlainDate plainDate, int i) {
            Weekday weekdayStart = getWeekdayStart(plainDate, i);
            Weekmodel model = this.owner.getModel();
            int value = weekdayStart.getValue(model);
            return value <= 8 - model.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
        }

        private Weekday getWeekdayStart(PlainDate plainDate, int i) {
            if (this.owner.isYearRelated()) {
                return Weekday.valueOf(GregorianMath.getDayOfWeek(plainDate.getYear() + i, 1, 1));
            }
            int year = plainDate.getYear();
            int month = plainDate.getMonth() + i;
            if (month == 0) {
                year--;
                month = 12;
            } else if (month == 13) {
                year++;
                month = 1;
            } else if (month == 14) {
                year++;
                month = 2;
            }
            return Weekday.valueOf(GregorianMath.getDayOfWeek(year, month, 1));
        }

        private int getLengthOfYM(PlainDate plainDate, int i) {
            if (this.owner.isYearRelated()) {
                return GregorianMath.isLeapYear(plainDate.getYear() + i) ? 366 : 365;
            }
            int year = plainDate.getYear();
            int month = plainDate.getMonth() + i;
            if (month == 0) {
                year--;
                month = 12;
            } else if (month == 13) {
                year++;
                month = 1;
            }
            return GregorianMath.getLengthOfMonth(year, month);
        }

        private int getCalendarWeek(PlainDate plainDate) {
            int dayOfMonth;
            if (this.owner.isYearRelated()) {
                dayOfMonth = plainDate.getDayOfYear();
            } else {
                dayOfMonth = plainDate.getDayOfMonth();
            }
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(plainDate, 0);
            if (firstCalendarWeekAsDay <= dayOfMonth) {
                int i = ((dayOfMonth - firstCalendarWeekAsDay) / 7) + 1;
                if ((i >= 53 || (!this.owner.isYearRelated() && i >= 5)) && getFirstCalendarWeekAsDay(plainDate, 1) + getLengthOfYM(plainDate, 0) <= dayOfMonth) {
                    return 1;
                }
                return i;
            }
            return (((dayOfMonth + getLengthOfYM(plainDate, -1)) - getFirstCalendarWeekAsDay(plainDate, -1)) / 7) + 1;
        }

        private PlainDate setCalendarWeek(PlainDate plainDate, int i) {
            int calendarWeek = getCalendarWeek(plainDate);
            if (i == calendarWeek) {
                return plainDate;
            }
            return plainDate.withDaysSinceUTC(plainDate.getDaysSinceUTC() + ((long) ((i - calendarWeek) * 7)));
        }
    }

    private static class BWRule implements ElementRule {
        private final CalendarWeekElement owner;

        private BWRule(CalendarWeekElement calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(ChronoEntity chronoEntity) {
            return Integer.valueOf(getWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMinWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)));
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(ChronoEntity chronoEntity) {
            return Integer.valueOf(getMaxWeek((PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE)));
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
            PlainDate plainDate = (PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE);
            NavigableElement navigableElementLocalDayOfWeek = this.owner.getModel().localDayOfWeek();
            int iIntValue = getValue(chronoEntity).intValue();
            if (z) {
                if (iIntValue >= (this.owner.isYearRelated() ? 52 : 4)) {
                    PlainDate plainDate2 = (PlainDate) plainDate.with(navigableElementLocalDayOfWeek, chronoEntity.getMaximum(navigableElementLocalDayOfWeek));
                    if (this.owner.isYearRelated()) {
                        if (plainDate2.getDayOfYear() < plainDate.getDayOfYear()) {
                            return PlainDate.DAY_OF_YEAR;
                        }
                    } else if (plainDate2.getDayOfMonth() < plainDate.getDayOfMonth()) {
                        return PlainDate.DAY_OF_MONTH;
                    }
                }
            } else if (iIntValue <= 1) {
                PlainDate plainDate3 = (PlainDate) plainDate.with(navigableElementLocalDayOfWeek, chronoEntity.getMinimum(navigableElementLocalDayOfWeek));
                if (this.owner.isYearRelated()) {
                    if (plainDate3.getDayOfYear() > plainDate.getDayOfYear()) {
                        return PlainDate.DAY_OF_YEAR;
                    }
                } else if (plainDate3.getDayOfMonth() > plainDate.getDayOfMonth()) {
                    return PlainDate.DAY_OF_MONTH;
                }
            }
            return navigableElementLocalDayOfWeek;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, Integer num) {
            if (num == null) {
                return false;
            }
            int iIntValue = num.intValue();
            PlainDate plainDate = (PlainDate) chronoEntity.get(PlainDate.CALENDAR_DATE);
            return iIntValue >= getMinWeek(plainDate) && iIntValue <= getMaxWeek(plainDate);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, Integer num, boolean z) {
            ChronoElement chronoElement = PlainDate.CALENDAR_DATE;
            PlainDate plainDate = (PlainDate) chronoEntity.get(chronoElement);
            if (num == null || (!z && !isValid(chronoEntity, num))) {
                throw new IllegalArgumentException("Invalid value: " + num + " (context=" + chronoEntity + ")");
            }
            return chronoEntity.with(chronoElement, setWeek(plainDate, num.intValue()));
        }

        private int getWeek(PlainDate plainDate) {
            return getWeek(plainDate, 0);
        }

        private int getMinWeek(PlainDate plainDate) {
            return getWeek(plainDate, -1);
        }

        private int getMaxWeek(PlainDate plainDate) {
            return getWeek(plainDate, 1);
        }

        private int getWeek(PlainDate plainDate, int i) {
            int dayOfMonth;
            if (this.owner.isYearRelated()) {
                dayOfMonth = plainDate.getDayOfYear();
            } else {
                dayOfMonth = plainDate.getDayOfMonth();
            }
            int value = Weekmodel.getDayOfWeek((plainDate.getDaysSinceUTC() - ((long) dayOfMonth)) + 1).getValue(this.owner.getModel());
            int i2 = value <= 8 - this.owner.getModel().getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
            if (i == -1) {
                dayOfMonth = 1;
            } else if (i != 0) {
                if (i == 1) {
                    dayOfMonth = getLengthOfYM(plainDate);
                } else {
                    throw new AssertionError("Unexpected: " + i);
                }
            }
            return MathUtils.floorDivide(dayOfMonth - i2, 7) + 1;
        }

        private PlainDate setWeek(PlainDate plainDate, int i) {
            int week = getWeek(plainDate);
            if (i == week) {
                return plainDate;
            }
            return plainDate.withDaysSinceUTC(plainDate.getDaysSinceUTC() + ((long) ((i - week) * 7)));
        }

        private int getLengthOfYM(PlainDate plainDate) {
            if (this.owner.isYearRelated()) {
                return GregorianMath.isLeapYear(plainDate.getYear()) ? 366 : 365;
            }
            return GregorianMath.getLengthOfMonth(plainDate.getYear(), plainDate.getMonth());
        }
    }
}
