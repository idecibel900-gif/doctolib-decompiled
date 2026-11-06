package net.time4j.calendar;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.NumberSystem;
import net.time4j.format.internal.DualFormatHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class EastAsianMonth implements Comparable, Serializable {
    private static final EastAsianMonth[] CACHE;
    public static final AttributeKey LEAP_MONTH_INDICATOR = Attributes.createKey("LEAP_MONTH_INDICATOR", Character.class);
    public static final AttributeKey LEAP_MONTH_IS_TRAILING = Attributes.createKey("LEAP_MONTH_IS_TRAILING", Boolean.class);
    private static final long serialVersionUID = 7544059597266533279L;
    private final int index;
    private final boolean leap;

    static {
        EastAsianMonth[] eastAsianMonthArr = new EastAsianMonth[24];
        for (int i = 0; i < 12; i++) {
            eastAsianMonthArr[i] = new EastAsianMonth(i, false);
            eastAsianMonthArr[i + 12] = new EastAsianMonth(i, true);
        }
        CACHE = eastAsianMonthArr;
    }

    private EastAsianMonth(int i, boolean z) {
        this.index = i;
        this.leap = z;
    }

    public static EastAsianMonth valueOf(int i) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return CACHE[i - 1];
    }

    public int getNumber() {
        return this.index + 1;
    }

    public boolean isLeap() {
        return this.leap;
    }

    public EastAsianMonth withLeap() {
        return CACHE[this.index + 12];
    }

    @Override // java.lang.Comparable
    public int compareTo(EastAsianMonth eastAsianMonth) {
        int i = this.index;
        int i2 = eastAsianMonth.index;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        if (this.leap) {
            return !eastAsianMonth.leap ? 1 : 0;
        }
        return eastAsianMonth.leap ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EastAsianMonth) {
            EastAsianMonth eastAsianMonth = (EastAsianMonth) obj;
            if (this.index == eastAsianMonth.index && this.leap == eastAsianMonth.leap) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.index + (this.leap ? 12 : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.index + 1);
        if (!this.leap) {
            return strValueOf;
        }
        return "*" + strValueOf;
    }

    String getDisplayName(Locale locale, NumberSystem numberSystem, AttributeQuery attributeQuery) {
        StringBuilder sb;
        Map textForms = CalendarText.getInstance("generic", locale).getTextForms();
        String numeral = DualFormatHelper.toNumeral(numberSystem, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem.getDigits().charAt(0)))).charValue(), getNumber());
        if (!this.leap) {
            return numeral;
        }
        boolean zBooleanValue = ((Boolean) attributeQuery.get(LEAP_MONTH_IS_TRAILING, Boolean.valueOf("R".equals(textForms.get("leap-alignment"))))).booleanValue();
        char cCharValue = ((Character) attributeQuery.get(LEAP_MONTH_INDICATOR, Character.valueOf(((String) textForms.get("leap-indicator")).charAt(0)))).charValue();
        if (zBooleanValue) {
            sb = new StringBuilder();
            sb.append(numeral);
            sb.append(cCharValue);
        } else {
            sb = new StringBuilder();
            sb.append(cCharValue);
            sb.append(numeral);
        }
        return sb.toString();
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            return CACHE[this.index + (this.leap ? 12 : 0)];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
    }
}
