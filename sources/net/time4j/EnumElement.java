package net.time4j;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.NumericalElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.GregorianTextElement;

/* JADX INFO: loaded from: classes5.dex */
final class EnumElement extends AbstractDateElement implements NavigableElement, NumericalElement, GregorianTextElement {
    private static final long serialVersionUID = 2055272540517425102L;
    private final transient Enum dmax;
    private final transient Enum dmin;
    private final transient int index;
    private final transient char symbol;
    private final transient Class type;

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

    EnumElement(String str, Class cls, Enum r3, Enum r4, int i, char c) {
        super(str);
        this.type = cls;
        this.dmin = r3;
        this.dmax = r4;
        this.index = i;
        this.symbol = c;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return this.type;
    }

    @Override // net.time4j.engine.BasicElement, net.time4j.engine.ChronoElement
    public char getSymbol() {
        return this.symbol;
    }

    @Override // net.time4j.engine.ChronoElement
    public Enum getDefaultMinimum() {
        return this.dmin;
    }

    @Override // net.time4j.engine.ChronoElement
    public Enum getDefaultMaximum() {
        return this.dmax;
    }

    public int numerical(Enum r1) {
        return r1.ordinal() + 1;
    }

    @Override // net.time4j.format.NumericalElement
    public int printToInt(Enum r1, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        return r1.ordinal() + 1;
    }

    @Override // net.time4j.format.NumericalElement
    public boolean parseFromInt(ChronoEntity chronoEntity, int i) {
        for (Enum r4 : (Enum[]) getType().getEnumConstants()) {
            if (numerical(r4) == i) {
                chronoEntity.with(this, r4);
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.format.TextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.TextElement
    public Enum parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        int index = parsePosition.getIndex();
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        AttributeKey attributeKey = Attributes.OUTPUT_CONTEXT;
        OutputContext outputContext = OutputContext.FORMAT;
        OutputContext outputContext2 = (OutputContext) attributeQuery.get(attributeKey, outputContext);
        Enum r5 = accessor(locale, textWidth, outputContext2).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (r5 != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
            return r5;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        if (outputContext2 == outputContext) {
            outputContext = OutputContext.STANDALONE;
        }
        return accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    @Override // net.time4j.format.internal.GregorianTextElement
    public void print(ChronoDisplay chronoDisplay, Appendable appendable, Locale locale, TextWidth textWidth, OutputContext outputContext) throws IOException {
        appendable.append(accessor(locale, textWidth, outputContext).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.internal.GregorianTextElement
    public Enum parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency) {
        int index = parsePosition.getIndex();
        Enum r1 = accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), leniency);
        if (r1 != null || leniency.isStrict()) {
            return r1;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        OutputContext outputContext2 = OutputContext.FORMAT;
        if (outputContext == outputContext2) {
            outputContext2 = OutputContext.STANDALONE;
        }
        return accessor(locale, textWidth, outputContext2).parse(charSequence, parsePosition, getType(), leniency);
    }

    int getIndex() {
        return this.index;
    }

    private TextAccessor accessor(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        switch (this.index) {
            case 101:
                return CalendarText.getIsoInstance(locale).getStdMonths(textWidth, outputContext);
            case 102:
                return CalendarText.getIsoInstance(locale).getWeekdays(textWidth, outputContext);
            case 103:
                return CalendarText.getIsoInstance(locale).getQuarters(textWidth, outputContext);
            default:
                throw new UnsupportedOperationException(name());
        }
    }

    private Object readResolve() throws ObjectStreamException {
        Object objLookupElement = PlainDate.lookupElement(name());
        if (objLookupElement != null) {
            return objLookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
