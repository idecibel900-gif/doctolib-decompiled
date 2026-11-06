package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UShort implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final short data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m5319boximpl(short s) {
        return new UShort(s);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m5320constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5321equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m5324unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5322hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    public boolean equals(Object obj) {
        return m5321equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5322hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m5324unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(m5324unboximpl() & 65535, ((UShort) obj).m5324unboximpl() & 65535);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5323toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }

    public String toString() {
        return m5323toStringimpl(this.data);
    }
}
