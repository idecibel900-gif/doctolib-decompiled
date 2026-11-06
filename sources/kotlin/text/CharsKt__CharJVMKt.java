package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class CharsKt__CharJVMKt {
    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static final String uppercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static String titlecase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strUppercase = uppercase(c, locale);
        if (strUppercase.length() <= 1) {
            String strValueOf = String.valueOf(c);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(strUppercase, upperCase)) {
                return String.valueOf(Character.toTitleCase(c));
            }
        } else if (c != 329) {
            char cCharAt = strUppercase.charAt(0);
            Intrinsics.checkNotNull(strUppercase, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strUppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Intrinsics.checkNotNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return cCharAt + lowerCase;
        }
        return strUppercase;
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static int checkRadix(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new IntRange(2, 36));
    }
}
