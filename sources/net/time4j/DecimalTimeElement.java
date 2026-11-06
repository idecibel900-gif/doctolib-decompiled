package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import net.time4j.engine.BasicElement;

/* JADX INFO: loaded from: classes5.dex */
final class DecimalTimeElement extends BasicElement implements ZonalElement {
    private static final long serialVersionUID = -4837430960549551204L;
    private final transient BigDecimal defaultMax;

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
        return true;
    }

    DecimalTimeElement(String str, BigDecimal bigDecimal) {
        super(str);
        this.defaultMax = bigDecimal;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return BigDecimal.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public BigDecimal getDefaultMinimum() {
        return BigDecimal.ZERO;
    }

    @Override // net.time4j.engine.ChronoElement
    public BigDecimal getDefaultMaximum() {
        return this.defaultMax;
    }

    private Object readResolve() throws ObjectStreamException {
        Object objLookupElement = PlainTime.lookupElement(name());
        if (objLookupElement != null) {
            return objLookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
