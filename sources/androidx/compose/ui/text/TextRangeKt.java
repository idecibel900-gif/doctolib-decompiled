package androidx.compose.ui.text;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextRangeKt {
    /* JADX INFO: renamed from: substring-FDrldGo, reason: not valid java name */
    public static final String m2224substringFDrldGo(CharSequence charSequence, long j) {
        return charSequence.subSequence(TextRange.m2215getMinimpl(j), TextRange.m2214getMaximpl(j)).toString();
    }

    public static final long TextRange(int i, int i2) {
        return TextRange.m2206constructorimpl(packWithCheck(i, i2));
    }

    public static final long TextRange(int i) {
        return TextRange(i, i);
    }

    /* JADX INFO: renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m2223coerceIn8ffj60Q(long j, int i, int i2) {
        int iCoerceIn = RangesKt.coerceIn(TextRange.m2217getStartimpl(j), i, i2);
        int iCoerceIn2 = RangesKt.coerceIn(TextRange.m2212getEndimpl(j), i, i2);
        return (iCoerceIn == TextRange.m2217getStartimpl(j) && iCoerceIn2 == TextRange.m2212getEndimpl(j)) ? j : TextRange(iCoerceIn, iCoerceIn2);
    }

    private static final long packWithCheck(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(("start cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
        }
        if (i2 >= 0) {
            return (((long) i2) & 4294967295L) | (((long) i) << 32);
        }
        throw new IllegalArgumentException(("end cannot be negative. [start: " + i + ", end: " + i2 + ']').toString());
    }
}
