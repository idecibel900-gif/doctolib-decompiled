package j$.time.chrono;

import java.io.Serializable;

/* JADX INFO: renamed from: j$.time.chrono.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1170d implements InterfaceC1168b, j$.time.temporal.m, j$.time.temporal.n, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public abstract InterfaceC1168b B(long j);

    public abstract InterfaceC1168b G(long j);

    public abstract InterfaceC1168b J(long j);

    @Override // j$.time.chrono.InterfaceC1168b, j$.time.temporal.m
    public /* bridge */ /* synthetic */ j$.time.temporal.m a(long j, j$.time.temporal.s sVar) {
        return a(j, sVar);
    }

    public static InterfaceC1168b s(m mVar, j$.time.temporal.m mVar2) {
        InterfaceC1168b interfaceC1168b = (InterfaceC1168b) mVar2;
        if (mVar.equals(interfaceC1168b.d())) {
            return interfaceC1168b;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + mVar.q() + ", actual: " + interfaceC1168b.d().q());
    }

    @Override // j$.time.temporal.m
    public InterfaceC1168b l(long j, j$.time.temporal.s sVar) {
        boolean z = sVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return s(d(), sVar.s(this, j));
            }
            throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
        switch (AbstractC1169c.a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return B(j);
            case 2:
                return B(Math.multiplyExact(j, 7));
            case 3:
                return G(j);
            case 4:
                return J(j);
            case 5:
                return J(Math.multiplyExact(j, 10));
            case 6:
                return J(Math.multiplyExact(j, 100));
            case 7:
                return J(Math.multiplyExact(j, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return i(Math.addExact(g(aVar), j), (j$.time.temporal.q) aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC1168b) && compareTo((InterfaceC1168b) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public int hashCode() {
        long jL = L();
        return ((int) (jL ^ (jL >>> 32))) ^ d().hashCode();
    }

    @Override // j$.time.temporal.m
    public InterfaceC1168b m(j$.time.temporal.n nVar) {
        return s(d(), nVar.c(this));
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final String toString() {
        long jG = g(j$.time.temporal.a.YEAR_OF_ERA);
        long jG2 = g(j$.time.temporal.a.MONTH_OF_YEAR);
        long jG3 = g(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(d().toString());
        sb.append(" ");
        sb.append(O());
        sb.append(" ");
        sb.append(jG);
        sb.append(jG2 < 10 ? "-0" : "-");
        sb.append(jG2);
        sb.append(jG3 < 10 ? "-0" : "-");
        sb.append(jG3);
        return sb.toString();
    }

    @Override // j$.time.temporal.m
    public InterfaceC1168b i(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(j$.time.d.a("Unsupported field: ", qVar));
        }
        return s(d(), qVar.X(this, j));
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public InterfaceC1168b S(j$.time.temporal.p pVar) {
        return s(d(), pVar.s(this));
    }
}
