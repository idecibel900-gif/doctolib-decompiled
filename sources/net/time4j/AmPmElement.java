package net.time4j;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.GregorianTextElement;

/* JADX INFO: loaded from: classes5.dex */
enum AmPmElement implements ZonalElement, GregorianTextElement {
    AM_PM_OF_DAY;

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return 'a';
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

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Meridiem.class;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((Meridiem) chronoDisplay.get(this)).compareTo((Enum) chronoDisplay2.get(this));
    }

    @Override // net.time4j.engine.ChronoElement
    public Meridiem getDefaultMinimum() {
        return Meridiem.AM;
    }

    @Override // net.time4j.engine.ChronoElement
    public Meridiem getDefaultMaximum() {
        return Meridiem.PM;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor(attributeQuery).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.TextElement
    public Meridiem parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        Meridiem amPm = parseAmPm(charSequence, parsePosition);
        return amPm == null ? (Meridiem) accessor(attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery) : amPm;
    }

    @Override // net.time4j.format.internal.GregorianTextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, Locale locale, TextWidth textWidth, OutputContext outputContext) throws IOException {
        appendable.append(accessor(locale, textWidth, outputContext).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.internal.GregorianTextElement
    public Meridiem parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency) {
        Meridiem amPm = parseAmPm(charSequence, parsePosition);
        return amPm == null ? (Meridiem) accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), leniency) : amPm;
    }

    private TextAccessor accessor(AttributeQuery attributeQuery) {
        return CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getMeridiems((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT));
    }

    private TextAccessor accessor(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getIsoInstance(locale).getMeridiems(textWidth, outputContext);
    }

    static Meridiem parseAmPm(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int i = index + 2;
        if (charSequence.length() < i) {
            return null;
        }
        char cCharAt = charSequence.charAt(index + 1);
        if (cCharAt != 'M' && cCharAt != 'm') {
            return null;
        }
        char cCharAt2 = charSequence.charAt(index);
        if (cCharAt2 == 'A' || cCharAt2 == 'a') {
            parsePosition.setIndex(i);
            return Meridiem.AM;
        }
        if (cCharAt2 != 'P' && cCharAt2 != 'p') {
            return null;
        }
        parsePosition.setIndex(i);
        return Meridiem.PM;
    }
}
