package j$.time.chrono;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: j$.time.chrono.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1167a implements m {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return q().compareTo(((m) obj).q());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static m B(m mVar, String str) {
        String strU;
        m mVar2 = (m) a.putIfAbsent(str, mVar);
        if (mVar2 == null && (strU = mVar.u()) != null) {
            b.putIfAbsent(strU, mVar);
        }
        return mVar2;
    }

    @Override // j$.time.chrono.m
    public InterfaceC1168b T(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return p(((Long) map.remove(aVar)).longValue());
        }
        J(map, e);
        InterfaceC1168b interfaceC1168bX = X(map, e);
        if (interfaceC1168bX != null) {
            return interfaceC1168bX;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (!map.containsKey(aVar2)) {
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
        if (map.containsKey(aVar3)) {
            if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                return Q(map, e);
            }
            j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(aVar4)) {
                j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (map.containsKey(aVar5)) {
                    int iA = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (e == j$.time.format.E.LENIENT) {
                        long jSubtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                        return R(iA, 1, 1).l(jSubtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).l(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).l(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    }
                    int iA2 = z(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    InterfaceC1168b interfaceC1168bL = R(iA, iA2, 1).l((z(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((z(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
                    if (e != j$.time.format.E.STRICT || interfaceC1168bL.e(aVar3) == iA2) {
                        return interfaceC1168bL;
                    }
                    throw new j$.time.c("Strict mode rejected resolved date as it is in a different month");
                }
                j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                if (map.containsKey(aVar6)) {
                    int iA3 = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (e == j$.time.format.E.LENIENT) {
                        return G(R(iA3, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                    }
                    int iA4 = z(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    InterfaceC1168b interfaceC1168bM = R(iA3, iA4, 1).l((z(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(j$.time.e.s(z(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).getValue(), 0));
                    if (e != j$.time.format.E.STRICT || interfaceC1168bM.e(aVar3) == iA4) {
                        return interfaceC1168bM;
                    }
                    throw new j$.time.c("Strict mode rejected resolved date as it is in a different month");
                }
            }
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
        if (map.containsKey(aVar7)) {
            int iA5 = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (e != j$.time.format.E.LENIENT) {
                return v(iA5, z(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
            }
            return v(iA5, 1).l(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
        if (!map.containsKey(aVar8)) {
            return null;
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (map.containsKey(aVar9)) {
            int iA6 = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (e == j$.time.format.E.LENIENT) {
                return v(iA6, 1).l(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.WEEKS).l(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            }
            InterfaceC1168b interfaceC1168bL2 = v(iA6, 1).l((z(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((z(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
            if (e != j$.time.format.E.STRICT || interfaceC1168bL2.e(aVar2) == iA6) {
                return interfaceC1168bL2;
            }
            throw new j$.time.c("Strict mode rejected resolved date as it is in a different year");
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
        if (!map.containsKey(aVar10)) {
            return null;
        }
        int iA7 = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        if (e == j$.time.format.E.LENIENT) {
            return G(v(iA7, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
        }
        InterfaceC1168b interfaceC1168bM2 = v(iA7, 1).l((z(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (j$.time.temporal.s) j$.time.temporal.b.DAYS).m(new j$.time.temporal.o(j$.time.e.s(z(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).getValue(), 0));
        if (e != j$.time.format.E.STRICT || interfaceC1168bM2.e(aVar2) == iA7) {
            return interfaceC1168bM2;
        }
        throw new j$.time.c("Strict mode rejected resolved date as it is in a different year");
    }

    public void J(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e != j$.time.format.E.LENIENT) {
                aVar.a0(l.longValue());
            }
            InterfaceC1168b interfaceC1168bI = N().i(1L, (j$.time.temporal.q) j$.time.temporal.a.DAY_OF_MONTH).i(l.longValue(), (j$.time.temporal.q) aVar);
            j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
            s(map, aVar2, interfaceC1168bI.e(aVar2));
            j$.time.temporal.a aVar3 = j$.time.temporal.a.YEAR;
            s(map, aVar3, interfaceC1168bI.e(aVar3));
        }
    }

    public InterfaceC1168b X(Map map, j$.time.format.E e) {
        int intExact;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            j$.time.temporal.a aVar2 = j$.time.temporal.a.ERA;
            Long l2 = (Long) map.remove(aVar2);
            if (e != j$.time.format.E.LENIENT) {
                intExact = z(aVar).a(l.longValue(), aVar);
            } else {
                intExact = Math.toIntExact(l.longValue());
            }
            if (l2 != null) {
                s(map, j$.time.temporal.a.YEAR, D(C(z(aVar2).a(l2.longValue(), aVar2)), intExact));
                return null;
            }
            j$.time.temporal.a aVar3 = j$.time.temporal.a.YEAR;
            if (map.containsKey(aVar3)) {
                s(map, aVar3, D(v(z(aVar3).a(((Long) map.get(aVar3)).longValue(), aVar3), 1).O(), intExact));
                return null;
            }
            if (e == j$.time.format.E.STRICT) {
                map.put(aVar, l);
                return null;
            }
            List listA = A();
            if (listA.isEmpty()) {
                s(map, aVar3, intExact);
                return null;
            }
            s(map, aVar3, D((n) listA.get(listA.size() - 1), intExact));
            return null;
        }
        j$.time.temporal.a aVar4 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar4)) {
            return null;
        }
        z(aVar4).b(((Long) map.get(aVar4)).longValue(), aVar4);
        return null;
    }

    public InterfaceC1168b Q(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = z(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (e == j$.time.format.E.LENIENT) {
            long jSubtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return R(iA, 1, 1).l(jSubtractExact, (j$.time.temporal.s) j$.time.temporal.b.MONTHS).l(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (j$.time.temporal.s) j$.time.temporal.b.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = z(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = z(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (e != j$.time.format.E.SMART) {
            return R(iA, iA2, iA3);
        }
        try {
            return R(iA, iA2, iA3);
        } catch (j$.time.c unused) {
            return R(iA, iA2, 1).m(new j$.time.g(2));
        }
    }

    public static InterfaceC1168b G(InterfaceC1168b interfaceC1168b, long j, long j2, long j3) {
        long j4;
        InterfaceC1168b interfaceC1168bL = interfaceC1168b.l(j, (j$.time.temporal.s) j$.time.temporal.b.MONTHS);
        j$.time.temporal.b bVar = j$.time.temporal.b.WEEKS;
        InterfaceC1168b interfaceC1168bL2 = interfaceC1168bL.l(j2, (j$.time.temporal.s) bVar);
        if (j3 > 7) {
            long j5 = j3 - 1;
            interfaceC1168bL2 = interfaceC1168bL2.l(j5 / 7, (j$.time.temporal.s) bVar);
            j4 = j5 % 7;
        } else {
            if (j3 < 1) {
                interfaceC1168bL2 = interfaceC1168bL2.l(Math.subtractExact(j3, 7L) / 7, (j$.time.temporal.s) bVar);
                j4 = (j3 + 6) % 7;
            }
            return interfaceC1168bL2.m(new j$.time.temporal.o(j$.time.e.s((int) j3).getValue(), 0));
        }
        j3 = j4 + 1;
        return interfaceC1168bL2.m(new j$.time.temporal.o(j$.time.e.s((int) j3).getValue(), 0));
    }

    public static void s(Map map, j$.time.temporal.a aVar, long j) {
        Long l = (Long) map.get(aVar);
        if (l != null && l.longValue() != j) {
            throw new j$.time.c("Conflict found: " + aVar + " " + l + " differs from " + aVar + " " + j);
        }
        map.put(aVar, Long.valueOf(j));
    }

    @Override // j$.time.chrono.m
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC1167a) && q().compareTo(((AbstractC1167a) obj).q()) == 0;
    }

    @Override // j$.time.chrono.m
    public final int hashCode() {
        return getClass().hashCode() ^ q().hashCode();
    }

    @Override // j$.time.chrono.m
    public final String toString() {
        return q();
    }
}
