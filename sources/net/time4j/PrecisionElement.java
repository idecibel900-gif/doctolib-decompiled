package net.time4j;

import java.util.concurrent.TimeUnit;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;

/* JADX INFO: loaded from: classes5.dex */
class PrecisionElement implements ChronoElement {
    static final ChronoElement CLOCK_PRECISION = new PrecisionElement(ClockUnit.class, ClockUnit.HOURS, ClockUnit.NANOS);
    static final ChronoElement TIME_PRECISION = new PrecisionElement(TimeUnit.class, TimeUnit.DAYS, TimeUnit.NANOSECONDS);
    private final transient Comparable max;
    private final transient Comparable min;
    private final Class type;

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return (char) 0;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isLenient() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return true;
    }

    private PrecisionElement(Class cls, Comparable comparable, Comparable comparable2) {
        this.type = cls;
        this.min = comparable;
        this.max = comparable2;
    }

    @Override // net.time4j.engine.ChronoElement
    public String name() {
        return "PRECISION";
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return this.type;
    }

    @Override // net.time4j.engine.ChronoElement
    public Comparable getDefaultMinimum() {
        return this.min;
    }

    @Override // net.time4j.engine.ChronoElement
    public Comparable getDefaultMaximum() {
        return this.max;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        Comparable comparable = (Comparable) chronoDisplay.get(this);
        Comparable comparable2 = (Comparable) chronoDisplay2.get(this);
        if (this.type == ClockUnit.class) {
            return comparable.compareTo(comparable2);
        }
        return comparable2.compareTo(comparable);
    }
}
