package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import net.time4j.engine.ChronoFunction;

/* JADX INFO: loaded from: classes5.dex */
final class IntegerDateElement extends AbstractDateElement implements ProportionalElement {
    private static final long serialVersionUID = -1337148214680014674L;
    private final transient Integer defaultMax;
    private final transient Integer defaultMin;
    private final transient int index;
    private final transient ChronoFunction rf;
    private final transient char symbol;

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.BasicElement
    protected boolean isSingleton() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.ProportionalElement
    public /* bridge */ /* synthetic */ ElementOperator setLenient(Number number) {
        return super.setLenient((Comparable) number);
    }

    private IntegerDateElement(String str, int i, Integer num, Integer num2, char c) {
        super(str);
        this.index = i;
        this.defaultMin = num;
        this.defaultMax = num2;
        this.symbol = c;
        this.rf = new ProportionalFunction(this, false);
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Integer.class;
    }

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return this.symbol;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMinimum() {
        return this.defaultMin;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMaximum() {
        return this.defaultMax;
    }

    int getIndex() {
        return this.index;
    }

    static IntegerDateElement create(String str, int i, int i2, int i3, char c) {
        return new IntegerDateElement(str, i, Integer.valueOf(i2), Integer.valueOf(i3), c);
    }

    private Object readResolve() throws ObjectStreamException {
        Object objLookupElement = PlainDate.lookupElement(name());
        if (objLookupElement != null) {
            return objLookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
