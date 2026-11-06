package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends AbstractC1167a implements Serializable {
    public static final t c = new t();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.m
    public final n C(int i) {
        if (i == 0) {
            return u.BCE;
        }
        if (i == 1) {
            return u.CE;
        }
        throw new j$.time.c("Invalid era: " + i);
    }

    @Override // j$.time.chrono.m
    public final String q() {
        return "ISO";
    }

    @Override // j$.time.chrono.m
    public final String u() {
        return "iso8601";
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1168b N() {
        return LocalDate.G(LocalDate.d0(new j$.time.a(ZoneId.systemDefault())));
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1168b R(int i, int i2, int i3) {
        return LocalDate.e0(i, i2, i3);
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1168b v(int i, int i2) {
        return LocalDate.g0(i, i2);
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1168b p(long j) {
        return LocalDate.f0(j);
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1168b H(TemporalAccessor temporalAccessor) {
        return LocalDate.G(temporalAccessor);
    }

    private t() {
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1171e I(LocalDateTime localDateTime) {
        return LocalDateTime.B(localDateTime);
    }

    @Override // j$.time.chrono.m
    public final InterfaceC1176j U(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    @Override // j$.time.chrono.m
    public final boolean Y(long j) {
        if ((3 & j) == 0) {
            return j % 100 != 0 || j % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.m
    public final int D(n nVar, int i) {
        if (nVar instanceof u) {
            return nVar == u.CE ? i : 1 - i;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.m
    public final List A() {
        return j$.time.b.c(u.values());
    }

    @Override // j$.time.chrono.AbstractC1167a, j$.time.chrono.m
    public final InterfaceC1168b T(Map map, j$.time.format.E e) {
        return (LocalDate) super.T(map, e);
    }

    @Override // j$.time.chrono.AbstractC1167a
    public final void J(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e != j$.time.format.E.LENIENT) {
                aVar.a0(l.longValue());
            }
            long j = 12;
            AbstractC1167a.s(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l.longValue(), j)) + 1);
            AbstractC1167a.s(map, j$.time.temporal.a.YEAR, Math.floorDiv(l.longValue(), j));
        }
    }

    @Override // j$.time.chrono.AbstractC1167a
    public final InterfaceC1168b X(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l = (Long) map.remove(aVar);
        if (l != null) {
            if (e != j$.time.format.E.LENIENT) {
                aVar.a0(l.longValue());
            }
            Long l2 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l2 != null) {
                if (l2.longValue() == 1) {
                    AbstractC1167a.s(map, j$.time.temporal.a.YEAR, l.longValue());
                    return null;
                }
                if (l2.longValue() == 0) {
                    AbstractC1167a.s(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l.longValue()));
                    return null;
                }
                throw new j$.time.c("Invalid value for era: " + l2);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l3 = (Long) map.get(aVar2);
            if (e != j$.time.format.E.STRICT) {
                AbstractC1167a.s(map, aVar2, (l3 == null || l3.longValue() > 0) ? l.longValue() : Math.subtractExact(1L, l.longValue()));
                return null;
            }
            if (l3 != null) {
                long jLongValue = l3.longValue();
                long jLongValue2 = l.longValue();
                if (jLongValue <= 0) {
                    jLongValue2 = Math.subtractExact(1L, jLongValue2);
                }
                AbstractC1167a.s(map, aVar2, jLongValue2);
                return null;
            }
            map.put(aVar, l);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.a0(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.AbstractC1167a
    public final InterfaceC1168b Q(Map map, j$.time.format.E e) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = aVar.b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (e == j$.time.format.E.LENIENT) {
            return LocalDate.e0(iA, 1, 1).j0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).i0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = aVar2.b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = aVar3.b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (e == j$.time.format.E.SMART) {
            if (iA2 == 4 || iA2 == 6 || iA2 == 9 || iA2 == 11) {
                iA3 = Math.min(iA3, 30);
            } else if (iA2 == 2) {
                j$.time.m mVar = j$.time.m.FEBRUARY;
                long j = iA;
                int i = j$.time.u.b;
                if ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) {
                    z = false;
                }
                iA3 = Math.min(iA3, mVar.B(z));
            }
        }
        return LocalDate.e0(iA, iA2, iA3);
    }

    @Override // j$.time.chrono.m
    public final j$.time.temporal.u z(j$.time.temporal.a aVar) {
        return aVar.b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new F((byte) 1, this);
    }
}
