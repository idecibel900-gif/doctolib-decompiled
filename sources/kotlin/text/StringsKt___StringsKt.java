package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static char first(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static Character getOrNull(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i < 0 || i >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static char last(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
    }

    public static char random(CharSequence charSequence, Random random) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(random.nextInt(charSequence.length()));
    }

    public static char single(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String drop(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        String strSubstring = str.substring(RangesKt.coerceAtMost(i, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String dropLast(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        return take(str, RangesKt.coerceAtLeast(str.length() - i, 0));
    }

    public static String take(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, RangesKt.coerceAtMost(i, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String takeLast(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        int length = str.length();
        String strSubstring = str.substring(length - RangesKt.coerceAtMost(i, length));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
