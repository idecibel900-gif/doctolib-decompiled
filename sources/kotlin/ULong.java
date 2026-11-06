package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class ULong implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final long data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m5296boximpl(long j) {
        return new ULong(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5297constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5298equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m5302unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5299equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5300hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m5298equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5300hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5302unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.ulongCompare(m5302unboximpl(), ((ULong) obj).m5302unboximpl());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5301toStringimpl(long j) {
        return UnsignedKt.ulongToString(j, 10);
    }

    public String toString() {
        return m5301toStringimpl(this.data);
    }
}
