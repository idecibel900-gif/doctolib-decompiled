package net.time4j.engine;

import java.io.Serializable;
import net.time4j.base.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TimePoint extends ChronoEntity implements Comparable, Serializable {
    public abstract int compareTo(TimePoint timePoint);

    @Override // net.time4j.engine.ChronoEntity
    protected abstract TimeAxis getChronology();

    public TimePoint plus(long j, Object obj) {
        if (j == 0) {
            return (TimePoint) getContext();
        }
        try {
            return (TimePoint) getRule(obj).addTo(getContext(), j);
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public TimePoint minus(long j, Object obj) {
        return plus(MathUtils.safeNegate(j), obj);
    }

    public long until(TimePoint timePoint, Object obj) {
        return getRule(obj).between(getContext(), timePoint);
    }

    private UnitRule getRule(Object obj) {
        return getChronology().getRule(obj);
    }
}
