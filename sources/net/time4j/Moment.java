package net.time4j;

import io.didomi.ssl.config.app.SyncConfiguration;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FlagElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeLine;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.scale.LeapSecondEvent;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.OverlapResolver;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class Moment extends TimePoint implements UniversalTime {
    private static final TimeAxis ENGINE;
    public static final ChronoElement FRACTION;
    private static final Set HIGH_TIME_ELEMENTS;
    private static final Map LOW_TIME_ELEMENTS;
    private static final Moment MAX;
    private static final long MAX_LIMIT;
    private static final Moment MIN;
    private static final long MIN_LIMIT;
    private static final ChronoOperator NEXT_LS;
    public static final ChronoElement POSIX_TIME;
    public static final ChronoElement PRECISION;
    private static final Moment START_LS_CHECK;
    private static final Map UNIT_LENGTHS;
    public static final Moment UNIX_EPOCH;
    private static final long serialVersionUID = -3192884724477742274L;
    private final transient int fraction;
    private final transient long posixTime;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public Moment getContext() {
        return this;
    }

    /* synthetic */ Moment(int i, long j, AnonymousClass1 anonymousClass1) {
        this(i, j);
    }

    static {
        long mjd = GregorianMath.toMJD(-999999999, 1, 1);
        long mjd2 = GregorianMath.toMJD(999999999, 12, 31);
        EpochDays epochDays = EpochDays.UNIX;
        EpochDays epochDays2 = EpochDays.MODIFIED_JULIAN_DATE;
        long jTransform = epochDays.transform(mjd, epochDays2) * 86400;
        MIN_LIMIT = jTransform;
        long jTransform2 = (epochDays.transform(mjd2, epochDays2) * 86400) + 86399;
        MAX_LIMIT = jTransform2;
        TimeScale timeScale = TimeScale.POSIX;
        Moment moment = new Moment(jTransform, 0, timeScale);
        MIN = moment;
        Moment moment2 = new Moment(jTransform2, 999999999, timeScale);
        MAX = moment2;
        START_LS_CHECK = new Moment(63158400L, 0, timeScale);
        HashSet hashSet = new HashSet();
        hashSet.add(PlainTime.HOUR_FROM_0_TO_24);
        hashSet.add(PlainTime.DIGITAL_HOUR_OF_DAY);
        hashSet.add(PlainTime.DIGITAL_HOUR_OF_AMPM);
        hashSet.add(PlainTime.CLOCK_HOUR_OF_DAY);
        hashSet.add(PlainTime.CLOCK_HOUR_OF_AMPM);
        hashSet.add(PlainTime.AM_PM_OF_DAY);
        hashSet.add(PlainTime.MINUTE_OF_HOUR);
        hashSet.add(PlainTime.MINUTE_OF_DAY);
        HIGH_TIME_ELEMENTS = Collections.unmodifiableSet(hashSet);
        HashMap map = new HashMap();
        map.put(PlainTime.SECOND_OF_MINUTE, 1);
        map.put(PlainTime.SECOND_OF_DAY, 1);
        map.put(PlainTime.MILLI_OF_SECOND, 1000);
        map.put(PlainTime.MILLI_OF_DAY, 1000);
        map.put(PlainTime.MICRO_OF_SECOND, 1000000);
        map.put(PlainTime.MICRO_OF_DAY, 1000000);
        ProportionalElement proportionalElement = PlainTime.NANO_OF_SECOND;
        Integer numValueOf = Integer.valueOf(Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        map.put(proportionalElement, numValueOf);
        map.put(PlainTime.NANO_OF_DAY, numValueOf);
        LOW_TIME_ELEMENTS = Collections.unmodifiableMap(map);
        EnumMap enumMap = new EnumMap(TimeUnit.class);
        enumMap.put(TimeUnit.DAYS, Double.valueOf(86400.0d));
        enumMap.put(TimeUnit.HOURS, Double.valueOf(3600.0d));
        enumMap.put(TimeUnit.MINUTES, Double.valueOf(60.0d));
        enumMap.put(TimeUnit.SECONDS, Double.valueOf(1.0d));
        enumMap.put(TimeUnit.MILLISECONDS, Double.valueOf(0.001d));
        enumMap.put(TimeUnit.MICROSECONDS, Double.valueOf(1.0E-6d));
        enumMap.put(TimeUnit.NANOSECONDS, Double.valueOf(1.0E-9d));
        UNIT_LENGTHS = Collections.unmodifiableMap(enumMap);
        AnonymousClass1 anonymousClass1 = null;
        TimeAxis.Builder up = TimeAxis.Builder.setUp(TimeUnit.class, Moment.class, new Merger(anonymousClass1), moment, moment2);
        for (TimeUnit timeUnit : TimeUnit.values()) {
            TimeUnitRule timeUnitRule = new TimeUnitRule(timeUnit);
            Map map2 = UNIT_LENGTHS;
            up.appendUnit(timeUnit, timeUnitRule, ((Double) map2.get(timeUnit)).doubleValue(), map2.keySet());
        }
        LongElement longElement = LongElement.POSIX_TIME;
        up.appendElement(longElement, longElement, TimeUnit.SECONDS);
        IntElement intElement = IntElement.FRACTION;
        up.appendElement(intElement, intElement, TimeUnit.NANOSECONDS);
        ChronoElement chronoElement = PrecisionElement.TIME_PRECISION;
        up.appendElement(chronoElement, (ElementRule) new PrecisionRule(anonymousClass1));
        ENGINE = up.withTimeLine(new GlobalTimeLine(anonymousClass1)).build();
        UNIX_EPOCH = new Moment(0L, 0, TimeScale.POSIX);
        POSIX_TIME = longElement;
        FRACTION = intElement;
        PRECISION = chronoElement;
        NEXT_LS = new NextLS(anonymousClass1);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x017b  */
    private Moment(long j, int i, TimeScale timeScale) {
        long j2;
        long jFloor;
        int nanos;
        long jEnhance;
        long jSafeSubtract = j;
        int iSafeSubtract = i;
        if (timeScale == TimeScale.POSIX) {
            this.posixTime = jSafeSubtract;
            this.fraction = iSafeSubtract;
        } else {
            LeapSeconds leapSeconds = LeapSeconds.getInstance();
            if (leapSeconds.isEnabled()) {
                if (timeScale == TimeScale.UTC) {
                    j2 = 0;
                } else {
                    j2 = 0;
                    if (timeScale == TimeScale.TAI) {
                        if (jSafeSubtract < 0) {
                            throw new IllegalArgumentException("TAI not supported before 1958-01-01: " + jSafeSubtract);
                        }
                        if (jSafeSubtract < 441763200) {
                            long jSafeAdd = MathUtils.safeAdd(jSafeSubtract, -441763168L);
                            int iSafeAdd = MathUtils.safeAdd(iSafeSubtract, 184000000);
                            if (iSafeAdd >= 1000000000) {
                                jSafeAdd = MathUtils.safeAdd(jSafeAdd, 1L);
                                iSafeAdd = MathUtils.safeSubtract(iSafeAdd, Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
                            }
                            double d = jSafeAdd + (((double) iSafeAdd) / 1.0E9d);
                            double dDeltaT = d - TimeScale.deltaT(PlainDate.of(MathUtils.floorDivide((long) (d - 42.184d), SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UTC));
                            jFloor = (long) Math.floor(dDeltaT);
                            nanos = toNanos(dDeltaT, jFloor);
                        } else {
                            nanos = iSafeSubtract;
                            jFloor = MathUtils.safeSubtract(jSafeSubtract, 441763210L);
                        }
                    } else if (timeScale == TimeScale.GPS) {
                        long jSafeAdd2 = MathUtils.safeAdd(jSafeSubtract, 252892809L);
                        if (jSafeAdd2 < 252892809) {
                            throw new IllegalArgumentException("GPS not supported before 1980-01-06: " + jSafeSubtract);
                        }
                        nanos = iSafeSubtract;
                        jFloor = jSafeAdd2;
                    } else if (timeScale == TimeScale.TT) {
                        if (jSafeSubtract < 42 || (jSafeSubtract == 42 && iSafeSubtract < 184000000)) {
                            double d2 = jSafeSubtract + (((double) iSafeSubtract) / 1.0E9d);
                            double dDeltaT2 = d2 - TimeScale.deltaT(PlainDate.of(MathUtils.floorDivide((long) (d2 - 42.184d), SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UTC));
                            jFloor = (long) Math.floor(dDeltaT2);
                            nanos = toNanos(dDeltaT2, jFloor);
                        } else {
                            jSafeSubtract = MathUtils.safeSubtract(jSafeSubtract, 42L);
                            iSafeSubtract = MathUtils.safeSubtract(iSafeSubtract, 184000000);
                            if (iSafeSubtract < 0) {
                                jSafeSubtract = MathUtils.safeSubtract(jSafeSubtract, 1L);
                                iSafeSubtract = MathUtils.safeAdd(iSafeSubtract, Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
                            }
                        }
                    } else {
                        if (timeScale != TimeScale.UT) {
                            throw new UnsupportedOperationException("Not yet implemented: " + timeScale.name());
                        }
                        if (jSafeSubtract >= 0) {
                            double dDeltaT3 = ((jSafeSubtract + (((double) iSafeSubtract) / 1.0E9d)) + TimeScale.deltaT(PlainDate.of(MathUtils.floorDivide(jSafeSubtract, SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UTC))) - 42.184d;
                            jFloor = (long) Math.floor(dDeltaT3);
                            nanos = toNanos(dDeltaT3, jFloor);
                        }
                    }
                    long jStrip = leapSeconds.strip(jFloor);
                    jEnhance = jFloor - leapSeconds.enhance(jStrip);
                    this.posixTime = jStrip;
                    if (jEnhance != j2 || jStrip == MAX_LIMIT) {
                        this.fraction = nanos;
                    } else if (jEnhance == 1) {
                        this.fraction = 1073741824 | nanos;
                    } else {
                        throw new IllegalStateException("Cannot handle leap shift of " + jSafeSubtract + ".");
                    }
                    iSafeSubtract = nanos;
                }
                nanos = iSafeSubtract;
                jFloor = jSafeSubtract;
                long jStrip2 = leapSeconds.strip(jFloor);
                jEnhance = jFloor - leapSeconds.enhance(jStrip2);
                this.posixTime = jStrip2;
                if (jEnhance != j2) {
                    this.fraction = nanos;
                } else {
                    this.fraction = nanos;
                }
                iSafeSubtract = nanos;
            } else {
                throw new IllegalStateException("Leap seconds are not supported by configuration.");
            }
        }
        checkUnixTime(this.posixTime);
        checkFraction(iSafeSubtract);
    }

    private Moment(int i, long j) {
        checkUnixTime(j);
        this.posixTime = j;
        this.fraction = i;
    }

    public static Moment of(long j, TimeScale timeScale) {
        return of(j, 0, timeScale);
    }

    public static Moment of(long j, int i, TimeScale timeScale) {
        if (j == 0 && i == 0 && timeScale == TimeScale.POSIX) {
            return UNIX_EPOCH;
        }
        return new Moment(j, i, timeScale);
    }

    public static Moment from(UnixTime unixTime) {
        if (unixTime instanceof Moment) {
            return (Moment) Moment.class.cast(unixTime);
        }
        if ((unixTime instanceof UniversalTime) && LeapSeconds.getInstance().isEnabled()) {
            UniversalTime universalTime = (UniversalTime) UniversalTime.class.cast(unixTime);
            TimeScale timeScale = TimeScale.UTC;
            return of(universalTime.getElapsedTime(timeScale), universalTime.getNanosecond(timeScale), timeScale);
        }
        return of(unixTime.getPosixTime(), unixTime.getNanosecond(), TimeScale.POSIX);
    }

    @Override // net.time4j.base.UnixTime
    public long getPosixTime() {
        return this.posixTime;
    }

    @Override // net.time4j.scale.UniversalTime
    public long getElapsedTime(TimeScale timeScale) {
        long elapsedTimeUTC;
        int nanos;
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
                return this.posixTime;
            case 2:
                return getElapsedTimeUTC();
            case 3:
                if (getElapsedTimeUTC() < 0) {
                    double dDeltaT = TimeScale.deltaT(getDateUTC()) + (this.posixTime - 63072000) + (((double) getNanosecond()) / 1.0E9d);
                    long jFloor = (long) Math.floor(dDeltaT);
                    if (Double.compare(1.0E9d - ((dDeltaT - jFloor) * 1.0E9d), 1.0d) < 0) {
                        jFloor++;
                        nanos = 0;
                    } else {
                        nanos = toNanos(dDeltaT, jFloor);
                    }
                    elapsedTimeUTC = jFloor - (-441763168);
                    if (nanos - 184000000 < 0) {
                        elapsedTimeUTC = jFloor - (-441763167);
                    }
                } else {
                    elapsedTimeUTC = getElapsedTimeUTC() + 441763210;
                }
                if (elapsedTimeUTC >= 0) {
                    return elapsedTimeUTC;
                }
                throw new IllegalArgumentException("TAI not supported before 1958-01-01: " + this);
            case 4:
                long elapsedTimeUTC2 = getElapsedTimeUTC();
                if (LeapSeconds.getInstance().strip(elapsedTimeUTC2) < 315964800) {
                    throw new IllegalArgumentException("GPS not supported before 1980-01-06: " + this);
                }
                if (!LeapSeconds.getInstance().isEnabled()) {
                    elapsedTimeUTC2 += 9;
                }
                return elapsedTimeUTC2 - 252892809;
            case 5:
                if (this.posixTime < 63072000) {
                    double dDeltaT2 = TimeScale.deltaT(getDateUTC()) + (this.posixTime - 63072000) + (((double) getNanosecond()) / 1.0E9d);
                    long jFloor2 = (long) Math.floor(dDeltaT2);
                    return Double.compare(1.0E9d - ((dDeltaT2 - ((double) jFloor2)) * 1.0E9d), 1.0d) < 0 ? jFloor2 + 1 : jFloor2;
                }
                long elapsedTimeUTC3 = getElapsedTimeUTC();
                return getNanosecond() + 184000000 >= 1000000000 ? elapsedTimeUTC3 + 43 : 42 + elapsedTimeUTC3;
            case 6:
                long j = this.posixTime;
                return j < 63072000 ? j - 63072000 : (long) Math.floor(getModernUT());
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + timeScale);
        }
    }

    @Override // net.time4j.base.UnixTime
    public int getNanosecond() {
        return this.fraction & (-1073741825);
    }

    @Override // net.time4j.scale.UniversalTime
    public int getNanosecond(TimeScale timeScale) {
        long elapsedTimeUTC;
        int nanosecond;
        int nanos = 0;
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
            case 2:
                return getNanosecond();
            case 3:
                if (getElapsedTimeUTC() < 0) {
                    double dDeltaT = TimeScale.deltaT(getDateUTC()) + (this.posixTime - 63072000) + (((double) getNanosecond()) / 1.0E9d);
                    long jFloor = (long) Math.floor(dDeltaT);
                    if (Double.compare(1.0E9d - ((dDeltaT - jFloor) * 1.0E9d), 1.0d) < 0) {
                        jFloor++;
                    } else {
                        nanos = toNanos(dDeltaT, jFloor);
                    }
                    elapsedTimeUTC = jFloor - (-441763168);
                    nanosecond = nanos - 184000000;
                    if (nanosecond < 0) {
                        elapsedTimeUTC = jFloor - (-441763167);
                        nanosecond = nanos - (-816000000);
                    }
                } else {
                    elapsedTimeUTC = getElapsedTimeUTC() + 441763200;
                    nanosecond = getNanosecond();
                }
                if (elapsedTimeUTC >= 0) {
                    return nanosecond;
                }
                throw new IllegalArgumentException("TAI not supported before 1958-01-01: " + this);
            case 4:
                if (LeapSeconds.getInstance().strip(getElapsedTimeUTC()) < 315964800) {
                    throw new IllegalArgumentException("GPS not supported before 1980-01-06: " + this);
                }
                return getNanosecond();
            case 5:
                if (this.posixTime < 63072000) {
                    double dDeltaT2 = TimeScale.deltaT(getDateUTC()) + (this.posixTime - 63072000) + (((double) getNanosecond()) / 1.0E9d);
                    long jFloor2 = (long) Math.floor(dDeltaT2);
                    if (Double.compare(1.0E9d - ((dDeltaT2 - jFloor2) * 1.0E9d), 1.0d) < 0) {
                        return 0;
                    }
                    return toNanos(dDeltaT2, jFloor2);
                }
                int nanosecond2 = getNanosecond();
                int i = 184000000 + nanosecond2;
                return i >= 1000000000 ? nanosecond2 - 816000000 : i;
            case 6:
                if (this.posixTime < 63072000) {
                    return getNanosecond();
                }
                double modernUT = getModernUT();
                return toNanos(modernUT, (long) Math.floor(modernUT));
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + timeScale);
        }
    }

    public boolean isLeapSecond() {
        return isPositiveLS() && LeapSeconds.getInstance().isEnabled();
    }

    public boolean isBefore(UniversalTime universalTime) {
        return compareTo(from(universalTime)) < 0;
    }

    public PlainTimestamp toZonalTimestamp(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public GeneralTimestamp toGeneralTimestamp(Chronology chronology, TZID tzid, StartOfDay startOfDay) {
        PlainTimestamp zonalTimestamp = toZonalTimestamp(tzid);
        return GeneralTimestamp.of(((PlainTimestamp) zonalTimestamp.minus(startOfDay.getDeviation(zonalTimestamp.getCalendarDate(), tzid), ClockUnit.SECONDS)).getCalendarDate().transform(chronology.getChronoType()), zonalTimestamp.getWallTime());
    }

    public GeneralTimestamp toGeneralTimestamp(CalendarFamily calendarFamily, String str, TZID tzid, StartOfDay startOfDay) {
        PlainTimestamp zonalTimestamp = toZonalTimestamp(tzid);
        zonalTimestamp.getWallTime();
        ((PlainTimestamp) zonalTimestamp.minus(startOfDay.getDeviation(zonalTimestamp.getCalendarDate(), tzid), ClockUnit.SECONDS)).getCalendarDate();
        throw null;
    }

    public ZonalDateTime inZonalView(TZID tzid) {
        return ZonalDateTime.of(this, Timezone.of(tzid));
    }

    public Moment plus(long j, SI si) {
        Moment momentOf;
        check1972(this);
        if (j == 0) {
            return this;
        }
        try {
            int i = AnonymousClass1.$SwitchMap$net$time4j$SI[si.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    long jSafeAdd = MathUtils.safeAdd(getNanosecond(), j);
                    int iFloorModulo = MathUtils.floorModulo(jSafeAdd, Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
                    long jFloorDivide = MathUtils.floorDivide(jSafeAdd, Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
                    if (LeapSeconds.getInstance().isEnabled()) {
                        momentOf = new Moment(MathUtils.safeAdd(getElapsedTimeUTC(), jFloorDivide), iFloorModulo, TimeScale.UTC);
                    } else {
                        momentOf = of(MathUtils.safeAdd(this.posixTime, jFloorDivide), iFloorModulo, TimeScale.POSIX);
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else if (LeapSeconds.getInstance().isEnabled()) {
                momentOf = new Moment(MathUtils.safeAdd(getElapsedTimeUTC(), j), getNanosecond(), TimeScale.UTC);
            } else {
                momentOf = of(MathUtils.safeAdd(this.posixTime, j), getNanosecond(), TimeScale.POSIX);
            }
            if (j < 0) {
                check1972(momentOf);
            }
            return momentOf;
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    @Override // net.time4j.engine.TimePoint
    public int compareTo(Moment moment) {
        int nanosecond;
        long elapsedTimeUTC = getElapsedTimeUTC();
        long elapsedTimeUTC2 = moment.getElapsedTimeUTC();
        if (elapsedTimeUTC < elapsedTimeUTC2) {
            return -1;
        }
        if (elapsedTimeUTC <= elapsedTimeUTC2 && (nanosecond = getNanosecond() - moment.getNanosecond()) <= 0) {
            return nanosecond < 0 ? -1 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Moment) {
            Moment moment = (Moment) obj;
            if (this.posixTime != moment.posixTime) {
                return false;
            }
            if (LeapSeconds.getInstance().isEnabled()) {
                return this.fraction == moment.fraction;
            }
            if (getNanosecond() == moment.getNanosecond()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.posixTime;
        return (((int) (j ^ (j >>> 32))) * 19) + (getNanosecond() * 37);
    }

    public String toString() {
        return toStringUTC(true);
    }

    public static TimeAxis axis() {
        return ENGINE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.time4j.engine.ChronoEntity
    public TimeAxis getChronology() {
        return ENGINE;
    }

    static void checkNegativeLS(long j, PlainTimestamp plainTimestamp) {
        LeapSeconds leapSeconds = LeapSeconds.getInstance();
        if (!leapSeconds.supportsNegativeLS() || leapSeconds.strip(leapSeconds.enhance(j)) <= j) {
            return;
        }
        throw new ChronoException("Illegal local timestamp due to negative leap second: " + plainTimestamp);
    }

    static void check1972(Moment moment) {
        if (moment.posixTime < 63072000) {
            throw new UnsupportedOperationException("Cannot calculate SI-duration before 1972-01-01.");
        }
    }

    private String toStringUTC(boolean z) {
        PlainDate dateUTC = getDateUTC();
        int timeOfDay = getTimeOfDay(this);
        int i = timeOfDay / 60;
        int i2 = i / 60;
        int i3 = i % 60;
        int shift = (timeOfDay % 60) + LeapSeconds.getInstance().getShift(getElapsedTimeUTC());
        int nanosecond = getNanosecond();
        StringBuilder sb = new StringBuilder(50);
        sb.append(dateUTC);
        sb.append('T');
        format(i2, 2, sb);
        if (z || (i3 | shift | nanosecond) != 0) {
            sb.append(':');
            format(i3, 2, sb);
            if (z || (shift | nanosecond) != 0) {
                sb.append(':');
                format(shift, 2, sb);
                if (nanosecond > 0) {
                    sb.append(',');
                    format(nanosecond, 9, sb);
                }
            }
        }
        sb.append('Z');
        return sb.toString();
    }

    private long getElapsedTimeUTC() {
        if (LeapSeconds.getInstance().isEnabled()) {
            long jEnhance = LeapSeconds.getInstance().enhance(this.posixTime);
            return isPositiveLS() ? jEnhance + 1 : jEnhance;
        }
        return this.posixTime - 63072000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlainDate getDateUTC() {
        return PlainDate.of(MathUtils.floorDivide(this.posixTime, SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UNIX);
    }

    private double getModernUT() {
        double elapsedTimeUTC = ((getElapsedTimeUTC() + 42.184d) + (((double) getNanosecond()) / 1.0E9d)) - TimeScale.deltaT(getDateUTC());
        long jFloor = (long) Math.floor(elapsedTimeUTC);
        return Double.compare(1.0E9d - ((elapsedTimeUTC - ((double) jFloor)) * 1.0E9d), 1.0d) < 0 ? jFloor + 1 : elapsedTimeUTC;
    }

    private static int toNanos(double d, long j) {
        try {
            return (int) ((d * 1.0E9d) - MathUtils.safeMultiply(j, 1000000000L));
        } catch (ArithmeticException unused) {
            return (int) ((d - j) * 1.0E9d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPositiveLS() {
        return (this.fraction >>> 30) != 0;
    }

    private static void checkUnixTime(long j) {
        if (j > MAX_LIMIT || j < MIN_LIMIT) {
            throw new IllegalArgumentException("UNIX time (UT) out of supported range: " + j);
        }
    }

    private static void checkFraction(int i) {
        if (i >= 1000000000 || i < 0) {
            throw new IllegalArgumentException("Nanosecond out of range: " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Moment transformForPrint(TimeScale timeScale) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
                if (isLeapSecond()) {
                    return new Moment(getNanosecond(), this.posixTime);
                }
            case 2:
                return this;
            case 3:
                return new Moment(getNanosecond(timeScale), MathUtils.safeAdd(getElapsedTime(timeScale), -378691200L));
            case 4:
                return new Moment(getNanosecond(), MathUtils.safeAdd(getElapsedTime(TimeScale.GPS), 315964800L));
            case 5:
            case 6:
                return new Moment(getNanosecond(timeScale), MathUtils.safeAdd(getElapsedTime(timeScale), 63072000L));
            default:
                throw new UnsupportedOperationException(timeScale.name());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Moment transformForParse(TimeScale timeScale) {
        if (timeScale != TimeScale.UTC) {
            if (isLeapSecond()) {
                throw new IllegalArgumentException("Leap seconds do not exist on continuous time scale: " + timeScale);
            }
            int i = AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()];
            if (i != 1) {
                if (i == 3) {
                    return new Moment(MathUtils.safeSubtract(this.posixTime, -378691200L), getNanosecond(), timeScale);
                }
                if (i == 4) {
                    return new Moment(MathUtils.safeSubtract(this.posixTime, 315964800L), getNanosecond(), timeScale);
                }
                if (i == 5 || i == 6) {
                    return new Moment(MathUtils.safeSubtract(this.posixTime, 63072000L), getNanosecond(), timeScale);
                }
                throw new UnsupportedOperationException(timeScale.name());
            }
        }
        return this;
    }

    private static void format(int i, int i2, StringBuilder sb) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2 - 1; i4++) {
            i3 *= 10;
        }
        while (i < i3 && i3 >= 10) {
            sb.append('0');
            i3 /= 10;
        }
        sb.append(String.valueOf(i));
    }

    private static int getTimeOfDay(Moment moment) {
        return MathUtils.floorModulo(moment.posixTime, SyncConfiguration.DEFAULT_FREQUENCY);
    }

    private PlainTimestamp in(Timezone timezone) {
        return PlainTimestamp.from(this, timezone.getOffset(this));
    }

    private Object writeReplace() {
        return new SPX(this, 4);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    void writeTimestamp(DataOutput dataOutput) throws IOException {
        int i = isPositiveLS() ? 65 : 64;
        int nanosecond = getNanosecond();
        if (nanosecond > 0) {
            i |= 2;
        }
        dataOutput.writeByte(i);
        dataOutput.writeLong(this.posixTime);
        if (nanosecond > 0) {
            dataOutput.writeInt(nanosecond);
        }
    }

    static Moment readTimestamp(DataInput dataInput, boolean z, boolean z2) throws IOException {
        long j = dataInput.readLong();
        int i = z2 ? dataInput.readInt() : 0;
        if (j == 0) {
            if (z) {
                throw new InvalidObjectException("UTC epoch is no leap second.");
            }
            if (i == 0) {
                return UNIX_EPOCH;
            }
        }
        if (j == MIN_LIMIT && i == 0) {
            if (z) {
                throw new InvalidObjectException("Minimum is no leap second.");
            }
            return MIN;
        }
        if (j == MAX_LIMIT && i == 999999999) {
            if (z) {
                throw new InvalidObjectException("Maximum is no leap second.");
            }
            return MAX;
        }
        checkFraction(i);
        if (z) {
            LeapSeconds leapSeconds = LeapSeconds.getInstance();
            if (leapSeconds.isEnabled() && !leapSeconds.isPositiveLS(leapSeconds.enhance(j) + 1)) {
                long packedDate = GregorianMath.toPackedDate(j);
                int month = GregorianMath.readMonth(packedDate);
                int dayOfMonth = GregorianMath.readDayOfMonth(packedDate);
                StringBuilder sb = new StringBuilder();
                sb.append("Not registered as leap second event: ");
                sb.append(GregorianMath.readYear(packedDate));
                sb.append("-");
                sb.append(month < 10 ? "0" : "");
                sb.append(month);
                sb.append(dayOfMonth < 10 ? "0" : "");
                sb.append(dayOfMonth);
                sb.append(" [Please check leap second configurations ");
                sb.append("either of emitter vm or this target vm]");
                throw new InvalidObjectException(sb.toString());
            }
            i |= 1073741824;
        }
        return new Moment(i, j);
    }

    private static class TimeUnitRule implements UnitRule {
        private final TimeUnit unit;

        TimeUnitRule(TimeUnit timeUnit) {
            this.unit = timeUnit;
        }

        @Override // net.time4j.engine.UnitRule
        public Moment addTo(Moment moment, long j) {
            if (this.unit.compareTo(TimeUnit.SECONDS) >= 0) {
                return Moment.of(MathUtils.safeAdd(moment.getPosixTime(), MathUtils.safeMultiply(j, this.unit.toSeconds(1L))), moment.getNanosecond(), TimeScale.POSIX);
            }
            long jSafeAdd = MathUtils.safeAdd(moment.getNanosecond(), MathUtils.safeMultiply(j, this.unit.toNanos(1L)));
            return Moment.of(MathUtils.safeAdd(moment.getPosixTime(), MathUtils.floorDivide(jSafeAdd, Http2Connection.DEGRADED_PONG_TIMEOUT_NS)), MathUtils.floorModulo(jSafeAdd, Http2Connection.DEGRADED_PONG_TIMEOUT_NS), TimeScale.POSIX);
        }

        @Override // net.time4j.engine.UnitRule
        public long between(Moment moment, Moment moment2) {
            long jSafeAdd;
            if (this.unit.compareTo(TimeUnit.SECONDS) >= 0) {
                jSafeAdd = moment2.getPosixTime() - moment.getPosixTime();
                if (jSafeAdd < 0) {
                    if (moment2.getNanosecond() > moment.getNanosecond()) {
                        jSafeAdd++;
                    }
                } else if (jSafeAdd > 0 && moment2.getNanosecond() < moment.getNanosecond()) {
                    jSafeAdd--;
                }
            } else {
                jSafeAdd = MathUtils.safeAdd(MathUtils.safeMultiply(MathUtils.safeSubtract(moment2.getPosixTime(), moment.getPosixTime()), 1000000000L), moment2.getNanosecond() - moment.getNanosecond());
            }
            switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[this.unit.ordinal()]) {
                case 1:
                    return jSafeAdd / 86400;
                case 2:
                    return jSafeAdd / 3600;
                case 3:
                    return jSafeAdd / 60;
                case 4:
                case 7:
                    return jSafeAdd;
                case 5:
                    return jSafeAdd / 1000000;
                case 6:
                    return jSafeAdd / 1000;
                default:
                    throw new UnsupportedOperationException(this.unit.name());
            }
        }
    }

    /* JADX INFO: renamed from: net.time4j.Moment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$SI;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$scale$TimeScale;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.NANOSECONDS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[SI.values().length];
            $SwitchMap$net$time4j$SI = iArr2;
            try {
                iArr2[SI.SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$time4j$SI[SI.NANOSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr3 = new int[TimeScale.values().length];
            $SwitchMap$net$time4j$scale$TimeScale = iArr3;
            try {
                iArr3[TimeScale.POSIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.UTC.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.TAI.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.GPS.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.TT.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$net$time4j$scale$TimeScale[TimeScale.UT.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private enum LongElement implements ChronoElement, ElementRule {
        POSIX_TIME;

        @Override // net.time4j.engine.ChronoElement
        public char getSymbol() {
            return (char) 0;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public Class getType() {
            return Long.class;
        }

        @Override // java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            return ((Long) chronoDisplay.get(this)).compareTo((Long) chronoDisplay2.get(this));
        }

        @Override // net.time4j.engine.ChronoElement
        public Long getDefaultMinimum() {
            return Long.valueOf(Moment.MIN_LIMIT);
        }

        @Override // net.time4j.engine.ChronoElement
        public Long getDefaultMaximum() {
            return Long.valueOf(Moment.MAX_LIMIT);
        }

        @Override // net.time4j.engine.ElementRule
        public Long getValue(Moment moment) {
            return Long.valueOf(moment.getPosixTime());
        }

        @Override // net.time4j.engine.ElementRule
        public Long getMinimum(Moment moment) {
            return Long.valueOf(Moment.MIN_LIMIT);
        }

        @Override // net.time4j.engine.ElementRule
        public Long getMaximum(Moment moment) {
            return Long.valueOf(Moment.MAX_LIMIT);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(Moment moment, Long l) {
            if (l == null) {
                return false;
            }
            long jLongValue = l.longValue();
            return jLongValue >= Moment.MIN_LIMIT && jLongValue <= Moment.MAX_LIMIT;
        }

        @Override // net.time4j.engine.ElementRule
        public Moment withValue(Moment moment, Long l, boolean z) {
            if (l == null) {
                throw new IllegalArgumentException("Missing elapsed seconds.");
            }
            return Moment.of(l.longValue(), moment.getNanosecond(), TimeScale.POSIX);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(Moment moment) {
            return IntElement.FRACTION;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(Moment moment) {
            return IntElement.FRACTION;
        }
    }

    private enum IntElement implements ChronoElement, ElementRule {
        FRACTION;

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(Moment moment) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(Moment moment) {
            return null;
        }

        @Override // net.time4j.engine.ChronoElement
        public char getSymbol() {
            return (char) 0;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isLenient() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        @Override // net.time4j.engine.ChronoElement
        public Class getType() {
            return Integer.class;
        }

        @Override // java.util.Comparator
        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            return ((Integer) chronoDisplay.get(this)).compareTo((Integer) chronoDisplay2.get(this));
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMinimum() {
            return 0;
        }

        @Override // net.time4j.engine.ChronoElement
        public Integer getDefaultMaximum() {
            return 999999999;
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getValue(Moment moment) {
            return Integer.valueOf(moment.getNanosecond());
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMinimum(Moment moment) {
            return getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public Integer getMaximum(Moment moment) {
            return getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(Moment moment, Integer num) {
            int iIntValue;
            return num != null && (iIntValue = num.intValue()) >= 0 && iIntValue < 1000000000;
        }

        @Override // net.time4j.engine.ElementRule
        public Moment withValue(Moment moment, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing fraction value.");
            }
            if (LeapSeconds.getInstance().isEnabled()) {
                TimeScale timeScale = TimeScale.UTC;
                return Moment.of(moment.getElapsedTime(timeScale), num.intValue(), timeScale);
            }
            return Moment.of(moment.getPosixTime(), num.intValue(), TimeScale.POSIX);
        }
    }

    private static class Merger implements ChronoMerger {
        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            DisplayMode displayModeOfStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
            return CalendarText.patternForMoment(displayModeOfStyle, displayModeOfStyle, locale);
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
        public Moment createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            PlainTimestamp plainTimestamp;
            TZID timezone;
            Moment momentInTimezone;
            ZonalOffset offset;
            Moment moment;
            TimeScale timeScale = (TimeScale) attributeQuery.get(Attributes.TIME_SCALE, TimeScale.UTC);
            if (chronoEntity instanceof UnixTime) {
                return Moment.from((UnixTime) UnixTime.class.cast(chronoEntity)).transformForParse(timeScale);
            }
            LongElement longElement = LongElement.POSIX_TIME;
            int i = 0;
            if (chronoEntity.contains(longElement)) {
                long jLongValue = ((Long) chronoEntity.get(longElement)).longValue();
                IntElement intElement = IntElement.FRACTION;
                return Moment.of(jLongValue, chronoEntity.contains(intElement) ? ((Integer) chronoEntity.get(intElement)).intValue() : 0, TimeScale.POSIX).transformForParse(timeScale);
            }
            if (chronoEntity.contains(FlagElement.LEAP_SECOND)) {
                chronoEntity.with((ChronoElement) PlainTime.SECOND_OF_MINUTE, 60);
                i = 1;
            }
            ChronoElement chronoElementElement = PlainTimestamp.axis().element();
            if (chronoEntity.contains(chronoElementElement)) {
                plainTimestamp = (PlainTimestamp) chronoEntity.get(chronoElementElement);
            } else {
                plainTimestamp = (PlainTimestamp) PlainTimestamp.axis().createFrom(chronoEntity, attributeQuery, z, z2);
            }
            AnonymousClass1 anonymousClass1 = null;
            if (plainTimestamp == null) {
                return null;
            }
            if (chronoEntity.hasTimezone()) {
                timezone = chronoEntity.getTimezone();
            } else {
                AttributeKey attributeKey = Attributes.TIMEZONE_ID;
                timezone = attributeQuery.contains(attributeKey) ? (TZID) attributeQuery.get(attributeKey) : null;
            }
            if (timezone != null) {
                FlagElement flagElement = FlagElement.DAYLIGHT_SAVING;
                if (chronoEntity.contains(flagElement)) {
                    momentInTimezone = plainTimestamp.in(Timezone.of(timezone).with(((TransitionStrategy) attributeQuery.get(Attributes.TRANSITION_STRATEGY, Timezone.DEFAULT_CONFLICT_STRATEGY)).using(((Boolean) chronoEntity.get(flagElement)).booleanValue() ? OverlapResolver.EARLIER_OFFSET : OverlapResolver.LATER_OFFSET)));
                } else {
                    AttributeKey attributeKey2 = Attributes.TRANSITION_STRATEGY;
                    if (attributeQuery.contains(attributeKey2)) {
                        momentInTimezone = plainTimestamp.in(Timezone.of(timezone).with((TransitionStrategy) attributeQuery.get(attributeKey2)));
                    } else {
                        momentInTimezone = plainTimestamp.inTimezone(timezone);
                    }
                }
            } else {
                momentInTimezone = null;
            }
            if (momentInTimezone == null) {
                return null;
            }
            if (i != 0) {
                if (timezone instanceof ZonalOffset) {
                    offset = (ZonalOffset) timezone;
                } else {
                    offset = Timezone.of(timezone).getOffset(momentInTimezone);
                }
                if (offset.getFractionalAmount() == 0 && offset.getAbsoluteSeconds() % 60 == 0) {
                    if (momentInTimezone.getDateUTC().getYear() >= 1972) {
                        moment = momentInTimezone.plus(1L, SI.SECONDS);
                    } else {
                        moment = new Moment(momentInTimezone.getNanosecond(), momentInTimezone.getPosixTime() + 1, anonymousClass1);
                    }
                    if (z) {
                        momentInTimezone = moment;
                    } else if (LeapSeconds.getInstance().isEnabled()) {
                        if (!moment.isPositiveLS()) {
                            throw new IllegalArgumentException("SECOND_OF_MINUTE parsed as invalid leapsecond before " + moment);
                        }
                        momentInTimezone = moment;
                    }
                } else {
                    throw new IllegalArgumentException("Leap second is only allowed  with timezone-offset in full minutes: " + offset);
                }
            }
            return momentInTimezone.transformForParse(timeScale);
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(Moment moment, AttributeQuery attributeQuery) {
            AttributeKey attributeKey = Attributes.TIMEZONE_ID;
            if (attributeQuery.contains(attributeKey)) {
                return moment.transformForPrint((TimeScale) attributeQuery.get(Attributes.TIME_SCALE, TimeScale.UTC)).inZonalView((TZID) attributeQuery.get(attributeKey));
            }
            throw new IllegalArgumentException("Cannot print moment without timezone.");
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology preparser() {
            return PlainTimestamp.axis();
        }
    }

    private static class GlobalTimeLine implements TimeLine {
        private GlobalTimeLine() {
        }

        /* synthetic */ GlobalTimeLine(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Moment moment, Moment moment2) {
            return moment.compareTo(moment2);
        }
    }

    private static class NextLS implements ChronoOperator {
        private NextLS() {
        }

        /* synthetic */ NextLS(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ChronoOperator
        public Moment apply(Moment moment) {
            LeapSecondEvent nextEvent;
            LeapSeconds leapSeconds = LeapSeconds.getInstance();
            if (!leapSeconds.isEnabled() || (nextEvent = leapSeconds.getNextEvent(moment.getElapsedTime(TimeScale.UTC))) == null) {
                return null;
            }
            return PlainDate.from(nextEvent.getDate()).atTime(23, 59, 59).atUTC().plus(nextEvent.getShift(), SI.SECONDS);
        }
    }

    private static class PrecisionRule implements ElementRule {
        private PrecisionRule() {
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(Moment moment) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(Moment moment) {
            return null;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(Moment moment, TimeUnit timeUnit) {
            return timeUnit != null;
        }

        /* synthetic */ PrecisionRule(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.engine.ElementRule
        public TimeUnit getValue(Moment moment) {
            int nanosecond = moment.getNanosecond();
            if (nanosecond == 0) {
                long j = moment.posixTime;
                if (MathUtils.floorModulo(j, SyncConfiguration.DEFAULT_FREQUENCY) == 0) {
                    return TimeUnit.DAYS;
                }
                if (MathUtils.floorModulo(j, 3600) == 0) {
                    return TimeUnit.HOURS;
                }
                if (MathUtils.floorModulo(j, 60) == 0) {
                    return TimeUnit.MINUTES;
                }
                return TimeUnit.SECONDS;
            }
            if (nanosecond % 1000000 == 0) {
                return TimeUnit.MILLISECONDS;
            }
            if (nanosecond % 1000 == 0) {
                return TimeUnit.MICROSECONDS;
            }
            return TimeUnit.NANOSECONDS;
        }

        @Override // net.time4j.engine.ElementRule
        public Moment withValue(Moment moment, TimeUnit timeUnit, boolean z) {
            Moment momentOf;
            if (timeUnit == null) {
                throw new IllegalArgumentException("Missing precision.");
            }
            switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
                case 1:
                    return Moment.of(MathUtils.floorDivide(moment.posixTime, SyncConfiguration.DEFAULT_FREQUENCY) * 86400, TimeScale.POSIX);
                case 2:
                    return Moment.of(MathUtils.floorDivide(moment.posixTime, 3600) * 3600, TimeScale.POSIX);
                case 3:
                    return Moment.of(MathUtils.floorDivide(moment.posixTime, 60) * 60, TimeScale.POSIX);
                case 4:
                    momentOf = Moment.of(moment.posixTime, 0, TimeScale.POSIX);
                    break;
                case 5:
                    momentOf = Moment.of(moment.posixTime, (moment.getNanosecond() / 1000000) * 1000000, TimeScale.POSIX);
                    break;
                case 6:
                    momentOf = Moment.of(moment.posixTime, (moment.getNanosecond() / 1000) * 1000, TimeScale.POSIX);
                    break;
                case 7:
                    return moment;
                default:
                    throw new UnsupportedOperationException(timeUnit.name());
            }
            return (moment.isLeapSecond() && LeapSeconds.getInstance().isEnabled()) ? momentOf.plus(1L, SI.SECONDS) : momentOf;
        }

        @Override // net.time4j.engine.ElementRule
        public TimeUnit getMinimum(Moment moment) {
            return TimeUnit.DAYS;
        }

        @Override // net.time4j.engine.ElementRule
        public TimeUnit getMaximum(Moment moment) {
            return TimeUnit.NANOSECONDS;
        }
    }
}
