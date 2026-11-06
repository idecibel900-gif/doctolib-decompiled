package net.time4j.format;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.util.Locale;
import net.time4j.base.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public enum NumberSystem {
    ARABIC("latn") { // from class: net.time4j.format.NumberSystem.1
        @Override // net.time4j.format.NumberSystem
        public boolean contains(char c) {
            return c >= '0' && c <= '9';
        }

        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String toNumeral(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot convert: " + i);
            }
            return Integer.toString(i);
        }

        @Override // net.time4j.format.NumberSystem
        public int toInteger(String str, Leniency leniency) {
            int i = Integer.parseInt(str);
            if (i >= 0) {
                return i;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "0123456789";
        }
    },
    ARABIC_INDIC("arab") { // from class: net.time4j.format.NumberSystem.2
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "٠١٢٣٤٥٦٧٨٩";
        }
    },
    ARABIC_INDIC_EXT("arabext") { // from class: net.time4j.format.NumberSystem.3
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "۰۱۲۳۴۵۶۷۸۹";
        }
    },
    BENGALI("beng") { // from class: net.time4j.format.NumberSystem.4
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "০১২৩৪৫৬৭৮৯";
        }
    },
    DEVANAGARI("deva") { // from class: net.time4j.format.NumberSystem.5
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "०१२३४५६७८९";
        }
    },
    DOZENAL("dozenal") { // from class: net.time4j.format.NumberSystem.6
        @Override // net.time4j.format.NumberSystem
        public boolean contains(char c) {
            return (c >= '0' && c <= '9') || c == 8586 || c == 8587;
        }

        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return false;
        }

        @Override // net.time4j.format.NumberSystem
        public String toNumeral(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot convert: " + i);
            }
            return Integer.toString(i, 12).replace('a', (char) 8586).replace('b', (char) 8587);
        }

        @Override // net.time4j.format.NumberSystem
        public int toNumeral(int i, Appendable appendable) throws IOException {
            char c;
            if (i >= 0) {
                int i2 = 1;
                while (true) {
                    if (i2 > 4) {
                        i2 = 0;
                        break;
                    }
                    if (i < NumberSystem.D_FACTORS[i2]) {
                        break;
                    }
                    i2++;
                }
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    do {
                        int i4 = i / NumberSystem.D_FACTORS[i3];
                        if (i4 == 11) {
                            c = 8587;
                        } else {
                            c = i4 == 10 ? (char) 8586 : (char) (i4 + 48);
                        }
                        appendable.append(c);
                        i -= i4 * NumberSystem.D_FACTORS[i3];
                        i3--;
                    } while (i3 >= 0);
                    return i2;
                }
            }
            return super.toNumeral(i, appendable);
        }

        @Override // net.time4j.format.NumberSystem
        public int toInteger(String str, Leniency leniency) {
            int i = Integer.parseInt(str.replace((char) 8586, 'a').replace((char) 8587, 'b'), 12);
            if (i >= 0) {
                return i;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "0123456789↊↋";
        }
    },
    ETHIOPIC("ethiopic") { // from class: net.time4j.format.NumberSystem.7
        @Override // net.time4j.format.NumberSystem
        public boolean contains(char c) {
            return c >= 4969 && c <= 4988;
        }

        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return false;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x005e  */
        @Override // net.time4j.format.NumberSystem
        public String toNumeral(int i) {
            char c;
            if (i < 1) {
                throw new IllegalArgumentException("Can only convert positive numbers: " + i);
            }
            String strValueOf = String.valueOf(i);
            int length = strValueOf.length();
            int i2 = length - 1;
            if (i2 % 2 == 0) {
                strValueOf = "0" + strValueOf;
            } else {
                length = i2;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = length; i3 >= 0; i3 -= 2) {
                char cCharAt = strValueOf.charAt(length - i3);
                int i4 = i3 - 1;
                char cCharAt2 = strValueOf.charAt(length - i4);
                char c2 = 0;
                char c3 = cCharAt2 != '0' ? (char) (cCharAt2 + 4920) : (char) 0;
                char c4 = cCharAt != '0' ? (char) (cCharAt + 4929) : (char) 0;
                int i5 = (i4 % 4) / 2;
                if (i4 == 0) {
                    c = 0;
                } else if (i5 == 0) {
                    c = 4988;
                } else if (c3 == 0 && c4 == 0) {
                    c = 0;
                } else {
                    c = 4987;
                }
                if (c3 != 4969 || c4 != 0 || length <= 1 || (c != 4987 && i3 != length)) {
                    c2 = c3;
                }
                if (c4 != 0) {
                    sb.append(c4);
                }
                if (c2 != 0) {
                    sb.append(c2);
                }
                if (c != 0) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        @Override // net.time4j.format.NumberSystem
        public int toInteger(String str, Leniency leniency) {
            int i;
            int i2 = 1;
            boolean z = false;
            boolean z2 = false;
            int iAddEthiopic = 0;
            int i3 = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char cCharAt = str.charAt(length);
                if (cCharAt < 4969 || cCharAt >= 4978) {
                    if (cCharAt >= 4978 && cCharAt < 4987) {
                        i = (cCharAt - 4977) * 10;
                    } else if (cCharAt == 4988) {
                        if (z && i3 == 0) {
                            i3 = 1;
                        }
                        iAddEthiopic = NumberSystem.addEthiopic(iAddEthiopic, i3, i2);
                        i2 = z ? i2 * 100 : i2 * ColorExtractionConstants.MAX_PIXEL_SAMPLES;
                        z2 = true;
                        z = false;
                        i3 = 0;
                    } else if (cCharAt == 4987) {
                        iAddEthiopic = NumberSystem.addEthiopic(iAddEthiopic, i3, i2);
                        i2 *= 100;
                        z = true;
                        z2 = false;
                        i3 = 0;
                    }
                } else {
                    i = cCharAt - 4968;
                }
                i3 += i;
            }
            return NumberSystem.addEthiopic(iAddEthiopic, ((z || z2) && i3 == 0) ? 1 : i3, i2);
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "፩፪፫፬፭፮፯፰፱፲፳፴፵፶፷፸፹፺፻፼";
        }
    },
    GUJARATI("gujr") { // from class: net.time4j.format.NumberSystem.8
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "૦૧૨૩૪૫૬૭૮૯";
        }
    },
    JAPANESE("jpan") { // from class: net.time4j.format.NumberSystem.9
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return false;
        }

        @Override // net.time4j.format.NumberSystem
        public String toNumeral(int i) {
            if (i < 1 || i > 9999) {
                throw new IllegalArgumentException("Cannot convert: " + i);
            }
            String digits = getDigits();
            int i2 = i / 1000;
            int i3 = i % 1000;
            int i4 = i3 / 100;
            int i5 = i3 % 100;
            int i6 = i5 / 10;
            int i7 = i5 % 10;
            StringBuilder sb = new StringBuilder();
            if (i2 >= 1) {
                if (i2 > 1) {
                    sb.append(digits.charAt(i2 - 1));
                }
                sb.append((char) 21315);
            }
            if (i4 >= 1) {
                if (i4 > 1) {
                    sb.append(digits.charAt(i4 - 1));
                }
                sb.append((char) 30334);
            }
            if (i6 >= 1) {
                if (i6 > 1) {
                    sb.append(digits.charAt(i6 - 1));
                }
                sb.append((char) 21313);
            }
            if (i7 > 0) {
                sb.append(digits.charAt(i7 - 1));
            }
            return sb.toString();
        }

        @Override // net.time4j.format.NumberSystem
        public int toInteger(String str, Leniency leniency) {
            boolean z;
            String digits = getDigits();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char cCharAt = str.charAt(length);
                if (cCharAt == 21313) {
                    if (i != 0 || i3 != 0 || i4 != 0) {
                        throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                    }
                    i++;
                } else if (cCharAt == 21315) {
                    if (i4 != 0) {
                        throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                    }
                    i4++;
                } else if (cCharAt != 30334) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= 9) {
                            z = false;
                            break;
                        }
                        if (digits.charAt(i5) == cCharAt) {
                            int i6 = i5 + 1;
                            if (i4 == 1) {
                                i2 += i6 * 1000;
                                i4 = -1;
                            } else if (i3 == 1) {
                                i2 += i6 * 100;
                                i3 = -1;
                            } else if (i == 1) {
                                i2 += i6 * 10;
                                i = -1;
                            } else {
                                i2 += i6;
                            }
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                    }
                } else {
                    if (i3 != 0 || i4 != 0) {
                        throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                    }
                    i3++;
                }
            }
            if (i == 1) {
                i2 += 10;
            }
            if (i3 == 1) {
                i2 += 100;
            }
            return i4 == 1 ? i2 + 1000 : i2;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "一二三四五六七八九十百千";
        }
    },
    KHMER("khmr") { // from class: net.time4j.format.NumberSystem.10
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "០១២៣៤៥៦៧៨៩";
        }
    },
    MYANMAR("mymr") { // from class: net.time4j.format.NumberSystem.11
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "၀၁၂၃၄၅၆၇၈၉";
        }
    },
    ORYA("orya") { // from class: net.time4j.format.NumberSystem.12
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "୦୧୨୩୪୫୬୭୮୯";
        }
    },
    ROMAN("roman") { // from class: net.time4j.format.NumberSystem.13
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return false;
        }

        @Override // net.time4j.format.NumberSystem
        public String toNumeral(int i) {
            if (i < 1 || i > 3999) {
                throw new IllegalArgumentException("Out of range (1-3999): " + i);
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < NumberSystem.NUMBERS.length; i2++) {
                while (i >= NumberSystem.NUMBERS[i2]) {
                    sb.append(NumberSystem.LETTERS[i2]);
                    i -= NumberSystem.NUMBERS[i2];
                }
            }
            return sb.toString();
        }

        @Override // net.time4j.format.NumberSystem
        public int toInteger(String str, Leniency leniency) {
            if (str.isEmpty()) {
                throw new NumberFormatException("Empty Roman numeral.");
            }
            String upperCase = str.toUpperCase(Locale.US);
            boolean zIsStrict = leniency.isStrict();
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char cCharAt = upperCase.charAt(i);
                int value = NumberSystem.getValue(cCharAt);
                i++;
                if (i != length) {
                    int i3 = 1;
                    while (i < length) {
                        char cCharAt2 = upperCase.charAt(i);
                        int i4 = i + 1;
                        if (cCharAt2 == cCharAt) {
                            i3++;
                            if (i3 >= 4 && zIsStrict) {
                                throw new NumberFormatException("Roman numeral contains more than 3 equal letters in sequence: " + str);
                            }
                            if (i4 == length) {
                                i2 += value * i3;
                            }
                            i = i4;
                        } else {
                            int value2 = NumberSystem.getValue(cCharAt2);
                            if (value2 >= value) {
                                if (!zIsStrict || (i3 <= 1 && NumberSystem.isValidRomanCombination(cCharAt, cCharAt2))) {
                                    i2 = (i2 + value2) - (value * i3);
                                    i = i4;
                                    break;
                                }
                                throw new NumberFormatException("Not conform with modern usage: " + str);
                            }
                            value *= i3;
                        }
                    }
                }
                i2 += value;
            }
            if (i2 > 3999) {
                throw new NumberFormatException("Roman numbers bigger than 3999 not supported.");
            }
            if (zIsStrict) {
                if (i2 >= 900 && upperCase.contains("DCD")) {
                    throw new NumberFormatException("Roman number contains invalid sequence DCD.");
                }
                if (i2 >= 90 && upperCase.contains("LXL")) {
                    throw new NumberFormatException("Roman number contains invalid sequence LXL.");
                }
                if (i2 >= 9 && upperCase.contains("VIV")) {
                    throw new NumberFormatException("Roman number contains invalid sequence VIV.");
                }
            }
            return i2;
        }

        @Override // net.time4j.format.NumberSystem
        public boolean contains(char c) {
            char upperCase = Character.toUpperCase(c);
            return upperCase == 'I' || upperCase == 'V' || upperCase == 'X' || upperCase == 'L' || upperCase == 'C' || upperCase == 'D' || upperCase == 'M';
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "IVXLCDM";
        }
    },
    TELUGU("telu") { // from class: net.time4j.format.NumberSystem.14
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "౦౧౨౩౪౫౬౭౮౯";
        }
    },
    THAI("thai") { // from class: net.time4j.format.NumberSystem.15
        @Override // net.time4j.format.NumberSystem
        public boolean isDecimal() {
            return true;
        }

        @Override // net.time4j.format.NumberSystem
        public String getDigits() {
            return "๐๑๒๓๔๕๖๗๘๙";
        }
    };

    private final String code;
    private static final int[] NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] D_FACTORS = {1, 12, 144, 1728, 20736};

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidRomanCombination(char c, char c2) {
        if (c == 'C') {
            return c2 == 'M' || c2 == 'D';
        }
        if (c == 'I') {
            return c2 == 'X' || c2 == 'V';
        }
        if (c != 'X') {
            return false;
        }
        return c2 == 'C' || c2 == 'L';
    }

    public abstract String getDigits();

    public abstract boolean isDecimal();

    NumberSystem(String str) {
        this.code = str;
    }

    public String toNumeral(int i) {
        if (isDecimal() && i >= 0) {
            int iCharAt = getDigits().charAt(0) - '0';
            String string = Integer.toString(i);
            StringBuilder sb = new StringBuilder();
            int length = string.length();
            for (int i2 = 0; i2 < length; i2++) {
                sb.append((char) (string.charAt(i2) + iCharAt));
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Cannot convert: " + i);
    }

    public int toNumeral(int i, Appendable appendable) throws IOException {
        String numeral = toNumeral(i);
        appendable.append(numeral);
        return numeral.length();
    }

    public int toInteger(String str, Leniency leniency) {
        if (isDecimal()) {
            int iCharAt = getDigits().charAt(0) - '0';
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                sb.append((char) (str.charAt(i) - iCharAt));
            }
            int i2 = Integer.parseInt(sb.toString());
            if (i2 >= 0) {
                return i2;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }
        throw new NumberFormatException("Cannot convert: " + str);
    }

    public boolean contains(char c) {
        String digits = getDigits();
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            if (digits.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public String getCode() {
        return this.code;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int addEthiopic(int i, int i2, int i3) {
        return MathUtils.safeAdd(i, MathUtils.safeMultiply(i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getValue(char c) {
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'M') {
            return 1000;
        }
        throw new NumberFormatException("Invalid Roman digit: " + c);
    }
}
