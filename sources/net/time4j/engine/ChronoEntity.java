package net.time4j.engine;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Set;
import net.time4j.tz.TZID;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ChronoEntity implements ChronoDisplay {
    protected abstract Chronology getChronology();

    @Override // net.time4j.engine.ChronoDisplay
    public boolean hasTimezone() {
        return false;
    }

    @Override // net.time4j.engine.ChronoDisplay
    public boolean contains(ChronoElement chronoElement) {
        return getChronology().isSupported(chronoElement);
    }

    @Override // net.time4j.engine.ChronoDisplay
    public Object get(ChronoElement chronoElement) {
        return getRule(chronoElement).getValue(getContext());
    }

    @Override // net.time4j.engine.ChronoDisplay
    public int getInt(ChronoElement chronoElement) {
        IntElementRule integerRule = getChronology().getIntegerRule(chronoElement);
        try {
            if (integerRule == null) {
                return ((Integer) get(chronoElement)).intValue();
            }
            return integerRule.getInt(getContext());
        } catch (ChronoException unused) {
            return LinearLayoutManager.INVALID_OFFSET;
        }
    }

    @Override // net.time4j.engine.ChronoDisplay
    public Object getMinimum(ChronoElement chronoElement) {
        return getRule(chronoElement).getMinimum(getContext());
    }

    @Override // net.time4j.engine.ChronoDisplay
    public Object getMaximum(ChronoElement chronoElement) {
        return getRule(chronoElement).getMaximum(getContext());
    }

    public boolean isValid(ChronoElement chronoElement, Object obj) {
        if (chronoElement != null) {
            return contains(chronoElement) && getRule(chronoElement).isValid(getContext(), obj);
        }
        throw new NullPointerException("Missing chronological element.");
    }

    public boolean isValid(ChronoElement chronoElement, long j) {
        return isValid(chronoElement, Long.valueOf(j));
    }

    public ChronoEntity with(ChronoElement chronoElement, Object obj) {
        return (ChronoEntity) getRule(chronoElement).withValue(getContext(), obj, chronoElement.isLenient());
    }

    public ChronoEntity with(ChronoElement chronoElement, int i) {
        IntElementRule integerRule = getChronology().getIntegerRule(chronoElement);
        if (integerRule != null) {
            return (ChronoEntity) integerRule.withValue(getContext(), i, chronoElement.isLenient());
        }
        return with(chronoElement, Integer.valueOf(i));
    }

    public ChronoEntity with(ChronoElement chronoElement, long j) {
        return with(chronoElement, Long.valueOf(j));
    }

    public ChronoEntity with(ChronoOperator chronoOperator) {
        return (ChronoEntity) chronoOperator.apply(getContext());
    }

    @Override // net.time4j.engine.ChronoDisplay
    public TZID getTimezone() {
        throw new ChronoException("Timezone not available: " + this);
    }

    public Set getRegisteredElements() {
        return getChronology().getRegisteredElements();
    }

    protected ChronoEntity getContext() {
        Chronology chronology = getChronology();
        Class chronoType = chronology.getChronoType();
        if (chronoType.isInstance(this)) {
            return (ChronoEntity) chronoType.cast(this);
        }
        for (ChronoElement chronoElement : chronology.getRegisteredElements()) {
            if (chronoType == chronoElement.getType()) {
                return (ChronoEntity) chronoType.cast(get(chronoElement));
            }
        }
        throw new IllegalStateException("Implementation error: Cannot find entity context.");
    }

    ElementRule getRule(ChronoElement chronoElement) {
        return getChronology().getRule(chronoElement);
    }
}
