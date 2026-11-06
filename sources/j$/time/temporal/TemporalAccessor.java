package j$.time.temporal;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface TemporalAccessor {
    boolean f(q qVar);

    long g(q qVar);

    default u k(q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.B(this);
        }
        if (f(qVar)) {
            return ((a) qVar).b;
        }
        throw new t(j$.time.d.a("Unsupported field: ", qVar));
    }

    default int e(q qVar) {
        u uVarK = k(qVar);
        if (!uVarK.d()) {
            throw new t("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long jG = g(qVar);
        if (uVarK.e(jG)) {
            return (int) jG;
        }
        throw new j$.time.c("Invalid value for " + qVar + " (valid values " + uVarK + "): " + jG);
    }

    default Object b(j$.time.g gVar) {
        if (gVar == r.a || gVar == r.b || gVar == r.c) {
            return null;
        }
        return gVar.j(this);
    }
}
