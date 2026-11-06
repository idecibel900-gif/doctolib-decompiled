package net.time4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.ResourceLoader;
import net.time4j.base.TimeSource;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.NumberType;
import net.time4j.format.PluralRules;

/* JADX INFO: loaded from: classes5.dex */
public final class PrettyTime {
    private static final ConcurrentMap LANGUAGE_MAP;
    private static final NumberSymbolProvider NUMBER_SYMBOLS;
    private static final long START_1972;
    private static final IsoUnit[] STD_UNITS;
    private static final Set SUPPORTED_UNITS;
    private static final IsoUnit[] TSP_UNITS;
    private final IsoUnit emptyUnit;
    private final String endListSeparator;
    private final Locale locale;
    private final String minusSign;
    private final TimeSource refClock;
    private final PluralRules rules;
    private final boolean shortStyle;
    private final String stdListSeparator;
    private final boolean weekToDays;
    private final char zeroDigit;

    static {
        NumberSymbolProvider numberSymbolProvider = null;
        int i = 0;
        for (NumberSymbolProvider numberSymbolProvider2 : ResourceLoader.getInstance().services(NumberSymbolProvider.class)) {
            int length = numberSymbolProvider2.getAvailableLocales().length;
            if (length >= i) {
                numberSymbolProvider = numberSymbolProvider2;
                i = length;
            }
        }
        if (numberSymbolProvider == null) {
            numberSymbolProvider = NumberSymbolProvider.DEFAULT;
        }
        NUMBER_SYMBOLS = numberSymbolProvider;
        LANGUAGE_MAP = new ConcurrentHashMap();
        CalendarUnit calendarUnit = CalendarUnit.YEARS;
        CalendarUnit calendarUnit2 = CalendarUnit.MONTHS;
        CalendarUnit calendarUnit3 = CalendarUnit.DAYS;
        ClockUnit clockUnit = ClockUnit.HOURS;
        ClockUnit clockUnit2 = ClockUnit.MINUTES;
        ClockUnit clockUnit3 = ClockUnit.SECONDS;
        IsoUnit[] isoUnitArr = {calendarUnit, calendarUnit2, CalendarUnit.WEEKS, calendarUnit3, clockUnit, clockUnit2, clockUnit3};
        STD_UNITS = isoUnitArr;
        TSP_UNITS = new IsoUnit[]{calendarUnit, calendarUnit2, calendarUnit3, clockUnit, clockUnit2, clockUnit3};
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, isoUnitArr);
        hashSet.add(ClockUnit.NANOS);
        SUPPORTED_UNITS = Collections.unmodifiableSet(hashSet);
        START_1972 = 63072000L;
    }

    private PrettyTime(Locale locale, TimeSource timeSource, char c, String str, IsoUnit isoUnit, boolean z, boolean z2, String str2, String str3) {
        if (isoUnit == null) {
            throw new NullPointerException("Missing zero time unit.");
        }
        if (timeSource == null) {
            throw new NullPointerException("Missing reference clock.");
        }
        this.rules = PluralRules.of(locale, NumberType.CARDINALS);
        this.locale = locale;
        this.refClock = timeSource;
        this.zeroDigit = c;
        this.emptyUnit = isoUnit;
        this.minusSign = str;
        this.weekToDays = z;
        this.shortStyle = z2;
        this.stdListSeparator = str2;
        this.endListSeparator = str3;
    }

    public static PrettyTime of(Locale locale) {
        ConcurrentMap concurrentMap = LANGUAGE_MAP;
        PrettyTime prettyTime = (PrettyTime) concurrentMap.get(locale);
        if (prettyTime != null) {
            return prettyTime;
        }
        SystemClock systemClock = SystemClock.INSTANCE;
        NumberSymbolProvider numberSymbolProvider = NUMBER_SYMBOLS;
        PrettyTime prettyTime2 = new PrettyTime(locale, systemClock, numberSymbolProvider.getZeroDigit(locale), numberSymbolProvider.getMinusSign(locale), ClockUnit.SECONDS, false, false, null, null);
        PrettyTime prettyTime3 = (PrettyTime) concurrentMap.putIfAbsent(locale, prettyTime2);
        return prettyTime3 != null ? prettyTime3 : prettyTime2;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String printToday() {
        return UnitPatterns.of(getLocale()).getTodayWord();
    }
}
