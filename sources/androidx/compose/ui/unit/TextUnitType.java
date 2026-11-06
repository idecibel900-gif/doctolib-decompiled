package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextUnitType {
    private final long type;
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m2633constructorimpl(0);
    private static final long Sp = m2633constructorimpl(4294967296L);
    private static final long Em = m2633constructorimpl(8589934592L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m2632boximpl(long j) {
        return new TextUnitType(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2633constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2634equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).m2638unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2635equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2636hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2634equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m2636hashCodeimpl(this.type);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2638unboximpl() {
        return this.type;
    }

    private /* synthetic */ TextUnitType(long j) {
        this.type = j;
    }

    public String toString() {
        return m2637toStringimpl(this.type);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2637toStringimpl(long j) {
        if (m2635equalsimpl0(j, Unspecified)) {
            return "Unspecified";
        }
        if (m2635equalsimpl0(j, Sp)) {
            return "Sp";
        }
        return m2635equalsimpl0(j, Em) ? "Em" : "Invalid";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m2641getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }

        /* JADX INFO: renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m2640getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* JADX INFO: renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m2639getEmUIouoOA() {
            return TextUnitType.Em;
        }
    }
}
