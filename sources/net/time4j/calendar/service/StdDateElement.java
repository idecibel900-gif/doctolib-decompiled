package net.time4j.calendar.service;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.format.DisplayElement;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StdDateElement extends DisplayElement implements StdCalendarElement {
    private final Class<ChronoEntity> chrono;
    private final transient boolean daywise;
    private final transient char symbol;

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    public StdDateElement(String str, Class cls, char c, boolean z) {
        super(str);
        this.chrono = cls;
        this.symbol = c;
        this.daywise = z;
    }

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return this.symbol;
    }

    @Override // net.time4j.engine.BasicElement
    protected boolean doEquals(BasicElement basicElement) {
        return this.chrono == ((StdDateElement) basicElement).chrono;
    }

    protected Object readResolve() throws ObjectStreamException {
        String strName = name();
        for (ChronoElement chronoElement : Chronology.lookup(this.chrono).getRegisteredElements()) {
            if (chronoElement.name().equals(strName)) {
                return chronoElement;
            }
        }
        throw new InvalidObjectException(strName);
    }

    protected Class getChronoType() {
        return this.chrono;
    }
}
