package net.time4j;

import java.io.ObjectStreamException;

/* JADX INFO: loaded from: classes5.dex */
final class WeekdayInMonthElement extends AbstractDateElement implements OrdinalWeekdayElement {
    static final WeekdayInMonthElement INSTANCE = new WeekdayInMonthElement();
    private static final long serialVersionUID = -2378018589067147278L;

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'F';
    }

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

    private WeekdayInMonthElement() {
        super("WEEKDAY_IN_MONTH");
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Integer.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMinimum() {
        return 1;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMaximum() {
        return 5;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
