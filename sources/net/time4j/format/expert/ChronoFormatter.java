package net.time4j.format.expert;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.time4j.CalendarUnit;
import net.time4j.DayPeriod;
import net.time4j.GeneralTimestamp;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.ProportionalElement;
import net.time4j.WallTimeElement;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.FlagElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.history.ChronoHistory;
import net.time4j.history.internal.HistoricAttribute;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.OverlapResolver;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;

/* JADX INFO: loaded from: classes5.dex */
public final class ChronoFormatter implements ChronoPrinter, ChronoParser {
    public static final ChronoFormatter RFC_1123 = rfc1123();
    private final Chronology chronology;
    private final int countOfElements;
    private final Chronology deepestParser;
    private final Map defaults;
    private final FractionProcessor fracproc;
    private final AttributeSet globalAttributes;
    private final boolean hasOptionals;
    private final boolean hasOrMarkers;
    private final boolean indexable;
    private final Leniency leniency;
    private final boolean needsExtensions;
    private final boolean noPreparser;
    private final OverrideHandler overrideHandler;
    private final boolean singleStepMode;
    private final int stepCount;
    private final List steps;
    private final boolean trailing;

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cast(Object obj) {
        return obj;
    }

    private ChronoFormatter(Chronology chronology, Chronology chronology2, Locale locale, List list, Map map, Attributes attributes, Chronology chronology3) {
        if (chronology == null) {
            throw new NullPointerException("Missing chronology.");
        }
        if (list.isEmpty()) {
            throw new IllegalStateException("No format processors defined.");
        }
        this.chronology = chronology;
        this.overrideHandler = OverrideHandler.of(chronology2);
        this.deepestParser = chronology3;
        AttributeSet attributeSetCreateDefaults = AttributeSet.createDefaults(chronology2 == null ? chronology : chronology2, attributes, locale);
        this.globalAttributes = attributeSetCreateDefaults;
        this.leniency = (Leniency) attributeSetCreateDefaults.get(Attributes.LENIENCY, Leniency.SMART);
        this.defaults = Collections.unmodifiableMap(map);
        Iterator it = list.iterator();
        FractionProcessor fractionProcessor = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = false;
        boolean zNeedsExtension = false;
        int i = 0;
        while (it.hasNext()) {
            FormatStep formatStep = (FormatStep) it.next();
            z3 = formatStep.isNewOrBlockStarted() ? true : z3;
            if (fractionProcessor == null && (formatStep.getProcessor() instanceof FractionProcessor)) {
                fractionProcessor = (FractionProcessor) FractionProcessor.class.cast(formatStep.getProcessor());
            }
            if (!z2 && formatStep.getLevel() > 0) {
                z2 = true;
            }
            ChronoElement element = formatStep.getProcessor().getElement();
            if (element != null) {
                i++;
                if (z && !ParsedValues.isIndexed(element)) {
                    z = false;
                }
                if (!zNeedsExtension) {
                    zNeedsExtension = needsExtension(chronology, chronology2, element);
                }
            }
        }
        this.fracproc = fractionProcessor;
        this.hasOptionals = z2;
        this.hasOrMarkers = z3;
        this.needsExtensions = zNeedsExtension;
        this.countOfElements = i;
        this.indexable = z;
        this.trailing = ((Boolean) this.globalAttributes.get(Attributes.TRAILING_CHARACTERS, Boolean.FALSE)).booleanValue();
        this.noPreparser = hasNoPreparser();
        this.stepCount = list.size();
        this.steps = freeze(list);
        this.singleStepMode = getSingleStepMode();
    }

    private ChronoFormatter(ChronoFormatter chronoFormatter, Attributes attributes) {
        this(chronoFormatter, chronoFormatter.globalAttributes.withAttributes(attributes), (ChronoHistory) null);
    }

    private ChronoFormatter(ChronoFormatter chronoFormatter, AttributeSet attributeSet) {
        this(chronoFormatter, attributeSet, (ChronoHistory) null);
    }

    private ChronoFormatter(ChronoFormatter chronoFormatter, AttributeSet attributeSet, ChronoHistory chronoHistory) {
        ChronoElement chronoElementMonth;
        if (attributeSet == null) {
            throw new NullPointerException("Missing global format attributes.");
        }
        this.chronology = chronoFormatter.chronology;
        this.overrideHandler = chronoFormatter.overrideHandler;
        this.deepestParser = chronoFormatter.deepestParser;
        this.globalAttributes = attributeSet;
        this.leniency = (Leniency) attributeSet.get(Attributes.LENIENCY, Leniency.SMART);
        this.defaults = Collections.unmodifiableMap(new NonAmbivalentMap(chronoFormatter.defaults));
        this.fracproc = chronoFormatter.fracproc;
        this.hasOptionals = chronoFormatter.hasOptionals;
        this.hasOrMarkers = chronoFormatter.hasOrMarkers;
        this.needsExtensions = chronoFormatter.needsExtensions || chronoHistory != null;
        this.countOfElements = chronoFormatter.countOfElements;
        int size = chronoFormatter.steps.size();
        ArrayList arrayList = new ArrayList(chronoFormatter.steps);
        boolean z = chronoFormatter.indexable;
        for (int i = 0; i < size; i++) {
            FormatStep formatStep = (FormatStep) arrayList.get(i);
            ChronoElement element = formatStep.getProcessor().getElement();
            Chronology chronologyPreparser = this.chronology;
            chronologyPreparser = chronologyPreparser == Moment.axis() ? chronologyPreparser.preparser() : chronologyPreparser;
            if (element != null && !chronologyPreparser.isRegistered(element)) {
                for (ChronoExtension chronoExtension : chronologyPreparser.getExtensions()) {
                    if (chronoExtension.getElements(chronoFormatter.getLocale(), chronoFormatter.globalAttributes).contains(element)) {
                        for (ChronoElement chronoElement : chronoExtension.getElements(attributeSet.getLocale(), attributeSet)) {
                            if (chronoElement.name().equals(element.name())) {
                                if (chronoElement == element) {
                                    break;
                                }
                                arrayList.set(i, formatStep.updateElement(chronoElement));
                                z = false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            if (chronoHistory != null) {
                if (element == PlainDate.YEAR) {
                    chronoElementMonth = chronoHistory.yearOfEra();
                } else if (element == PlainDate.MONTH_OF_YEAR || element == PlainDate.MONTH_AS_NUMBER) {
                    chronoElementMonth = chronoHistory.month();
                } else if (element == PlainDate.DAY_OF_MONTH) {
                    chronoElementMonth = chronoHistory.dayOfMonth();
                } else {
                    chronoElementMonth = element == PlainDate.DAY_OF_YEAR ? chronoHistory.dayOfYear() : null;
                }
                if (chronoElementMonth != null) {
                    arrayList.set(i, formatStep.updateElement(chronoElementMonth));
                }
                z = false;
            }
        }
        this.indexable = z;
        this.trailing = ((Boolean) this.globalAttributes.get(Attributes.TRAILING_CHARACTERS, Boolean.FALSE)).booleanValue();
        this.noPreparser = hasNoPreparser();
        this.stepCount = arrayList.size();
        this.steps = freeze(arrayList);
        this.singleStepMode = getSingleStepMode();
    }

    private ChronoFormatter(ChronoFormatter chronoFormatter, Map map) {
        OverrideHandler overrideHandler = chronoFormatter.overrideHandler;
        Chronology calendarOverride = overrideHandler == null ? null : overrideHandler.getCalendarOverride();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            checkElement(chronoFormatter.chronology, calendarOverride, (ChronoElement) it.next());
        }
        this.chronology = chronoFormatter.chronology;
        this.overrideHandler = chronoFormatter.overrideHandler;
        this.deepestParser = chronoFormatter.deepestParser;
        this.globalAttributes = chronoFormatter.globalAttributes;
        this.leniency = chronoFormatter.leniency;
        this.fracproc = chronoFormatter.fracproc;
        this.hasOptionals = chronoFormatter.hasOptionals;
        this.hasOrMarkers = chronoFormatter.hasOrMarkers;
        this.needsExtensions = chronoFormatter.needsExtensions;
        this.countOfElements = chronoFormatter.countOfElements;
        this.trailing = chronoFormatter.trailing;
        HashMap map2 = new HashMap(chronoFormatter.defaults);
        boolean z = chronoFormatter.indexable;
        for (ChronoElement chronoElement : map.keySet()) {
            Object obj = map.get(chronoElement);
            if (obj == null) {
                map2.remove(chronoElement);
            } else {
                map2.put(chronoElement, obj);
                z = z && ParsedValues.isIndexed(chronoElement);
            }
        }
        this.defaults = Collections.unmodifiableMap(map2);
        this.indexable = z;
        this.noPreparser = hasNoPreparser();
        this.stepCount = chronoFormatter.stepCount;
        this.steps = freeze(chronoFormatter.steps);
        this.singleStepMode = getSingleStepMode();
    }

    public Chronology getChronology() {
        return this.chronology;
    }

    public Locale getLocale() {
        return this.globalAttributes.getLocale();
    }

    public AttributeQuery getAttributes() {
        return this.globalAttributes;
    }

    public String print(Object obj) {
        return format0(display(obj, this.globalAttributes));
    }

    public String format(Object obj) {
        return print(obj);
    }

    public Set print(Object obj, Appendable appendable, AttributeQuery attributeQuery) {
        return print(display(obj, attributeQuery), appendable, attributeQuery, true);
    }

    @Override // net.time4j.format.expert.ChronoPrinter
    public Object print(Object obj, Appendable appendable, AttributeQuery attributeQuery, ChronoFunction chronoFunction) throws IOException {
        ChronoDisplay chronoDisplayDisplay = display(obj, attributeQuery);
        print(chronoDisplayDisplay, appendable, attributeQuery, false);
        return chronoFunction.apply(chronoDisplayDisplay);
    }

    Set print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, boolean z) throws IOException {
        LinkedList linkedList;
        Throwable th;
        int iPrint;
        int i;
        Appendable appendable2 = appendable;
        if (appendable2 == null) {
            throw new NullPointerException("Missing text result buffer.");
        }
        int size = this.steps.size();
        int i2 = 0;
        AttributeQuery attributeQuery2 = attributeQuery;
        boolean z2 = attributeQuery2 == this.globalAttributes;
        Set linkedHashSet = z ? new LinkedHashSet(size) : null;
        if (this.hasOrMarkers) {
            LinkedList linkedList2 = new LinkedList();
            linkedList2.push(new StringBuilder(size << 2));
            if (z) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.push(linkedHashSet);
                linkedList = linkedList3;
            } else {
                linkedList = null;
            }
            int iSkipTrailingOrBlocks = 0;
            while (iSkipTrailingOrBlocks < size) {
                FormatStep formatStep = (FormatStep) this.steps.get(iSkipTrailingOrBlocks);
                int level = formatStep.getLevel();
                int i3 = level;
                while (i3 > i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((CharSequence) linkedList2.peek());
                    linkedList2.push(sb);
                    if (z) {
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                        linkedHashSet2.addAll((Collection) linkedList.peek());
                        linkedList.push(linkedHashSet2);
                        linkedHashSet = linkedHashSet2;
                    }
                    i3--;
                }
                while (i3 < i2) {
                    StringBuilder sb2 = (StringBuilder) linkedList2.pop();
                    linkedList2.pop();
                    linkedList2.push(sb2);
                    if (z) {
                        Set set = (Set) linkedList.pop();
                        linkedList.pop();
                        linkedList.push(set);
                        linkedHashSet = set;
                    }
                    i3++;
                }
                StringBuilder sb3 = (StringBuilder) linkedList2.peek();
                if (z) {
                    linkedHashSet = (Set) linkedList.peek();
                }
                try {
                    iPrint = formatStep.print(chronoDisplay, sb3, attributeQuery2, linkedHashSet, z2);
                    th = null;
                } catch (IllegalArgumentException | ChronoException e) {
                    th = e;
                    iPrint = -1;
                }
                if (iPrint == -1) {
                    int section = formatStep.getSection();
                    if (!formatStep.isNewOrBlockStarted()) {
                        i = iSkipTrailingOrBlocks + 1;
                        while (true) {
                            if (i >= size) {
                                i = iSkipTrailingOrBlocks;
                                break;
                            }
                            FormatStep formatStep2 = (FormatStep) this.steps.get(i);
                            if (formatStep2.isNewOrBlockStarted() && formatStep2.getSection() == section) {
                                break;
                            }
                            i++;
                        }
                    } else {
                        i = iSkipTrailingOrBlocks;
                        break;
                    }
                    if (i <= iSkipTrailingOrBlocks && !formatStep.isNewOrBlockStarted()) {
                        if (th == null) {
                            throw new IllegalArgumentException("Not formattable: " + chronoDisplay);
                        }
                        throw new IllegalArgumentException("Not formattable: " + chronoDisplay, th);
                    }
                    linkedList2.pop();
                    StringBuilder sb4 = new StringBuilder();
                    if (!linkedList2.isEmpty()) {
                        sb4.append((CharSequence) linkedList2.peek());
                    }
                    linkedList2.push(sb4);
                    if (z) {
                        linkedList.pop();
                        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                        if (!linkedList.isEmpty()) {
                            linkedHashSet3.addAll((Collection) linkedList.peek());
                        }
                        linkedList.push(linkedHashSet3);
                    }
                    iSkipTrailingOrBlocks = i;
                } else if (formatStep.isNewOrBlockStarted()) {
                    iSkipTrailingOrBlocks = formatStep.skipTrailingOrBlocks();
                }
                iSkipTrailingOrBlocks++;
                attributeQuery2 = attributeQuery;
                i2 = level;
            }
            StringBuilder sb5 = (StringBuilder) linkedList2.peek();
            linkedList2.clear();
            appendable2.append(sb5);
            if (z) {
                Set set2 = (Set) linkedList.peek();
                linkedList.clear();
                linkedHashSet = set2;
            }
        } else {
            int iSkipTrailingOrBlocks2 = 0;
            while (iSkipTrailingOrBlocks2 < size) {
                try {
                    FormatStep formatStep3 = (FormatStep) this.steps.get(iSkipTrailingOrBlocks2);
                    formatStep3.print(chronoDisplay, appendable2, attributeQuery, linkedHashSet, z2);
                    if (formatStep3.isNewOrBlockStarted()) {
                        iSkipTrailingOrBlocks2 = formatStep3.skipTrailingOrBlocks();
                    }
                    iSkipTrailingOrBlocks2++;
                    appendable2 = appendable;
                } catch (ChronoException e2) {
                    throw new IllegalArgumentException("Not formattable: " + chronoDisplay, e2);
                }
            }
        }
        if (z) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return null;
    }

    public Object parse(CharSequence charSequence) throws ParseException {
        ParseLog parseLog = new ParseLog();
        Object obj = parse(charSequence, parseLog);
        if (obj == null) {
            throw new ParseException(parseLog.getErrorMessage(), parseLog.getErrorIndex());
        }
        int position = parseLog.getPosition();
        if (this.trailing || position >= charSequence.length()) {
            return obj;
        }
        throw new ParseException("Unparsed trailing characters: " + sub(position, charSequence), position);
    }

    public Object parse(CharSequence charSequence, ParseLog parseLog) {
        if (this.noPreparser) {
            Chronology chronology = this.chronology;
            return parse(this, chronology, chronology.getExtensions(), charSequence, parseLog, this.globalAttributes, this.leniency, false, true);
        }
        return parse(charSequence, parseLog, this.globalAttributes);
    }

    @Override // net.time4j.format.expert.ChronoParser
    public Object parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
        boolean z;
        AttributeQuery attributeQuery2;
        Leniency leniency;
        TZID timezone;
        Moment momentIn;
        Leniency leniency2 = this.leniency;
        AttributeSet attributeSet = this.globalAttributes;
        if (attributeQuery != attributeSet) {
            MergedAttributes mergedAttributes = new MergedAttributes(attributeQuery, attributeSet);
            z = false;
            attributeQuery2 = mergedAttributes;
            leniency = (Leniency) mergedAttributes.get(Attributes.LENIENCY, Leniency.SMART);
        } else {
            z = true;
            attributeQuery2 = attributeQuery;
            leniency = leniency2;
        }
        boolean z2 = z;
        OverrideHandler overrideHandler = this.overrideHandler;
        if (overrideHandler != null) {
            List extensions = overrideHandler.getExtensions();
            OverrideHandler overrideHandler2 = this.overrideHandler;
            GeneralTimestamp generalTimestamp = (GeneralTimestamp) parse(this, overrideHandler2, extensions, charSequence, parseLog, attributeQuery2, leniency, true, z2);
            if (parseLog.isError()) {
                return null;
            }
            ChronoEntity rawValues0 = parseLog.getRawValues0();
            if (rawValues0.hasTimezone()) {
                timezone = rawValues0.getTimezone();
            } else {
                AttributeKey attributeKey = Attributes.TIMEZONE_ID;
                timezone = attributeQuery2.contains(attributeKey) ? (TZID) attributeQuery2.get(attributeKey) : null;
            }
            if (timezone != null) {
                StartOfDay startOfDay = (StartOfDay) attributeQuery.get(Attributes.START_OF_DAY, overrideHandler2.getDefaultStartOfDay());
                FlagElement flagElement = FlagElement.DAYLIGHT_SAVING;
                if (rawValues0.contains(flagElement)) {
                    momentIn = generalTimestamp.in(Timezone.of(timezone).with(((TransitionStrategy) attributeQuery2.get(Attributes.TRANSITION_STRATEGY, Timezone.DEFAULT_CONFLICT_STRATEGY)).using(((Boolean) rawValues0.get(flagElement)).booleanValue() ? OverlapResolver.EARLIER_OFFSET : OverlapResolver.LATER_OFFSET)), startOfDay);
                } else {
                    AttributeKey attributeKey2 = Attributes.TRANSITION_STRATEGY;
                    if (attributeQuery2.contains(attributeKey2)) {
                        momentIn = generalTimestamp.in(Timezone.of(timezone).with((TransitionStrategy) attributeQuery2.get(attributeKey2)), startOfDay);
                    } else {
                        momentIn = generalTimestamp.in(Timezone.of(timezone), startOfDay);
                    }
                }
            } else {
                momentIn = null;
            }
            if (momentIn == null) {
                parseLog.setError(charSequence.length(), "Missing timezone or offset.");
                return null;
            }
            rawValues0.with(Moment.axis().element(), momentIn);
            Object objCast = cast(momentIn);
            if (leniency.isStrict()) {
                checkConsistency(rawValues0, objCast, charSequence, parseLog);
            }
            return objCast;
        }
        return parse(this, this.chronology, 0, charSequence, parseLog, attributeQuery2, leniency, z2);
    }

    public ChronoFormatter with(Leniency leniency) {
        return with(Attributes.LENIENCY, leniency);
    }

    public ChronoFormatter with(Timezone timezone) {
        if (timezone == null) {
            throw new NullPointerException("Missing timezone id.");
        }
        return new ChronoFormatter(this, this.globalAttributes.withAttributes(new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).setTimezone(timezone.getID()).build()).withInternal(Attributes.TRANSITION_STRATEGY, timezone.getStrategy()));
    }

    public ChronoFormatter withTimezone(TZID tzid) {
        return with(Timezone.of(tzid));
    }

    public ChronoFormatter with(AttributeKey attributeKey, Enum r4) {
        return new ChronoFormatter(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(attributeKey, r4).build());
    }

    ChronoFormatter with(Map map, AttributeSet attributeSet) {
        AttributeSet attributeSetMerge = AttributeSet.merge(attributeSet, this.globalAttributes);
        return new ChronoFormatter(new ChronoFormatter(this, map), attributeSetMerge, (ChronoHistory) attributeSetMerge.get(HistoricAttribute.CALENDAR_HISTORY, null));
    }

    Map getDefaults() {
        return this.defaults;
    }

    public static ChronoFormatter ofPattern(String str, PatternType patternType, Locale locale, Chronology chronology) {
        Builder builder = new Builder(chronology, locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoFormatter ofMomentStyle(DisplayMode displayMode, DisplayMode displayMode2, Locale locale, TZID tzid) {
        Builder builder = new Builder(Moment.axis(), locale);
        builder.addProcessor(new StyleProcessor(displayMode, displayMode2));
        return builder.build().withTimezone(tzid);
    }

    public static Builder setUp(Class cls, Locale locale) {
        if (cls == null) {
            throw new NullPointerException("Missing chronological type.");
        }
        Chronology chronologyLookup = Chronology.lookup(cls);
        if (chronologyLookup == null) {
            throw new IllegalArgumentException("Not formattable: " + cls);
        }
        return new Builder(chronologyLookup, locale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoFormatter) {
            ChronoFormatter chronoFormatter = (ChronoFormatter) obj;
            if (this.chronology.equals(chronoFormatter.chronology) && isEqual(this.overrideHandler, chronoFormatter.overrideHandler) && this.globalAttributes.equals(chronoFormatter.globalAttributes) && this.defaults.equals(chronoFormatter.defaults) && this.steps.equals(chronoFormatter.steps)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.chronology.hashCode() * 7) + (this.globalAttributes.hashCode() * 31) + (this.steps.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        sb.append("net.time4j.format.ChronoFormatter[chronology=");
        sb.append(this.chronology.getChronoType().getName());
        if (this.overrideHandler != null) {
            sb.append(", override=");
            sb.append(this.overrideHandler);
        }
        sb.append(", default-attributes=");
        sb.append(this.globalAttributes);
        sb.append(", default-values=");
        sb.append(this.defaults);
        sb.append(", processors=");
        boolean z = true;
        for (FormatStep formatStep : this.steps) {
            if (z) {
                sb.append('{');
                z = false;
            } else {
                sb.append('|');
            }
            sb.append(formatStep);
        }
        sb.append("}]");
        return sb.toString();
    }

    AttributeSet getAttributes0() {
        return this.globalAttributes;
    }

    boolean isSingleStepOptimizationPossible() {
        return this.stepCount == 1 && !this.hasOptionals;
    }

    private boolean getSingleStepMode() {
        boolean zIsSingleStepOptimizationPossible = isSingleStepOptimizationPossible();
        if (zIsSingleStepOptimizationPossible) {
            FormatProcessor processor = ((FormatStep) this.steps.get(0)).getProcessor();
            if (processor instanceof CustomizedProcessor) {
                return ((CustomizedProcessor) CustomizedProcessor.class.cast(processor)).isSingleStepMode();
            }
            if (!(processor instanceof StyleProcessor)) {
                return false;
            }
        }
        return zIsSingleStepOptimizationPossible;
    }

    private String format0(ChronoDisplay chronoDisplay) {
        StringBuilder sb = new StringBuilder(this.steps.size() * 8);
        try {
            print(chronoDisplay, (Appendable) sb, this.globalAttributes, false);
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static ChronoFormatter rfc1123() {
        Builder up = setUp(Moment.class, Locale.ENGLISH);
        rfc1123DateTime(up);
        up.addTimezoneOffset(DisplayMode.MEDIUM, false, Arrays.asList("GMT", "UT", "Z"));
        up.or();
        rfc1123DateTime(up);
        final HashMap map = new HashMap();
        OffsetSign offsetSign = OffsetSign.BEHIND_UTC;
        map.put("EST", ZonalOffset.ofHours(offsetSign, 5));
        map.put("EDT", ZonalOffset.ofHours(offsetSign, 4));
        map.put("CST", ZonalOffset.ofHours(offsetSign, 6));
        map.put("CDT", ZonalOffset.ofHours(offsetSign, 5));
        map.put("MST", ZonalOffset.ofHours(offsetSign, 7));
        map.put("MDT", ZonalOffset.ofHours(offsetSign, 6));
        map.put("PST", ZonalOffset.ofHours(offsetSign, 8));
        map.put("PDT", ZonalOffset.ofHours(offsetSign, 7));
        up.addProcessor(new CustomizedProcessor(TimezoneElement.TIMEZONE_OFFSET, new ChronoPrinter() { // from class: net.time4j.format.expert.ChronoFormatter.1
            @Override // net.time4j.format.expert.ChronoPrinter
            public Object print(TZID tzid, Appendable appendable, AttributeQuery attributeQuery, ChronoFunction chronoFunction) {
                return null;
            }
        }, new ChronoParser() { // from class: net.time4j.format.expert.ChronoFormatter.2
            @Override // net.time4j.format.expert.ChronoParser
            public TZID parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
                int position = parseLog.getPosition();
                int i = position + 3;
                if (i > charSequence.length()) {
                    return null;
                }
                TZID tzid = (TZID) map.get(charSequence.subSequence(position, i).toString());
                if (tzid != null) {
                    parseLog.setPosition(i);
                    return tzid;
                }
                parseLog.setError(position, "No time zone information found.");
                return null;
            }
        }));
        return up.build().withTimezone(ZonalOffset.UTC);
    }

    private static void rfc1123DateTime(Builder builder) {
        Builder builderStartOptionalSection = builder.startOptionalSection();
        AttributeKey attributeKey = Attributes.TEXT_WIDTH;
        TextWidth textWidth = TextWidth.ABBREVIATED;
        builderStartOptionalSection.startSection(attributeKey, textWidth).addText(PlainDate.DAY_OF_WEEK).endSection().addLiteral(", ").endSection().addInteger(PlainDate.DAY_OF_MONTH, 1, 2).addLiteral(' ').startSection(attributeKey, textWidth).addText(PlainDate.MONTH_OF_YEAR).endSection().addLiteral(' ').addFixedInteger(PlainDate.YEAR, 4).addLiteral(' ').addFixedInteger(PlainTime.DIGITAL_HOUR_OF_DAY, 2).addLiteral(':').addFixedInteger(PlainTime.MINUTE_OF_HOUR, 2).startOptionalSection().addLiteral(':').addFixedInteger(PlainTime.SECOND_OF_MINUTE, 2).endSection().addLiteral(' ');
    }

    private ChronoDisplay display(Object obj, AttributeQuery attributeQuery) {
        GeneralTimestamp generalTimestamp;
        OverrideHandler overrideHandler = this.overrideHandler;
        if (overrideHandler == null) {
            return this.chronology.preformat(obj, attributeQuery);
        }
        try {
            Class chronoType = overrideHandler.getCalendarOverride().getChronoType();
            StartOfDay startOfDay = (StartOfDay) attributeQuery.get(Attributes.START_OF_DAY, this.overrideHandler.getDefaultStartOfDay());
            Moment moment = (Moment) Moment.class.cast(obj);
            TZID tzid = (TZID) attributeQuery.get(Attributes.TIMEZONE_ID);
            String str = "";
            if (CalendarVariant.class.isAssignableFrom(chronoType)) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(cast(this.overrideHandler.getCalendarOverride()));
                str = (String) attributeQuery.get(Attributes.CALENDAR_VARIANT);
                generalTimestamp = moment.toGeneralTimestamp(null, str, tzid, startOfDay);
            } else if (Calendrical.class.isAssignableFrom(chronoType)) {
                generalTimestamp = moment.toGeneralTimestamp(this.overrideHandler.getCalendarOverride(), tzid, startOfDay);
            } else {
                throw new IllegalStateException("Unexpected calendar override: " + chronoType);
            }
            return new ZonalDisplay(generalTimestamp, str, tzid);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Not formattable: " + obj, e);
        } catch (NoSuchElementException e2) {
            throw new IllegalArgumentException(e2.getMessage(), e2);
        }
    }

    private static Object parse(ChronoFormatter chronoFormatter, Chronology chronology, int i, CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, Leniency leniency, boolean z) {
        Chronology chronology2;
        Object obj;
        Chronology chronologyPreparser = chronology.preparser();
        if (chronologyPreparser == null || chronology == (chronology2 = chronoFormatter.deepestParser)) {
            return parse(chronoFormatter, chronology, chronology.getExtensions(), charSequence, parseLog, attributeQuery, leniency, i > 0, z);
        }
        if (chronologyPreparser == chronology2) {
            obj = parse(chronoFormatter, chronologyPreparser, chronologyPreparser.getExtensions(), charSequence, parseLog, attributeQuery, leniency, true, z);
        } else {
            obj = parse(chronoFormatter, chronologyPreparser, i + 1, charSequence, parseLog, attributeQuery, leniency, z);
        }
        if (parseLog.isError()) {
            return null;
        }
        if (obj == null) {
            ChronoEntity rawValues = parseLog.getRawValues();
            parseLog.setError(charSequence.length(), getReason(rawValues) + getDescription(rawValues));
            return null;
        }
        ChronoEntity rawValues0 = parseLog.getRawValues0();
        try {
            if (chronologyPreparser instanceof TimeAxis) {
                updateSelf(rawValues0, ((TimeAxis) TimeAxis.class.cast(chronologyPreparser)).element(), obj);
                Object objCreateFrom = chronology.createFrom(rawValues0, attributeQuery, leniency.isLax(), false);
                if (objCreateFrom != null) {
                    return leniency.isStrict() ? checkConsistency(rawValues0, objCreateFrom, charSequence, parseLog) : objCreateFrom;
                }
                if (!parseLog.isError()) {
                    parseLog.setError(charSequence.length(), getReason(rawValues0) + getDescription(rawValues0));
                }
                return null;
            }
            throw new IllegalStateException("Unsupported chronology or preparser: " + chronology);
        } catch (RuntimeException e) {
            parseLog.setError(charSequence.length(), e.getMessage() + getDescription(rawValues0));
            return null;
        }
    }

    private static void updateSelf(ChronoEntity chronoEntity, ChronoElement chronoElement, Object obj) {
        chronoEntity.with(chronoElement, chronoElement.getType().cast(obj));
    }

    /* JADX WARN: Code duplicated, block: B:108:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[LOOP:1: B:55:0x00bc->B:117:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e9 A[Catch: RuntimeException -> 0x00f8, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x00f8, blocks: (B:64:0x00df, B:65:0x00e3, B:67:0x00e9), top: B:95:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0123  */
    /* JADX WARN: Code duplicated, block: B:79:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x013d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0158  */
    /* JADX WARN: Code duplicated, block: B:84:0x015e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0165 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:80:0x013d, please report this as an issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static Object parse(ChronoFormatter chronoFormatter, ChronoMerger chronoMerger, List list, CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, Leniency leniency, boolean z, boolean z2) {
        ParseLog parseLog2;
        AttributeQuery attributeQuery2;
        ChronoEntity chronoEntity;
        ParseLog parseLog3;
        boolean zIsError;
        ChronoEntity chronoEntityResolve;
        ParseLog parseLog4;
        Iterator it;
        ChronoEntity chronoEntity2;
        Object objCreateFrom;
        Set registeredElements;
        char symbol;
        boolean z3;
        Iterator it2;
        int length = charSequence.length();
        if (parseLog.getPosition() >= length) {
            throw new IndexOutOfBoundsException("[" + parseLog.getPosition() + "]: " + charSequence.toString());
        }
        try {
            try {
                if (chronoFormatter.singleStepMode && !z) {
                    ParsedValue parsedValue = new ParsedValue();
                    ParseLog parseLog5 = parseLog;
                    ((FormatStep) chronoFormatter.steps.get(0)).parse(charSequence, parseLog5, attributeQuery, parsedValue, z2);
                    if (parseLog5.isError()) {
                        return null;
                    }
                    try {
                        Object result = parsedValue.getResult();
                        if (result != null) {
                            return result;
                        }
                    } catch (ClassCastException unused) {
                    }
                    try {
                        parseLog5.setRawValues(parsedValue);
                        attributeQuery2 = attributeQuery;
                        parseLog4 = parseLog5;
                        chronoEntityResolve = parsedValue;
                    } catch (AmbivalentValueException e) {
                        e = e;
                        attributeQuery2 = attributeQuery;
                        parseLog3 = parseLog5;
                        chronoEntity = parsedValue;
                        zIsError = parseLog3.isError();
                        parseLog4 = parseLog3;
                        chronoEntityResolve = chronoEntity;
                        if (!zIsError) {
                            parseLog3.setError(parseLog3.getPosition(), e.getMessage());
                        }
                    }
                } else {
                    try {
                        ChronoEntity elements = chronoFormatter.parseElements(charSequence, parseLog, attributeQuery, z2, chronoFormatter.countOfElements);
                        ParseLog parseLog6 = parseLog;
                        attributeQuery2 = attributeQuery;
                        try {
                            parseLog6.setRawValues(elements);
                            chronoEntityResolve = elements;
                            parseLog4 = parseLog6;
                        } catch (AmbivalentValueException e2) {
                            e = e2;
                            chronoEntity = elements;
                            parseLog3 = parseLog6;
                            zIsError = parseLog3.isError();
                            parseLog4 = parseLog3;
                            chronoEntityResolve = chronoEntity;
                            if (!zIsError) {
                                parseLog3.setError(parseLog3.getPosition(), e.getMessage());
                            }
                        }
                    } catch (AmbivalentValueException e3) {
                        e = e3;
                        parseLog2 = parseLog;
                        attributeQuery2 = attributeQuery;
                        chronoEntity = null;
                        parseLog3 = parseLog2;
                        zIsError = parseLog3.isError();
                        parseLog4 = parseLog3;
                        chronoEntityResolve = chronoEntity;
                        if (!zIsError) {
                            parseLog3.setError(parseLog3.getPosition(), e.getMessage());
                        }
                        if (chronoEntityResolve != null) {
                            parseLog4 = parseLog3;
                            chronoEntityResolve = chronoEntity;
                            if (!parseLog4.isError()) {
                                if (!chronoFormatter.defaults.isEmpty()) {
                                    registeredElements = null;
                                    for (ChronoElement chronoElement : chronoFormatter.defaults.keySet()) {
                                        if (!chronoEntityResolve.contains(chronoElement)) {
                                            symbol = chronoElement.getSymbol();
                                            z3 = true;
                                            if (symbol != 0) {
                                                if (registeredElements == null) {
                                                    registeredElements = chronoEntityResolve.getRegisteredElements();
                                                }
                                                it2 = registeredElements.iterator();
                                                while (it2.hasNext()) {
                                                    if (((ChronoElement) it2.next()).getSymbol() == symbol) {
                                                        z3 = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (z3) {
                                                setValue(chronoEntityResolve, chronoElement, chronoFormatter.defaults.get(chronoElement));
                                            }
                                        }
                                    }
                                }
                                chronoEntity2 = chronoEntityResolve;
                                try {
                                    if (chronoFormatter.needsExtensions) {
                                        try {
                                            it = list.iterator();
                                            while (true) {
                                                chronoEntity2 = chronoEntityResolve;
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                chronoEntityResolve = ((ChronoExtension) it.next()).resolve(chronoEntityResolve, chronoFormatter.getLocale(), attributeQuery2);
                                            }
                                            objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                                            if (chronoFormatter.fracproc != null) {
                                                objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                                            }
                                            if (objCreateFrom == null) {
                                                if (leniency.isStrict()) {
                                                    return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                                                }
                                                return objCreateFrom;
                                            }
                                            if (!z) {
                                                parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                                            }
                                            return null;
                                        } catch (RuntimeException e4) {
                                            parseLog4.setError(length, e4.getMessage() + getDescription(chronoEntityResolve));
                                            return null;
                                        }
                                    }
                                    objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                                    if (chronoFormatter.fracproc != null) {
                                        objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                                    }
                                    if (objCreateFrom == null) {
                                        if (leniency.isStrict()) {
                                            return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                                        }
                                        return objCreateFrom;
                                    }
                                    if (!z) {
                                        parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                                    }
                                    return null;
                                } catch (RuntimeException e5) {
                                    parseLog4.setError(length, e5.getMessage() + getDescription(chronoEntity2));
                                }
                            }
                        }
                        parseLog4 = parseLog3;
                        chronoEntityResolve = chronoEntity;
                        return null;
                    }
                }
            } catch (AmbivalentValueException e6) {
                e = e6;
                attributeQuery2 = attributeQuery;
                chronoEntity = null;
                parseLog3 = parseLog2;
                zIsError = parseLog3.isError();
                parseLog4 = parseLog3;
                chronoEntityResolve = chronoEntity;
                if (!zIsError) {
                    parseLog3.setError(parseLog3.getPosition(), e.getMessage());
                }
                if (chronoEntityResolve != null) {
                    parseLog4 = parseLog3;
                    chronoEntityResolve = chronoEntity;
                    if (!parseLog4.isError()) {
                        if (!chronoFormatter.defaults.isEmpty()) {
                            registeredElements = null;
                            while (r0.hasNext()) {
                                if (!chronoEntityResolve.contains(chronoElement)) {
                                    symbol = chronoElement.getSymbol();
                                    z3 = true;
                                    if (symbol != 0) {
                                        if (registeredElements == null) {
                                            registeredElements = chronoEntityResolve.getRegisteredElements();
                                        }
                                        it2 = registeredElements.iterator();
                                        while (it2.hasNext()) {
                                            if (((ChronoElement) it2.next()).getSymbol() == symbol) {
                                                z3 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (z3) {
                                        setValue(chronoEntityResolve, chronoElement, chronoFormatter.defaults.get(chronoElement));
                                    }
                                }
                            }
                        }
                        chronoEntity2 = chronoEntityResolve;
                        if (chronoFormatter.needsExtensions) {
                            it = list.iterator();
                            while (true) {
                                chronoEntity2 = chronoEntityResolve;
                                if (!it.hasNext()) {
                                    break;
                                }
                                chronoEntityResolve = ((ChronoExtension) it.next()).resolve(chronoEntityResolve, chronoFormatter.getLocale(), attributeQuery2);
                            }
                            objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                            if (chronoFormatter.fracproc != null) {
                                objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                            }
                            if (objCreateFrom == null) {
                                if (leniency.isStrict()) {
                                    return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                                }
                                return objCreateFrom;
                            }
                            if (!z) {
                                parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                            }
                            return null;
                        }
                        objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                        if (chronoFormatter.fracproc != null) {
                            objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                        }
                        if (objCreateFrom == null) {
                            if (leniency.isStrict()) {
                                return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                            }
                            return objCreateFrom;
                        }
                        if (!z) {
                            parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                        }
                        return null;
                    }
                }
                parseLog4 = parseLog3;
                chronoEntityResolve = chronoEntity;
                return null;
            }
        } catch (AmbivalentValueException e7) {
            e = e7;
            parseLog2 = parseLog;
        }
        if (chronoEntityResolve != null) {
            parseLog4 = parseLog3;
            chronoEntityResolve = chronoEntity;
            if (!parseLog4.isError()) {
                if (!chronoFormatter.defaults.isEmpty()) {
                    registeredElements = null;
                    while (r0.hasNext()) {
                        if (!chronoEntityResolve.contains(chronoElement)) {
                            symbol = chronoElement.getSymbol();
                            z3 = true;
                            if (symbol != 0) {
                                if (registeredElements == null) {
                                    registeredElements = chronoEntityResolve.getRegisteredElements();
                                }
                                it2 = registeredElements.iterator();
                                while (it2.hasNext()) {
                                    if (((ChronoElement) it2.next()).getSymbol() == symbol) {
                                        z3 = false;
                                        break;
                                    }
                                }
                            }
                            if (z3) {
                                setValue(chronoEntityResolve, chronoElement, chronoFormatter.defaults.get(chronoElement));
                            }
                        }
                    }
                }
                chronoEntity2 = chronoEntityResolve;
                if (chronoFormatter.needsExtensions) {
                    it = list.iterator();
                    while (true) {
                        chronoEntity2 = chronoEntityResolve;
                        if (!it.hasNext()) {
                            break;
                        }
                        chronoEntityResolve = ((ChronoExtension) it.next()).resolve(chronoEntityResolve, chronoFormatter.getLocale(), attributeQuery2);
                    }
                    objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                    if (chronoFormatter.fracproc != null && (objCreateFrom instanceof ChronoEntity)) {
                        objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                    }
                    if (objCreateFrom == null) {
                        if (leniency.isStrict()) {
                            return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                        }
                        return objCreateFrom;
                    }
                    if (!z) {
                        parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                    }
                    return null;
                }
                objCreateFrom = chronoMerger.createFrom(chronoEntity2, attributeQuery2, leniency.isLax(), z);
                if (chronoFormatter.fracproc != null) {
                    objCreateFrom = cast(chronoFormatter.fracproc.update((ChronoEntity) ChronoEntity.class.cast(objCreateFrom), chronoEntity2));
                }
                if (objCreateFrom == null) {
                    if (leniency.isStrict()) {
                        return checkConsistency(chronoEntity2, objCreateFrom, charSequence, parseLog4);
                    }
                    return objCreateFrom;
                }
                if (!z) {
                    parseLog4.setError(length, getReason(chronoEntity2) + getDescription(chronoEntity2));
                }
                return null;
            }
        }
        parseLog4 = parseLog3;
        chronoEntityResolve = chronoEntity;
        return null;
    }

    private static void setValue(ChronoEntity chronoEntity, ChronoElement chronoElement, Object obj) {
        chronoEntity.with(chronoElement, chronoElement.getType().cast(obj));
    }

    private static String getReason(ChronoEntity chronoEntity) {
        ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
        if (chronoEntity.contains(validationElement)) {
            String str = "Validation failed => " + ((String) chronoEntity.get(validationElement));
            chronoEntity.with(validationElement, (Object) null);
            return str;
        }
        return "Insufficient data:";
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static void addPattern(Builder builder, String str, PatternType patternType) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'') {
                int i2 = i + 1;
                boolean z = str.charAt(i2) == 'Z';
                while (i2 < length) {
                    if (str.charAt(i2) == '\'') {
                        int i3 = i2 + 1;
                        if (i3 >= length || str.charAt(i3) != '\'') {
                            if (!z || i2 != i + 2 || !Builder.hasUnixChronology(builder.chronology)) {
                                break;
                                break;
                                break;
                            } else {
                                throw new IllegalArgumentException("Z-literal (=UTC+00) should not be escaped: " + str);
                            }
                        }
                        i2 = i3;
                    }
                    i2++;
                }
                i = i2;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        String string = sb.toString();
        int i4 = AnonymousClass3.$SwitchMap$net$time4j$format$expert$PatternType[patternType.ordinal()];
        if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4) {
            if ((string.contains("h") || string.contains("K")) && !string.contains("a") && !string.contains("b") && !string.contains("B")) {
                throw new IllegalArgumentException("12-hour-clock requires am/pm-marker or dayperiod: " + str);
            }
            if (string.contains("Y") && ((string.contains("M") || string.contains("L")) && !string.contains("w"))) {
                throw new IllegalArgumentException("Y as week-based-year requires a week-date-format: " + str);
            }
            if (string.contains("D") && ((string.contains("M") || string.contains("L")) && !string.contains("d"))) {
                throw new IllegalArgumentException("D is the day of year but not the day of month: " + str);
            }
        }
        builder.addPattern(str, patternType);
    }

    /* JADX INFO: renamed from: net.time4j.format.expert.ChronoFormatter$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$PatternType;

        static {
            int[] iArr = new int[PatternType.values().length];
            $SwitchMap$net$time4j$format$expert$PatternType = iArr;
            try {
                iArr[PatternType.CLDR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.CLDR_24.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.CLDR_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$time4j$format$expert$PatternType[PatternType.SIMPLE_DATE_FORMAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x011d  */
    private static Object checkConsistency(ChronoEntity chronoEntity, Object obj, CharSequence charSequence, ParseLog parseLog) {
        TimePoint timePointMinus;
        Object objValueOf;
        boolean zEquals;
        if (obj instanceof UnixTime) {
            UnixTime unixTime = (UnixTime) UnixTime.class.cast(obj);
            TimezoneElement timezoneElement = TimezoneElement.TIMEZONE_ID;
            if (chronoEntity.contains(timezoneElement)) {
                TimezoneElement timezoneElement2 = TimezoneElement.TIMEZONE_OFFSET;
                if (chronoEntity.contains(timezoneElement2)) {
                    TZID tzid = (TZID) chronoEntity.get(timezoneElement);
                    TZID tzid2 = (TZID) chronoEntity.get(timezoneElement2);
                    if (!Timezone.of(tzid).getOffset(unixTime).equals(tzid2)) {
                        parseLog.setError(charSequence.length(), "Ambivalent offset information: " + tzid + " versus " + tzid2);
                        return null;
                    }
                }
            }
            FlagElement flagElement = FlagElement.DAYLIGHT_SAVING;
            if (chronoEntity.contains(flagElement)) {
                try {
                    boolean zIsDaylightSaving = Timezone.of(chronoEntity.getTimezone()).isDaylightSaving(unixTime);
                    if (zIsDaylightSaving != ((Boolean) chronoEntity.get(flagElement)).booleanValue()) {
                        StringBuilder sb = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
                        sb.append("Conflict found: ");
                        sb.append("Parsed entity is ");
                        if (!zIsDaylightSaving) {
                            sb.append("not ");
                        }
                        sb.append("daylight-saving, but timezone name");
                        sb.append(" has not the appropriate form in {");
                        sb.append(charSequence.toString());
                        sb.append("}.");
                        parseLog.setError(charSequence.length(), sb.toString());
                        return null;
                    }
                } catch (IllegalArgumentException e) {
                    StringBuilder sb2 = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
                    sb2.append("Unable to check timezone name: ");
                    sb2.append(e.getMessage());
                    parseLog.setError(charSequence.length(), sb2.toString());
                    return null;
                }
            }
            return obj;
        }
        if (obj instanceof ChronoDisplay) {
            ChronoDisplay chronoDisplayMidnightAtEndOfDay = (ChronoDisplay) obj;
            if ((obj instanceof PlainTimestamp) && ((PlainTimestamp) PlainTimestamp.class.cast(obj)).getHour() == 0) {
                if (chronoEntity.getInt(PlainTime.HOUR_FROM_0_TO_24) != 24) {
                    WallTimeElement wallTimeElement = PlainTime.COMPONENT;
                    if (!chronoEntity.contains(wallTimeElement) || ((PlainTime) chronoEntity.get(wallTimeElement)).getHour() != 24) {
                        timePointMinus = null;
                    }
                }
                timePointMinus = ((PlainTimestamp) PlainTimestamp.class.cast(obj)).toDate().minus(1L, CalendarUnit.DAYS);
            } else {
                timePointMinus = null;
            }
            for (ChronoElement chronoElement : chronoEntity.getRegisteredElements()) {
                ProportionalElement proportionalElement = PlainTime.SECOND_OF_MINUTE;
                if (chronoElement != proportionalElement || chronoEntity.getInt(proportionalElement) != 60) {
                    if (timePointMinus != null) {
                        if (chronoElement.isDateElement()) {
                            chronoDisplayMidnightAtEndOfDay = timePointMinus;
                        } else if (chronoElement.isTimeElement()) {
                            chronoDisplayMidnightAtEndOfDay = PlainTime.midnightAtEndOfDay();
                        }
                    }
                    if (chronoDisplayMidnightAtEndOfDay.contains(chronoElement)) {
                        if (chronoElement.getType() == Integer.class) {
                            ChronoElement chronoElement2 = (ChronoElement) cast(chronoElement);
                            int i = chronoEntity.getInt(chronoElement2);
                            if (chronoDisplayMidnightAtEndOfDay.getInt(chronoElement2) != i) {
                                objValueOf = Integer.valueOf(i);
                                zEquals = false;
                            } else {
                                zEquals = true;
                                objValueOf = null;
                            }
                        } else {
                            objValueOf = chronoEntity.get(chronoElement);
                            zEquals = chronoDisplayMidnightAtEndOfDay.get(chronoElement).equals(objValueOf);
                        }
                        if (!zEquals) {
                            StringBuilder sb3 = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
                            sb3.append("Conflict found: ");
                            sb3.append("Text {");
                            sb3.append(charSequence.toString());
                            sb3.append("} with element ");
                            sb3.append(chronoElement.name());
                            sb3.append(" {");
                            sb3.append(objValueOf);
                            sb3.append("}, but parsed entity ");
                            sb3.append("has element value {");
                            sb3.append(chronoDisplayMidnightAtEndOfDay.get(chronoElement));
                            sb3.append("}.");
                            parseLog.setError(charSequence.length(), sb3.toString());
                            return null;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return obj;
    }

    private ChronoEntity parseElements(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, boolean z, int i) {
        LinkedList linkedList;
        ParsedValues parsedValues;
        ParsedValues parsedValues2;
        int i2;
        ChronoElement element;
        ParsedValues parsedValues3 = new ParsedValues(i, this.indexable);
        parsedValues3.setPosition(parseLog.getPosition());
        if (this.hasOptionals) {
            LinkedList linkedList2 = new LinkedList();
            linkedList2.push(parsedValues3);
            linkedList = linkedList2;
        } else {
            linkedList = null;
        }
        int size = this.steps.size();
        int level = 0;
        int i3 = 0;
        int iSkipTrailingOrBlocks = 0;
        while (iSkipTrailingOrBlocks < size) {
            FormatStep formatStep = (FormatStep) this.steps.get(iSkipTrailingOrBlocks);
            if (linkedList == null) {
                parsedValues2 = parsedValues3;
                parsedValues = parsedValues2;
            } else {
                level = formatStep.getLevel();
                int i4 = level;
                while (i4 > i3) {
                    parsedValues3 = new ParsedValues(i >>> 1, this.indexable);
                    parsedValues3.setPosition(parseLog.getPosition());
                    linkedList.push(parsedValues3);
                    i4--;
                }
                while (i4 < i3) {
                    parsedValues3 = (ParsedValues) linkedList.pop();
                    ((ParsedValues) linkedList.peek()).putAll(parsedValues3);
                    i4++;
                }
                parsedValues = parsedValues3;
                parsedValues2 = (ParsedValues) linkedList.peek();
            }
            int i5 = level;
            parseLog.clearWarning();
            formatStep.parse(charSequence, parseLog, attributeQuery, parsedValues2, z);
            if (parseLog.isWarning() && (element = formatStep.getProcessor().getElement()) != null && this.defaults.containsKey(element)) {
                parsedValues2.put(element, this.defaults.get(element));
                parsedValues2.with((ChronoElement) ValidationElement.ERROR_MESSAGE, (Object) null);
                parseLog.clearError();
                parseLog.clearWarning();
            }
            if (parseLog.isError()) {
                int section = formatStep.getSection();
                if (formatStep.isNewOrBlockStarted()) {
                    i2 = iSkipTrailingOrBlocks;
                    break;
                }
                i2 = iSkipTrailingOrBlocks + 1;
                while (true) {
                    if (i2 >= size) {
                        i2 = iSkipTrailingOrBlocks;
                        break;
                    }
                    FormatStep formatStep2 = (FormatStep) this.steps.get(i2);
                    if (formatStep2.isNewOrBlockStarted() && formatStep2.getSection() == section) {
                        break;
                    }
                    i2++;
                }
                if (i2 > iSkipTrailingOrBlocks || formatStep.isNewOrBlockStarted()) {
                    if (linkedList != null) {
                        parsedValues = (ParsedValues) linkedList.pop();
                    }
                    parseLog.clearError();
                    parseLog.setPosition(parsedValues.getPosition());
                    parsedValues.reset();
                    if (linkedList != null) {
                        linkedList.push(parsedValues);
                    }
                    iSkipTrailingOrBlocks = i2;
                } else {
                    if (i5 == 0) {
                        if (linkedList != null) {
                            parsedValues = (ParsedValues) linkedList.peek();
                        }
                        parsedValues.setNoAmbivalentCheck();
                        return parsedValues;
                    }
                    int level2 = formatStep.getLevel();
                    int i6 = i2;
                    for (int i7 = iSkipTrailingOrBlocks + 1; i7 < size && ((FormatStep) this.steps.get(i7)).getLevel() > level2; i7++) {
                        i6 = i7;
                    }
                    for (int i8 = size - 1; i8 > i6; i8--) {
                        if (((FormatStep) this.steps.get(i8)).getSection() == section) {
                            i6 = i8;
                            break;
                        }
                    }
                    i5--;
                    parsedValues3 = (ParsedValues) linkedList.pop();
                    parseLog.clearError();
                    parseLog.setPosition(parsedValues3.getPosition());
                    iSkipTrailingOrBlocks = i6;
                }
                iSkipTrailingOrBlocks++;
                level = i5;
                i3 = level;
            } else if (formatStep.isNewOrBlockStarted()) {
                iSkipTrailingOrBlocks = formatStep.skipTrailingOrBlocks();
            }
            parsedValues3 = parsedValues;
            iSkipTrailingOrBlocks++;
            level = i5;
            i3 = level;
        }
        while (level > 0) {
            parsedValues3 = (ParsedValues) linkedList.pop();
            ((ParsedValues) linkedList.peek()).putAll(parsedValues3);
            level--;
        }
        if (linkedList != null) {
            parsedValues3 = (ParsedValues) linkedList.peek();
        }
        parsedValues3.setNoAmbivalentCheck();
        return parsedValues3;
    }

    private static String sub(int i, CharSequence charSequence) {
        int length = charSequence.length();
        if (length - i <= 10) {
            return charSequence.subSequence(i, length).toString();
        }
        return charSequence.subSequence(i, i + 10).toString() + "...";
    }

    private static String getDescription(ChronoEntity chronoEntity) {
        Set<ChronoElement> registeredElements = chronoEntity.getRegisteredElements();
        StringBuilder sb = new StringBuilder(registeredElements.size() * 16);
        sb.append(" [parsed={");
        boolean z = true;
        for (ChronoElement chronoElement : registeredElements) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(chronoElement.name());
            sb.append('=');
            sb.append(chronoEntity.get(chronoElement));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Chronology checkElement(Chronology chronology, Chronology chronology2, ChronoElement chronoElement) {
        if (chronology.isSupported(chronoElement)) {
            return chronology;
        }
        if (chronology2 == null) {
            do {
                chronology = chronology.preparser();
                if (chronology != null) {
                }
            } while (!chronology.isSupported(chronoElement));
            return chronology;
        }
        if (chronoElement.isDateElement() && chronology2.isSupported(chronoElement)) {
            return chronology2;
        }
        if (chronoElement.isTimeElement() && PlainTime.axis().isSupported(chronoElement)) {
            return PlainTime.axis();
        }
        throw new IllegalArgumentException("Unsupported element: " + chronoElement.name());
    }

    private static boolean needsExtension(Chronology chronology, Chronology chronology2, ChronoElement chronoElement) {
        Iterator it = chronology.getExtensions().iterator();
        while (it.hasNext()) {
            if (((ChronoExtension) it.next()).canResolve(chronoElement)) {
                return true;
            }
        }
        if (chronology2 != null) {
            if (chronoElement.isDateElement()) {
                Iterator it2 = chronology2.getExtensions().iterator();
                while (it2.hasNext()) {
                    if (((ChronoExtension) it2.next()).canResolve(chronoElement)) {
                        return true;
                    }
                }
                return false;
            }
            if (!chronoElement.isTimeElement() || !PlainTime.axis().isSupported(chronoElement)) {
                return false;
            }
            Iterator it3 = PlainTime.axis().getExtensions().iterator();
            while (it3.hasNext()) {
                if (((ChronoExtension) it3.next()).canResolve(chronoElement)) {
                    return true;
                }
            }
            return false;
        }
        while (true) {
            chronology = chronology.preparser();
            if (chronology == null) {
                return false;
            }
            Iterator it4 = chronology.getExtensions().iterator();
            while (it4.hasNext()) {
                if (((ChronoExtension) it4.next()).canResolve(chronoElement)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getDepth(Chronology chronology, Chronology chronology2, Chronology chronology3) {
        if (chronology3 != null) {
            return -1;
        }
        int i = 0;
        if (chronology.equals(chronology2)) {
            return 0;
        }
        do {
            chronology2 = chronology2.preparser();
            if (chronology2 == null) {
                return Integer.MAX_VALUE;
            }
            i++;
        } while (!chronology.equals(chronology2));
        return i;
    }

    private List freeze(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FormatStep) it.next()).quickPath(this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean hasNoPreparser() {
        return this.chronology.preparser() == null && this.overrideHandler == null;
    }

    public static final class Builder {
        private static final AttributeKey CUSTOM_DAY_PERIOD = Attributes.createKey("CUSTOM_DAY_PERIOD", DayPeriod.class);
        private final Chronology chronology;
        private DayPeriod dayPeriod;
        private Chronology deepestParser;
        private Map defaultMap;
        private int depthOfParser;
        private int leftPadWidth;
        private final Locale locale;
        private final Chronology override;
        private String pattern;
        private int reservedIndex;
        private int sectionID;
        private LinkedList stack;
        private List steps;

        private static boolean isSymbol(char c) {
            if (c < 'A' || c > 'Z') {
                return c >= 'a' && c <= 'z';
            }
            return true;
        }

        private Builder(Chronology chronology, Locale locale) {
            this(chronology, locale, (Chronology) null);
        }

        private Builder(Chronology chronology, Locale locale, Chronology chronology2) {
            if (chronology == null) {
                throw new NullPointerException("Missing chronology.");
            }
            if (locale == null) {
                throw new NullPointerException("Missing locale.");
            }
            this.chronology = chronology;
            this.override = chronology2;
            this.locale = locale;
            this.steps = new ArrayList();
            this.stack = new LinkedList();
            this.sectionID = 0;
            this.reservedIndex = -1;
            this.leftPadWidth = 0;
            this.pattern = null;
            this.dayPeriod = null;
            this.defaultMap = new HashMap();
            this.deepestParser = chronology;
            this.depthOfParser = 0;
        }

        public Chronology getChronology() {
            Chronology chronology = this.override;
            return chronology == null ? this.chronology : chronology;
        }

        public Builder addInteger(ChronoElement chronoElement, int i, int i2) {
            return addNumber(chronoElement, false, i, i2, SignPolicy.SHOW_NEVER);
        }

        public Builder addInteger(ChronoElement chronoElement, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, false, i, i2, signPolicy);
        }

        public Builder addLongNumber(ChronoElement chronoElement, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, false, i, i2, signPolicy);
        }

        public Builder addFixedInteger(ChronoElement chronoElement, int i) {
            return addNumber(chronoElement, true, i, i, SignPolicy.SHOW_NEVER);
        }

        public Builder addNumerical(ChronoElement chronoElement, int i, int i2) {
            return addNumber(chronoElement, false, i, i2, SignPolicy.SHOW_NEVER);
        }

        public Builder addFixedNumerical(ChronoElement chronoElement, int i) {
            return addNumber(chronoElement, true, i, i, SignPolicy.SHOW_NEVER);
        }

        public Builder addFraction(ChronoElement chronoElement, int i, int i2, boolean z) {
            checkElement(chronoElement);
            boolean z2 = !z && i == i2;
            ensureOnlyOneFractional(z2, z);
            FractionProcessor fractionProcessor = new FractionProcessor(chronoElement, i, i2, z);
            int i3 = this.reservedIndex;
            if (i3 != -1 && z2) {
                FormatStep formatStep = (FormatStep) this.steps.get(i3);
                addProcessor(fractionProcessor);
                List list = this.steps;
                if (formatStep.getSection() == ((FormatStep) list.get(list.size() - 1)).getSection()) {
                    this.reservedIndex = i3;
                    this.steps.set(i3, formatStep.reserve(i));
                }
                return this;
            }
            addProcessor(fractionProcessor);
            return this;
        }

        public Builder addLiteral(char c) {
            return addLiteral(String.valueOf(c));
        }

        public Builder addLiteral(char c, char c2) {
            addProcessor(new LiteralProcessor(c, c2));
            return this;
        }

        public Builder addLiteral(String str) {
            int i;
            FormatStep formatStep;
            LiteralProcessor literalProcessor = new LiteralProcessor(str);
            int prefixedDigitArea = literalProcessor.getPrefixedDigitArea();
            if (prefixedDigitArea > 0) {
                if (this.steps.isEmpty()) {
                    formatStep = null;
                } else {
                    List list = this.steps;
                    formatStep = (FormatStep) list.get(list.size() - 1);
                }
                if (formatStep != null && formatStep.isDecimal() && !formatStep.isNewOrBlockStarted()) {
                    throw new IllegalStateException("Numerical literal can't be inserted after an element with decimal digits.");
                }
            }
            if (prefixedDigitArea == 0 || (i = this.reservedIndex) == -1) {
                addProcessor(literalProcessor);
                return this;
            }
            FormatStep formatStep2 = (FormatStep) this.steps.get(i);
            addProcessor(literalProcessor);
            int section = formatStep2.getSection();
            List list2 = this.steps;
            if (section == ((FormatStep) list2.get(list2.size() - 1)).getSection()) {
                this.reservedIndex = i;
                this.steps.set(i, formatStep2.reserve(prefixedDigitArea));
            }
            return this;
        }

        public Builder skipUnknown(ChronoCondition chronoCondition, int i) {
            addProcessor(new SkipProcessor(chronoCondition, i));
            return this;
        }

        public Builder addPattern(String str, PatternType patternType) {
            if (patternType == null) {
                throw new NullPointerException("Missing pattern type.");
            }
            Map map = Collections.EMPTY_MAP;
            int length = str.length();
            Locale locale = this.locale;
            StringBuilder sb = new StringBuilder();
            if (!this.stack.isEmpty()) {
                locale = ((AttributeSet) this.stack.getLast()).getLocale();
            }
            int i = 0;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (isSymbol(cCharAt)) {
                    addLiteralChars(sb);
                    int i2 = i + 1;
                    while (i2 < length && str.charAt(i2) == cCharAt) {
                        i2++;
                    }
                    Map mapRegisterSymbol = patternType.registerSymbol(this, locale, cCharAt, i2 - i);
                    if (!mapRegisterSymbol.isEmpty()) {
                        if (map.isEmpty()) {
                            map = mapRegisterSymbol;
                        } else {
                            HashMap map2 = new HashMap(map);
                            map2.putAll(mapRegisterSymbol);
                            map = map2;
                        }
                    }
                    i = i2 - 1;
                } else if (cCharAt == '\'') {
                    addLiteralChars(sb);
                    int i3 = i + 1;
                    int i4 = i3;
                    while (i4 < length) {
                        if (str.charAt(i4) == '\'') {
                            int i5 = i4 + 1;
                            if (i5 >= length || str.charAt(i5) != '\'') {
                                break;
                            }
                            i4 = i5;
                        }
                        i4++;
                    }
                    if (i4 >= length) {
                        throw new IllegalArgumentException("String literal in pattern not closed: " + str);
                    }
                    if (i3 != i4) {
                        addLiteral(str.substring(i3, i4).replace("''", "'"));
                    } else {
                        addLiteral('\'');
                    }
                    i = i4;
                } else if (cCharAt == '[') {
                    addLiteralChars(sb);
                    startOptionalSection();
                } else if (cCharAt == ']') {
                    addLiteralChars(sb);
                    endSection();
                } else if (cCharAt == '|') {
                    try {
                        addLiteralChars(sb);
                        or();
                    } catch (IllegalStateException e) {
                        throw new IllegalArgumentException(e);
                    }
                } else {
                    if (cCharAt == '#' || cCharAt == '{' || cCharAt == '}') {
                        throw new IllegalArgumentException("Pattern contains reserved character: '" + cCharAt + "'");
                    }
                    sb.append(cCharAt);
                }
                i++;
            }
            addLiteralChars(sb);
            if (!map.isEmpty()) {
                int size = this.steps.size();
                for (int i6 = 0; i6 < size; i6++) {
                    FormatStep formatStep = (FormatStep) this.steps.get(i6);
                    ChronoElement element = formatStep.getProcessor().getElement();
                    if (map.containsKey(element)) {
                        this.steps.set(i6, formatStep.updateElement((ChronoElement) map.get(element)));
                    }
                }
            }
            if (this.pattern != null) {
                str = "";
            }
            this.pattern = str;
            return this;
        }

        public Builder addText(TextElement textElement) {
            checkElement(textElement);
            addProcessor(TextProcessor.create(textElement));
            return this;
        }

        public Builder addText(ChronoElement chronoElement) {
            checkElement(chronoElement);
            if (chronoElement instanceof TextElement) {
                addProcessor(TextProcessor.create((TextElement) TextElement.class.cast(chronoElement)));
                return this;
            }
            HashMap map = new HashMap();
            for (Enum r4 : (Enum[]) chronoElement.getType().getEnumConstants()) {
                map.put(r4, r4.toString());
            }
            addProcessor(new LookupProcessor(chronoElement, map));
            return this;
        }

        public Builder addDayPeriodFixed() {
            return addText(findDayPeriodElement(true, null));
        }

        public Builder addDayPeriodApproximate() {
            return addText(findDayPeriodElement(false, null));
        }

        public Builder addCustomized(ChronoElement chronoElement, ChronoPrinter chronoPrinter, ChronoParser chronoParser) {
            checkElement(chronoElement);
            addProcessor(new CustomizedProcessor(chronoElement, chronoPrinter, chronoParser));
            return this;
        }

        public Builder addTwoDigitYear(ChronoElement chronoElement) {
            checkElement(chronoElement);
            checkAfterDecimalDigits(chronoElement);
            TwoDigitYearProcessor twoDigitYearProcessor = new TwoDigitYearProcessor(chronoElement);
            int i = this.reservedIndex;
            if (i == -1) {
                addProcessor(twoDigitYearProcessor);
                this.reservedIndex = this.steps.size() - 1;
                return this;
            }
            FormatStep formatStep = (FormatStep) this.steps.get(i);
            startSection(Attributes.LENIENCY, Leniency.STRICT);
            addProcessor(twoDigitYearProcessor);
            endSection();
            List list = this.steps;
            if (formatStep.getSection() == ((FormatStep) list.get(list.size() - 1)).getSection()) {
                this.reservedIndex = i;
                this.steps.set(i, formatStep.reserve(2));
            }
            return this;
        }

        public Builder addTimezoneID() {
            if (hasUnixChronology(this.chronology)) {
                addProcessor(TimezoneIDProcessor.INSTANCE);
                return this;
            }
            throw new IllegalStateException("Only unix timestamps can have a timezone id.");
        }

        public Builder addShortTimezoneName() {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(true));
            return this;
        }

        public Builder addLongTimezoneName() {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(false));
            return this;
        }

        public Builder addTimezoneOffset(DisplayMode displayMode, boolean z, List list) {
            addProcessor(new TimezoneOffsetProcessor(displayMode, z, list));
            return this;
        }

        public Builder addShortLocalizedOffset() {
            addProcessor(new LocalizedGMTProcessor(true));
            return this;
        }

        public Builder addLongLocalizedOffset() {
            addProcessor(new LocalizedGMTProcessor(false));
            return this;
        }

        public Builder startOptionalSection() {
            return startOptionalSection(null);
        }

        public Builder startOptionalSection(final ChronoCondition chronoCondition) {
            AttributeSet attributeSet;
            final ChronoCondition condition;
            ChronoCondition chronoCondition2;
            resetPadding();
            Attributes.Builder builder = new Attributes.Builder();
            if (this.stack.isEmpty()) {
                attributeSet = null;
                condition = null;
            } else {
                attributeSet = (AttributeSet) this.stack.getLast();
                builder.setAll(attributeSet.getAttributes());
                condition = attributeSet.getCondition();
            }
            int level = getLevel(attributeSet) + 1;
            int i = this.sectionID + 1;
            this.sectionID = i;
            if (chronoCondition != null) {
                chronoCondition2 = condition == null ? chronoCondition : new ChronoCondition() { // from class: net.time4j.format.expert.ChronoFormatter.Builder.1
                    @Override // net.time4j.engine.ChronoCondition
                    public boolean test(ChronoDisplay chronoDisplay) {
                        return condition.test(chronoDisplay) && chronoCondition.test(chronoDisplay);
                    }
                };
            } else {
                chronoCondition2 = condition;
            }
            this.stack.addLast(new AttributeSet(builder.build(), this.locale, level, i, chronoCondition2));
            return this;
        }

        public Builder startSection(AttributeKey attributeKey, int i) {
            AttributeSet attributeSetWithAttributes;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSetWithAttributes = new AttributeSet(new Attributes.Builder().set(attributeKey, i).build(), this.locale);
            } else {
                AttributeSet attributeSet = (AttributeSet) this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(attributeSet.getAttributes());
                builder.set(attributeKey, i);
                attributeSetWithAttributes = attributeSet.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSetWithAttributes);
            return this;
        }

        public Builder startSection(AttributeKey attributeKey, char c) {
            AttributeSet attributeSetWithAttributes;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSetWithAttributes = new AttributeSet(new Attributes.Builder().set(attributeKey, c).build(), this.locale);
            } else {
                AttributeSet attributeSet = (AttributeSet) this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(attributeSet.getAttributes());
                builder.set(attributeKey, c);
                attributeSetWithAttributes = attributeSet.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSetWithAttributes);
            return this;
        }

        public Builder startSection(AttributeKey attributeKey, Enum r5) {
            AttributeSet attributeSetWithAttributes;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSetWithAttributes = new AttributeSet(new Attributes.Builder().set(attributeKey, r5).build(), this.locale);
            } else {
                AttributeSet attributeSet = (AttributeSet) this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(attributeSet.getAttributes());
                builder.set(attributeKey, r5);
                attributeSetWithAttributes = attributeSet.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSetWithAttributes);
            return this;
        }

        public Builder endSection() {
            this.stack.removeLast();
            resetPadding();
            return this;
        }

        public Builder or() {
            FormatStep formatStep;
            int size;
            int section;
            int section2 = !this.stack.isEmpty() ? ((AttributeSet) this.stack.getLast()).getSection() : 0;
            if (this.steps.isEmpty()) {
                formatStep = null;
                size = -1;
                section = -1;
            } else {
                size = this.steps.size() - 1;
                formatStep = (FormatStep) this.steps.get(size);
                section = formatStep.getSection();
            }
            if (section2 == section) {
                this.steps.set(size, formatStep.startNewOrBlock());
                resetPadding();
                this.reservedIndex = -1;
                return this;
            }
            throw new IllegalStateException("Cannot start or-block without any previous step in current section.");
        }

        public ChronoFormatter build() {
            return build(Attributes.empty());
        }

        public ChronoFormatter build(Attributes attributes) {
            boolean z;
            if (attributes == null) {
                throw new NullPointerException("Missing format attributes.");
            }
            int size = this.steps.size();
            HashMap map = null;
            for (int i = 0; i < size; i++) {
                FormatStep formatStep = (FormatStep) this.steps.get(i);
                if (formatStep.isNewOrBlockStarted()) {
                    int section = formatStep.getSection();
                    int i2 = size - 1;
                    while (true) {
                        if (i2 <= i) {
                            z = false;
                            break;
                        }
                        if (((FormatStep) this.steps.get(i2)).getSection() == section) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            map.put(Integer.valueOf(i), formatStep.markLastOrBlock(i2));
                            z = true;
                            break;
                        }
                        i2--;
                    }
                    if (!z) {
                        throw new IllegalStateException("Missing format processor after or-operator.");
                    }
                }
            }
            if (map != null) {
                for (Integer num : map.keySet()) {
                    this.steps.set(num.intValue(), map.get(num));
                }
            }
            ChronoFormatter chronoFormatter = new ChronoFormatter(this.chronology, this.override, this.locale, this.steps, this.defaultMap, attributes, this.deepestParser);
            String str = this.pattern;
            if (str == null) {
                str = "";
            }
            if (this.dayPeriod == null && str.isEmpty()) {
                return chronoFormatter;
            }
            AttributeSet attributeSetWithInternal = chronoFormatter.globalAttributes;
            if (!str.isEmpty()) {
                attributeSetWithInternal = attributeSetWithInternal.withInternal(Attributes.FORMAT_PATTERN, str);
            }
            DayPeriod dayPeriod = this.dayPeriod;
            if (dayPeriod != null) {
                attributeSetWithInternal = attributeSetWithInternal.withInternal(CUSTOM_DAY_PERIOD, dayPeriod);
            }
            return new ChronoFormatter(attributeSetWithInternal);
        }

        Builder addYear(ChronoElement chronoElement, int i, boolean z) {
            FormatStep formatStep;
            if (this.steps.isEmpty()) {
                formatStep = null;
            } else {
                List list = this.steps;
                formatStep = (FormatStep) list.get(list.size() - 1);
            }
            if (formatStep == null || formatStep.isNewOrBlockStarted() || !formatStep.isNumerical() || i != 4) {
                return addNumber(chronoElement, false, i, 10, SignPolicy.SHOW_WHEN_NEGATIVE, z);
            }
            return addNumber(chronoElement, true, 4, 4, SignPolicy.SHOW_NEVER, z);
        }

        private Builder addNumber(ChronoElement chronoElement, boolean z, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, z, i, i2, signPolicy, false);
        }

        private Builder addNumber(ChronoElement chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2) {
            checkElement(chronoElement);
            FormatStep formatStepCheckAfterDecimalDigits = checkAfterDecimalDigits(chronoElement);
            NumberProcessor numberProcessor = new NumberProcessor(chronoElement, z, i, i2, signPolicy, z2);
            if (z) {
                int i3 = this.reservedIndex;
                if (i3 == -1) {
                    addProcessor(numberProcessor);
                    return this;
                }
                FormatStep formatStep = (FormatStep) this.steps.get(i3);
                addProcessor(numberProcessor);
                List list = this.steps;
                if (formatStep.getSection() == ((FormatStep) list.get(list.size() - 1)).getSection()) {
                    this.reservedIndex = i3;
                    this.steps.set(i3, formatStep.reserve(i));
                }
                return this;
            }
            if (formatStepCheckAfterDecimalDigits != null && formatStepCheckAfterDecimalDigits.isNumerical() && !formatStepCheckAfterDecimalDigits.isNewOrBlockStarted()) {
                throw new IllegalStateException("Numerical element with variable width can't be inserted after another numerical element. Consider \"addFixedXXX()\" instead.");
            }
            addProcessor(numberProcessor);
            this.reservedIndex = this.steps.size() - 1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addProcessor(FormatProcessor formatProcessor) {
            AttributeSet attributeSet;
            int level;
            int section;
            this.reservedIndex = -1;
            if (this.stack.isEmpty()) {
                attributeSet = null;
                level = 0;
                section = 0;
            } else {
                attributeSet = (AttributeSet) this.stack.getLast();
                level = attributeSet.getLevel();
                section = attributeSet.getSection();
            }
            FormatStep formatStep = new FormatStep(formatProcessor, level, section, attributeSet);
            int i = this.leftPadWidth;
            if (i > 0) {
                formatStep = formatStep.pad(i, 0);
                this.leftPadWidth = 0;
            }
            this.steps.add(formatStep);
        }

        private TextElement findDayPeriodElement(boolean z, DayPeriod dayPeriod) {
            AttributeSet attributeSet;
            Attributes attributesBuild = new Attributes.Builder(getChronology()).build();
            AttributeQuery attributeQueryWithInternal = attributesBuild;
            if (dayPeriod != null) {
                if (this.stack.isEmpty()) {
                    attributeSet = new AttributeSet(attributesBuild, this.locale);
                } else {
                    attributeSet = (AttributeSet) this.stack.getLast();
                }
                attributeQueryWithInternal = attributeSet.withInternal(CUSTOM_DAY_PERIOD, dayPeriod);
            }
            Iterator it = PlainTime.axis().getExtensions().iterator();
            while (it.hasNext()) {
                for (ChronoElement chronoElement : ((ChronoExtension) it.next()).getElements(this.locale, attributeQueryWithInternal)) {
                    if (z && chronoElement.getSymbol() == 'b' && isDayPeriodSupported(chronoElement)) {
                        return (TextElement) ChronoFormatter.cast(chronoElement);
                    }
                    if (!z && chronoElement.getSymbol() == 'B' && isDayPeriodSupported(chronoElement)) {
                        return (TextElement) ChronoFormatter.cast(chronoElement);
                    }
                }
            }
            throw new IllegalStateException("Day periods are not supported: " + getChronology().getChronoType());
        }

        private boolean isDayPeriodSupported(ChronoElement chronoElement) {
            if (!chronoElement.name().endsWith("_DAY_PERIOD")) {
                return false;
            }
            if (this.override != null || this.chronology.isSupported(chronoElement)) {
                return true;
            }
            Chronology chronologyPreparser = this.chronology;
            do {
                chronologyPreparser = chronologyPreparser.preparser();
                if (chronologyPreparser == null) {
                    return false;
                }
            } while (!chronologyPreparser.isSupported(chronoElement));
            return true;
        }

        private static int getLevel(AttributeSet attributeSet) {
            if (attributeSet == null) {
                return 0;
            }
            return attributeSet.getLevel();
        }

        private static void checkAttribute(AttributeKey attributeKey) {
            if (attributeKey.name().charAt(0) != '_') {
                return;
            }
            throw new IllegalArgumentException("Internal attribute not allowed: " + attributeKey.name());
        }

        private void checkMomentChrono() {
            if (!hasUnixChronology(this.chronology)) {
                throw new IllegalStateException("Timezone names in specific non-location format can only be reliably combined with instant-like types, for example \"Moment\".");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean hasUnixChronology(Chronology chronology) {
            while (!UnixTime.class.isAssignableFrom(chronology.getChronoType())) {
                chronology = chronology.preparser();
                if (chronology == null) {
                    return false;
                }
            }
            return true;
        }

        private void resetPadding() {
            this.leftPadWidth = 0;
        }

        private void checkElement(ChronoElement chronoElement) {
            Chronology chronologyCheckElement = ChronoFormatter.checkElement(this.chronology, this.override, chronoElement);
            int depth = ChronoFormatter.getDepth(chronologyCheckElement, this.chronology, this.override);
            if (depth >= this.depthOfParser) {
                this.deepestParser = chronologyCheckElement;
                this.depthOfParser = depth;
            }
        }

        private void ensureDecimalDigitsOnlyOnce() {
            for (int size = this.steps.size() - 1; size >= 0; size--) {
                FormatStep formatStep = (FormatStep) this.steps.get(size);
                if (formatStep.isNewOrBlockStarted()) {
                    return;
                }
                if (formatStep.isDecimal()) {
                    throw new IllegalArgumentException("Cannot define more than one element with decimal digits.");
                }
            }
        }

        private void ensureOnlyOneFractional(boolean z, boolean z2) {
            ensureDecimalDigitsOnlyOnce();
            if (!z && !z2 && this.reservedIndex != -1) {
                throw new IllegalArgumentException("Cannot add fractional element with variable width after another numerical element with variable width.");
            }
        }

        private FormatStep checkAfterDecimalDigits(ChronoElement chronoElement) {
            FormatStep formatStep;
            if (this.steps.isEmpty()) {
                formatStep = null;
            } else {
                List list = this.steps;
                formatStep = (FormatStep) list.get(list.size() - 1);
            }
            if (formatStep == null) {
                return null;
            }
            if (!formatStep.isDecimal() || formatStep.isNewOrBlockStarted()) {
                return formatStep;
            }
            throw new IllegalStateException(chronoElement.name() + " can't be inserted after an element with decimal digits.");
        }

        private void addLiteralChars(StringBuilder sb) {
            if (sb.length() > 0) {
                addLiteral(sb.toString());
                sb.setLength(0);
            }
        }
    }

    private static class OverrideHandler implements ChronoMerger {
        private final List extensions;
        private final Chronology override;

        private OverrideHandler(Chronology chronology) {
            this.override = chronology;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(chronology.getExtensions());
            arrayList.addAll(PlainTime.axis().getExtensions());
            this.extensions = Collections.unmodifiableList(arrayList);
        }

        static OverrideHandler of(Chronology chronology) {
            if (chronology == null) {
                return null;
            }
            return new OverrideHandler(chronology);
        }

        @Override // net.time4j.engine.ChronoMerger
        public GeneralTimestamp createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            Object objCreateFrom = this.override.createFrom(chronoEntity, attributeQuery, z, z2);
            PlainTime plainTime = (PlainTime) PlainTime.axis().createFrom(chronoEntity, attributeQuery, z, z2);
            if (objCreateFrom instanceof Calendrical) {
                return (GeneralTimestamp) ChronoFormatter.cast(GeneralTimestamp.of((Calendrical) Calendrical.class.cast(objCreateFrom), plainTime));
            }
            throw new IllegalStateException("Cannot determine calendar type: " + objCreateFrom);
        }

        @Override // net.time4j.engine.ChronoMerger
        public StartOfDay getDefaultStartOfDay() {
            return this.override.getDefaultStartOfDay();
        }

        @Override // net.time4j.engine.ChronoMerger
        public int getDefaultPivotYear() {
            return this.override.getDefaultPivotYear();
        }

        public List getExtensions() {
            return this.extensions;
        }

        public Chronology getCalendarOverride() {
            return this.override;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OverrideHandler) {
                return this.override.equals(((OverrideHandler) obj).override);
            }
            return false;
        }

        public int hashCode() {
            return this.override.hashCode();
        }

        public String toString() {
            return this.override.getChronoType().getName();
        }

        @Override // net.time4j.engine.ChronoMerger
        public ChronoDisplay preformat(GeneralTimestamp generalTimestamp, AttributeQuery attributeQuery) {
            throw new UnsupportedOperationException("Not used.");
        }

        @Override // net.time4j.engine.ChronoMerger
        public Chronology preparser() {
            throw new UnsupportedOperationException("Not used.");
        }

        @Override // net.time4j.engine.ChronoMerger
        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Not used.");
        }
    }

    private static class ZonalDisplay implements ChronoDisplay, UnixTime {
        private final GeneralTimestamp tsp;
        private final TZID tzid;
        private final String variant;

        @Override // net.time4j.engine.ChronoDisplay
        public boolean hasTimezone() {
            return true;
        }

        private ZonalDisplay(GeneralTimestamp generalTimestamp, String str, TZID tzid) {
            this.tsp = generalTimestamp;
            this.variant = str;
            this.tzid = tzid;
        }

        @Override // net.time4j.engine.ChronoDisplay
        public boolean contains(ChronoElement chronoElement) {
            return this.tsp.contains(chronoElement);
        }

        @Override // net.time4j.engine.ChronoDisplay
        public Object get(ChronoElement chronoElement) {
            return this.tsp.get(chronoElement);
        }

        @Override // net.time4j.engine.ChronoDisplay
        public int getInt(ChronoElement chronoElement) {
            return this.tsp.getInt(chronoElement);
        }

        @Override // net.time4j.engine.ChronoDisplay
        public Object getMinimum(ChronoElement chronoElement) {
            return this.tsp.getMinimum(chronoElement);
        }

        @Override // net.time4j.engine.ChronoDisplay
        public Object getMaximum(ChronoElement chronoElement) {
            return this.tsp.getMaximum(chronoElement);
        }

        @Override // net.time4j.engine.ChronoDisplay
        public TZID getTimezone() {
            return this.tzid;
        }

        @Override // net.time4j.base.UnixTime
        public long getPosixTime() {
            return getUnixTime().getPosixTime();
        }

        @Override // net.time4j.base.UnixTime
        public int getNanosecond() {
            return getUnixTime().getNanosecond();
        }

        private UnixTime getUnixTime() {
            StartOfDay defaultStartOfDay;
            try {
                defaultStartOfDay = Chronology.lookup(this.tsp.toDate().getClass()).getDefaultStartOfDay();
            } catch (RuntimeException unused) {
                defaultStartOfDay = StartOfDay.MIDNIGHT;
            }
            return this.tsp.in(Timezone.of(this.tzid), defaultStartOfDay);
        }
    }
}
