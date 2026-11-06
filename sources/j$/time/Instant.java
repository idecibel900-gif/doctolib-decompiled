package j$.time;

import io.didomi.ssl.config.app.SyncConfiguration;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.n, Comparable<Instant>, Serializable {
    public static final Instant c = new Instant(0, 0);
    private static final long serialVersionUID = -665713676816604388L;
    public final long a;
    public final int b;

    public static Instant now() {
        a.b.getClass();
        return ofEpochMilli(System.currentTimeMillis());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int iCompare = Long.compare(this.a, instant2.a);
        return iCompare != 0 ? iCompare : this.b - instant2.b;
    }

    static {
        ofEpochSecond(-31557014167219200L, 0L);
        ofEpochSecond(31556889864403199L, 999999999L);
    }

    public static Instant ofEpochSecond(long j, long j2) {
        return s(Math.addExact(j, Math.floorDiv(j2, 1000000000L)), (int) Math.floorMod(j2, 1000000000L));
    }

    public static Instant ofEpochMilli(long j) {
        long j2 = 1000;
        return s(Math.floorDiv(j, j2), ((int) Math.floorMod(j, j2)) * 1000000);
    }

    public static Instant B(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return ofEpochSecond(temporalAccessor.g(j$.time.temporal.a.INSTANT_SECONDS), temporalAccessor.e(j$.time.temporal.a.NANO_OF_SECOND));
        } catch (c e) {
            throw new c("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static Instant s(long j, int i) {
        if ((((long) i) | j) == 0) {
            return c;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new c("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j, i);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(getEpochSecond(), getNano(), zoneId);
    }

    public Instant(long j, int i) {
        this.a = j;
        this.b = i;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int e(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return super.k(qVar).a(qVar.Q(this), qVar);
        }
        int i = f.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.b / 1000;
        }
        if (i == 3) {
            return this.b / 1000000;
        }
        if (i == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.b.a(this.a, aVar);
        }
        throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        int i;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.Q(this);
        }
        int i2 = f.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else if (i2 == 2) {
            i = this.b / 1000;
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return this.a;
                }
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
            }
            i = this.b / 1000000;
        }
        return i;
    }

    public long getEpochSecond() {
        return this.a;
    }

    public int getNano() {
        return this.b;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(LocalDate localDate) {
        return (Instant) localDate.c(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m i(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.X(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.a0(j);
        int i = f.a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i2 = ((int) j) * 1000;
                if (i2 != this.b) {
                    return s(this.a, i2);
                }
            } else if (i == 3) {
                int i3 = ((int) j) * 1000000;
                if (i3 != this.b) {
                    return s(this.a, i3);
                }
            } else {
                if (i != 4) {
                    throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
                }
                if (j != this.a) {
                    return s(j, this.b);
                }
            }
        } else if (j != this.b) {
            return s(this.a, (int) j);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final Instant l(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.s(this, j);
        }
        switch (f.b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return G(0L, j);
            case 2:
                return G(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return G(j / 1000, (j % 1000) * 1000000);
            case 4:
                return G(j, 0L);
            case 5:
                return G(Math.multiplyExact(j, 60), 0L);
            case 6:
                return G(Math.multiplyExact(j, 3600), 0L);
            case 7:
                return G(Math.multiplyExact(j, 43200), 0L);
            case 8:
                return G(Math.multiplyExact(j, SyncConfiguration.DEFAULT_FREQUENCY), 0L);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    public final Instant G(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return ofEpochSecond(Math.addExact(Math.addExact(this.a, j), j2 / 1000000000), ((long) this.b) + (j2 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(g gVar) {
        if (gVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.NANOS;
        }
        if (gVar == j$.time.temporal.r.b || gVar == j$.time.temporal.r.a || gVar == j$.time.temporal.r.e || gVar == j$.time.temporal.r.d || gVar == j$.time.temporal.r.f || gVar == j$.time.temporal.r.g) {
            return null;
        }
        return gVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.i(this.a, j$.time.temporal.a.INSTANT_SECONDS).i(this.b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j = this.a;
        return (j >= 0 || this.b <= 0) ? Math.addExact(Math.multiplyExact(j, 1000), this.b / 1000000) : Math.addExact(Math.multiplyExact(j + 1, 1000), (this.b / 1000000) - 1000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.a == instant.a && this.b == instant.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return DateTimeFormatter.ISO_INSTANT.format(this);
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
