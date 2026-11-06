package androidx.compose.foundation.lazy.grid;

/* JADX INFO: loaded from: classes.dex */
public final class GridItemSpan {
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ GridItemSpan m379boximpl(long j) {
        return new GridItemSpan(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m380constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m381equalsimpl(long j, Object obj) {
        return (obj instanceof GridItemSpan) && j == ((GridItemSpan) obj).m385unboximpl();
    }

    /* JADX INFO: renamed from: getCurrentLineSpan-impl, reason: not valid java name */
    public static final int m382getCurrentLineSpanimpl(long j) {
        return (int) j;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m383hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m384toStringimpl(long j) {
        return "GridItemSpan(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m381equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m383hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m384toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m385unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ GridItemSpan(long j) {
        this.packedValue = j;
    }
}
