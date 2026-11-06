package net.time4j.calendar.service;

import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
public class StdIntegerDateElement extends StdDateElement {
    private static final long serialVersionUID = -4975173343610190782L;
    private final transient ChronoOperator decrementor;
    private final transient ChronoOperator incrementor;
    private final transient int max;
    private final transient int min;

    public StdIntegerDateElement(String str, Class cls, int i, int i2, char c) {
        super(str, cls, c, str.startsWith("DAY_OF_"));
        this.min = i;
        this.max = i2;
        this.decrementor = null;
        this.incrementor = null;
    }

    public StdIntegerDateElement(String str, Class cls, int i, int i2, char c, ChronoOperator chronoOperator, ChronoOperator chronoOperator2) {
        super(str, cls, c, false);
        this.min = i;
        this.max = i2;
        this.decrementor = chronoOperator;
        this.incrementor = chronoOperator2;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Integer.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMinimum() {
        return Integer.valueOf(this.min);
    }

    @Override // net.time4j.engine.ChronoElement
    public Integer getDefaultMaximum() {
        return Integer.valueOf(this.max);
    }
}
