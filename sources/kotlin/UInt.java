package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class UInt implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final int data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m5274boximpl(int i) {
        return new UInt(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m5275constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5276equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m5279unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5277hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m5276equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5277hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5279unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.uintCompare(m5279unboximpl(), ((UInt) obj).m5279unboximpl());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5278toStringimpl(int i) {
        return String.valueOf(((long) i) & 4294967295L);
    }

    public String toString() {
        return m5278toStringimpl(this.data);
    }
}
