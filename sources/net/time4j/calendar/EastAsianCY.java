package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.TextElement;

/* JADX INFO: loaded from: classes5.dex */
class EastAsianCY implements TextElement, Serializable {
    static final EastAsianCY SINGLETON = new EastAsianCY();
    private static final long serialVersionUID = -4211396220263977858L;

    EastAsianCY() {
    }

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'U';
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isLenient() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public String name() {
        return "CYCLIC_YEAR";
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return CyclicYear.class;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((CyclicYear) chronoDisplay.get(this)).compareTo((SexagesimalName) chronoDisplay2.get(this));
    }

    @Override // net.time4j.engine.ChronoElement
    public CyclicYear getDefaultMinimum() {
        return CyclicYear.of(1);
    }

    @Override // net.time4j.engine.ChronoElement
    public CyclicYear getDefaultMaximum() {
        return CyclicYear.of(60);
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(((CyclicYear) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)));
    }

    @Override // net.time4j.format.TextElement
    public CyclicYear parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return CyclicYear.parse(charSequence, parsePosition, (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), !((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict());
    }

    protected Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
