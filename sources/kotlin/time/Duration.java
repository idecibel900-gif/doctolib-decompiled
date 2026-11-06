package kotlin.time;

import com.amazon.a.a.o.c.a.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
public final class Duration implements Comparable {
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m5401constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(4611686018427387903L);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m5399boximpl(long j) {
        return new Duration(j);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5402equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m5431unboximpl();
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m5415getValueimpl(long j) {
        return j >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5416hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m5418isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m5419isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m5421isNegativeimpl(long j) {
        return j < 0;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m5422isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(Object obj) {
        return m5402equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m5416hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5431unboximpl() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m5430compareToLRDsOJo(((Duration) obj).m5431unboximpl());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m5414getStorageUnitimpl(long j) {
        return m5419isInNanosimpl(j) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5401constructorimpl(long j) {
        if (!DurationJvmKt.getDurationAssertionsEnabled()) {
            return j;
        }
        if (m5419isInNanosimpl(j)) {
            long jM5415getValueimpl = m5415getValueimpl(j);
            if (-4611686018426999999L <= jM5415getValueimpl && jM5415getValueimpl < 4611686018427000000L) {
                return j;
            }
            throw new AssertionError(m5415getValueimpl(j) + " ns is out of nanoseconds range");
        }
        long jM5415getValueimpl2 = m5415getValueimpl(j);
        if (-4611686018427387903L > jM5415getValueimpl2 || jM5415getValueimpl2 >= 4611686018427387904L) {
            throw new AssertionError(m5415getValueimpl(j) + " ms is out of milliseconds range");
        }
        long jM5415getValueimpl3 = m5415getValueimpl(j);
        if (-4611686018426L > jM5415getValueimpl3 || jM5415getValueimpl3 >= 4611686018427L) {
            return j;
        }
        throw new AssertionError(m5415getValueimpl(j) + " ms is denormalized");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m5433getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m5432getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m5434parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m5429unaryMinusUwyO8pc(long j) {
        return DurationKt.durationOf(-m5415getValueimpl(j), ((int) j) & 1);
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m5423plusLRDsOJo(long j, long j2) {
        if (m5420isInfiniteimpl(j)) {
            if (m5417isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m5420isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long jM5415getValueimpl = m5415getValueimpl(j) + m5415getValueimpl(j2);
            return m5419isInNanosimpl(j) ? DurationKt.durationOfNanosNormalized(jM5415getValueimpl) : DurationKt.durationOfMillisNormalized(jM5415getValueimpl);
        }
        if (m5418isInMillisimpl(j)) {
            return m5397addValuesMixedRangesUwyO8pc(j, m5415getValueimpl(j), m5415getValueimpl(j2));
        }
        return m5397addValuesMixedRangesUwyO8pc(j, m5415getValueimpl(j2), m5415getValueimpl(j));
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m5397addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(j4) + (j3 - DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m5424timesUwyO8pc(long j, int i) {
        if (m5420isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m5429unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return ZERO;
        }
        long jM5415getValueimpl = m5415getValueimpl(j);
        long j2 = i;
        long j3 = jM5415getValueimpl * j2;
        if (!m5419isInNanosimpl(j)) {
            if (j3 / j2 == jM5415getValueimpl) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(j3, new LongRange(-4611686018427387903L, 4611686018427387903L)));
            }
            return MathKt.getSign(jM5415getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM5415getValueimpl && jM5415getValueimpl < 2147483648L) {
            return DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM5415getValueimpl) {
            return DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = DurationKt.nanosToMillis(jM5415getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = DurationKt.nanosToMillis((jM5415getValueimpl - DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        if (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) {
            return MathKt.getSign(jM5415getValueimpl) * MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(jNanosToMillis2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m5420isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m5417isFiniteimpl(long j) {
        return !m5420isInfiniteimpl(j);
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m5403getAbsoluteValueUwyO8pc(long j) {
        return m5421isNegativeimpl(j) ? m5429unaryMinusUwyO8pc(j) : j;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m5430compareToLRDsOJo(long j) {
        return m5400compareToLRDsOJo(this.rawValue, j);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m5400compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m5421isNegativeimpl(j) ? -i : i;
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m5404getHoursComponentimpl(long j) {
        if (m5420isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m5406getInWholeHoursimpl(j) % ((long) 24));
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m5411getMinutesComponentimpl(long j) {
        if (m5420isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m5409getInWholeMinutesimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m5413getSecondsComponentimpl(long j) {
        if (m5420isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m5410getInWholeSecondsimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m5412getNanosecondsComponentimpl(long j) {
        long jM5415getValueimpl;
        if (m5420isInfiniteimpl(j)) {
            return 0;
        }
        if (m5418isInMillisimpl(j)) {
            jM5415getValueimpl = DurationKt.millisToNanos(m5415getValueimpl(j) % ((long) 1000));
        } else {
            jM5415getValueimpl = m5415getValueimpl(j) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        }
        return (int) jM5415getValueimpl;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m5425toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m5415getValueimpl(j), m5414getStorageUnitimpl(j), unit);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m5427toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m5415getValueimpl(j), m5414getStorageUnitimpl(j), unit);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m5405getInWholeDaysimpl(long j) {
        return m5427toLongimpl(j, DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m5406getInWholeHoursimpl(long j) {
        return m5427toLongimpl(j, DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m5409getInWholeMinutesimpl(long j) {
        return m5427toLongimpl(j, DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m5410getInWholeSecondsimpl(long j) {
        return m5427toLongimpl(j, DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m5408getInWholeMillisecondsimpl(long j) {
        return (m5418isInMillisimpl(j) && m5417isFiniteimpl(j)) ? m5415getValueimpl(j) : m5427toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m5407getInWholeMicrosecondsimpl(long j) {
        return m5427toLongimpl(j, DurationUnit.MICROSECONDS);
    }

    public String toString() {
        return m5428toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5428toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM5421isNegativeimpl = m5421isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (zM5421isNegativeimpl) {
            sb.append('-');
        }
        long jM5403getAbsoluteValueUwyO8pc = m5403getAbsoluteValueUwyO8pc(j);
        long jM5405getInWholeDaysimpl = m5405getInWholeDaysimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5404getHoursComponentimpl = m5404getHoursComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5411getMinutesComponentimpl = m5411getMinutesComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5413getSecondsComponentimpl = m5413getSecondsComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5412getNanosecondsComponentimpl = m5412getNanosecondsComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM5405getInWholeDaysimpl != 0;
        boolean z2 = iM5404getHoursComponentimpl != 0;
        boolean z3 = iM5411getMinutesComponentimpl != 0;
        boolean z4 = (iM5413getSecondsComponentimpl == 0 && iM5412getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM5405getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM5404getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM5411getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM5413getSecondsComponentimpl != 0 || z || z2 || z3) {
                m5398appendFractionalimpl(j, sb, iM5413getSecondsComponentimpl, iM5412getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM5412getNanosecondsComponentimpl >= 1000000) {
                m5398appendFractionalimpl(j, sb, iM5412getNanosecondsComponentimpl / 1000000, iM5412getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM5412getNanosecondsComponentimpl >= 1000) {
                m5398appendFractionalimpl(j, sb, iM5412getNanosecondsComponentimpl / 1000, iM5412getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM5412getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (zM5421isNegativeimpl && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m5398appendFractionalimpl(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append(b.a);
            String strPadStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) strPadStart, 0, i6);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m5426toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m5421isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM5403getAbsoluteValueUwyO8pc = m5403getAbsoluteValueUwyO8pc(j);
        long jM5406getInWholeHoursimpl = m5406getInWholeHoursimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5411getMinutesComponentimpl = m5411getMinutesComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5413getSecondsComponentimpl = m5413getSecondsComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        int iM5412getNanosecondsComponentimpl = m5412getNanosecondsComponentimpl(jM5403getAbsoluteValueUwyO8pc);
        long j2 = m5420isInfiniteimpl(j) ? 9999999999999L : jM5406getInWholeHoursimpl;
        boolean z = false;
        boolean z2 = j2 != 0;
        boolean z3 = (iM5413getSecondsComponentimpl == 0 && iM5412getNanosecondsComponentimpl == 0) ? false : true;
        if (iM5411getMinutesComponentimpl != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(j2);
            sb.append('H');
        }
        if (z) {
            sb.append(iM5411getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m5398appendFractionalimpl(j, sb, iM5413getSecondsComponentimpl, iM5412getNanosecondsComponentimpl, 9, "S", true);
        }
        return sb.toString();
    }
}
