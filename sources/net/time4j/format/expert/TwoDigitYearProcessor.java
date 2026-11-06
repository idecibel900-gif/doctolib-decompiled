package net.time4j.format.expert;

import java.io.IOException;
import java.util.Set;
import net.time4j.base.MathUtils;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

/* JADX INFO: loaded from: classes5.dex */
final class TwoDigitYearProcessor implements FormatProcessor {
    private final ChronoElement element;
    private final Leniency lenientMode;
    private final int pivotYear;
    private final int protectedLength;
    private final int reserved;
    private final char zeroDigit;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return true;
    }

    TwoDigitYearProcessor(ChronoElement chronoElement) {
        if (chronoElement.name().startsWith("YEAR")) {
            this.element = chronoElement;
            this.reserved = 0;
            this.zeroDigit = '0';
            this.lenientMode = Leniency.SMART;
            this.protectedLength = 0;
            this.pivotYear = 100;
            return;
        }
        throw new IllegalArgumentException("Year element required: " + chronoElement);
    }

    private TwoDigitYearProcessor(ChronoElement chronoElement, int i, char c, Leniency leniency, int i2, int i3) {
        this.element = chronoElement;
        this.reserved = i;
        this.zeroDigit = c;
        this.lenientMode = leniency;
        this.protectedLength = i2;
        this.pivotYear = i3;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set set, boolean z) throws IOException {
        char cCharValue;
        int iFloorModulo = chronoDisplay.getInt(this.element);
        if (iFloorModulo < 0) {
            if (iFloorModulo == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Format context has no year: " + chronoDisplay);
            }
            throw new IllegalArgumentException("Negative year cannot be printed as two-digit-year: " + iFloorModulo);
        }
        if (getPivotYear(z, attributeQuery) != 100) {
            iFloorModulo = MathUtils.floorModulo(iFloorModulo, 100);
        }
        String string = Integer.toString(iFloorModulo);
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        int i = 0;
        if (cCharValue != '0') {
            int i2 = cCharValue - '0';
            char[] charArray = string.toCharArray();
            for (int i3 = 0; i3 < charArray.length; i3++) {
                charArray[i3] = (char) (charArray[i3] + i2);
            }
            string = new String(charArray);
        }
        int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        if (iFloorModulo < 10) {
            appendable.append(cCharValue);
            i = 1;
        }
        appendable.append(string);
        int length2 = i + string.length();
        if (length != -1 && length2 > 0 && set != null) {
            set.add(new ElementPosition(this.element, length, length + length2));
        }
        return length2;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity parsedEntity, boolean z) {
        char cCharValue;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing digits for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        int iMin = (z ? this.lenientMode : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict() ? 2 : 9;
        if (z) {
            cCharValue = this.zeroDigit;
        } else {
            cCharValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        if (this.reserved > 0 && iIntValue <= 0) {
            int i = 0;
            for (int i2 = position; i2 < length; i2++) {
                int iCharAt = charSequence.charAt(i2) - cCharValue;
                if (iCharAt < 0 || iCharAt > 9) {
                    break;
                }
                i++;
            }
            iMin = Math.min(iMin, i - this.reserved);
        }
        int i3 = position + 2;
        int iMin2 = Math.min(length, iMin + position);
        boolean z2 = true;
        int i4 = position;
        int year = 0;
        while (i4 < iMin2) {
            int iCharAt2 = charSequence.charAt(i4) - cCharValue;
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                if (!z2) {
                    break;
                }
                parseLog.setError(position, "Digit expected.");
                return;
            } else {
                year = (year * 10) + iCharAt2;
                i4++;
                z2 = false;
            }
        }
        if (i4 < i3) {
            parseLog.setError(position, "Not enough digits found for: " + this.element.name());
            return;
        }
        if (i4 == i3) {
            year = toYear(year, getPivotYear(z, attributeQuery));
        }
        parsedEntity.put(this.element, year);
        parseLog.setPosition(i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TwoDigitYearProcessor) {
            return this.element.equals(((TwoDigitYearProcessor) obj).element);
        }
        return false;
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(TwoDigitYearProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor withElement(ChronoElement chronoElement) {
        return this.element == chronoElement ? this : new TwoDigitYearProcessor(chronoElement);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor quickPath(ChronoFormatter chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new TwoDigitYearProcessor(this.element, i, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue(), ((Integer) attributeQuery.get(Attributes.PIVOT_YEAR, Integer.valueOf(chronoFormatter.getChronology().getDefaultPivotYear()))).intValue());
    }

    private static int toYear(int i, int i2) {
        int i3;
        if (i >= i2 % 100) {
            i3 = (i2 / 100) - 1;
        } else {
            i3 = i2 / 100;
        }
        return (i3 * 100) + i;
    }

    private int getPivotYear(boolean z, AttributeQuery attributeQuery) {
        int iIntValue = z ? this.pivotYear : ((Integer) attributeQuery.get(Attributes.PIVOT_YEAR, Integer.valueOf(this.pivotYear))).intValue();
        if (iIntValue >= 100) {
            return iIntValue;
        }
        throw new IllegalArgumentException("Pivot year must not be smaller than 100: " + iIntValue);
    }
}
