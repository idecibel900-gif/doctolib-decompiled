package com.swmansion.enriched.markdown.input.detection;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class WordsUtils {
    public static final WordsUtils INSTANCE = new WordsUtils();

    private WordsUtils() {
    }

    public final int tokenStart(String text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        while (i > 0 && !CharsKt.isWhitespace(text.charAt(i - 1))) {
            i--;
        }
        return i;
    }

    public final List getAffectedWords(String text, int i, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        int iCoerceIn = RangesKt.coerceIn(i, 0, length);
        if (iCoerceIn > 0) {
            do {
                iCoerceIn--;
                if (iCoerceIn <= 0) {
                    break;
                }
            } while (!CharsKt.isWhitespace(text.charAt(iCoerceIn)));
            if (CharsKt.isWhitespace(text.charAt(iCoerceIn))) {
                iCoerceIn++;
            }
        }
        int iCoerceIn2 = RangesKt.coerceIn(i + i2, 0, length);
        if (iCoerceIn2 < length) {
            while (iCoerceIn2 < length && !CharsKt.isWhitespace(text.charAt(iCoerceIn2))) {
                iCoerceIn2++;
            }
        }
        if (iCoerceIn >= iCoerceIn2) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i3 = iCoerceIn;
        while (iCoerceIn < iCoerceIn2) {
            if (CharsKt.isWhitespace(text.charAt(iCoerceIn))) {
                if (iCoerceIn > i3) {
                    String strSubstring = text.substring(i3, iCoerceIn);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    arrayList.add(new WordResult(strSubstring, i3, iCoerceIn));
                }
                i3 = iCoerceIn + 1;
            }
            iCoerceIn++;
        }
        if (i3 < iCoerceIn2) {
            String strSubstring2 = text.substring(i3, iCoerceIn2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            arrayList.add(new WordResult(strSubstring2, i3, iCoerceIn2));
        }
        return arrayList;
    }
}
