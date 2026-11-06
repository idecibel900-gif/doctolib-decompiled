package j$.time.chrono;

/* JADX INFO: renamed from: j$.time.chrono.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1168b extends j$.time.temporal.m, j$.time.temporal.n, Comparable {
    InterfaceC1168b S(j$.time.temporal.p pVar);

    m d();

    boolean equals(Object obj);

    int hashCode();

    @Override // j$.time.temporal.m
    InterfaceC1168b i(long j, j$.time.temporal.q qVar);

    @Override // j$.time.temporal.m
    InterfaceC1168b l(long j, j$.time.temporal.s sVar);

    InterfaceC1168b m(j$.time.temporal.n nVar);

    String toString();

    default InterfaceC1171e M(j$.time.k kVar) {
        return new C1173g(this, kVar);
    }

    default n O() {
        return d().C(e(j$.time.temporal.a.ERA));
    }

    default boolean y() {
        return d().Y(g(j$.time.temporal.a.YEAR));
    }

    default int V() {
        return y() ? 366 : 365;
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.m
    default InterfaceC1168b a(long j, j$.time.temporal.s sVar) {
        return AbstractC1170d.s(d(), super.a(j, sVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.g gVar) {
        if (gVar == j$.time.temporal.r.a || gVar == j$.time.temporal.r.e || gVar == j$.time.temporal.r.d || gVar == j$.time.temporal.r.g) {
            return null;
        }
        if (gVar == j$.time.temporal.r.b) {
            return d();
        }
        if (gVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.DAYS;
        }
        return gVar.j(this);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.i(L(), j$.time.temporal.a.EPOCH_DAY);
    }

    default long L() {
        return g(j$.time.temporal.a.EPOCH_DAY);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: W */
    default int compareTo(InterfaceC1168b interfaceC1168b) {
        int iCompare = Long.compare(L(), interfaceC1168b.L());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((AbstractC1167a) d()).q().compareTo(interfaceC1168b.d().q());
    }
}
