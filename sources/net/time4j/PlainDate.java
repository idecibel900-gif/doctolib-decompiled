package net.time4j;

import com.facebook.imageutils.TiffUtil;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
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
import net.time4j.engine.IntElementRule;
import net.time4j.engine.Normalizer;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
public final class PlainDate extends Calendrical implements GregorianDate, Normalizer, LocalizedPatternSupport {
    static final ChronoElement CALENDAR_DATE;
    public static final CalendarDateElement COMPONENT;
    public static final ProportionalElement DAY_OF_MONTH;
    public static final ProportionalElement DAY_OF_QUARTER;
    public static final NavigableElement DAY_OF_WEEK;
    public static final ProportionalElement DAY_OF_YEAR;
    private static final Map ELEMENTS;
    private static final TimeAxis ENGINE;
    public static final ProportionalElement MONTH_AS_NUMBER;
    public static final NavigableElement MONTH_OF_YEAR;
    public static final NavigableElement QUARTER_OF_YEAR;
    private static final CalendarSystem TRANSFORMER;
    public static final OrdinalWeekdayElement WEEKDAY_IN_MONTH;
    public static final AdjustableElement YEAR;
    public static final AdjustableElement YEAR_OF_WEEKDATE;
    private static final long serialVersionUID = -6698431452072325688L;
    private final transient byte dayOfMonth;
    private final transient byte month;
    private final transient int year;
    static final PlainDate MIN = new PlainDate(-999999999, 1, 1);
    static final PlainDate MAX = new PlainDate(999999999, 12, 31);
    static final Integer MIN_YEAR = -999999999;
    static final Integer MAX_YEAR = 999999999;
    private static final Integer VALUE_1 = 1;
    private static final Integer VALUE_12 = 12;
    private static final Integer STD_YEAR_LEN = 365;
    private static final Integer LEAP_YEAR_LEN = 366;
    private static final int[] DAY_OF_YEAR_PER_MONTH = {31, 59, 90, 120, 151, 181, 212, 243, 273, RCHTTPStatusCodes.NOT_MODIFIED, 334, 365};
    private static final int[] DAY_OF_LEAP_YEAR_PER_MONTH = {31, 60, 91, 121, 152, 182, 213, 244, TiffUtil.TIFF_TAG_ORIENTATION, 305, 335, 366};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public PlainDate getContext() {
        return this;
    }

    static {
        DateElement dateElement = DateElement.INSTANCE;
        CALENDAR_DATE = dateElement;
        COMPONENT = dateElement;
        IntegerDateElement integerDateElementCreate = IntegerDateElement.create("YEAR", 14, -999999999, 999999999, 'u');
        YEAR = integerDateElementCreate;
        YOWElement yOWElement = YOWElement.INSTANCE;
        YEAR_OF_WEEKDATE = yOWElement;
        EnumElement enumElement = new EnumElement("QUARTER_OF_YEAR", Quarter.class, Quarter.Q1, Quarter.Q4, 103, 'Q');
        QUARTER_OF_YEAR = enumElement;
        EnumElement enumElement2 = new EnumElement("MONTH_OF_YEAR", Month.class, Month.JANUARY, Month.DECEMBER, 101, 'M');
        MONTH_OF_YEAR = enumElement2;
        IntegerDateElement integerDateElementCreate2 = IntegerDateElement.create("MONTH_AS_NUMBER", 15, 1, 12, 'M');
        MONTH_AS_NUMBER = integerDateElementCreate2;
        IntegerDateElement integerDateElementCreate3 = IntegerDateElement.create("DAY_OF_MONTH", 16, 1, 31, 'd');
        DAY_OF_MONTH = integerDateElementCreate3;
        EnumElement enumElement3 = new EnumElement("DAY_OF_WEEK", Weekday.class, Weekday.MONDAY, Weekday.SUNDAY, 102, 'E');
        DAY_OF_WEEK = enumElement3;
        IntegerDateElement integerDateElementCreate4 = IntegerDateElement.create("DAY_OF_YEAR", 17, 1, 365, 'D');
        DAY_OF_YEAR = integerDateElementCreate4;
        IntegerDateElement integerDateElementCreate5 = IntegerDateElement.create("DAY_OF_QUARTER", 18, 1, 92, (char) 0);
        DAY_OF_QUARTER = integerDateElementCreate5;
        WeekdayInMonthElement weekdayInMonthElement = WeekdayInMonthElement.INSTANCE;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        HashMap map = new HashMap();
        fill(map, dateElement);
        fill(map, integerDateElementCreate);
        fill(map, yOWElement);
        fill(map, enumElement);
        fill(map, enumElement2);
        fill(map, integerDateElementCreate2);
        fill(map, integerDateElementCreate3);
        fill(map, enumElement3);
        fill(map, integerDateElementCreate4);
        fill(map, integerDateElementCreate5);
        fill(map, weekdayInMonthElement);
        ELEMENTS = Collections.unmodifiableMap(map);
        AnonymousClass1 anonymousClass1 = null;
        Transformer transformer = new Transformer(anonymousClass1);
        TRANSFORMER = transformer;
        TimeAxis.Builder up = TimeAxis.Builder.setUp(IsoDateUnit.class, PlainDate.class, new Merger(anonymousClass1), transformer);
        DateElementRule dateElementRule = new DateElementRule(anonymousClass1);
        CalendarUnit calendarUnit = CalendarUnit.DAYS;
        TimeAxis.Builder builderAppendElement = up.appendElement(dateElement, dateElementRule, calendarUnit).appendElement(integerDateElementCreate, new IntegerElementRule(integerDateElementCreate), CalendarUnit.YEARS).appendElement(yOWElement, YOWElement.elementRule(PlainDate.class), Weekcycle.YEARS).appendElement(enumElement, EnumElementRule.of(enumElement), CalendarUnit.QUARTERS);
        EnumElementRule enumElementRuleOf = EnumElementRule.of(enumElement2);
        CalendarUnit calendarUnit2 = CalendarUnit.MONTHS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(enumElement2, enumElementRuleOf, calendarUnit2).appendElement(integerDateElementCreate2, new IntegerElementRule(integerDateElementCreate2), calendarUnit2).appendElement(integerDateElementCreate3, new IntegerElementRule(integerDateElementCreate3), calendarUnit).appendElement(enumElement3, EnumElementRule.of(enumElement3), calendarUnit).appendElement(integerDateElementCreate4, new IntegerElementRule(integerDateElementCreate4), calendarUnit).appendElement(integerDateElementCreate5, new IntegerElementRule(integerDateElementCreate5), calendarUnit).appendElement(weekdayInMonthElement, new IntegerElementRule(19, weekdayInMonthElement), CalendarUnit.WEEKS);
        registerUnits(builderAppendElement2);
        registerExtensions(builderAppendElement2);
        ENGINE = builderAppendElement2.build();
    }

    private PlainDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (byte) i2;
        this.dayOfMonth = (byte) i3;
    }

    public static PlainDate of(int i, int i2, int i3) {
        return of(i, i2, i3, true);
    }

    public static PlainDate of(int i, Month month, int i2) {
        return of(i, month.getValue(), i2, true);
    }

    public static PlainDate of(int i, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("Day of year out of range: " + i2);
        }
        if (i2 <= 31) {
            return of(i, 1, i2);
        }
        int[] iArr = GregorianMath.isLeapYear(i) ? DAY_OF_LEAP_YEAR_PER_MONTH : DAY_OF_YEAR_PER_MONTH;
        for (int i3 = i2 > iArr[6] ? 7 : 1; i3 < 12; i3++) {
            if (i2 <= iArr[i3]) {
                return of(i, i3 + 1, i2 - iArr[i3 - 1], false);
            }
        }
        throw new IllegalArgumentException("Day of year out of range: " + i2);
    }

    public static PlainDate of(int i, int i2, Weekday weekday) {
        return of(i, i2, weekday, true);
    }

    public static PlainDate of(long j, EpochDays epochDays) {
        return (PlainDate) TRANSFORMER.transform(EpochDays.UTC.transform(j, epochDays));
    }

    public static PlainDate from(GregorianDate gregorianDate) {
        if (gregorianDate instanceof PlainDate) {
            return (PlainDate) gregorianDate;
        }
        return of(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth());
    }

    public PlainTimestamp atStartOfDay() {
        return at(PlainTime.MIN);
    }

    public PlainTimestamp at(PlainTime plainTime) {
        return PlainTimestamp.of(this, plainTime);
    }

    public PlainTimestamp atTime(int i, int i2, int i3) {
        return at(PlainTime.of(i, i2, i3));
    }

    @Override // net.time4j.base.GregorianDate
    public int getYear() {
        return this.year;
    }

    @Override // net.time4j.base.GregorianDate
    public int getMonth() {
        return this.month;
    }

    @Override // net.time4j.base.GregorianDate
    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(GregorianMath.getDayOfWeek(this.year, this.month, this.dayOfMonth));
    }

    public int getDayOfYear() {
        byte b = this.month;
        if (b == 1) {
            return this.dayOfMonth;
        }
        if (b == 2) {
            return this.dayOfMonth + 31;
        }
        return DAY_OF_YEAR_PER_MONTH[b - 2] + this.dayOfMonth + (GregorianMath.isLeapYear(this.year) ? 1 : 0);
    }

    public int lengthOfMonth() {
        return GregorianMath.getLengthOfMonth(this.year, this.month);
    }

    @Override // net.time4j.engine.Calendrical
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlainDate) {
            PlainDate plainDate = (PlainDate) obj;
            if (this.dayOfMonth == plainDate.dayOfMonth && this.month == plainDate.month && this.year == plainDate.year) {
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.engine.Calendrical
    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.dayOfMonth) ^ (i & (-2048));
    }

    @Override // net.time4j.base.GregorianDate
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        formatYear(sb, this.year);
        format2Digits(sb, this.month);
        format2Digits(sb, this.dayOfMonth);
        return sb.toString();
    }

    public static TimeAxis axis() {
        return ENGINE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public TimeAxis getChronology() {
        return ENGINE;
    }

    @Override // net.time4j.engine.Calendrical
    protected int compareByTime(CalendarDate calendarDate) {
        if (calendarDate instanceof PlainDate) {
            PlainDate plainDate = (PlainDate) calendarDate;
            int i = this.year - plainDate.year;
            if (i != 0) {
                return i;
            }
            int i2 = this.month - plainDate.month;
            return i2 == 0 ? this.dayOfMonth - plainDate.dayOfMonth : i2;
        }
        return super.compareByTime(calendarDate);
    }

    long getDaysSinceUTC() {
        return TRANSFORMER.transform(this);
    }

    PlainDate withDaysSinceUTC(long j) {
        return (PlainDate) TRANSFORMER.transform(j);
    }

    static Object lookupElement(String str) {
        return ELEMENTS.get(str);
    }

    static PlainDate doAdd(CalendarUnit calendarUnit, PlainDate plainDate, long j, int i) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit[calendarUnit.ordinal()]) {
            case 1:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 12000L), i);
            case 2:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 1200L), i);
            case 3:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 120L), i);
            case 4:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 12L), i);
            case 5:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 3L), i);
            case 6:
                return fromEpochMonths(plainDate, MathUtils.safeAdd(plainDate.getEpochMonths(), j), plainDate.dayOfMonth, i);
            case 7:
                return doAdd(CalendarUnit.DAYS, plainDate, MathUtils.safeMultiply(j, 7L), i);
            case 8:
                return addDays(plainDate, j);
            default:
                throw new UnsupportedOperationException(calendarUnit.name());
        }
    }

    long getEpochMonths() {
        return ((((long) (this.year - 1970)) * 12) + ((long) this.month)) - 1;
    }

    int getWeekOfYear() {
        return ((Integer) get(Weekmodel.ISO.weekOfYear())).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getDayOfQuarter() {
        switch (this.month) {
            case 1:
            case 4:
            case 7:
            case 10:
                return this.dayOfMonth;
            case 2:
            case 8:
            case BaseVideoCapturer.RGBA /* 11 */:
                return this.dayOfMonth + 31;
            case 3:
                return (GregorianMath.isLeapYear(this.year) ? (byte) 60 : (byte) 59) + this.dayOfMonth;
            case 5:
                return this.dayOfMonth + 30;
            case 6:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return this.dayOfMonth + 61;
            case 9:
                return this.dayOfMonth + 62;
            default:
                throw new AssertionError("Unknown month: " + ((int) this.month));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        return of(i, this.month, Math.min(GregorianMath.getLengthOfMonth(i, this.month), (int) this.dayOfMonth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate withMonth(int i) {
        if (this.month == i) {
            return this;
        }
        return of(this.year, i, Math.min(GregorianMath.getLengthOfMonth(this.year, i), (int) this.dayOfMonth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate withDayOfMonth(int i) {
        return this.dayOfMonth == i ? this : of(this.year, this.month, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate withDayOfWeek(Weekday weekday) {
        Weekday dayOfWeek = getDayOfWeek();
        return dayOfWeek == weekday ? this : (PlainDate) TRANSFORMER.transform(MathUtils.safeAdd(getDaysSinceUTC(), weekday.getValue() - dayOfWeek.getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate withDayOfYear(int i) {
        return getDayOfYear() == i ? this : of(this.year, i);
    }

    private static PlainDate fromEpochMonths(PlainDate plainDate, long j, int i, int i2) {
        if (i2 == 5 && plainDate.dayOfMonth == plainDate.lengthOfMonth()) {
            i2 = 2;
        }
        int iSafeCast = MathUtils.safeCast(MathUtils.safeAdd(MathUtils.floorDivide(j, 12), 1970L));
        int iFloorModulo = MathUtils.floorModulo(j, 12) + 1;
        int lengthOfMonth = GregorianMath.getLengthOfMonth(iSafeCast, iFloorModulo);
        if (i > lengthOfMonth) {
            switch (i2) {
                case 0:
                case 2:
                case 5:
                case 6:
                    break;
                case 1:
                    return fromEpochMonths(plainDate, MathUtils.safeAdd(j, 1L), 1, i2);
                case 3:
                    return fromEpochMonths(plainDate, MathUtils.safeAdd(j, 1L), i - lengthOfMonth, i2);
                case 4:
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Day of month out of range: ");
                    formatYear(sb, iSafeCast);
                    format2Digits(sb, iFloorModulo);
                    format2Digits(sb, i);
                    throw new ChronoException(sb.toString());
                default:
                    throw new UnsupportedOperationException("Overflow policy not implemented: " + i2);
            }
            return of(iSafeCast, iFloorModulo, i);
        }
        if (i < lengthOfMonth && i2 == 2) {
        }
        return of(iSafeCast, iFloorModulo, i);
        i = lengthOfMonth;
        return of(iSafeCast, iFloorModulo, i);
    }

    private static PlainDate addDays(PlainDate plainDate, long j) {
        long jSafeAdd = MathUtils.safeAdd(plainDate.dayOfMonth, j);
        if (jSafeAdd >= 1 && jSafeAdd <= 28) {
            return of(plainDate.year, plainDate.month, (int) jSafeAdd);
        }
        long jSafeAdd2 = MathUtils.safeAdd(plainDate.getDayOfYear(), j);
        if (jSafeAdd2 >= 1 && jSafeAdd2 <= 365) {
            return of(plainDate.year, (int) jSafeAdd2);
        }
        return (PlainDate) TRANSFORMER.transform(MathUtils.safeAdd(plainDate.getDaysSinceUTC(), j));
    }

    private static void fill(Map map, ChronoElement chronoElement) {
        map.put(chronoElement.name(), chronoElement);
    }

    private static void formatYear(StringBuilder sb, int i) {
        int iSafeNegate;
        if (i < 0) {
            sb.append('-');
            iSafeNegate = MathUtils.safeNegate(i);
        } else {
            iSafeNegate = i;
        }
        if (iSafeNegate >= 10000) {
            if (i > 0) {
                sb.append('+');
            }
        } else if (iSafeNegate < 1000) {
            sb.append('0');
            if (iSafeNegate < 100) {
                sb.append('0');
                if (iSafeNegate < 10) {
                    sb.append('0');
                }
            }
        }
        sb.append(iSafeNegate);
    }

    private static void format2Digits(StringBuilder sb, int i) {
        sb.append('-');
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private static void registerExtensions(TimeAxis.Builder builder) {
        for (ChronoExtension chronoExtension : ResourceLoader.getInstance().services(ChronoExtension.class)) {
            if (chronoExtension.accept(PlainDate.class)) {
                builder.appendExtension(chronoExtension);
            }
        }
        builder.appendExtension((ChronoExtension) new WeekExtension());
    }

    private static void registerUnits(TimeAxis.Builder builder) {
        EnumSet enumSetRange = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet enumSetRange2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        CalendarUnit[] calendarUnitArrValues = CalendarUnit.values();
        int length = calendarUnitArrValues.length;
        int i = 0;
        while (i < length) {
            CalendarUnit calendarUnit = calendarUnitArrValues[i];
            TimeAxis.Builder builder2 = builder;
            builder2.appendUnit(calendarUnit, new CalendarUnit.Rule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? enumSetRange : enumSetRange2);
            i++;
            builder = builder2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainDate of(int i, int i2, Weekday weekday, boolean z) {
        if (i2 < 1 || i2 > 53) {
            if (z) {
                throw new IllegalArgumentException(woyFailed(i2));
            }
            return null;
        }
        if (z && (i < MIN_YEAR.intValue() || i > MAX_YEAR.intValue())) {
            throw new IllegalArgumentException(yowFailed(i));
        }
        int value = Weekday.valueOf(GregorianMath.getDayOfWeek(i, 1, 1)).getValue();
        int value2 = (((value <= 4 ? 2 - value : 9 - value) + ((i2 - 1) * 7)) + weekday.getValue()) - 1;
        if (value2 <= 0) {
            i--;
            value2 += GregorianMath.isLeapYear(i) ? 366 : 365;
        } else {
            int i3 = GregorianMath.isLeapYear(i) ? 366 : 365;
            if (value2 > i3) {
                value2 -= i3;
                i++;
            }
        }
        PlainDate plainDateOf = of(i, value2);
        if (i2 != 53 || plainDateOf.getWeekOfYear() == 53) {
            return plainDateOf;
        }
        if (z) {
            throw new IllegalArgumentException(woyFailed(i2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String yowFailed(int i) {
        return "YEAR_OF_WEEKDATE (ISO) out of range: " + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String woyFailed(int i) {
        return "WEEK_OF_YEAR (ISO) out of range: " + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainDate of(int i, int i2, int i3, boolean z) {
        if (z) {
            GregorianMath.checkDate(i, i2, i3);
        }
        return new PlainDate(i, i2, i3);
    }

    private Object writeReplace() {
        return new SPX(this, 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Merger implements ChronoMerger {
        private static final int DEFAULT_PIVOT_YEAR = GregorianMath.readYear(GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(MathUtils.floorDivide(System.currentTimeMillis(), 86400000), EpochDays.UNIX))) + 20;

        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(PlainDate plainDate, AttributeQuery attributeQuery) {
            return plainDate;
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
            return CalendarText.patternForDate(DisplayMode.ofStyle(displayStyle.getStyleValue()), locale);
        }

        @Override // net.time4j.engine.ChronoMerger
        public PlainDate createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            Weekday weekday;
            ProportionalElement proportionalElement;
            int i;
            ChronoElement chronoElement = PlainDate.CALENDAR_DATE;
            if (chronoEntity.contains(chronoElement)) {
                return (PlainDate) chronoEntity.get(chronoElement);
            }
            int i2 = chronoEntity.getInt(PlainDate.YEAR);
            if (i2 != Integer.MIN_VALUE) {
                ProportionalElement proportionalElement2 = PlainDate.MONTH_AS_NUMBER;
                int value = chronoEntity.getInt(proportionalElement2);
                if (value == Integer.MIN_VALUE) {
                    ChronoElement chronoElement2 = PlainDate.MONTH_OF_YEAR;
                    if (chronoEntity.contains(chronoElement2)) {
                        value = ((Month) chronoEntity.get(chronoElement2)).getValue();
                    }
                }
                if (value != Integer.MIN_VALUE && (i = chronoEntity.getInt((proportionalElement = PlainDate.DAY_OF_MONTH))) != Integer.MIN_VALUE) {
                    if (z) {
                        return (PlainDate) ((PlainDate) PlainDate.of(i2, 1, 1).with(proportionalElement2.setLenient(Integer.valueOf(value)))).with(proportionalElement.setLenient(Integer.valueOf(i)));
                    }
                    if (validateYear(chronoEntity, i2) && validateMonth(chronoEntity, value) && validateDayOfMonth(chronoEntity, i2, value, i)) {
                        return PlainDate.of(i2, value, i, false);
                    }
                    return null;
                }
                ProportionalElement proportionalElement3 = PlainDate.DAY_OF_YEAR;
                int i3 = chronoEntity.getInt(proportionalElement3);
                if (i3 != Integer.MIN_VALUE) {
                    if (z) {
                        return (PlainDate) PlainDate.of(i2, 1).with(proportionalElement3.setLenient(Integer.valueOf(i3)));
                    }
                    if (validateYear(chronoEntity, i2) && validateDayOfYear(chronoEntity, i2, i3)) {
                        return PlainDate.of(i2, i3);
                    }
                    return null;
                }
                int i4 = chronoEntity.getInt(PlainDate.DAY_OF_QUARTER);
                if (i4 != Integer.MIN_VALUE) {
                    ChronoElement chronoElement3 = PlainDate.QUARTER_OF_YEAR;
                    if (chronoEntity.contains(chronoElement3)) {
                        Quarter quarter = (Quarter) chronoEntity.get(chronoElement3);
                        boolean zIsLeapYear = GregorianMath.isLeapYear(i2);
                        int i5 = (zIsLeapYear ? 91 : 90) + i4;
                        if (quarter == Quarter.Q1) {
                            i5 = i4;
                        } else if (quarter == Quarter.Q3) {
                            i5 += 91;
                        } else if (quarter == Quarter.Q4) {
                            i5 += 183;
                        }
                        if (z) {
                            return (PlainDate) PlainDate.of(i2, 1).with(proportionalElement3.setLenient(Integer.valueOf(i5)));
                        }
                        if (validateYear(chronoEntity, i2) && validateDayOfQuarter(chronoEntity, zIsLeapYear, quarter, i4)) {
                            return PlainDate.of(i2, i5);
                        }
                        return null;
                    }
                }
            }
            int i6 = chronoEntity.getInt(PlainDate.YEAR_OF_WEEKDATE);
            if (i6 != Integer.MIN_VALUE) {
                Weekmodel weekmodel = Weekmodel.ISO;
                if (chronoEntity.contains(weekmodel.weekOfYear())) {
                    int iIntValue = ((Integer) chronoEntity.get(weekmodel.weekOfYear())).intValue();
                    ChronoElement chronoElement4 = PlainDate.DAY_OF_WEEK;
                    if (chronoEntity.contains(chronoElement4)) {
                        weekday = (Weekday) chronoEntity.get(chronoElement4);
                    } else {
                        if (chronoEntity.contains(weekmodel.localDayOfWeek())) {
                            weekday = (Weekday) chronoEntity.get(weekmodel.localDayOfWeek());
                        }
                        return null;
                    }
                    if (i6 >= -999999999 && i6 <= 999999999) {
                        PlainDate plainDateOf = PlainDate.of(i6, iIntValue, weekday, false);
                        if (plainDateOf == null) {
                            flagValidationError(chronoEntity, PlainDate.woyFailed(iIntValue));
                        }
                        return plainDateOf;
                    }
                    flagValidationError(chronoEntity, PlainDate.yowFailed(i6));
                    return null;
                }
            }
            EpochDays epochDays = EpochDays.MODIFIED_JULIAN_DATE;
            if (chronoEntity.contains(epochDays)) {
                return (PlainDate) PlainDate.TRANSFORMER.transform(EpochDays.UTC.transform(((Long) chronoEntity.get(epochDays)).longValue(), epochDays));
            }
            if (chronoEntity instanceof UnixTime) {
                return ((PlainTimestamp) PlainTimestamp.axis().createFrom(chronoEntity, attributeQuery, z, z2)).getCalendarDate();
            }
            return null;
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return DEFAULT_PIVOT_YEAR;
        }

        private static boolean validateYear(ChronoEntity chronoEntity, int i) {
            if (i >= -999999999 && i <= 999999999) {
                return true;
            }
            flagValidationError(chronoEntity, "YEAR out of range: " + i);
            return false;
        }

        private static boolean validateMonth(ChronoEntity chronoEntity, int i) {
            if (i >= 1 && i <= 12) {
                return true;
            }
            flagValidationError(chronoEntity, "MONTH_OF_YEAR out of range: " + i);
            return false;
        }

        private static boolean validateDayOfMonth(ChronoEntity chronoEntity, int i, int i2, int i3) {
            if (i3 >= 1 && (i3 <= 28 || i3 <= GregorianMath.getLengthOfMonth(i, i2))) {
                return true;
            }
            flagValidationError(chronoEntity, "DAY_OF_MONTH out of range: " + i3);
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        
            if (r4 > (net.time4j.base.GregorianMath.isLeapYear(r3) ? 366 : 365)) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static boolean validateDayOfYear(net.time4j.engine.ChronoEntity r2, int r3, int r4) {
            /*
                r0 = 1
                if (r4 < r0) goto L13
                r1 = 365(0x16d, float:5.11E-43)
                if (r4 <= r1) goto L12
                boolean r3 = net.time4j.base.GregorianMath.isLeapYear(r3)
                if (r3 == 0) goto Lf
                r1 = 366(0x16e, float:5.13E-43)
            Lf:
                if (r4 <= r1) goto L12
                goto L13
            L12:
                return r0
            L13:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "DAY_OF_YEAR out of range: "
                r3.append(r0)
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                flagValidationError(r2, r3)
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainDate.Merger.validateDayOfYear(net.time4j.engine.ChronoEntity, int, int):boolean");
        }

        private static boolean validateDayOfQuarter(ChronoEntity chronoEntity, boolean z, Quarter quarter, int i) {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$Quarter[quarter.ordinal()];
            int i3 = 91;
            if (i2 != 1) {
                if (i2 != 2) {
                    i3 = 92;
                }
            } else if (!z) {
                i3 = 90;
            }
            if (i >= 1 && i <= i3) {
                return true;
            }
            flagValidationError(chronoEntity, "DAY_OF_QUARTER out of range: " + i);
            return false;
        }

        private static void flagValidationError(ChronoEntity chronoEntity, String str) {
            ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
            if (chronoEntity.isValid(validationElement, str)) {
                chronoEntity.with(validationElement, str);
            }
        }
    }

    /* JADX INFO: renamed from: net.time4j.PlainDate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$Quarter;

        static {
            int[] iArr = new int[Quarter.values().length];
            $SwitchMap$net$time4j$Quarter = iArr;
            try {
                iArr[Quarter.Q1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$Quarter[Quarter.Q2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CalendarUnit.values().length];
            $SwitchMap$net$time4j$CalendarUnit = iArr2;
            try {
                iArr2[CalendarUnit.MILLENNIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.CENTURIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.DECADES.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.QUARTERS.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.MONTHS.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.WEEKS.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$time4j$CalendarUnit[CalendarUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static class Transformer implements CalendarSystem {
        private Transformer() {
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMaximumSinceUTC() {
            return 365241779741L;
        }

        @Override // net.time4j.engine.CalendarSystem
        public long getMinimumSinceUTC() {
            return -365243219892L;
        }

        /* synthetic */ Transformer(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.CalendarSystem
        public PlainDate transform(long j) {
            if (j == -365243219892L) {
                return PlainDate.MIN;
            }
            if (j == 365241779741L) {
                return PlainDate.MAX;
            }
            long packedDate = GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(j, EpochDays.UTC));
            return PlainDate.of(GregorianMath.readYear(packedDate), GregorianMath.readMonth(packedDate), GregorianMath.readDayOfMonth(packedDate));
        }

        @Override // net.time4j.engine.CalendarSystem
        public long transform(PlainDate plainDate) {
            return EpochDays.UTC.transform(GregorianMath.toMJD(plainDate), EpochDays.MODIFIED_JULIAN_DATE);
        }
    }

    private static class DateElementRule implements ElementRule {
        private DateElementRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainDate plainDate) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainDate plainDate) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate getValue(PlainDate plainDate) {
            return plainDate;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainDate plainDate, PlainDate plainDate2) {
            return plainDate2 != null;
        }

        /* synthetic */ DateElementRule(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate withValue(PlainDate plainDate, PlainDate plainDate2, boolean z) {
            if (plainDate2 != null) {
                return plainDate2;
            }
            throw new IllegalArgumentException("Missing date value.");
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate getMinimum(PlainDate plainDate) {
            return PlainDate.MIN;
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate getMaximum(PlainDate plainDate) {
            return PlainDate.MAX;
        }
    }

    private static class IntegerElementRule implements IntElementRule {
        private final int index;
        private final String name;
        private final ChronoElement ref;

        IntegerElementRule(ChronoElement chronoElement) {
            this(((IntegerDateElement) chronoElement).getIndex(), chronoElement);
        }

        IntegerElementRule(int i, ChronoElement chronoElement) {
            this.ref = chronoElement;
            this.name = chronoElement.name();
            this.index = i;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(PlainDate plainDate) {
            return Integer.valueOf(getInt(plainDate));
        }

        @Override // net.time4j.engine.IntElementRule
        public int getInt(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return plainDate.year;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    return plainDate.month;
                case 16:
                    return plainDate.dayOfMonth;
                case 17:
                    return plainDate.getDayOfYear();
                case 18:
                    return plainDate.getDayOfQuarter();
                case 19:
                    return ((plainDate.dayOfMonth - 1) / 7) + 1;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate withValue(PlainDate plainDate, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            return withValue(plainDate, num.intValue(), z);
        }

        @Override // net.time4j.engine.IntElementRule
        public PlainDate withValue(PlainDate plainDate, int i, boolean z) {
            if (z) {
                return (PlainDate) plainDate.plus(MathUtils.safeSubtract(i, getInt(plainDate)), (IsoDateUnit) PlainDate.ENGINE.getBaseUnit(this.ref));
            }
            switch (this.index) {
                case 14:
                    return plainDate.withYear(i);
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    return plainDate.withMonth(i);
                case 16:
                    return plainDate.withDayOfMonth(i);
                case 17:
                    return plainDate.withDayOfYear(i);
                case 18:
                    if (i >= 1 && i <= getMaximumOfQuarterDay(plainDate)) {
                        return (PlainDate) plainDate.plus(i - plainDate.getDayOfQuarter(), CalendarUnit.DAYS);
                    }
                    throw new IllegalArgumentException("Out of range: " + i);
                case 19:
                    if (z || (i >= 1 && i <= getMaximumOfWIM(plainDate))) {
                        return (PlainDate) plainDate.plus(i - (((plainDate.dayOfMonth - 1) / 7) + 1), CalendarUnit.WEEKS);
                    }
                    throw new IllegalArgumentException("Out of range: " + i);
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainDate plainDate, Integer num) {
            return num != null && isValid(plainDate, num.intValue());
        }

        public boolean isValid(PlainDate plainDate, int i) {
            switch (this.index) {
                case 14:
                    return i >= -999999999 && i <= 999999999;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    return i >= 1 && i <= 12;
                case 16:
                    return i >= 1 && i <= GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month);
                case 17:
                    if (i >= 1) {
                        if (i <= (GregorianMath.isLeapYear(plainDate.year) ? 366 : 365)) {
                            return true;
                        }
                    }
                    return false;
                case 18:
                    return i >= 1 && i <= getMaximumOfQuarterDay(plainDate);
                case 19:
                    return i >= 1 && i <= getMaximumOfWIM(plainDate);
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return PlainDate.MIN_YEAR;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                case 16:
                case 17:
                case 18:
                case 19:
                    return PlainDate.VALUE_1;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return PlainDate.MAX_YEAR;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    return PlainDate.VALUE_12;
                case 16:
                    return Integer.valueOf(GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month));
                case 17:
                    return GregorianMath.isLeapYear(plainDate.year) ? PlainDate.LEAP_YEAR_LEN : PlainDate.STD_YEAR_LEN;
                case 18:
                    return Integer.valueOf(getMaximumOfQuarterDay(plainDate));
                case 19:
                    return Integer.valueOf(getMaximumOfWIM(plainDate));
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainDate plainDate) {
            return getChild();
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainDate plainDate) {
            return getChild();
        }

        private ChronoElement getChild() {
            switch (this.index) {
                case 14:
                    return PlainDate.MONTH_AS_NUMBER;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    return PlainDate.DAY_OF_MONTH;
                case 16:
                case 17:
                case 18:
                case 19:
                    return null;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        private static int getMaximumOfQuarterDay(PlainDate plainDate) {
            int i = ((plainDate.month - 1) / 3) + 1;
            if (i == 1) {
                return GregorianMath.isLeapYear(plainDate.year) ? 91 : 90;
            }
            return i == 2 ? 91 : 92;
        }

        private int getMaximumOfWIM(PlainDate plainDate) {
            int lengthOfMonth = GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month);
            byte b = plainDate.dayOfMonth;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if ((i2 * 7) + b > lengthOfMonth) {
                    return (((b + (i * 7)) - 1) / 7) + 1;
                }
                i = i2;
            }
        }
    }

    private static class EnumElementRule implements ElementRule {
        private final int index;
        private final Enum max;
        private final Enum min;
        private final String name;
        private final Class type;

        EnumElementRule(String str, Class cls, Enum r3, Enum r4, int i) {
            this.name = str;
            this.type = cls;
            this.min = r3;
            this.max = r4;
            this.index = i;
        }

        static EnumElementRule of(ChronoElement chronoElement) {
            return new EnumElementRule(chronoElement.name(), chronoElement.getType(), (Enum) chronoElement.getDefaultMinimum(), (Enum) chronoElement.getDefaultMaximum(), ((EnumElement) chronoElement).getIndex());
        }

        @Override // net.time4j.engine.ElementRule
        public Enum getValue(PlainDate plainDate) {
            Object objValueOf;
            switch (this.index) {
                case 101:
                    objValueOf = Month.valueOf(plainDate.month);
                    break;
                case 102:
                    objValueOf = plainDate.getDayOfWeek();
                    break;
                case 103:
                    objValueOf = Quarter.valueOf(((plainDate.month - 1) / 3) + 1);
                    break;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
            return (Enum) this.type.cast(objValueOf);
        }

        @Override // net.time4j.engine.ElementRule
        public Enum getMinimum(PlainDate plainDate) {
            return this.min;
        }

        @Override // net.time4j.engine.ElementRule
        public Enum getMaximum(PlainDate plainDate) {
            if (this.index == 102 && plainDate.year == 999999999 && plainDate.month == 12 && plainDate.dayOfMonth >= 27) {
                return (Enum) this.type.cast(Weekday.FRIDAY);
            }
            return this.max;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainDate plainDate, Enum r5) {
            if (r5 == null) {
                return false;
            }
            if (this.index != 102 || plainDate.year != 999999999) {
                return true;
            }
            try {
                withValue(plainDate, r5, false);
                return true;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // net.time4j.engine.ElementRule
        public PlainDate withValue(PlainDate plainDate, Enum r3, boolean z) {
            if (r3 != null) {
                switch (this.index) {
                    case 101:
                        return plainDate.withMonth(((Month) Month.class.cast(r3)).getValue());
                    case 102:
                        return plainDate.withDayOfWeek((Weekday) Weekday.class.cast(r3));
                    case 103:
                        return (PlainDate) plainDate.plus(((Quarter) Quarter.class.cast(r3)).getValue() - (((plainDate.month - 1) / 3) + 1), CalendarUnit.QUARTERS);
                    default:
                        throw new UnsupportedOperationException(this.name);
                }
            }
            throw new IllegalArgumentException("Missing element value.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainDate plainDate) {
            return getChild();
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainDate plainDate) {
            return getChild();
        }

        private ChronoElement getChild() {
            switch (this.index) {
                case 101:
                    return PlainDate.DAY_OF_MONTH;
                case 102:
                    return null;
                case 103:
                    return PlainDate.DAY_OF_QUARTER;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }
    }
}
