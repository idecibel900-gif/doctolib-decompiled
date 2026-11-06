package net.time4j.format.expert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import net.time4j.PlainTime$BigDecimalElementRule$$ExternalSyntheticBackportWithForwarding0;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

/* JADX INFO: loaded from: classes5.dex */
final class FractionProcessor implements FormatProcessor {
    private final FormatProcessor decimalSeparator;
    private final ChronoElement element;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    FractionProcessor(ChronoElement chronoElement, int i, int i2, boolean z) {
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = !z && i == i2;
        this.decimalSeparator = z ? new LiteralProcessor(Attributes.DECIMAL_SEPARATOR) : null;
        if (chronoElement == null) {
            throw new NullPointerException("Missing element.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Negative min digits: " + i);
        }
        if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        }
        if (i > 9) {
            throw new IllegalArgumentException("Min digits out of range: " + i);
        }
        if (i2 > 9) {
            throw new IllegalArgumentException("Max digits out of range: " + i2);
        }
        this.zeroDigit = '0';
        this.lenientMode = Leniency.SMART;
    }

    private FractionProcessor(FormatProcessor formatProcessor, ChronoElement chronoElement, int i, int i2, boolean z, char c, Leniency leniency) {
        this.decimalSeparator = formatProcessor;
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = z;
        this.zeroDigit = c;
        this.lenientMode = leniency;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set set, boolean z) throws IOException {
        AttributeQuery attributeQuery2;
        char cCharValue;
        Set set2;
        int i;
        int i2;
        BigDecimal decimal = toDecimal((Number) chronoDisplay.get(this.element));
        BigDecimal decimal2 = toDecimal((Number) chronoDisplay.getMinimum(this.element));
        BigDecimal decimal3 = toDecimal((Number) chronoDisplay.getMaximum(this.element));
        if (decimal.compareTo(decimal3) > 0) {
            decimal = decimal3;
        }
        BigDecimal bigDecimalSubtract = decimal.subtract(decimal2);
        BigDecimal bigDecimalAdd = decimal3.subtract(decimal2).add(BigDecimal.ONE);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimalM = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimalM) != 0) {
            bigDecimalM = PlainTime$BigDecimalElementRule$$ExternalSyntheticBackportWithForwarding0.m(bigDecimalDivide);
        }
        BigDecimal bigDecimal = bigDecimalM;
        if (z) {
            cCharValue = this.zeroDigit;
            attributeQuery2 = attributeQuery;
        } else {
            attributeQuery2 = attributeQuery;
            cCharValue = ((Character) attributeQuery2.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        char c = cCharValue;
        int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        int i3 = 0;
        if (bigDecimal.scale() == 0) {
            if (this.minDigits > 0) {
                if (hasDecimalSeparator()) {
                    this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery2, set, z);
                    i = 1;
                } else {
                    i = 0;
                }
                while (true) {
                    i2 = this.minDigits;
                    if (i3 >= i2) {
                        break;
                    }
                    appendable.append(c);
                    i3++;
                }
                i3 = i + i2;
            }
            set2 = set;
        } else {
            if (hasDecimalSeparator()) {
                set2 = set;
                this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery, set2, z);
                i3 = 1;
            } else {
                set2 = set;
            }
            String plainString = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), this.minDigits), this.maxDigits), roundingMode).toPlainString();
            int i4 = c - '0';
            int length2 = plainString.length();
            for (int i5 = 2; i5 < length2; i5++) {
                appendable.append((char) (plainString.charAt(i5) + i4));
                i3++;
            }
        }
        if (length != -1 && i3 > 1 && set2 != null) {
            set2.add(new ElementPosition(this.element, length + 1, length + i3));
        }
        return i3;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity parsedEntity, boolean z) {
        int i;
        int i2;
        char cCharValue;
        Leniency leniency = z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        int i3 = 9;
        if (!leniency.isLax() || this.fixedWidth) {
            i = this.minDigits;
            i2 = this.maxDigits;
        } else {
            i2 = 9;
            i = 0;
        }
        int length = charSequence.length();
        if (parseLog.getPosition() >= length) {
            if (i > 0) {
                parseLog.setError(parseLog.getPosition(), "Expected fraction digits not found for: " + this.element.name());
                return;
            }
            return;
        }
        if (hasDecimalSeparator()) {
            this.decimalSeparator.parse(charSequence, parseLog, attributeQuery, null, z);
            if (parseLog.isError()) {
                if (i == 0) {
                    parseLog.clearError();
                    return;
                }
                return;
            }
        }
        int position = parseLog.getPosition();
        int i4 = position + i;
        int iMin = Math.min(i2 + position, length);
        if (i4 > length && leniency.isStrict()) {
            parseLog.setError(parseLog.getPosition(), "Expected at least " + i + " digits.");
            return;
        }
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        long j = 0;
        while (position < iMin) {
            int iCharAt = charSequence.charAt(position) - cCharValue;
            if (iCharAt < 0 || iCharAt > i3) {
                if (position >= i4 || !leniency.isStrict()) {
                    break;
                    break;
                }
                parseLog.setError(parseLog.getPosition(), "Expected at least " + i + " digits.");
                return;
            }
            j = (j * 10) + ((long) iCharAt);
            position++;
            i3 = 9;
        }
        BigDecimal bigDecimalMovePointLeft = new BigDecimal(j).movePointLeft(position - parseLog.getPosition());
        if (this.element.name().equals("NANO_OF_SECOND")) {
            parsedEntity.put(this.element, getRealValue(bigDecimalMovePointLeft, 0, 999999999));
        } else {
            parsedEntity.put(FractionalElement.FRACTION, bigDecimalMovePointLeft);
            ChronoElement chronoElement = this.element;
            parsedEntity.put(chronoElement, chronoElement.getDefaultMinimum());
        }
        parseLog.setPosition(position);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FractionProcessor) {
            FractionProcessor fractionProcessor = (FractionProcessor) obj;
            if (this.element.equals(fractionProcessor.element) && this.minDigits == fractionProcessor.minDigits && this.maxDigits == fractionProcessor.maxDigits && hasDecimalSeparator() == fractionProcessor.hasDecimalSeparator()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(FractionProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor withElement(ChronoElement chronoElement) {
        return this.element == chronoElement ? this : new FractionProcessor(chronoElement, this.minDigits, this.maxDigits, hasDecimalSeparator());
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor quickPath(ChronoFormatter chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new FractionProcessor(this.decimalSeparator, this.element, this.minDigits, this.maxDigits, this.fixedWidth, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    ChronoEntity update(ChronoEntity chronoEntity, ChronoEntity chronoEntity2) {
        FractionalElement fractionalElement = FractionalElement.FRACTION;
        if (!chronoEntity2.contains(fractionalElement)) {
            return chronoEntity;
        }
        int realValue = getRealValue((BigDecimal) chronoEntity2.get(fractionalElement), ((Integer) chronoEntity.getMinimum(this.element)).intValue(), ((Integer) chronoEntity.getMaximum(this.element)).intValue());
        chronoEntity2.with(fractionalElement, (Object) null);
        chronoEntity2.with(this.element, realValue);
        return chronoEntity.with(this.element, realValue);
    }

    private int getRealValue(BigDecimal bigDecimal, int i, int i2) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i);
        return bigDecimal.multiply(BigDecimal.valueOf(i2).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).intValueExact();
    }

    private static BigDecimal toDecimal(Number number) {
        return BigDecimal.valueOf(number.longValue());
    }

    private boolean hasDecimalSeparator() {
        return this.decimalSeparator != null;
    }
}
