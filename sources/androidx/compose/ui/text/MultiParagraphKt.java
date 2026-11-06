package androidx.compose.ui.text;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiParagraphKt {
    public static final int findParagraphByY(List list, float f) {
        byte b;
        if (f <= 0.0f) {
            return 0;
        }
        if (f >= ((ParagraphInfo) CollectionsKt.last(list)).getBottom()) {
            return CollectionsKt.getLastIndex(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i2);
            if (paragraphInfo.getTop() > f) {
                b = 1;
            } else {
                b = paragraphInfo.getBottom() <= f ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i = i2 + 1;
            } else {
                if (b <= 0) {
                    return i2;
                }
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m2155findParagraphsByRangeSbBc2M(List list, long j, Function1 function1) {
        int size = list.size();
        for (int iFindParagraphByIndex = findParagraphByIndex(list, TextRange.m2215getMinimpl(j)); iFindParagraphByIndex < size; iFindParagraphByIndex++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(iFindParagraphByIndex);
            if (paragraphInfo.getStartIndex() >= TextRange.m2214getMaximpl(j)) {
                return;
            }
            if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                function1.invoke(paragraphInfo);
            }
        }
    }

    public static final int findParagraphByIndex(List list, int i) {
        byte b;
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i3);
            if (paragraphInfo.getStartIndex() > i) {
                b = 1;
            } else {
                b = paragraphInfo.getEndIndex() <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByLineIndex(List list, int i) {
        byte b;
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) list.get(i3);
            if (paragraphInfo.getStartLineIndex() > i) {
                b = 1;
            } else {
                b = paragraphInfo.getEndLineIndex() <= i ? (byte) -1 : (byte) 0;
            }
            if (b < 0) {
                i2 = i3 + 1;
            } else {
                if (b <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }
}
