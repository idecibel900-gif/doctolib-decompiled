package net.time4j.format;

import com.amazon.a.a.o.b;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.Chronology;
import net.time4j.format.internal.ExtendedPatterns;
import net.time4j.format.internal.FormatUtils;
import net.time4j.i18n.IsoTextProviderSPI;
import net.time4j.i18n.PropertyBundle;

/* JADX INFO: loaded from: classes5.dex */
public final class CalendarText {
    private static final ConcurrentMap CACHE;
    private static final FormatPatternProvider FORMAT_PATTERN_PROVIDER;
    private static final TextProvider JDK_PROVIDER;
    private static final TextProvider ROOT_PROVIDER;
    private static final Set RTL;
    private final String calendarType;
    private final Map eras;
    private final Map leapMonths;
    private final Locale locale;
    private final Map meridiems;
    private final MissingResourceException mre;
    private final String provider;
    private final Map quarters;
    private final Map stdMonths;
    private final Map textForms;
    private final Map weekdays;

    static {
        FormatPatternProvider isoTextProviderSPI;
        HashSet hashSet = new HashSet();
        hashSet.add("ar");
        hashSet.add("dv");
        hashSet.add("fa");
        hashSet.add("ha");
        hashSet.add("he");
        hashSet.add("iw");
        hashSet.add("ji");
        hashSet.add("ps");
        hashSet.add("sd");
        hashSet.add("ug");
        hashSet.add("ur");
        hashSet.add("yi");
        RTL = Collections.unmodifiableSet(hashSet);
        Iterator it = ResourceLoader.getInstance().services(FormatPatternProvider.class).iterator();
        if (it.hasNext()) {
            isoTextProviderSPI = (FormatPatternProvider) it.next();
        } else {
            isoTextProviderSPI = new IsoTextProviderSPI();
        }
        FORMAT_PATTERN_PROVIDER = new FormatPatterns(isoTextProviderSPI);
        AnonymousClass1 anonymousClass1 = null;
        JDK_PROVIDER = new JDKTextProvider(anonymousClass1);
        ROOT_PROVIDER = new FallbackProvider(anonymousClass1);
        CACHE = new ConcurrentHashMap();
    }

    private CalendarText(String str, Locale locale, TextProvider textProvider) throws Throwable {
        this.provider = textProvider.toString();
        int i = 0;
        Map mapUnmodifiableMap = Collections.unmodifiableMap(getMonths(str, locale, textProvider, false));
        this.stdMonths = mapUnmodifiableMap;
        Map months = getMonths(str, locale, textProvider, true);
        if (months == null) {
            this.leapMonths = mapUnmodifiableMap;
        } else {
            this.leapMonths = Collections.unmodifiableMap(months);
        }
        EnumMap enumMap = new EnumMap(TextWidth.class);
        TextWidth[] textWidthArrValues = TextWidth.values();
        int length = textWidthArrValues.length;
        int i2 = 0;
        while (i2 < length) {
            TextWidth textWidth = textWidthArrValues[i2];
            EnumMap enumMap2 = new EnumMap(OutputContext.class);
            OutputContext[] outputContextArrValues = OutputContext.values();
            int length2 = outputContextArrValues.length;
            int i3 = i;
            while (i3 < length2) {
                OutputContext outputContext = outputContextArrValues[i3];
                enumMap2.put(outputContext, new TextAccessor(textProvider.quarters(str, locale, textWidth, outputContext)));
                i3++;
                textWidthArrValues = textWidthArrValues;
            }
            enumMap.put(textWidth, enumMap2);
            i2++;
            i = 0;
        }
        this.quarters = Collections.unmodifiableMap(enumMap);
        EnumMap enumMap3 = new EnumMap(TextWidth.class);
        TextWidth[] textWidthArrValues2 = TextWidth.values();
        int length3 = textWidthArrValues2.length;
        for (int i4 = 0; i4 < length3; i4++) {
            TextWidth textWidth2 = textWidthArrValues2[i4];
            EnumMap enumMap4 = new EnumMap(OutputContext.class);
            OutputContext[] outputContextArrValues2 = OutputContext.values();
            int length4 = outputContextArrValues2.length;
            int i5 = 0;
            while (i5 < length4) {
                OutputContext outputContext2 = outputContextArrValues2[i5];
                enumMap4.put(outputContext2, new TextAccessor(textProvider.weekdays(str, locale, textWidth2, outputContext2)));
                i5++;
                textWidthArrValues2 = textWidthArrValues2;
                length3 = length3;
            }
            enumMap3.put(textWidth2, enumMap4);
        }
        this.weekdays = Collections.unmodifiableMap(enumMap3);
        EnumMap enumMap5 = new EnumMap(TextWidth.class);
        for (TextWidth textWidth3 : TextWidth.values()) {
            enumMap5.put(textWidth3, new TextAccessor(textProvider.eras(str, locale, textWidth3)));
        }
        this.eras = Collections.unmodifiableMap(enumMap5);
        EnumMap enumMap6 = new EnumMap(TextWidth.class);
        TextWidth[] textWidthArrValues3 = TextWidth.values();
        int length5 = textWidthArrValues3.length;
        for (int i6 = 0; i6 < length5; i6++) {
            TextWidth textWidth4 = textWidthArrValues3[i6];
            EnumMap enumMap7 = new EnumMap(OutputContext.class);
            OutputContext[] outputContextArrValues3 = OutputContext.values();
            int length6 = outputContextArrValues3.length;
            int i7 = 0;
            while (i7 < length6) {
                OutputContext outputContext3 = outputContextArrValues3[i7];
                enumMap7.put(outputContext3, new TextAccessor(textProvider.meridiems(str, locale, textWidth4, outputContext3)));
                i7++;
                textWidthArrValues3 = textWidthArrValues3;
            }
            enumMap6.put(textWidth4, enumMap7);
        }
        this.meridiems = Collections.unmodifiableMap(enumMap6);
        HashMap map = new HashMap();
        try {
            PropertyBundle propertyBundleLoad = PropertyBundle.load("calendar/names/" + str + "/" + str, locale);
            for (String str2 : propertyBundleLoad.keySet()) {
                map.put(str2, propertyBundleLoad.getString(str2));
            }
            e = null;
        } catch (MissingResourceException e) {
            e = e;
        }
        this.textForms = Collections.unmodifiableMap(map);
        this.calendarType = str;
        this.locale = locale;
        this.mre = e;
    }

    public static CalendarText getIsoInstance(Locale locale) {
        return getInstance("iso8601", locale);
    }

    public static CalendarText getInstance(String str, Locale locale) {
        TextProvider textProvider;
        if (str == null) {
            throw new NullPointerException("Missing calendar type.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(':');
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!country.isEmpty()) {
            sb.append('-');
            sb.append(country);
        }
        String string = sb.toString();
        CalendarText calendarText = (CalendarText) CACHE.get(string);
        if (calendarText != null) {
            return calendarText;
        }
        if (locale.getLanguage().isEmpty() && str.equals("iso8601")) {
            textProvider = ROOT_PROVIDER;
        } else {
            Iterator it = ResourceLoader.getInstance().services(TextProvider.class).iterator();
            while (true) {
                if (!it.hasNext()) {
                    textProvider = null;
                    break;
                }
                TextProvider textProvider2 = (TextProvider) it.next();
                if (textProvider2.supportsCalendarType(str) && textProvider2.supportsLanguage(locale)) {
                    textProvider = textProvider2;
                    break;
                }
            }
            if (textProvider == null) {
                TextProvider textProvider3 = JDK_PROVIDER;
                if (textProvider3.supportsCalendarType(str) && textProvider3.supportsLanguage(locale)) {
                    textProvider = textProvider3;
                }
                if (textProvider == null) {
                    textProvider = ROOT_PROVIDER;
                }
            }
        }
        CalendarText calendarText2 = new CalendarText(str, locale, textProvider);
        CalendarText calendarText3 = (CalendarText) CACHE.putIfAbsent(string, calendarText2);
        return calendarText3 != null ? calendarText3 : calendarText2;
    }

    public TextAccessor getStdMonths(TextWidth textWidth, OutputContext outputContext) {
        return getMonths(textWidth, outputContext, false);
    }

    public TextAccessor getLeapMonths(TextWidth textWidth, OutputContext outputContext) {
        return getMonths(textWidth, outputContext, true);
    }

    public TextAccessor getQuarters(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) ((Map) this.quarters.get(textWidth)).get(outputContext);
    }

    public TextAccessor getWeekdays(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) ((Map) this.weekdays.get(textWidth)).get(outputContext);
    }

    public TextAccessor getEras(TextWidth textWidth) {
        return (TextAccessor) this.eras.get(textWidth);
    }

    public TextAccessor getMeridiems(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) ((Map) this.meridiems.get(textWidth)).get(outputContext);
    }

    public Map getTextForms() {
        return this.textForms;
    }

    public TextAccessor getTextForms(ChronoElement chronoElement, String... strArr) {
        return getTextForms(chronoElement.name(), chronoElement.getType(), strArr);
    }

    public TextAccessor getTextForms(String str, Class cls, String... strArr) {
        String key;
        if (this.mre != null) {
            throw new MissingResourceException(this.mre.getMessage(), this.mre.getClassName(), this.mre.getKey());
        }
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int length = enumArr.length;
        String[] strArr2 = new String[length];
        String keyPrefix = getKeyPrefix(str);
        int i = !CalendarEra.class.isAssignableFrom(cls) ? 1 : 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = 0;
            while (true) {
                String keyStart = getKeyStart(keyPrefix, i3, strArr);
                if (keyStart == null) {
                    key = null;
                    break;
                }
                key = toKey(keyStart, i2, i);
                if (this.textForms.containsKey(key)) {
                    break;
                }
                i3++;
            }
            if (key == null) {
                if (this.textForms.containsKey(str)) {
                    strArr2[i2] = (String) this.textForms.get(str);
                } else {
                    strArr2[i2] = enumArr[i2].name();
                }
            } else {
                strArr2[i2] = (String) this.textForms.get(key);
            }
        }
        return new TextAccessor(strArr2);
    }

    public static String patternForDate(DisplayMode displayMode, Locale locale) {
        return FORMAT_PATTERN_PROVIDER.getDatePattern(displayMode, locale);
    }

    public static String patternForTime(DisplayMode displayMode, Locale locale) {
        return FORMAT_PATTERN_PROVIDER.getTimePattern(displayMode, locale);
    }

    public static String patternForTimestamp(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
        return FormatUtils.removeZones(FORMAT_PATTERN_PROVIDER.getDateTimePattern(displayMode, displayMode2, locale));
    }

    public static String patternForMoment(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
        return FORMAT_PATTERN_PROVIDER.getDateTimePattern(displayMode, displayMode2, locale);
    }

    public String toString() {
        return this.provider + "(" + this.calendarType + "/" + this.locale + ")";
    }

    public static boolean isRTL(Locale locale) {
        return RTL.contains(locale.getLanguage());
    }

    static String extractCalendarType(Chronology chronology) {
        CalendarType calendarType = (CalendarType) chronology.getChronoType().getAnnotation(CalendarType.class);
        return calendarType == null ? "iso8601" : calendarType.value();
    }

    private TextAccessor getMonths(TextWidth textWidth, OutputContext outputContext, boolean z) {
        if (z) {
            return (TextAccessor) ((Map) this.leapMonths.get(textWidth)).get(outputContext);
        }
        return (TextAccessor) ((Map) this.stdMonths.get(textWidth)).get(outputContext);
    }

    private static Map getMonths(String str, Locale locale, TextProvider textProvider, boolean z) {
        EnumMap enumMap = new EnumMap(TextWidth.class);
        boolean z2 = false;
        for (TextWidth textWidth : TextWidth.values()) {
            EnumMap enumMap2 = new EnumMap(OutputContext.class);
            for (OutputContext outputContext : OutputContext.values()) {
                String[] strArrMonths = textProvider.months(str, locale, textWidth, outputContext, z);
                if (z && !z2) {
                    z2 = !Arrays.equals(textProvider.months(str, locale, textWidth, outputContext, false), strArrMonths);
                }
                enumMap2.put(outputContext, new TextAccessor(strArrMonths));
            }
            enumMap.put(textWidth, enumMap2);
        }
        if (!z || z2) {
            return enumMap;
        }
        return null;
    }

    private String getKeyPrefix(String str) {
        if (!this.textForms.containsKey("useShortKeys") || !b.af.equals(this.textForms.get("useShortKeys"))) {
            return str;
        }
        if (str.equals("MONTH_OF_YEAR") || str.equals("DAY_OF_WEEK") || str.equals("QUARTER_OF_YEAR") || str.equals("ERA")) {
            return str.substring(0, 1);
        }
        if (str.equals("EVANGELIST")) {
            return "EV";
        }
        if (str.equals("SANSCULOTTIDES")) {
            return "S";
        }
        return str.equals("DAY_OF_DECADE") ? "D" : str;
    }

    private static String getKeyStart(String str, int i, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            if (i > 0) {
                return null;
            }
            return str;
        }
        if (strArr.length < i) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean z = true;
        for (int i2 = 0; i2 < strArr.length - i; i2++) {
            if (z) {
                sb.append('(');
                z = false;
            } else {
                sb.append('|');
            }
            sb.append(strArr[i2]);
        }
        if (!z) {
            sb.append(')');
        }
        return sb.toString();
    }

    private static String toKey(String str, int i, int i2) {
        return str + '_' + (i + i2);
    }

    private static class JDKTextProvider implements TextProvider {
        private JDKTextProvider() {
        }

        /* synthetic */ JDKTextProvider(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.TextProvider
        public boolean supportsCalendarType(String str) {
            return "iso8601".equals(str);
        }

        @Override // net.time4j.format.TextProvider
        public boolean supportsLanguage(Locale locale) {
            String language = locale.getLanguage();
            for (Locale locale2 : DateFormatSymbols.getAvailableLocales()) {
                if (locale2.getLanguage().equals(language)) {
                    return true;
                }
            }
            return false;
        }

        @Override // net.time4j.format.TextProvider
        public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                return dateFormatSymbols.getMonths();
            }
            if (i == 2 || i == 3) {
                return dateFormatSymbols.getShortMonths();
            }
            if (i == 4) {
                return narrow(dateFormatSymbols.getShortMonths(), 12);
            }
            throw new UnsupportedOperationException(textWidth.name());
        }

        @Override // net.time4j.format.TextProvider
        public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            return new String[]{"Q1", "Q2", "Q3", "Q4"};
        }

        @Override // net.time4j.format.TextProvider
        public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            String[] weekdays;
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                weekdays = dateFormatSymbols.getWeekdays();
            } else if (i == 2 || i == 3) {
                weekdays = dateFormatSymbols.getShortWeekdays();
            } else if (i == 4) {
                weekdays = narrow(weekdays("", locale, TextWidth.SHORT, outputContext), 7);
            } else {
                throw new UnsupportedOperationException("Unknown text width: " + textWidth);
            }
            if (weekdays.length <= 7) {
                return weekdays;
            }
            String str2 = weekdays[1];
            String[] strArr = new String[7];
            System.arraycopy(weekdays, 2, strArr, 0, 6);
            strArr[6] = str2;
            return strArr;
        }

        @Override // net.time4j.format.TextProvider
        public String[] eras(String str, Locale locale, TextWidth textWidth) {
            DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
            if (textWidth == TextWidth.NARROW) {
                String[] eras = dateFormatSymbols.getEras();
                String[] strArr = new String[eras.length];
                int length = eras.length;
                for (int i = 0; i < length; i++) {
                    if (!eras[i].isEmpty()) {
                        strArr[i] = toSingleLetter(eras[i]);
                    } else if (i == 0 && eras.length == 2) {
                        strArr[i] = "B";
                    } else if (i == 1 && eras.length == 2) {
                        strArr[i] = "A";
                    } else {
                        strArr[i] = String.valueOf(i);
                    }
                }
                return strArr;
            }
            return dateFormatSymbols.getEras();
        }

        @Override // net.time4j.format.TextProvider
        public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"A", "P"};
            }
            return DateFormatSymbols.getInstance(locale).getAmPmStrings();
        }

        public String toString() {
            return "JDKTextProvider";
        }

        private static String[] narrow(String[] strArr, int i) {
            String[] strArr2 = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                if (!strArr[i2].isEmpty()) {
                    strArr2[i2] = toSingleLetter(strArr[i2]);
                } else {
                    strArr2[i2] = String.valueOf(i2 + 1);
                }
            }
            return strArr2;
        }

        private static String toSingleLetter(String str) {
            char cCharAt = Normalizer.normalize(str, Normalizer.Form.NFD).charAt(0);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                return String.valueOf(cCharAt);
            }
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                return String.valueOf((char) (cCharAt - ' '));
            }
            if (cCharAt < 1040 || cCharAt > 1071) {
                return (cCharAt < 1072 || cCharAt > 1103) ? str : String.valueOf((char) (cCharAt - ' '));
            }
            return String.valueOf(cCharAt);
        }
    }

    private static class FallbackProvider implements TextProvider {
        private FallbackProvider() {
        }

        @Override // net.time4j.format.TextProvider
        public boolean supportsCalendarType(String str) {
            return true;
        }

        @Override // net.time4j.format.TextProvider
        public boolean supportsLanguage(Locale locale) {
            return true;
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.TextProvider
        public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
            if (textWidth == TextWidth.WIDE) {
                return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13"};
            }
            return new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        }

        @Override // net.time4j.format.TextProvider
        public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"1", "2", "3", "4"};
            }
            return new String[]{"Q1", "Q2", "Q3", "Q4"};
        }

        @Override // net.time4j.format.TextProvider
        public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            return new String[]{"1", "2", "3", "4", "5", "6", "7"};
        }

        @Override // net.time4j.format.TextProvider
        public String[] eras(String str, Locale locale, TextWidth textWidth) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"B", "A"};
            }
            return new String[]{"BC", "AD"};
        }

        @Override // net.time4j.format.TextProvider
        public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"A", "P"};
            }
            return new String[]{"AM", "PM"};
        }

        public String toString() {
            return "FallbackProvider";
        }
    }

    private static class FormatPatterns implements FormatPatternProvider {
        private final FormatPatternProvider delegate;

        FormatPatterns(FormatPatternProvider formatPatternProvider) {
            this.delegate = formatPatternProvider;
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getDatePattern(DisplayMode displayMode, Locale locale) {
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                return getFormatPattern(DateFormat.getDateInstance(getFormatStyle(displayMode), locale));
            }
            return formatPatternProvider.getDatePattern(displayMode, locale);
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getTimePattern(DisplayMode displayMode, Locale locale) {
            String timePattern;
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                timePattern = getFormatPattern(DateFormat.getTimeInstance(getFormatStyle(displayMode), locale));
            } else if (formatPatternProvider instanceof ExtendedPatterns) {
                timePattern = ((ExtendedPatterns) ExtendedPatterns.class.cast(formatPatternProvider)).getTimePattern(displayMode, locale, true);
            } else {
                timePattern = formatPatternProvider.getTimePattern(displayMode, locale);
            }
            return FormatUtils.removeZones(timePattern);
        }

        @Override // net.time4j.format.FormatPatternProvider
        public String getDateTimePattern(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                return getFormatPattern(DateFormat.getDateTimeInstance(getFormatStyle(displayMode), getFormatStyle(displayMode2), locale));
            }
            return this.delegate.getDateTimePattern(displayMode, displayMode2, locale).replace("{1}", this.delegate.getDatePattern(displayMode, locale)).replace("{0}", formatPatternProvider.getTimePattern(displayMode2, locale));
        }

        private static int getFormatStyle(DisplayMode displayMode) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$DisplayMode[displayMode.ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            if (i == 4) {
                return 3;
            }
            throw new UnsupportedOperationException("Unknown: " + displayMode);
        }

        private static String getFormatPattern(DateFormat dateFormat) {
            if (dateFormat instanceof SimpleDateFormat) {
                return ((SimpleDateFormat) SimpleDateFormat.class.cast(dateFormat)).toPattern();
            }
            throw new IllegalStateException("Cannot retrieve format pattern: " + dateFormat);
        }
    }

    /* JADX INFO: renamed from: net.time4j.format.CalendarText$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$DisplayMode;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        static {
            int[] iArr = new int[DisplayMode.values().length];
            $SwitchMap$net$time4j$format$DisplayMode = iArr;
            try {
                iArr[DisplayMode.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$DisplayMode[DisplayMode.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$DisplayMode[DisplayMode.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$format$DisplayMode[DisplayMode.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TextWidth.values().length];
            $SwitchMap$net$time4j$format$TextWidth = iArr2;
            try {
                iArr2[TextWidth.WIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.ABBREVIATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$time4j$format$TextWidth[TextWidth.NARROW.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }
}
