package net.time4j;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.ResourceLoader;
import net.time4j.format.PluralCategory;
import net.time4j.format.RelativeTimeProvider;
import net.time4j.format.TextWidth;
import net.time4j.format.UnitPatternProvider;

/* JADX INFO: loaded from: classes5.dex */
final class UnitPatterns {
    private static final UnitPatternProvider FALLBACK;
    private static final UnitPatternProvider PROVIDER;
    private final Map future;
    private final Map lastWeekdays;
    private final Map list;
    private final Locale locale;
    private final Map nextWeekdays;
    private final String now;
    private final Map past;
    private final Map patterns;
    private final Map shortFuture;
    private final Map shortPast;
    private final String today;
    private final String tomorrow;
    private final String yesterday;
    private static final ConcurrentMap CACHE = new ConcurrentHashMap();
    private static final IsoUnit[] UNIT_IDS = {CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.WEEKS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS, ClockUnit.MILLIS, ClockUnit.MICROS, ClockUnit.NANOS};

    /* JADX WARN: Multi-variable type inference failed */
    static {
        UnitPatternProvider fallbackProvider = new FallbackProvider(0 == true ? 1 : 0);
        FALLBACK = fallbackProvider;
        Iterator it = ResourceLoader.getInstance().services(UnitPatternProvider.class).iterator();
        UnitPatternProvider unitPatternProvider = it.hasNext() ? (UnitPatternProvider) it.next() : null;
        if (unitPatternProvider != null) {
            fallbackProvider = unitPatternProvider;
        }
        PROVIDER = fallbackProvider;
    }

    private UnitPatterns(Locale locale) {
        String tomorrowWord;
        String str;
        String todayWord;
        String str2;
        HashMap map;
        HashMap map2;
        this.locale = locale;
        HashMap map3 = new HashMap(10);
        HashMap map4 = new HashMap(10);
        HashMap map5 = new HashMap(10);
        HashMap map6 = new HashMap(10);
        HashMap map7 = new HashMap(10);
        HashMap map8 = new HashMap(10);
        IsoUnit[] isoUnitArr = UNIT_IDS;
        int length = isoUnitArr.length;
        int i = 0;
        while (i < length) {
            IsoUnit isoUnit = isoUnitArr[i];
            EnumMap enumMap = new EnumMap(TextWidth.class);
            TextWidth[] textWidthArrValues = TextWidth.values();
            int length2 = textWidthArrValues.length;
            IsoUnit[] isoUnitArr2 = isoUnitArr;
            int i2 = 0;
            while (i2 < length2) {
                int i3 = length;
                TextWidth textWidth = textWidthArrValues[i2];
                int i4 = i2;
                EnumMap enumMap2 = new EnumMap(PluralCategory.class);
                PluralCategory[] pluralCategoryArrValues = PluralCategory.values();
                int i5 = i;
                int i6 = 0;
                for (int length3 = pluralCategoryArrValues.length; i6 < length3; length3 = length3) {
                    int i7 = i6;
                    PluralCategory pluralCategory = pluralCategoryArrValues[i7];
                    enumMap2.put(pluralCategory, lookup(locale, isoUnit, textWidth, pluralCategory));
                    i6 = i7 + 1;
                }
                enumMap.put(textWidth, Collections.unmodifiableMap(enumMap2));
                i2 = i4 + 1;
                length = i3;
                i = i5;
            }
            int i8 = length;
            int i9 = i;
            map3.put(isoUnit, Collections.unmodifiableMap(enumMap));
            if (Character.isDigit(isoUnit.getSymbol())) {
                map = map3;
                map2 = map4;
            } else {
                EnumMap enumMap3 = new EnumMap(PluralCategory.class);
                PluralCategory[] pluralCategoryArrValues2 = PluralCategory.values();
                int length4 = pluralCategoryArrValues2.length;
                int i10 = 0;
                while (i10 < length4) {
                    PluralCategory pluralCategory2 = pluralCategoryArrValues2[i10];
                    enumMap3.put(pluralCategory2, lookup(locale, isoUnit, false, false, pluralCategory2));
                    i10++;
                    map3 = map3;
                }
                map = map3;
                map4.put(isoUnit, Collections.unmodifiableMap(enumMap3));
                EnumMap enumMap4 = new EnumMap(PluralCategory.class);
                for (PluralCategory pluralCategory3 : PluralCategory.values()) {
                    enumMap4.put(pluralCategory3, lookup(locale, isoUnit, false, true, pluralCategory3));
                }
                map6.put(isoUnit, Collections.unmodifiableMap(enumMap4));
                EnumMap enumMap5 = new EnumMap(PluralCategory.class);
                PluralCategory[] pluralCategoryArrValues3 = PluralCategory.values();
                int length5 = pluralCategoryArrValues3.length;
                int i11 = 0;
                while (i11 < length5) {
                    PluralCategory pluralCategory4 = pluralCategoryArrValues3[i11];
                    enumMap5.put(pluralCategory4, lookup(locale, isoUnit, true, false, pluralCategory4));
                    i11++;
                    map4 = map4;
                }
                map2 = map4;
                map5.put(isoUnit, Collections.unmodifiableMap(enumMap5));
                EnumMap enumMap6 = new EnumMap(PluralCategory.class);
                for (PluralCategory pluralCategory5 : PluralCategory.values()) {
                    enumMap6.put(pluralCategory5, lookup(locale, isoUnit, true, true, pluralCategory5));
                }
                map7.put(isoUnit, Collections.unmodifiableMap(enumMap6));
            }
            i = i9 + 1;
            map4 = map2;
            isoUnitArr = isoUnitArr2;
            length = i8;
            map3 = map;
        }
        HashMap map9 = map3;
        HashMap map10 = map4;
        for (int i12 = 2; i12 <= 7; i12++) {
            Integer numValueOf = Integer.valueOf(i12);
            EnumMap enumMap7 = new EnumMap(TextWidth.class);
            for (TextWidth textWidth2 : TextWidth.values()) {
                enumMap7.put(textWidth2, lookup(locale, textWidth2, i12));
            }
            map8.put(numValueOf, Collections.unmodifiableMap(enumMap7));
        }
        this.patterns = Collections.unmodifiableMap(map9);
        this.past = Collections.unmodifiableMap(map10);
        this.future = Collections.unmodifiableMap(map5);
        this.shortPast = Collections.unmodifiableMap(map6);
        this.shortFuture = Collections.unmodifiableMap(map7);
        this.list = Collections.unmodifiableMap(map8);
        EnumMap enumMap8 = new EnumMap(Weekday.class);
        EnumMap enumMap9 = new EnumMap(Weekday.class);
        Weekday[] weekdayArrValues = Weekday.values();
        int length6 = weekdayArrValues.length;
        int i13 = 0;
        while (true) {
            tomorrowWord = "";
            if (i13 < length6) {
                Weekday weekday = weekdayArrValues[i13];
                enumMap8.put(weekday, "");
                enumMap9.put(weekday, "");
                i13++;
            } else {
                try {
                    break;
                } catch (MissingResourceException unused) {
                    str = "";
                    todayWord = str;
                }
            }
        }
        UnitPatternProvider unitPatternProvider = PROVIDER;
        String nowWord = unitPatternProvider.getNowWord(locale);
        if (unitPatternProvider instanceof RelativeTimeProvider) {
            RelativeTimeProvider relativeTimeProvider = (RelativeTimeProvider) RelativeTimeProvider.class.cast(unitPatternProvider);
            String yesterdayWord = relativeTimeProvider.getYesterdayWord(locale);
            try {
                todayWord = relativeTimeProvider.getTodayWord(locale);
                try {
                    tomorrowWord = relativeTimeProvider.getTomorrowWord(locale);
                    for (Weekday weekday2 : Weekday.values()) {
                        enumMap8.put(weekday2, relativeTimeProvider.labelForLast(weekday2, locale));
                        enumMap9.put(weekday2, relativeTimeProvider.labelForNext(weekday2, locale));
                    }
                    str2 = tomorrowWord;
                    tomorrowWord = yesterdayWord;
                } catch (MissingResourceException unused2) {
                    str = tomorrowWord;
                    tomorrowWord = yesterdayWord;
                    nowWord = FALLBACK.getNowWord(locale);
                    str2 = str;
                }
            } catch (MissingResourceException unused3) {
                str = "";
                todayWord = str;
            }
        } else {
            str2 = "";
            todayWord = str2;
        }
        this.now = nowWord;
        this.yesterday = tomorrowWord;
        this.today = todayWord;
        this.tomorrow = str2;
        this.lastWeekdays = Collections.unmodifiableMap(enumMap8);
        this.nextWeekdays = Collections.unmodifiableMap(enumMap9);
    }

    static UnitPatterns of(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Missing language.");
        }
        ConcurrentMap concurrentMap = CACHE;
        UnitPatterns unitPatterns = (UnitPatterns) concurrentMap.get(locale);
        if (unitPatterns == null) {
            unitPatterns = new UnitPatterns(locale);
            UnitPatterns unitPatterns2 = (UnitPatterns) concurrentMap.putIfAbsent(locale, unitPatterns);
            if (unitPatterns2 != null) {
                return unitPatterns2;
            }
        }
        return unitPatterns;
    }

    String getTodayWord() {
        return this.today;
    }

    private static char getID(IsoUnit isoUnit) {
        char symbol = isoUnit.getSymbol();
        if (isoUnit == ClockUnit.MINUTES) {
            return 'N';
        }
        return symbol;
    }

    private static String lookup(Locale locale, IsoUnit isoUnit, TextWidth textWidth, PluralCategory pluralCategory) {
        try {
            return lookup(PROVIDER, locale, getID(isoUnit), textWidth, pluralCategory);
        } catch (MissingResourceException unused) {
            return lookup(FALLBACK, locale, getID(isoUnit), textWidth, pluralCategory);
        }
    }

    private static String lookup(UnitPatternProvider unitPatternProvider, Locale locale, char c, TextWidth textWidth, PluralCategory pluralCategory) {
        if (c == '3') {
            return unitPatternProvider.getMilliPattern(locale, textWidth, pluralCategory);
        }
        if (c == '6') {
            return unitPatternProvider.getMicroPattern(locale, textWidth, pluralCategory);
        }
        if (c == '9') {
            return unitPatternProvider.getNanoPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'D') {
            return unitPatternProvider.getDayPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'H') {
            return unitPatternProvider.getHourPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'S') {
            return unitPatternProvider.getSecondPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'W') {
            return unitPatternProvider.getWeekPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'Y') {
            return unitPatternProvider.getYearPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'M') {
            return unitPatternProvider.getMonthPattern(locale, textWidth, pluralCategory);
        }
        if (c == 'N') {
            return unitPatternProvider.getMinutePattern(locale, textWidth, pluralCategory);
        }
        throw new UnsupportedOperationException("Unit-ID: " + c);
    }

    private static String lookup(Locale locale, IsoUnit isoUnit, boolean z, boolean z2, PluralCategory pluralCategory) {
        Locale locale2;
        boolean z3;
        boolean z4;
        PluralCategory pluralCategory2;
        try {
            locale2 = locale;
            z3 = z;
            z4 = z2;
            pluralCategory2 = pluralCategory;
            try {
                return lookup(PROVIDER, locale2, getID(isoUnit), z3, z4, pluralCategory2);
            } catch (MissingResourceException unused) {
                return lookup(FALLBACK, locale2, getID(isoUnit), z3, z4, pluralCategory2);
            }
        } catch (MissingResourceException unused2) {
            locale2 = locale;
            z3 = z;
            z4 = z2;
            pluralCategory2 = pluralCategory;
        }
    }

    private static String lookup(UnitPatternProvider unitPatternProvider, Locale locale, char c, boolean z, boolean z2, PluralCategory pluralCategory) {
        if (!z2 || !(unitPatternProvider instanceof RelativeTimeProvider)) {
            if (c == 'D') {
                return unitPatternProvider.getDayPattern(locale, z, pluralCategory);
            }
            if (c == 'H') {
                return unitPatternProvider.getHourPattern(locale, z, pluralCategory);
            }
            if (c == 'S') {
                return unitPatternProvider.getSecondPattern(locale, z, pluralCategory);
            }
            if (c == 'W') {
                return unitPatternProvider.getWeekPattern(locale, z, pluralCategory);
            }
            if (c == 'Y') {
                return unitPatternProvider.getYearPattern(locale, z, pluralCategory);
            }
            if (c == 'M') {
                return unitPatternProvider.getMonthPattern(locale, z, pluralCategory);
            }
            if (c != 'N') {
                throw new UnsupportedOperationException("Unit-ID: " + c);
            }
            return unitPatternProvider.getMinutePattern(locale, z, pluralCategory);
        }
        RelativeTimeProvider relativeTimeProvider = (RelativeTimeProvider) RelativeTimeProvider.class.cast(unitPatternProvider);
        if (c == 'D') {
            return relativeTimeProvider.getShortDayPattern(locale, z, pluralCategory);
        }
        if (c == 'H') {
            return relativeTimeProvider.getShortHourPattern(locale, z, pluralCategory);
        }
        if (c == 'S') {
            return relativeTimeProvider.getShortSecondPattern(locale, z, pluralCategory);
        }
        if (c == 'W') {
            return relativeTimeProvider.getShortWeekPattern(locale, z, pluralCategory);
        }
        if (c == 'Y') {
            return relativeTimeProvider.getShortYearPattern(locale, z, pluralCategory);
        }
        if (c == 'M') {
            return relativeTimeProvider.getShortMonthPattern(locale, z, pluralCategory);
        }
        if (c != 'N') {
            throw new UnsupportedOperationException("Unit-ID: " + c);
        }
        return relativeTimeProvider.getShortMinutePattern(locale, z, pluralCategory);
    }

    private static String lookup(Locale locale, TextWidth textWidth, int i) {
        try {
            return PROVIDER.getListPattern(locale, textWidth, i);
        } catch (MissingResourceException unused) {
            return FALLBACK.getListPattern(locale, textWidth, i);
        }
    }

    private static class FallbackProvider implements UnitPatternProvider {
        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getYearPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("year", "yr", "y", textWidth, pluralCategory);
            }
            return getUnitPattern("y");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMonthPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("month", "mth", "m", textWidth, pluralCategory);
            }
            return getUnitPattern("m");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getWeekPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("week", "wk", "w", textWidth, pluralCategory);
            }
            return getUnitPattern("w");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getDayPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("day", "day", "d", textWidth, pluralCategory);
            }
            return getUnitPattern("d");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getHourPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("hour", "hr", "h", textWidth, pluralCategory);
            }
            return getUnitPattern("h");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMinutePattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("minute", "min", "m", textWidth, pluralCategory);
            }
            return getUnitPattern("min");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getSecondPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("second", "sec", "s", textWidth, pluralCategory);
            }
            return getUnitPattern("s");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getYearPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("year", z, pluralCategory);
            }
            return getRelativePattern("y", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMonthPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("month", z, pluralCategory);
            }
            return getRelativePattern("m", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getWeekPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("week", z, pluralCategory);
            }
            return getRelativePattern("w", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getDayPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("day", z, pluralCategory);
            }
            return getRelativePattern("d", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getHourPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("hour", z, pluralCategory);
            }
            return getRelativePattern("h", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMinutePattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("minute", z, pluralCategory);
            }
            return getRelativePattern("min", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getSecondPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("second", z, pluralCategory);
            }
            return getRelativePattern("s", z);
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getNowWord(Locale locale) {
            return "now";
        }

        private static String getEnglishPattern(String str, String str2, String str3, TextWidth textWidth, PluralCategory pluralCategory) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                return getPluralPattern(str, pluralCategory);
            }
            if (i == 2 || i == 3) {
                return getPluralPattern(str2, pluralCategory);
            }
            if (i == 4) {
                return "{0}" + str3;
            }
            throw new UnsupportedOperationException(textWidth.name());
        }

        private static String getPluralPattern(String str, PluralCategory pluralCategory) {
            return "{0} " + str + (pluralCategory == PluralCategory.ONE ? "" : "s");
        }

        private static String getUnitPattern(String str) {
            return "{0} " + str;
        }

        private static String getRelativeEnglishPattern(String str, boolean z, PluralCategory pluralCategory) {
            String str2 = pluralCategory == PluralCategory.ONE ? "" : "s";
            if (z) {
                return "in {0} " + str + str2;
            }
            return "{0} " + str + str2 + " ago";
        }

        private static String getRelativePattern(String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "+" : "-");
            sb.append("{0} ");
            sb.append(str);
            return sb.toString();
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getListPattern(Locale locale, TextWidth textWidth, int i) {
            if (i < 2) {
                throw new IllegalArgumentException("Size must be greater than 1.");
            }
            StringBuilder sb = new StringBuilder(i * 5);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append('{');
                sb.append(i2);
                sb.append('}');
                if (i2 < i - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMilliPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("millisecond", "msec", "ms", textWidth, pluralCategory);
            }
            return getUnitPattern("ms");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getMicroPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("microsecond", "µsec", "µs", textWidth, pluralCategory);
            }
            return getUnitPattern("µs");
        }

        @Override // net.time4j.format.UnitPatternProvider
        public String getNanoPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("nanosecond", "nsec", "ns", textWidth, pluralCategory);
            }
            return getUnitPattern("ns");
        }
    }

    /* JADX INFO: renamed from: net.time4j.UnitPatterns$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        static {
            int[] iArr = new int[TextWidth.values().length];
            $SwitchMap$net$time4j$format$TextWidth = iArr;
            try {
                iArr[TextWidth.WIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.ABBREVIATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.NARROW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
