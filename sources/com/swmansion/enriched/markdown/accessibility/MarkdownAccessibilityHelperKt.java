package com.swmansion.enriched.markdown.accessibility;

import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarkdownAccessibilityHelperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int findFirstNonWhitespace(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (!CharsKt.isWhitespace(str.charAt(i3))) {
                return i3;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findLastNonWhitespace(String str, int i, int i2) {
        int i3 = i2 - 1;
        if (i <= i3) {
            while (CharsKt.isWhitespace(str.charAt(i3))) {
                if (i3 != i) {
                    i3--;
                }
            }
            return i3 + 1;
        }
        return i2;
    }
}
