package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextRange {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextRange m2205boximpl(long j) {
        return new TextRange(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2206constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2209equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m2221unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2210equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getEnd-impl, reason: not valid java name */
    public static final int m2212getEndimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: getStart-impl, reason: not valid java name */
    public static final int m2217getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2218hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2209equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2218hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2221unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: getMin-impl, reason: not valid java name */
    public static final int m2215getMinimpl(long j) {
        return m2217getStartimpl(j) > m2212getEndimpl(j) ? m2212getEndimpl(j) : m2217getStartimpl(j);
    }

    /* JADX INFO: renamed from: getMax-impl, reason: not valid java name */
    public static final int m2214getMaximpl(long j) {
        return m2217getStartimpl(j) > m2212getEndimpl(j) ? m2217getStartimpl(j) : m2212getEndimpl(j);
    }

    /* JADX INFO: renamed from: getCollapsed-impl, reason: not valid java name */
    public static final boolean m2211getCollapsedimpl(long j) {
        return m2217getStartimpl(j) == m2212getEndimpl(j);
    }

    /* JADX INFO: renamed from: getReversed-impl, reason: not valid java name */
    public static final boolean m2216getReversedimpl(long j) {
        return m2217getStartimpl(j) > m2212getEndimpl(j);
    }

    /* JADX INFO: renamed from: getLength-impl, reason: not valid java name */
    public static final int m2213getLengthimpl(long j) {
        return m2214getMaximpl(j) - m2215getMinimpl(j);
    }

    /* JADX INFO: renamed from: intersects-5zc-tL8, reason: not valid java name */
    public static final boolean m2219intersects5zctL8(long j, long j2) {
        return m2215getMinimpl(j) < m2214getMaximpl(j2) && m2215getMinimpl(j2) < m2214getMaximpl(j);
    }

    /* JADX INFO: renamed from: contains-5zc-tL8, reason: not valid java name */
    public static final boolean m2207contains5zctL8(long j, long j2) {
        return m2215getMinimpl(j) <= m2215getMinimpl(j2) && m2214getMaximpl(j2) <= m2214getMaximpl(j);
    }

    /* JADX INFO: renamed from: contains-impl, reason: not valid java name */
    public static final boolean m2208containsimpl(long j, int i) {
        return i < m2214getMaximpl(j) && m2215getMinimpl(j) <= i;
    }

    public String toString() {
        return m2220toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2220toStringimpl(long j) {
        return "TextRange(" + m2217getStartimpl(j) + ", " + m2212getEndimpl(j) + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZero-d9O1mEE, reason: not valid java name */
        public final long m2222getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }
}
