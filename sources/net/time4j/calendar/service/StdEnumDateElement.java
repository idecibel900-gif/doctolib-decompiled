package net.time4j.calendar.service;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.NumericalElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StdEnumDateElement extends StdDateElement implements NumericalElement, TextElement {
    private static final long serialVersionUID = -2452569351302286113L;
    private final transient ChronoOperator decrementor;
    private final transient String defaultCalendarType;
    private final transient ChronoOperator incrementor;
    private final transient Class type;

    private static boolean isWeekdayElement(char c) {
        return c == 'E';
    }

    protected boolean hasLeapMonth(ChronoDisplay chronoDisplay) {
        return false;
    }

    public abstract int numerical(Enum r1);

    public StdEnumDateElement(String str, Class cls, Class cls2, char c) {
        super(str, cls, c, isWeekdayElement(c));
        this.type = cls2;
        this.defaultCalendarType = extractCalendarType(cls);
        this.decrementor = null;
        this.incrementor = null;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return this.type;
    }

    @Override // net.time4j.format.NumericalElement
    public int printToInt(Enum r1, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        return numerical(r1);
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
        appendable.append(accessor(attributeQuery, (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT), hasLeapMonth(chronoDisplay)).print((Enum) chronoDisplay.get(this)));
    }

    @Override // net.time4j.format.TextElement
    public Enum parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        int index = parsePosition.getIndex();
        AttributeKey attributeKey = Attributes.OUTPUT_CONTEXT;
        OutputContext outputContext = OutputContext.FORMAT;
        OutputContext outputContext2 = (OutputContext) attributeQuery.get(attributeKey, outputContext);
        Enum r4 = accessor(attributeQuery, outputContext2, false).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (r4 == null && isMonthElement()) {
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            r4 = accessor(attributeQuery, outputContext2, true).parse(charSequence, parsePosition, getType(), attributeQuery);
        }
        if (r4 != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
            return r4;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        if (outputContext2 == outputContext) {
            outputContext = OutputContext.STANDALONE;
        }
        Enum r1 = accessor(attributeQuery, outputContext, false).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (r1 != null || !isMonthElement()) {
            return r1;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        return accessor(attributeQuery, outputContext, true).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    protected String getCalendarType(AttributeQuery attributeQuery) {
        if (isMonthElement() || isEraElement()) {
            return (String) attributeQuery.get(Attributes.CALENDAR_TYPE, this.defaultCalendarType);
        }
        if (isWeekdayElement()) {
            return "iso8601";
        }
        return this.defaultCalendarType;
    }

    protected boolean isEraElement() {
        return getSymbol() == 'G';
    }

    protected boolean isMonthElement() {
        return getSymbol() == 'M';
    }

    protected boolean isWeekdayElement() {
        return isWeekdayElement(getSymbol());
    }

    protected TextAccessor accessor(AttributeQuery attributeQuery, OutputContext outputContext, boolean z) {
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        CalendarText calendarText = CalendarText.getInstance(getCalendarType(attributeQuery), locale);
        if (isMonthElement()) {
            if (z) {
                return calendarText.getLeapMonths(textWidth, outputContext);
            }
            return calendarText.getStdMonths(textWidth, outputContext);
        }
        if (isWeekdayElement()) {
            return calendarText.getWeekdays(textWidth, outputContext);
        }
        if (isEraElement()) {
            return calendarText.getEras(textWidth);
        }
        return calendarText.getTextForms(name(), this.type, new String[0]);
    }

    private static String extractCalendarType(Class cls) {
        CalendarType calendarType = (CalendarType) cls.getAnnotation(CalendarType.class);
        return calendarType == null ? "iso8601" : calendarType.value();
    }
}
