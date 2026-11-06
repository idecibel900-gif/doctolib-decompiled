package net.time4j.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class TimeAxis extends Chronology implements TimeLine {
    private final Map baseUnits;
    private final CalendarSystem calendarSystem;
    private final Map convertibleUnits;
    private final TimePoint max;
    private final TimePoint min;
    private final ChronoElement self;
    private final TimeLine timeline;
    private final Map unitLengths;
    private final Map unitRules;
    private final Class unitType;

    private TimeAxis(Class cls, Class cls2, ChronoMerger chronoMerger, Map map, Map map2, final Map map3, Map map4, List list, Map map5, TimePoint timePoint, TimePoint timePoint2, CalendarSystem calendarSystem, TimeLine timeLine) {
        super(cls, chronoMerger, map, list);
        this.unitType = cls2;
        this.unitRules = Collections.unmodifiableMap(map2);
        this.unitLengths = Collections.unmodifiableMap(map3);
        this.convertibleUnits = Collections.unmodifiableMap(map4);
        this.baseUnits = Collections.unmodifiableMap(map5);
        this.min = timePoint;
        this.max = timePoint2;
        this.calendarSystem = calendarSystem;
        this.self = new SelfElement(cls, timePoint, timePoint2);
        if (timeLine == null) {
            ArrayList arrayList = new ArrayList(map2.keySet());
            Collections.sort(arrayList, new Comparator() { // from class: net.time4j.engine.TimeAxis.1
                @Override // java.util.Comparator
                public int compare(Object obj, Object obj2) {
                    return Double.compare(TimeAxis.getLength(map3, obj), TimeAxis.getLength(map3, obj2));
                }
            });
            this.timeline = new DefaultTimeLine(arrayList.get(0), timePoint, timePoint2);
            return;
        }
        this.timeline = timeLine;
    }

    public boolean isRegistered(Object obj) {
        return this.unitRules.containsKey(obj);
    }

    @Override // java.util.Comparator
    public int compare(TimePoint timePoint, TimePoint timePoint2) {
        return timePoint.compareTo(timePoint2);
    }

    public Object getBaseUnit(ChronoElement chronoElement) {
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        Object obj = this.baseUnits.get(chronoElement);
        if (obj == null && (chronoElement instanceof BasicElement)) {
            obj = this.baseUnits.get(((BasicElement) chronoElement).getParent());
        }
        if (obj != null) {
            return obj;
        }
        throw new ChronoException("Base unit not found for: " + chronoElement.name());
    }

    public TimePoint getMinimum() {
        return this.min;
    }

    public TimePoint getMaximum() {
        return this.max;
    }

    @Override // net.time4j.engine.Chronology
    public CalendarSystem getCalendarSystem() {
        CalendarSystem calendarSystem = this.calendarSystem;
        return calendarSystem == null ? super.getCalendarSystem() : calendarSystem;
    }

    @Override // net.time4j.engine.Chronology, net.time4j.engine.ChronoMerger
    public TimePoint createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
        if (chronoEntity.contains(this.self)) {
            return (TimePoint) chronoEntity.get(this.self);
        }
        return (TimePoint) super.createFrom(chronoEntity, attributeQuery, z, z2);
    }

    public ChronoElement element() {
        return this.self;
    }

    UnitRule getRule(Object obj) {
        UnitRule unitRuleDerive;
        if (obj == null) {
            throw new NullPointerException("Missing chronological unit.");
        }
        if (isRegistered(obj)) {
            return (UnitRule) this.unitRules.get(obj);
        }
        if (!(obj instanceof BasicUnit) || (unitRuleDerive = ((BasicUnit) BasicUnit.class.cast(obj)).derive(this)) == null) {
            throw new RuleNotFoundException(this, obj);
        }
        return unitRuleDerive;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double getLength(Map map, Object obj) {
        Double d = (Double) map.get(obj);
        if (d == null) {
            if (obj instanceof ChronoUnit) {
                return ((ChronoUnit) ChronoUnit.class.cast(obj)).getLength();
            }
            return Double.NaN;
        }
        return d.doubleValue();
    }

    public static final class Builder extends Chronology.Builder {
        private final Map baseUnits;
        private final CalendarSystem calendarSystem;
        private final Map convertibleUnits;
        private final TimePoint max;
        private final TimePoint min;
        private TimeLine timeline;
        private final Map unitLengths;
        private final Map unitRules;
        private final Class unitType;

        private Builder(Class cls, Class cls2, ChronoMerger chronoMerger, TimePoint timePoint, TimePoint timePoint2, CalendarSystem calendarSystem, TimeLine timeLine) {
            super(cls2, chronoMerger);
            this.timeline = null;
            if (cls == null) {
                throw new NullPointerException("Missing unit type.");
            }
            if (timePoint == null) {
                throw new NullPointerException("Missing minimum of range.");
            }
            if (timePoint2 == null) {
                throw new NullPointerException("Missing maximum of range.");
            }
            if (Calendrical.class.isAssignableFrom(cls2) && calendarSystem == null) {
                throw new NullPointerException("Missing calendar system.");
            }
            this.unitType = cls;
            this.unitRules = new HashMap();
            this.unitLengths = new HashMap();
            this.convertibleUnits = new HashMap();
            this.baseUnits = new HashMap();
            this.min = timePoint;
            this.max = timePoint2;
            this.calendarSystem = calendarSystem;
            this.timeline = timeLine;
        }

        public static Builder setUp(Class cls, Class cls2, ChronoMerger chronoMerger, TimePoint timePoint, TimePoint timePoint2) {
            return new Builder(cls, cls2, chronoMerger, timePoint, timePoint2, null, null);
        }

        public static Builder setUp(Class cls, Class cls2, ChronoMerger chronoMerger, CalendarSystem calendarSystem) {
            Builder builder = new Builder(cls, cls2, chronoMerger, (TimePoint) calendarSystem.transform(calendarSystem.getMinimumSinceUTC()), (TimePoint) calendarSystem.transform(calendarSystem.getMaximumSinceUTC()), calendarSystem, null);
            for (EpochDays epochDays : EpochDays.values()) {
                builder.appendElement((ChronoElement) epochDays, epochDays.derive(calendarSystem));
            }
            return builder;
        }

        @Override // net.time4j.engine.Chronology.Builder
        public Builder appendElement(ChronoElement chronoElement, ElementRule elementRule) {
            super.appendElement(chronoElement, elementRule);
            return this;
        }

        public Builder appendElement(ChronoElement chronoElement, ElementRule elementRule, Object obj) {
            if (obj == null) {
                throw new NullPointerException("Missing base unit.");
            }
            super.appendElement(chronoElement, elementRule);
            this.baseUnits.put(chronoElement, obj);
            return this;
        }

        public Builder appendUnit(Object obj, UnitRule unitRule, double d, Set set) {
            if (obj == null) {
                throw new NullPointerException("Missing time unit.");
            }
            if (unitRule == null) {
                throw new NullPointerException("Missing unit rule.");
            }
            checkUnitDuplicates(obj);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new NullPointerException("Found convertible unit which is null.");
                }
            }
            if (Double.isNaN(d)) {
                throw new IllegalArgumentException("Not a number: " + d);
            }
            if (Double.isInfinite(d)) {
                throw new IllegalArgumentException("Infinite: " + d);
            }
            this.unitRules.put(obj, unitRule);
            this.unitLengths.put(obj, Double.valueOf(d));
            HashSet hashSet = new HashSet(set);
            hashSet.remove(obj);
            this.convertibleUnits.put(obj, hashSet);
            return this;
        }

        @Override // net.time4j.engine.Chronology.Builder
        public Builder appendExtension(ChronoExtension chronoExtension) {
            super.appendExtension(chronoExtension);
            return this;
        }

        public Builder withTimeLine(TimeLine timeLine) {
            if (timeLine == null) {
                throw new NullPointerException("Missing time line.");
            }
            this.timeline = timeLine;
            return this;
        }

        public TimeAxis build() {
            if (this.unitRules.isEmpty()) {
                throw new IllegalStateException("No time unit was registered.");
            }
            TimeAxis timeAxis = new TimeAxis(this.chronoType, this.unitType, this.merger, this.ruleMap, this.unitRules, this.unitLengths, this.convertibleUnits, this.extensions, this.baseUnits, this.min, this.max, this.calendarSystem, this.timeline);
            Chronology.register(timeAxis);
            return timeAxis;
        }

        private void checkUnitDuplicates(Object obj) {
            if (this.time4j) {
                return;
            }
            Iterator it = this.unitRules.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equals(obj)) {
                    throw new IllegalArgumentException("Unit duplicate found: " + obj.toString());
                }
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) Enum.class.cast(obj)).name();
                for (Object obj2 : this.unitRules.keySet()) {
                    if ((obj2 instanceof Enum) && ((Enum) Enum.class.cast(obj2)).name().equals(strName)) {
                        throw new IllegalArgumentException("Unit duplicate found: " + strName);
                    }
                }
            }
        }
    }

    private static class SelfElement extends BasicElement implements ElementRule {
        private static final long serialVersionUID = 4777240530511579802L;
        private final TimePoint max;
        private final TimePoint min;
        private final Class<TimePoint> type;

        @Override // net.time4j.engine.ElementRule
        public TimePoint getValue(TimePoint timePoint) {
            return timePoint;
        }

        @Override // net.time4j.engine.BasicElement
        protected String getVeto(Chronology chronology) {
            return null;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isDateElement() {
            return false;
        }

        @Override // net.time4j.engine.BasicElement
        protected boolean isSingleton() {
            return true;
        }

        @Override // net.time4j.engine.ChronoElement
        public boolean isTimeElement() {
            return false;
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(TimePoint timePoint, TimePoint timePoint2) {
            return timePoint2 != null;
        }

        private SelfElement(Class cls, TimePoint timePoint, TimePoint timePoint2) {
            super(cls.getName() + "-AXIS");
            this.type = cls;
            this.min = timePoint;
            this.max = timePoint2;
        }

        @Override // net.time4j.engine.ChronoElement
        public Class getType() {
            return this.type;
        }

        @Override // net.time4j.engine.ChronoElement
        public TimePoint getDefaultMinimum() {
            return this.min;
        }

        @Override // net.time4j.engine.ChronoElement
        public TimePoint getDefaultMaximum() {
            return this.max;
        }

        @Override // net.time4j.engine.ElementRule
        public TimePoint getMinimum(TimePoint timePoint) {
            return getDefaultMinimum();
        }

        @Override // net.time4j.engine.ElementRule
        public TimePoint getMaximum(TimePoint timePoint) {
            return getDefaultMaximum();
        }

        @Override // net.time4j.engine.ElementRule
        public TimePoint withValue(TimePoint timePoint, TimePoint timePoint2, boolean z) {
            if (timePoint2 != null) {
                return timePoint2;
            }
            throw new IllegalArgumentException("Missing value.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(TimePoint timePoint) {
            throw new UnsupportedOperationException();
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(TimePoint timePoint) {
            throw new UnsupportedOperationException();
        }

        @Override // net.time4j.engine.BasicElement
        protected ElementRule derive(Chronology chronology) {
            if (chronology.getChronoType().equals(this.type)) {
                return this;
            }
            return null;
        }
    }

    private static class DefaultTimeLine implements TimeLine {
        private final TimePoint max;
        private final TimePoint min;
        private final Object step;

        DefaultTimeLine(Object obj, TimePoint timePoint, TimePoint timePoint2) {
            this.step = obj;
            this.min = timePoint;
            this.max = timePoint2;
        }

        @Override // java.util.Comparator
        public int compare(TimePoint timePoint, TimePoint timePoint2) {
            return timePoint.compareTo(timePoint2);
        }
    }
}
