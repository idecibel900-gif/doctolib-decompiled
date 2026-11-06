package net.time4j;

import com.amazon.a.a.o.c.a.b;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.time4j.base.MathUtils;
import net.time4j.engine.AbstractDuration;
import net.time4j.engine.AbstractMetric;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimeSpan;
import net.time4j.format.TimeSpanFormatter;

/* JADX INFO: loaded from: classes5.dex */
public final class Duration extends AbstractDuration implements Serializable {
    private static final Formatter CF_BAS_CAL;
    private static final Formatter CF_BAS_ORD;
    private static final Formatter CF_EXT_CAL;
    private static final Formatter CF_EXT_ORD;
    private static final TimeMetric CLOCK_METRIC;
    private static final char ISO_DECIMAL_SEPARATOR;
    private static final Comparator ITEM_COMPARATOR;
    public static Normalizer STD_CALENDAR_PERIOD = null;
    public static Normalizer STD_CLOCK_PERIOD = null;
    public static Normalizer STD_PERIOD = null;
    private static final Formatter TF_BAS;
    private static final Formatter TF_EXT;
    private static final TimeMetric WEEK_BASED_METRIC;
    private static final TimeMetric YMD_METRIC;
    private static final Duration ZERO;
    private static final long serialVersionUID = -6321211763598951499L;
    private final transient List items;
    private final transient boolean negative;

    /* JADX INFO: renamed from: net.time4j.Duration$1, reason: invalid class name */
    abstract class AnonymousClass1 implements Comparator {
    }

    static {
        ISO_DECIMAL_SEPARATOR = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? b.a : ',';
        ZERO = new Duration();
        CF_EXT_CAL = createAlternativeDateFormat(true, false);
        CF_EXT_ORD = createAlternativeDateFormat(true, true);
        CF_BAS_CAL = createAlternativeDateFormat(false, false);
        CF_BAS_ORD = createAlternativeDateFormat(false, true);
        TF_EXT = createAlternativeTimeFormat(true);
        TF_BAS = createAlternativeTimeFormat(false);
        ITEM_COMPARATOR = StdNormalizer.comparator();
        STD_PERIOD = StdNormalizer.ofMixedUnits();
        STD_CALENDAR_PERIOD = StdNormalizer.ofCalendarUnits();
        STD_CLOCK_PERIOD = StdNormalizer.ofClockUnits();
        CalendarUnit calendarUnit = CalendarUnit.YEARS;
        CalendarUnit calendarUnit2 = CalendarUnit.MONTHS;
        CalendarUnit calendarUnit3 = CalendarUnit.DAYS;
        YMD_METRIC = in(calendarUnit, calendarUnit2, calendarUnit3);
        CLOCK_METRIC = in(ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS, ClockUnit.NANOS);
        WEEK_BASED_METRIC = in(CalendarUnit.weekBasedYears(), CalendarUnit.WEEKS, calendarUnit3);
    }

    Duration(List list, boolean z) {
        boolean zIsEmpty = list.isEmpty();
        if (zIsEmpty) {
            this.items = Collections.EMPTY_LIST;
        } else {
            Collections.sort(list, ITEM_COMPARATOR);
            this.items = Collections.unmodifiableList(list);
        }
        this.negative = !zIsEmpty && z;
    }

    private Duration() {
        this.items = Collections.EMPTY_LIST;
        this.negative = false;
    }

    public static Duration ofZero() {
        return ZERO;
    }

    public static TimeMetric in(IsoUnit... isoUnitArr) {
        return new Metric(isoUnitArr, null);
    }

    @Override // net.time4j.engine.TimeSpan
    public List getTotalLength() {
        return this.items;
    }

    public boolean isNegative() {
        return this.negative;
    }

    public boolean contains(IsoUnit isoUnit) {
        if (isoUnit == null) {
            return false;
        }
        boolean zIsFractionUnit = isFractionUnit(isoUnit);
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            TimeSpan.Item item = (TimeSpan.Item) this.items.get(i);
            IsoUnit isoUnit2 = (IsoUnit) item.getUnit();
            if (isoUnit2.equals(isoUnit) || (zIsFractionUnit && isFractionUnit(isoUnit2))) {
                if (item.getAmount() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) Duration.class.cast(obj);
            if (this.negative == duration.negative && getTotalLength().equals(duration.getTotalLength())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = getTotalLength().hashCode();
        if (this.negative) {
            return 0;
        }
        return iHashCode;
    }

    public String toString() {
        return toString(0);
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0148  */
    /* JADX WARN: Code duplicated, block: B:82:0x014d  */
    /* JADX WARN: Code duplicated, block: B:83:0x015c  */
    private String toString(int i) {
        boolean z;
        if (i == 1 && isNegative()) {
            throw new ChronoException("Negative sign not allowed in ISO-8601.");
        }
        if (isEmpty()) {
            return "PT0S";
        }
        boolean z2 = i == 2;
        StringBuilder sb = new StringBuilder();
        if (isNegative()) {
            sb.append('-');
        }
        sb.append('P');
        int iCount = count();
        long jSafeMultiply = 0;
        int i2 = 0;
        long j = 0;
        boolean z3 = false;
        long j2 = 0;
        boolean z4 = false;
        while (i2 < iCount) {
            TimeSpan.Item item = (TimeSpan.Item) getTotalLength().get(i2);
            IsoUnit isoUnit = (IsoUnit) item.getUnit();
            if (!z3 && !isoUnit.isCalendrical()) {
                sb.append('T');
                z3 = true;
            }
            boolean z5 = z2;
            long amount = item.getAmount();
            int i3 = i2;
            char symbol = isoUnit.getSymbol();
            long j3 = j;
            if (isoUnit == Weekcycle.YEARS) {
                z4 = true;
            }
            if (symbol <= '0' || symbol > '9') {
                if (symbol == 'S') {
                    j2 = amount;
                } else if ((z5 || i == 1) && symbol != 'H') {
                    if (symbol == 'I') {
                        sb.append(MathUtils.safeMultiply(amount, 1000L));
                    } else if (symbol == 'M') {
                        sb.append(amount);
                        if (symbol == 0) {
                            sb.append('{');
                            sb.append(isoUnit);
                            sb.append('}');
                        } else {
                            sb.append(symbol);
                        }
                    } else {
                        if (symbol == 'Q') {
                            sb.append(MathUtils.safeMultiply(amount, 3L));
                            symbol = 'M';
                        } else if (symbol == 'W') {
                            if (iCount != 1) {
                                jSafeMultiply = MathUtils.safeMultiply(amount, 7L);
                                if (!contains(CalendarUnit.DAYS)) {
                                    sb.append(jSafeMultiply);
                                    jSafeMultiply = 0;
                                }
                            } else if (z5) {
                                sb.append(MathUtils.safeMultiply(amount, 7L));
                            } else {
                                sb.append(amount);
                            }
                            symbol = 'D';
                        } else if (symbol == 'Y') {
                            sb.append(amount);
                        } else {
                            switch (symbol) {
                                case 'C':
                                    sb.append(MathUtils.safeMultiply(amount, 100L));
                                    break;
                                case 'D':
                                    if (jSafeMultiply != 0) {
                                        amount = MathUtils.safeAdd(amount, jSafeMultiply);
                                        jSafeMultiply = 0;
                                    }
                                    sb.append(amount);
                                    break;
                                case 'E':
                                    sb.append(MathUtils.safeMultiply(amount, 10L));
                                    break;
                                default:
                                    throw new ChronoException("Special units cannot be output in " + (z5 ? "XML" : "ISO") + "-mode: " + toString(0));
                            }
                        }
                        if (symbol == 0) {
                            sb.append('{');
                            sb.append(isoUnit);
                            sb.append('}');
                        } else {
                            sb.append(symbol);
                        }
                    }
                    symbol = 'Y';
                    if (symbol == 0) {
                        sb.append('{');
                        sb.append(isoUnit);
                        sb.append('}');
                    } else {
                        sb.append(symbol);
                    }
                } else {
                    sb.append(amount);
                    if (symbol == 0) {
                        sb.append('{');
                        sb.append(isoUnit);
                        sb.append('}');
                    } else {
                        sb.append(symbol);
                    }
                }
                j = j3;
            } else {
                j = amount;
            }
            i2 = i3 + 1;
            z2 = z5;
        }
        boolean z6 = z2;
        long j4 = j;
        if (j4 != 0) {
            sb.append(MathUtils.safeAdd(j2, j4 / 1000000000));
            sb.append(z6 ? b.a : ISO_DECIMAL_SEPARATOR);
            String strValueOf = String.valueOf(j4 % 1000000000);
            int length = 9 - strValueOf.length();
            for (int i4 = 0; i4 < length; i4++) {
                sb.append('0');
            }
            sb.append(strValueOf);
            sb.append('S');
        } else if (j2 != 0) {
            sb.append(j2);
            sb.append('S');
        }
        if (z4) {
            boolean z7 = !z3;
            if (z3) {
                z = z7;
            } else {
                int iCount2 = count();
                int i5 = 0;
                while (true) {
                    if (i5 >= iCount2) {
                        z = z7;
                    } else {
                        Object unit = ((TimeSpan.Item) getTotalLength().get(i5)).getUnit();
                        if (unit == Weekcycle.YEARS || unit == CalendarUnit.WEEKS || unit == CalendarUnit.DAYS) {
                            i5++;
                        } else {
                            z = false;
                        }
                    }
                }
            }
            if (!z) {
                int iIndexOf = sb.indexOf("Y");
                sb.replace(iIndexOf, iIndexOf + 1, "{WEEK_BASED_YEARS}");
            }
        }
        return sb.toString();
    }

    private int count() {
        return getTotalLength().size();
    }

    private boolean isFractionUnit(IsoUnit isoUnit) {
        char symbol = isoUnit.getSymbol();
        return symbol >= '1' && symbol <= '9';
    }

    private static Formatter createAlternativeDateFormat(boolean z, boolean z2) {
        String str;
        if (z) {
            if (z2) {
                str = "YYYY-DDD";
            } else {
                str = "YYYY-MM-DD";
            }
        } else if (z2) {
            str = "YYYYDDD";
        } else {
            str = "YYYYMMDD";
        }
        return Formatter.ofPattern(CalendarUnit.class, str);
    }

    private static Formatter createAlternativeTimeFormat(boolean z) {
        return Formatter.ofPattern(ClockUnit.class, z ? "hh[:mm[:ss[,fffffffff]]]" : "hh[mm[ss[,fffffffff]]]");
    }

    private Object writeReplace() {
        return new SPX(this, 6);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static final class Formatter extends TimeSpanFormatter {
        private Formatter(Class cls, String str) {
            super(cls, str);
        }

        public static Formatter ofPattern(Class cls, String str) {
            return new Formatter(cls, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.time4j.format.TimeSpanFormatter
        public IsoUnit getUnit(char c) {
            if (c == 'I') {
                return CalendarUnit.MILLENNIA;
            }
            if (c == 'M') {
                return CalendarUnit.MONTHS;
            }
            if (c == 'Q') {
                return CalendarUnit.QUARTERS;
            }
            if (c == 'W') {
                return CalendarUnit.WEEKS;
            }
            if (c == 'Y') {
                return CalendarUnit.YEARS;
            }
            if (c == 'f') {
                return ClockUnit.NANOS;
            }
            if (c == 'h') {
                return ClockUnit.HOURS;
            }
            if (c == 'm') {
                return ClockUnit.MINUTES;
            }
            if (c != 's') {
                switch (c) {
                    case 'C':
                        return CalendarUnit.CENTURIES;
                    case 'D':
                        return CalendarUnit.DAYS;
                    case 'E':
                        return CalendarUnit.DECADES;
                    default:
                        throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
                }
            }
            return ClockUnit.SECONDS;
        }
    }

    private static class Metric extends AbstractMetric {
        /* synthetic */ Metric(IsoUnit[] isoUnitArr, AnonymousClass1 anonymousClass1) {
            this(isoUnitArr);
        }

        private Metric(IsoUnit... isoUnitArr) {
            super(isoUnitArr.length > 1, isoUnitArr);
        }
    }
}
