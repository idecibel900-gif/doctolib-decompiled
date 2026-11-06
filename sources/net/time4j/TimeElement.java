package net.time4j;

import java.io.ObjectStreamException;
import net.time4j.engine.BasicElement;

/* JADX INFO: loaded from: classes5.dex */
final class TimeElement extends BasicElement implements WallTimeElement {
    static final TimeElement INSTANCE = new TimeElement();
    private static final long serialVersionUID = -3712256393866098916L;

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

    private TimeElement() {
        super("WALL_TIME");
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return PlainTime.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public PlainTime getDefaultMinimum() {
        return PlainTime.MIN;
    }

    @Override // net.time4j.engine.ChronoElement
    public PlainTime getDefaultMaximum() {
        return PlainTime.of(23, 59, 59, 999999999);
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
