package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.engine.BasicElement;

/* JADX INFO: loaded from: classes5.dex */
final class DateElement extends BasicElement implements CalendarDateElement {
    static final DateElement INSTANCE = new DateElement();
    private static final long serialVersionUID = -6519899440006935829L;

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

    private DateElement() {
        super("CALENDAR_DATE");
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return PlainDate.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public PlainDate getDefaultMinimum() {
        return PlainDate.MIN;
    }

    @Override // net.time4j.engine.ChronoElement
    public PlainDate getDefaultMaximum() {
        return PlainDate.MAX;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
