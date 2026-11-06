package net.time4j;

import io.didomi.ssl.config.app.SyncConfiguration;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FlagElement;
import net.time4j.engine.Normalizer;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class PlainTimestamp extends TimePoint implements GregorianDate, WallTime, Normalizer, LocalizedPatternSupport {
    private static final Map CHILDREN;
    private static final TimeAxis ENGINE;
    private static final PlainTimestamp MAX;
    private static final PlainTimestamp MIN;
    private static final TimeMetric STD_METRIC;
    private static final long serialVersionUID = 7458380065762437714L;
    private final transient PlainDate date;
    private final transient PlainTime time;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public PlainTimestamp getContext() {
        return this;
    }

    static {
        PlainTimestamp plainTimestamp = new PlainTimestamp(PlainDate.MIN, PlainTime.MIN);
        MIN = plainTimestamp;
        PlainDate plainDate = PlainDate.MAX;
        ChronoElement chronoElement = PlainTime.WALL_TIME;
        PlainTimestamp plainTimestamp2 = new PlainTimestamp(plainDate, (PlainTime) chronoElement.getDefaultMaximum());
        MAX = plainTimestamp2;
        HashMap map = new HashMap();
        ChronoElement chronoElement2 = PlainDate.CALENDAR_DATE;
        map.put(chronoElement2, chronoElement);
        AdjustableElement adjustableElement = PlainDate.YEAR;
        ProportionalElement proportionalElement = PlainDate.MONTH_AS_NUMBER;
        map.put(adjustableElement, proportionalElement);
        AdjustableElement adjustableElement2 = PlainDate.YEAR_OF_WEEKDATE;
        map.put(adjustableElement2, Weekmodel.ISO.weekOfYear());
        NavigableElement navigableElement = PlainDate.QUARTER_OF_YEAR;
        ProportionalElement proportionalElement2 = PlainDate.DAY_OF_QUARTER;
        map.put(navigableElement, proportionalElement2);
        NavigableElement navigableElement2 = PlainDate.MONTH_OF_YEAR;
        ProportionalElement proportionalElement3 = PlainDate.DAY_OF_MONTH;
        map.put(navigableElement2, proportionalElement3);
        map.put(proportionalElement, proportionalElement3);
        map.put(proportionalElement3, chronoElement);
        NavigableElement navigableElement3 = PlainDate.DAY_OF_WEEK;
        map.put(navigableElement3, chronoElement);
        ProportionalElement proportionalElement4 = PlainDate.DAY_OF_YEAR;
        map.put(proportionalElement4, chronoElement);
        map.put(proportionalElement2, chronoElement);
        OrdinalWeekdayElement ordinalWeekdayElement = PlainDate.WEEKDAY_IN_MONTH;
        map.put(ordinalWeekdayElement, chronoElement);
        ZonalElement zonalElement = PlainTime.AM_PM_OF_DAY;
        ProportionalElement proportionalElement5 = PlainTime.DIGITAL_HOUR_OF_AMPM;
        map.put(zonalElement, proportionalElement5);
        AdjustableElement adjustableElement3 = PlainTime.CLOCK_HOUR_OF_AMPM;
        ProportionalElement proportionalElement6 = PlainTime.MINUTE_OF_HOUR;
        map.put(adjustableElement3, proportionalElement6);
        AdjustableElement adjustableElement4 = PlainTime.CLOCK_HOUR_OF_DAY;
        map.put(adjustableElement4, proportionalElement6);
        map.put(proportionalElement5, proportionalElement6);
        ProportionalElement proportionalElement7 = PlainTime.DIGITAL_HOUR_OF_DAY;
        map.put(proportionalElement7, proportionalElement6);
        ProportionalElement proportionalElement8 = PlainTime.HOUR_FROM_0_TO_24;
        map.put(proportionalElement8, proportionalElement6);
        ProportionalElement proportionalElement9 = PlainTime.SECOND_OF_MINUTE;
        map.put(proportionalElement6, proportionalElement9);
        ProportionalElement proportionalElement10 = PlainTime.MINUTE_OF_DAY;
        map.put(proportionalElement10, proportionalElement9);
        ProportionalElement proportionalElement11 = PlainTime.NANO_OF_SECOND;
        map.put(proportionalElement9, proportionalElement11);
        ProportionalElement proportionalElement12 = PlainTime.SECOND_OF_DAY;
        map.put(proportionalElement12, proportionalElement11);
        CHILDREN = Collections.unmodifiableMap(map);
        TimeAxis.Builder up = TimeAxis.Builder.setUp(IsoUnit.class, PlainTimestamp.class, new Merger(null), plainTimestamp, plainTimestamp2);
        FieldRule fieldRuleOf = FieldRule.of(chronoElement2);
        CalendarUnit calendarUnit = CalendarUnit.DAYS;
        TimeAxis.Builder builderAppendElement = up.appendElement(chronoElement2, fieldRuleOf, calendarUnit);
        FieldRule fieldRuleOf2 = FieldRule.of(adjustableElement);
        CalendarUnit calendarUnit2 = CalendarUnit.YEARS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(adjustableElement, fieldRuleOf2, calendarUnit2).appendElement(adjustableElement2, FieldRule.of(adjustableElement2), Weekcycle.YEARS).appendElement(navigableElement, FieldRule.of(navigableElement), CalendarUnit.QUARTERS);
        FieldRule fieldRuleOf3 = FieldRule.of(navigableElement2);
        CalendarUnit calendarUnit3 = CalendarUnit.MONTHS;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(navigableElement2, fieldRuleOf3, calendarUnit3).appendElement(proportionalElement, FieldRule.of(proportionalElement), calendarUnit3).appendElement(proportionalElement3, FieldRule.of(proportionalElement3), calendarUnit).appendElement(navigableElement3, FieldRule.of(navigableElement3), calendarUnit).appendElement(proportionalElement4, FieldRule.of(proportionalElement4), calendarUnit).appendElement(proportionalElement2, FieldRule.of(proportionalElement2), calendarUnit).appendElement(ordinalWeekdayElement, FieldRule.of(ordinalWeekdayElement), CalendarUnit.WEEKS).appendElement(chronoElement, (ElementRule) FieldRule.of(chronoElement)).appendElement((ChronoElement) zonalElement, (ElementRule) FieldRule.of(zonalElement));
        FieldRule fieldRuleOf4 = FieldRule.of(adjustableElement3);
        ClockUnit clockUnit = ClockUnit.HOURS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(adjustableElement3, fieldRuleOf4, clockUnit).appendElement(adjustableElement4, FieldRule.of(adjustableElement4), clockUnit).appendElement(proportionalElement5, FieldRule.of(proportionalElement5), clockUnit).appendElement(proportionalElement7, FieldRule.of(proportionalElement7), clockUnit).appendElement(proportionalElement8, FieldRule.of(proportionalElement8), clockUnit);
        FieldRule fieldRuleOf5 = FieldRule.of(proportionalElement6);
        ClockUnit clockUnit2 = ClockUnit.MINUTES;
        TimeAxis.Builder builderAppendElement5 = builderAppendElement4.appendElement(proportionalElement6, fieldRuleOf5, clockUnit2).appendElement(proportionalElement10, FieldRule.of(proportionalElement10), clockUnit2);
        FieldRule fieldRuleOf6 = FieldRule.of(proportionalElement9);
        ClockUnit clockUnit3 = ClockUnit.SECONDS;
        TimeAxis.Builder builderAppendElement6 = builderAppendElement5.appendElement(proportionalElement9, fieldRuleOf6, clockUnit3).appendElement(proportionalElement12, FieldRule.of(proportionalElement12), clockUnit3);
        ProportionalElement proportionalElement13 = PlainTime.MILLI_OF_SECOND;
        FieldRule fieldRuleOf7 = FieldRule.of(proportionalElement13);
        ClockUnit clockUnit4 = ClockUnit.MILLIS;
        TimeAxis.Builder builderAppendElement7 = builderAppendElement6.appendElement(proportionalElement13, fieldRuleOf7, clockUnit4);
        ProportionalElement proportionalElement14 = PlainTime.MICRO_OF_SECOND;
        FieldRule fieldRuleOf8 = FieldRule.of(proportionalElement14);
        ClockUnit clockUnit5 = ClockUnit.MICROS;
        TimeAxis.Builder builderAppendElement8 = builderAppendElement7.appendElement(proportionalElement14, fieldRuleOf8, clockUnit5);
        FieldRule fieldRuleOf9 = FieldRule.of(proportionalElement11);
        ClockUnit clockUnit6 = ClockUnit.NANOS;
        TimeAxis.Builder builderAppendElement9 = builderAppendElement8.appendElement(proportionalElement11, fieldRuleOf9, clockUnit6);
        ProportionalElement proportionalElement15 = PlainTime.MILLI_OF_DAY;
        TimeAxis.Builder builderAppendElement10 = builderAppendElement9.appendElement(proportionalElement15, FieldRule.of(proportionalElement15), clockUnit4);
        ProportionalElement proportionalElement16 = PlainTime.MICRO_OF_DAY;
        TimeAxis.Builder builderAppendElement11 = builderAppendElement10.appendElement(proportionalElement16, FieldRule.of(proportionalElement16), clockUnit5);
        ProportionalElement proportionalElement17 = PlainTime.NANO_OF_DAY;
        TimeAxis.Builder builderAppendElement12 = builderAppendElement11.appendElement(proportionalElement17, FieldRule.of(proportionalElement17), clockUnit6);
        ZonalElement zonalElement2 = PlainTime.DECIMAL_HOUR;
        TimeAxis.Builder builderAppendElement13 = builderAppendElement12.appendElement((ChronoElement) zonalElement2, (ElementRule) new DecimalRule(zonalElement2));
        ZonalElement zonalElement3 = PlainTime.DECIMAL_MINUTE;
        TimeAxis.Builder builderAppendElement14 = builderAppendElement13.appendElement((ChronoElement) zonalElement3, (ElementRule) new DecimalRule(zonalElement3));
        ZonalElement zonalElement4 = PlainTime.DECIMAL_SECOND;
        TimeAxis.Builder builderAppendElement15 = builderAppendElement14.appendElement((ChronoElement) zonalElement4, (ElementRule) new DecimalRule(zonalElement4));
        ChronoElement chronoElement3 = PlainTime.PRECISION;
        TimeAxis.Builder builderAppendElement16 = builderAppendElement15.appendElement(chronoElement3, (ElementRule) FieldRule.of(chronoElement3));
        registerCalendarUnits(builderAppendElement16);
        registerClockUnits(builderAppendElement16);
        registerExtensions(builderAppendElement16);
        ENGINE = builderAppendElement16.build();
        STD_METRIC = Duration.in(calendarUnit2, calendarUnit3, calendarUnit, clockUnit, clockUnit2, clockUnit3, clockUnit6);
    }

    private PlainTimestamp(PlainDate plainDate, PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            this.date = (PlainDate) plainDate.plus(1L, CalendarUnit.DAYS);
            this.time = PlainTime.MIN;
        } else {
            if (plainDate == null) {
                throw new NullPointerException("Missing date.");
            }
            this.date = plainDate;
            this.time = plainTime;
        }
    }

    public static PlainTimestamp of(PlainDate plainDate, PlainTime plainTime) {
        return new PlainTimestamp(plainDate, plainTime);
    }

    public static PlainTimestamp of(int i, int i2, int i3, int i4, int i5, int i6) {
        return of(PlainDate.of(i, i2, i3), PlainTime.of(i4, i5, i6));
    }

    public PlainDate getCalendarDate() {
        return this.date;
    }

    public PlainTime getWallTime() {
        return this.time;
    }

    @Override // net.time4j.base.GregorianDate
    public int getYear() {
        return this.date.getYear();
    }

    @Override // net.time4j.base.GregorianDate
    public int getMonth() {
        return this.date.getMonth();
    }

    @Override // net.time4j.base.GregorianDate
    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    @Override // net.time4j.base.WallTime
    public int getHour() {
        return this.time.getHour();
    }

    @Override // net.time4j.base.WallTime
    public int getMinute() {
        return this.time.getMinute();
    }

    @Override // net.time4j.base.WallTime
    public int getSecond() {
        return this.time.getSecond();
    }

    @Override // net.time4j.base.WallTime
    public int getNanosecond() {
        return this.time.getNanosecond();
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(PlainTimestamp plainTimestamp) {
        if (this.date.isAfter(plainTimestamp.date)) {
            return 1;
        }
        if (this.date.isBefore(plainTimestamp.date)) {
            return -1;
        }
        return this.time.compareTo(plainTimestamp.time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlainTimestamp) {
            PlainTimestamp plainTimestamp = (PlainTimestamp) obj;
            if (this.date.equals(plainTimestamp.date) && this.time.equals(plainTimestamp.time)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.date.hashCode() * 13) + (this.time.hashCode() * 37);
    }

    @Override // net.time4j.base.GregorianDate
    public String toString() {
        return this.date.toString() + this.time.toString();
    }

    public PlainDate toDate() {
        return this.date;
    }

    public static TimeAxis axis() {
        return ENGINE;
    }

    public Moment atUTC() {
        return at(ZonalOffset.UTC);
    }

    public Moment at(ZonalOffset zonalOffset) {
        long jSafeMultiply = MathUtils.safeMultiply(this.date.getDaysSinceUTC() + 730, 86400L) + ((long) (this.time.getHour() * 3600)) + ((long) (this.time.getMinute() * 60)) + ((long) this.time.getSecond());
        int nanosecond = this.time.getNanosecond();
        long integralAmount = jSafeMultiply - ((long) zonalOffset.getIntegralAmount());
        int fractionalAmount = nanosecond - zonalOffset.getFractionalAmount();
        if (fractionalAmount < 0) {
            fractionalAmount += Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            integralAmount--;
        } else if (fractionalAmount >= 1000000000) {
            fractionalAmount -= Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            integralAmount++;
        }
        return Moment.of(integralAmount, fractionalAmount, TimeScale.POSIX);
    }

    public Moment inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public Moment in(Timezone timezone) {
        if (timezone.isFixed()) {
            return at(timezone.getOffset(this.date, this.time));
        }
        TransitionStrategy strategy = timezone.getStrategy();
        long jResolve = strategy.resolve(this.date, this.time, timezone);
        Moment momentOf = Moment.of(jResolve, this.time.getNanosecond(), TimeScale.POSIX);
        if (strategy == Timezone.STRICT_MODE) {
            Moment.checkNegativeLS(jResolve, this);
        }
        return momentOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public TimeAxis getChronology() {
        return ENGINE;
    }

    static PlainTimestamp from(UnixTime unixTime, ZonalOffset zonalOffset) {
        long posixTime = unixTime.getPosixTime() + ((long) zonalOffset.getIntegralAmount());
        int nanosecond = unixTime.getNanosecond() + zonalOffset.getFractionalAmount();
        if (nanosecond < 0) {
            nanosecond += Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            posixTime--;
        } else if (nanosecond >= 1000000000) {
            nanosecond -= Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
            posixTime++;
        }
        PlainDate plainDateOf = PlainDate.of(MathUtils.floorDivide(posixTime, SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UNIX);
        int iFloorModulo = MathUtils.floorModulo(posixTime, SyncConfiguration.DEFAULT_FREQUENCY);
        int i = iFloorModulo % 60;
        int i2 = iFloorModulo / 60;
        return of(plainDateOf, PlainTime.of(i2 / 60, i2 % 60, i, nanosecond));
    }

    private static void registerCalendarUnits(TimeAxis.Builder builder) {
        EnumSet enumSetRange = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet enumSetRange2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        CalendarUnit[] calendarUnitArrValues = CalendarUnit.values();
        int length = calendarUnitArrValues.length;
        int i = 0;
        while (i < length) {
            CalendarUnit calendarUnit = calendarUnitArrValues[i];
            TimeAxis.Builder builder2 = builder;
            builder2.appendUnit(calendarUnit, new CompositeUnitRule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? enumSetRange : enumSetRange2);
            i++;
            builder = builder2;
        }
    }

    private static void registerClockUnits(TimeAxis.Builder builder) {
        for (ClockUnit clockUnit : ClockUnit.values()) {
            builder.appendUnit(clockUnit, new CompositeUnitRule(clockUnit), clockUnit.getLength(), EnumSet.allOf(ClockUnit.class));
        }
    }

    private static void registerExtensions(TimeAxis.Builder builder) {
        Iterator it = PlainDate.axis().getExtensions().iterator();
        while (it.hasNext()) {
            builder.appendExtension((ChronoExtension) it.next());
        }
        Iterator it2 = PlainTime.axis().getExtensions().iterator();
        while (it2.hasNext()) {
            builder.appendExtension((ChronoExtension) it2.next());
        }
    }

    private Object writeReplace() {
        return new SPX(this, 8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Merger implements ChronoMerger {
        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(PlainTimestamp plainTimestamp, AttributeQuery attributeQuery) {
            return plainTimestamp;
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology preparser() {
            return null;
        }

        /* synthetic */ Merger(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            DisplayMode displayModeOfStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
            return CalendarText.patternForTimestamp(displayModeOfStyle, displayModeOfStyle, locale);
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        @Override // net.time4j.engine.ChronoMerger
        public PlainTimestamp createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            PlainDate plainDate;
            PlainTime plainTime;
            TZID tzid;
            if (chronoEntity instanceof UnixTime) {
                AttributeKey attributeKey = Attributes.TIMEZONE_ID;
                if (attributeQuery.contains(attributeKey)) {
                    tzid = (TZID) attributeQuery.get(attributeKey);
                } else if (z) {
                    tzid = ZonalOffset.UTC;
                } else {
                    throw new IllegalArgumentException("Missing timezone attribute for type conversion.");
                }
                return Moment.from((UnixTime) UnixTime.class.cast(chronoEntity)).toZonalTimestamp(tzid);
            }
            boolean z3 = z2 && chronoEntity.getInt(PlainTime.SECOND_OF_MINUTE) == 60;
            if (z3) {
                chronoEntity.with((ChronoElement) PlainTime.SECOND_OF_MINUTE, 59);
            }
            ChronoElement chronoElement = PlainDate.CALENDAR_DATE;
            if (chronoEntity.contains(chronoElement)) {
                plainDate = (PlainDate) chronoEntity.get(chronoElement);
            } else {
                plainDate = (PlainDate) PlainDate.axis().createFrom(chronoEntity, attributeQuery, z, false);
            }
            if (plainDate == null) {
                return null;
            }
            ChronoElement chronoElement2 = PlainTime.WALL_TIME;
            if (chronoEntity.contains(chronoElement2)) {
                plainTime = (PlainTime) chronoEntity.get(chronoElement2);
            } else {
                plainTime = (PlainTime) PlainTime.axis().createFrom(chronoEntity, attributeQuery, z, false);
                if (plainTime == null && z) {
                    plainTime = PlainTime.MIN;
                }
            }
            if (plainTime == null) {
                return null;
            }
            ChronoElement chronoElement3 = LongElement.DAY_OVERFLOW;
            if (chronoEntity.contains(chronoElement3)) {
                plainDate = (PlainDate) plainDate.plus(((Long) chronoEntity.get(chronoElement3)).longValue(), CalendarUnit.DAYS);
            }
            if (z3) {
                FlagElement flagElement = FlagElement.LEAP_SECOND;
                Boolean bool = Boolean.TRUE;
                if (chronoEntity.isValid(flagElement, bool)) {
                    chronoEntity.with(flagElement, bool);
                }
            }
            return PlainTimestamp.of(plainDate, plainTime);
        }
    }

    private static class FieldRule implements ElementRule {
        private final ChronoElement element;

        /* synthetic */ FieldRule(ChronoElement chronoElement, AnonymousClass1 anonymousClass1) {
            this(chronoElement);
        }

        private FieldRule(ChronoElement chronoElement) {
            this.element = chronoElement;
        }

        static FieldRule of(ChronoElement chronoElement) {
            return new FieldRule(chronoElement);
        }

        @Override // net.time4j.engine.ElementRule
        public Object getValue(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.get(this.element);
            }
            if (this.element.isTimeElement()) {
                return plainTimestamp.time.get(this.element);
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public Object getMinimum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.getMinimum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMinimum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public Object getMaximum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.getMaximum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMaximum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTimestamp plainTimestamp, Object obj) {
            if (obj == null) {
                return false;
            }
            if (this.element.isDateElement()) {
                return plainTimestamp.date.isValid(this.element, obj);
            }
            if (this.element.isTimeElement()) {
                if (Number.class.isAssignableFrom(this.element.getType())) {
                    long number = toNumber(this.element.getDefaultMinimum());
                    long number2 = toNumber(this.element.getDefaultMaximum());
                    long number3 = toNumber(obj);
                    return number <= number3 && number2 >= number3;
                }
                if (this.element.equals(PlainTime.WALL_TIME) && PlainTime.MAX.equals(obj)) {
                    return false;
                }
                return plainTimestamp.time.isValid(this.element, obj);
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTimestamp withValue(PlainTimestamp plainTimestamp, Object obj, boolean z) {
            if (obj == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            if (obj.equals(getValue(plainTimestamp))) {
                return plainTimestamp;
            }
            if (z) {
                return (PlainTimestamp) plainTimestamp.plus(MathUtils.safeSubtract(toNumber(obj), toNumber(getValue(plainTimestamp))), (IsoUnit) PlainTimestamp.ENGINE.getBaseUnit(this.element));
            }
            if (this.element.isDateElement()) {
                return PlainTimestamp.of((PlainDate) plainTimestamp.date.with(this.element, obj), plainTimestamp.time);
            }
            if (this.element.isTimeElement()) {
                if (Number.class.isAssignableFrom(this.element.getType())) {
                    long number = toNumber(this.element.getDefaultMinimum());
                    long number2 = toNumber(this.element.getDefaultMaximum());
                    long number3 = toNumber(obj);
                    if (number > number3 || number2 < number3) {
                        throw new IllegalArgumentException("Out of range: " + obj);
                    }
                } else if (this.element.equals(PlainTime.WALL_TIME) && obj.equals(PlainTime.MAX)) {
                    throw new IllegalArgumentException("Out of range: " + obj);
                }
                return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with(this.element, obj));
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        private long toNumber(Object obj) {
            return ((Number) Number.class.cast(obj)).longValue();
        }
    }

    private static class DecimalRule extends FieldRule {
        DecimalRule(ChronoElement chronoElement) {
            super(chronoElement, null);
        }

        @Override // net.time4j.PlainTimestamp.FieldRule
        public boolean isValid(PlainTimestamp plainTimestamp, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                return false;
            }
            return ((BigDecimal) ((FieldRule) this).element.getDefaultMinimum()).compareTo(bigDecimal) <= 0 && bigDecimal.compareTo((BigDecimal) ((FieldRule) this).element.getDefaultMaximum()) <= 0;
        }

        @Override // net.time4j.PlainTimestamp.FieldRule
        public PlainTimestamp withValue(PlainTimestamp plainTimestamp, BigDecimal bigDecimal, boolean z) {
            if (isValid(plainTimestamp, bigDecimal)) {
                return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with(((FieldRule) this).element, bigDecimal));
            }
            throw new IllegalArgumentException("Out of range: " + bigDecimal);
        }
    }

    private static class CompositeUnitRule implements UnitRule {
        private final CalendarUnit calendarUnit;
        private final ClockUnit clockUnit;

        CompositeUnitRule(CalendarUnit calendarUnit) {
            this.calendarUnit = calendarUnit;
            this.clockUnit = null;
        }

        CompositeUnitRule(ClockUnit clockUnit) {
            this.calendarUnit = null;
            this.clockUnit = clockUnit;
        }

        @Override // net.time4j.engine.UnitRule
        public PlainTimestamp addTo(PlainTimestamp plainTimestamp, long j) {
            PlainDate plainDate;
            PlainTime plainTime;
            if (this.calendarUnit != null) {
                plainDate = (PlainDate) plainTimestamp.date.plus(j, this.calendarUnit);
                plainTime = plainTimestamp.time;
            } else {
                DayCycles dayCyclesRoll = plainTimestamp.time.roll(j, this.clockUnit);
                PlainDate plainDate2 = (PlainDate) plainTimestamp.date.plus(dayCyclesRoll.getDayOverflow(), CalendarUnit.DAYS);
                PlainTime wallTime = dayCyclesRoll.getWallTime();
                plainDate = plainDate2;
                plainTime = wallTime;
            }
            return PlainTimestamp.of(plainDate, plainTime);
        }

        @Override // net.time4j.engine.UnitRule
        public long between(PlainTimestamp plainTimestamp, PlainTimestamp plainTimestamp2) {
            long jSafeAdd;
            CalendarUnit calendarUnit = this.calendarUnit;
            if (calendarUnit != null) {
                long jBetween = calendarUnit.between(plainTimestamp.date, plainTimestamp2.date);
                if (jBetween == 0) {
                    return jBetween;
                }
                if (this.calendarUnit != CalendarUnit.DAYS && ((PlainDate) plainTimestamp.date.plus(jBetween, this.calendarUnit)).compareByTime(plainTimestamp2.date) != 0) {
                    return jBetween;
                }
                PlainTime plainTime = plainTimestamp.time;
                PlainTime plainTime2 = plainTimestamp2.time;
                if (jBetween <= 0 || !plainTime.isAfter(plainTime2)) {
                    return (jBetween >= 0 || !plainTime.isBefore(plainTime2)) ? jBetween : jBetween + 1;
                }
                return jBetween - 1;
            }
            if (!plainTimestamp.date.isAfter(plainTimestamp2.date)) {
                long jUntil = plainTimestamp.date.until(plainTimestamp2.date, CalendarUnit.DAYS);
                if (jUntil == 0) {
                    return this.clockUnit.between(plainTimestamp.time, plainTimestamp2.time);
                }
                if (this.clockUnit.compareTo(ClockUnit.SECONDS) <= 0) {
                    long jSafeMultiply = MathUtils.safeMultiply(jUntil, 86400L);
                    PlainTime plainTime3 = plainTimestamp2.time;
                    ProportionalElement proportionalElement = PlainTime.SECOND_OF_DAY;
                    jSafeAdd = MathUtils.safeAdd(jSafeMultiply, MathUtils.safeSubtract(((Integer) plainTime3.get(proportionalElement)).longValue(), ((Integer) plainTimestamp.time.get(proportionalElement)).longValue()));
                    if (plainTimestamp.time.getNanosecond() > plainTimestamp2.time.getNanosecond()) {
                        jSafeAdd--;
                    }
                } else {
                    long jSafeMultiply2 = MathUtils.safeMultiply(jUntil, 86400000000000L);
                    PlainTime plainTime4 = plainTimestamp2.time;
                    ProportionalElement proportionalElement2 = PlainTime.NANO_OF_DAY;
                    jSafeAdd = MathUtils.safeAdd(jSafeMultiply2, MathUtils.safeSubtract(((Long) plainTime4.get(proportionalElement2)).longValue(), ((Long) plainTimestamp.time.get(proportionalElement2)).longValue()));
                }
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.clockUnit.ordinal()]) {
                    case 1:
                        return jSafeAdd / 3600;
                    case 2:
                        return jSafeAdd / 60;
                    case 3:
                    case 6:
                        return jSafeAdd;
                    case 4:
                        return jSafeAdd / 1000000;
                    case 5:
                        return jSafeAdd / 1000;
                    default:
                        throw new UnsupportedOperationException(this.clockUnit.name());
                }
            }
            return -between(plainTimestamp2, plainTimestamp);
        }
    }

    /* JADX INFO: renamed from: net.time4j.PlainTimestamp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

        static {
            int[] iArr = new int[ClockUnit.values().length];
            $SwitchMap$net$time4j$ClockUnit = iArr;
            try {
                iArr[ClockUnit.HOURS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MINUTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.SECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MILLIS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.MICROS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$ClockUnit[ClockUnit.NANOS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
