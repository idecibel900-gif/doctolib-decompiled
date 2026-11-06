package net.time4j;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.c.a.b;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import io.didomi.ssl.config.app.SyncConfiguration;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class PlainTime extends TimePoint implements WallTime, LocalizedPatternSupport {
    public static final ZonalElement AM_PM_OF_DAY;
    public static final AdjustableElement CLOCK_HOUR_OF_AMPM;
    public static final AdjustableElement CLOCK_HOUR_OF_DAY;
    public static final WallTimeElement COMPONENT;
    private static final BigDecimal DECIMAL_23_9;
    private static final BigDecimal DECIMAL_24_0;
    private static final BigDecimal DECIMAL_3600;
    private static final BigDecimal DECIMAL_59_9;
    private static final BigDecimal DECIMAL_60;
    public static final ZonalElement DECIMAL_HOUR;
    public static final ZonalElement DECIMAL_MINUTE;
    private static final BigDecimal DECIMAL_MRD;
    public static final ZonalElement DECIMAL_SECOND;
    public static final ProportionalElement DIGITAL_HOUR_OF_AMPM;
    public static final ProportionalElement DIGITAL_HOUR_OF_DAY;
    private static final Map ELEMENTS;
    private static final TimeAxis ENGINE;
    private static final PlainTime[] HOURS;
    public static final ProportionalElement HOUR_FROM_0_TO_24;
    private static final ElementRule H_DECIMAL_RULE;
    static final char ISO_DECIMAL_SEPARATOR;
    static final PlainTime MAX;
    public static final ProportionalElement MICRO_OF_DAY;
    public static final ProportionalElement MICRO_OF_SECOND;
    public static final ProportionalElement MILLI_OF_DAY;
    public static final ProportionalElement MILLI_OF_SECOND;
    static final PlainTime MIN;
    public static final ProportionalElement MINUTE_OF_DAY;
    public static final ProportionalElement MINUTE_OF_HOUR;
    private static final ElementRule M_DECIMAL_RULE;
    public static final ProportionalElement NANO_OF_DAY;
    public static final ProportionalElement NANO_OF_SECOND;
    public static final ChronoElement PRECISION;
    public static final ProportionalElement SECOND_OF_DAY;
    public static final ProportionalElement SECOND_OF_MINUTE;
    private static final ElementRule S_DECIMAL_RULE;
    static final ChronoElement WALL_TIME;
    private static final long serialVersionUID = 2780881537313863339L;
    private final transient byte hour;
    private final transient byte minute;
    private final transient int nano;
    private final transient byte second;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public PlainTime getContext() {
        return this;
    }

    static {
        ISO_DECIMAL_SEPARATOR = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? b.a : ',';
        DECIMAL_60 = new BigDecimal(60);
        DECIMAL_3600 = new BigDecimal(3600);
        DECIMAL_MRD = new BigDecimal(Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        DECIMAL_24_0 = new BigDecimal("24");
        DECIMAL_23_9 = new BigDecimal("23.999999999999999");
        DECIMAL_59_9 = new BigDecimal("59.999999999999999");
        HOURS = new PlainTime[25];
        for (int i = 0; i <= 24; i++) {
            HOURS[i] = new PlainTime(i, 0, 0, 0, false);
        }
        PlainTime[] plainTimeArr = HOURS;
        PlainTime plainTime = plainTimeArr[0];
        MIN = plainTime;
        PlainTime plainTime2 = plainTimeArr[24];
        MAX = plainTime2;
        TimeElement timeElement = TimeElement.INSTANCE;
        WALL_TIME = timeElement;
        COMPONENT = timeElement;
        AmPmElement amPmElement = AmPmElement.AM_PM_OF_DAY;
        AM_PM_OF_DAY = amPmElement;
        IntegerTimeElement integerTimeElementCreateClockElement = IntegerTimeElement.createClockElement("CLOCK_HOUR_OF_AMPM", false);
        CLOCK_HOUR_OF_AMPM = integerTimeElementCreateClockElement;
        IntegerTimeElement integerTimeElementCreateClockElement2 = IntegerTimeElement.createClockElement("CLOCK_HOUR_OF_DAY", true);
        CLOCK_HOUR_OF_DAY = integerTimeElementCreateClockElement2;
        IntegerTimeElement integerTimeElementCreateTimeElement = IntegerTimeElement.createTimeElement("DIGITAL_HOUR_OF_AMPM", 3, 0, 11, 'K');
        DIGITAL_HOUR_OF_AMPM = integerTimeElementCreateTimeElement;
        IntegerTimeElement integerTimeElementCreateTimeElement2 = IntegerTimeElement.createTimeElement("DIGITAL_HOUR_OF_DAY", 4, 0, 23, 'H');
        DIGITAL_HOUR_OF_DAY = integerTimeElementCreateTimeElement2;
        IntegerTimeElement integerTimeElementCreateTimeElement3 = IntegerTimeElement.createTimeElement("HOUR_FROM_0_TO_24", 5, 0, 23, 'H');
        HOUR_FROM_0_TO_24 = integerTimeElementCreateTimeElement3;
        IntegerTimeElement integerTimeElementCreateTimeElement4 = IntegerTimeElement.createTimeElement("MINUTE_OF_HOUR", 6, 0, 59, 'm');
        MINUTE_OF_HOUR = integerTimeElementCreateTimeElement4;
        IntegerTimeElement integerTimeElementCreateTimeElement5 = IntegerTimeElement.createTimeElement("MINUTE_OF_DAY", 7, 0, 1439, (char) 0);
        MINUTE_OF_DAY = integerTimeElementCreateTimeElement5;
        IntegerTimeElement integerTimeElementCreateTimeElement6 = IntegerTimeElement.createTimeElement("SECOND_OF_MINUTE", 8, 0, 59, 's');
        SECOND_OF_MINUTE = integerTimeElementCreateTimeElement6;
        IntegerTimeElement integerTimeElementCreateTimeElement7 = IntegerTimeElement.createTimeElement("SECOND_OF_DAY", 9, 0, 86399, (char) 0);
        SECOND_OF_DAY = integerTimeElementCreateTimeElement7;
        IntegerTimeElement integerTimeElementCreateTimeElement8 = IntegerTimeElement.createTimeElement("MILLI_OF_SECOND", 10, 0, 999, (char) 0);
        MILLI_OF_SECOND = integerTimeElementCreateTimeElement8;
        IntegerTimeElement integerTimeElementCreateTimeElement9 = IntegerTimeElement.createTimeElement("MICRO_OF_SECOND", 11, 0, 999999, (char) 0);
        MICRO_OF_SECOND = integerTimeElementCreateTimeElement9;
        IntegerTimeElement integerTimeElementCreateTimeElement10 = IntegerTimeElement.createTimeElement("NANO_OF_SECOND", 12, 0, 999999999, 'S');
        NANO_OF_SECOND = integerTimeElementCreateTimeElement10;
        IntegerTimeElement integerTimeElementCreateTimeElement11 = IntegerTimeElement.createTimeElement("MILLI_OF_DAY", 13, 0, 86399999, 'A');
        MILLI_OF_DAY = integerTimeElementCreateTimeElement11;
        LongElement longElementCreate = LongElement.create("MICRO_OF_DAY", 0L, 86399999999L);
        MICRO_OF_DAY = longElementCreate;
        LongElement longElementCreate2 = LongElement.create("NANO_OF_DAY", 0L, 86399999999999L);
        NANO_OF_DAY = longElementCreate2;
        DecimalTimeElement decimalTimeElement = new DecimalTimeElement("DECIMAL_HOUR", DECIMAL_23_9);
        DECIMAL_HOUR = decimalTimeElement;
        BigDecimal bigDecimal = DECIMAL_59_9;
        DecimalTimeElement decimalTimeElement2 = new DecimalTimeElement("DECIMAL_MINUTE", bigDecimal);
        DECIMAL_MINUTE = decimalTimeElement2;
        DecimalTimeElement decimalTimeElement3 = new DecimalTimeElement("DECIMAL_SECOND", bigDecimal);
        DECIMAL_SECOND = decimalTimeElement3;
        ChronoElement chronoElement = PrecisionElement.CLOCK_PRECISION;
        PRECISION = chronoElement;
        HashMap map = new HashMap();
        fill(map, timeElement);
        fill(map, amPmElement);
        fill(map, integerTimeElementCreateClockElement);
        fill(map, integerTimeElementCreateClockElement2);
        fill(map, integerTimeElementCreateTimeElement);
        fill(map, integerTimeElementCreateTimeElement2);
        fill(map, integerTimeElementCreateTimeElement3);
        fill(map, integerTimeElementCreateTimeElement4);
        fill(map, integerTimeElementCreateTimeElement5);
        fill(map, integerTimeElementCreateTimeElement6);
        fill(map, integerTimeElementCreateTimeElement7);
        fill(map, integerTimeElementCreateTimeElement8);
        fill(map, integerTimeElementCreateTimeElement9);
        fill(map, integerTimeElementCreateTimeElement10);
        fill(map, integerTimeElementCreateTimeElement11);
        fill(map, longElementCreate);
        fill(map, longElementCreate2);
        fill(map, decimalTimeElement);
        fill(map, decimalTimeElement2);
        fill(map, decimalTimeElement3);
        ELEMENTS = Collections.unmodifiableMap(map);
        BigDecimalElementRule bigDecimalElementRule = new BigDecimalElementRule(decimalTimeElement, DECIMAL_24_0);
        H_DECIMAL_RULE = bigDecimalElementRule;
        BigDecimalElementRule bigDecimalElementRule2 = new BigDecimalElementRule(decimalTimeElement2, bigDecimal);
        M_DECIMAL_RULE = bigDecimalElementRule2;
        BigDecimalElementRule bigDecimalElementRule3 = new BigDecimalElementRule(decimalTimeElement3, bigDecimal);
        S_DECIMAL_RULE = bigDecimalElementRule3;
        TimeAxis.Builder up = TimeAxis.Builder.setUp(IsoTimeUnit.class, PlainTime.class, new Merger(null), plainTime, plainTime2);
        AnonymousClass1 anonymousClass1 = null;
        TimeAxis.Builder builderAppendElement = up.appendElement((ChronoElement) timeElement, (ElementRule) new TimeRule(anonymousClass1)).appendElement((ChronoElement) amPmElement, (ElementRule) new MeridiemRule(anonymousClass1));
        IntegerElementRule integerElementRule = new IntegerElementRule(integerTimeElementCreateClockElement, 1, 12);
        ClockUnit clockUnit = ClockUnit.HOURS;
        TimeAxis.Builder builderAppendElement2 = builderAppendElement.appendElement(integerTimeElementCreateClockElement, integerElementRule, clockUnit).appendElement(integerTimeElementCreateClockElement2, new IntegerElementRule(integerTimeElementCreateClockElement2, 1, 24), clockUnit).appendElement(integerTimeElementCreateTimeElement, new IntegerElementRule(integerTimeElementCreateTimeElement, 0, 11), clockUnit).appendElement(integerTimeElementCreateTimeElement2, new IntegerElementRule(integerTimeElementCreateTimeElement2, 0, 23), clockUnit).appendElement(integerTimeElementCreateTimeElement3, new IntegerElementRule(integerTimeElementCreateTimeElement3, 0, 24), clockUnit);
        IntegerElementRule integerElementRule2 = new IntegerElementRule(integerTimeElementCreateTimeElement4, 0, 59);
        ClockUnit clockUnit2 = ClockUnit.MINUTES;
        TimeAxis.Builder builderAppendElement3 = builderAppendElement2.appendElement(integerTimeElementCreateTimeElement4, integerElementRule2, clockUnit2).appendElement(integerTimeElementCreateTimeElement5, new IntegerElementRule(integerTimeElementCreateTimeElement5, 0, 1440), clockUnit2);
        IntegerElementRule integerElementRule3 = new IntegerElementRule(integerTimeElementCreateTimeElement6, 0, 59);
        ClockUnit clockUnit3 = ClockUnit.SECONDS;
        TimeAxis.Builder builderAppendElement4 = builderAppendElement3.appendElement(integerTimeElementCreateTimeElement6, integerElementRule3, clockUnit3).appendElement(integerTimeElementCreateTimeElement7, new IntegerElementRule(integerTimeElementCreateTimeElement7, 0, SyncConfiguration.DEFAULT_FREQUENCY), clockUnit3);
        IntegerElementRule integerElementRule4 = new IntegerElementRule(integerTimeElementCreateTimeElement8, 0, 999);
        ClockUnit clockUnit4 = ClockUnit.MILLIS;
        TimeAxis.Builder builderAppendElement5 = builderAppendElement4.appendElement(integerTimeElementCreateTimeElement8, integerElementRule4, clockUnit4);
        IntegerElementRule integerElementRule5 = new IntegerElementRule(integerTimeElementCreateTimeElement9, 0, 999999);
        ClockUnit clockUnit5 = ClockUnit.MICROS;
        TimeAxis.Builder builderAppendElement6 = builderAppendElement5.appendElement(integerTimeElementCreateTimeElement9, integerElementRule5, clockUnit5);
        IntegerElementRule integerElementRule6 = new IntegerElementRule(integerTimeElementCreateTimeElement10, 0, 999999999);
        ClockUnit clockUnit6 = ClockUnit.NANOS;
        TimeAxis.Builder builderAppendElement7 = builderAppendElement6.appendElement(integerTimeElementCreateTimeElement10, integerElementRule6, clockUnit6).appendElement(integerTimeElementCreateTimeElement11, new IntegerElementRule(integerTimeElementCreateTimeElement11, 0, 86400000), clockUnit4).appendElement(longElementCreate, new LongElementRule(longElementCreate, 0L, 86400000000L), clockUnit5).appendElement(longElementCreate2, new LongElementRule(longElementCreate2, 0L, 86400000000000L), clockUnit6).appendElement((ChronoElement) decimalTimeElement, (ElementRule) bigDecimalElementRule).appendElement((ChronoElement) decimalTimeElement2, (ElementRule) bigDecimalElementRule2).appendElement((ChronoElement) decimalTimeElement3, (ElementRule) bigDecimalElementRule3).appendElement(chronoElement, (ElementRule) new PrecisionRule(null));
        registerExtensions(builderAppendElement7);
        registerUnits(builderAppendElement7);
        ENGINE = builderAppendElement7.build();
    }

    private PlainTime(int i, int i2, int i3, int i4, boolean z) {
        if (z) {
            checkHour(i);
            checkMinute(i2);
            checkSecond(i3);
            checkNano(i4);
            if (i == 24 && (i2 | i3 | i4) != 0) {
                throw new IllegalArgumentException("T24:00:00 exceeded.");
            }
        }
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    @Override // net.time4j.base.WallTime
    public int getHour() {
        return this.hour;
    }

    @Override // net.time4j.base.WallTime
    public int getMinute() {
        return this.minute;
    }

    @Override // net.time4j.base.WallTime
    public int getSecond() {
        return this.second;
    }

    @Override // net.time4j.base.WallTime
    public int getNanosecond() {
        return this.nano;
    }

    public static PlainTime midnightAtStartOfDay() {
        return MIN;
    }

    public static PlainTime midnightAtEndOfDay() {
        return MAX;
    }

    public static PlainTime of(int i) {
        checkHour(i);
        return HOURS[i];
    }

    public static PlainTime of(int i, int i2) {
        if (i2 == 0) {
            return of(i);
        }
        return new PlainTime(i, i2, 0, 0, true);
    }

    public static PlainTime of(int i, int i2, int i3) {
        if ((i2 | i3) == 0) {
            return of(i);
        }
        return new PlainTime(i, i2, i3, 0, true);
    }

    public static PlainTime of(int i, int i2, int i3, int i4) {
        return of(i, i2, i3, i4, true);
    }

    public static PlainTime of(BigDecimal bigDecimal) {
        return (PlainTime) H_DECIMAL_RULE.withValue(null, bigDecimal, false);
    }

    public DayCycles roll(long j, ClockUnit clockUnit) {
        return ClockUnitRule.addToWithOverflow(this, j, clockUnit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlainTime) {
            PlainTime plainTime = (PlainTime) obj;
            if (this.hour == plainTime.hour && this.minute == plainTime.minute && this.second == plainTime.second && this.nano == plainTime.nano) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.hour + (this.minute * 60) + (this.second * 3600) + (this.nano * 37);
    }

    public boolean isBefore(PlainTime plainTime) {
        return compareTo(plainTime) < 0;
    }

    public boolean isAfter(PlainTime plainTime) {
        return compareTo(plainTime) > 0;
    }

    public boolean isSimultaneous(PlainTime plainTime) {
        return compareTo(plainTime) == 0;
    }

    public boolean isMidnight() {
        return isFullHour() && this.hour % 24 == 0;
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(PlainTime plainTime) {
        int i = this.hour - plainTime.hour;
        if (i == 0 && (i = this.minute - plainTime.minute) == 0 && (i = this.second - plainTime.second) == 0) {
            i = this.nano - plainTime.nano;
        }
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(19);
        sb.append('T');
        append2Digits(this.hour, sb);
        if ((this.minute | this.second | this.nano) != 0) {
            sb.append(':');
            append2Digits(this.minute, sb);
            if ((this.second | this.nano) != 0) {
                sb.append(':');
                append2Digits(this.second, sb);
                int i = this.nano;
                if (i != 0) {
                    printNanos(sb, i);
                }
            }
        }
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

    static void printNanos(StringBuilder sb, int i) {
        int i2;
        sb.append(ISO_DECIMAL_SEPARATOR);
        String string = Integer.toString(i);
        if (i % 1000000 == 0) {
            i2 = 3;
        } else {
            i2 = i % 1000 == 0 ? 6 : 9;
        }
        for (int length = string.length(); length < 9; length++) {
            sb.append('0');
        }
        int length2 = (i2 + string.length()) - 9;
        for (int i3 = 0; i3 < length2; i3++) {
            sb.append(string.charAt(i3));
        }
    }

    static Object lookupElement(String str) {
        return ELEMENTS.get(str);
    }

    boolean hasReducedRange(ChronoElement chronoElement) {
        if (chronoElement == MILLI_OF_DAY && this.nano % 1000000 != 0) {
            return true;
        }
        if (chronoElement == HOUR_FROM_0_TO_24 && !isFullHour()) {
            return true;
        }
        if (chronoElement == MINUTE_OF_DAY && !isFullMinute()) {
            return true;
        }
        if (chronoElement != SECOND_OF_DAY || this.nano == 0) {
            return chronoElement == MICRO_OF_DAY && this.nano % 1000 != 0;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainTime of(int i, int i2, int i3, int i4, boolean z) {
        if ((i2 | i3 | i4) != 0) {
            return new PlainTime(i, i2, i3, i4, z);
        }
        if (z) {
            return of(i);
        }
        return HOURS[i];
    }

    private static void fill(Map map, ChronoElement chronoElement) {
        map.put(chronoElement.name(), chronoElement);
    }

    private static void append2Digits(int i, StringBuilder sb) {
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private static void checkHour(long j) {
        if (j < 0 || j > 24) {
            throw new IllegalArgumentException("HOUR_OF_DAY out of range: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkMinute(long j) {
        if (j < 0 || j > 59) {
            throw new IllegalArgumentException("MINUTE_OF_HOUR out of range: " + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkSecond(long j) {
        if (j < 0 || j > 59) {
            throw new IllegalArgumentException("SECOND_OF_MINUTE out of range: " + j);
        }
    }

    private static void checkNano(int i) {
        if (i < 0 || i >= 1000000000) {
            throw new IllegalArgumentException("NANO_OF_SECOND out of range: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainTime createFromMillis(int i, int i2) {
        int i3 = ((i % 1000) * 1000000) + i2;
        int i4 = i / 1000;
        int i5 = i4 % 60;
        int i6 = i4 / 60;
        return of(i6 / 60, i6 % 60, i5, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainTime createFromMicros(long j, int i) {
        int i2 = (((int) (j % 1000000)) * 1000) + i;
        int i3 = (int) (j / 1000000);
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        return of(i5 / 60, i5 % 60, i4, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlainTime createFromNanos(long j) {
        int i = (int) (j % 1000000000);
        int i2 = (int) (j / 1000000000);
        int i3 = i2 % 60;
        int i4 = i2 / 60;
        return of(i4 / 60, i4 % 60, i3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getNanoOfDay() {
        return ((long) this.nano) + (((long) this.second) * 1000000000) + (((long) this.minute) * 60000000000L) + (((long) this.hour) * 3600000000000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFullHour() {
        return ((this.minute | this.second) | this.nano) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFullMinute() {
        return (this.second | this.nano) == 0;
    }

    private static void registerExtensions(TimeAxis.Builder builder) {
        for (ChronoExtension chronoExtension : ResourceLoader.getInstance().services(ChronoExtension.class)) {
            if (chronoExtension.accept(PlainTime.class)) {
                builder.appendExtension(chronoExtension);
            }
        }
        builder.appendExtension((ChronoExtension) new DayPeriod.Extension());
    }

    private static void registerUnits(TimeAxis.Builder builder) {
        Set setAllOf = EnumSet.allOf(ClockUnit.class);
        for (ClockUnit clockUnit : ClockUnit.values()) {
            builder.appendUnit(clockUnit, new ClockUnitRule(clockUnit, null), clockUnit.getLength(), setAllOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long floorMod(long j, long j2) {
        return j - (j2 * (j >= 0 ? j / j2 : ((j + 1) / j2) - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long floorDiv(long j, long j2) {
        if (j >= 0) {
            return j / j2;
        }
        return ((j + 1) / j2) - 1;
    }

    private Object writeReplace() {
        return new SPX(this, 2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class ClockUnitRule implements UnitRule {
        private final ClockUnit unit;

        /* synthetic */ ClockUnitRule(ClockUnit clockUnit, AnonymousClass1 anonymousClass1) {
            this(clockUnit);
        }

        private ClockUnitRule(ClockUnit clockUnit) {
            this.unit = clockUnit;
        }

        @Override // net.time4j.engine.UnitRule
        public PlainTime addTo(PlainTime plainTime, long j) {
            return j == 0 ? plainTime : (PlainTime) doAdd(PlainTime.class, this.unit, plainTime, j);
        }

        @Override // net.time4j.engine.UnitRule
        public long between(PlainTime plainTime, PlainTime plainTime2) {
            long j;
            long nanoOfDay = plainTime2.getNanoOfDay() - plainTime.getNanoOfDay();
            switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.unit.ordinal()]) {
                case 1:
                    j = 3600000000000L;
                    break;
                case 2:
                    j = 60000000000L;
                    break;
                case 3:
                    j = 1000000000;
                    break;
                case 4:
                    j = 1000000;
                    break;
                case 5:
                    j = 1000;
                    break;
                case 6:
                    j = 1;
                    break;
                default:
                    throw new UnsupportedOperationException(this.unit.name());
            }
            return nanoOfDay / j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static DayCycles addToWithOverflow(PlainTime plainTime, long j, ClockUnit clockUnit) {
            if (j == 0 && plainTime.hour < 24) {
                return new DayCycles(0L, plainTime);
            }
            return (DayCycles) doAdd(DayCycles.class, clockUnit, plainTime, j);
        }

        private static Object doAdd(Class cls, ClockUnit clockUnit, PlainTime plainTime, long j) {
            long jSafeAdd;
            PlainTime plainTimeOf;
            int iFloorModulo = plainTime.minute;
            int iFloorModulo2 = plainTime.second;
            int i = plainTime.nano;
            switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[clockUnit.ordinal()]) {
                case 1:
                    jSafeAdd = MathUtils.safeAdd(plainTime.hour, j);
                    break;
                case 2:
                    long jSafeAdd2 = MathUtils.safeAdd(plainTime.minute, j);
                    jSafeAdd = MathUtils.safeAdd(plainTime.hour, MathUtils.floorDivide(jSafeAdd2, 60));
                    iFloorModulo = MathUtils.floorModulo(jSafeAdd2, 60);
                    break;
                case 3:
                    long jSafeAdd3 = MathUtils.safeAdd(plainTime.second, j);
                    long jSafeAdd4 = MathUtils.safeAdd(plainTime.minute, MathUtils.floorDivide(jSafeAdd3, 60));
                    jSafeAdd = MathUtils.safeAdd(plainTime.hour, MathUtils.floorDivide(jSafeAdd4, 60));
                    int iFloorModulo3 = MathUtils.floorModulo(jSafeAdd4, 60);
                    iFloorModulo2 = MathUtils.floorModulo(jSafeAdd3, 60);
                    iFloorModulo = iFloorModulo3;
                    break;
                case 4:
                    return doAdd(cls, ClockUnit.NANOS, plainTime, MathUtils.safeMultiply(j, 1000000L));
                case 5:
                    return doAdd(cls, ClockUnit.NANOS, plainTime, MathUtils.safeMultiply(j, 1000L));
                case 6:
                    long jSafeAdd5 = MathUtils.safeAdd(plainTime.nano, j);
                    long jSafeAdd6 = MathUtils.safeAdd(plainTime.second, MathUtils.floorDivide(jSafeAdd5, Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
                    long jSafeAdd7 = MathUtils.safeAdd(plainTime.minute, MathUtils.floorDivide(jSafeAdd6, 60));
                    jSafeAdd = MathUtils.safeAdd(plainTime.hour, MathUtils.floorDivide(jSafeAdd7, 60));
                    int iFloorModulo4 = MathUtils.floorModulo(jSafeAdd7, 60);
                    int iFloorModulo5 = MathUtils.floorModulo(jSafeAdd6, 60);
                    int iFloorModulo6 = MathUtils.floorModulo(jSafeAdd5, Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
                    iFloorModulo = iFloorModulo4;
                    iFloorModulo2 = iFloorModulo5;
                    i = iFloorModulo6;
                    break;
                default:
                    throw new UnsupportedOperationException(clockUnit.name());
            }
            int iFloorModulo7 = MathUtils.floorModulo(jSafeAdd, 24);
            if ((iFloorModulo7 | iFloorModulo | iFloorModulo2 | i) == 0) {
                plainTimeOf = (j <= 0 || cls != PlainTime.class) ? PlainTime.MIN : PlainTime.MAX;
            } else {
                plainTimeOf = PlainTime.of(iFloorModulo7, iFloorModulo, iFloorModulo2, i);
            }
            if (cls == PlainTime.class) {
                return cls.cast(plainTimeOf);
            }
            return cls.cast(new DayCycles(MathUtils.floorDivide(jSafeAdd, 24), plainTimeOf));
        }
    }

    /* JADX INFO: renamed from: net.time4j.PlainTime$1, reason: invalid class name */
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

    private static class TimeRule implements ElementRule {
        private TimeRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime getValue(PlainTime plainTime) {
            return plainTime;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, PlainTime plainTime2) {
            return plainTime2 != null;
        }

        /* synthetic */ TimeRule(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, PlainTime plainTime2, boolean z) {
            if (plainTime2 != null) {
                return plainTime2;
            }
            throw new IllegalArgumentException("Missing time value.");
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime getMinimum(PlainTime plainTime) {
            return PlainTime.MIN;
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime getMaximum(PlainTime plainTime) {
            return PlainTime.MAX;
        }
    }

    private static class PrecisionRule implements ElementRule {
        private PrecisionRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, ClockUnit clockUnit) {
            return clockUnit != null;
        }

        /* synthetic */ PrecisionRule(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ElementRule
        public ClockUnit getValue(PlainTime plainTime) {
            if (plainTime.nano != 0) {
                if (plainTime.nano % 1000000 != 0) {
                    if (plainTime.nano % 1000 == 0) {
                        return ClockUnit.MICROS;
                    }
                    return ClockUnit.NANOS;
                }
                return ClockUnit.MILLIS;
            }
            if (plainTime.second == 0) {
                if (plainTime.minute != 0) {
                    return ClockUnit.MINUTES;
                }
                return ClockUnit.HOURS;
            }
            return ClockUnit.SECONDS;
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, ClockUnit clockUnit, boolean z) {
            if (clockUnit == null) {
                throw new IllegalArgumentException("Missing precision value.");
            }
            if (clockUnit.ordinal() < getValue(plainTime).ordinal()) {
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[clockUnit.ordinal()]) {
                    case 1:
                        return PlainTime.of(plainTime.hour);
                    case 2:
                        return PlainTime.of(plainTime.hour, plainTime.minute);
                    case 3:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second);
                    case 4:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second, (plainTime.nano / 1000000) * 1000000);
                    case 5:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second, (plainTime.nano / 1000) * 1000);
                    case 6:
                        break;
                    default:
                        throw new UnsupportedOperationException(clockUnit.name());
                }
            }
            return plainTime;
        }

        @Override // net.time4j.engine.ElementRule
        public ClockUnit getMinimum(PlainTime plainTime) {
            return ClockUnit.HOURS;
        }

        @Override // net.time4j.engine.ElementRule
        public ClockUnit getMaximum(PlainTime plainTime) {
            return ClockUnit.NANOS;
        }
    }

    private static class MeridiemRule implements ElementRule {
        private MeridiemRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, Meridiem meridiem) {
            return meridiem != null;
        }

        /* synthetic */ MeridiemRule(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ElementRule
        public Meridiem getValue(PlainTime plainTime) {
            return Meridiem.ofHour(plainTime.hour);
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, Meridiem meridiem, boolean z) {
            int i = plainTime.hour == 24 ? 0 : plainTime.hour;
            if (meridiem == null) {
                throw new IllegalArgumentException("Missing am/pm-value.");
            }
            if (meridiem == Meridiem.AM) {
                if (i >= 12) {
                    i -= 12;
                }
            } else if (meridiem == Meridiem.PM && i < 12) {
                i += 12;
            }
            return PlainTime.of(i, plainTime.minute, plainTime.second, plainTime.nano);
        }

        @Override // net.time4j.engine.ElementRule
        public Meridiem getMinimum(PlainTime plainTime) {
            return Meridiem.AM;
        }

        @Override // net.time4j.engine.ElementRule
        public Meridiem getMaximum(PlainTime plainTime) {
            return Meridiem.PM;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return PlainTime.DIGITAL_HOUR_OF_AMPM;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return PlainTime.DIGITAL_HOUR_OF_AMPM;
        }
    }

    private static class IntegerElementRule implements ElementRule {
        private final ChronoElement element;
        private final int index;
        private final int max;
        private final int min;

        IntegerElementRule(ChronoElement chronoElement, int i, int i2) {
            this.element = chronoElement;
            if (chronoElement instanceof IntegerTimeElement) {
                this.index = ((IntegerTimeElement) chronoElement).getIndex();
            } else {
                this.index = -1;
            }
            this.min = i;
            this.max = i2;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(PlainTime plainTime) {
            int i;
            byte b;
            int nanoOfDay = 12;
            switch (this.index) {
                case 1:
                    int i2 = plainTime.hour % 12;
                    if (i2 != 0) {
                        nanoOfDay = i2;
                    }
                    return Integer.valueOf(nanoOfDay);
                case 2:
                    nanoOfDay = plainTime.hour % 24;
                    if (nanoOfDay == 0) {
                        nanoOfDay = 24;
                    }
                    return Integer.valueOf(nanoOfDay);
                case 3:
                    nanoOfDay = plainTime.hour % 12;
                    return Integer.valueOf(nanoOfDay);
                case 4:
                    nanoOfDay = plainTime.hour % 24;
                    return Integer.valueOf(nanoOfDay);
                case 5:
                    nanoOfDay = plainTime.hour;
                    return Integer.valueOf(nanoOfDay);
                case 6:
                    nanoOfDay = plainTime.minute;
                    return Integer.valueOf(nanoOfDay);
                case 7:
                    i = plainTime.hour * 60;
                    b = plainTime.minute;
                    nanoOfDay = i + b;
                    return Integer.valueOf(nanoOfDay);
                case 8:
                    nanoOfDay = plainTime.second;
                    return Integer.valueOf(nanoOfDay);
                case 9:
                    i = (plainTime.hour * 3600) + (plainTime.minute * 60);
                    b = plainTime.second;
                    nanoOfDay = i + b;
                    return Integer.valueOf(nanoOfDay);
                case 10:
                    nanoOfDay = plainTime.nano / 1000000;
                    return Integer.valueOf(nanoOfDay);
                case BaseVideoCapturer.RGBA /* 11 */:
                    nanoOfDay = plainTime.nano / 1000;
                    return Integer.valueOf(nanoOfDay);
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    nanoOfDay = plainTime.nano;
                    return Integer.valueOf(nanoOfDay);
                case 13:
                    nanoOfDay = (int) (plainTime.getNanoOfDay() / 1000000);
                    return Integer.valueOf(nanoOfDay);
                default:
                    throw new UnsupportedOperationException(this.element.name());
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:22:0x006c A[PHI: r8
          0x006c: PHI (r8v8 int) = (r8v3 int), (r8v4 int), (r8v3 int), (r8v7 int), (r8v3 int) binds: [B:9:0x002d, B:34:0x0087, B:28:0x007a, B:26:0x0075, B:24:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:26:0x0075 A[PHI: r8
          0x0075: PHI (r8v6 int) = (r8v4 int), (r8v3 int) binds: [B:34:0x0087, B:24:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, Integer num, boolean z) {
            int i;
            int i2;
            if (num == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            if (z) {
                return withValueInLenientMode(plainTime, num.intValue());
            }
            if (isValid(plainTime, num)) {
                int i3 = plainTime.hour;
                int i4 = plainTime.minute;
                int i5 = plainTime.second;
                int i6 = plainTime.nano;
                int iIntValue = num.intValue();
                switch (this.index) {
                    case 1:
                        if (iIntValue == 12) {
                            iIntValue = 0;
                        }
                        if (!isAM(plainTime)) {
                            iIntValue += 12;
                        }
                        i3 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 2:
                        if (iIntValue == 24) {
                            i3 = 0;
                        } else {
                            i3 = iIntValue;
                        }
                        return PlainTime.of(i3, i4, i5, i6);
                    case 3:
                        if (!isAM(plainTime)) {
                            iIntValue += 12;
                        }
                        i3 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 4:
                    case 5:
                        i3 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 6:
                        i4 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 7:
                        i3 = iIntValue / 60;
                        i4 = iIntValue % 60;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 8:
                        i5 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 9:
                        i3 = iIntValue / 3600;
                        int i7 = iIntValue % 3600;
                        i4 = i7 / 60;
                        i5 = i7 % 60;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 10:
                        i = iIntValue * 1000000;
                        i2 = plainTime.nano % 1000000;
                        i6 = i + i2;
                        return PlainTime.of(i3, i4, i5, i6);
                    case BaseVideoCapturer.RGBA /* 11 */:
                        i = iIntValue * 1000;
                        i2 = plainTime.nano % 1000;
                        i6 = i + i2;
                        return PlainTime.of(i3, i4, i5, i6);
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        i6 = iIntValue;
                        return PlainTime.of(i3, i4, i5, i6);
                    case 13:
                        return PlainTime.createFromMillis(iIntValue, plainTime.nano % 1000000);
                    default:
                        throw new UnsupportedOperationException(this.element.name());
                }
            }
            throw new IllegalArgumentException("Value out of range: " + num);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, Integer num) {
            int iIntValue;
            int i;
            if (num == null || (iIntValue = num.intValue()) < this.min || iIntValue > (i = this.max)) {
                return false;
            }
            if (iIntValue == i) {
                int i2 = this.index;
                if (i2 == 5) {
                    return plainTime.isFullHour();
                }
                if (i2 == 7) {
                    return plainTime.isFullMinute();
                }
                if (i2 == 9) {
                    return plainTime.nano == 0;
                }
                if (i2 == 13) {
                    return plainTime.nano % 1000000 == 0;
                }
            }
            if (plainTime.hour == 24) {
                switch (this.index) {
                    case 6:
                    case 8:
                    case 10:
                    case BaseVideoCapturer.RGBA /* 11 */:
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        return iIntValue == 0;
                }
            }
            return true;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(PlainTime plainTime) {
            return Integer.valueOf(this.min);
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(PlainTime plainTime) {
            if (plainTime.hour == 24) {
                switch (this.index) {
                    case 6:
                    case 8:
                    case 10:
                    case BaseVideoCapturer.RGBA /* 11 */:
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        return 0;
                }
            }
            if (plainTime.hasReducedRange(this.element)) {
                return Integer.valueOf(this.max - 1);
            }
            return Integer.valueOf(this.max);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return getChild(plainTime);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return getChild(plainTime);
        }

        private ChronoElement getChild(PlainTime plainTime) {
            switch (this.index) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return PlainTime.MINUTE_OF_HOUR;
                case 6:
                case 7:
                    return PlainTime.SECOND_OF_MINUTE;
                case 8:
                case 9:
                    return PlainTime.NANO_OF_SECOND;
                default:
                    return null;
            }
        }

        private PlainTime withValueInLenientMode(PlainTime plainTime, int i) {
            ChronoElement chronoElement = this.element;
            if (chronoElement == PlainTime.HOUR_FROM_0_TO_24 || chronoElement == PlainTime.DIGITAL_HOUR_OF_DAY || chronoElement == PlainTime.DIGITAL_HOUR_OF_AMPM) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, ((Integer) plainTime.get(chronoElement)).intValue()), ClockUnit.HOURS);
            }
            if (chronoElement == PlainTime.MINUTE_OF_HOUR) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, (int) plainTime.minute), ClockUnit.MINUTES);
            }
            if (chronoElement == PlainTime.SECOND_OF_MINUTE) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, (int) plainTime.second), ClockUnit.SECONDS);
            }
            ProportionalElement proportionalElement = PlainTime.MILLI_OF_SECOND;
            if (chronoElement == proportionalElement) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, ((Integer) plainTime.get(proportionalElement)).intValue()), ClockUnit.MILLIS);
            }
            ProportionalElement proportionalElement2 = PlainTime.MICRO_OF_SECOND;
            if (chronoElement == proportionalElement2) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, ((Integer) plainTime.get(proportionalElement2)).intValue()), ClockUnit.MICROS);
            }
            if (chronoElement == PlainTime.NANO_OF_SECOND) {
                return (PlainTime) plainTime.plus(MathUtils.safeSubtract(i, plainTime.nano), ClockUnit.NANOS);
            }
            if (chronoElement == PlainTime.MILLI_OF_DAY) {
                int iFloorModulo = MathUtils.floorModulo(i, 86400000);
                int i2 = plainTime.nano % 1000000;
                if (iFloorModulo == 0 && i2 == 0) {
                    return i > 0 ? PlainTime.MAX : PlainTime.MIN;
                }
                return PlainTime.createFromMillis(iFloorModulo, i2);
            }
            if (chronoElement == PlainTime.MINUTE_OF_DAY) {
                int iFloorModulo2 = MathUtils.floorModulo(i, 1440);
                if (iFloorModulo2 == 0 && plainTime.isFullMinute()) {
                    return i > 0 ? PlainTime.MAX : PlainTime.MIN;
                }
                return withValue(plainTime, Integer.valueOf(iFloorModulo2), false);
            }
            if (chronoElement == PlainTime.SECOND_OF_DAY) {
                int iFloorModulo3 = MathUtils.floorModulo(i, SyncConfiguration.DEFAULT_FREQUENCY);
                if (iFloorModulo3 == 0 && plainTime.nano == 0) {
                    return i > 0 ? PlainTime.MAX : PlainTime.MIN;
                }
                return withValue(plainTime, Integer.valueOf(iFloorModulo3), false);
            }
            throw new UnsupportedOperationException(this.element.name());
        }

        private static boolean isAM(PlainTime plainTime) {
            return plainTime.hour < 12 || plainTime.hour == 24;
        }
    }

    private static class LongElementRule implements ElementRule {
        private final ChronoElement element;
        private final long max;
        private final long min;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        LongElementRule(ChronoElement chronoElement, long j, long j2) {
            this.element = chronoElement;
            this.min = j;
            this.max = j2;
        }

        @Override // net.time4j.engine.ElementRule
        public Long getValue(PlainTime plainTime) {
            return Long.valueOf(this.element == PlainTime.MICRO_OF_DAY ? plainTime.getNanoOfDay() / 1000 : plainTime.getNanoOfDay());
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, Long l, boolean z) {
            if (l == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            if (z) {
                return withValueInLenientMode(plainTime, l.longValue());
            }
            if (!isValid(plainTime, l)) {
                throw new IllegalArgumentException("Value out of range: " + l);
            }
            long jLongValue = l.longValue();
            return this.element == PlainTime.MICRO_OF_DAY ? PlainTime.createFromMicros(jLongValue, plainTime.nano % 1000) : PlainTime.createFromNanos(jLongValue);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, Long l) {
            if (l == null) {
                return false;
            }
            if (this.element == PlainTime.MICRO_OF_DAY && l.longValue() == this.max) {
                return plainTime.nano % 1000 == 0;
            }
            return this.min <= l.longValue() && l.longValue() <= this.max;
        }

        @Override // net.time4j.engine.ElementRule
        public Long getMinimum(PlainTime plainTime) {
            return Long.valueOf(this.min);
        }

        @Override // net.time4j.engine.ElementRule
        public Long getMaximum(PlainTime plainTime) {
            if (this.element == PlainTime.MICRO_OF_DAY && plainTime.nano % 1000 != 0) {
                return Long.valueOf(this.max - 1);
            }
            return Long.valueOf(this.max);
        }

        private PlainTime withValueInLenientMode(PlainTime plainTime, long j) {
            if (this.element == PlainTime.MICRO_OF_DAY) {
                long jFloorMod = PlainTime.floorMod(j, 86400000000L);
                int i = plainTime.nano % 1000;
                if (jFloorMod != 0 || i != 0 || j <= 0) {
                    return PlainTime.createFromMicros(jFloorMod, i);
                }
                return PlainTime.MAX;
            }
            long jFloorMod2 = PlainTime.floorMod(j, 86400000000000L);
            if (jFloorMod2 != 0 || j <= 0) {
                return PlainTime.createFromNanos(jFloorMod2);
            }
            return PlainTime.MAX;
        }
    }

    private static class BigDecimalElementRule implements ElementRule {
        private final ChronoElement element;
        private final BigDecimal max;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        BigDecimalElementRule(ChronoElement chronoElement, BigDecimal bigDecimal) {
            this.element = chronoElement;
            this.max = bigDecimal;
        }

        @Override // net.time4j.engine.ElementRule
        public BigDecimal getValue(PlainTime plainTime) {
            BigDecimal bigDecimalAdd;
            ChronoElement chronoElement = this.element;
            if (chronoElement == PlainTime.DECIMAL_HOUR) {
                if (!plainTime.equals(PlainTime.MIN)) {
                    if (plainTime.hour == 24) {
                        return PlainTime.DECIMAL_24_0;
                    }
                    bigDecimalAdd = BigDecimal.valueOf(plainTime.hour).add(div(BigDecimal.valueOf(plainTime.minute), PlainTime.DECIMAL_60)).add(div(BigDecimal.valueOf(plainTime.second), PlainTime.DECIMAL_3600)).add(div(BigDecimal.valueOf(plainTime.nano), PlainTime.DECIMAL_3600.multiply(PlainTime.DECIMAL_MRD)));
                } else {
                    return BigDecimal.ZERO;
                }
            } else if (chronoElement == PlainTime.DECIMAL_MINUTE) {
                if (plainTime.isFullHour()) {
                    return BigDecimal.ZERO;
                }
                bigDecimalAdd = BigDecimal.valueOf(plainTime.minute).add(div(BigDecimal.valueOf(plainTime.second), PlainTime.DECIMAL_60)).add(div(BigDecimal.valueOf(plainTime.nano), PlainTime.DECIMAL_60.multiply(PlainTime.DECIMAL_MRD)));
            } else if (chronoElement == PlainTime.DECIMAL_SECOND) {
                if (!plainTime.isFullMinute()) {
                    bigDecimalAdd = BigDecimal.valueOf(plainTime.second).add(div(BigDecimal.valueOf(plainTime.nano), PlainTime.DECIMAL_MRD));
                } else {
                    return BigDecimal.ZERO;
                }
            } else {
                throw new UnsupportedOperationException(this.element.name());
            }
            return PlainTime$BigDecimalElementRule$$ExternalSyntheticBackportWithForwarding0.m(bigDecimalAdd.setScale(15, RoundingMode.FLOOR));
        }

        @Override // net.time4j.engine.ElementRule
        public PlainTime withValue(PlainTime plainTime, BigDecimal bigDecimal, boolean z) {
            int iFloorModulo;
            int iIntValue;
            long jLongValueExact;
            int iIntValue2;
            int nano;
            int iFloorModulo2;
            int iFloorModulo3;
            if (bigDecimal == null) {
                throw new IllegalArgumentException("Missing element value.");
            }
            ChronoElement chronoElement = this.element;
            if (chronoElement == PlainTime.DECIMAL_HOUR) {
                RoundingMode roundingMode = RoundingMode.FLOOR;
                BigDecimal scale = bigDecimal.setScale(0, roundingMode);
                BigDecimal bigDecimalMultiply = bigDecimal.subtract(scale).multiply(PlainTime.DECIMAL_60);
                BigDecimal scale2 = bigDecimalMultiply.setScale(0, roundingMode);
                BigDecimal bigDecimalMultiply2 = bigDecimalMultiply.subtract(scale2).multiply(PlainTime.DECIMAL_60);
                BigDecimal scale3 = bigDecimalMultiply2.setScale(0, roundingMode);
                jLongValueExact = scale.longValueExact();
                iIntValue2 = scale2.intValue();
                iIntValue = scale3.intValue();
                nano = toNano(bigDecimalMultiply2.subtract(scale3));
            } else if (chronoElement == PlainTime.DECIMAL_MINUTE) {
                RoundingMode roundingMode2 = RoundingMode.FLOOR;
                BigDecimal scale4 = bigDecimal.setScale(0, roundingMode2);
                BigDecimal bigDecimalMultiply3 = bigDecimal.subtract(scale4).multiply(PlainTime.DECIMAL_60);
                BigDecimal scale5 = bigDecimalMultiply3.setScale(0, roundingMode2);
                iIntValue = scale5.intValue();
                int nano2 = toNano(bigDecimalMultiply3.subtract(scale5));
                long jLongValueExact2 = scale4.longValueExact();
                long jFloorDivide = plainTime.hour;
                if (!z) {
                    PlainTime.checkMinute(jLongValueExact2);
                    iFloorModulo2 = (int) jLongValueExact2;
                } else {
                    jFloorDivide += MathUtils.floorDivide(jLongValueExact2, 60);
                    iFloorModulo2 = MathUtils.floorModulo(jLongValueExact2, 60);
                }
                jLongValueExact = jFloorDivide;
                iIntValue2 = iFloorModulo2;
                nano = nano2;
            } else if (chronoElement == PlainTime.DECIMAL_SECOND) {
                BigDecimal scale6 = bigDecimal.setScale(0, RoundingMode.FLOOR);
                int nano3 = toNano(bigDecimal.subtract(scale6));
                long jLongValueExact3 = scale6.longValueExact();
                long jFloorDivide2 = plainTime.hour;
                int iFloorModulo4 = plainTime.minute;
                if (!z) {
                    PlainTime.checkSecond(jLongValueExact3);
                    iFloorModulo = (int) jLongValueExact3;
                } else {
                    iFloorModulo = MathUtils.floorModulo(jLongValueExact3, 60);
                    long jFloorDivide3 = ((long) iFloorModulo4) + MathUtils.floorDivide(jLongValueExact3, 60);
                    jFloorDivide2 += MathUtils.floorDivide(jFloorDivide3, 60);
                    iFloorModulo4 = MathUtils.floorModulo(jFloorDivide3, 60);
                }
                iIntValue = iFloorModulo;
                jLongValueExact = jFloorDivide2;
                iIntValue2 = iFloorModulo4;
                nano = nano3;
            } else {
                throw new UnsupportedOperationException(this.element.name());
            }
            if (z) {
                iFloorModulo3 = MathUtils.floorModulo(jLongValueExact, 24);
                if (jLongValueExact > 0 && (iFloorModulo3 | iIntValue2 | iIntValue | nano) == 0) {
                    return PlainTime.MAX;
                }
            } else {
                if (jLongValueExact < 0 || jLongValueExact > 24) {
                    throw new IllegalArgumentException("Value out of range: " + bigDecimal);
                }
                iFloorModulo3 = (int) jLongValueExact;
            }
            return PlainTime.of(iFloorModulo3, iIntValue2, iIntValue, nano);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(PlainTime plainTime, BigDecimal bigDecimal) {
            ChronoElement chronoElement;
            if (bigDecimal == null) {
                return false;
            }
            if (plainTime.hour == 24 && ((chronoElement = this.element) == PlainTime.DECIMAL_MINUTE || chronoElement == PlainTime.DECIMAL_SECOND)) {
                return BigDecimal.ZERO.compareTo(bigDecimal) == 0;
            }
            return BigDecimal.ZERO.compareTo(bigDecimal) <= 0 && this.max.compareTo(bigDecimal) >= 0;
        }

        @Override // net.time4j.engine.ElementRule
        public BigDecimal getMinimum(PlainTime plainTime) {
            return BigDecimal.ZERO;
        }

        @Override // net.time4j.engine.ElementRule
        public BigDecimal getMaximum(PlainTime plainTime) {
            ChronoElement chronoElement;
            if (plainTime.hour == 24 && ((chronoElement = this.element) == PlainTime.DECIMAL_MINUTE || chronoElement == PlainTime.DECIMAL_SECOND)) {
                return BigDecimal.ZERO;
            }
            return this.max;
        }

        private static BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.divide(bigDecimal2, 16, RoundingMode.FLOOR);
        }

        private static int toNano(BigDecimal bigDecimal) {
            return Math.min(999999999, bigDecimal.movePointRight(9).setScale(0, RoundingMode.HALF_UP).intValue());
        }
    }

    private static class Merger implements ChronoMerger {
        private Merger() {
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(PlainTime plainTime, AttributeQuery attributeQuery) {
            return plainTime;
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
            return CalendarText.patternForTime(DisplayMode.ofStyle(displayStyle.getStyleValue()), locale);
        }

        @Override // net.time4j.engine.ChronoMerger
        public PlainTime createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            if (chronoEntity instanceof UnixTime) {
                return ((PlainTimestamp) PlainTimestamp.axis().createFrom(chronoEntity, attributeQuery, z, z2)).getWallTime();
            }
            ChronoElement chronoElement = PlainTime.WALL_TIME;
            if (chronoEntity.contains(chronoElement)) {
                return (PlainTime) chronoEntity.get(chronoElement);
            }
            ZonalElement zonalElement = PlainTime.DECIMAL_HOUR;
            if (chronoEntity.contains(zonalElement)) {
                return PlainTime.of((BigDecimal) chronoEntity.get(zonalElement));
            }
            int hour = chronoEntity.getInt(PlainTime.HOUR_FROM_0_TO_24);
            if (hour == Integer.MIN_VALUE) {
                hour = readHour(chronoEntity);
                if (hour == Integer.MIN_VALUE) {
                    return readSpecialCases(chronoEntity);
                }
                if (hour == -1 || hour == -2) {
                    if (!z) {
                        flagValidationError(chronoEntity, "Clock hour cannot be zero.");
                        return null;
                    }
                    hour = hour == -1 ? 0 : 12;
                } else if (hour == 24 && !z) {
                    flagValidationError(chronoEntity, "Time 24:00 not allowed, use lax mode or element HOUR_FROM_0_TO_24 instead.");
                    return null;
                }
            }
            ZonalElement zonalElement2 = PlainTime.DECIMAL_MINUTE;
            if (chronoEntity.contains(zonalElement2)) {
                return (PlainTime) PlainTime.M_DECIMAL_RULE.withValue(PlainTime.of(hour), chronoEntity.get(zonalElement2), false);
            }
            int i = chronoEntity.getInt(PlainTime.MINUTE_OF_HOUR);
            if (i == Integer.MIN_VALUE) {
                i = 0;
            }
            ZonalElement zonalElement3 = PlainTime.DECIMAL_SECOND;
            if (chronoEntity.contains(zonalElement3)) {
                return (PlainTime) PlainTime.S_DECIMAL_RULE.withValue(PlainTime.of(hour, i), chronoEntity.get(zonalElement3), false);
            }
            int i2 = chronoEntity.getInt(PlainTime.SECOND_OF_MINUTE);
            if (i2 == Integer.MIN_VALUE) {
                i2 = 0;
            }
            int iSafeMultiply = chronoEntity.getInt(PlainTime.NANO_OF_SECOND);
            if (iSafeMultiply == Integer.MIN_VALUE) {
                int i3 = chronoEntity.getInt(PlainTime.MICRO_OF_SECOND);
                if (i3 == Integer.MIN_VALUE) {
                    int i4 = chronoEntity.getInt(PlainTime.MILLI_OF_SECOND);
                    iSafeMultiply = i4 == Integer.MIN_VALUE ? 0 : MathUtils.safeMultiply(i4, 1000000);
                } else {
                    iSafeMultiply = MathUtils.safeMultiply(i3, 1000);
                }
            }
            if (z) {
                long jSafeAdd = MathUtils.safeAdd(MathUtils.safeMultiply(MathUtils.safeAdd(MathUtils.safeAdd(MathUtils.safeMultiply(hour, 3600L), MathUtils.safeMultiply(i, 60L)), i2), 1000000000L), iSafeMultiply);
                long jFloorMod = PlainTime.floorMod(jSafeAdd, 86400000000000L);
                long jFloorDiv = PlainTime.floorDiv(jSafeAdd, 86400000000000L);
                if (jFloorDiv != 0) {
                    ChronoElement chronoElement2 = LongElement.DAY_OVERFLOW;
                    if (chronoEntity.isValid(chronoElement2, jFloorDiv)) {
                        chronoEntity.with(chronoElement2, jFloorDiv);
                    }
                }
                if (jFloorMod != 0 || jFloorDiv <= 0) {
                    return PlainTime.createFromNanos(jFloorMod);
                }
                return PlainTime.MAX;
            }
            if ((hour >= 0 && i >= 0 && i2 >= 0 && iSafeMultiply >= 0 && hour == 24 && (i | i2 | iSafeMultiply) == 0) || (hour < 24 && i <= 59 && i2 <= 59 && iSafeMultiply <= 1000000000)) {
                return PlainTime.of(hour, i, i2, iSafeMultiply, false);
            }
            flagValidationError(chronoEntity, "Time component out of range.");
            return null;
        }

        private static int readHour(ChronoEntity chronoEntity) {
            int i = chronoEntity.getInt(PlainTime.DIGITAL_HOUR_OF_DAY);
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            int i2 = chronoEntity.getInt(PlainTime.CLOCK_HOUR_OF_DAY);
            if (i2 == 0) {
                return -1;
            }
            if (i2 == 24) {
                return 0;
            }
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            ZonalElement zonalElement = PlainTime.AM_PM_OF_DAY;
            if (chronoEntity.contains(zonalElement)) {
                Meridiem meridiem = (Meridiem) chronoEntity.get(zonalElement);
                int i3 = chronoEntity.getInt(PlainTime.CLOCK_HOUR_OF_AMPM);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 == 0) {
                        return meridiem == Meridiem.AM ? -1 : -2;
                    }
                    int i4 = i3 != 12 ? i3 : 0;
                    return meridiem == Meridiem.AM ? i4 : i4 + 12;
                }
                int i5 = chronoEntity.getInt(PlainTime.DIGITAL_HOUR_OF_AMPM);
                if (i5 != Integer.MIN_VALUE) {
                    return meridiem == Meridiem.AM ? i5 : i5 + 12;
                }
            }
            return LinearLayoutManager.INVALID_OFFSET;
        }

        private static PlainTime readSpecialCases(ChronoEntity chronoEntity) {
            int iIntValue;
            int iIntValue2;
            ProportionalElement proportionalElement = PlainTime.NANO_OF_DAY;
            if (chronoEntity.contains(proportionalElement)) {
                long jLongValue = ((Long) chronoEntity.get(proportionalElement)).longValue();
                if (jLongValue >= 0 && jLongValue <= 86400000000000L) {
                    return PlainTime.createFromNanos(jLongValue);
                }
                flagValidationError(chronoEntity, "NANO_OF_DAY out of range: " + jLongValue);
                return null;
            }
            ProportionalElement proportionalElement2 = PlainTime.MICRO_OF_DAY;
            int i = 0;
            if (chronoEntity.contains(proportionalElement2)) {
                ProportionalElement proportionalElement3 = PlainTime.NANO_OF_SECOND;
                return PlainTime.createFromMicros(((Long) chronoEntity.get(proportionalElement2)).longValue(), chronoEntity.contains(proportionalElement3) ? ((Integer) chronoEntity.get(proportionalElement3)).intValue() % 1000 : 0);
            }
            ProportionalElement proportionalElement4 = PlainTime.MILLI_OF_DAY;
            if (chronoEntity.contains(proportionalElement4)) {
                ProportionalElement proportionalElement5 = PlainTime.NANO_OF_SECOND;
                if (chronoEntity.contains(proportionalElement5)) {
                    int iIntValue3 = ((Integer) chronoEntity.get(proportionalElement5)).intValue();
                    if (iIntValue3 < 0 || iIntValue3 >= 1000000000) {
                        flagValidationError(chronoEntity, "NANO_OF_SECOND out of range: " + iIntValue3);
                        return null;
                    }
                    i = iIntValue3 % 1000000;
                } else {
                    ProportionalElement proportionalElement6 = PlainTime.MICRO_OF_SECOND;
                    if (chronoEntity.contains(proportionalElement6)) {
                        int iIntValue4 = ((Integer) chronoEntity.get(proportionalElement6)).intValue();
                        if (iIntValue4 < 0 || iIntValue4 >= 1000000) {
                            flagValidationError(chronoEntity, "MICRO_OF_SECOND out of range: " + iIntValue4);
                            return null;
                        }
                        i = iIntValue4 % 1000;
                    }
                }
                int iIntValue5 = ((Integer) chronoEntity.get(proportionalElement4)).intValue();
                if (iIntValue5 >= 0 && iIntValue5 <= 86400000) {
                    return PlainTime.createFromMillis(iIntValue5, i);
                }
                flagValidationError(chronoEntity, "MILLI_OF_DAY out of range: " + iIntValue5);
                return null;
            }
            ProportionalElement proportionalElement7 = PlainTime.SECOND_OF_DAY;
            if (chronoEntity.contains(proportionalElement7)) {
                ProportionalElement proportionalElement8 = PlainTime.NANO_OF_SECOND;
                if (chronoEntity.contains(proportionalElement8)) {
                    iIntValue2 = ((Integer) chronoEntity.get(proportionalElement8)).intValue();
                } else {
                    ProportionalElement proportionalElement9 = PlainTime.MICRO_OF_SECOND;
                    if (chronoEntity.contains(proportionalElement9)) {
                        iIntValue2 = ((Integer) chronoEntity.get(proportionalElement9)).intValue() * 1000;
                    } else {
                        ProportionalElement proportionalElement10 = PlainTime.MILLI_OF_SECOND;
                        iIntValue2 = chronoEntity.contains(proportionalElement10) ? ((Integer) chronoEntity.get(proportionalElement10)).intValue() * 1000000 : 0;
                    }
                }
                return (PlainTime) PlainTime.of(0, 0, 0, iIntValue2).with(proportionalElement7, chronoEntity.get(proportionalElement7));
            }
            ProportionalElement proportionalElement11 = PlainTime.MINUTE_OF_DAY;
            if (!chronoEntity.contains(proportionalElement11)) {
                return null;
            }
            ProportionalElement proportionalElement12 = PlainTime.NANO_OF_SECOND;
            if (chronoEntity.contains(proportionalElement12)) {
                iIntValue = ((Integer) chronoEntity.get(proportionalElement12)).intValue();
            } else {
                ProportionalElement proportionalElement13 = PlainTime.MICRO_OF_SECOND;
                if (chronoEntity.contains(proportionalElement13)) {
                    iIntValue = ((Integer) chronoEntity.get(proportionalElement13)).intValue() * 1000;
                } else {
                    ProportionalElement proportionalElement14 = PlainTime.MILLI_OF_SECOND;
                    iIntValue = chronoEntity.contains(proportionalElement14) ? ((Integer) chronoEntity.get(proportionalElement14)).intValue() * 1000000 : 0;
                }
            }
            ProportionalElement proportionalElement15 = PlainTime.SECOND_OF_MINUTE;
            return (PlainTime) PlainTime.of(0, 0, chronoEntity.contains(proportionalElement15) ? ((Integer) chronoEntity.get(proportionalElement15)).intValue() : 0, iIntValue).with(proportionalElement11, chronoEntity.get(proportionalElement11));
        }

        private static void flagValidationError(ChronoEntity chronoEntity, String str) {
            ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
            if (chronoEntity.isValid(validationElement, str)) {
                chronoEntity.with(validationElement, str);
            }
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }
    }
}
