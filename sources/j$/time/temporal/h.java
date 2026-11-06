package j$.time.temporal;

import com.facebook.imageutils.TiffUtil;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import j$.time.LocalDate;
import j$.time.format.D;
import j$.time.format.E;
import java.util.Map;

/* JADX WARN: Enum visitor error
java.lang.NullPointerException
	at jadx.core.dex.visitors.EnumVisitor.searchEnumSuperCtrInsn(EnumVisitor.java:495)
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:473)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;
    public static final int[] a;
    public static final /* synthetic */ h[] b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u J() {
                return u.g(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.f(a.DAY_OF_YEAR) || !temporalAccessor.f(a.MONTH_OF_YEAR) || !temporalAccessor.f(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.a;
                return j$.time.chrono.m.r(temporalAccessor).equals(j$.time.chrono.t.c);
            }

            @Override // j$.time.temporal.q
            public final u B(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long jG = temporalAccessor.g(h.QUARTER_OF_YEAR);
                if (jG == 1) {
                    return j$.time.chrono.t.c.Y(temporalAccessor.g(a.YEAR)) ? u.f(1L, 91L) : u.f(1L, 90L);
                }
                if (jG == 2) {
                    return u.f(1L, 91L);
                }
                if (jG == 3 || jG == 4) {
                    return u.f(1L, 92L);
                }
                return J();
            }

            @Override // j$.time.temporal.q
            public final long Q(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.e(a.DAY_OF_YEAR) - h.a[((temporalAccessor.e(a.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.t.c.Y(temporalAccessor.g(a.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m X(m mVar, long j) {
                long jQ = Q(mVar);
                J().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.i((j - jQ) + mVar.g(aVar), aVar);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor G(Map map, D d, E e) {
                long jSubtractExact;
                LocalDate localDateJ0;
                a aVar = a.YEAR;
                Long l = (Long) map.get(aVar);
                q qVar = h.QUARTER_OF_YEAR;
                Long l2 = (Long) map.get(qVar);
                if (l == null || l2 == null) {
                    return null;
                }
                int iA = aVar.b.a(l.longValue(), aVar);
                long jLongValue = ((Long) map.get(h.DAY_OF_QUARTER)).longValue();
                h hVar2 = j.a;
                if (!j$.time.chrono.m.r(d).equals(j$.time.chrono.t.c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                if (e == E.LENIENT) {
                    localDateJ0 = LocalDate.e0(iA, 1, 1).j0(Math.multiplyExact(Math.subtractExact(l2.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    LocalDate localDateE0 = LocalDate.e0(iA, ((qVar.J().a(l2.longValue(), qVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (e == E.STRICT) {
                            B(localDateE0).b(jLongValue, this);
                        } else {
                            J().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    localDateJ0 = localDateE0;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(qVar);
                return localDateJ0.i0(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u J() {
                return u.f(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.f(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.a;
                return j$.time.chrono.m.r(temporalAccessor).equals(j$.time.chrono.t.c);
            }

            @Override // j$.time.temporal.q
            public final long Q(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.g(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u B(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return J();
            }

            @Override // j$.time.temporal.q
            public final m X(m mVar, long j) {
                long jQ = Q(mVar);
                J().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.i(((j - jQ) * 3) + mVar.g(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u J() {
                return u.g(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.f(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.a;
                return j$.time.chrono.m.r(temporalAccessor).equals(j$.time.chrono.t.c);
            }

            @Override // j$.time.temporal.q
            public final u B(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.d0(LocalDate.G(temporalAccessor));
                }
                throw new t("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final long Q(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.a0(LocalDate.G(temporalAccessor));
            }

            @Override // j$.time.temporal.q
            public final m X(m mVar, long j) {
                J().b(j, this);
                return mVar.l(Math.subtractExact(j, Q(mVar)), b.WEEKS);
            }

            @Override // j$.time.temporal.q
            public final TemporalAccessor G(Map map, D d, E e) {
                LocalDate localDateI;
                long j;
                long j2;
                q qVar = h.WEEK_BASED_YEAR;
                Long l = (Long) map.get(qVar);
                a aVar = a.DAY_OF_WEEK;
                Long l2 = (Long) map.get(aVar);
                if (l == null || l2 == null) {
                    return null;
                }
                int iA = qVar.J().a(l.longValue(), qVar);
                long jLongValue = ((Long) map.get(h.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                h hVar4 = j.a;
                if (!j$.time.chrono.m.r(d).equals(j$.time.chrono.t.c)) {
                    throw new j$.time.c("Resolve requires IsoChronology");
                }
                LocalDate localDateE0 = LocalDate.e0(iA, 1, 4);
                if (e == E.LENIENT) {
                    long jLongValue2 = l2.longValue();
                    if (jLongValue2 > 7) {
                        long j3 = jLongValue2 - 1;
                        j = 1;
                        localDateE0 = localDateE0.k0(j3 / 7);
                        j2 = j3 % 7;
                    } else {
                        j = 1;
                        if (jLongValue2 < 1) {
                            localDateE0 = localDateE0.k0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j2 = (jLongValue2 + 6) % 7;
                        }
                        localDateI = localDateE0.k0(Math.subtractExact(jLongValue, j)).i(jLongValue2, aVar);
                    }
                    jLongValue2 = j2 + j;
                    localDateI = localDateE0.k0(Math.subtractExact(jLongValue, j)).i(jLongValue2, aVar);
                } else {
                    int iA2 = aVar.b.a(l2.longValue(), aVar);
                    if (jLongValue < 1 || jLongValue > 52) {
                        if (e == E.STRICT) {
                            h.d0(localDateE0).b(jLongValue, this);
                        } else {
                            J().b(jLongValue, this);
                        }
                    }
                    localDateI = localDateE0.k0(jLongValue - 1).i(iA2, aVar);
                }
                map.remove(this);
                map.remove(qVar);
                map.remove(aVar);
                return localDateI;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u J() {
                return a.YEAR.b;
            }

            @Override // j$.time.temporal.q
            public final boolean s(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.f(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.a;
                return j$.time.chrono.m.r(temporalAccessor).equals(j$.time.chrono.t.c);
            }

            @Override // j$.time.temporal.q
            public final long Q(TemporalAccessor temporalAccessor) {
                if (s(temporalAccessor)) {
                    return h.b0(LocalDate.G(temporalAccessor));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u B(TemporalAccessor temporalAccessor) {
                if (!s(temporalAccessor)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return J();
            }

            @Override // j$.time.temporal.q
            public final m X(m mVar, long j) {
                if (!s(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.b.a(j, h.WEEK_BASED_YEAR);
                LocalDate localDateG = LocalDate.G(mVar);
                a aVar = a.DAY_OF_WEEK;
                int iE = localDateG.e(aVar);
                int iA0 = h.a0(localDateG);
                if (iA0 == 53 && h.c0(iA) == 52) {
                    iA0 = 52;
                }
                LocalDate localDateE0 = LocalDate.e0(iA, 1, 4);
                return mVar.m(localDateE0.i0(((iA0 - 1) * 7) + (iE - localDateE0.e(aVar))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        b = new h[]{hVar, hVar2, hVar3, hVar4};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, TiffUtil.TIFF_TAG_ORIENTATION};
    }

    public static u d0(LocalDate localDate) {
        return u.f(1L, c0(b0(localDate)));
    }

    public static int c0(int i) {
        LocalDate localDateE0 = LocalDate.e0(i, 1, 1);
        if (localDateE0.Q() != j$.time.e.THURSDAY) {
            return (localDateE0.Q() == j$.time.e.WEDNESDAY && localDateE0.y()) ? 53 : 52;
        }
        return 53;
    }

    public static int a0(LocalDate localDate) {
        int iOrdinal = localDate.Q().ordinal();
        int iX = localDate.X() - 1;
        int i = (3 - iOrdinal) + iX;
        int i2 = i - ((i / 7) * 7);
        int i3 = i2 - 3;
        if (i3 < -3) {
            i3 = i2 + 4;
        }
        if (iX >= i3) {
            int i4 = ((iX - i3) / 7) + 1;
            if (i4 != 53 || i3 == -3 || (i3 == -2 && localDate.y())) {
                return i4;
            }
            return 1;
        }
        if (localDate.X() != 180) {
            localDate = LocalDate.g0(localDate.a, SensibleDefaults.X_OFFSET);
        }
        return (int) d0(localDate.l0(-1L)).d;
    }

    public static int b0(LocalDate localDate) {
        int i = localDate.a;
        int iX = localDate.X();
        if (iX <= 3) {
            return iX - localDate.Q().ordinal() < -2 ? i - 1 : i;
        }
        if (iX >= 363) {
            return ((iX - 363) - (localDate.y() ? 1 : 0)) - localDate.Q().ordinal() >= 0 ? i + 1 : i;
        }
        return i;
    }
}
