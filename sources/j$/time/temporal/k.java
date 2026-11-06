package j$.time.temporal;

import j$.time.format.D;
import j$.time.format.E;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;
    public final transient String a;
    public final transient u b;
    public final transient long c;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j) {
        this.a = str;
        this.b = u.f((-365243219162L) + j, 365241780471L + j);
        this.c = j;
    }

    @Override // j$.time.temporal.q
    public final u J() {
        return this.b;
    }

    @Override // j$.time.temporal.q
    public final m X(m mVar, long j) {
        if (!this.b.e(j)) {
            throw new j$.time.c("Invalid value: " + this.a + " " + j);
        }
        return mVar.i(Math.subtractExact(j, this.c), a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final u B(TemporalAccessor temporalAccessor) {
        if (temporalAccessor.f(a.EPOCH_DAY)) {
            return this.b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    @Override // j$.time.temporal.q
    public final boolean s(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(a.EPOCH_DAY);
    }

    @Override // j$.time.temporal.q
    public final long Q(TemporalAccessor temporalAccessor) {
        return temporalAccessor.g(a.EPOCH_DAY) + this.c;
    }

    @Override // j$.time.temporal.q
    public final TemporalAccessor G(Map map, D d2, E e) {
        long jLongValue = ((Long) map.remove(this)).longValue();
        j$.time.chrono.m mVarR = j$.time.chrono.m.r(d2);
        E e2 = E.LENIENT;
        long j = this.c;
        if (e == e2) {
            return mVarR.p(Math.subtractExact(jLongValue, j));
        }
        this.b.b(jLongValue, this);
        return mVarR.p(jLongValue - j);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.a;
    }
}
