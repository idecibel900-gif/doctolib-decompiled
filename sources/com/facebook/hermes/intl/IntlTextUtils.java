package com.facebook.hermes.intl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IntlTextUtils {
    public static boolean isASCIIDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isASCIILetter(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean isASCIILetterOrDigit(char c) {
        return isASCIILetter(c) || isASCIIDigit(c);
    }

    public static boolean isAlphaNum(CharSequence charSequence, int i, int i2, int i3, int i4) {
        int i5;
        if (i2 >= charSequence.length() || (i5 = (i2 - i) + 1) < i3 || i5 > i4) {
            return false;
        }
        while (i <= i2) {
            if (!isASCIILetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isUnicodeExtensionKeyTypeItem(CharSequence charSequence, int i, int i2) {
        return isAlphaNum(charSequence, i, i2, 3, 8);
    }
}
