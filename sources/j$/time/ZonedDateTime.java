package j$.time;

import j$.time.chrono.InterfaceC1171e;
import j$.time.chrono.InterfaceC1176j;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, InterfaceC1176j, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;
    public final LocalDateTime a;
    public final ZoneOffset b;
    public final ZoneId c;

    public static ZonedDateTime B(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f fVarS = zoneId.s();
        List listF = fVarS.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
                Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
            }
        } else {
            Object objE = fVarS.e(localDateTime);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            localDateTime = localDateTime.a0(Duration.B(bVar.d.b - bVar.c.b, 0).a);
            zoneOffset = bVar.d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime s(long j, int i, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.s().d(Instant.ofEpochSecond(j, i));
        return new ZonedDateTime(LocalDateTime.Q(j, i, zoneOffsetD), zoneId, zoneOffsetD);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u k(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) qVar).b;
            }
            return this.a.k(qVar);
        }
        return qVar.B(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i = y.a[((j$.time.temporal.a) qVar).ordinal()];
            if (i == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i == 2) {
                return this.b.b;
            }
            return this.a.e(qVar);
        }
        return super.e(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i = y.a[((j$.time.temporal.a) qVar).ordinal()];
            if (i == 1) {
                return Z();
            }
            if (i == 2) {
                return this.b.b;
            }
            return this.a.g(qVar);
        }
        return qVar.Q(this);
    }

    @Override // j$.time.chrono.InterfaceC1176j
    public final ZoneOffset o() {
        return this.b;
    }

    @Override // j$.time.chrono.InterfaceC1176j
    public final ZoneId K() {
        return this.c;
    }

    @Override // j$.time.chrono.InterfaceC1176j
    public final InterfaceC1176j E(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.c.equals(zoneId) ? this : B(this.a, zoneId, this.b);
    }

    @Override // j$.time.chrono.InterfaceC1176j
    public final InterfaceC1171e x() {
        return this.a;
    }

    @Override // j$.time.chrono.InterfaceC1176j
    /* JADX INFO: renamed from: toLocalDate, reason: merged with bridge method [inline-methods] */
    public LocalDate n() {
        return this.a.a;
    }

    @Override // j$.time.chrono.InterfaceC1176j
    public final k h() {
        return this.a.b;
    }

    @Override // j$.time.chrono.InterfaceC1176j
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(LocalDate localDate) {
        return B(LocalDateTime.J(localDate, this.a.b), this.c, this.b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m i(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i = y.a[aVar.ordinal()];
            if (i == 1) {
                return s(j, this.a.b.d, this.c);
            }
            if (i != 2) {
                return B(this.a.i(j, qVar), this.c, this.b);
            }
            ZoneOffset zoneOffsetB0 = ZoneOffset.b0(aVar.b.a(j, aVar));
            return (zoneOffsetB0.equals(this.b) || !this.c.s().f(this.a).contains(zoneOffsetB0)) ? this : new ZonedDateTime(this.a, this.c, zoneOffsetB0);
        }
        return (ZonedDateTime) qVar.X(this, j);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime l(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
            if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
                return B(this.a.l(j, sVar), this.c, this.b);
            }
            LocalDateTime localDateTimeX = this.a.l(j, sVar);
            ZoneOffset zoneOffset = this.b;
            ZoneId zoneId = this.c;
            Objects.requireNonNull(localDateTimeX, "localDateTime");
            Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.s().f(localDateTimeX).contains(zoneOffset)) {
                return new ZonedDateTime(localDateTimeX, zoneId, zoneOffset);
            }
            return s(localDateTimeX.w(zoneOffset), localDateTimeX.b.d, zoneId);
        }
        return (ZonedDateTime) sVar.s(this, j);
    }

    @Override // j$.time.temporal.m
    public final InterfaceC1176j a(long j, j$.time.temporal.s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(g gVar) {
        if (gVar == j$.time.temporal.r.f) {
            return n();
        }
        return super.b(gVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.a.equals(zonedDateTime.a) && this.b.equals(zonedDateTime.b) && this.c.equals(zonedDateTime.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.b) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.a.toString() + this.b.c;
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
