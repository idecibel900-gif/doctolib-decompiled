package com.facebook.react.views.text;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TextTransformKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextTransform.values().length];
            try {
                iArr[TextTransform.UPPERCASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextTransform.LOWERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextTransform.CAPITALIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String applyTextTransform(String str, TextTransform textTransform) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i = textTransform == null ? -1 : WhenMappings.$EnumSwitchMapping$0[textTransform.ordinal()];
        if (i == 1) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (i == 2) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (i != 3) {
            return str;
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb = new StringBuilder(str.length());
        int iFirst = wordInstance.first();
        int next = wordInstance.next();
        while (true) {
            int i2 = next;
            int i3 = iFirst;
            iFirst = i2;
            if (iFirst != -1) {
                String strSubstring = str.substring(i3, iFirst);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                if (strSubstring.length() > 0) {
                    char upperCase2 = Character.toUpperCase(strSubstring.charAt(0));
                    String strSubstring2 = strSubstring.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    strSubstring = upperCase2 + strSubstring2;
                }
                sb.append(strSubstring);
                next = wordInstance.next();
            } else {
                String string = sb.toString();
                Intrinsics.checkNotNull(string);
                return string;
            }
        }
    }
}
