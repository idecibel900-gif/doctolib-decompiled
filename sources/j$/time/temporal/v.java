package j$.time.temporal;

import j$.time.chrono.InterfaceC1168b;
import j$.time.format.D;
import j$.time.format.E;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements q {
    public static final u f = u.f(1, 7);
    public static final u g = u.g(0, 4, 6);
    public static final u h = u.g(0, 52, 54);
    public static final u i = u.g(1, 52, 53);
    public final String a;
    public final w b;
    public final s c;
    public final s d;
    public final u e;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public final InterfaceC1168b e(j$.time.chrono.m mVar, int i2, int i3, int i4) {
        InterfaceC1168b interfaceC1168bR = mVar.R(i2, 1, 1);
        int iH = h(1, b(interfaceC1168bR));
        return interfaceC1168bR.l(((Math.min(i3, a(iH, interfaceC1168bR.V() + this.b.b) - 1) - 1) * 7) + (i4 - 1) + (-iH), (s) b.DAYS);
    }

    public v(String str, w wVar, s sVar, s sVar2, u uVar) {
        this.a = str;
        this.b = wVar;
        this.c = sVar;
        this.d = sVar2;
        this.e = uVar;
    }

    @Override // j$.time.temporal.q
    public final long Q(TemporalAccessor temporalAccessor) {
        int iC;
        b bVar = b.WEEKS;
        s sVar = this.d;
        if (sVar == bVar) {
            iC = b(temporalAccessor);
        } else if (sVar != b.MONTHS) {
            if (sVar != b.YEARS) {
                if (sVar == w.h) {
                    iC = d(temporalAccessor);
                } else if (sVar == b.FOREVER) {
                    iC = c(temporalAccessor);
                } else {
                    throw new IllegalStateException("unreachable, rangeUnit: " + sVar + ", this: " + this);
                }
            } else {
                int iB = b(temporalAccessor);
                int iE = temporalAccessor.e(a.DAY_OF_YEAR);
                iC = a(h(iE, iB), iE);
            }
        } else {
            int iB2 = b(temporalAccessor);
            int iE2 = temporalAccessor.e(a.DAY_OF_MONTH);
            iC = a(h(iE2, iB2), iE2);
        }
        return iC;
    }

    public final int b(TemporalAccessor temporalAccessor) {
        return Math.floorMod(temporalAccessor.e(a.DAY_OF_WEEK) - this.b.a.getValue(), 7) + 1;
    }

    public final int c(TemporalAccessor temporalAccessor) {
        int iB = b(temporalAccessor);
        int iE = temporalAccessor.e(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int iE2 = temporalAccessor.e(aVar);
        int iH = h(iE2, iB);
        int iA = a(iH, iE2);
        if (iA == 0) {
            return iE - 1;
        }
        return iA >= a(iH, ((int) temporalAccessor.k(aVar).d) + this.b.b) ? iE + 1 : iE;
    }

    public final int d(TemporalAccessor temporalAccessor) {
        int iA;
        int iB = b(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int iE = temporalAccessor.e(aVar);
        int iH = h(iE, iB);
        int iA2 = a(iH, iE);
        if (iA2 == 0) {
            return d(j$.time.chrono.m.r(temporalAccessor).H(temporalAccessor).a(iE, (s) b.DAYS));
        }
        return (iA2 <= 50 || iA2 < (iA = a(iH, ((int) temporalAccessor.k(aVar).d) + this.b.b))) ? iA2 : (iA2 - iA) + 1;
    }

    public final int h(int i2, int i3) {
        int iFloorMod = Math.floorMod(i2 - i3, 7);
        return iFloorMod + 1 > this.b.b ? 7 - iFloorMod : -iFloorMod;
    }

    public static int a(int i2, int i3) {
        return ((i3 - 1) + (i2 + 7)) / 7;
    }

    @Override // j$.time.temporal.q
    public final m X(m mVar, long j) {
        int iA = this.e.a(j, this);
        int iE = mVar.e(this);
        if (iA == iE) {
            return mVar;
        }
        if (this.d != b.FOREVER) {
            return mVar.l(iA - iE, this.c);
        }
        w wVar = this.b;
        return e(j$.time.chrono.m.r(mVar), (int) j, mVar.e(wVar.e), mVar.e(wVar.c));
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor G(Map map, D d, E e) {
        InterfaceC1168b interfaceC1168bL;
        InterfaceC1168b interfaceC1168bL2;
        InterfaceC1168b interfaceC1168bL3;
        long jLongValue = ((Long) map.get(this)).longValue();
        int intExact = Math.toIntExact(jLongValue);
        b bVar = b.WEEKS;
        u uVar = this.e;
        w wVar = this.b;
        s sVar = this.d;
        if (sVar == bVar) {
            long jFloorMod = Math.floorMod((uVar.a(jLongValue, this) - 1) + (wVar.a.getValue() - 1), 7) + 1;
            map.remove(this);
            map.put(a.DAY_OF_WEEK, Long.valueOf(jFloorMod));
            return null;
        }
        a aVar = a.DAY_OF_WEEK;
        if (!map.containsKey(aVar)) {
            return null;
        }
        int iFloorMod = Math.floorMod(aVar.b.a(((Long) map.get(aVar)).longValue(), aVar) - wVar.a.getValue(), 7) + 1;
        j$.time.chrono.m mVarR = j$.time.chrono.m.r(d);
        a aVar2 = a.YEAR;
        if (!map.containsKey(aVar2)) {
            if ((sVar != w.h && sVar != b.FOREVER) || !map.containsKey(wVar.f) || !map.containsKey(wVar.e)) {
                return null;
            }
            v vVar = wVar.f;
            int iA = vVar.e.a(((Long) map.get(vVar)).longValue(), wVar.f);
            if (e == E.LENIENT) {
                interfaceC1168bL = e(mVarR, iA, 1, iFloorMod).l(Math.subtractExact(((Long) map.get(wVar.e)).longValue(), 1L), (s) bVar);
            } else {
                v vVar2 = wVar.e;
                InterfaceC1168b interfaceC1168bE = e(mVarR, iA, vVar2.e.a(((Long) map.get(vVar2)).longValue(), wVar.e), iFloorMod);
                if (e == E.STRICT && c(interfaceC1168bE) != iA) {
                    throw new j$.time.c("Strict mode rejected resolved date as it is in a different week-based-year");
                }
                interfaceC1168bL = interfaceC1168bE;
            }
            map.remove(this);
            map.remove(wVar.f);
            map.remove(wVar.e);
            map.remove(aVar);
            return interfaceC1168bL;
        }
        int iA2 = aVar2.b.a(((Long) map.get(aVar2)).longValue(), aVar2);
        b bVar2 = b.MONTHS;
        if (sVar == bVar2) {
            a aVar3 = a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                long jLongValue2 = ((Long) map.get(aVar3)).longValue();
                long j = intExact;
                if (e == E.LENIENT) {
                    InterfaceC1168b interfaceC1168bL4 = mVarR.R(iA2, 1, 1).l(Math.subtractExact(jLongValue2, 1L), (s) bVar2);
                    int iB = b(interfaceC1168bL4);
                    int iE = interfaceC1168bL4.e(a.DAY_OF_MONTH);
                    interfaceC1168bL3 = interfaceC1168bL4.l(Math.addExact(Math.multiplyExact(Math.subtractExact(j, a(h(iE, iB), iE)), 7), iFloorMod - b(interfaceC1168bL4)), (s) b.DAYS);
                } else {
                    InterfaceC1168b interfaceC1168bR = mVarR.R(iA2, aVar3.b.a(jLongValue2, aVar3), 1);
                    long jA = uVar.a(j, this);
                    int iB2 = b(interfaceC1168bR);
                    int iE2 = interfaceC1168bR.e(a.DAY_OF_MONTH);
                    InterfaceC1168b interfaceC1168bL5 = interfaceC1168bR.l((((int) (jA - ((long) a(h(iE2, iB2), iE2)))) * 7) + (iFloorMod - b(interfaceC1168bR)), (s) b.DAYS);
                    if (e == E.STRICT && interfaceC1168bL5.g(aVar3) != jLongValue2) {
                        throw new j$.time.c("Strict mode rejected resolved date as it is in a different month");
                    }
                    interfaceC1168bL3 = interfaceC1168bL5;
                }
                map.remove(this);
                map.remove(aVar2);
                map.remove(aVar3);
                map.remove(aVar);
                return interfaceC1168bL3;
            }
        }
        if (sVar != b.YEARS) {
            return null;
        }
        long j2 = intExact;
        InterfaceC1168b interfaceC1168bR2 = mVarR.R(iA2, 1, 1);
        if (e == E.LENIENT) {
            int iB3 = b(interfaceC1168bR2);
            int iE3 = interfaceC1168bR2.e(a.DAY_OF_YEAR);
            interfaceC1168bL2 = interfaceC1168bR2.l(Math.addExact(Math.multiplyExact(Math.subtractExact(j2, a(h(iE3, iB3), iE3)), 7), iFloorMod - b(interfaceC1168bR2)), (s) b.DAYS);
        } else {
            long jA2 = uVar.a(j2, this);
            int iB4 = b(interfaceC1168bR2);
            int iE4 = interfaceC1168bR2.e(a.DAY_OF_YEAR);
            InterfaceC1168b interfaceC1168bL6 = interfaceC1168bR2.l((((int) (jA2 - ((long) a(h(iE4, iB4), iE4)))) * 7) + (iFloorMod - b(interfaceC1168bR2)), (s) b.DAYS);
            if (e == E.STRICT && interfaceC1168bL6.g(aVar2) != iA2) {
                throw new j$.time.c("Strict mode rejected resolved date as it is in a different year");
            }
            interfaceC1168bL2 = interfaceC1168bL6;
        }
        map.remove(this);
        map.remove(aVar2);
        map.remove(aVar);
        return interfaceC1168bL2;
    }

    @Override // j$.time.temporal.q
    public final u J() {
        return this.e;
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.f(a.DAY_OF_WEEK)) {
            return false;
        }
        b bVar = b.WEEKS;
        s sVar = this.d;
        if (sVar == bVar) {
            return true;
        }
        if (sVar == b.MONTHS) {
            return temporalAccessor.f(a.DAY_OF_MONTH);
        }
        if (sVar == b.YEARS) {
            return temporalAccessor.f(a.DAY_OF_YEAR);
        }
        if (sVar == w.h) {
            return temporalAccessor.f(a.DAY_OF_YEAR);
        }
        if (sVar == b.FOREVER) {
            return temporalAccessor.f(a.YEAR);
        }
        return false;
    }

    @Override // j$.time.temporal.q
    public final u B(TemporalAccessor temporalAccessor) {
        b bVar = b.WEEKS;
        s sVar = this.d;
        if (sVar == bVar) {
            return this.e;
        }
        if (sVar == b.MONTHS) {
            return f(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (sVar == b.YEARS) {
            return f(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (sVar == w.h) {
            return g(temporalAccessor);
        }
        if (sVar == b.FOREVER) {
            return a.YEAR.b;
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + sVar + ", this: " + this);
    }

    public final u f(TemporalAccessor temporalAccessor, a aVar) {
        int iH = h(temporalAccessor.e(aVar), b(temporalAccessor));
        u uVarK = temporalAccessor.k(aVar);
        return u.f(a(iH, (int) uVarK.a), a(iH, (int) uVarK.d));
    }

    public final u g(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.f(aVar)) {
            return h;
        }
        int iB = b(temporalAccessor);
        int iE = temporalAccessor.e(aVar);
        int iH = h(iE, iB);
        int iA = a(iH, iE);
        if (iA != 0) {
            int i2 = (int) temporalAccessor.k(aVar).d;
            int iA2 = a(iH, this.b.b + i2);
            if (iA >= iA2) {
                return g(j$.time.chrono.m.r(temporalAccessor).H(temporalAccessor).l((i2 - iE) + 8, (s) b.DAYS));
            }
            return u.f(1L, iA2 - 1);
        }
        return g(j$.time.chrono.m.r(temporalAccessor).H(temporalAccessor).a(iE + 7, (s) b.DAYS));
    }

    public final String toString() {
        return this.a + "[" + this.b.toString() + "]";
    }
}
