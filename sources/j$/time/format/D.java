package j$.time.format;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC1168b;
import j$.time.chrono.InterfaceC1176j;
import j$.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class D implements TemporalAccessor {
    public ZoneId b;
    public j$.time.chrono.m c;
    public boolean d;
    public E e;
    public InterfaceC1168b f;
    public j$.time.k g;
    public final Map a = new HashMap();
    public j$.time.r h = j$.time.r.d;

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        if (((HashMap) this.a).containsKey(qVar)) {
            return true;
        }
        InterfaceC1168b interfaceC1168b = this.f;
        if (interfaceC1168b != null && interfaceC1168b.f(qVar)) {
            return true;
        }
        j$.time.k kVar = this.g;
        if (kVar == null || !kVar.f(qVar)) {
            return (qVar == null || (qVar instanceof j$.time.temporal.a) || !qVar.s(this)) ? false : true;
        }
        return true;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        Objects.requireNonNull(qVar, "field");
        Long l = (Long) ((HashMap) this.a).get(qVar);
        if (l != null) {
            return l.longValue();
        }
        InterfaceC1168b interfaceC1168b = this.f;
        if (interfaceC1168b != null && interfaceC1168b.f(qVar)) {
            return this.f.g(qVar);
        }
        j$.time.k kVar = this.g;
        if (kVar != null && kVar.f(qVar)) {
            return this.g.g(qVar);
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.Q(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.g gVar) {
        if (gVar == j$.time.temporal.r.a) {
            return this.b;
        }
        if (gVar == j$.time.temporal.r.b) {
            return this.c;
        }
        if (gVar == j$.time.temporal.r.f) {
            InterfaceC1168b interfaceC1168b = this.f;
            if (interfaceC1168b != null) {
                return LocalDate.G(interfaceC1168b);
            }
            return null;
        }
        if (gVar == j$.time.temporal.r.g) {
            return this.g;
        }
        if (gVar == j$.time.temporal.r.d) {
            Long l = (Long) ((HashMap) this.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                return ZoneOffset.b0(l.intValue());
            }
            ZoneId zoneId = this.b;
            return zoneId instanceof ZoneOffset ? zoneId : gVar.j(this);
        }
        if (gVar == j$.time.temporal.r.e) {
            return gVar.j(this);
        }
        if (gVar == j$.time.temporal.r.c) {
            return null;
        }
        return gVar.j(this);
    }

    public final void A(j$.time.temporal.q qVar, j$.time.temporal.a aVar, Long l) {
        Long l2 = (Long) ((HashMap) this.a).put(aVar, l);
        if (l2 == null || l2.longValue() == l.longValue()) {
            return;
        }
        throw new j$.time.c("Conflict found: " + aVar + " " + l2 + " differs from " + aVar + " " + l + " while resolving  " + qVar);
    }

    public final void q() {
        if (((HashMap) this.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.b;
            if (zoneId != null) {
                r(zoneId);
                return;
            }
            Long l = (Long) ((HashMap) this.a).get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l != null) {
                r(ZoneOffset.b0(l.intValue()));
            }
        }
    }

    public final void r(ZoneId zoneId) {
        Map map = this.a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        InterfaceC1176j interfaceC1176jU = this.c.U(Instant.s(((Long) ((HashMap) map).remove(aVar)).longValue(), 0), zoneId);
        z(interfaceC1176jU.n());
        A(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(interfaceC1176jU.h().h0()));
    }

    public final void z(InterfaceC1168b interfaceC1168b) {
        InterfaceC1168b interfaceC1168b2 = this.f;
        if (interfaceC1168b2 != null) {
            if (interfaceC1168b == null || interfaceC1168b2.equals(interfaceC1168b)) {
                return;
            }
            throw new j$.time.c("Conflict found: Fields resolved to two different dates: " + this.f + " " + interfaceC1168b);
        }
        if (interfaceC1168b != null) {
            if (!this.c.equals(interfaceC1168b.d())) {
                throw new j$.time.c("ChronoLocalDate must use the effective parsed chronology: " + this.c);
            }
            this.f = interfaceC1168b;
        }
    }

    public final void u() {
        Map map = this.a;
        j$.time.temporal.a aVar = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (((HashMap) map).containsKey(aVar)) {
            long jLongValue = ((Long) ((HashMap) this.a).remove(aVar)).longValue();
            E e = this.e;
            if (e == E.STRICT || (e == E.SMART && jLongValue != 0)) {
                aVar.a0(jLongValue);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            A(aVar, aVar2, Long.valueOf(jLongValue));
        }
        Map map2 = this.a;
        j$.time.temporal.a aVar3 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (((HashMap) map2).containsKey(aVar3)) {
            long jLongValue2 = ((Long) ((HashMap) this.a).remove(aVar3)).longValue();
            E e2 = this.e;
            if (e2 == E.STRICT || (e2 == E.SMART && jLongValue2 != 0)) {
                aVar3.a0(jLongValue2);
            }
            A(aVar3, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(jLongValue2 != 12 ? jLongValue2 : 0L));
        }
        Map map3 = this.a;
        j$.time.temporal.a aVar4 = j$.time.temporal.a.AMPM_OF_DAY;
        if (((HashMap) map3).containsKey(aVar4)) {
            Map map4 = this.a;
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (((HashMap) map4).containsKey(aVar5)) {
                long jLongValue3 = ((Long) ((HashMap) this.a).remove(aVar4)).longValue();
                long jLongValue4 = ((Long) ((HashMap) this.a).remove(aVar5)).longValue();
                if (this.e == E.LENIENT) {
                    A(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(Math.addExact(Math.multiplyExact(jLongValue3, 12), jLongValue4)));
                } else {
                    aVar4.a0(jLongValue3);
                    aVar5.a0(jLongValue3);
                    A(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf((jLongValue3 * 12) + jLongValue4));
                }
            }
        }
        Map map5 = this.a;
        j$.time.temporal.a aVar6 = j$.time.temporal.a.NANO_OF_DAY;
        if (((HashMap) map5).containsKey(aVar6)) {
            long jLongValue5 = ((Long) ((HashMap) this.a).remove(aVar6)).longValue();
            if (this.e != E.LENIENT) {
                aVar6.a0(jLongValue5);
            }
            A(aVar6, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue5 / 3600000000000L));
            A(aVar6, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue5 / 60000000000L) % 60));
            A(aVar6, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((jLongValue5 / 1000000000) % 60));
            A(aVar6, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue5 % 1000000000));
        }
        Map map6 = this.a;
        j$.time.temporal.a aVar7 = j$.time.temporal.a.MICRO_OF_DAY;
        if (((HashMap) map6).containsKey(aVar7)) {
            long jLongValue6 = ((Long) ((HashMap) this.a).remove(aVar7)).longValue();
            if (this.e != E.LENIENT) {
                aVar7.a0(jLongValue6);
            }
            A(aVar7, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue6 / 1000000));
            A(aVar7, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 % 1000000));
        }
        Map map7 = this.a;
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MILLI_OF_DAY;
        if (((HashMap) map7).containsKey(aVar8)) {
            long jLongValue7 = ((Long) ((HashMap) this.a).remove(aVar8)).longValue();
            if (this.e != E.LENIENT) {
                aVar8.a0(jLongValue7);
            }
            A(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue7 / 1000));
            A(aVar8, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 % 1000));
        }
        Map map8 = this.a;
        j$.time.temporal.a aVar9 = j$.time.temporal.a.SECOND_OF_DAY;
        if (((HashMap) map8).containsKey(aVar9)) {
            long jLongValue8 = ((Long) ((HashMap) this.a).remove(aVar9)).longValue();
            if (this.e != E.LENIENT) {
                aVar9.a0(jLongValue8);
            }
            A(aVar9, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue8 / 3600));
            A(aVar9, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue8 / 60) % 60));
            A(aVar9, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(jLongValue8 % 60));
        }
        Map map9 = this.a;
        j$.time.temporal.a aVar10 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (((HashMap) map9).containsKey(aVar10)) {
            long jLongValue9 = ((Long) ((HashMap) this.a).remove(aVar10)).longValue();
            if (this.e != E.LENIENT) {
                aVar10.a0(jLongValue9);
            }
            A(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue9 / 60));
            A(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(jLongValue9 % 60));
        }
        Map map10 = this.a;
        j$.time.temporal.a aVar11 = j$.time.temporal.a.NANO_OF_SECOND;
        if (((HashMap) map10).containsKey(aVar11)) {
            long jLongValue10 = ((Long) ((HashMap) this.a).get(aVar11)).longValue();
            E e3 = this.e;
            E e4 = E.LENIENT;
            if (e3 != e4) {
                aVar11.a0(jLongValue10);
            }
            Map map11 = this.a;
            j$.time.temporal.a aVar12 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (((HashMap) map11).containsKey(aVar12)) {
                long jLongValue11 = ((Long) ((HashMap) this.a).remove(aVar12)).longValue();
                if (this.e != e4) {
                    aVar12.a0(jLongValue11);
                }
                jLongValue10 = (jLongValue10 % 1000) + (jLongValue11 * 1000);
                A(aVar12, aVar11, Long.valueOf(jLongValue10));
            }
            Map map12 = this.a;
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (((HashMap) map12).containsKey(aVar13)) {
                long jLongValue12 = ((Long) ((HashMap) this.a).remove(aVar13)).longValue();
                if (this.e != e4) {
                    aVar13.a0(jLongValue12);
                }
                A(aVar13, aVar11, Long.valueOf((jLongValue10 % 1000000) + (jLongValue12 * 1000000)));
            }
        }
        Map map13 = this.a;
        j$.time.temporal.a aVar14 = j$.time.temporal.a.HOUR_OF_DAY;
        if (((HashMap) map13).containsKey(aVar14)) {
            Map map14 = this.a;
            j$.time.temporal.a aVar15 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (((HashMap) map14).containsKey(aVar15)) {
                Map map15 = this.a;
                j$.time.temporal.a aVar16 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (((HashMap) map15).containsKey(aVar16) && ((HashMap) this.a).containsKey(aVar11)) {
                    s(((Long) ((HashMap) this.a).remove(aVar14)).longValue(), ((Long) ((HashMap) this.a).remove(aVar15)).longValue(), ((Long) ((HashMap) this.a).remove(aVar16)).longValue(), ((Long) ((HashMap) this.a).remove(aVar11)).longValue());
                }
            }
        }
    }

    public final void s(long j, long j2, long j3, long j4) {
        if (this.e == E.LENIENT) {
            long jAddExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j, 3600000000000L), Math.multiplyExact(j2, 60000000000L)), Math.multiplyExact(j3, 1000000000L)), j4);
            v(j$.time.k.X(Math.floorMod(jAddExact, 86400000000000L)), j$.time.r.a(0, 0, (int) Math.floorDiv(jAddExact, 86400000000000L)));
            return;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.MINUTE_OF_HOUR;
        int iA = aVar.b.a(j2, aVar);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
        int iA2 = aVar2.b.a(j4, aVar2);
        if (this.e == E.SMART && j == 24 && iA == 0 && j3 == 0 && iA2 == 0) {
            v(j$.time.k.g, j$.time.r.a(0, 0, 1));
            return;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.HOUR_OF_DAY;
        int iA3 = aVar3.b.a(j, aVar3);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.SECOND_OF_MINUTE;
        v(j$.time.k.Q(iA3, iA, aVar4.b.a(j3, aVar4), iA2), j$.time.r.d);
    }

    public final void v(j$.time.k kVar, j$.time.r rVar) {
        j$.time.k kVar2 = this.g;
        if (kVar2 != null) {
            if (!kVar2.equals(kVar)) {
                throw new j$.time.c("Conflict found: Fields resolved to different times: " + this.g + " " + kVar);
            }
            j$.time.r rVar2 = this.h;
            rVar2.getClass();
            j$.time.r rVar3 = j$.time.r.d;
            if (rVar2 != rVar3 && rVar != rVar3 && !this.h.equals(rVar)) {
                throw new j$.time.c("Conflict found: Fields resolved to different excess periods: " + this.h + " " + rVar);
            }
            this.h = rVar;
            return;
        }
        this.g = kVar;
        this.h = rVar;
    }

    public final void p(TemporalAccessor temporalAccessor) {
        Iterator it = ((HashMap) this.a).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.q qVar = (j$.time.temporal.q) entry.getKey();
            if (temporalAccessor.f(qVar)) {
                try {
                    long jG = temporalAccessor.g(qVar);
                    long jLongValue = ((Long) entry.getValue()).longValue();
                    if (jG != jLongValue) {
                        throw new j$.time.c("Conflict found: Field " + qVar + " " + jG + " differs from " + qVar + " " + jLongValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.a);
        sb.append(',');
        sb.append(this.c);
        if (this.b != null) {
            sb.append(',');
            sb.append(this.b);
        }
        if (this.f != null || this.g != null) {
            sb.append(" resolved to ");
            InterfaceC1168b interfaceC1168b = this.f;
            if (interfaceC1168b != null) {
                sb.append(interfaceC1168b);
                if (this.g != null) {
                    sb.append('T');
                    sb.append(this.g);
                }
            } else {
                sb.append(this.g);
            }
        }
        return sb.toString();
    }
}
