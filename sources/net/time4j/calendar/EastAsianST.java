package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.TextElement;

/* JADX INFO: loaded from: classes5.dex */
class EastAsianST implements TextElement, ElementRule, Serializable {
    private static final EastAsianST SINGLETON = new EastAsianST();
    private static final long serialVersionUID = 4572549754637955194L;

    EastAsianST() {
    }

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return (char) 0;
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

    @Override // net.time4j.engine.ElementRule
    public boolean isValid(EastAsianCalendar eastAsianCalendar, SolarTerm solarTerm) {
        return solarTerm != null;
    }

    static EastAsianST getInstance() {
        return SINGLETON;
    }

    @Override // net.time4j.engine.ChronoElement
    public String name() {
        return "SOLAR_TERM";
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return SolarTerm.class;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((SolarTerm) chronoDisplay.get(this)).compareTo((Enum) chronoDisplay2.get(this));
    }

    @Override // net.time4j.engine.ChronoElement
    public SolarTerm getDefaultMinimum() {
        return SolarTerm.MINOR_01_LICHUN_315;
    }

    @Override // net.time4j.engine.ChronoElement
    public SolarTerm getDefaultMaximum() {
        return SolarTerm.MAJOR_12_DAHAN_300;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(((SolarTerm) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)));
    }

    @Override // net.time4j.format.TextElement
    public SolarTerm parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        int length = charSequence.length();
        if (parsePosition.getIndex() >= length) {
            parsePosition.setErrorIndex(length);
            return null;
        }
        return SolarTerm.parse(charSequence, locale, parsePosition);
    }

    @Override // net.time4j.engine.ElementRule
    public SolarTerm getValue(EastAsianCalendar eastAsianCalendar) {
        return SolarTerm.of(eastAsianCalendar.getCalendarSystem().midnight(eastAsianCalendar.getDaysSinceEpochUTC() + 1));
    }

    @Override // net.time4j.engine.ElementRule
    public SolarTerm getMinimum(EastAsianCalendar eastAsianCalendar) {
        EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
        return SolarTerm.of(calendarSystem.midnight(calendarSystem.newYear(eastAsianCalendar.getCycle(), eastAsianCalendar.getYear().getNumber()) + 1));
    }

    @Override // net.time4j.engine.ElementRule
    public SolarTerm getMaximum(EastAsianCalendar eastAsianCalendar) {
        EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
        return SolarTerm.of(calendarSystem.midnight(calendarSystem.newYear(eastAsianCalendar.getCycle(), eastAsianCalendar.getYear().getNumber()) + ((long) eastAsianCalendar.lengthOfYear())));
    }

    @Override // net.time4j.engine.ElementRule
    public EastAsianCalendar withValue(EastAsianCalendar eastAsianCalendar, SolarTerm solarTerm, boolean z) {
        if (solarTerm == null) {
            throw new IllegalArgumentException("Missing solar term.");
        }
        return (EastAsianCalendar) eastAsianCalendar.with(solarTerm.sinceNewYear());
    }

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtFloor(EastAsianCalendar eastAsianCalendar) {
        throw new AbstractMethodError();
    }

    @Override // net.time4j.engine.ElementRule
    public ChronoElement getChildAtCeiling(EastAsianCalendar eastAsianCalendar) {
        throw new AbstractMethodError();
    }

    protected Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
