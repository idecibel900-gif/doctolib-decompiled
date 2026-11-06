package net.time4j.engine;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Chronology implements ChronoMerger {
    private static final List CHRONOS = new CopyOnWriteArrayList();
    private static final ReferenceQueue QUEUE = new ReferenceQueue();
    private final Class chronoType;
    private final List extensions;
    private final Map intRules;
    private final ChronoMerger merger;
    private final Map ruleMap;

    private static Object cast(Object obj) {
        return obj;
    }

    Chronology(Class cls, ChronoMerger chronoMerger, Map map, List list) {
        if (cls == null) {
            throw new NullPointerException("Missing chronological type.");
        }
        if (chronoMerger == null) {
            throw new NullPointerException("Missing chronological merger.");
        }
        this.chronoType = cls;
        this.merger = chronoMerger;
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        this.ruleMap = mapUnmodifiableMap;
        this.extensions = Collections.unmodifiableList(list);
        HashMap map2 = new HashMap();
        for (ChronoElement chronoElement : mapUnmodifiableMap.keySet()) {
            if (chronoElement.getType() == Integer.class) {
                Object obj = this.ruleMap.get(chronoElement);
                if (obj instanceof IntElementRule) {
                    map2.put(chronoElement, (IntElementRule) obj);
                }
            }
        }
        this.intRules = Collections.unmodifiableMap(map2);
    }

    public Class getChronoType() {
        return this.chronoType;
    }

    public Set getRegisteredElements() {
        return this.ruleMap.keySet();
    }

    public boolean isRegistered(ChronoElement chronoElement) {
        return chronoElement != null && this.ruleMap.containsKey(chronoElement);
    }

    public boolean isSupported(ChronoElement chronoElement) {
        if (chronoElement == null) {
            return false;
        }
        return isRegistered(chronoElement) || getDerivedRule(chronoElement, false) != null;
    }

    @Override // net.time4j.engine.ChronoMerger
    public Object createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
        return this.merger.createFrom(chronoEntity, attributeQuery, z, z2);
    }

    @Override // net.time4j.engine.ChronoMerger
    public ChronoDisplay preformat(Object obj, AttributeQuery attributeQuery) {
        return this.merger.preformat(obj, attributeQuery);
    }

    @Override // net.time4j.engine.ChronoMerger
    public Chronology preparser() {
        return this.merger.preparser();
    }

    @Override // net.time4j.engine.ChronoMerger
    public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
        return this.merger.getFormatPattern(displayStyle, locale);
    }

    @Override // net.time4j.engine.ChronoMerger
    public StartOfDay getDefaultStartOfDay() {
        return this.merger.getDefaultStartOfDay();
    }

    @Override // net.time4j.engine.ChronoMerger
    public int getDefaultPivotYear() {
        return this.merger.getDefaultPivotYear();
    }

    public List getExtensions() {
        return this.extensions;
    }

    public CalendarSystem getCalendarSystem() {
        throw new ChronoException("Calendar system is not available.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Chronology lookup(Class cls) {
        Chronology chronology;
        try {
            Class.forName(cls.getName(), true, cls.getClassLoader());
            Iterator it = CHRONOS.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    chronology = null;
                    break;
                }
                chronology = (Chronology) ((ChronoReference) it.next()).get();
                if (chronology == null) {
                    z = true;
                } else if (chronology.getChronoType() == cls) {
                    break;
                }
            }
            if (z) {
                purgeQueue();
            }
            return (Chronology) cast(chronology);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    static void register(Chronology chronology) {
        CHRONOS.add(new ChronoReference(chronology, QUEUE));
    }

    ElementRule getRule(ChronoElement chronoElement) {
        if (chronoElement == null) {
            throw new NullPointerException("Missing chronological element.");
        }
        ElementRule derivedRule = (ElementRule) this.ruleMap.get(chronoElement);
        if (derivedRule == null && (derivedRule = getDerivedRule(chronoElement, true)) == null) {
            throw new RuleNotFoundException(this, chronoElement);
        }
        return (ElementRule) cast(derivedRule);
    }

    IntElementRule getIntegerRule(ChronoElement chronoElement) {
        return (IntElementRule) this.intRules.get(chronoElement);
    }

    private ElementRule getDerivedRule(ChronoElement chronoElement, boolean z) {
        if (!(chronoElement instanceof BasicElement) || !ChronoEntity.class.isAssignableFrom(getChronoType())) {
            return null;
        }
        BasicElement basicElement = (BasicElement) BasicElement.class.cast(chronoElement);
        String veto = z ? basicElement.getVeto(this) : null;
        if (veto == null) {
            return (ElementRule) cast(basicElement.derive((Chronology) cast(this)));
        }
        throw new RuleNotFoundException(veto);
    }

    private static void purgeQueue() {
        while (true) {
            ChronoReference chronoReference = (ChronoReference) QUEUE.poll();
            if (chronoReference == null) {
                return;
            }
            for (ChronoReference chronoReference2 : CHRONOS) {
                if (chronoReference2.name.equals(chronoReference.name)) {
                    CHRONOS.remove(chronoReference2);
                    break;
                }
            }
        }
    }

    public static class Builder {
        final Class chronoType;
        final List extensions;
        final ChronoMerger merger;
        final Map ruleMap;
        final boolean time4j;

        Builder(Class cls, ChronoMerger chronoMerger) {
            if (chronoMerger == null) {
                throw new NullPointerException("Missing chronological merger.");
            }
            this.chronoType = cls;
            this.time4j = cls.getName().startsWith("net.time4j.");
            this.merger = chronoMerger;
            this.ruleMap = new HashMap();
            this.extensions = new ArrayList();
        }

        public Builder appendElement(ChronoElement chronoElement, ElementRule elementRule) {
            checkElementDuplicates(chronoElement);
            this.ruleMap.put(chronoElement, elementRule);
            return this;
        }

        public Builder appendExtension(ChronoExtension chronoExtension) {
            if (chronoExtension == null) {
                throw new NullPointerException("Missing chronological extension.");
            }
            if (!this.extensions.contains(chronoExtension)) {
                this.extensions.add(chronoExtension);
            }
            return this;
        }

        private void checkElementDuplicates(ChronoElement chronoElement) {
            if (this.time4j) {
                return;
            }
            if (chronoElement == null) {
                throw new NullPointerException("Static initialization problem: Check if given element statically refer to any chronology causing premature class loading.");
            }
            String strName = chronoElement.name();
            for (ChronoElement chronoElement2 : this.ruleMap.keySet()) {
                if (chronoElement2.equals(chronoElement) || chronoElement2.name().equals(strName)) {
                    throw new IllegalArgumentException("Element duplicate found: " + strName);
                }
            }
        }
    }

    private static class ChronoReference extends WeakReference {
        private final String name;

        ChronoReference(Chronology chronology, ReferenceQueue referenceQueue) {
            super(chronology, referenceQueue);
            this.name = chronology.chronoType.getName();
        }
    }
}
