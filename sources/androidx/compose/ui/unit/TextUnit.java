package androidx.compose.ui.unit;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextUnit {
    public static final Companion Companion = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m2616boximpl(long j) {
        return new TextUnit(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2617constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2618equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m2625unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2619equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m2620getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2623hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2618equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2623hashCodeimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2625unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m2622getValueimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m2624toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2624toStringimpl(long j) {
        long jM2621getTypeUIouoOA = m2621getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2641getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2640getSpUIouoOA())) {
            return m2622getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2639getEmUIouoOA())) {
            return "Invalid";
        }
        return m2622getValueimpl(j) + ".em";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m2626getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m2632boximpl(companion.m2641getUnspecifiedUIouoOA()), TextUnitType.m2632boximpl(companion.m2640getSpUIouoOA()), TextUnitType.m2632boximpl(companion.m2639getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m2621getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m2620getRawTypeimpl(j) >>> 32)].m2638unboximpl();
    }
}
