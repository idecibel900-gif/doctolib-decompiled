package net.time4j.format;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;

/* JADX INFO: loaded from: classes5.dex */
public final class TextAccessor {
    private final List textForms;

    TextAccessor(String[] strArr) {
        this.textForms = Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public String print(Enum r3) {
        int iOrdinal = r3.ordinal();
        if (this.textForms.size() <= iOrdinal) {
            return r3.name();
        }
        return (String) this.textForms.get(iOrdinal);
    }

    public Enum parse(CharSequence charSequence, ParsePosition parsePosition, Class cls, Leniency leniency) {
        TextAccessor textAccessor;
        CharSequence charSequence2;
        ParsePosition parsePosition2;
        Class cls2;
        boolean z;
        boolean z2;
        boolean z3;
        if (leniency != Leniency.STRICT) {
            textAccessor = this;
            charSequence2 = charSequence;
            parsePosition2 = parsePosition;
            cls2 = cls;
            if (leniency == Leniency.LAX) {
                z2 = true;
            } else {
                z = false;
                z2 = true;
                z3 = true;
            }
            return textAccessor.parse(charSequence2, parsePosition2, cls2, z2, z, z3);
        }
        textAccessor = this;
        charSequence2 = charSequence;
        parsePosition2 = parsePosition;
        cls2 = cls;
        z2 = false;
        z = z2;
        z3 = z;
        return textAccessor.parse(charSequence2, parsePosition2, cls2, z2, z, z3);
    }

    public Enum parse(CharSequence charSequence, ParsePosition parsePosition, Class cls, AttributeQuery attributeQuery) {
        AttributeKey attributeKey = Attributes.PARSE_CASE_INSENSITIVE;
        Boolean bool = Boolean.TRUE;
        return parse(charSequence, parsePosition, cls, ((Boolean) attributeQuery.get(attributeKey, bool)).booleanValue(), ((Boolean) attributeQuery.get(Attributes.PARSE_PARTIAL_COMPARE, Boolean.FALSE)).booleanValue(), ((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, bool)).booleanValue());
    }

    public List getTextForms() {
        return this.textForms;
    }

    public String toString() {
        int size = this.textForms.size();
        StringBuilder sb = new StringBuilder((size * 16) + 2);
        sb.append('{');
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append((String) this.textForms.get(i));
        }
        sb.append('}');
        return sb.toString();
    }

    private Enum parse(CharSequence charSequence, ParsePosition parsePosition, Class cls, boolean z, boolean z2, boolean z3) {
        int i;
        String str;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int size = this.textForms.size();
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        String str2 = "";
        String strName = "";
        int i2 = 0;
        Enum r11 = null;
        int i3 = 0;
        while (i2 < enumArr.length) {
            boolean zIsEmpty = strName.isEmpty();
            if (zIsEmpty) {
                strName = i2 >= size ? enumArr[i2].name() : (String) this.textForms.get(i2);
            }
            int length2 = strName.length();
            int i4 = index;
            int i5 = 0;
            boolean z4 = true;
            while (z4 && i5 < length2) {
                Enum[] enumArr2 = enumArr;
                int i6 = index + i5;
                if (i6 >= length) {
                    str = str2;
                    z4 = false;
                } else {
                    char cCharAt = charSequence.charAt(i6);
                    char cCharAt2 = strName.charAt(i5);
                    if (z3) {
                        str = str2;
                        if (cCharAt == 160) {
                            cCharAt = ' ';
                        }
                        if (cCharAt2 == 160) {
                            cCharAt2 = ' ';
                        }
                    } else {
                        str = str2;
                    }
                    boolean z5 = !z ? cCharAt != cCharAt2 : !(cCharAt == cCharAt2 || compareIgnoreCase(cCharAt, cCharAt2));
                    if (z5) {
                        i4++;
                    }
                    z4 = z5;
                }
                i5++;
                enumArr = enumArr2;
                size = size;
                str2 = str;
            }
            Enum[] enumArr3 = enumArr;
            int i7 = size;
            String str3 = str2;
            if (z3 && zIsEmpty && length2 == 5 && strName.charAt(4) == '.' && i4 == (i = index + 3) && i < length && charSequence.charAt(i) == '.') {
                i2--;
                strName = ((Object) strName.subSequence(index, i)) + ".";
            } else {
                if (z2 || length2 == 1) {
                    int i8 = i4 - index;
                    if (i3 < i8) {
                        r11 = enumArr3[i2];
                        i3 = i8;
                    } else if (i3 == i8) {
                        strName = str3;
                        r11 = null;
                    }
                } else if (z4) {
                    parsePosition.setIndex(i4);
                    return enumArr3[i2];
                }
                strName = str3;
            }
            i2++;
            enumArr = enumArr3;
            size = i7;
            str2 = str3;
        }
        if (r11 == null) {
            parsePosition.setErrorIndex(index);
            return r11;
        }
        parsePosition.setIndex(index + i3);
        return r11;
    }

    private boolean compareIgnoreCase(char c, char c2) {
        if (c >= 'a' && c <= 'z') {
            if (c2 >= 'A' && c2 <= 'Z') {
                c2 = (char) (c2 + ' ');
            }
            return c == c2;
        }
        if (c < 'A' || c > 'Z') {
            return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
        }
        char c3 = (char) (c + ' ');
        if (c2 >= 'A' && c2 <= 'Z') {
            c2 = (char) (c2 + ' ');
        }
        return c3 == c2;
    }
}
