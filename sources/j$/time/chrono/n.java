package j$.time.chrono;

import j$.time.temporal.TemporalAccessor;

/* JADX INFO: loaded from: classes2.dex */
public interface n extends TemporalAccessor, j$.time.temporal.n {
    int getValue();

    @Override // j$.time.temporal.TemporalAccessor
    default boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return qVar == j$.time.temporal.a.ERA;
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        return super.e(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return qVar.Q(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object b(j$.time.g gVar) {
        if (gVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.ERAS;
        }
        return super.b(gVar);
    }

    @Override // j$.time.temporal.n
    default j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.i(getValue(), j$.time.temporal.a.ERA);
    }
}
