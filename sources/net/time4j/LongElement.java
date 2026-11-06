package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoFunction;

/* JADX INFO: loaded from: classes5.dex */
final class LongElement extends AbstractTimeElement implements ProportionalElement {
    static final ChronoElement DAY_OVERFLOW = new LongElement();
    private static final long serialVersionUID = 5930990958663061693L;
    private final transient Long defaultMax;
    private final transient Long defaultMin;
    private final transient ChronoFunction rf;

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return true;
    }

    @Override // net.time4j.ProportionalElement
    public /* bridge */ /* synthetic */ ElementOperator setLenient(Number number) {
        return super.setLenient((Comparable) number);
    }

    private LongElement() {
        this("DAY_OVERFLOW", Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private LongElement(String str, long j, long j2) {
        super(str);
        this.defaultMin = Long.valueOf(j);
        this.defaultMax = Long.valueOf(j2);
        this.rf = new ProportionalFunction(this, true);
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Long.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public Long getDefaultMinimum() {
        return this.defaultMin;
    }

    @Override // net.time4j.engine.ChronoElement
    public Long getDefaultMaximum() {
        return this.defaultMax;
    }

    static LongElement create(String str, long j, long j2) {
        return new LongElement(str, j, j2);
    }

    private Object readResolve() throws ObjectStreamException {
        Object objLookupElement = PlainTime.lookupElement(name());
        if (objLookupElement != null) {
            return objLookupElement;
        }
        if (name().equals("DAY_OVERFLOW")) {
            return DAY_OVERFLOW;
        }
        throw new InvalidObjectException(name());
    }
}
