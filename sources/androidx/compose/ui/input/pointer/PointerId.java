package androidx.compose.ui.input.pointer;

/* JADX INFO: loaded from: classes.dex */
public final class PointerId {
    private final long value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerId m1766boximpl(long j) {
        return new PointerId(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1767constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1768equalsimpl(long j, Object obj) {
        return (obj instanceof PointerId) && j == ((PointerId) obj).m1772unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1769equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1770hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1771toStringimpl(long j) {
        return "PointerId(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1768equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1770hashCodeimpl(this.value);
    }

    public String toString() {
        return m1771toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1772unboximpl() {
        return this.value;
    }

    private /* synthetic */ PointerId(long j) {
        this.value = j;
    }
}
