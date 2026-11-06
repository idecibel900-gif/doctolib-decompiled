package net.time4j.history;

import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.CalendarUnit;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.TextElement;
import net.time4j.format.expert.Iso8601Format;
import net.time4j.history.internal.HistoricVariant;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
public final class ChronoHistory implements Serializable {
    private static final long EARLIEST_CUTOVER;
    private static final ChronoHistory INTRODUCTION_BY_POPE_GREGOR;
    private static final Map LOOKUP;
    public static final ChronoHistory PROLEPTIC_BYZANTINE;
    public static final ChronoHistory PROLEPTIC_GREGORIAN;
    public static final ChronoHistory PROLEPTIC_JULIAN;
    private static final ChronoHistory SWEDEN;
    public static final AttributeKey YEAR_DEFINITION = Attributes.createKey("YEAR_DEFINITION", YearDefinition.class);
    private static final long serialVersionUID = 4100690610730913643L;
    private final transient AncientJulianLeapYears ajly;
    private final transient ChronoElement centuryElement;
    private final transient ChronoElement dateElement;
    private final transient TextElement dayOfMonthElement;
    private final transient TextElement dayOfYearElement;
    private final transient Set elements;
    private final transient ChronoElement eraElement;
    private final transient EraPreference eraPreference;
    private final transient List events;
    private final transient TextElement monthElement;
    private final transient NewYearStrategy nys;
    private final transient HistoricVariant variant;
    private final transient ChronoElement yearAfterElement;
    private final transient ChronoElement yearBeforeElement;
    private final transient TextElement yearOfEraElement;

    static {
        HistoricVariant historicVariant = HistoricVariant.PROLEPTIC_GREGORIAN;
        CalendarAlgorithm calendarAlgorithm = CalendarAlgorithm.GREGORIAN;
        PROLEPTIC_GREGORIAN = new ChronoHistory(historicVariant, Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, calendarAlgorithm, calendarAlgorithm)));
        HistoricVariant historicVariant2 = HistoricVariant.PROLEPTIC_JULIAN;
        CalendarAlgorithm calendarAlgorithm2 = CalendarAlgorithm.JULIAN;
        ChronoHistory chronoHistory = new ChronoHistory(historicVariant2, Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, calendarAlgorithm2, calendarAlgorithm2)));
        PROLEPTIC_JULIAN = chronoHistory;
        HistoricVariant historicVariant3 = HistoricVariant.PROLEPTIC_BYZANTINE;
        List listSingletonList = Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, calendarAlgorithm2, calendarAlgorithm2));
        NewYearRule newYearRule = NewYearRule.BEGIN_OF_SEPTEMBER;
        PROLEPTIC_BYZANTINE = new ChronoHistory(historicVariant3, listSingletonList, null, new NewYearStrategy(newYearRule, Integer.MAX_VALUE), EraPreference.byzantineUntil((PlainDate) PlainDate.axis().getMaximum()));
        long jLongValue = ((Long) PlainDate.of(1582, 10, 15).get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        EARLIEST_CUTOVER = jLongValue;
        INTRODUCTION_BY_POPE_GREGOR = ofGregorianReform(jLongValue);
        ArrayList arrayList = new ArrayList();
        CalendarAlgorithm calendarAlgorithm3 = CalendarAlgorithm.SWEDISH;
        arrayList.add(new CutOverEvent(-57959L, calendarAlgorithm2, calendarAlgorithm3));
        arrayList.add(new CutOverEvent(-53575L, calendarAlgorithm3, calendarAlgorithm2));
        arrayList.add(new CutOverEvent(-38611L, calendarAlgorithm2, calendarAlgorithm));
        ChronoHistory chronoHistory2 = new ChronoHistory(HistoricVariant.SWEDEN, Collections.unmodifiableList(arrayList));
        SWEDEN = chronoHistory2;
        HashMap map = new HashMap();
        HistoricEra historicEra = HistoricEra.AD;
        PlainDate plainDateConvert = chronoHistory.convert(HistoricDate.of(historicEra, 988, 3, 1));
        PlainDate plainDateConvert2 = chronoHistory.convert(HistoricDate.of(historicEra, 1382, 12, 24));
        PlainDate plainDateConvert3 = chronoHistory.convert(HistoricDate.of(historicEra, 1421, 12, 24));
        PlainDate plainDateConvert4 = chronoHistory.convert(HistoricDate.of(historicEra, 1699, 12, 31));
        ChronoHistory chronoHistoryOfFirstGregorianReform = ofFirstGregorianReform();
        NewYearRule newYearRule2 = NewYearRule.BEGIN_OF_JANUARY;
        NewYearStrategy newYearStrategyUntil = newYearRule2.until(1383);
        NewYearRule newYearRule3 = NewYearRule.CHRISTMAS_STYLE;
        map.put("ES", chronoHistoryOfFirstGregorianReform.with(newYearStrategyUntil.and(newYearRule3.until(1556))).with(EraPreference.hispanicUntil(plainDateConvert2)));
        map.put("PT", ofFirstGregorianReform().with(newYearRule2.until(1422).and(newYearRule3.until(1556))).with(EraPreference.hispanicUntil(plainDateConvert3)));
        map.put("FR", ofGregorianReform(PlainDate.of(1582, 12, 20)).with(NewYearRule.EASTER_STYLE.until(1567)));
        map.put("DE", ofFirstGregorianReform().with(newYearRule3.until(1544)));
        map.put("DE-BAYERN", ofGregorianReform(PlainDate.of(1583, 10, 16)).with(newYearRule3.until(1544)));
        map.put("DE-PREUSSEN", ofGregorianReform(PlainDate.of(1610, 9, 2)).with(newYearRule3.until(1559)));
        map.put("DE-PROTESTANT", ofGregorianReform(PlainDate.of(1700, 3, 1)).with(newYearRule3.until(1559)));
        map.put("NL", ofGregorianReform(PlainDate.of(1583, 1, 1)));
        map.put("AT", ofGregorianReform(PlainDate.of(1584, 1, 17)));
        map.put("CH", ofGregorianReform(PlainDate.of(1584, 1, 22)));
        map.put("HU", ofGregorianReform(PlainDate.of(1587, 11, 1)));
        ChronoHistory chronoHistoryOfGregorianReform = ofGregorianReform(PlainDate.of(1700, 3, 1));
        NewYearRule newYearRule4 = NewYearRule.MARIA_ANUNCIATA;
        map.put("DK", chronoHistoryOfGregorianReform.with(newYearRule4.until(1623)));
        map.put("NO", ofGregorianReform(PlainDate.of(1700, 3, 1)).with(newYearRule4.until(1623)));
        map.put("IT", ofFirstGregorianReform().with(newYearRule3.until(1583)));
        map.put("IT-FLORENCE", ofFirstGregorianReform().with(newYearRule4.until(1749)));
        map.put("IT-PISA", ofFirstGregorianReform().with(NewYearRule.CALCULUS_PISANUS.until(1749)));
        ChronoHistory chronoHistoryOfFirstGregorianReform2 = ofFirstGregorianReform();
        NewYearRule newYearRule5 = NewYearRule.BEGIN_OF_MARCH;
        map.put("IT-VENICE", chronoHistoryOfFirstGregorianReform2.with(newYearRule5.until(1798)));
        map.put("GB", ofGregorianReform(PlainDate.of(1752, 9, 14)).with(newYearRule3.until(1087).and(newYearRule2.until(1155)).and(newYearRule4.until(1752))));
        map.put("GB-SCT", ofGregorianReform(PlainDate.of(1752, 9, 14)).with(newYearRule3.until(1087).and(newYearRule2.until(1155)).and(newYearRule4.until(1600))));
        map.put("RU", ofGregorianReform(PlainDate.of(1918, 2, 14)).with(newYearRule2.until(988).and(newYearRule5.until(1493)).and(newYearRule.until(1700))).with(EraPreference.byzantineBetween(plainDateConvert, plainDateConvert4)));
        map.put("SE", chronoHistory2);
        LOOKUP = Collections.unmodifiableMap(map);
    }

    private ChronoHistory(HistoricVariant historicVariant, List list) {
        this(historicVariant, list, null, null, EraPreference.DEFAULT);
    }

    private ChronoHistory(HistoricVariant historicVariant, List list, AncientJulianLeapYears ancientJulianLeapYears, NewYearStrategy newYearStrategy, EraPreference eraPreference) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one cutover event must be present in chronological history.");
        }
        if (historicVariant == null) {
            throw new NullPointerException("Missing historic variant.");
        }
        if (eraPreference == null) {
            throw new NullPointerException("Missing era preference.");
        }
        this.variant = historicVariant;
        this.events = list;
        this.ajly = ancientJulianLeapYears;
        this.nys = newYearStrategy;
        this.eraPreference = eraPreference;
        HistoricDateElement historicDateElement = new HistoricDateElement(this);
        this.dateElement = historicDateElement;
        HistoricEraElement historicEraElement = new HistoricEraElement(this);
        this.eraElement = historicEraElement;
        HistoricIntegerElement historicIntegerElement = new HistoricIntegerElement('y', 1, 999999999, this, 2);
        this.yearOfEraElement = historicIntegerElement;
        HistoricIntegerElement historicIntegerElement2 = new HistoricIntegerElement((char) 0, 1, 999999999, this, 6);
        this.yearAfterElement = historicIntegerElement2;
        HistoricIntegerElement historicIntegerElement3 = new HistoricIntegerElement((char) 0, 1, 999999999, this, 7);
        this.yearBeforeElement = historicIntegerElement3;
        HistoricIntegerElement historicIntegerElement4 = new HistoricIntegerElement('M', 1, 12, this, 3);
        this.monthElement = historicIntegerElement4;
        HistoricIntegerElement historicIntegerElement5 = new HistoricIntegerElement('d', 1, 31, this, 4);
        this.dayOfMonthElement = historicIntegerElement5;
        HistoricIntegerElement historicIntegerElement6 = new HistoricIntegerElement('D', 1, 365, this, 5);
        this.dayOfYearElement = historicIntegerElement6;
        HistoricIntegerElement historicIntegerElement7 = new HistoricIntegerElement((char) 0, 1, 10000000, this, 8);
        this.centuryElement = historicIntegerElement7;
        HashSet hashSet = new HashSet();
        hashSet.add(historicDateElement);
        hashSet.add(historicEraElement);
        hashSet.add(historicIntegerElement);
        hashSet.add(historicIntegerElement2);
        hashSet.add(historicIntegerElement3);
        hashSet.add(historicIntegerElement4);
        hashSet.add(historicIntegerElement5);
        hashSet.add(historicIntegerElement6);
        hashSet.add(historicIntegerElement7);
        this.elements = Collections.unmodifiableSet(hashSet);
    }

    public static ChronoHistory ofFirstGregorianReform() {
        return INTRODUCTION_BY_POPE_GREGOR;
    }

    public static ChronoHistory ofGregorianReform(PlainDate plainDate) {
        if (plainDate.equals(PlainDate.axis().getMaximum())) {
            return PROLEPTIC_JULIAN;
        }
        if (plainDate.equals(PlainDate.axis().getMinimum())) {
            return PROLEPTIC_GREGORIAN;
        }
        long jLongValue = ((Long) plainDate.get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        check(jLongValue);
        if (jLongValue == EARLIEST_CUTOVER) {
            return INTRODUCTION_BY_POPE_GREGOR;
        }
        return ofGregorianReform(jLongValue);
    }

    public static ChronoHistory of(Locale locale) {
        ChronoHistory chronoHistory;
        String country = locale.getCountry();
        if (locale.getVariant().isEmpty()) {
            chronoHistory = null;
        } else {
            country = country + "-" + locale.getVariant();
            chronoHistory = (ChronoHistory) LOOKUP.get(country);
        }
        if (chronoHistory == null) {
            chronoHistory = (ChronoHistory) LOOKUP.get(country);
        }
        return chronoHistory == null ? ofFirstGregorianReform() : chronoHistory;
    }

    public static ChronoHistory ofSweden() {
        return SWEDEN;
    }

    public boolean isValid(HistoricDate historicDate) {
        Calculus algorithm;
        return (historicDate == null || isOutOfRange(historicDate) || (algorithm = getAlgorithm(historicDate)) == null || !algorithm.isValid(historicDate)) ? false : true;
    }

    public PlainDate convert(HistoricDate historicDate) {
        if (isOutOfRange(historicDate)) {
            throw new IllegalArgumentException("Out of supported range: " + historicDate);
        }
        Calculus algorithm = getAlgorithm(historicDate);
        if (algorithm == null) {
            throw new IllegalArgumentException("Invalid historic date: " + historicDate);
        }
        return PlainDate.of(algorithm.toMJD(historicDate), EpochDays.MODIFIED_JULIAN_DATE);
    }

    public HistoricDate convert(PlainDate plainDate) {
        HistoricDate historicDateOf;
        long jLongValue = ((Long) plainDate.get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        int size = this.events.size() - 1;
        while (true) {
            if (size < 0) {
                historicDateOf = null;
                break;
            }
            CutOverEvent cutOverEvent = (CutOverEvent) this.events.get(size);
            if (jLongValue >= cutOverEvent.start) {
                historicDateOf = cutOverEvent.algorithm.fromMJD(jLongValue);
                break;
            }
            size--;
        }
        if (historicDateOf == null) {
            historicDateOf = getJulianAlgorithm().fromMJD(jLongValue);
        }
        HistoricEra preferredEra = this.eraPreference.getPreferredEra(historicDateOf, plainDate);
        if (preferredEra != historicDateOf.getEra()) {
            historicDateOf = HistoricDate.of(preferredEra, preferredEra.yearOfEra(historicDateOf.getEra(), historicDateOf.getYearOfEra()), historicDateOf.getMonth(), historicDateOf.getDayOfMonth());
        }
        if (!isOutOfRange(historicDateOf)) {
            return historicDateOf;
        }
        throw new IllegalArgumentException("Out of supported range: " + historicDateOf);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0088  */
    /* JADX WARN: Code duplicated, block: B:22:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a4 A[LOOP:0: B:23:0x00a1->B:25:0x00a4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:32:0x00df  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:48:0x012a  */
    /* JADX WARN: Code duplicated, block: B:50:0x013d  */
    /* JADX WARN: Code duplicated, block: B:53:0x016b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x016d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0170 A[Catch: ParseException -> 0x01a2, TryCatch #0 {ParseException -> 0x01a2, blocks: (B:51:0x0141, B:56:0x0170, B:58:0x0179, B:59:0x018f, B:60:0x0190, B:62:0x0199), top: B:77:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0179 A[Catch: ParseException -> 0x01a2, TryCatch #0 {ParseException -> 0x01a2, blocks: (B:51:0x0141, B:56:0x0170, B:58:0x0179, B:59:0x018f, B:60:0x0190, B:62:0x0199), top: B:77:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0190 A[Catch: ParseException -> 0x01a2, TryCatch #0 {ParseException -> 0x01a2, blocks: (B:51:0x0141, B:56:0x0170, B:58:0x0179, B:59:0x018f, B:60:0x0190, B:62:0x0199), top: B:77:0x0141 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0199 A[Catch: ParseException -> 0x01a2, TRY_LEAVE, TryCatch #0 {ParseException -> 0x01a2, blocks: (B:51:0x0141, B:56:0x0170, B:58:0x0179, B:59:0x018f, B:60:0x0190, B:62:0x0199), top: B:77:0x0141 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0179, please report this as an issue */
    public static ChronoHistory from(String str) {
        ChronoHistory chronoHistoryOfSweden;
        int i;
        String[] strArrSplit;
        String[] strArrSplit2;
        String[] strArrSplit3;
        String strSubstring;
        PlainDate date;
        PlainDate date2;
        int i2;
        NewYearStrategy newYearStrategyAnd;
        int i3;
        String[] strArrSplit4;
        NewYearRule newYearRuleValueOf;
        int i4;
        String strSubstring2;
        String[] strArrSplit5;
        int[] iArr;
        int i5;
        if (!str.startsWith("historic-")) {
            throw new IllegalArgumentException("Variant does not start with \"historic-\": " + str);
        }
        String[] strArrSplit6 = str.substring(9).split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (strArrSplit6.length == 0) {
            throw new IllegalArgumentException("Invalid variant description.");
        }
        HistoricVariant historicVariantValueOf = HistoricVariant.valueOf(strArrSplit6[0]);
        switch (AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[historicVariantValueOf.ordinal()]) {
            case 1:
                return PROLEPTIC_GREGORIAN;
            case 2:
                return PROLEPTIC_JULIAN;
            case 3:
                return PROLEPTIC_BYZANTINE;
            case 4:
                chronoHistoryOfSweden = ofSweden();
                i = 1;
                strArrSplit = strArrSplit6[i].split(f.b);
                if (strArrSplit[0].equals("ancient-julian-leap-years")) {
                    String str2 = strArrSplit[1];
                    strSubstring2 = str2.substring(1, str2.length() - 1);
                    if (!strSubstring2.isEmpty()) {
                        strArrSplit5 = strSubstring2.split(f.a);
                        iArr = new int[strArrSplit5.length];
                        for (i5 = 0; i5 < strArrSplit5.length; i5++) {
                            iArr[i5] = 1 - Integer.parseInt(strArrSplit5[i5]);
                        }
                        chronoHistoryOfSweden = chronoHistoryOfSweden.with(AncientJulianLeapYears.of(iArr));
                    }
                }
                strArrSplit2 = strArrSplit6[i + 1].split(f.b);
                if (strArrSplit2[0].equals("new-year-strategy")) {
                    String str3 = strArrSplit2[1];
                    newYearStrategyAnd = null;
                    for (String str4 : str3.substring(1, str3.length() - 1).split(f.a)) {
                        strArrSplit4 = str4.split("->");
                        newYearRuleValueOf = NewYearRule.valueOf(strArrSplit4[0]);
                        if (strArrSplit4.length == 2) {
                            i4 = Integer.parseInt(strArrSplit4[1]);
                        } else {
                            i4 = Integer.MAX_VALUE;
                        }
                        if (newYearStrategyAnd == null) {
                            if (newYearRuleValueOf == NewYearRule.BEGIN_OF_JANUARY || i4 != 567) {
                                newYearStrategyAnd = newYearRuleValueOf.until(i4);
                            }
                        } else {
                            newYearStrategyAnd = newYearStrategyAnd.and(newYearRuleValueOf.until(i4));
                        }
                    }
                    chronoHistoryOfSweden = chronoHistoryOfSweden.with(newYearStrategyAnd);
                }
                strArrSplit3 = strArrSplit6[i + 2].split(f.b);
                if (strArrSplit3[0].equals("era-preference")) {
                    String str5 = strArrSplit3[1];
                    strSubstring = str5.substring(1, str5.length() - 1);
                    if (!strSubstring.equals("default")) {
                        String[] strArrSplit7 = strSubstring.split(f.a);
                        try {
                            HistoricEra historicEraValueOf = HistoricEra.valueOf(strArrSplit7[0].substring(5));
                            date = Iso8601Format.parseDate(strArrSplit7[1].substring(7));
                            date2 = Iso8601Format.parseDate(strArrSplit7[2].substring(5));
                            i2 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[historicEraValueOf.ordinal()];
                            if (i2 == 1) {
                                return chronoHistoryOfSweden.with(EraPreference.hispanicBetween(date, date2));
                            }
                            if (i2 == 2) {
                                return chronoHistoryOfSweden.with(EraPreference.byzantineBetween(date, date2));
                            }
                            if (i2 == 3) {
                                return chronoHistoryOfSweden.with(EraPreference.abUrbeConditaBetween(date, date2));
                            }
                            throw new IllegalArgumentException("BC/AD not allowed as era preference: " + str);
                        } catch (ParseException unused) {
                            throw new IllegalArgumentException("Invalid date syntax: " + str);
                        }
                    }
                }
                return chronoHistoryOfSweden;
            case 5:
                if (!getGregorianCutOverDate(strArrSplit6, str).equals(PlainDate.of(1582, 10, 15))) {
                    throw new IllegalArgumentException("Inconsistent cutover date: " + str);
                }
                chronoHistoryOfSweden = ofFirstGregorianReform();
                i = 2;
                strArrSplit = strArrSplit6[i].split(f.b);
                if (strArrSplit[0].equals("ancient-julian-leap-years")) {
                    String str6 = strArrSplit[1];
                    strSubstring2 = str6.substring(1, str6.length() - 1);
                    if (!strSubstring2.isEmpty()) {
                        strArrSplit5 = strSubstring2.split(f.a);
                        iArr = new int[strArrSplit5.length];
                        while (i5 < strArrSplit5.length) {
                            iArr[i5] = 1 - Integer.parseInt(strArrSplit5[i5]);
                        }
                        chronoHistoryOfSweden = chronoHistoryOfSweden.with(AncientJulianLeapYears.of(iArr));
                    }
                }
                strArrSplit2 = strArrSplit6[i + 1].split(f.b);
                if (strArrSplit2[0].equals("new-year-strategy")) {
                    String str7 = strArrSplit2[1];
                    newYearStrategyAnd = null;
                    while (i3 < r6.length) {
                        strArrSplit4 = str4.split("->");
                        newYearRuleValueOf = NewYearRule.valueOf(strArrSplit4[0]);
                        if (strArrSplit4.length == 2) {
                            i4 = Integer.parseInt(strArrSplit4[1]);
                        } else {
                            i4 = Integer.MAX_VALUE;
                        }
                        if (newYearStrategyAnd == null) {
                            if (newYearRuleValueOf == NewYearRule.BEGIN_OF_JANUARY) {
                                newYearStrategyAnd = newYearRuleValueOf.until(i4);
                            } else {
                                newYearStrategyAnd = newYearRuleValueOf.until(i4);
                            }
                        } else {
                            newYearStrategyAnd = newYearStrategyAnd.and(newYearRuleValueOf.until(i4));
                        }
                    }
                    chronoHistoryOfSweden = chronoHistoryOfSweden.with(newYearStrategyAnd);
                }
                strArrSplit3 = strArrSplit6[i + 2].split(f.b);
                if (strArrSplit3[0].equals("era-preference")) {
                    String str8 = strArrSplit3[1];
                    strSubstring = str8.substring(1, str8.length() - 1);
                    if (!strSubstring.equals("default")) {
                        String[] strArrSplit8 = strSubstring.split(f.a);
                        HistoricEra historicEraValueOf2 = HistoricEra.valueOf(strArrSplit8[0].substring(5));
                        date = Iso8601Format.parseDate(strArrSplit8[1].substring(7));
                        date2 = Iso8601Format.parseDate(strArrSplit8[2].substring(5));
                        i2 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[historicEraValueOf2.ordinal()];
                        if (i2 == 1) {
                            return chronoHistoryOfSweden.with(EraPreference.hispanicBetween(date, date2));
                        }
                        if (i2 == 2) {
                            return chronoHistoryOfSweden.with(EraPreference.byzantineBetween(date, date2));
                        }
                        if (i2 == 3) {
                            return chronoHistoryOfSweden.with(EraPreference.abUrbeConditaBetween(date, date2));
                        }
                        throw new IllegalArgumentException("BC/AD not allowed as era preference: " + str);
                    }
                }
                return chronoHistoryOfSweden;
            case 6:
                chronoHistoryOfSweden = ofGregorianReform(getGregorianCutOverDate(strArrSplit6, str));
                i = 2;
                strArrSplit = strArrSplit6[i].split(f.b);
                if (strArrSplit[0].equals("ancient-julian-leap-years")) {
                    String str9 = strArrSplit[1];
                    strSubstring2 = str9.substring(1, str9.length() - 1);
                    if (!strSubstring2.isEmpty()) {
                        strArrSplit5 = strSubstring2.split(f.a);
                        iArr = new int[strArrSplit5.length];
                        while (i5 < strArrSplit5.length) {
                            iArr[i5] = 1 - Integer.parseInt(strArrSplit5[i5]);
                        }
                        chronoHistoryOfSweden = chronoHistoryOfSweden.with(AncientJulianLeapYears.of(iArr));
                    }
                }
                strArrSplit2 = strArrSplit6[i + 1].split(f.b);
                if (strArrSplit2[0].equals("new-year-strategy")) {
                    String str10 = strArrSplit2[1];
                    newYearStrategyAnd = null;
                    while (i3 < r6.length) {
                        strArrSplit4 = str4.split("->");
                        newYearRuleValueOf = NewYearRule.valueOf(strArrSplit4[0]);
                        if (strArrSplit4.length == 2) {
                            i4 = Integer.parseInt(strArrSplit4[1]);
                        } else {
                            i4 = Integer.MAX_VALUE;
                        }
                        if (newYearStrategyAnd == null) {
                            if (newYearRuleValueOf == NewYearRule.BEGIN_OF_JANUARY) {
                                newYearStrategyAnd = newYearRuleValueOf.until(i4);
                            } else {
                                newYearStrategyAnd = newYearRuleValueOf.until(i4);
                            }
                        } else {
                            newYearStrategyAnd = newYearStrategyAnd.and(newYearRuleValueOf.until(i4));
                        }
                    }
                    chronoHistoryOfSweden = chronoHistoryOfSweden.with(newYearStrategyAnd);
                }
                strArrSplit3 = strArrSplit6[i + 2].split(f.b);
                if (strArrSplit3[0].equals("era-preference")) {
                    String str11 = strArrSplit3[1];
                    strSubstring = str11.substring(1, str11.length() - 1);
                    if (!strSubstring.equals("default")) {
                        String[] strArrSplit9 = strSubstring.split(f.a);
                        HistoricEra historicEraValueOf3 = HistoricEra.valueOf(strArrSplit9[0].substring(5));
                        date = Iso8601Format.parseDate(strArrSplit9[1].substring(7));
                        date2 = Iso8601Format.parseDate(strArrSplit9[2].substring(5));
                        i2 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[historicEraValueOf3.ordinal()];
                        if (i2 == 1) {
                            return chronoHistoryOfSweden.with(EraPreference.hispanicBetween(date, date2));
                        }
                        if (i2 == 2) {
                            return chronoHistoryOfSweden.with(EraPreference.byzantineBetween(date, date2));
                        }
                        if (i2 == 3) {
                            return chronoHistoryOfSweden.with(EraPreference.abUrbeConditaBetween(date, date2));
                        }
                        throw new IllegalArgumentException("BC/AD not allowed as era preference: " + str);
                    }
                }
                return chronoHistoryOfSweden;
            default:
                throw new UnsupportedOperationException(historicVariantValueOf.name());
        }
    }

    private static PlainDate getGregorianCutOverDate(String[] strArr, String str) {
        String[] strArrSplit = strArr[1].split(f.b);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Invalid syntax in variant description: " + str);
        }
        if (strArrSplit[0].equals("cutover")) {
            try {
                return (PlainDate) Iso8601Format.EXTENDED_DATE.parse(strArrSplit[1]);
            } catch (ParseException unused) {
            }
        }
        throw new IllegalArgumentException("Invalid cutover definition: " + str);
    }

    public String getVariant() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("historic-");
        sb.append(this.variant.name());
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[this.variant.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            sb.append(":no-cutover");
        } else {
            if (i == 5 || i == 6) {
                sb.append(":cutover=");
                sb.append(getGregorianCutOverDate());
            }
            sb.append(":ancient-julian-leap-years=");
            AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
            if (ancientJulianLeapYears != null) {
                int[] pattern = ancientJulianLeapYears.getPattern();
                sb.append('[');
                sb.append(pattern[0]);
                for (int i2 = 1; i2 < pattern.length; i2++) {
                    sb.append(',');
                    sb.append(pattern[i2]);
                }
                sb.append(']');
            } else {
                sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            sb.append(":new-year-strategy=");
            sb.append(getNewYearStrategy());
            sb.append(":era-preference=");
            sb.append(getEraPreference());
        }
        return sb.toString();
    }

    public PlainDate getGregorianCutOverDate() {
        List list = this.events;
        long j = ((CutOverEvent) list.get(list.size() - 1)).start;
        if (j == Long.MIN_VALUE) {
            throw new UnsupportedOperationException("Proleptic history without any gregorian reform date.");
        }
        return PlainDate.of(j, EpochDays.MODIFIED_JULIAN_DATE);
    }

    public boolean hasGregorianCutOverDate() {
        List list = this.events;
        return ((CutOverEvent) list.get(list.size() - 1)).start > Long.MIN_VALUE;
    }

    public HistoricDate getBeginOfYear(HistoricEra historicEra, int i) {
        HistoricDate historicDateNewYear = getNewYearStrategy().newYear(historicEra, i);
        if (isValid(historicDateNewYear)) {
            HistoricEra preferredEra = this.eraPreference.getPreferredEra(historicDateNewYear, convert(historicDateNewYear));
            return preferredEra != historicEra ? HistoricDate.of(preferredEra, preferredEra.yearOfEra(historicDateNewYear.getEra(), historicDateNewYear.getYearOfEra()), historicDateNewYear.getMonth(), historicDateNewYear.getDayOfMonth()) : historicDateNewYear;
        }
        throw new IllegalArgumentException("Cannot determine valid New Year: " + historicEra + "-" + i);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004c  */
    public int getLengthOfYear(HistoricEra historicEra, int i) {
        HistoricDate historicDateNewYear;
        HistoricDate historicDateNewYear2;
        try {
            NewYearStrategy newYearStrategy = this.nys;
            int i2 = 1;
            if (newYearStrategy == null) {
                historicDateNewYear = HistoricDate.of(historicEra, i, 1, 1);
                historicDateNewYear2 = HistoricDate.of(historicEra, i, 12, 31);
            } else {
                historicDateNewYear = newYearStrategy.newYear(historicEra, i);
                if (historicEra != HistoricEra.BC) {
                    HistoricDate historicDateNewYear3 = this.nys.newYear(historicEra, i + 1);
                    if (historicEra == HistoricEra.BYZANTINE) {
                        historicDateNewYear2 = this.nys.newYear(HistoricEra.AD, historicEra.annoDomini(i));
                        if (historicDateNewYear2.compareTo(historicDateNewYear) <= 0) {
                            historicDateNewYear2 = historicDateNewYear3;
                        }
                    } else {
                        historicDateNewYear2 = historicDateNewYear3;
                    }
                } else if (i == 1) {
                    historicDateNewYear2 = this.nys.newYear(HistoricEra.AD, 1);
                } else {
                    historicDateNewYear2 = this.nys.newYear(historicEra, i - 1);
                }
                i2 = 0;
            }
            return (int) (CalendarUnit.DAYS.between(convert(historicDateNewYear), convert(historicDateNewYear2)) + ((long) i2));
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public AncientJulianLeapYears getAncientJulianLeapYears() {
        AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
        if (ancientJulianLeapYears != null) {
            return ancientJulianLeapYears;
        }
        throw new UnsupportedOperationException("No historic julian leap years were defined.");
    }

    public boolean hasAncientJulianLeapYears() {
        return this.ajly != null;
    }

    public ChronoHistory with(AncientJulianLeapYears ancientJulianLeapYears) {
        if (ancientJulianLeapYears != null) {
            return !hasGregorianCutOverDate() ? this : new ChronoHistory(this.variant, this.events, ancientJulianLeapYears, this.nys, this.eraPreference);
        }
        throw new NullPointerException("Missing ancient julian leap years.");
    }

    public NewYearStrategy getNewYearStrategy() {
        NewYearStrategy newYearStrategy = this.nys;
        return newYearStrategy == null ? NewYearStrategy.DEFAULT : newYearStrategy;
    }

    public ChronoHistory with(NewYearStrategy newYearStrategy) {
        if (newYearStrategy.equals(NewYearStrategy.DEFAULT)) {
            if (this.nys != null) {
                return new ChronoHistory(this.variant, this.events, this.ajly, null, this.eraPreference);
            }
        } else if (hasGregorianCutOverDate()) {
            return new ChronoHistory(this.variant, this.events, this.ajly, newYearStrategy, this.eraPreference);
        }
        return this;
    }

    public ChronoHistory with(EraPreference eraPreference) {
        return (eraPreference.equals(this.eraPreference) || !hasGregorianCutOverDate()) ? this : new ChronoHistory(this.variant, this.events, this.ajly, this.nys, eraPreference);
    }

    public ChronoElement date() {
        return this.dateElement;
    }

    public ChronoElement era() {
        return this.eraElement;
    }

    public TextElement yearOfEra() {
        return this.yearOfEraElement;
    }

    /* JADX INFO: renamed from: net.time4j.history.ChronoHistory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$HistoricEra;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$YearDefinition;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$internal$HistoricVariant;

        static {
            int[] iArr = new int[YearDefinition.values().length];
            $SwitchMap$net$time4j$history$YearDefinition = iArr;
            try {
                iArr[YearDefinition.DUAL_DATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$history$YearDefinition[YearDefinition.AFTER_NEW_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$history$YearDefinition[YearDefinition.BEFORE_NEW_YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[HistoricEra.values().length];
            $SwitchMap$net$time4j$history$HistoricEra = iArr2;
            try {
                iArr2[HistoricEra.HISPANIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$time4j$history$HistoricEra[HistoricEra.BYZANTINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$time4j$history$HistoricEra[HistoricEra.AB_URBE_CONDITA.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[HistoricVariant.values().length];
            $SwitchMap$net$time4j$history$internal$HistoricVariant = iArr3;
            try {
                iArr3[HistoricVariant.PROLEPTIC_GREGORIAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$net$time4j$history$internal$HistoricVariant[HistoricVariant.PROLEPTIC_JULIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$net$time4j$history$internal$HistoricVariant[HistoricVariant.PROLEPTIC_BYZANTINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$net$time4j$history$internal$HistoricVariant[HistoricVariant.SWEDEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$net$time4j$history$internal$HistoricVariant[HistoricVariant.INTRODUCTION_ON_1582_10_15.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$net$time4j$history$internal$HistoricVariant[HistoricVariant.SINGLE_CUTOVER_DATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public ChronoElement yearOfEra(YearDefinition yearDefinition) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$YearDefinition[yearDefinition.ordinal()];
        if (i == 1) {
            return this.yearOfEraElement;
        }
        if (i == 2) {
            return this.yearAfterElement;
        }
        if (i == 3) {
            return this.yearBeforeElement;
        }
        throw new UnsupportedOperationException(yearDefinition.name());
    }

    public ChronoElement centuryOfEra() {
        return this.centuryElement;
    }

    public TextElement month() {
        return this.monthElement;
    }

    public ChronoElement dayOfMonth() {
        return this.dayOfMonthElement;
    }

    public ChronoElement dayOfYear() {
        return this.dayOfYearElement;
    }

    public Set getElements() {
        return this.elements;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoHistory) {
            ChronoHistory chronoHistory = (ChronoHistory) obj;
            if (this.variant == chronoHistory.variant && isEqual(this.ajly, chronoHistory.ajly) && isEqual(this.nys, chronoHistory.nys) && this.eraPreference.equals(chronoHistory.eraPreference)) {
                return this.variant != HistoricVariant.SINGLE_CUTOVER_DATE || ((CutOverEvent) this.events.get(0)).start == ((CutOverEvent) chronoHistory.events.get(0)).start;
            }
        }
        return false;
    }

    public int hashCode() {
        HistoricVariant historicVariant = this.variant;
        if (historicVariant == HistoricVariant.SINGLE_CUTOVER_DATE) {
            long j = ((CutOverEvent) this.events.get(0)).start;
            return (int) (j ^ (j << 32));
        }
        return historicVariant.hashCode();
    }

    public String toString() {
        return "ChronoHistory[" + getVariant() + "]";
    }

    Calculus getAlgorithm(HistoricDate historicDate) {
        for (int size = this.events.size() - 1; size >= 0; size--) {
            CutOverEvent cutOverEvent = (CutOverEvent) this.events.get(size);
            if (historicDate.compareTo(cutOverEvent.dateAtCutOver) >= 0) {
                return cutOverEvent.algorithm;
            }
            if (historicDate.compareTo(cutOverEvent.dateBeforeCutOver) > 0) {
                return null;
            }
        }
        return getJulianAlgorithm();
    }

    HistoricDate adjustDayOfMonth(HistoricDate historicDate) {
        int maximumDayOfMonth;
        Calculus algorithm = getAlgorithm(historicDate);
        return (algorithm != null && (maximumDayOfMonth = algorithm.getMaximumDayOfMonth(historicDate)) < historicDate.getDayOfMonth()) ? HistoricDate.of(historicDate.getEra(), historicDate.getYearOfEra(), historicDate.getMonth(), maximumDayOfMonth) : historicDate;
    }

    List getEvents() {
        return this.events;
    }

    HistoricVariant getHistoricVariant() {
        return this.variant;
    }

    EraPreference getEraPreference() {
        return this.eraPreference;
    }

    private boolean isOutOfRange(HistoricDate historicDate) {
        int iAnnoDomini = historicDate.getEra().annoDomini(historicDate.getYearOfEra());
        if (this == PROLEPTIC_BYZANTINE) {
            return iAnnoDomini < -5508 || (iAnnoDomini == -5508 && historicDate.getMonth() < 9) || iAnnoDomini > 999979465;
        }
        if (this == PROLEPTIC_JULIAN) {
            return Math.abs(iAnnoDomini) > 999979465;
        }
        if (this == PROLEPTIC_GREGORIAN) {
            return Math.abs(iAnnoDomini) > 999999999;
        }
        return iAnnoDomini < -44 || iAnnoDomini > 9999;
    }

    private Calculus getJulianAlgorithm() {
        AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
        if (ancientJulianLeapYears != null) {
            return ancientJulianLeapYears.getCalculus();
        }
        return CalendarAlgorithm.JULIAN;
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static void check(long j) {
        if (j < EARLIEST_CUTOVER) {
            throw new IllegalArgumentException("Gregorian calendar did not exist before 1582-10-15");
        }
    }

    private static ChronoHistory ofGregorianReform(long j) {
        return new ChronoHistory(j == EARLIEST_CUTOVER ? HistoricVariant.INTRODUCTION_ON_1582_10_15 : HistoricVariant.SINGLE_CUTOVER_DATE, Collections.singletonList(new CutOverEvent(j, CalendarAlgorithm.JULIAN, CalendarAlgorithm.GREGORIAN)));
    }

    private Object writeReplace() {
        return new SPX(this, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
