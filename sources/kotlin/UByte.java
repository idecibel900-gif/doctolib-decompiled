package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UByte implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final byte data;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m5252boximpl(byte b) {
        return new UByte(b);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m5253constructorimpl(byte b) {
        return b;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5254equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m5257unboximpl();
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5255hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    public boolean equals(Object obj) {
        return m5254equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5255hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m5257unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(m5257unboximpl() & 255, ((UByte) obj).m5257unboximpl() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5256toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m5256toStringimpl(this.data);
    }
}
